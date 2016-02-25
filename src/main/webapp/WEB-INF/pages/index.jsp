<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Students Library</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid container-background">
    <div class="wrap">
        <div class="row">
            <div class="col-md-7 col-main-one">
                <div class="col-main-one-s">
                    <h1><spring:message code="welcome.title1"/></h1>
                    <br/><br/>
               <h8><spring:message code="welcome.title2"/>
                    <br/><br/> <spring:message code="welcome.title3"/>
               </h8>

                  <!-- social buttons
                    <br/>
                    <ul class="social-contact">
                        <li class="span5">
                            <a href=""><img src="/resources/img/vk.png" class="social-icons"></a>
                        </li>
                        <li class="span5">
                            <a href=""><img src="/resources/img/facebook.png" class="social-icons"></a>
                        </li>
                        <li class="span5">
                            <a href=""><img src="/resources/img/twitter.png" class="social-icons"></a>
                        </li>
                        <li class="span5">
                            <a href=""><img src="/resources/img/youtube.png" class="social-icons"></a>
                        </li>
                    </ul> -->
                </div>
            </div>
            <div class="col-md-5">
                <div class="form">
                    <form role="form" name='LoginForm' action="<c:url value='/login' />" method='POST'>
                        <img src="${pageContext.request.contextPath}/resources/img/logo3.png" class="image-logo">
                        <div class="form-group">
                            <label for="email"><spring:message code="label.email"/></label>
                            <input type="text" class="form-control" name="username" id="email" placeholder="<spring:message code="login.email.placeholder"/>">
                        </div>
                        <label for="pass"><spring:message code="label.password"/></label>
                        <div class="input-group">
                            <input type="password" name="password" id="pass" placeholder="<spring:message code="login.password.placeholder"/>" class="form-control">
                            <span class="input-group-addon"><a href="/forgot-password" class="forget-index"><spring:message code="login.forgot"/></a></span>
                        </div>
                        <div class="form-group">
                            <label class="checkbox pull-left checkbox-pull-left">
                                <input type="checkbox" name="remember-me" value="true" checked><spring:message code="login.remember"/>
                            </label>
                        </div>
                        <br />
                       <center> <button type="submit" name="submit" value="submit" class="btn sign-in"><spring:message code="login.enter"/></button></center>
                        <div class="text-login"><spring:message code="login.add.information"/> <a href="${pageContext.request.contextPath}/registration"><spring:message code="login.add.registration"/></a></div>
                    </form>

                    <c:if test="${not empty logout}">
                        <div class="alert alert-success alert-login">${logout}</div>
                    </c:if>
                 </div>
            </div>
        </div>
    </div>

    <div class="wrap wrap-main">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <ul class="thumbnails">
                            <li class="span3">
                                <img src="${pageContext.request.contextPath}/resources/img/knu.png" alt="<spring:message code="login.university.knu"/>" class="image-thumbnail">
                                <br><h6><spring:message code="login.university.knu"/></h6>
                            </li>
                            <li class="span3">
                                    <img src="${pageContext.request.contextPath}/resources/img/naukma.png" alt="<spring:message code="login.university.naukma"/>" class="image-thumbnail">
                                <br><h6><spring:message code="login.university.naukma"/></h6>
                            </li>
                            <li class="span3">
                                <img src="${pageContext.request.contextPath}/resources/img/knteu.png" alt="<spring:message code="login.university.knteu"/>" class="image-thumbnail">
                                <br><h6><spring:message code="login.university.knteu"/></h6>
                            </li>
                            <li class="span3">
                                <img src="${pageContext.request.contextPath}/resources/img/knuba.png" alt="<spring:message code="login.university.knuca"/>" class="image-thumbnail">
                                <br><h6><spring:message code="login.university.knuca"/></h6>
                            </li>
                        </ul>
                    </div>
                    <div class="item">
                        <ul class="thumbnails">
                            <li class="span3">
                                <img src="${pageContext.request.contextPath}/resources/img/knukim.png" alt="<spring:message code="login.university.knuculture"/>" class="image-thumbnail">
                                <br><h6><spring:message code="login.university.knuculture"/></h6>
                            </li>
                            <li class="span3">
                                <img src="${pageContext.request.contextPath}/resources/img/nau.png" alt="<spring:message code="login.university.nau"/>" class="image-thumbnail">
                                <br><h6><spring:message code="login.university.nau"/></h6>
                            </li>
                            <li class="span3">
                                <img src="${pageContext.request.contextPath}/resources/img/kneu.png" alt="<spring:message code="login.university.kneu"/>" class="image-thumbnail">
                                <br><h6><spring:message code="login.university.kneu"/></h6>
                            </li>
                            <li class="span3">
                                <img src="${pageContext.request.contextPath}/resources/img/npu.png" alt="<spring:message code="login.university.npu"/>" class="image-thumbnail">
                                <br><h6><spring:message code="login.university.npu"/></h6>
                            </li>
                        </ul>
                    </div>
            </div>
            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>

            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

</div>
<tiles:insertAttribute name="footer" />
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/carousel.js"></script>
</body>
</html>
