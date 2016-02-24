<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="text-registration-success">
    <h3><spring:message code="index.forget.send1"/> ${name}
        <br>${email}
        <br>${id}
        <a href="/index"><spring:message code="index.forget.send2"/></a></h3>
</div>