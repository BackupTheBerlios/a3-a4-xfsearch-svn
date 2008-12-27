/* CVS $Id: $ */
package org.qualipso.advdoc.coreapi.ontology; 
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.ontology.*; 
/**
 * Vocabulary definitions from ontologybaetle.rdf 
 * @author Auto-generated by schemagen on 11 abr 2008 14:28 
 */
public class Baetle {
    /** <p>The ontology model that holds the vocabulary terms</p> */
    private static OntModel m_model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM, null );
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://xmlns.com/baetle/#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    public static final ObjectProperty relates_to = m_model.createObjectProperty( "http://xmlns.com/baetle/#relates_to" );
    
    /** <p>A comment on an Issue</p> */
    public static final ObjectProperty comment = m_model.createObjectProperty( "http://xmlns.com/baetle/#comment" );
    
    public static final ObjectProperty author = m_model.createObjectProperty( "http://xmlns.com/baetle/#author" );
    
    public static final ObjectProperty next = m_model.createObjectProperty( "http://xmlns.com/baetle/#next" );
    
    /** <p>A user interested in changes to this issue</p> */
    public static final ObjectProperty interested = m_model.createObjectProperty( "http://xmlns.com/baetle/#interested" );
    
    /** <p>A contact point</p> */
    public static final ObjectProperty qa_contact = m_model.createObjectProperty( "http://xmlns.com/baetle/#qa_contact" );
    
    /** <p>this issue is blocking the other</p> */
    public static final ObjectProperty blocks = m_model.createObjectProperty( "http://xmlns.com/baetle/#blocks" );
    
    /** <p>the priority value recognised by those responsible for the issue</p> */
    public static final ObjectProperty priority = m_model.createObjectProperty( "http://xmlns.com/baetle/#priority" );
    
    public static final ObjectProperty operating_system = m_model.createObjectProperty( "http://xmlns.com/baetle/#operating_system" );
    
    /** <p>the project this issue concerns</p> */
    public static final ObjectProperty project = m_model.createObjectProperty( "http://xmlns.com/baetle/#project" );
    
    /** <p>this Issue is a duplicate of the other.</p> */
    public static final ObjectProperty duplicate = m_model.createObjectProperty( "http://xmlns.com/baetle/#duplicate" );
    
    public static final ObjectProperty about = m_model.createObjectProperty( "http://xmlns.com/baetle/#about" );
    
    public static final ObjectProperty previous = m_model.createObjectProperty( "http://xmlns.com/baetle/#previous" );
    
    /** <p>the person the bug is assigned to</p> */
    public static final ObjectProperty assigned_to = m_model.createObjectProperty( "http://xmlns.com/baetle/#assigned_to" );
    
    public static final ObjectProperty platform = m_model.createObjectProperty( "http://xmlns.com/baetle/#platform" );
    
    public static final ObjectProperty resolvedWith = m_model.createObjectProperty( "http://xmlns.com/baetle/#resolvedWith" );
    
    /** <p>the reporter of the bug</p> */
    public static final ObjectProperty reporter = m_model.createObjectProperty( "http://xmlns.com/baetle/#reporter" );
    
    public static final ObjectProperty target_milestone = m_model.createObjectProperty( "http://xmlns.com/baetle/#target_milestone" );
    
    /** <p>a task that depends on this one being completed</p> */
    public static final ObjectProperty depends_on = m_model.createObjectProperty( "http://xmlns.com/baetle/#depends_on" );
    
    public static final ObjectProperty contains = m_model.createObjectProperty( "http://xmlns.com/baetle/#contains" );
    
    /** <p>this Issue causes the other one</p> */
    public static final ObjectProperty causes = m_model.createObjectProperty( "http://xmlns.com/baetle/#causes" );
    
    public static final ObjectProperty status = m_model.createObjectProperty( "http://xmlns.com/baetle/#status" );
    
    public static final ObjectProperty version = m_model.createObjectProperty( "http://xmlns.com/baetle/#version" );
    
    /** <p>date Issue was updated</p> */
    public static final DatatypeProperty updated = m_model.createDatatypeProperty( "http://xmlns.com/baetle/#updated" );
    
    /** <p>date the task is due by</p> */
    public static final DatatypeProperty due_date = m_model.createDatatypeProperty( "http://xmlns.com/baetle/#due_date" );
    
    /** <p>summary of committing</p> */
    public static final DatatypeProperty summary = m_model.createDatatypeProperty( "http://xmlns.com/baetle/#summary" );
    
    /** <p>number of votes for the issue</p> */
    public static final DatatypeProperty votes = m_model.createDatatypeProperty( "http://xmlns.com/baetle/#votes" );
    
    public static final DatatypeProperty date = m_model.createDatatypeProperty( "http://xmlns.com/baetle/#date" );
    
    public static final DatatypeProperty id = m_model.createDatatypeProperty( "http://xmlns.com/baetle/#id" );
    
    /** <p>a subtask of this issue</p> */
    public static final DatatypeProperty subtask = m_model.createDatatypeProperty( "http://xmlns.com/baetle/#subtask" );
    
    /** <p>longer description of the Issue</p> */
    public static final DatatypeProperty description = m_model.createDatatypeProperty( "http://xmlns.com/baetle/#description" );
    
    /** <p>Creation date of Issue</p> */
    public static final DatatypeProperty created = m_model.createDatatypeProperty( "http://xmlns.com/baetle/#created" );
    
    /** <p>description of the environment where the issue was noticed</p> */
    public static final DatatypeProperty environment = m_model.createDatatypeProperty( "http://xmlns.com/baetle/#environment" );
    
    public static final DatatypeProperty name = m_model.createDatatypeProperty( "http://xmlns.com/baetle/#name" );
    
    public static final OntClass Unconfirmed = m_model.createClass( "http://xmlns.com/baetle/#Unconfirmed" );
    
    public static final OntClass Enhancement = m_model.createClass( "http://xmlns.com/baetle/#Enhancement" );
    
    public static final OntClass NotReproducible = m_model.createClass( "http://xmlns.com/baetle/#NotReproducible" );
    
    public static final OntClass Major = m_model.createClass( "http://xmlns.com/baetle/#Major" );
    
    public static final OntClass Closed = m_model.createClass( "http://xmlns.com/baetle/#Closed" );
    
    public static final OntClass Blocker = m_model.createClass( "http://xmlns.com/baetle/#Blocker" );
    
    public static final OntClass Trivial = m_model.createClass( "http://xmlns.com/baetle/#Trivial" );
    
    public static final OntClass Resolved = m_model.createClass( "http://xmlns.com/baetle/#Resolved" );
    
    public static final OntClass Critical = m_model.createClass( "http://xmlns.com/baetle/#Critical" );
    
    public static final OntClass Version = m_model.createClass( "http://xmlns.com/baetle/#Version" );
    
    public static final OntClass SoftwarePackage = m_model.createClass( "http://xmlns.com/baetle/#SoftwarePackage" );
    
    /** <p>An issue in a bug database.</p> */
    public static final OntClass Issue = m_model.createClass( "http://xmlns.com/baetle/#Issue" );
    
    /** <p>Priority values.</p> */
    public static final OntClass Priority = m_model.createClass( "http://xmlns.com/baetle/#Priority" );
    
    public static final OntClass DocumentVersion = m_model.createClass( "http://xmlns.com/baetle/#DocumentVersion" );
    
    public static final OntClass Remind = m_model.createClass( "http://xmlns.com/baetle/#Remind" );
    
    public static final OntClass Duplicate = m_model.createClass( "http://xmlns.com/baetle/#Duplicate" );
    
    public static final OntClass New = m_model.createClass( "http://xmlns.com/baetle/#New" );
    
    public static final OntClass Defect = m_model.createClass( "http://xmlns.com/baetle/#Defect" );
    
    public static final OntClass WontFix = m_model.createClass( "http://xmlns.com/baetle/#WontFix" );
    
    public static final OntClass Fixed = m_model.createClass( "http://xmlns.com/baetle/#Fixed" );
    
    public static final OntClass Incomplete = m_model.createClass( "http://xmlns.com/baetle/#Incomplete" );
    
    public static final OntClass Bug = m_model.createClass( "http://xmlns.com/baetle/#Bug" );
    
    public static final OntClass Verified = m_model.createClass( "http://xmlns.com/baetle/#Verified" );
    
    public static final OntClass Later = m_model.createClass( "http://xmlns.com/baetle/#Later" );
    
    public static final OntClass Open = m_model.createClass( "http://xmlns.com/baetle/#Open" );
    
    public static final OntClass Committing = m_model.createClass( "http://xmlns.com/baetle/#Committing" );
    
    public static final OntClass WorksForMe = m_model.createClass( "http://xmlns.com/baetle/#WorksForMe" );
    
    public static final OntClass Minor = m_model.createClass( "http://xmlns.com/baetle/#Minor" );
    
    public static final OntClass Reopened = m_model.createClass( "http://xmlns.com/baetle/#Reopened" );
    
    public static final OntClass Started = m_model.createClass( "http://xmlns.com/baetle/#Started" );
    
}
