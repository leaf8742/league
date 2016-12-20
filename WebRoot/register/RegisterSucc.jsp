<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="pageTitle">Duke足球联赛: 注册联赛成功</c:set>

<html>
    <head>
        <base href="<%=basePath%>">
        <title>${pageTitle}</title>
    </head>
    <body bgcolor='white'>
        <!-- Page Heading -->
        <table border='1' cellpadding='5' cellspacing='0' width='400'>
            <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
                <td><h3>${pageTitle}</h3></td>
            </tr>
        </table>
        
        <p>
           ${player.name}, 非常感谢您注册 <i>${league.title}</i> 联赛。
        </p>
        <a href='../'>回首页</a>
    </body>
</html>