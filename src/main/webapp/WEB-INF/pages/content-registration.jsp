<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="text-registration-hd"><h3><spring:message code="index.register.form"/> </h3></div>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <div class="form form-registration">
            <form:form role="form" modelAttribute="RegistrationForm" action="${pageContext.request.contextPath}/registration" method='POST'>
                <div class="form-group">
                    <label for="fistname"><spring:message code="index.register.form1"/> :</label>
                    <input type="text" class="form-control" name="firstname" id="fistname" value="${user.firstname}" placeholder="<spring:message code="index.register.form1.placeholder"/>">
                    <form:errors path="firstname" name="firstname" type="text" cssClass="error" />
                </div>

                <div class="form-group">
                    <label for="lastname"><spring:message code="index.register.form2"/> :</label>
                    <input type="text" class="form-control" name="lastname" id="lastname" value="${user.lastname}" placeholder="<spring:message code="index.register.form2.placeholder"/>">
                    <form:errors path="lastname" name="lastname" type="text" cssClass="error" />
                </div>

                <div class="form-group">
                    <label for="email"><spring:message code="index.register.form3"/> :</label>
                    <input type="text" class="form-control" name="email" id="email" value="${user.email}" placeholder="<spring:message code="index.register.form3.placeholder"/>">
                    <form:errors path="email" name="email" type="text" cssClass="error" />
                </div>

                <div class="form-group">
                <label for="password"><spring:message code="index.register.form4"/> :</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="<spring:message code="index.register.form4.placeholder"/>">
                    <form:errors path="password" name="password" type="text" cssClass="error" />
                </div>

                <center> <button type="submit" name="submit" value="submit" class="btn sign-in"><spring:message code="index.register.form5.button"/></button></center>
                <div class="text-registration"><spring:message code="index.register.form6.text"/> <a class="pointer" data-toggle="modal" data-target="#basicModal"><spring:message code="index.register.form7.text"/></a><spring:message code="index.register.form8.text"/></div>
            </form:form>

        </div>
    </div>
    <div class="col-md-1">
    </div>
</div>
<div class="modal fade" id="basicModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button class="close" type="button" data-dismiss="modal">x</button>
                <h4><spring:message code="index.register.form7.text"/></h4>
            </div>
            <div class="modal-body model-center-text">
                <spring:message code="user.registration.modal.terms"/>
            </div>
            <div class="modal-footer">
                <button class="btn inMyFilesDelete button-model color-privacy-button" data-dismiss="modal"  type="button"><spring:message code="user.registration.modal.close"/></button></div>
        </div>
    </div>
</div>
