<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查看用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align: center;">
  	登录名：<s:property value="#user.username"/><br/>
  	昵称:<s:property value="#user.nick"/><br/>
  	性别：<s:property value="#user.sex==0?'女':'男'"/><br/>
  	学历:<s:property value="#user.education"/><br/>
  	兴趣爱好：<s:property value="#user.hobby"/><br/>
  	照片：
  		<c:url value="/user/download" var="url">
  			<c:param name="path" value="${user.path}"></c:param>
  			<c:param name="filename" value="${user.filename}"></c:param>
  		</c:url>
  		<a href="${url}">下载</a>
  		<s:debug></s:debug>
  </body>
</html>
