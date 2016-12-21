<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<c:set scope="request" var="pageTitle" value="Duke足球联赛：首页"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${pageTitle}</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
    <body bgcolor='white'>
        <table border='0' width='800' cellspacing='0' cellpadding='5' align="center">
            <tr>
                <td width="200" align='center' valign='middle'>
                    <%@include file="/WEB-INF/jspf/common/logo.jsp" %>
                </td>
                <td width="600" align='center' bgcolor='#CCCCFF' valign='middle'>
                    <jsp:include page="/WEB-INF/jspf/common/banner.jsp">
                    <jsp:param value="Index" name="subTitle" />
                    </jsp:include>
                </td>
            </tr>

            <tr>
                <td bgcolor='#CCCCFF' align='left' valign='top' height="300">
                    <%@include file="/WEB-INF/jspf/common/navigation.jsp" %>
                </td>
                <td align='left' valign='top'>
                    <jsp:include page="/WEB-INF/jspf/indexBody.jsp" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align='right'>
                    <%@include file="/WEB-INF/jspf/common/footer.jsp" %>
                </td>
            </tr>
        </table>
    </body>
</html>
