/*
* Functions for the forum plugin
*/


/*
* Information data, this information is loaded by the plugin and stored in memory
* the information is only refreshed pushing the forum widget
*/

var forumRDF;


/*
* Configuration params (for development, ad-hoc code)
*/

var forumInfoUrl = "forumList.rdf";
//var emailsInfoUrl = "qualipso.rdf";
var qualipsoThreadID = "http://rdfs.org/sioc/ns#Thread";
var qualipsoPostID = "http://rdfs.org/sioc/ns#Post";

function pluginForumInit()
{
 panelForumListThreadsInit();
 panelForumThreadInit();
 panelForumPostInfoInit();
 treeForumListThreadsInit();
 treeForumListPostsInit();
}


/*
* Panel with forum post list
*/
function panelForumListThreadsInit() {

    YAHOO.qualipsoa4.knowledgeboard.panelForumListThreads =
    new YAHOO.widget.Panel("panelForumListThreads", {
        visible:false,
        width:"400px",
        height:"450px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelProjectMLListPosts','tr','tl']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelForumListThreads.setHeader("Threads of the forum");
    YAHOO.qualipsoa4.knowledgeboard.panelForumListThreads.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelForumListThreads.render(document.body);
    makeRequestForumList(forumInfoUrl);
}

/*
* Panel with the information of the selected thread
*/
function panelForumThreadInit() {
    
    YAHOO.qualipsoa4.knowledgeboard.panelForumThread =
    new YAHOO.widget.Panel("panelForumThread", {
        visible:false,
        width:"400px",
        height:"350px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelForumListThreads','tr','tl']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelForumThread.setHeader("Posts in the tread");
    YAHOO.qualipsoa4.knowledgeboard.panelForumThread.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelForumThread.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelForumThread.render(document.body);
}

/*
* Panel with informatio about a post
*/

function panelForumPostInfoInit() {
   
    YAHOO.qualipsoa4.knowledgeboard.panelForumPostInfo =
    new YAHOO.widget.Panel("panelForumPostInfo", {
        visible:false,
        width:"400px",
        height:"350px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelForumThread','tr','tl']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelForumPostInfo.setHeader("Post info");
    YAHOO.qualipsoa4.knowledgeboard.panelForumPostInfo.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelForumPostInfo.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelForumPostInfo.render(document.body);
  

}



function treeForumListThreadsInit() {
    YAHOO.qualipsoa4.knowledgeboard.treeForumListThreads = new YAHOO.widget.TreeView("treeForumListThreads");
    YAHOO.qualipsoa4.knowledgeboard.treeForumListThreads.subscribe("labelClick", onTreeForumListThreadsClick);
}

function treeForumListPostsInit() {
    YAHOO.qualipsoa4.knowledgeboard.treeForumListPosts = new YAHOO.widget.TreeView("treeForumListPosts");
    YAHOO.qualipsoa4.knowledgeboard.treeForumListPosts.subscribe("labelClick", treeForumListPostsClick);
}


    

function treeForumListPostsClick(node) {

 YAHOO.qualipsoa4.knowledgeboard.panelForumPostInfo.show();
 YAHOO.qualipsoa4.knowledgeboard.panelForumPostInfo.focus();
 parsePostInfoRDF(node.data.url);
}


function onTreeForumListThreadsClick(node) {
 YAHOO.qualipsoa4.knowledgeboard.panelForumThread.show();
 YAHOO.qualipsoa4.knowledgeboard.panelForumThread.focus();
 parseThreadInfotRDF(node.data.url);
}


function makeRequestForumList( sUrl ) {
    
    var request = YAHOO.util.Connect.asyncRequest( 'GET', sUrl,
        {
            success : handleForumListSuccess,
            failure : handleForumListFailure
        }
    );
}



function handleForumListSuccess( o ) {
   if ( o.responseText !== undefined ) {
        var content  = o.responseText;
        var nThreads =  parseThreadsListRDF (content);
	YAHOO.qualipsoa4.knowledgeboard.panelBugsList.setFooter(nThreads + " threads.");

    }
}

function handleForumListFailure( o ){
    if ( o.responseText !== undefined ) {
        alert( 'Couldn\'t load the content: ' + o.statusText );
    }
}


function generatePostInfo( subject, content)
{
  var postInfoHTML = "<STRONG><A1>Subject:</A1></STRONG><br> " + subject  + "<br><hr>" +
		"<STRONG>Content:</STRONG> <br>" + content  +	"<br><hr>";

  return postInfoHTML;

}


function parsePostInfoRDF (resourcePostID) {
   
	
    var postsList = forumRDF.getElementsByTagName("Description");

    if (postsList == null || postsList.length == 0)
	return;

    var HTMLCode = YAHOO.qualipsoa4.knowledgeboard.panelForumPostInfo;

    var n = postsList.length;
  
   for (i=0; i < n ; i++){

	var type= postsList[i].getElementsByTagName("type");
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
		
		if (typeName == qualipsoPostID)
		{	
			var postResource = postsList[i].attributes[0].nodeValue;
			
			if ( postResource == resourcePostID)
			{	
				var subject = postsList[i].getElementsByTagName("subject")[0].childNodes[0].nodeValue;
				var content = postsList[i].getElementsByTagName("content")[0].childNodes[0].nodeValue;
				var info = generatePostInfo(subject, content);
				HTMLCode.setBody(info);
			}
				
		}
	}
	else
		alert("No type for this resource");
    }

    HTMLCode.render(document.body);

}


function parseThreadInfotRDF (resourceThreadID) {
   
	
    var postsList = forumRDF.getElementsByTagName("Description");

    if (postsList == null || postsList.length == 0)
	return;

    treeForumListPostsInit();
    var postsTree = YAHOO.qualipsoa4.knowledgeboard.treeForumListPosts;
  
    new YAHOO.widget.HTMLNode("Posts in the tread: ", postsTree.getRoot() , false);

    var n = postsList.length;
  
   for (i=0; i < n ; i++){

	var type= postsList[i].getElementsByTagName("type");
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
		
		if (typeName == qualipsoPostID)
		{	
			var parentResource = postsList[i].getElementsByTagName("has\_parent")[0].attributes[0].value;
			
			if ( parentResource == resourceThreadID)
			{	
				var postResource =  postsList[i].attributes[0].nodeValue;
				var subject = postsList[i].getElementsByTagName("subject")[0].childNodes[0].nodeValue;
				
				new YAHOO.widget.TextNode({label: subject, url:postResource}, postsTree.getRoot() , false);
			}
				
		}
	}
	else
		alert("No type for this resource");
    }


     postsTree.draw();

}




function parseThreadsListRDF (contents) {
   
    

    var parser = new DOMParser();
    
    forumRDF = parser.parseFromString(contents, "application/xml");

    var threadList = forumRDF.getElementsByTagName("Description");

    if (threadList == null || threadList.length == 0)
	return;

    var threadsTree = YAHOO.qualipsoa4.knowledgeboard.treeForumListThreads;
    new YAHOO.widget.HTMLNode("Threads in the forum: ", threadsTree.getRoot() , false);

    var n = threadList.length;
    var nThreads = 0;
 
   for (i=0; i < n ; i++){

	var type= threadList[i].getElementsByTagName("type");
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

		if (typeName == qualipsoThreadID)
		{	
			nThreads++;
			var resourceThread = threadList[i].attributes[0].nodeValue;
			new YAHOO.widget.TextNode({label: resourceThread, url:resourceThread}, threadsTree.getRoot() , false);
			
		}
	}
	else
		alert("No type for this resource");
    }


    threadsTree.draw();
  
    return nThreads;

}




