<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="wrap wrap-container">
        <div class="row">
            <div class="col-md-3">
                <div class="navbar-header">
                    <a href="/user"><img src="${pageContext.request.contextPath}/resources/img/logo3.png" class="image-logo-header"></a>
                </div>
            </div>
            <div class="col-md-9">
                <div class="header-text">
                    <h6><a href="/logout"><spring:message code="user.header.exit"/></a></h6>
                </div>
            </div>
        </div>
    </div>
</nav>