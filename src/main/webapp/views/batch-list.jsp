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
		<div class="module">
			<div class="module-head">
				<h3>Batch</h3>
			</div>
			<div class="btn-controls">
                <div class="btn-box-row row-fluid">
                	<a href="initBatchDetail"><button type="button" value="save" class="btn btn-primary" 
                	style="float: right; margin: 5px">Create</button></a>
                </div>
            </div>
			<div class="module-body table">
				<table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display" width="100%">
					<thead>
						<tr>
							<th>No</th>
							<th>Batch name</th>
							<th>Language</th>
							<th>Start date</th>
							<th>End date</th>
							<th>Active</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${batches}" var="batch" varStatus="i">
						<tr class="gradeA">
							<td>${i.count}</td>
							<td>${batch.batchName}</td>
							<td>${batch.languageId.languageName}</td>
							<td>${batch.startDate}</td>
							<td>${batch.endDate}</td>
							<td>${batch.active}</td>
							<td>
								<a href="assign-course?batchId=${batch.batchId}" onclick="" style="text-decoration: none;">
									<button id="btn-assign" class="btn btn-primary" style="float: right; margin: 5px;" data-toggle="modal" data-target="#assgin-course">Assign Course</button>
								</a>
							</td>
							<td>
								<a href="initBatchConfig?batchId=${batch.batchId}" style="text-decoration: none;">Detail</a> | 
								<a href="initBatchDetail?batchId=${batch.batchId}" style="text-decoration: none;">Edit</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div><!--/.module-->					
	</div><!--/.content-->

	<script>
		$(document).ready(function() {
			$('.datatable-1').dataTable();
			$('.dataTables_paginate').addClass("btn-group datatable-pagination");
			$('.dataTables_paginate > a').wrapInner('<span />');
			$('.dataTables_paginate > a:first-child').append('<i class="icon-chevron-left shaded"></i>');
			$('.dataTables_paginate > a:last-child').append('<i class="icon-chevron-right shaded"></i>');

		});
	</script>
	 <!-- Modal inport -->
		<div id="assgin-course" class="modal fade" role="dialog">
		  <div class="modal-dialog">
			<form action="import-course" enctype="multipart/form-data" method="POST">
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Assign Course</h4>
			        <h4 id="title"></h4>
			      </div>
			      
			      <div class="modal-body">
			      	<div class="module-body table">
						<table id="tb" cellpadding="0" cellspacing="0" border="0" class="table table-bordered table-striped	 display">
							<thead>
								<tr>
									<th>No</th>
									<th>Name</th>
									<th>Duration</th>
									<th>Lecture</th>
									<th>Language</th>
									<th>Level</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="course" items="${courses}" varStatus="i">
								<tr>
									<td>${i.count}</td>
									<td>${course.name}</td>
									<td>${course.learningDuration}</td>
									<td>${course.numberOfLecture}</td>
									<td>${course.languageId.languageName}</td>
									<td>${course.levelId.levelName}</td>
									<td>
										<a href="assign-course?batchId=${batch.batchId}" onclick="assign-course" style="text-decoration: none;">
											<button id="btn-assign" class="btn btn-primary" style="float: right; margin: 5px;" data-toggle="modal" data-target="#assgin-course">Assign</button>
										</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			</form>
		  </div>
		</div>
</body>
</html>