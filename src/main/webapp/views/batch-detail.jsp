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
			<div class="module-body">
			<c:set var="batchLanguageId" value="${batch.languageId.languageId}"/>
			<c:set var="batchActive" value="${batch.active}"/>
				<form class="form-horizontal row-fluid" id="batch-detail" action="saveBatch" method="post" enctype="multipart/form-data">
					<div class="control-group" style="display: none;">
						<div class="controls">
							<input type="text" id="batchId" name="batchId" placeholder="Name" class="span8" value="${batch.batchId}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Batch name</label>
						<div class="controls">
							<input type="text" id="batchName" name="batchName" placeholder="Class Name" class="span8" value="${batch.batchName}">
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">Start date</label>
						<div class="controls">
							<input type="date" id="startDate" name="startDate" class="span8 tip" value="${batch.startDate}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">End date</label>
						<div class="controls">
							<input type="date" id="endDate" name="endDate" class="span8 tip" value="${batch.endDate}">
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="basicinput">Language</label>
						<div class="controls">
							<select tabindex="1" id="languageId" name="languageId" data-placeholder="Select here.." class="span8">
							<c:forEach items="${languages}" var="language">
								<c:set var="tmpLanguageId" value="${language.languageId}"></c:set>
								<c:choose>
								<c:when test="${batchLanguageId == tmpLanguageId}">
									<option value="${language.languageId}" selected>${language.languageName}</option>
								</c:when>
								<c:otherwise>
									<option value="${language.languageId}">${language.languageName}</option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
							
							</select>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label">Import Fresher</label>
						<div class="controls">
							<input type="file" id="fresherFile" name="fresherFile">
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label">Active</label>
						<div class="controls">
							<label class="checkbox inline">
								<c:choose>
								<c:when test="${batchActive == true}">
									<input type="checkbox" id="active" name="active" value="true" checked>
								</c:when>
								<c:otherwise>
									<input type="checkbox" id="active" name="active" value="true">
								</c:otherwise>
								</c:choose>
								active
							</label>
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-success">Save</button>
							<button type="button" id="btn-cancel" class="btn btn-danger">Cancel</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div><!--/.content-->
</body>
</html>