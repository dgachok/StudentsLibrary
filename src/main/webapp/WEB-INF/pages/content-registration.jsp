<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="text-registration-hd"><h3>Приєднуйтесь до Студентської бібліотеки сьогодні. </h3></div>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <div class="form form-registration">
            <form:form role="form" modelAttribute="RegistrationForm" action="${pageContext.request.contextPath}/registration" method='POST'>
                <div class="form-group">
                    <label for="fistname">Ім'я користувача :</label>
                    <input type="text" class="form-control" name="firstname" id="fistname" value="${user.firstname}" placeholder="Введіть ім'я користувача">
                    <form:errors path="firstname" name="firstname" type="text" cssClass="error" />
                </div>

                <div class="form-group">
                    <label for="lastname">Призвіще користувача :</label>
                    <input type="text" class="form-control" name="lastname" id="lastname" value="${user.lastname}" placeholder="Введіть призвіще користувача">
                    <form:errors path="lastname" name="lastname" type="text" cssClass="error" />
                </div>

                <div class="form-group">
                    <label for="email">Ваш Email :</label>
                    <input type="text" class="form-control" name="email" id="email" value="${user.email}" placeholder="Введіть пошту користувача">
                    <form:errors path="email" name="email" type="text" cssClass="error" />
                </div>

                <div class="form-group">
                <label for="password">Пароль :</label>
                <input type="password" class="form-control" name="password" id="password" value="${user.password}" placeholder="Введіть пароль користувача">
                    <form:errors path="password" name="password" type="text" cssClass="error" />
                </div>

                <center> <button type="submit" name="submit" value="submit" class="btn sign-in">Зареєструватися</button></center>
                <div class="text-registration">Реєструючись, ви погоджуєтеся з <a href="">Умовами надання послуг і Політикою конфіденційності</a>, включаючи Політику використання файлів cookie. Інші користувачі зможуть знайти вас за наданими вами електронною поштою.</div>
            </form:form>
        </div>
    </div>
    <div class="col-md-1">
    </div>
</div>
