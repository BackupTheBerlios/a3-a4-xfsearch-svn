function org_qualipso_advdoc_advtools_semsearch_SemanticSearchMain(){var l=window,k=document,t=l.external,ab,w,q,p='',z={},db=[],F=[],o=[],C,E;if(!l.__gwt_stylesLoaded){l.__gwt_stylesLoaded={};}if(!l.__gwt_scriptsLoaded){l.__gwt_scriptsLoaded={};}function v(){try{return t&&(t.gwtOnLoad&&l.location.search.indexOf('gwt.hybrid')== -1);}catch(a){return false;}}
function y(){if(ab&&w){var c=k.getElementById('org.qualipso.advdoc.advtools.semsearch.SemanticSearchMain');var b=c.contentWindow;b.__gwt_initHandlers=org_qualipso_advdoc_advtools_semsearch_SemanticSearchMain.__gwt_initHandlers;if(v()){b.__gwt_getProperty=function(a){return r(a);};}org_qualipso_advdoc_advtools_semsearch_SemanticSearchMain=null;b.gwtOnLoad(C,'org.qualipso.advdoc.advtools.semsearch.SemanticSearchMain',p);}}
function s(){var j,h='__gwt_marker_org.qualipso.advdoc.advtools.semsearch.SemanticSearchMain',i;k.write('<script id="'+h+'"><\/script>');i=k.getElementById(h);j=i&&i.previousSibling;while(j&&j.tagName!='SCRIPT'){j=j.previousSibling;}function d(b){var a=b.lastIndexOf('/');return a>=0?b.substring(0,a+1):'';}
;if(j&&j.src){p=d(j.src);}if(p==''){var c=k.getElementsByTagName('base');if(c.length>0){p=c[c.length-1].href;}else{var g=k.location;var e=g.href;p=d(e.substr(0,e.length-g.hash.length));}}else if(p.match(/^\w+:\/\//)){}else{var f=k.createElement('img');f.src=p+'clear.cache.gif';p=d(f.src);}if(i){i.parentNode.removeChild(i);}}
function D(){var f=document.getElementsByTagName('meta');for(var d=0,g=f.length;d<g;++d){var e=f[d],h=e.getAttribute('name'),b;if(h){if(h=='gwt:property'){b=e.getAttribute('content');if(b){var i,c=b.indexOf('=');if(c>=0){h=b.substring(0,c);i=b.substring(c+1);}else{h=b;i='';}z[h]=i;}}else if(h=='gwt:onPropertyErrorFn'){b=e.getAttribute('content');if(b){try{E=eval(b);}catch(a){alert('Bad handler "'+b+'" for "gwt:onPropertyErrorFn"');}}}else if(h=='gwt:onLoadErrorFn'){b=e.getAttribute('content');if(b){try{C=eval(b);}catch(a){alert('Bad handler "'+b+'" for "gwt:onLoadErrorFn"');}}}}}}
function n(a,b){return b in db[a];}
function m(a){var b=z[a];return b==null?null:b;}
function cb(d,e){var a=o;for(var b=0,c=d.length-1;b<c;++b){a=a[d[b]]||(a[d[b]]=[]);}a[d[c]]=e;}
function r(d){var e=F[d](),b=db[d];if(e in b){return e;}var a=[];for(var c in b){a[b[c]]=c;}if(E){E(d,a,e);}throw null;}
F['user.agent']=function(){var d=navigator.userAgent.toLowerCase();var b=function(a){return parseInt(a[1])*1000+parseInt(a[2]);};if(d.indexOf('opera')!= -1){return 'opera';}else if(d.indexOf('webkit')!= -1){return 'safari';}else if(d.indexOf('msie')!= -1){var c=/msie ([0-9]+)\.([0-9]+)/.exec(d);if(c&&c.length==3){if(b(c)>=6000){return 'ie6';}}}else if(d.indexOf('gecko')!= -1){var c=/rv:([0-9]+)\.([0-9]+)/.exec(d);if(c&&c.length==3){if(b(c)>=1008)return 'gecko1_8';}return 'gecko';}return 'unknown';};db['user.agent']={'gecko':0,'gecko1_8':1,'ie6':2,'opera':3,'safari':4};org_qualipso_advdoc_advtools_semsearch_SemanticSearchMain.onInjectionDone=function(){ab=true;y();};org_qualipso_advdoc_advtools_semsearch_SemanticSearchMain.onScriptLoad=function(){w=true;y();};s();D();var bb;if(v()){bb='hosted.html?org_qualipso_advdoc_advtools_semsearch_SemanticSearchMain';}else{try{cb(['safari'],'2ED96F16EA0A40078249323FE4F2FB48');cb(['ie6'],'4C42A41CD35F979DD425E10BFB404C3E');cb(['gecko'],'6A5295C8C380115FC066B5A370B1BB51');cb(['gecko1_8'],'8EC36191C767A9D090715FC7FFF31967');cb(['opera'],'A7153EA397FB2E5C8088EE29033E5524');bb=o[r('user.agent')];}catch(a){return;}bb+='.cache.html';}var B;function A(){if(!q){q=true;y();if(k.removeEventListener){k.removeEventListener('DOMContentLoaded',A,false);}if(B){clearInterval(B);}}}
var u;function x(){if(!u){u=true;var a=k.createElement('iframe');a.src="javascript:''";a.id='org.qualipso.advdoc.advtools.semsearch.SemanticSearchMain';a.style.cssText='position:absolute;width:0;height:0;border:none';k.body.appendChild(a);a.src=p+bb;}}
if(k.addEventListener){k.addEventListener('DOMContentLoaded',function(){x();A();},false);}var B=setInterval(function(){if(/loaded|complete/.test(k.readyState)){x();A();}},50);if(!__gwt_stylesLoaded['styles/semsearch.css']){__gwt_stylesLoaded['styles/semsearch.css']=true;document.write('<link rel="stylesheet" href="'+p+'styles/semsearch.css">');}k.write("<script>org_qualipso_advdoc_advtools_semsearch_SemanticSearchMain.onInjectionDone('org.qualipso.advdoc.advtools.semsearch.SemanticSearchMain')<\/script>");}
org_qualipso_advdoc_advtools_semsearch_SemanticSearchMain.__gwt_initHandlers=function(i,e,j){var d=window,g=d.onresize,f=d.onbeforeunload,h=d.onunload;d.onresize=function(a){try{i();}finally{g&&g(a);}};d.onbeforeunload=function(a){var c,b;try{c=e();}finally{b=f&&f(a);}if(c!=null){return c;}if(b!=null){return b;}};d.onunload=function(a){try{j();}finally{h&&h(a);}};};org_qualipso_advdoc_advtools_semsearch_SemanticSearchMain();