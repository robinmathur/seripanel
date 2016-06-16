<%@ include file="/WEB-INF/tags/customtaglibs.jspf" %>

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
                <div>
                    <p>
                        ${syllabus.content}
                    </p>
                </div>
            </c:forEach>
        </div>
    </c:when>
</c:choose>

    </div>
</div>