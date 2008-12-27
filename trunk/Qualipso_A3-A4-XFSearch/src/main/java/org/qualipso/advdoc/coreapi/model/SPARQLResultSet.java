package org.qualipso.advdoc.coreapi.model;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class SPARQLResultSet {

	/**
	 * List of String
	 */
	private ArrayList columns = new ArrayList();
	
	/**
	 * List of RDFNode[]
	 */
	private ArrayList rows = new ArrayList();
	
	/**
	 * SPARQL query string
	 */
	private String query;
	
	/**
	 * Remove type information flag
	 */
	private boolean removeTypeInformation = false;
	
	/**
	 * Constructor
	 * @param rs result of the SPARQL query
	 */
	public SPARQLResultSet(ResultSet rs,String query,boolean removeTypeInformation) {
		
		this.query = query;
		this.removeTypeInformation = removeTypeInformation;
		
		// Columns
		List vars = rs.getResultVars();
		for (int i = 0;i < vars.size();i++) {
			columns.add((String)vars.get(i));
		}
		
		// Rows
		while (rs.hasNext()) {
			QuerySolution sol = rs.nextSolution();
			RDFNode[] row = new RDFNode[columns.size()];
			for (int i = 0;i < row.length;i++) {
				row[i] = sol.get((String)columns.get(i));
			}
			rows.add(row);
		}
	}
	
	public String getQuery() {
		return this.query;
	}
	
	public ArrayList getColumns() {
		return this.columns;
	}
	
	public int getNumColumns() {
		return this.columns.size();
	}
	
	public ArrayList getRows() {
		return this.rows;
	}
	
	public int getNumRows() {
		return this.rows.size();
	}
	
	public String[] getColumnsAsArray() {
		String[] cols = new String[columns.size()];
		for (int i = 0;i < cols.length;i++) {
			cols[i] = (String)columns.get(i);
		}
		return cols;
	}
	
	public boolean isLiteral(int row,int col) {
		RDFNode node = getAsNode(row, col);
		return node.isLiteral();
	}

	public boolean isLiteral(int row,String colName) {
		RDFNode node = getAsNode(row, colName);
		return node.isLiteral();
	}

	
	public RDFNode getAsNode(int row,int col) {
		RDFNode[] nodes = (RDFNode[])rows.get(row);
		return nodes[col];
	}

	public RDFNode getAsNode(int row,String colName) {
		int colNumber = colName2colNumber(colName);
		return getAsNode(row,colNumber);
	}

	public String getAsString(int row,int col) {
		try {
			RDFNode node = getAsNode(row,col);
			if (removeTypeInformation) {
				String str = node.toString();
				int i = str.indexOf("^^");
				if (i >= 0) {
					return str.substring(0, i);
				} else {
					return str;
				}
			} else {
				return node.toString();
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	public Integer getAsInteger(int row,int col) {
		try {
			String str = getAsString(row, col);
			return new Integer(str);
		} catch (Exception e) {
			return null;
		}
	}

	public Float getAsFloat(int row,int col) {
		try {
			String str = getAsString(row, col);
			return new Float(str);
			//return Float.parseFloat(getNumericPart(str));
		} catch (Exception e) {
			return null;
		}
	}

	public String getAsString(int row,String colName) {
		try {
			RDFNode node = getAsNode(row,colName);
			return node.toString();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Integer getAsInteger(int row,String colName) {
		try {
			String str = getAsString(row, colName);
			return new Integer(str);
			//return Integer.parseInt(getNumericPart(str));
		} catch (Exception e) {
			return null;
		}
	}

	public Float getAsFloat(int row,String colName) {
		try {
			String str = getAsString(row, colName);
			return new Float(str);
			//return Float.parseFloat(getNumericPart(str));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * To String conversion
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("--------------------------------------------------");
		sb.append(query);
		sb.append('\r');
		sb.append('\n');
		sb.append("--------------------------------------------------");
		sb.append('\r');
		sb.append('\n');
		for (int i = 0;i < columns.size();i++) {
			if (i > 0) {
				sb.append("  |  ");
			}
			sb.append(columns.get(i));
		}
		sb.append('\r');
		sb.append('\n');
		sb.append("--------------------------------------------------");
		sb.append('\r');
		sb.append('\n');
		for (int i = 0;i < rows.size();i++) {
			for (int j = 0;j < columns.size();j++) {
				if (j > 0) {
					sb.append("  |  ");
				}
				RDFNode node = ((RDFNode[])rows.get(i))[j];
				if (node != null) {
					sb.append(node.toString());
				} else {
					sb.append(" ");
				}
			}
			sb.append('\r');
			sb.append('\n');
		}
		sb.append('\r');
		sb.append('\n');
		sb.append("--------------------------------------------------");
		sb.append('\r');
		sb.append('\n');
		return sb.toString();
	}
	
	private int colName2colNumber(String colName) {
		for (int i = 0;i < columns.size();i++) {
			String cn = (String)columns.get(i);
			if (cn.equalsIgnoreCase(colName)) {
				return i;
			}
		}
		throw new IllegalArgumentException("Column name does not exist");
	}

	private String colNumber2colName(int colNumber) {
		return (String)columns.get(colNumber);
	}
	
	static String getNumericPart(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		StringBuffer sb = new StringBuffer("");
		char c = str.charAt(0);
		int i = 0;
		while (i < str.length() && (Character.isDigit(c) || c == '.' || c == '-' || c == '+')) {
			sb.append(c);
			i++;
			c = str.charAt(i);
		}
		return sb.toString();
	}

}
