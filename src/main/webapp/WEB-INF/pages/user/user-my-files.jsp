<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<h3>Мои файлы</h3>

<c:forEach var="files" items="${files}">
<div class="files">
    <div class="header_files">
        <div class="name-file my-files-name">
            <img src="../../../resources/img/documents.png" class="files_img"> ${files.name}
        </div>
    </div>
    <div class="content_files"><strong>Description :</strong>
        <br>${files.description}
    </div>
    <div class="footer_files">
        <div class="button-download-my-files">
            <a href="/download-file-${files.id}"><button type="submit" name="submit" value="submit" class="btn inMyFilesDownload">Скачать</button></a>
        </div>
        <div class="button-delete-my-files">
            <a href="/delete-file-${files.id}"><button type="submit" name="submit" value="submit" class="btn inMyFilesDelete">Удалить</button></a>
        </div>
    </div>
</div>
</c:forEach>
<c:if test='${empty "${files}"}'>
    <h3>У вас пока нет файлов. <a href="${pageContext.request.contextPath}/download-files">Хотите добавить?</a></h3>
</c:if>