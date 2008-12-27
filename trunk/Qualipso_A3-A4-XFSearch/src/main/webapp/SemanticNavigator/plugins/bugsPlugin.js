/*
* Functions for the Bugs plugin
*/


/*
* Information data, this information is loaded by the plugin and stored in memory
* the information is only refreshed pushing the Bugs widget
*/

var bugsRDF;


/*
* Configuration params (for development, ad-hoc code)
*/

var bugsInfoUrl = "bugList.rdf";
//var emailsInfoUrl = "qualipso.rdf";
var qualipsoBugsID = "http://xmlns.com/baetle/#Bug";



function pluginBugsInit()
{
 panelBugsListInit();
 panelBugInfoInit();
 treeBugsListInit();
 treeBugInfotInit();
}


/*
* Panel with Bugs post list
*/
function panelBugsListInit() {

    YAHOO.qualipsoa4.knowledgeboard.panelBugsList =
    new YAHOO.widget.Panel("panelBugsList", {
        visible:true,
        width:"400px",
        height:"350px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelPeople','tl','bl']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelBugsList.setHeader("List of Bugs");
    YAHOO.qualipsoa4.knowledgeboard.panelBugsList.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelBugsList.render(document.body);
    makeRequestBugsList(bugsInfoUrl);
   
}

/*
* Panel with the information of the selected thread
*/
function panelBugInfoInit() {
    //
    YAHOO.qualipsoa4.knowledgeboard.panelBugInfo =
    new YAHOO.widget.Panel("panelBugInfo", {
        visible:false,
        width:"400px",
        height:"250px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelBugsList','tl','tr']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelBugInfo.setHeader("Bug information");
    YAHOO.qualipsoa4.knowledgeboard.panelBugInfo.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelBugInfo.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelBugInfo.render(document.body);
}



function treeBugsListInit() {

    YAHOO.qualipsoa4.knowledgeboard.treeBugsList = new YAHOO.widget.TreeView("treeBugsList");
    YAHOO.qualipsoa4.knowledgeboard.treeBugsList.subscribe("labelClick", onTreetreeBugsListClick);

}


function treeBugInfotInit() {
  
    
}

function onTreetreeBugsListClick(node) {
 YAHOO.qualipsoa4.knowledgeboard.panelBugInfo.show();
 YAHOO.qualipsoa4.knowledgeboard.panelBugInfo.focus();
 showBugInfo(node.data.url);
}



function makeRequestBugsList( sUrl ) {
     var request = YAHOO.util.Connect.asyncRequest( 'GET', sUrl,
        {
            success : handleRequestBugsListSuccess,
            failure : handleRequestBugsListFailure
        }
    );
}


function handleRequestBugsListSuccess( o ) {
   if ( o.responseText !== undefined ) {
        var content  = o.responseText;
        var nBugs =  parseBugsListRDF (content);
	YAHOO.qualipsoa4.knowledgeboard.panelBugsList.setFooter(nBugs + " bugs.");

    }
}

function handleRequestBugsListFailure( o ){
    if ( o.responseText !== undefined ) {
        alert( 'Couldn\'t load the content: ' + o.statusText );
    }
}


function generateBugInfo( subject, date, assigned)
{
 var bugInfoHTML = "<STRONG><A1>Subject:</A1></STRONG> " + subject  + "<br>" +
		"<STRONG>Date:</STRONG> " + date  +	"<br>" +
		"<STRONG>Assigned:</STRONG> " + assigned  +	"<br>";

  return bugInfoHTML;

}


function showBugInfo(bugResourceID)
{

  
    var bugsList = bugsRDF.getElementsByTagName("Description");

    if (bugsList == null || bugsList.length == 0)
	return;

    var HTMLCode = YAHOO.qualipsoa4.knowledgeboard.panelBugInfo;

    var n = bugsList.length;
    var nBugs = 0;
    for (i=0; i < n ; i++){

	var type= bugsList[i].getElementsByTagName("type");
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

		if (typeName == qualipsoBugsID)
		{	
			var resourceBug = bugsList[i].attributes[0].nodeValue;
			if ( resourceBug == bugResourceID)
			{
				nBugs++;
				
				var subject = bugsList[i].getElementsByTagName("description")[0].childNodes[0].nodeValue;
				var date = bugsList[i].getElementsByTagName("created")[0].childNodes[0].nodeValue;
				var assigned = bugsList[i].getElementsByTagName("assigned_to")[0].childNodes[0].nodeValue;
	
				var info = generateBugInfo ( subject, date, assigned);
		
				HTMLCode.setBody(info);
				
			break;
			}
		}
	}
	else
		alert("No type for this resource");
    }


    HTMLCode.render(document.body);


}


function parseBugsListRDF (contents) {
   
    var parser = new DOMParser();
    
    bugsRDF = parser.parseFromString(contents, "application/xml");

    var bugsList = bugsRDF.getElementsByTagName("Description");

    if (bugsList == null || bugsList.length == 0)
	return;

    var bugsTree = YAHOO.qualipsoa4.knowledgeboard.treeBugsList;
    new YAHOO.widget.HTMLNode("Bugs by description: ", bugsTree.getRoot() , false);

    var n = bugsList.length;
    var nBugs = 0;
    for (i=0; i < n ; i++){

	var type= bugsList[i].getElementsByTagName("type");
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

		if (typeName == qualipsoBugsID)
		{	
			nBugs++;
			var resourceBug = bugsList[i].attributes[0].nodeValue;
			
			var subject = bugsList[i].getElementsByTagName("description")[0].childNodes[0].nodeValue;
			new YAHOO.widget.TextNode({label: subject, url:resourceBug}, bugsTree.getRoot() , false);
			
		}
	}
	else
		alert("No type for this resource");
    }


    bugsTree.draw();
  
    return nBugs;

}
