<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" scope="request">Duke足球联赛</c:set>
<c:set var="mainBody" scope="request">EnterPlayerBody.jsp</c:set>

<jsp:include page="/WEB-INF/jspf/common/layout.jsp">
    <jsp:param name="subTitle" value="注册联赛" />
</jsp:include>
