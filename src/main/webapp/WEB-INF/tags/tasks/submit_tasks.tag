<%@ include file="/WEB-INF/tags/customtaglibs.jspf" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/pages/js/tinymce/jquery.tinymce.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/pages/js/wysiwyg.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/pages/prettify/prettify.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/pages/prettify/prettify.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/pages/js/elements.js"></script>
<div class="row-fluid">
    <div class="">
        <h4 class="">${subjectForm.subjectName}</h4>
        <br>

<c:choose>
    <c:when test="${fn:length(syllabusList)>0}">
        <div class="accordion">

            <c:forEach var="syllabus" items="${syllabusList}">
                <h3><a href="#">Task Details </a></h3>
                <form class="stdform" action="${formAction}" name="userForm" method="post">
                    <input type="hidden" name="standardId" value="${syllabus.standardId}">
                    <input type="hidden" name="taskName" value="${syllabus.taskName}">
                    <input type="hidden" name="subjectId" value="${syllabus.subjectId}">
                    <input type="hidden" name="schoolId" value="${syllabus.schoolId}">

                    <input type="hidden" name="moduleId" value="${syllabus.moduleId}">
                    <input type="hidden" name="pId" value="${syllabus.taskId}">
                    <input type="hidden" name="taskDueDate" value="${syllabus.taskDueDate}">


                    <div>
                        <textarea id="elm1" name="content" rows="15" cols="80" style="width: 80%" class="tinymce">
                            <p>${syllabus.content}</p>
                        </textarea>
                    </div>
                    <p class="stdformbutton">
                        <button class="btn btn-primary">Submit Button</button>
                        <button type="reset" class="btn">Reset Button</button>
                    </p>
                </form>
            </c:forEach>
        </div>
    </c:when>
</c:choose>

    </div>
</div>