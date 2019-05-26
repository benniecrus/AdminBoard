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
			<div class="module-body">
				<form class="form-horizontal row-fluid" action="save-course" method="post" id="course-detail">
				<input type="hidden" name="batchId" value="${batch.batchId}">
					<div class="control-group" style="display: none;">
						<div class="controls">
							<input type="text" id="courseId" name="courseId" placeholder="Name" class="span8" value="${course.courseId }"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Name</label>
						<div class="controls">
							<input type="text" id="name" name=name placeholder="Name" class="span8" value="${course.name}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">Duration</label>
						<div class="controls">
							<input type="number" id="learningDuration" name="learningDuration" class="span8 tip" value="0" value="${course.learningDuration}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">Number of lecture</label>
						<div class="controls">
							<input type="number" id="numberOfLecture" name="numberOfLecture" class="span8 tip" value="0" value="${course.numberOfLecture}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="basicinput">Level</label>
						<div class="controls">
							<select tabindex="1" id="levelId" name="levelId" data-placeholder="Select here.." class="span8">
							<c:forEach var="level" items="${levels}">
								<option value="${level.levelId }">${level.levelName}</option>
							</c:forEach>
							</select>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="basicinput">Language</label>
						<div class="controls">
							<select tabindex="1" id="languageId" name="languageId" data-placeholder="Select here.." class="span8">
								<c:forEach var="language" items="${languages}">
									<option value="${language.languageId}">${language.languageName}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<button type="submit" id="btn-create-course" class="btn btn-success">Submit</button>

							<a href="cancel"><button type="button" id="btn-cancel" class="btn btn-danger">Cancel</button></a>
						</div>
					</div>
				</form>
 			</div>
		</div>
	</div> --><!--/.content-->
</body>
</html>