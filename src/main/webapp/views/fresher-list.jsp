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
                 	<button id="btn-inport" class="btn btn-primary" style="float: right; margin: 5px;" data-toggle="modal" data-target="#myModal">Import</button>
                 	<button id="btn-open-modal-export" class="btn btn-warning" style="float: right; margin: 5px; background-color: Tomato;" data-toggle="modal" data-target="#myModalExport">Export</button>
                 </div>
             </div>
			<div class="module-body table">
				<table id="tb" cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped display" width="100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Location</th>
							<th>Birthday</th>
							<th>Class name</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="fresher" items="${freshers}" varStatus="i">
						<tr onclick="show">
							<td>${i.count}</td>
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
	
	
	<!--Modal export  -->
		<div id="myModalExport" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Export to file</h4>
		      </div>
		      
		      <div class="modal-body">
		      	<p>Do you want to export to excel file!</p>
		      </div>
		      <div class="modal-footer">
		       	<button type="button" class="btn btn-primary"  id="btn-export">Export</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		 <!-- Modal inport -->
		<div id="myModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">
			<form action="import-fresher" enctype="multipart/form-data" method="POST">
				<input type="hidden" name="batchId" value="${batch.batchId}">
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Choose file</h4>
			        <h4 id="title"></h4>
			      </div>
			      
			      <div class="modal-body">
			      	<input type="file" id="fresherFile" name="fresherFile">
			      </div>
			      <div class="modal-footer">
			       	<button type="submit" class="btn btn-primary"  id="btn-import">Import</button>
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			</form>
		  </div>
		</div>
</body>
	<script>
		$(document).ready(function() {
			$('.datatable-1').dataTable();
			$('.dataTables_paginate').addClass("btn-group datatable-pagination");
			$('.dataTables_paginate > a').wrapInner('<span />');
			$('.dataTables_paginate > a:first-child').append('<i class="icon-chevron-left shaded"></i>');
			$('.dataTables_paginate > a:last-child').append('<i class="icon-chevron-right shaded"></i>');
		});
		$(document).ready(function(){
			$('#btn-export').click(function(){
				$("#myModal").modal("hide");
				$("#tb").table2excel({
					exclude: ".noExl",
					name: "Worksheet Name"
				})
				
			})
			  
		})
	</script>
</html>