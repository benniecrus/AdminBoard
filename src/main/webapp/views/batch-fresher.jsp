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
				<h3>Fresher</h3>
			</div>
			<div class="btn-controls">
                 <div class="btn-box-row row-fluid">
                 	<a href="add-fresher"><button type="button" class="btn btn-primary" style="float: right; margin: 5px;">Create</button></a>
                 	<button type="button" class="btn btn-primary" style="float: right; margin: 5px;" value="import-fresher">Import</button>
        <!--          	<button type="button" class="btn btn-warning" style="float: right; margin: 5px; background-color: Tomato;" >Export</button> -->
                 </div>
             </div>
			<div class="module-body table">
				<table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped display" width="100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Location</th>
							<th>Birthday</th>
							<th>Batch Name</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="fresher" items="${freshers}">
						<tr>
							<td>${fresher.fresherId}</td>
							<td>${fresher.name}</td>
							<td>${fresher.location}</td>
							<td>${fresher.birthday}</td>
							<td>${fresher.batchId.batchName}</td>
							<td>
								<a href="edit-fresher?fresherId=${fresher.fresherId}" onclick="edit-fresher" style="text-decoration: none;">Edit</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div><!--/.content-->
	<script>
		$(document).ready(function() {
			$('.datatable-1').dataTable();
			$('.dataTables_paginate').addClass("btn-group datatable-pagination");
			$('.dataTables_paginate > a').wrapInner('<span />');
			$('.dataTables_paginate > a:first-child').append('<i class="icon-chevron-left shaded"></i>');
			$('.dataTables_paginate > a:last-child').append('<i class="icon-chevron-right shaded"></i>');
		} );
	</script>
</body>