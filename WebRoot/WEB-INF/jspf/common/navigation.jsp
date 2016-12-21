<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<center><h3><font color="red">球&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;员</font></h3></center>
<hr width='90%' size='2' noshade />
&nbsp;&nbsp;&nbsp;<img src='<c:url value="/images/bullet.gif" />' />
<a href='<c:url value="/ListLeagues.jsp" />'>列出所有联赛</a><br/>
&nbsp;&nbsp;&nbsp;<img src='<c:url value="/images/bullet.gif" />' />
<a href='<c:url value="/register/EnterPlayer.jsp" />'>注册联赛</a>

<br /><br />
<center><h3><font color="red">联赛管理员</font></h3></center>
<hr width='90%' size='1' noshade />
&nbsp;&nbsp;&nbsp;<img src='<c:url value="/images/bullet.gif" />' />
<a href='<c:url value="/admin/AddLeague.jsp" />'>添加新联赛</a><br/>
&nbsp;&nbsp;&nbsp;<img src='<c:url value="/images/bullet.gif" />' />
列出注册球员