/*
* Functions for the project plugin
*/


/*
* Information data, this information is loaded by the plugin and stored in memory
* the information is only refreshed pushing the project widget
*/

var projectRDF;


/*
* Configuration params (for development, ad-hoc code)
*/

var projectInfoUrl = "projectsList.rdf";

var qualipsoProjectID = "http://usefulinc.com/ns/doap#Project";



function pluginprojectInit()
{
 panelProjectsInit();
 panelProjectDOAPInit();
 treeProjectsInit();
 treeProjectDOAPInit();
}

function panelProjectsInit() {
    YAHOO.qualipsoa4.knowledgeboard.panelProjects =
    new YAHOO.widget.Panel("panelProjects", {
        width:"300px",
        height:"250px",
        visible:true,
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
	context:['panelPeople','tl','tr']
  });
    YAHOO.qualipsoa4.knowledgeboard.panelProjects.setHeader("All projects");
    YAHOO.qualipsoa4.knowledgeboard.panelProjects.setBody("");
    //YAHOO.qualipsoa4.knowledgeboard.panelProjects.setBody("<div id='treeProjects'></div>");
    YAHOO.qualipsoa4.knowledgeboard.panelProjects.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelProjects.render(document.body);
    makeRequestProjectsList(projectInfoUrl);
}

function panelProjectDOAPInit() {
    // Project summary
    YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP =
    new YAHOO.widget.Panel("panelProjectDOAP", {
        width:"300px",
        height:"250px",
        visible:false,
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelProjects','tl','tr']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP.setHeader("Project Info");
    YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP.setBody("");
    //YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP.setBody("<div id='treeProjectDOAP'></div>");
    YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP.render(document.body);
  
}



function treeProjectsInit() {
    // Tree View for Projects
    YAHOO.qualipsoa4.knowledgeboard.treeProjects = new YAHOO.widget.TreeView("treeProjects");
    YAHOO.qualipsoa4.knowledgeboard.treeProjects.subscribe("labelClick", onTreeProjectsClick);
}

function treeProjectDOAPInit() {
    // Tree View for DOAP Project info
    YAHOO.qualipsoa4.knowledgeboard.treeProjectDOAP = new YAHOO.widget.TreeView("treeProjectDOAP");
    YAHOO.qualipsoa4.knowledgeboard.treeProjectDOAP.subscribe("labelClick", onTreeProjectDOAPClick)
}



function onTreeProjectsClick(node) {
    YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP.show();
    YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP.focus();
    parseProjectInfoRDF(node.data.url);

}


function onTreeProjectDOAPClick(node) {

}



function makeRequestProjectsList( sUrl ) {
    
    var request = YAHOO.util.Connect.asyncRequest( 'GET', sUrl,
        {
            success : handleProjectsListSuccess,
            failure : handleProjectsListFailure
        }
    );
}


function handleProjectsListSuccess( o ) {

    if ( o.responseText !== undefined ) {
        var content  = o.responseText;
        var nprojects = parseProjectsListRDF (content);
       
        YAHOO.qualipsoa4.knowledgeboard.panelProjects.setFooter(nprojects + " projects.");
        YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP.render(document.body);
  
    }

}

function handleProjectsListFailure( o ){
    if ( o.responseText !== undefined ) {
        alert( 'Couldn\'t load the content: ' + o.statusText );
    }
}

function generateProjectInfo( homePage, wiki)
{
 var projectInfoHTML = "<STRONG><A1>Home Page:</A1></STRONG> <a href=\"" + homePage + "\"> " + homePage  + "</a><br>" +
		"<STRONG>Wiki:</STRONG> <a href=\"" + wiki + "\"> " + wiki  +	"</a><br>";
		
  return projectInfoHTML;

}

function parseProjectInfoRDF (projectResourceID) {
   
   
    var parser = new DOMParser();
    var projectList = projectRDF.getElementsByTagName("Description");

    if (projectList == null || projectList.length == 0)
	return;

    var HTMLCode = YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP;
    
    var n = projectList.length;
    for (i=0; i < n ; i++){

	var type= projectList[i].getElementsByTagName("type");
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

		if (typeName == qualipsoProjectID)
		{
			var resourceProject = projectList[i].attributes[0].nodeValue;
	
			if ( resourceProject == projectResourceID)
			{
			
				var homePage = projectList[i].getElementsByTagName("homepage")[0].childNodes[0].nodeValue;
				var wiki = projectList[i].getElementsByTagName("wiki")[0].childNodes[0].nodeValue;

				var info = generateProjectInfo ( homePage, wiki);

				HTMLCode.setBody(info);
			}			
		}
	}
	else
		alert("No type for this resource");
    }


    HTMLCode.render(document.body);

}



function parseProjectsListRDF (contents) {
   
 

    var parser = new DOMParser();
    
    projectRDF = parser.parseFromString(contents, "application/xml");

    var projectList = projectRDF.getElementsByTagName("Description");

    if (projectList == null || projectList.length == 0)
	return;

    var projectsTree = YAHOO.qualipsoa4.knowledgeboard.treeProjects;
   new YAHOO.widget.HTMLNode("Bugs by description: ", projectsTree.getRoot() , false);


    var n = projectList.length;
    var nProjects = 0;
   for (i=0; i < n ; i++){

	var type= projectList[i].getElementsByTagName("type");
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

		if (typeName == qualipsoProjectID)
		{	
			nProjects++;
			var resourceProject = projectList[i].attributes[0].nodeValue;
			
			var homePage = projectList[i].getElementsByTagName("homepage")[0].childNodes[0].nodeValue;
			
			new YAHOO.widget.TextNode({label: homePage, url:resourceProject}, projectsTree.getRoot() , false);
			
		}
	}
	else
		alert("No type for this resource");
    }


    projectsTree.draw();
  
    return nProjects;

}

