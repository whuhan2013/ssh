<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax调用web服务</title>
<script type="text/javascript">
var xmlHttpReq;    //用于保存XMLHttpRequest对象的全局变量

//用于创建XMLHttpRequest对象
function createXmlHttp() {
    //根据window.XMLHttpRequest对象是否存在使用不同的创建方式
//    if (window.XMLHttpRequest) {
//       xmlHttp = new XMLHttpRequest();                  //FireFox、Opera等浏览器支持的创建方式
//   } else {
//      xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");//IE浏览器支持的创建方式
//    }
	if (window.ActiveXObject) {
		xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttpReq = new XMLHttpRequest();
	}
}

function loadAjax() {
   
	createXmlHttp();                        //创建XmlHttpRequest对象
	 
	  
	
	var url="http://localhost:8080/AndroidStruts2JSON/login.action?userName=admin&password=123456&date="+new Date();
	//xmlHttpReq.open("get", encodeURI(encodeURI(url+param,"UTF-8"),"UTF-8"), true);
	xmlHttpReq.open("get", encodeURI(encodeURI(url,"UTF-8"),"UTF-8"), true);//上传图片
	xmlHttpReq.setrequestheader("content-type","application/x-www-form-urlencoded");//post提交设置项
	xmlHttpReq.onreadystatechange = loadCallback;  //IE这里设置回调函数
	xmlHttpReq.send(null);
	
}


function loadCallback() {
    
	//alert(xmlHttpReq.readyState);
    if (xmlHttpReq.readyState == 4) {
       alert("aa");
		//if(xmlHttpReq.status==200){
		document.getElementById("contentDiv").innerHTML=xmlHttpReq.responseText;
		//}
    }
}


</script>

<body>
<div id="contentTypeDiv">
</div>
<br/><br/>
<div id="contentDiv">
</div>




<input type="button" value="调用" onclick="loadAjax()">

</body>
</head>
</html>
