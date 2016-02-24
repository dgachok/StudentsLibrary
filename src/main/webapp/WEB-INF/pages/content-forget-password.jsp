<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="text-registration-success">

    <h3><spring:message code="index.forget.newpassword"/></h3>
    <form action="${pageContext.request.contextPath}/forgetNewPassword?id=${id}" method="post">
    <div class="form-group">
        <label for="newPassword"><spring:message code="index.forget.newpassword.label"/></label>
        <input type="password" class="form-control" name="password" id="newPassword" placeholder="<spring:message code="index.forget.newpassword.placeholder"/>">
    </div>
    <button type="submit" name="submit" value="submit" class="btn sign-in"><spring:message code="index.forget.change.button"/></button>
        </form>
    <c:if test="${not empty pass}">
        <div class="alert alert-warning alert-login">${pass}</div>
    </c:if>
</div>
