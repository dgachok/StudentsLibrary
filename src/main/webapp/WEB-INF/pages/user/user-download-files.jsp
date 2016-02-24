<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<h3><spring:message code="user.download.h1"/></h3>
<div class="add-file">
    <div class="content-add-files">
    <form:form method="POST" modelAttribute="file" enctype="multipart/form-data">
        <label for="name"><strong><h4><spring:message code="user.download.form1"/> :</h4></strong></label>
        <input path="name" id="name" value="${file.name}" name="name" placeholder="<spring:message code="user.download.form2"/>" class="input-description" >
        <form:errors path="name" name="name" type="text" cssClass="error" />
        <br />
        <label for="description"><strong><h4><spring:message code="user.download.form3"/> :</h4></strong></label>
        <textarea path="description" value="${file.description}" id="description" name="description" rows="5" cols="50" placeholder="<spring:message code="user.download.form3.placeholder"/>" class="input-description" ></textarea>
        <form:errors path="description" name="description" type="text" cssClass="error" />

        <!-- <div class="fileform">
            <div id="fileformlabel"></div>
            <div class="selectbutton">Обзор</div>

          <input type="file" name="file" id="file" onchange="getName(this.value);"  path="file"/>

        </div> -->

        <input type="file" name="file" id="file" cssClass="input-download-file"  path="file">
        <form:errors path="file" name="file" type="text" cssClass="error" />

        <center> <input type="submit" name="submit" value="<spring:message code="user.download.form4.add"/>" class="btn download-button upload-button"></center>
    </form:form>

        <c:if test="${not empty uploadSuccess}">
            <div class="alert alert-success alert-login">${uploadSuccess}</div>
        </c:if>

        <c:if test="${not empty uploadError}">
            <div class="alert alert-warning alert-login">${uploadError}</div>
        </c:if>

    </div>
</div>

