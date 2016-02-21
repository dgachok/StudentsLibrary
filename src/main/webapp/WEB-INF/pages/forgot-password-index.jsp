<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="text-forget-password">
        <h3>Если вы забыли пароль введите свою почту чтобы вы могли изменить свой пароль</h3>
    </div>

<div class="forget-form">
<form class="forget-index" action="${pageContext.request.contextPath}/sendforgetpassword" method="post">
    <div class="form-group">
        <label for="forgetEmail">Ваша почта</label>
        <input type="text" name="email" value="${email}" class="form-control" id="forgetEmail" placeholder="Введите почту">
    </div>
    <div class="modal-footer">
        <button type="submit" class="btn btn-primary forgot-btn">Отправить</button></a>
    </div>
</form>
<c:if test="${not empty noUser}">
    <div class="alert alert-warning alert-login">${noUser}</div>
</c:if></div>