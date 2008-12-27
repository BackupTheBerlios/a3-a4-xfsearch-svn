/*
* Functions for the people plugin
*/


/*
* Information data, this information is loaded by the plugin and stored in memory (peopleRDF)
* the information is only refreshed pushing the people widget
*/

var peopleRDF;


/*
* Configuration params (for development, ad-hoc code)
*/

var peopleInfoUrl = "contactList.rdf";
//var emailsInfoUrl = "qualipso.rdf"
;
var qualipsoPersonID = "http://rdfs.org/sioc/ns#User";
var qualipsoPersonIDFOAF = "http://xmlns.com/foaf/0.1/Person";


function pluginPeopleInit()
{
 panelPeopleInit();
 panelPersonInit();
 treePeopleInit();
 treePersonInit();
 panelPeopleLoad();
}



function panelPeopleInit() {
    YAHOO.qualipsoa4.knowledgeboard.panelPeople =
    new YAHOO.widget.Panel("panelPeople", {
        visible:true,
        width:"300px",
        height:"250px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelTools','tl','bl']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelPeople.setHeader("All People");
    YAHOO.qualipsoa4.knowledgeboard.panelPeople.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelPeople.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelPeople.render(document.body);
}


function panelPersonInit() {
    YAHOO.qualipsoa4.knowledgeboard.panelPerson =
    new YAHOO.widget.Panel("panelPerson", {
        visible:false,
        width:"300px",
        height:"200px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelPeople','tl','bl']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelPerson.setHeader("Person");
    YAHOO.qualipsoa4.knowledgeboard.panelPerson.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelPerson.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelPerson.render(document.body);
}


function treePeopleInit() {
    YAHOO.qualipsoa4.knowledgeboard.treePeople = new YAHOO.widget.TreeView("treePeople");
    YAHOO.qualipsoa4.knowledgeboard.treePeople.subscribe("labelClick", onTreePeopleClick);
}

function treePersonInit() {
    YAHOO.qualipsoa4.knowledgeboard.treePerson = new YAHOO.widget.TreeView("treePerson");
    YAHOO.qualipsoa4.knowledgeboard.treePerson.subscribe("labelClick", onTreePersonClick);
}


function panelPeopleLoad() {
    var tree = YAHOO.qualipsoa4.knowledgeboard.treePeople;
    makeRequestPeople(peopleInfoUrl);
    tree.draw();
}


function onTreePeopleClick(node) {
    YAHOO.qualipsoa4.knowledgeboard.panelPerson.show();
    YAHOO.qualipsoa4.knowledgeboard.panelPerson.focus();
    YAHOO.qualipsoa4.knowledgeboard.panelPerson.setHeader(node.data.label);
    makeRequestPerson(node.data.url);
}


function onTreePersonClick(node) {

}


function makeRequestPeople( sUrl ) {
    var request = YAHOO.util.Connect.asyncRequest( 'GET', sUrl,
        {
            success : handlePeopleSuccess,
            failure : handlePeopleFailure
        }
    );
}




function handlePeopleSuccess( o ) {
    if ( o.responseText !== undefined ) {
        var content  = o.responseText;
        var nPeople = parsePeople (content);
        //var contents = "test"
        YAHOO.qualipsoa4.knowledgeboard.panelPeople.setFooter(nPeople + " contacts");
    }
}

function handlePeopleFailure( o ){
    if ( o.responseText !== undefined ) {
        alert( 'Couldn\'t load the content: ' + o.statusText );
    }
}


function makeRequestPerson( sUrl ) {
	parsePerson(sUrl);
}





function generateContactHTML(name, lastName, email)
{
 var contactHTML =  "<STRONG><A1>Name:</A1></STRONG> " + name + "<br>" +
		"<STRONG>Last Name:</STRONG> " + lastName  +	"<br>" +
		"<STRONG>email:</STRONG> " + email  +	"<br>";

  return contactHTML;

}



function parsePerson (personResourceID) {
 
 
     var peopleList = peopletRDF.getElementsByTagName("Description");

    if (peopleList == null || peopleList.length == 0)
	return;

    var HTMLCode = YAHOO.qualipsoa4.knowledgeboard.panelPerson;

    var n = peopleList.length;
    for (i=0; i < n ; i++){

	var type= peopleList[i].getElementsByTagName("type");
 	var typeName = "";
	/* we can only have one rdf:type tag and then could be the first attribute or the first node */

	if (type.length > 0)
	{
		
		if (type[0].attributes[0] != null)
			typeName = type[0].attributes[0].value;
		else if (typeName = type[0].childNodes[0] != null)
			typeName = type[0].childNodes[0].nodeValue;

		if (typeName == qualipsoPersonID)
		{	
			var resourcePeople = peopleList[i].attributes[0].nodeValue;
			if ( resourcePeople == personResourceID)
			{


				var resourcePerson = peopleList[i].attributes[0].nodeValue;
				
				var name; 
				if ( peopleList[i].getElementsByTagName("name")[0].childNodes[0] != null)
					name = peopleList[i].getElementsByTagName("name")[0].childNodes[0].nodeValue;
				else
					name = ""; // no name defined
				
				var lastName;
				if (peopleList[i].getElementsByTagName("last_name")[0].childNodes[0] != null)
					lastName = peopleList[i].getElementsByTagName("last_name")[0].childNodes[0].nodeValue;
				else
					lastName = ""; //no lastname 
	
				var email;
				if (peopleList[i].getElementsByTagName("email")[0].childNodes[0] != null)
					email = peopleList[i].getElementsByTagName("email")[0].childNodes[0].nodeValue ;
				else
					email = "";

				var contactHTML = generateContactHTML(name, lastName, email);
				
				HTMLCode.setBody(contactHTML);
			}			
			
		}
		else if ( typeName == qualipsoPersonIDFOAF )
		{
			var resourcePeople = peopleList[i].attributes[0].nodeValue;
			if ( resourcePeople == personResourceID)
			{


				var resourcePerson = peopleList[i].attributes[0].nodeValue;
				
				var name; 
				if ( peopleList[i].getElementsByTagName("firstName")[0].childNodes[0] != null)
					name = peopleList[i].getElementsByTagName("firstName")[0].childNodes[0].nodeValue;
				else
					name = ""; // no name defined
				
				var lastName;
				if (peopleList[i].getElementsByTagName("surname")[0].childNodes[0] != null)
					lastName = peopleList[i].getElementsByTagName("surname")[0].childNodes[0].nodeValue;
				else
					lastName = ""; //no lastname 
	
				var email;
				if (peopleList[i].getElementsByTagName("email")[0].childNodes[0] != null)
					email = peopleList[i].getElementsByTagName("mbox")[0].childNodes[0].nodeValue ;
				else
					email = "";

				var contactHTML = generateContactHTML(name, lastName, email);
				
				HTMLCode.setBody(contactHTML);
			}		
		
		}
	}
	else
		alert("No type for this resource");
    }


    HTMLCode.render(document.body);
  
    return nPeople;

}



function parsePeople (contents) {
   
 
    var parser = new DOMParser();
    peopletRDF = parser.parseFromString(contents, "text/xml");
   
    var peopleList = peopletRDF.getElementsByTagName("Description");

    if (peopleList == null || peopleList.length == 0)
	return;

    var peopleTree = YAHOO.qualipsoa4.knowledgeboard.treePeople;
    new YAHOO.widget.HTMLNode("Persons: ", peopleTree.getRoot() , false);

    var n = peopleList.length;
    var nPeople = 0;
  
   for (i=0; i < n ; i++){

	var type= peopleList[i].getElementsByTagName("type");
 	var typeName = "";
	/* we can only have one rdf:type tag and then could be the first attribute or the first node */

	if (type.length > 0)
	{
		if (type[0].attributes[0] != null)
			typeName = type[0].attributes[0].value;
		else if (typeName = type[0].childNodes[0] != null)
		{
			typeName = type[0].childNodes[0].nodeValue;

		}
		
		
		if (typeName == qualipsoPersonID)
		{	
			
			var resourcePerson = peopleList[i].attributes[0].nodeValue;
			
			

			var name; 
			if ( peopleList[i].getElementsByTagName("name")[0].childNodes[0] != null)
				name = peopleList[i].getElementsByTagName("name")[0].childNodes[0].nodeValue;
			else
				name = ""; // no name defined
			
			var lastName;
			if (peopleList[i].getElementsByTagName("last_name")[0].childNodes[0] != null)
				lastName = peopleList[i].getElementsByTagName("last_name")[0].childNodes[0].nodeValue;
			else
				lastName = ""; //no lastname 
			
			var tagPerson = "";
			if (lastName != "")
			{
				nPeople++;
				new YAHOO.widget.TextNode({label: lastName, url:resourcePerson}, peopleTree.getRoot() , false);
			}
			else if (name != "")
			{
				nPeople++;
				new YAHOO.widget.TextNode({label: name, url:resourcePerson}, peopleTree.getRoot() , false);
			}

	
			
			
			
		}
		else if (typeName == qualipsoPersonIDFOAF)
		{	
			
			var resourcePerson = peopleList[i].attributes[0].nodeValue;
			
			

			var name; 
			if ( peopleList[i].getElementsByTagName("firstName")[0].childNodes[0] != null)
				name = peopleList[i].getElementsByTagName("firstName")[0].childNodes[0].nodeValue;
			else
				name = ""; // no name defined
			
			var lastName;
			if (peopleList[i].getElementsByTagName("surname")[0].childNodes[0] != null)
				lastName = peopleList[i].getElementsByTagName("surname")[0].childNodes[0].nodeValue;
			else
				lastName = ""; //no lastname 
			
			var tagPerson = "";
			if (lastName != "")
			{
				nPeople++;
				new YAHOO.widget.TextNode({label: name + " " + lastName, url:resourcePerson}, peopleTree.getRoot() , false);
			}
			else if (name != "")
			{
				nPeople++;
				new YAHOO.widget.TextNode({label: name, url:resourcePerson}, peopleTree.getRoot() , false);
			}

	
			
			
			
		}
	}
	else
		alert("No type for this resource");
    }


    peopleTree.draw();
  
    return nPeople;

}




