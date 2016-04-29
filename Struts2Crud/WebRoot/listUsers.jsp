<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示所有的用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align: center;">
    	<table width="88%">
    		<tr>
    			<td>
    				<s:form action="user_queryCondition" namespace="/user">
    					<s:textfield name="username" label="用户名"></s:textfield>
    					<s:select list="#{'0':'女','1':'男'}" label="性别" name="sex" headerKey="" headerValue="请选择"></s:select>
    					<s:select label="学历" name="education" list="#{'研究生':'研究生','本科':'本科','专科':'专科','高中':'高中'}" headerKey="" headerValue="请选择"></s:select>
    					<s:submit value="查询"></s:submit>
    				</s:form>
    			</td>
    		</tr>
    		<tr>
    			<td align="center">用户列表</td>
    		</tr>
    		<tr>
    			<td align="right">
    				<a href="${pageContext.request.contextPath}/addUser.jsp">添加</a>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<table frame="border" width="100%">
    					<tr>
    						<th>用户名</th>
    						<th>姓名</th>
    						<th>性别</th>
    						<th>联系电话</th>
    						<th>学历</th>
    						<th>编辑</th>
    						<th>查看</th>
    						<th>删除</th>
    					</tr>
    					<s:iterator value="#users" var="user" status="vs">
    						<tr bgcolor="<s:property value='#vs.even?"#A6A6A6":"#627C8C"'/>">
	    						<td><s:property value="#user.username"/></td>
	    						<td><s:property value="#user.nick"/></td>
	    						<td><s:property value="#user.sex==0?'女':'男'"/></td>
	    						<td><s:property value="#user.telephone"/></td>
	    						<td><s:property value="#user.education"/></td>
	    						<td>
	    							<s:url action="user_editUserUI" namespace="/user" var="url">
	    								<s:param name="userId" value="#user.id"></s:param>
	    							</s:url>
	    							<a href="<s:property value='url'/>">修改</a>
	    						</td>
	    						<td>
	    							<s:url action="user_showUser" namespace="/user" var="url">
	    								<s:param name="userId" value="#user.id"></s:param>
	    							</s:url>
	    							<a href="<s:property value='url'/>">查看</a>
	    						</td>
	    						<td>
	    							<s:url action="user_delUser" namespace="/user" var="url">
	    								<s:param name="userId" value="#user.id"></s:param>
	    							</s:url>
	    							<a href="<s:property value='url'/>">删除</a>
	    						</td>
	    					</tr>
    					</s:iterator>
    				</table>
    			</td>
    		</tr>
    	</table>
  </body>
</html>
