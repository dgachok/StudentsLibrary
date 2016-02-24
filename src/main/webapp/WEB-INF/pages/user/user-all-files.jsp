<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<h3><spring:message code="user.allfiles.h1"/></h3>

<c:forEach var="files" items="${files}">
<div class="files">
    <div class="header_files">
        <div class="name-file">
            <img src="../../../resources/img/documents.png" class="files_img"> ${files.name}
        </div>
        <div class="name-user">
            <img src="../../../resources/img/icon-user-png.png" class="files_img"> ${files.user.firstname} ${files.user.lastname}
        </div>
    </div>
    <div class="content_files"><strong><spring:message code="user.allfiles.form1"/> :</strong>
        <br> ${files.description}
        <center><a href="/download-file-${files.id}"> <button type="submit" name="submit" value="submit" class="btn download-button"><spring:message code="user.allfiles.form2.download"/></button></a></center>
    </div>
</div>
</c:forEach>
<c:if test='${empty files}'>
    <h3><spring:message code="user.allfiles.text1"/> <a href="${pageContext.request.contextPath}/download-files"><spring:message code="user.allfiles.text2"/></a></h3>
</c:if>