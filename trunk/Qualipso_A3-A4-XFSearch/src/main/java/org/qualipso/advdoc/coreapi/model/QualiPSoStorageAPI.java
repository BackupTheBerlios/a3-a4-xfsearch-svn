package org.qualipso.advdoc.coreapi.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ibm.icu.util.StringTokenizer;

public class QualiPSoStorageAPI extends QualiPSoModel {
	
	public static class Path {
		private ArrayList path = new ArrayList();
		public Path() {
		}
		public Path(String[] path) {
			for (int i = 0;i < path.length;i++) {
				addFolder(path[i]);
			}
		}
		public Path(String path) {
			StringTokenizer st = new StringTokenizer(path,"/");
			while (st.hasMoreTokens()) {
				String folder = st.nextToken();
				addFolder(folder);
			}
		}
		public void addFolder(String folder) {
			if (folder == null) {
				return;
			}
			folder = folder.trim();
			if (folder.length() > 0) {
				path.add(folder);
			}
		}
		public String[] getPath() {
			String[] result = new String[path.size()];
			for (int i = 0;i < result.length;i++) {
				result[i] = (String)path.get(i);
			}
			return result;
		}
		public int getLength() {
			return path.size();
		}
		public String getFolder(int i) {
			return (String)path.get(i);
		}
		public String getPath(String baseDir) {
			String currentDir = baseDir;
			for (int i = 0;i < getLength();i++) {
				currentDir += '/';
				currentDir += getFolder(i);
			}
			return currentDir;			
		}
		public String toString() {
			StringBuffer b = new StringBuffer();
			for (int i = 0;i < getLength();i++) {
				b.append('/');
				b.append(getFolder(i));
			}
			return b.toString();
		}
	}

	public QualiPSoStorageAPI() throws Exception {
	}
	
	public boolean exists(Path path) {
		String baseDir = configuration.getStorageDir();
		String absoluteDir = path.getPath(baseDir);
		boolean result = new File(absoluteDir).exists();
		debug("exists(path)");
		detail("Absolute directory: "+absoluteDir);
		detail("Result            : "+result);
		return result;
	}
	
	public boolean exists(Path path, String filename) {
		String baseDir = configuration.getStorageDir();
		String complete = path.getPath(baseDir);
		complete += '/';
		complete += filename;
		boolean result = new File(complete).exists();
		debug("exists(path,filename)");
		detail("Absolute directory: "+complete);
		detail("Result            : "+result);
		return result;
	}
	
	public boolean createPath(Path path) {
		String baseDir = configuration.getStorageDir();
		String currentDir = baseDir;
		boolean result = true;
		for (int i = 0;i < path.getLength();i++) {
			currentDir += '/';
			currentDir += path.getFolder(i);
			File d = new File(currentDir);
			result = d.mkdir();
		}
		// return last folder creation
		debug("createPath()");
		detail("Directory:"+currentDir);
		detail("Result   :"+result);
		return result;
	}

	public boolean createFolder(Path path,String newFolder) {
		String baseDir = configuration.getStorageDir();
		String complete = path.getPath(baseDir);
		complete += '/';
		complete += newFolder;
		File d = new File(complete);
		boolean result = d.mkdir();
		debug("createFolder()");
		detail("Directory:"+complete);
		detail("Result   :"+result);
		return result;
	}
	
	public boolean removeFolder(Path path,String folder) {
		String baseDir = configuration.getStorageDir();
		String complete = path.getPath(baseDir);
		complete += '/';
		complete += folder;
		File d = new File(complete);
		boolean result = d.delete();
		debug("removeFolder()");
		detail("Directory:"+complete);
		detail("Result   :"+result);
		return result;
	}
	
	public boolean removeFile(Path path,String filename) {
		String baseDir = configuration.getStorageDir();
		String complete = path.getPath(baseDir);
		complete += '/';
		complete += filename;
		File d = new File(complete);
		boolean result = d.delete();
		debug("removeFile()");
		detail("File:"+complete);
		detail("Result   :"+result);
		return result;
	}

	
	public String[] getFiles(Path path,final String filter) {
		String baseDir = configuration.getStorageDir();
		String complete = path.getPath(baseDir);
		File dir = new File(complete);
		String[] files = dir.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return tdi.text.StringUtil.match(filter, name, true);
			}
		});
		debug("getFiles()");
		detail("Directory:"+complete);
		detail("Result   :"+files.length);
		return files;
	}

	public String[] getSubFolders(Path path) {
		String baseDir = configuration.getStorageDir();
		String complete = path.getPath(baseDir);
		File dir = new File(complete);
		File[] folders = dir.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});
		String[] foldersStr = new String[folders.length];
		for (int i = 0;i < foldersStr.length;i++) {
			foldersStr[i] = folders[i].getName();
		}
		debug("getSubFolders()");
		detail("Directory:"+complete);
		detail("Result   :"+foldersStr.length);
		return foldersStr;
	}

	
	public byte[] loadFile(Path path, String filename) throws IOException {
		String baseDir = configuration.getStorageDir();
		String complete = path.getPath(baseDir);
		complete += '/';
		complete += filename;
		try {
			File f = new File(complete);
			long size = f.length();
			FileInputStream fis = new FileInputStream(complete);
			byte[] data = new byte[(int)size];
			fis.read(data);
			fis.close();
			debug("loadFile()");
			detail("File:"+complete);
			detail("Result   :"+data.length);
			return data;
		} catch (IOException e) {
			debug(getClass().getName()+".loadFile() "+filename+" "+e.getMessage());
			throw e;
		}
	}
	
	public String loadTextFile(Path path,String filename) throws IOException {
		String baseDir = configuration.getStorageDir();
		String complete = path.getPath(baseDir);
		complete += '/';
		complete += filename;
		try {
			File f = new File(complete);
			long size = f.length();
			BufferedReader br = new BufferedReader(new FileReader(complete));
			char[] data = new char[(int)size];
			br.read(data);
			String str = new String(data);
			br.close();
			debug("loadTextFile()");
			detail("File:"+complete);
			detail("Result   :"+str.length());
			return str;
		} catch (IOException e) {
			debug(getClass().getName()+".loadFile() "+filename+" "+e.getMessage());
			throw e;
		}
	}
	
	public boolean storeFile(Path path,String filename,boolean overwrite,byte[] data) throws IOException {
		if (exists(path, filename) && !overwrite) {
			debug(getClass().getName()+".storeFile() Can't overwrite");
			return false;
		}
		String baseDir = configuration.getStorageDir();
		String complete = path.getPath(baseDir);
		complete += '/';
		complete += filename;
		try {
			FileOutputStream fos = new FileOutputStream(complete);
			fos.write(data);
			fos.close();
			debug("storeFile()");
			detail("File:"+complete);
			detail("Result   :"+data.length);
			return true;
		} catch (IOException e) {
			debug(getClass().getName()+".storeFile() "+filename+" "+e.getMessage());
			throw e;
		}
	}

	public boolean storeFile(Path path,String filename,boolean overwrite,String text) throws IOException {
		if (exists(path, filename) && !overwrite) {
			debug(getClass().getName()+".storeFile() Can't overwrite");
			return false;
		}
		String baseDir = configuration.getStorageDir();
		String complete = path.getPath(baseDir);
		complete += '/';
		complete += filename;
		try {
			PrintWriter pw = new PrintWriter(complete);
			pw.print(text);
			pw.close();
			debug("storeTextFile()");
			detail("File:"+complete);
			detail("Result   :"+text.length());
			return true;
		} catch (IOException e) {
			debug(getClass().getName()+".storeFile() "+filename+" "+e.getMessage());
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			QualiPSoStorageAPI model = new QualiPSoStorageAPI();

			Path path = new Path("/temp/test");

			System.out.println("----------------- exists() ------------------");
			boolean result = model.exists(path);
			System.out.println(result);
			System.out.println("----------------- exists() ------------------");
			result = model.exists(path,"test1.txt");
			System.out.println(result);
			System.out.println("----------------- createPath() ------------------");
			result = model.createPath(path);
			System.out.println(result);
			System.out.println("----------------- createFolder() ------------------");
			result = model.createFolder(path,"subdir");
			System.out.println(result);
			System.out.println("----------------- storeFile() ------------------");
			result = model.storeFile(path, "test1.txt", true, "Testing the storage API");
			System.out.println(result);
			result = model.storeFile(path, "test2.txt", true, "Testing the storage API");
			System.out.println(result);
			result = model.storeFile(path, "test3.txt", true, "Testing the storage API");
			System.out.println(result);
			System.out.println("----------------- loadFile() ------------------");
			String contents = model.loadTextFile(path, "test1.txt");
			System.out.println(contents);
			System.out.println("----------------- getFiles() ------------------");
			String[] files = model.getFiles(path, "*.txt");
			for (int i = 0;i < files.length;i++) {
				System.out.print(files[i]+" ");
			}
			System.out.println();
			System.out.println("----------------- getSubFolders() ------------------");
			String[] folders = model.getSubFolders(path);
			for (int i = 0;i < folders.length;i++) {
				System.out.print(folders[i]+" ");
			}
			System.out.println();
			System.out.println("----------------- removeFolder() ------------------");
			result = model.removeFolder(path,"subdir");
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
