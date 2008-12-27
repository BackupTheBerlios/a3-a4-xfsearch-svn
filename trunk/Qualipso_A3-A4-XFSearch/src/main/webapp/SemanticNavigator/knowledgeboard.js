/*
 * Copyright (C) 2007-2008 Universidad Rey Juan Carlos
 * Authors: Julia Anaya <janaya@gsyc.es>, Alvaro del Castillo <acs@gsyc.es>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 * 
*/

YAHOO.namespace("qualipsoa4.knowledgeboard");

//
// Initializing the Panel
//
function init() {

    pluginMailListInit();  // MailingList plugin
    pluginPeopleInit();    // People plugin
    pluginForumInit();	   // Forum plugin
    pluginBugsInit();      // Bugs plugin
    pluginprojectInit();   // Projects plugin


    YAHOO.qualipsoa4.knowledgeboard.manager = new YAHOO.widget.OverlayManager();
    YAHOO.qualipsoa4.knowledgeboard.manager.register([
            YAHOO.qualipsoa4.knowledgeboard.panelProjects,
            YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP,

            YAHOO.qualipsoa4.knowledgeboard.panelProjectMLListPosts,
            YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost,
            YAHOO.qualipsoa4.knowledgeboard.panelPeople,
            YAHOO.qualipsoa4.knowledgeboard.panelPerson,
 	    YAHOO.qualipsoa4.knowledgeboard.panelForumListThreads,
            YAHOO.qualipsoa4.knowledgeboard.panelForumThread,
	    YAHOO.qualipsoa4.knowledgeboard.panelForumPostInfo,
	    YAHOO.qualipsoa4.knowledgeboard.panelBugsList,
	    YAHOO.qualipsoa4.knowledgeboard.panelBugInfo

    ]);



    YAHOO.util.Event.addListener("showProjects", "click", YAHOO.qualipsoa4.knowledgeboard.panelProjects.show, YAHOO.qualipsoa4.knowledgeboard.panelProjects, true);
    YAHOO.util.Event.addListener("showProjectDOAP", "click", YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP.show, YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP, true);
    YAHOO.util.Event.addListener("showProjectMLListPosts", "click", YAHOO.qualipsoa4.knowledgeboard.panelProjectMLListPosts.show, YAHOO.qualipsoa4.knowledgeboard.panelProjectMLListPosts, true);
    YAHOO.util.Event.addListener("showProjectMLPost", "click", YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost.show, YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost, true);
    YAHOO.util.Event.addListener("showPeople", "click", YAHOO.qualipsoa4.knowledgeboard.panelPeople.show, YAHOO.qualipsoa4.knowledgeboard.panelPeople, true);
    YAHOO.util.Event.addListener("showPerson", "click", YAHOO.qualipsoa4.knowledgeboard.panelPerson.show, YAHOO.qualipsoa4.knowledgeboard.panelPerson, true);

 YAHOO.util.Event.addListener("showForumListThreads", "click", YAHOO.qualipsoa4.knowledgeboard.panelForumListThreads.show, YAHOO.qualipsoa4.knowledgeboard.panelForumListThreads, true);
 YAHOO.util.Event.addListener("showForumThread", "click", YAHOO.qualipsoa4.knowledgeboard.panelForumThread.show, YAHOO.qualipsoa4.knowledgeboard.panelForumThread, true);

 YAHOO.util.Event.addListener("showBugsList", "click", YAHOO.qualipsoa4.knowledgeboard.panelBugsList.show, YAHOO.qualipsoa4.knowledgeboard.panelBugsList, true);
 YAHOO.util.Event.addListener("showBugInfo", "click", YAHOO.qualipsoa4.knowledgeboard.panelBugInfo.show, YAHOO.qualipsoa4.knowledgeboard.panelBugInfo, true);


}




function panelHTMLInit() {

    YAHOO.qualipsoa4.knowledgeboard.panelHTML =
    new YAHOO.widget.Panel("panelHTML", {
        visible:false,
        width:"300px",
        height:"250px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        //context:['panelProjects','tl','bl']
        context:['panelProjectSIOCPost','tl','tr']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelHTML.setHeader("");
    YAHOO.qualipsoa4.knowledgeboard.panelHTML.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelHTML.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelHTML.render(document.body);
}



function panelProjectSIOCPostInit() {
    //
    YAHOO.qualipsoa4.knowledgeboard.panelProjectSIOCPost =
    new YAHOO.widget.Panel("panelProjectSIOCPost", {
        visible:false,
        width:"300px",
        height:"250px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelProjectSIOC','tl','tr']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelProjectSIOCPost.setHeader("Mailing List Post(SIOC)");
    YAHOO.qualipsoa4.knowledgeboard.panelProjectSIOCPost.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelProjectSIOCPost.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelProjectSIOCPost.render(document.body);
}



function panelGoogleMapInit() {
    YAHOO.qualipsoa4.knowledgeboard.panelGoogleMap =
    new YAHOO.widget.Panel("panelGoogleMap", {
        visible:false,
        width:"300px",
        height:"250px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelPerson','tl','tr']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelGoogleMap.setHeader("Google map");
    YAHOO.qualipsoa4.knowledgeboard.panelGoogleMap.setBody("<div id='map' style='width: 290px; height: 210px'></div>");
    YAHOO.qualipsoa4.knowledgeboard.panelGoogleMap.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelGoogleMap.render(document.body);
}

function panelSPARQLInit() {
    YAHOO.qualipsoa4.knowledgeboard.panelSPARQL =
    new YAHOO.widget.Panel("panelSPARQL", {
        visible:false,
        width:"300px",
        height:"250px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelPerson','tl','tr']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelSPARQL.setHeader("SPARQL (Result)");
    YAHOO.qualipsoa4.knowledgeboard.panelSPARQL.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelSPARQL.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelSPARQL.render(document.body);
}

function panelRSSInit() {
    YAHOO.qualipsoa4.knowledgeboard.panelRSS =
    new YAHOO.widget.Panel("panelRSS", {
        visible:false,
        width:"300px",
        height:"250px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelPerson','tl','tr']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelRSS.setHeader("Project (RSS)");
    YAHOO.qualipsoa4.knowledgeboard.panelRSS.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelRSS.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelRSS.render(document.body);
}

function panelSIOCPostInit() {
    YAHOO.qualipsoa4.knowledgeboard.panelSIOCPost =
    new YAHOO.widget.Panel("panelSIOCPost", {
        visible:false,
        width:"300px",
        height:"250px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelPerson','tl','tr']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelSIOCPost.setHeader("Person (FOAF)");
    YAHOO.qualipsoa4.knowledgeboard.panelSIOCPost.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelSIOCPost.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelSIOCPost.render(document.body);
}


function treeProjectSIOCSubscribersInit() {
    YAHOO.qualipsoa4.knowledgeboard.treeProjectSIOCSubscribers = new YAHOO.widget.TreeView("treeProjectSIOCSubscribers");
    YAHOO.qualipsoa4.knowledgeboard.treeProjectSIOCSubscribers.subscribe("labelClick", onTreeProjectSIOCSubscribersClick);
}

function treeProjectSIOCPostInit() {
    YAHOO.qualipsoa4.knowledgeboard.treeProjectSIOCPost = new YAHOO.widget.TreeView("treeProjectSIOCPost");
    YAHOO.qualipsoa4.knowledgeboard.treeProjectSIOCPost.subscribe("labelClick", onTreeProjectSIOCPostClick);
}



function treePersonWorksWithInit() {
    YAHOO.qualipsoa4.knowledgeboard.treePersonWorksWith = new YAHOO.widget.TreeView("treePersonWorksWith");
    YAHOO.qualipsoa4.knowledgeboard.treePersonWorksWith.subscribe("labelClick", onTreePersonWorksWithClick);
}

function treePersonProjectsInit() {
    YAHOO.qualipsoa4.knowledgeboard.treePersonProjects = new YAHOO.widget.TreeView("treePersonProjects");
    YAHOO.qualipsoa4.knowledgeboard.treePersonProjects.subscribe("labelClick", onTreePersonProjectsClick);
}

function treePersonInterestsInit() {
    YAHOO.qualipsoa4.knowledgeboard.treePersonInterests = new YAHOO.widget.TreeView("treePersonInterests");
    YAHOO.qualipsoa4.knowledgeboard.treePersonInterests.subscribe("labelClick", onTreePersonInterestsClick);
}

function treeSPARQLInit() {
    YAHOO.qualipsoa4.knowledgeboard.panelSPARQLTree = new YAHOO.widget.TreeView("panelSPARQLTree");
    YAHOO.qualipsoa4.knowledgeboard.panelSPARQLTree.subscribe("labelClick", onPanelSPARQLTreeClick);
}

function treeRSSInit() {
    YAHOO.qualipsoa4.knowledgeboard.panelRSSTree = new YAHOO.widget.TreeView("panelRSSTree");
    YAHOO.qualipsoa4.knowledgeboard.panelRSSTree.subscribe("labelClick", onPanelRSSTreeClick);
}




//function panelGoogleMapLoad() {
function panelGoogleMapLoad(lat, long) {
    //new YAHOO.util.ImageLoader.srcImgObj   ( domId , url , width , height )
    //var panel = YAHOO.qualipsoa4.knowledgeboard.panelGoogleMap;
    var map = new GMap2(document.getElementById("map"));
    //var point = new GLatLng(40.41045, -3.71045)
    var point = new GLatLng(lat, long)
    map.setCenter(point, 13);
    map.addOverlay(new GMarker(point));
    //YAHOO.qualipsoa4.knowledgeboard.panelGoogleMap.setBody("");
}


function onTreeProjectSIOCSubscribersClick(node) {
}

function onTreeProjectSIOCPostClick(node) {
}



function onTreePersonWorksWithClick(node) {
}

function onTreePersonProjectsClick(node) {
}

function onTreePersonInterestsClick(node) {
}

function onPanelRSSTreeClick(node) {
}

function onPanelSPARQLTreeClick(node) {
}

// Hack just for testing
var siocUrl = "swamlML.sioc";
var sparqlResultsUrl = "sparqlResults.srx";

function makeRequestRSS( sUrl ) {
    var request = YAHOO.util.Connect.asyncRequest( 'GET', sUrl,
        {
            success:handleRSSSuccess,
            failure:handleRSSFailure,
            argument: { foo:"foo", bar:"bar" }
        }
    );
}


function makeRequestHTML( sUrl ) {
    //var sUrl = o.href;
    var request = YAHOO.util.Connect.asyncRequest( 'GET', sUrl,
        {
            success : handleHTMLSuccess,
            failure : handleHTMLFailure
        }
    );
}

function makeRequestSIOC( sUrl ){
    var request = YAHOO.util.Connect.asyncRequest('GET', sUrl,
        {
            success : handleSIOCSuccess,
            failure : handleSIOCFailure
        }
    );
}
function makeRequestSIOCPost(siocPostUrl) {
    // siocPostUrl = "swamlMLPost.sioc";
    var request = YAHOO.util.Connect.asyncRequest('GET', siocPostUrl,
        {
            success : handleSIOCPostSuccess,
            failure : handleSIOCPostFailure
        }
    );
}
function makeRequestSIOCPostXHTML(siocPostUrl) {
    // siocPostUrl = "swamlMLPost.sioc";
    var request = YAHOO.util.Connect.asyncRequest('GET', siocPostUrl,
        {
            success : handleSIOCPostXHTMLSuccess,
            failure : handleSIOCPostXHTMLFailure
        }
    );
}

function makeRequestFOAF( sUrl ) {
    //var sUrl = o.href;
    var request = YAHOO.util.Connect.asyncRequest( 'GET', sUrl,
        {
            success : handleFOAFSuccess,
            failure : handleFOAFFailure
        }
    );
}

function makeRequestSPARQL( sUrl ) {
    //var sUrl = o.href;
    var request = YAHOO.util.Connect.asyncRequest( 'GET', sUrl,
        {
            success : handleSPARQLSuccess,
            failure : handleSPARQLFailure
        }
    );
}



var handleRSSSuccess = function(o) {
    if (o.responseText !== undefined) {
        contents = parseRSS(o.responseText); 
        YAHOO.qualipsoa4.knowledgeboard.panelRSS.setBody(contents);
    }
}               

var handleRSSFailure = function(o) {
    YAHOO.qualipsoa4.knowledgeboard.panelRSS.setBody("Received response");
    if (o.responseText !== undefined) {
        contents  = "<li>Transaction id: " + o.tId + "</li>";
        contents += "<li>HTTP status: " + o.status + "</li>";
        contents += "<li>Status code message: " + o.statusText + "</li>";
        YAHOO.qualipsoa4.knowledgeboard.panelRSS.setBody(contents);
    }
}

function handleDOAPSuccess( o ) {
    if ( o.responseText !== undefined ) {
        var content  = o.responseText;
        var contents = parseDOAP (content);
        //var contents = "test"
        YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP.setBody(contents);
    }
}

function handleHTMLSuccess( o ) {
    if ( o.responseText !== undefined ) {
        var content  = o.responseText;
        YAHOO.qualipsoa4.knowledgeboard.panelHTML.setHeader("HTML");
        YAHOO.qualipsoa4.knowledgeboard.panelHTML.setBody(content);

        //content = content.replace( /<body>/, '<div id="popupbody">' );
        //content  = content.replace( /<\/body>/, '</div>' );
        //var win = document.getElementById('win');
        //var windowbody = win.getElementsByTagName('div')[1];
        //windowbody.innerHTML=content;
        //var title = win.getElementsByTagName( 'title' )[0].innerHTML;
        //var body = document.getElementById( 'popupbody' ).innerHTML;
        //panel.setBody( body );
        //panel.setHeader( title );
        //panel.show();
        //var tree = YAHOO.qualipsoa4.knowledgeboard.treeProjectDOAP;
        //new YAHOO.widget.TextNode({label:"QualOSS", doap:"qualoss.doap"}, tree.getRoot() , false);
        //tree.draw();
    }
}

function handleSIOCSuccess( o ) {
    if ( o.responseText !== undefined ) {
        var content  = o.responseText;
        var contents = parseSIOC (content);
        //var contents = "test"
        YAHOO.qualipsoa4.knowledgeboard.panelProjectSIOC.setBody(contents);
    }
}

function handleSIOCPostSuccess( o ) {
    if (o.responseText !== undefined) {
        var contents = parseSIOCPost(o.responseText);

        var formObject = document.getElementById('SIOCPostCommentForm');
        formObject.SIOCPostId.value = o.argument.postURL;
        YAHOO.qualipsoa4.knowledgeboard.panelSIOCPost.setBody(contents);
        YAHOO.qualipsoa4.knowledgeboard.panelSIOCPost.focus();
    }
}

function handleSIOCPostXHTMLSuccess( o ) {
    if (o.responseText !== undefined) {
        var content  = o.responseText;
        var contents = parseSIOCContent(content);

        //var formObject = document.getElementById('SIOCPostCommentForm');
        //formObject.SIOCPostId.value = o.argument.postURL;
        //YAHOO.qualipsoa4.knowledgeboard.panelProjectSIOCPost.setBody(contents);

        YAHOO.qualipsoa4.knowledgeboard.panelHTML.show();
        YAHOO.qualipsoa4.knowledgeboard.panelHTML.focus();
        YAHOO.qualipsoa4.knowledgeboard.panelHTML.setHeader("Mailing list Post content (XHTML)");
        YAHOO.qualipsoa4.knowledgeboard.panelHTML.setBody(contents);

    }
}



function handleHTMLFailure( o ){
    if ( o.responseText !== undefined ) {
        alert( 'Couldn\'t load the content: ' + o.statusText );
    }
}

function handleSIOCFailure( o ){
    if ( o.responseText !== undefined ) {
        alert( 'Couldn\'t load the content: ' + o.statusText );
    }
}

function handleSIOCPostFailure( o ) {
    if (o.responseText !== undefined) {
        alert( 'Couldn\'t load the content: ' + o.statusText );
    }
}

function handleSIOCPostXHTMLFailure( o ) {
    if (o.responseText !== undefined) {
        alert( 'Couldn\'t load the content: ' + o.statusText );
    }
}

function handleFOAFFailure( o ) {
    if (o.responseText !== undefined) {
        alert( 'Couldn\'t load the content: ' + o.statusText );
    }
}

function handleSPARQLSuccess (o) {
    if (o.responseText !== undefined) {
        contents = parseSPARQL(o.responseText);
        YAHOO.qualipsoa4.knowledgeboard.panelSPARQL.setBody(contents);
    }
}

function handleSPARQLFailure (o) {
    if (o.responseText !== undefined) {
        contents  = "<li>Transaction id: " + o.tId + "</li>";
        contents += "<li>HTTP status: " + o.status + "</li>";
        contents += "<li>Status code message: " + o.statusText + "</li>";
        YAHOO.qualipsoa4.knowledgeboard.panelSPARQL.setBody(contents);
        YAHOO.qualipsoa4.knowledgeboard.panelSPARQL.focus();
    }
}


function parseDOAP (contents) {
    var doap = "";
    // http://developer.mozilla.org/en/docs/DOMParser
    var parser = new DOMParser();
    var myXMLDoc = parser.parseFromString(contents, "text/xml");

    var project = myXMLDoc.getElementsByTagName("Project")[0];
    var name = project.getElementsByTagName("name")[0].childNodes[0].nodeValue;
    var license_href = project.getElementsByTagName("license")[0].attributes[0].value;
    var project_href = project.getElementsByTagName("homepage")[0].attributes[0].value;
    project_href = project_href.replace( 'http://', '' );
    project_href = project_href.replace( '/', '.htm' );
    var shortdesc = project.getElementsByTagName("shortdesc")[0].childNodes[0].nodeValue;
    var foafcreated = project.getElementsByTagName("created")[0].childNodes[0].nodeValue;
    //var desc = project.getElementsByTagName("description")[0].childNodes[0].nodeValue;
    var language = project.getElementsByTagName("programming-language")[0].childNodes[0].nodeValue;
    var releases = project.getElementsByTagName("release")[0];
    var last_release = releases.getElementsByTagName("Version")[0];
    var last_release_name = last_release.getElementsByTagName("name")[0].childNodes[0].nodeValue;
    var developers =  project.getElementsByTagName("developer")[0];
    var developer = developers.getElementsByTagName("Person")[0];
    var developer_name = developer.getElementsByTagName("name")[0].childNodes[0].nodeValue;
    // To get the name of foaf file, doap should have a developer seeAlso tag
    // the following is a hack to get wikier.foaf
    //var developer_homepage = developer.getElementsByTagName("homepage")[0].attributes[0].value;
    //var developer_foaf = developer_homepage.replace('http://www.','');
    //var developer_foaf = developer_foaf.replace('.org/','.foaf');

    //var developer_seeAlso = developer.getElementsByTagName("seeAlso")[0].attributes[0].value;
    var developer_foaf = "wikier.foaf";
    // Do not why the following line gives errors
    //var ml_url = project.getElementsByTagName("mailing-list")[0].attributes[0].value;
    var ml_href = project.getElementsByTagName("mailing-list")[0];
    var wiki_href = project.getElementsByTagName("wiki")[0].attributes[0].value;
    var bug_href = project.getElementsByTagName("bug-database")[0].attributes[0].value;
    var download_href = project.getElementsByTagName("download-page")[0].attributes[0].value;
    var mirror_href = project.getElementsByTagName("download-mirror")[0].attributes[0].value;
    var repositorys = project.getElementsByTagName("repository")[0];
    var repository = repositorys.getElementsByTagName("SVNRepository")[0];
    var repository_browse = repository.getElementsByTagName("browse")[0].attributes[0].value;

    var tree = YAHOO.qualipsoa4.knowledgeboard.treeProjectDOAP;
    var projectNode = tree.getNodeByProperty("label","Project");
    if (projectNode == null) {
        projectNode = new YAHOO.widget.TextNode({label:"Project"}, tree.getRoot() , true);
    } else {
        tree.removeChildren(projectNode);
    }
    new YAHOO.widget.TextNode({label:"Project name:" + name, href:project_href, target:"_"}, projectNode , false);
    new YAHOO.widget.TextNode({label:"License:" + license_href, href:license_href, target:"_"}, projectNode , false);
    new YAHOO.widget.TextNode({label:"Description: "+shortdesc}, projectNode , false);
    new YAHOO.widget.TextNode({label:"Language: "+language}, projectNode , false);
    new YAHOO.widget.TextNode({label:"Last release: "+last_release_name}, projectNode, false);
    new YAHOO.widget.TextNode({label:"Developer: "+developer_name, foaf:developer_foaf}, projectNode, false);
    //new YAHOO.widget.TextNode({label:"Mailing lists: "+"SWAML", foaf:developer_foaf}, projectNode, false);
    new YAHOO.widget.TextNode({label:"Mailing lists: "+ml_href, sioc:"swamlML.sioc"}, projectNode, false);
    new YAHOO.widget.TextNode({label:"Wiki: "+wiki_href, href:wiki_href}, projectNode, false);
    new YAHOO.widget.TextNode({label:"Bugs: "+bug_href, href:bug_href}, projectNode, false);
    new YAHOO.widget.TextNode({label:"Download: "+download_href, href:download_href}, projectNode, false);
    new YAHOO.widget.TextNode({label:"Mirror: "+mirror_href, href:mirror_href}, projectNode, false);
    new YAHOO.widget.TextNode({label:"Repositorys: "}, projectNode, false);
    new YAHOO.widget.TextNode({label:"Repository browse: "+repository_browse, href:repository_browse}, projectNode, false);
    tree.draw();
    projectNode.expand();

    //doap += "<ul>";
    //doap += "<li>Project name: "+ name +"</li>\n";
    //doap += "<li>Project URL: <a href='"+ project_url +"'>" + project_url + "</a></li>\n";
    //doap += "<li>Short description:"+ shortdesc +"</li>\n";
    //doap += "<li>Language: "+ language +"</li>\n";
    //doap += "<li>Last release: "+ last_release_name +"</li>\n";
    //doap += "<li>Developer: "+ developer_name +"</li>\n";
    //doap += "<li>Mailing list: <a href='"+ ml_url +"'>" + ml_url + "</a></li>\n";
    //doap += "<li>Wiki: <a href='"+ wiki_url +"'>" + wiki_url + "</a></li>\n";
    //doap += "<li>Bugs: <a href='"+ bug_url +"'>" + bug_url + "</a></li>\n";
    //doap += "<li>Download: <a href='"+ download_url +"'>" + download_url + "</a></li>\n";
    //doap += "<li>Mirror: <a href='"+ mirror_url +"'>" + mirror_url + "</a></li>\n";
    //doap += "<li>Repositorys: </li>\n";
    //doap += "<li>Repository browse: <a href='"+ repository_browse +"'>" + repository_browse + "</a></li>\n";
    //doap += "</ul>";
    YAHOO.qualipsoa4.knowledgeboard.panelProjectDOAP.setFooter("DOAP file created: " + foafcreated);
    return doap;
}

// We use a Tree to show the data and try to capture events
function parseSIOC (contents) {
    var sioc = "";
    // http://developer.mozilla.org/en/docs/DOMParser
    var parser = new DOMParser();
    var myXMLDoc = parser.parseFromString(contents, "text/xml");

    var forum = myXMLDoc.getElementsByTagName("Forum")[0];
    var dateSIOC = forum.getElementsByTagName("date")[0].childNodes[0].nodeValue;
    var title = forum.getElementsByTagName("title")[0].childNodes[0].nodeValue;
    var description = forum.getElementsByTagName("description")[0].childNodes[0].nodeValue;
    var posts = forum.getElementsByTagName("container_of");
    var subscribers = forum.getElementsByTagName("has_subscriber");
    sioc += "<ul>\n";
    sioc += "<li>Title: "+title+"</li>\n";
    sioc += "<li>Description: "+description+"</li>\n";
    //sioc += "<li>Date: "+dateSIOC+"</li>\n";
    sioc += "</ul>\n";
    sioc += "<b>Forum contents</b>\n";
    //sioc += "<ul>";
    var treePosts = YAHOO.qualipsoa4.knowledgeboard.treeProjectSIOCPosts;
    var postsNode = treePosts.getNodeByProperty("label","Posts");
    if (postsNode == null) {
        postsNode = new YAHOO.widget.TextNode({label:"Posts"}, treePosts.getRoot() , false);
    } else {
        treePosts.removeChildren(postsNode);
    }
    for (var i = 0; i < posts.length; i++) {
        // http://swaml.berlios.de/demos/swaml-devel/2007-Jun/post-43: change berlios by localhost
        var posthref = posts[i].attributes[0].value;
        // var postURLlocal = postURL.replace("swaml.berlios.de", "localhost/QualiPSo-YahooUI/qualipso/KnowledgeBoard/posts");
        var posthreflocal = posthref.replace("http://swaml.berlios.de", "posts");
        var postRDFlocal = posthreflocal.replace(posthreflocal, posthreflocal + ".rdf");
        var postXHTMLlocal = posthreflocal.replace(posthreflocal, posthreflocal + ".xhtml");
        //var tmpNode = new YAHOO.widget.TextNode("Post " + i, tree.getRoot() , false);
        var tmpNode = new YAHOO.widget.TextNode({label:"Post " + i, rdf:postRDFlocal, xhtml:postXHTMLlocal}, postsNode , false);
    }
    treePosts.draw();
    //var tmpNode = new YAHOO.widget.TextNode({label: i, url:postURLlocal}, tree.getRoot() , false);
    var treeSubscribers = YAHOO.qualipsoa4.knowledgeboard.treeProjectSIOCSubscribers;
    var subscribersNode = treeSubscribers.getNodeByProperty("label","Subscribers");
    if (subscribersNode == null) {
        subscribersNode = new YAHOO.widget.TextNode({label:"Subscribers"}, treeSubscribers.getRoot() , false);
    } else {
        treeSubscribers.removeChildren(subscribersNode);
    }
    for (var i = 0; i < subscribers.length; i++) {
        //    // http://swaml.berlios.de/demos/swaml-devel/2007-Jun/post-43: change berlios by localhost
        var subscriberhref = posts[i].attributes[0].value;
        //    // var postURLlocal = postURL.replace("swaml.berlios.de", "localhost/QualiPSo-YahooUI/qualipso/KnowledgeBoard/posts");
        var subscriberhreflocal = subscriberhref.replace("http://swaml.berlios.de", "posts");
        //    //var tmpNode = new YAHOO.widget.TextNode("Post " + i, tree.getRoot() , false);
        var tmpNode = new YAHOO.widget.TextNode({label:"Subscriber " + i, href:subscriberhreflocal}, subscribersNode , false);
    }
    treeSubscribers.draw();
    YAHOO.qualipsoa4.knowledgeboard.panelProjectSIOC.setFooter("SIOC file date: " + dateSIOC);

    return sioc;
}


function parseSIOCPost (contents) {
    var sioc = "";
    // http://developer.mozilla.org/en/docs/DOMParser
    var parser = new DOMParser();
    var myXMLDoc = parser.parseFromString(contents, "text/xml");

    var post = myXMLDoc.getElementsByTagName("Post")[0];
    var title = post.getElementsByTagName("title")[0].childNodes[0].nodeValue;
    var date = post.getElementsByTagName("created")[0].childNodes[0].nodeValue;
    var content = post.getElementsByTagName("content")[0].childNodes[0].nodeValue;
    var link = post.getElementsByTagName("link")[0].attributes[0].value;
    var creator = post.getElementsByTagName("has_creator")[0].attributes[0].value;
    var next_by_date = post.getElementsByTagName("next_by_date")[0].attributes[0].value;
    var id = post.getElementsByTagName("content")[0].childNodes[0].nodeValue;
    var previous_by_date = post.getElementsByTagName("previous_by_date")[0].attributes[0].value;
    var reply_of = post.getElementsByTagName("reply_of")[0].attributes[0].value;

    sioc += "<ul>\n";
    //sioc += "<li>Id: " + id + "</li>\n";
    sioc += "<li>Title: " + title + "</li>\n";
    //sioc += "<li>Date: " + date + "</li>\n";
    sioc += "</ul>\n";
    //sioc += "<b>Post content</b><br>\n";
    //sioc +=  content;
    //YAHOO.qualipsoa4.knowledgeboard.panelProjectSIOC.setFooter("SIOC file date: " + date);


    var tree = YAHOO.qualipsoa4.knowledgeboard.treeProjectSIOCPost;
    new YAHOO.widget.TextNode({label:"link:" + link, href:link, target:"_"}, tree.getRoot() , false);
    new YAHOO.widget.TextNode({label:"creator:" + creator, href:creator, target:"_"}, tree.getRoot() , false);
    new YAHOO.widget.TextNode({label:"next_by_date:" + next_by_date, href:next_by_date, target:"_"}, tree.getRoot() , false);
    new YAHOO.widget.TextNode({label:"previous_by_date:" + previous_by_date, href:previous_by_date, target:"_"}, tree.getRoot() , false);
    new YAHOO.widget.TextNode({label:"reply_of:" + reply_of, href:reply_of, target:"_"}, tree.getRoot() , false);
    tree.draw();

    return sioc;
}

function parseSIOCContent (contents) {
    var content = "<html>\n<body>\n<pre>";

    var parser = new DOMParser();
    var myXMLDoc = parser.parseFromString(contents, "text/xml");

    content = myXMLDoc.getElementsByTagName("pre")[0].childNodes[0].nodeValue;
    content += "</body>\n</html>\n</pre>";
    return content;
}


// http://developer.mozilla.org/en/docs/Parsing_and_serializing_XML
function parseRSS (contents) {
    var rssHeaders = "";
    // http://developer.mozilla.org/en/docs/DOMParser
    var parser = new DOMParser();
    var myXMLDoc = parser.parseFromString(contents, "text/xml");

    var channel = myXMLDoc.getElementsByTagName("channel")[0];
    var title = channel.getElementsByTagName("title")[0];
    var link = channel.getElementsByTagName("link")[0];
    var description = channel.getElementsByTagName("description")[0];
    var language = channel.getElementsByTagName("language")[0];
    var generator = channel.getElementsByTagName("generator")[0];
    var image = channel.getElementsByTagName("image")[0];
    var items = channel.getElementsByTagName("item");

    var tree = YAHOO.qualipsoa4.knowledgeboard.panelRSSTree;
    for (var i = 0; i < items.length; i++) {
        var titleItem = items[i].getElementsByTagName("title")[0];
        var description = items[i].getElementsByTagName("description")[0];
        var tmpNode = new YAHOO.widget.TextNode(titleItem.childNodes[0].nodeValue, tree.getRoot() , false);  
        var tmpNode1 = new YAHOO.widget.HTMLNode(description.childNodes[0].nodeValue, tmpNode , false);  
    }
    tree.draw();
    return rssHeaders;
}

function parseSPARQL (contents) {
    var sparql = "Tags for Mailing List";
    // http://developer.mozilla.org/en/docs/DOMParser
    var parser = new DOMParser();
    var myXMLDoc = parser.parseFromString(contents, "text/xml");

    var results = myXMLDoc.getElementsByTagName("result");

    var tree = YAHOO.qualipsoa4.knowledgeboard.panelSPARQLTree;
    //<result>
    //  <binding name='label'>
    //    <literal>Requirement</literal>
    //  </binding>
    //</result>
    for (var i = 0; i < results.length; i++) {
        var binding = results[i].getElementsByTagName("binding")[0];           
        var bindLabel = binding.attributes[0].value;
        var bindValue = binding.getElementsByTagName("literal")[0].childNodes[0].nodeValue;
        var tmpNode = new YAHOO.widget.TextNode(bindValue, tree.getRoot() , false);  
    }
    tree.draw();
    return sparql;
}



YAHOO.util.Event.addListener(window, "load", init);
