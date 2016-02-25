<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="wrap wrap-container">
        <div class="row">
            <div class="col-md-3">
                <div class="navbar-header">
                    <a href="/index"><img src="${pageContext.request.contextPath}/resources/img/logo3.png" class="image-logo-header"></a>
                </div>
            </div>
            <div class="col-md-9">
                <div class="header-text">
                    <h6><spring:message code="header.login.title1"/> <a href="/registration"><spring:message code="header.login.title2"/></a></h6>
                </div>
            </div>
        </div>
    </div>
</nav>