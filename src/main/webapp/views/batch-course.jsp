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
				<h3>Course</h3>
			</div>
			<div class="btn-controls">
                <div class="btn-box-row row-fluid">
                	<button type="button" id="btn-create-course" value="add-course" class="btn btn-primary" 
                	style="float: right; margin: 5px;" id="btn-modal">Create</button>
                	<button type="button" id="btn-import-course" value="import-course" class="btn btn-primary" 
                	style="float: right; margin: 5px;" id="btn-modal">Import</button>
                </div>
            </div>
            <div id="show-modal"></div>
			<div class="module-body table">
				<table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display" width="100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Number of lecture</th>
							<th>Language</th>
							<th>Level</th>
						</tr>
					</thead>
					<tbody>
						<tr class="gradeA">
							<td>Gecko</td>
							<td>Netscape Navigator 9</td>
							<td>Win 98+ / OSX.2+</td>
							<td class="center">1.8</td>
							<td class="center">A</td>
						</tr>
						<tr class="gradeA">
							<td>Gecko</td>
							<td>Mozilla 1.0</td>
							<td>Win 95+ / OSX.1+</td>
							<td class="center">1</td>
							<td class="center">A</td>
						</tr>
						<tr class="gradeA">
							<td>Gecko</td>
							<td>Mozilla 1.1</td>
							<td>Win 95+ / OSX.1+</td>
							<td class="center">1.1</td>
							<td class="center">A</td>
						</tr>
						<tr class="gradeA">
							<td>Gecko</td>
							<td>Mozilla 1.2</td>
							<td>Win 95+ / OSX.1+</td>
							<td class="center">1.2</td>
							<td class="center">A</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div><!--/.module-->
	</div><!--/.content-->
	<script>
		$(document).ready(function(e) {
			$('.datatable-1').dataTable();
			$('.dataTables_paginate').addClass("btn-group datatable-pagination");
			$('.dataTables_paginate > a').wrapInner('<span />');
			$('.dataTables_paginate > a:first-child').append('<i class="icon-chevron-left shaded"></i>');
			$('.dataTables_paginate > a:last-child').append('<i class="icon-chevron-right shaded"></i>');
			
			// $('#btn-modal').click(function(){
			// 	$.post('course-form.html', function(result){
			// 		alert(result);
			// 		$('#show-modal').load(result);
			// 		$('#course').modal('show');
			// 	})
			// })
		} );
	</script>
</body>