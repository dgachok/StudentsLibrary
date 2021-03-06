<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<h3><spring:message code="user.edit.h1"/></h3>
<h3><spring:message code="user.edit.h2"/> : ${currentUser.email}</h3>
<div class="add-file">
    <div class="content-add-files">

        <form:form role="form" modelAttribute="user" action="${pageContext.request.contextPath}/user/edit-profile" method="POST">
            <div class="form-group">

                <form:input type="hidden" path="id" id="id" value="${user.id}" />

                <form:input type="hidden" path="ssoId" id="ssoId" value="${user.ssoId}" />

                <form:input type="hidden" path="email" id="email" value="${user.email}" />

                <form:input type="hidden" path="user_role_id" id="user_role_id" value="${user.user_role_id}" />

                <form:input type="hidden" path="account_status" id="account_status" value="${user.account_status}" />

                <label for="fistname"><spring:message code="user.edit.form1"/> :</label>
                <input type="text" class="form-control" name="firstname" id="fistname" value="${user.firstname}">
                <form:errors path="firstname" name="firstname" type="text" cssClass="error" />
            </div>

            <div class="form-group">
                <label for="lastname"><spring:message code="user.edit.form2"/> :</label>
                <input type="text" class="form-control" name="lastname" id="lastname" value="${user.lastname}" >
                <form:errors path="lastname" name="lastname"  type="text" cssClass="error" />
            </div>

            <div class="form-group">
                <label for="password"><spring:message code="user.edit.form3"/> :</label>
                <input type="password" class="form-control" name="password" id="password">
                <form:errors path="password" name="password" type="text" cssClass="error" />
            </div>

            <center> <button type="submit" name="submit" value="submit" class="btn sign-in"><spring:message code="user.edit.form4"/></button></center>
        </form:form>

        <c:if test="${not empty editSuccess}">
            <div class="alert alert-warning alert-login">${editSuccess}</div>
        </c:if>

    </div>
</div>
