<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="menu-under-avatar active-block first-block-user">
    <a href="/user"><spring:message code="user.menu.all.files"/></a>
</div>
<div class="menu-under-avatar ">
    <a href="/myfiles"><spring:message code="user.menu.my.files"/></a>
</div>
<div class="menu-under-avatar ">
    <a href="/download-files"><spring:message code="user.menu.add.file"/></a>
</div>
<div class="menu-under-avatar  last-block-user">
    <a href="/edit-profile"><spring:message code="user.menu.edit.profile"/></a>
</div>