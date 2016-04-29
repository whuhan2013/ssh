<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align: center;">
  	<s:form action="user_editUser" namespace="/user" enctype="multipart/form-data">
  			<s:hidden name="id" value="%{#user.id}"></s:hidden>
   			<s:textfield name="username" label="登录名" value="%{#user.username}"></s:textfield>
   			<s:password name="password" label="密码"></s:password>
   			<s:textfield name="nick" label="昵称" value="%{#user.nick}"></s:textfield>
   			<s:radio label="性别" list="#{'1':'男','0':'女'}" value="#user.sex" name="sex"></s:radio>
   			<s:select label="学历" name="education" list="#{'研究生':'研究生','本科':'本科','专科':'专科','高中':'高中'}" value="#user.education" headerKey="" headerValue="请选择"></s:select>
   			<s:textfield name="birthday" label="出生日期" value="%{#user.birthday}"></s:textfield>
   			<s:textfield name="telephone" label="电话号码" value="%{#user.telephone}"></s:textfield>
   			<s:checkboxlist list="{'足球','篮球','乒乓球','羽毛球'}" name="hobbies" label="兴趣爱好" value="#user.hobbies"></s:checkboxlist>
   			<s:file name="image" label="照片"></s:file>
   			<s:textarea name="remark" label="简介" value="%{#user.remark}"></s:textarea>
   			<s:submit value="保存"></s:submit>
    </s:form>
    <s:debug></s:debug>
  </body>
</html>
