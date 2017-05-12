<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testListMap.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		迭代map:<br>
  		<s:iterator>
  			<!-- 
  				key表示emap2中的key值
  				value表示emap2中的value值
  			 -->
  			<s:property value="key"/>
  			<s:property value="value"/>
  		</s:iterator>
  		<br>
  		迭代list,但是list中含有map:<br>
  		内存结构:
  		map["emList",value],
  		value为
  			[
  			  {d1=D-enum, c1=6.7, b1=5, a1=A-enum}, 
  			  {d1=D1-enum, c1=C1-enum, b1=B1-enum, a1=A1-enum}, 
  			  {d1=D2-enum, c1=C2-enum, b1=B2-enum, a1=A2-enum}
  			 ]
  		<br>
  		<s:iterator value="emList">
  			<s:iterator value="top">
  				<s:property value="key"/>
  				<s:property value="value"/>
  			</s:iterator>
  		</s:iterator>
  </body>
</html>
