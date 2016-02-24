<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Students Library</title>
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/css/style.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="wrap wrap-container">
        <div class="row">
            <div class="col-md-3">
                <div class="navbar-header">
                    <a href="/index"><img src="../../resources/img/logo3.png" class="image-logo-header"></a>
                </div>
            </div>
            <div class="col-md-9">
                <div class="header-text">
                    <h6><spring:message code="header.registr.title1"/> <a href="/login"><spring:message code="header.registr.title2"/></a></h6>
                </div>
            </div>
        </div>
    </div>
</nav>
<div class="container-fluid container-background template-header">
    <div class="wrap wrap-main">
        <div class="text-registration-success">
            <h3><spring:message code="index.404"/> <a href="/index"><spring:message code="index.forget.success2"/></a></h3>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="wrap wrap-main">
        <ul class="footer-contact">
            <li class="span4">
                <a href="?lang=en"><spring:message code="label.english"/></a>
            </li>
            <li class="span4">
                <a href="?lang=ua"><spring:message code="label.ukrainian"/></a>
            </li>
            <li class="span4">
                <a href="?lang=ru"><spring:message code="label.russian"/></a>
            </li>
        </ul>
    </div>
</div>
<script src="../../resources/js/jquery.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
<script src="../../resources/js/carousel.js"></script>
</body>
</html>
