<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<p><s:text name="message.league.login.header" /></p>
<font color='red'><s:actionerror /></font>

<form action='<c:url value="admin/Login" />' method='POST'>
    <table>
        <tr>
            <td>用户名：
                <input type='text' name='username' value='${param.username}' />
                <br/><br/>
            </td>
            <td>
                <font color='red' size="-1"><i>
                    <s:fielderror>
                        <s:param>username</s:param>
                    </s:fielderror>
                </i></font>
            </td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：
                <input type='password' name='password' value='${param.password}' />
                <br/><br/>
            </td>
            <td>
                <font color='red' size="-1"><i>
                    <s:fielderror>
                        <s:param>password</s:param>
                    </s:fielderror>
                </i></font>
            </td>
        </tr>
    </table>                                                
    <input type='submit' value='登 录' />
</form>
<a href="index.jsp">回首页</a>
