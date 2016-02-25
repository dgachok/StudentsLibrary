<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<h3><spring:message code="user.files.h1"/></h3>

<c:forEach var="files" items="${files}">
<div class="files">
    <div class="header_files">
        <div class="name-file my-files-name">
            <img src="${pageContext.request.contextPath}/resources/img/documents.png" class="files_img"> ${files.name}
        </div>
    </div>
    <div class="content_files"><strong><spring:message code="user.files.description"/> :</strong>
        <br>${files.description}
    </div>
    <div class="footer_files">
        <div class="button-download-my-files">
            <a href="/user/download-file-${files.id}"><button type="submit" name="submit" value="submit" class="btn inMyFilesDownload"><spring:message code="user.files.download.button"/></button></a>
        </div>
        <div class="button-delete-my-files">
            <a class="btn inMyFilesDelete" data-toggle="modal" data-target="#basicModal"><spring:message code="user.files.delete.button"/></a></button>
        </div>
    </div>
</div>
    <div class="modal fade margin-model" id="basicModal" tabindex="-1" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header"><button class="close" type="button" data-dismiss="modal">x</button>

                </div>
                <div class="modal-body model-center-text">
                    <h3><spring:message code="user.files.modal.window.text"/></h3>
                </div>
                <div class="modal-footer">
                    <a href="/user/delete-file-${files.id}"><button class="btn inMyFilesDelete button-model"  type="button"><spring:message code="user.files.delete.button"/></button></a></div>
            </div>
        </div>
    </div>
</c:forEach>
<c:if test='${empty files}'>
    <h3><spring:message code="user.files.text1"/> <a href="${pageContext.request.contextPath}/user/download-files"><spring:message code="user.files.text2"/></a></h3>
</c:if>