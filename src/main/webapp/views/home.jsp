<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
    <body>
        <div class="content">
            <div class="btn-controls">
                <div class="btn-box-row row-fluid">
                 <a href="#" class="btn-box big span3" id="batch-link"><i class="fa fa-list"></i><b>${batchSize}</b>
                     <p class="text-muted">Batch</p>
                  </a>
                    <a href="#" class="btn-box big span3" id="course-link"><i class="fa fa-book"></i><b>${courseSize }</b>
                         <p class="text-muted">Course</p>
                    </a>
                    <a href="#" class="btn-box big span3" id="fresher-link"><i class="fa fa-user"></i><b>${fresherSize}</b>
                        <p class="text-muted">Fresher</p>
                    </a>
                    <a href="#" class="btn-box big span3" id="language-link"><i class="fa fa-language"></i><b>${languageSize}</b>
                        <p class="text-muted">Language</p>
                    </a>
                </div>
            </div>
            <div class="module">
                <div class="module-head">
                    <h3>
                        DataTables</h3>
                </div>
                <div class="module-body table">
                    <table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped  display"
                        width="100%">
                        <thead>
                            <tr>
                                <th>
                                    Rendering engine
                                </th>
                                <th>
                                    Browser
                                </th>
                                <th>
                                    Platform(s)
                                </th>
                                <th>
                                    Engine version
                                </th>
                                <th>
                                    CSS grade
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="odd gradeA">
                                <td>
                                    Trident
                                </td>
                                <td>
                                    Internet Explorer 5.5
                                </td>
                                <td>
                                    Win 95+
                                </td>
                                <td class="center">
                                    5.5
                                </td>
                                <td class="center">
                                    A
                                </td>
                            </tr>
                            <tr class="even gradeA">
                                <td>
                                    Trident
                                </td>
                                <td>
                                    AOL browser (AOL desktop)
                                </td>
                                <td>
                                    Win XP
                                </td>
                                <td class="center">
                                    6
                                </td>
                                <td class="center">
                                    A
                                </td>
                        </tbody>
                    </table>
                </div>
            </div>
            <!--/.module-->
        </div>
         <!--/.content-->
      <script type="text/javascript">
      	$(document).ready(function(){
      		
      		$('#batch-link').click(function(e){ 
      			alert("hello");
      		})
      	})
      </script>
    </body>
</html>