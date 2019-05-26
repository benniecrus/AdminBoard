<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<style type="text/css">
		label.control-label{
			display: inline-flex;
			width: 100px;
		}
		.controls{
			display: inline;
		}
		span{
			padding-right: 10px;
		}
	</style>
</head>
<body>
	<div class="content">
		<div class="module">
			<div class="module-head">
				<h3>Batch</h3>
			</div>
			<div class="module-body">
					<div class="control-group">
						<div class="controls">
							
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Batch name</label>
						<div class="controls">
							<span>${batch.batchName}</span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">Start date</label>
						<div class="controls">
							<span>${batch.startDate}</span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">End date</label>
						<div class="controls">
							<span>${batch.endDate}</span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="basicinput">Language</label>
						<div class="controls">
							<span>${batch.languageId.languageName}</span>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label">Number of Freshers</label>
						<div class="controls">
							<span>${numberFresher}</span> <a href="initFresherList?batchId=${batch.batchId}">Manage Fresher</a>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label">Number of Courses</label>
						<div class="controls">
							<span>${numberCourse}</span> <a href="initCourseList?batchId=${batch.batchId}">Manage Course</a>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label">Active</label>
						<div class="controls">
							<span>${batch.active}</span>
						</div>
					</div>

			</div>
		</div>
	</div><!--/.content-->
</body>
</html>