<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Students Library</title>
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid container-background">
    <div class="wrap">
        <div class="row">
            <div class="col-md-7 col-main-one">
                <div class="col-main-one-s">
                    <h1>Ласкаво просимо у студентську бібліотеку.</h1>
                    <br/><br/>
               <h8>Приєднуйтеся до друзів та інших чудових людей. Отримуйте миттєві оновлення про те, що вас цікавить. А також дивіться, як розгортаються події, – в реальному часі та з різних перспектив.
                    <br/><br/> За допомогою цього сервісу ви зможете завантажувати книжки, конспекти на сайт і ділитися ними зі своїми друзями. Найближчим часом на сайті з'явиться роль викладача, який зможе продавати методички та викладати свої роботи на сайті.
               </h8>

                  <!-- social buttons
                    <br/>
                    <ul class="social-contact">
                        <li class="span5">
                            <a href=""><img src="../../resources/img/vk.png" class="social-icons"></a>
                        </li>
                        <li class="span5">
                            <a href=""><img src="../../resources/img/facebook.png" class="social-icons"></a>
                        </li>
                        <li class="span5">
                            <a href=""><img src="../../resources/img/twitter.png" class="social-icons"></a>
                        </li>
                        <li class="span5">
                            <a href=""><img src="../../resources/img/youtube.png" class="social-icons"></a>
                        </li>
                    </ul> -->
                </div>
            </div>
            <div class="col-md-5">
                <div class="form">
                    <form role="form" name='LoginForm' action="<c:url value='/login' />" method='POST'>
                        <img src="../../resources/img/logo3.png" class="image-logo">
                        <div class="form-group">
                            <label for="email"><spring:message code="label.email"/></label>
                            <input type="text" class="form-control" name="username" id="email" placeholder="Введите свою почту">
                        </div>
                        <label for="pass"><spring:message code="label.password"/></label>
                        <div class="input-group">
                            <input type="password" name="password" id="pass" placeholder="Пароль" class="form-control">
                            <span class="input-group-addon"><a href="/forgot-password" class="forget-index">Забыли?</a></span>
                        </div>
                        <div class="form-group">
                            <label class="checkbox pull-left checkbox-pull-left">
                                <input type="checkbox" name="remember-me" value="true" checked>Запомнить меня
                            </label>
                        </div>
                        <br />
                       <center> <button type="submit" name="submit" value="submit" class="btn sign-in">Войти</button></center>
                        <div class="text-login">Если у вас еще нет аккаунта, пожалуйста, <a href="${pageContext.request.contextPath}/registration">зарегистрируйтесь</a></div>
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
                                <img src="../../resources/img/knu.png" alt="КНУ" class="image-thumbnail">
                                <br><h6>КНУ ім.Шевченка</h6>
                            </li>
                            <li class="span3">
                                    <img src="../../resources/img/naukma.png" alt="КНУ" class="image-thumbnail">
                                <br><h6>НАУКМА</h6>
                            </li>
                            <li class="span3">
                                <img src="../../resources/img/knteu.png" alt="КНУ" class="image-thumbnail">
                                <br><h6>КНТЭУ</h6>
                            </li>
                            <li class="span3">
                                <img src="../../resources/img/knu.png" alt="КНУ" class="image-thumbnail">
                                <br><h6>КНУ ім.Шевченка</h6>
                            </li>
                        </ul>
                    </div>
                    <div class="item">
                        <ul class="thumbnails">
                            <li class="span3">
                                <img src="../../resources/img/knu.png" alt="КНУ" class="image-thumbnail">
                                <br><h6>КНУ ім.Шевченка</h6>
                            </li>
                            <li class="span3">
                                <img src="../../resources/img/naukma.png" alt="КНУ" class="image-thumbnail">
                                <br><h6>НАУКМА</h6>
                            </li>
                            <li class="span3">
                                <img src="../../resources/img/knteu.png" alt="КНУ" class="image-thumbnail">
                                <br><h6>КНТЭУ</h6>
                            </li>
                            <li class="span3">
                                <img src="../../resources/img/knu.png" alt="КНУ" class="image-thumbnail">
                                <br><h6>КНУ ім.Шевченка</h6>
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
<script src="../../resources/js/jquery.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
<script src="../../resources/js/carousel.js"></script>
</body>
</html>
