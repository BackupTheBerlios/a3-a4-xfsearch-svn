/*
* Functions for the mailing list plugin
*/


/*
* Information data, this information is loaded by the plugin and stored in memory
* the information is only refreshed pushing the mailing list widget
*/

var mailListRDF;


/*
* Configuration params (for development, ad-hoc code)
*/

var emailsInfoUrl = "mailList.rdf";
//var emailsInfoUrl = "qualipso.rdf";
var qualipsoMailListID = "http://www.qualipso.org/ontology/doc/qualipso_maillinglist#Mail";



function pluginMailListInit()
{
 panelProjectMLListPostsInit();
 panelProjectMLPostInit();
 treeProjectMLListPostsInit();
 treeProjectMLPostInit();
}


/*
* Panel with email list
*/
function panelProjectMLListPostsInit() {

    YAHOO.qualipsoa4.knowledgeboard.panelProjectMLListPosts =
    new YAHOO.widget.Panel("panelProjectMLListPosts", {
        visible:true,
        width:"360px",
        height:"450px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelTools','tr','br']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelProjectMLListPosts.setHeader("Project Mailing List Emails");
    YAHOO.qualipsoa4.knowledgeboard.panelProjectMLListPosts.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelProjectMLListPosts.render(document.body);
    makeRequestEmailsList(emailsInfoUrl);
}

/*
* Panel with the information of the selected email
*/
function panelProjectMLPostInit() {
    //
    YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost =
    new YAHOO.widget.Panel("panelProjectMLPost", {
        visible:false,
        width:"400px",
        height:"450px",
        constraintoviewport:true,
        effect:{ effect: YAHOO.widget.ContainerEffect.FADE,duration: 0.5},
        context:['panelProjectMLListPosts','tr','tl']
    });
    YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost.setHeader("Email information");
    YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost.setBody("");
    YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost.setFooter("");
    YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost.render(document.body);
}

/*
function treeProjectMLInit() {
    // Tree View for DOAP Project info
    YAHOO.qualipsoa4.knowledgeboard.treeProjectML = new YAHOO.widget.TreeView("treeProjectML");
    YAHOO.qualipsoa4.knowledgeboard.treeProjectML.subscribe("labelClick", onTreeProjectMLClick)
}
*/

function treeProjectMLListPostsInit() {

    YAHOO.qualipsoa4.knowledgeboard.treeProjectMLListPosts = new YAHOO.widget.TreeView("treeProjectMLListPosts");
    YAHOO.qualipsoa4.knowledgeboard.treeProjectMLListPosts.subscribe("labelClick", onTreeProjectMLPostClick);
}


function treeProjectMLPostInit() {
    YAHOO.qualipsoa4.knowledgeboard.HTMLCodeProjectMLPosts = new YAHOO.widget.HTMLNode("treeProjectMLPost");
    YAHOO.qualipsoa4.knowledgeboard.treeProjectMLContact = new YAHOO.widget.TreeView("treeProjectMLContact");
    YAHOO.qualipsoa4.knowledgeboard.treeProjectMLContact.subscribe("labelClick", onTreeProjectMLContact);

    new YAHOO.widget.HTMLNode("Email contacts: ", YAHOO.qualipsoa4.knowledgeboard.treeProjectMLContact.getRoot() , false);
    
}


function onTreeProjectMLContact(node) {
   if ( YAHOO.qualipsoa4.knowledgeboard.panelPerson != null)
   {
    YAHOO.qualipsoa4.knowledgeboard.panelPerson.show();
    YAHOO.qualipsoa4.knowledgeboard.panelPerson.focus();
    YAHOO.qualipsoa4.knowledgeboard.panelPerson.setHeader(node.data.label);
    makeRequestPerson("http://contact/" + node.data.url);
   }
   else
	alert("No people information plugin");

}

function onTreeProjectMLPostClick(node) {
  YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost.show();
  YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost.focus();
  makeRequestEmail(node.data.url);

}




/*
* Information request functions
*/

function makeRequestEmail( emailResourceID ) {
 
   var subject = parseEmail(emailResourceID);

   if (subject != null)
	   YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost.setHeader(subject);

}




function makeRequestEmailsList( sUrl ) {
     var request = YAHOO.util.Connect.asyncRequest( 'GET', sUrl,
        {
            success : handleRequestEmailsListSuccess,
            failure : handleRequestEmailsListFailure
        }
    );
}

function handleRequestEmailsListSuccess( o ) {
   if ( o.responseText !== undefined ) {
        var content  = o.responseText;
        var nEmails =  parseMailListRDF (content);
	YAHOO.qualipsoa4.knowledgeboard.panelProjectMLListPosts.setFooter(nEmails + " emails.");

    }
}

function handleRequestEmailsListFailure( o ){
    if ( o.responseText !== undefined ) {
        alert( 'Couldn\'t load the content: ' + o.statusText );
    }
}


/*
* Information parsers
*/


function generateEmailHTML( from, to, cc, date, subject, body)
{
 var emailHTML = "<STRONG><A1>From:</A1></STRONG> " + from  + " " + date + "<br>" +
		"<STRONG>To:</STRONG> " + to  +	"<br>" +
		"<STRONG>Cc:</STRONG> " + cc  +	"<br>" +
		"<STRONG>Subject:</STRONG> " + subject + "<br>" +
		"<hr>" +
		body;

  return emailHTML;

}


function parseEmail ( emailResourceID)
{

  var mailList = mailListRDF.getElementsByTagName("Description");

    if (mailList == null || mailList.length == 0)
	return;

    var HTMLCode = YAHOO.qualipsoa4.knowledgeboard.panelProjectMLPost;

    treeProjectMLPostInit();
    var contactTree = YAHOO.qualipsoa4.knowledgeboard.treeProjectMLContact;


    var n = mailList.length;
  
    for (i=0; i < n ; i++){

	var type= mailList[i].getElementsByTagName("type");
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

		if (typeName == qualipsoMailListID)
		{	
			var resourceEmail = mailList[i].attributes[0].nodeValue;
			if ( resourceEmail == emailResourceID)
			{
				var subject = mailList[i].getElementsByTagName("subject")[0].childNodes[0].nodeValue;
				var body  = mailList[i].getElementsByTagName("content")[0].childNodes[0].nodeValue;
				var date = mailList[i].getElementsByTagName("modified_at")[0].childNodes[0].nodeValue;
				var from = mailList[i].getElementsByTagName("from")[0].childNodes[0].nodeValue;
				
				var to = "";

				new YAHOO.widget.TextNode({label: from, url:from}, contactTree.getRoot() , false);
				
				if (mailList[i].getElementsByTagName("to")!= null)
				{
					toInformation = mailList[i].getElementsByTagName("to");
					nTo = toInformation.length;
					for (j=0 ; j < nTo ; j++)
					{
						to = to + toInformation[j].childNodes[0].nodeValue + " ";
						new YAHOO.widget.TextNode({label: toInformation[j].childNodes[0].nodeValue, 
									   url:toInformation[j].childNodes[0].nodeValue}, 
									    contactTree.getRoot() , false);
					}
					
				}
				
				var cc = "";
				
				if (mailList[i].getElementsByTagName("cc")!= null)
				{
					ccInformation = mailList[i].getElementsByTagName("cc");
					nCc = ccInformation.length;
					for (j=0 ; j < nCc ; j++)
					{
						cc = cc + ccInformation[j].childNodes[0].nodeValue + " ";
						new YAHOO.widget.TextNode({label: ccInformation[j].childNodes[0].nodeValue, 
									   url:ccInformation[j].childNodes[0].nodeValue}, 
									    contactTree.getRoot() , false);
					}
					
				}
				
				
				var emailHTML = generateEmailHTML( from, to, cc, date, subject, body);
				
				HTMLCode.setBody(emailHTML);
				


				break;
			}
			
		}
	}
	else
		alert("No type for this resource");
    }
	
    HTMLCode.render(document.body);
    contactTree.draw();

    if (subject != null && subject != "")
	return subject;
    else
	return null;

}

function parseMailListRDF (contents) {
   
    var doap = "";
   // alert(contents);

    var parser = new DOMParser();
    
    mailListRDF = parser.parseFromString(contents, "application/xml");

    var mailList = mailListRDF.getElementsByTagName("Description");

    if (mailList == null || mailList.length == 0)
	return;

    var mboxTree = YAHOO.qualipsoa4.knowledgeboard.treeProjectMLListPosts;
    new YAHOO.widget.HTMLNode("Emails by subject: ", mboxTree.getRoot() , false);

    var n = mailList.length;
    var nEmails = 0;
  
   for (i=0; i < n ; i++){

	var type= mailList[i].getElementsByTagName("type");
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

		if (typeName == qualipsoMailListID)
		{	
			nEmails++;
			var resourceEmail = mailList[i].attributes[0].nodeValue;
			var subject = mailList[i].getElementsByTagName("subject")[0].childNodes[0].nodeValue;
			//alert(mailList[i].getElementsByTagName("subject").name + " " + mailList[i].getElementsByTagName("subject").value);
			new YAHOO.widget.TextNode({label: subject, url:resourceEmail}, mboxTree.getRoot() , false);
			//alert(mailList[i].getElementsByTagName("subject")[0].childNodes[0].nodeValue);
			//alert(mailList[i].getElementsByTagName("content")[0].childNodes[0].nodeValue);
			//alert(mailList[i].getElementsByTagName("modified_at")[0].childNodes[0].nodeValue);
			//alert(mailList[i].getElementsByTagName("from")[0].childNodes[0].nodeValue);
			
		}
	}
	else
		alert("No type for this resource");
    }


    mboxTree.draw();
  
    return nEmails;

}



