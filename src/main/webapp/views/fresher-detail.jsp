<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
			<div class="module-body">

					<form class="form-horizontal row-fluid" action="save-fresher" method="POST" id="fresher-detail">
						<input type="hidden" name="batchId" value="${batch.batchId}">
						<div class="control-group" style="display: none;">
							<div class="controls">
								<input type="text" id="fresherId" name="fresherId" value="${fresher.fresherId}" class="span8">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Name</label>
							<div class="controls">
								<input type="text" id="name" name="name" placeholder="Name" class="span8" value="${fresher.name}">
							</div>
						</div>

						<div class="control-group">
							<label class="control-label">Location</label>
							<div class="controls">
								<input type="text" id="location" name="location" placeholder="Location" class="span8 tip" value="${fresher.location}">
							</div>
						</div>

						<div class="control-group">
							<label class="control-label">Birthday</label>
							<div class="controls">
								<input type="date" id="birthday" name="birthday" placeholder="Birthday" class="span8 tip" value="${fresher.birthday}">
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="basicinput">Batch</label>
							<div class="controls">
								<select tabindex="1" id="batchId" name="batchId" data-placeholder="Select here.." class="span8">
									<c:forEach var="batch" items="${batchs}">
										<option value="${batch.batchId}">${batch.batchName}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label">Active</label>
							<div class="controls">
								<label class="checkbox inline">
									<input type="checkbox" id="active" name="active" value="${fresher.active}">
									Status
								</label>
							</div>
						</div>

						<div class="control-group">
							<div class="controls">
								<button type="submit" id="btn-submit" class="btn btn-success">Submit</button>
								<a href="cancel"><button type="button" id="btn-cancel" class="btn btn-danger">Cancel</button></a>
							</div>
						</div>
					</form>
			</div>
		</div>
	</div><!--/.content-->
	
</body>
</html>