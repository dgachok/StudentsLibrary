<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="text-forget-password">
        <h3><spring:message code="index.forgot.title1"/></h3>
    </div>

<div class="forget-form">
<form class="forget-index" action="${pageContext.request.contextPath}/sendforgetpassword" method="post">
    <div class="form-group">
        <label for="forgetEmail"><spring:message code="index.forgot.title2"/></label>
        <input type="text" name="email" value="${email}" class="form-control" id="forgetEmail" placeholder="<spring:message code="index.forgot.title3"/>">
    </div>
    <div class="modal-footer">
        <button type="submit" class="btn btn-primary forgot-btn"><spring:message code="index.forgot.title4"/></button></a>
    </div>
</form>
<c:if test="${not empty noUser}">
    <div class="alert alert-warning alert-login">${noUser}</div>
</c:if></div>