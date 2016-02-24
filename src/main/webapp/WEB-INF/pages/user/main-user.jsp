<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<c:set var="data" value="../../resources" />
<html>
<head>
    <title>Students Library</title>
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../resources/css/style.css" rel="stylesheet">
    <script src="../../../resources/js/uploadfile.js"></script>
</head>
<body>
<tiles:insertAttribute name="header-user" />
<div class="container-fluid container-background template-header user-main">
    <div class="wrap wrap-main">
        <div class="row">
            <div class="col-md-3 block-user">
                <div class="avatar">
                    <img src="../../../resources/img/avatar_user.png" class="avatar_img">
                </div>
                <spring:message code="user.main"/> ${currentUser.firstname} ${currentUser.lastname}

                <tiles:insertAttribute name="user-menu" />
            </div>
            <div class="col-md-8 col-md-offset-1 block-content">
                <div class="content-user">
                    <tiles:insertAttribute name="content-user" />
                </div>
            </div>
        </div>
    </div>
</div>
<tiles:insertAttribute name="footer" />
<script src="../../../resources/js/jquery.min.js"></script>
<script src="../../../resources/js/bootstrap.min.js"></script>
<script src="../../../resources/js/carousel.js"></script>
</body>
</html>
