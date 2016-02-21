<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<c:set var="data" value="../../resources" />
<html>
<head>
    <title>Students Library</title>
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/css/style.css" rel="stylesheet">
</head>
<body>
<tiles:insertAttribute name="header" />
<div class="container-fluid container-background template-header">
    <div class="wrap wrap-main">
        <tiles:insertAttribute name="content" />
    </div>
</div>
<tiles:insertAttribute name="footer" />
<script src="../../resources/js/jquery.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
<script src="../../resources/js/carousel.js"></script>
</body>
</html>
