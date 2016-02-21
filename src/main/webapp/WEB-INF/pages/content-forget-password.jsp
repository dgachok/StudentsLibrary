<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="text-registration-success">

    <h3> Введіть новий пароль</h3>
    <form action="${pageContext.request.contextPath}/forgetNewPassword?id=${id}" method="post">
    <div class="form-group">
        <label for="newPassword">Новий пароль</label>
        <input type="text" class="form-control" name="password" value="${password}" id="newPassword" placeholder="Введіть новий пароль">
    </div>
    <button type="submit" name="submit" value="submit" class="btn sign-in">Войти</button>
        </form>
</div>
