<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<table border='1' cellspacing='0' cellpadding='0' width='400'>
    <tr height='30'>
        <td bgcolor='#CCCCFF' align='center' valign='middle' height='30'>
            <b>1) 输入球员信息</b>
        </td>
        <td bgcolor='#CCCCCC' align='center' valign='middle' height='30'>
            <b>2) 选择联赛和分组</b>
        </td>
    </tr>
</table>
<br/><font color='red'><s:actionerror /></font>

<form action='<c:url value="register/EnterPlayer.action" />' method='POST'>
    <table>
        <tr>
            <td>姓 名：<input type='text' name='name' value='${param.name}' /><br/><br/></td>
            <td>
                <font color='red' size="-1">
                    <i><s:fielderror><s:param>name</s:param></s:fielderror></i>
                </font>
            </td>
        </tr>
        <tr>
            <td>地 址：<input type='text' name='address' value='${param.address}' /><br/><br/></td>
            <td>
                <font color='red' size="-1">
                    <i><s:fielderror><s:param>address</s:param></s:fielderror></i>
                </font>
            </td>
        </tr>
        <tr>
            <td>城 市：<input type='text' name='city' value='${param.city}' /><br/><br/></td>
            <td>
                <font color='red' size="-1">
                    <i><s:fielderror><s:param>city</s:param></s:fielderror></i>
                </font>
            </td>
        </tr>
        <tr>
            <td>邮 箱：<input type='text' name='email' value='${param.email}' /><br/><br/></td>
            <td>
                <font color='red' size="-1">
                    <i><s:fielderror><s:param>email</s:param></s:fielderror></i>
                </font>
            </td>
        </tr>
    </table>
    <input type='submit' value="继续..."/>
</form>
<a href="index.jsp">回首页</a>
