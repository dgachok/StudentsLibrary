<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="text-registration-hd"><h3><spring:message code="index.login.form"/> </h3></div>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <div class="form form-login">
            <form role="form" name='LoginForm' action="<c:url value='/login' />" method='POST'>
                <div class="form-group">
                    <label for="email"><spring:message code="index.login.form1"/></label>
                    <input type="text" class="form-control" name="username" id="email" placeholder="<spring:message code="index.login.form1.placeholder"/>" >
                </div>
                <label for="pass"><spring:message code="index.login.form2"/></label>
                <div class="input-group">
                    <input type="password" name="password" id="pass" placeholder="<spring:message code="index.login.form2.placeholder"/>" class="form-control" >
                    <span class="input-group-addon"><a href="/forgot-password" class="forget-index"><spring:message code="index.login.form3"/></a></span>
                </div>
                <div class="form-group">
                    <label class="checkbox pull-left checkbox-pull-left">
                        <input type="checkbox" name="remember-me" checked><spring:message code="index.login.form4"/>
                    </label>
                </div>
                <br />
                <center> <button type="submit" name="submit" value="submit" class="btn sign-in"><spring:message code="index.login.form5.button"/></button></center>
                <div class="text-login"><spring:message code="index.login.form6"/> <a href="${pageContext.request.contextPath}/registration"><spring:message code="index.login.form7"/></a></div>
            </form>
            <c:if test="${not empty error}">
                <div class="alert alert-warning alert-login">${error}</div>
            </c:if>
            <c:if test="${not empty verification}">
                <div class="alert alert-success alert-login">${verification}</div>
            </c:if>
        </div>
    </div>
    <div class="col-md-1">
    </div>

</div>