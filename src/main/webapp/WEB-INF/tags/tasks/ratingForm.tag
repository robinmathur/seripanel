<%@ include file="/WEB-INF/tags/customtaglibs.jspf" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/pages/js/responsive-tables.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/pages/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        // dynamic table
        $('#dyntable').dataTable({
            "sPaginationType": "full_numbers",
            "aaSortingFixed": [[0,'asc']],
            "fnDrawCallback": function(oSettings) {
                jQuery.uniform.update();
            }
        });

rating.studentListing();
    });
</script>
<div class="row-fluid">
<div class="">
<h4 class="">${subjectForm.subjectName}</h4>
<br>
    <form class="stdform" action="${formAction}" method="post">
<sec:authorize access="hasRole('ROLE_TEACHER')">
    <p>
        <label>Select Subject</label>
                <span class="field">
                    <input type="hidden" name="standardId" id="standardId">
                    <standardLibs:subjectListInQuery ids="${tempStandardId}" ctrlName="subjectId" ctrlId="customSubjectId" selectedSubject="0" />
                </span>
    </p>
</sec:authorize>
</form>


    <h4 class="widgettitle">Data Table</h4>
    <table id="dyntable" class="table table-bordered responsive">
        <colgroup>
            <col class="con0" style="align: center; width: 4%" />
            <col class="con1" />
            <col class="con0" />
            <col class="con1" />
            <col class="con0" />
            <col class="con1" />
        </colgroup>
        <thead>
        <tr>
            <th class="head0 nosort"><input type="checkbox" class="checkall" /></th>
            <th class="head0">Student Name</th>
            <th class="head1">Task Name</th>
            <th class="head0">View Task Details</th>
            <th class="head1">Max Rating</th>
            <th class="head0">Assign Rating</th>
        </tr>
        </thead>
        <tbody>
        <tr class="gradeX">
            <td class="aligncenter"><span class="center"><input type="checkbox" /></span></td>
            <td>Trident</td>
            <td>Home Work</td>
            <td><a href="#">View Task Details</a></td>
            <td class="center">5</td>
            <td class="center"><span class="field" id="rating">
                        <a href="#" class="student-rate-a promptbutton"> <span class="badge badge-important">1</span></a>
                        <a href="#" class="student-rate-a promptbutton"> <span class="badge badge-warning">2</span></a>
                        <a href="#" class="student-rate-a promptbutton"> <span class="badge">3</span></a>
                        <a href="#" class="student-rate-a promptbutton"> <span class="badge badge-info">4</span></a>
                        <a href="#" class="student-rate-a promptbutton"> <span class="badge badge-success">5</span></a>
                    </span>
            </td>
        </tr>
        <tr class="gradeC">
            <td class="aligncenter"><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Trident</td>
            <td>Internet Explorer 5.0</td>
            <td>Win 95+</td>
            <td class="center">5</td>
            <td class="center">C</td>
        </tr>
        <tr class="gradeA">
            <td class="aligncenter"><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Trident</td>
            <td>Internet Explorer 5.5</td>
            <td>Win 95+</td>
            <td class="center">5.5</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td class="aligncenter"><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Trident</td>
            <td>Internet Explorer 6</td>
            <td>Win 98+</td>
            <td class="center">6</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td class="aligncenter"><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Trident</td>
            <td>Internet Explorer 7</td>
            <td>Win XP SP2+</td>
            <td class="center">7</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td class="aligncenter"><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Trident</td>
            <td>AOL browser (AOL desktop)</td>
            <td>Win XP</td>
            <td class="center">6</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td class="aligncenter"><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Firefox 1.0</td>
            <td>Win 98+ / OSX.2+</td>
            <td class="center">1.7</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td class="aligncenter"><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Firefox 1.5</td>
            <td>Win 98+ / OSX.2+</td>
            <td class="center">1.8</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Firefox 2.0</td>
            <td>Win 98+ / OSX.2+</td>
            <td class="center">1.8</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Firefox 3.0</td>
            <td>Win 2k+ / OSX.3+</td>
            <td class="center">1.9</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Camino 1.0</td>
            <td>OSX.2+</td>
            <td class="center">1.8</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Camino 1.5</td>
            <td>OSX.3+</td>
            <td class="center">1.8</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Netscape 7.2</td>
            <td>Win 95+ / Mac OS 8.6-9.2</td>
            <td class="center">1.7</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Netscape Browser 8</td>
            <td>Win 98SE+</td>
            <td class="center">1.7</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Netscape Navigator 9</td>
            <td>Win 98+ / OSX.2+</td>
            <td class="center">1.8</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Mozilla 1.0</td>
            <td>Win 95+ / OSX.1+</td>
            <td class="center">1</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Mozilla 1.1</td>
            <td>Win 95+ / OSX.1+</td>
            <td class="center">1.1</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Mozilla 1.2</td>
            <td>Win 95+ / OSX.1+</td>
            <td class="center">1.2</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Mozilla 1.3</td>
            <td>Win 95+ / OSX.1+</td>
            <td class="center">1.3</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Mozilla 1.4</td>
            <td>Win 95+ / OSX.1+</td>
            <td class="center">1.4</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Mozilla 1.5</td>
            <td>Win 95+ / OSX.1+</td>
            <td class="center">1.5</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Mozilla 1.6</td>
            <td>Win 95+ / OSX.1+</td>
            <td class="center">1.6</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Mozilla 1.7</td>
            <td>Win 98+ / OSX.1+</td>
            <td class="center">1.7</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Mozilla 1.8</td>
            <td>Win 98+ / OSX.1+</td>
            <td class="center">1.8</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Seamonkey 1.1</td>
            <td>Win 98+ / OSX.2+</td>
            <td class="center">1.8</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Gecko</td>
            <td>Epiphany 2.20</td>
            <td>Gnome</td>
            <td class="center">1.8</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Webkit</td>
            <td>Safari 1.2</td>
            <td>OSX.3</td>
            <td class="center">125.5</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Webkit</td>
            <td>Safari 1.3</td>
            <td>OSX.3</td>
            <td class="center">312.8</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Webkit</td>
            <td>Safari 2.0</td>
            <td>OSX.4+</td>
            <td class="center">419.3</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Webkit</td>
            <td>Safari 3.0</td>
            <td>OSX.4+</td>
            <td class="center">522.1</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Webkit</td>
            <td>OmniWeb 5.5</td>
            <td>OSX.4+</td>
            <td class="center">420</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Webkit</td>
            <td>iPod Touch / iPhone</td>
            <td>iPod</td>
            <td class="center">420.1</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Webkit</td>
            <td>S60</td>
            <td>S60</td>
            <td class="center">413</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Presto</td>
            <td>Opera 7.0</td>
            <td>Win 95+ / OSX.1+</td>
            <td class="center">-</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Presto</td>
            <td>Opera 7.5</td>
            <td>Win 95+ / OSX.2+</td>
            <td class="center">-</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Presto</td>
            <td>Opera 8.0</td>
            <td>Win 95+ / OSX.2+</td>
            <td class="center">-</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Presto</td>
            <td>Opera 8.5</td>
            <td>Win 95+ / OSX.2+</td>
            <td class="center">-</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Presto</td>
            <td>Opera 9.0</td>
            <td>Win 95+ / OSX.3+</td>
            <td class="center">-</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Presto</td>
            <td>Opera 9.2</td>
            <td>Win 88+ / OSX.3+</td>
            <td class="center">-</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Presto</td>
            <td>Opera 9.5</td>
            <td>Win 88+ / OSX.3+</td>
            <td class="center">-</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Presto</td>
            <td>Opera for Wii</td>
            <td>Wii</td>
            <td class="center">-</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Presto</td>
            <td>Nokia N800</td>
            <td>N800</td>
            <td class="center">-</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Presto</td>
            <td>Nintendo DS browser</td>
            <td>Nintendo DS</td>
            <td class="center">8.5</td>
            <td class="center">C/A<sup>1</sup></td>
        </tr>
        <tr class="gradeC">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>KHTML</td>
            <td>Konqureror 3.1</td>
            <td>KDE 3.1</td>
            <td class="center">3.1</td>
            <td class="center">C</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>KHTML</td>
            <td>Konqureror 3.3</td>
            <td>KDE 3.3</td>
            <td class="center">3.3</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>KHTML</td>
            <td>Konqureror 3.5</td>
            <td>KDE 3.5</td>
            <td class="center">3.5</td>
            <td class="center">A</td>
        </tr>
        <tr class="gradeX">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Tasman</td>
            <td>Internet Explorer 4.5</td>
            <td>Mac OS 8-9</td>
            <td class="center">-</td>
            <td class="center">X</td>
        </tr>
        <tr class="gradeC">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Tasman</td>
            <td>Internet Explorer 5.1</td>
            <td>Mac OS 7.6-9</td>
            <td class="center">1</td>
            <td class="center">C</td>
        </tr>
        <tr class="gradeC">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Tasman</td>
            <td>Internet Explorer 5.2</td>
            <td>Mac OS 8-X</td>
            <td class="center">1</td>
            <td class="center">C</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Misc</td>
            <td>NetFront 3.1</td>
            <td>Embedded devices</td>
            <td class="center">-</td>
            <td class="center">C</td>
        </tr>
        <tr class="gradeA">
            <td><span class="center">
                            <input type="checkbox" />
                          </span></td>
            <td>Misc</td>
            <td>NetFront 3.4</td>
            <td>Embedded devices</td>
            <td class="center">-</td>
            <td class="center">A</td>
        </tr>
        </tbody>
    </table>

</div></div>