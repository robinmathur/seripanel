<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="row-fluid">
    <div id="dashboard-left" class="span8">

        <h5 class="subtitle">Recently Viewed Pages</h5>
        <ul class="shortcuts">
            <li class="events">
                <a href="">
                    <span class="shortcuts-icon iconsi-event"></span>
                    <span class="shortcuts-label">Events</span>
                </a>
            </li>
            <li class="products">
                <a href="">
                    <span class="shortcuts-icon iconsi-message"></span>
                    <span class="shortcuts-label">Messages</span>
                </a>
            </li>
            <li class="archive">
                <a href="">
                    <span class="shortcuts-icon iconsi-archive"></span>
                    <span class="shortcuts-label">Syllabus</span>
                </a>
            </li>
            <li class="help">
                <a href="">
                    <span class="shortcuts-icon iconsi-help"></span>
                    <span class="shortcuts-label">Help</span>
                </a>
            </li>
            <li class="last images">
                <a href="">
                    <span class="shortcuts-icon iconsi-images"></span>
                    <span class="shortcuts-label">Images</span>
                </a>
            </li>
        </ul>

        <br />


        <div class="divider30"></div>
<c:choose>
    <c:when test="${fn:length(subjectList)>0}">

        <table class="table table-bordered responsive">
            <thead>
            <tr>
                <th class="head1">Subject Name</th>
                <th class="head0">Subject Name</th>
                <th class="head1">Syllabus</th>
                <th class="head0">Tomorrow's Task</th>
                <th class="head1">Assignment</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${subjectList}" var="subject">
                <tr>
                    <td>${subject.subjectName}</td>
                    <td>${subject.subjectName}</td>
                    <td><a href="/syllabus/view/?subjectid=${subject.subjectId}">View Syllabus</a> </td>
                    <td class="center"><a href="/syllabus/view">View / Update Task</a></td>
                    <td class="center"><a href="/syllabus/view">View / Update Assignment</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <br />

    </c:when>
</c:choose>
    </div><!--span8-->


    <div id="dashboard-right" class="span4">

        <h5 class="subtitle">Announcements</h5>

        <div class="divider15"></div>

        <div class="alert alert-block">
            <button data-dismiss="alert" class="close" type="button">&times;</button>
            <h4>Warning!</h4>
            <p style="margin: 8px 0">Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna.</p>
        </div><!--alert-->

        <br />

    </div><!--span4-->
</div><!--row-fluid-->