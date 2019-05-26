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
				<h3>User</h3>
			</div>
			<div class="module-body">
			<c:set var="userRoleId" value="${user.roleId.roleId}"/>
			<c:set var="userActive" value="${user.active}"/>
					<form class="form-horizontal row-fluid" action="editProfile" method="post">
						<div class="control-group" style="display: none;">
							<div class="controls">
								<input type="text" id="userId" name="userId" placeholder="Name" class="span8" value="${user.userId}">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="basicinput">Name</label>
							<div class="controls">
								<input type="text" id="name" name="name" placeholder="Name" class="span8" value='<c:out value="${user.name}"></c:out>'>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="basicinput">User name</label>
							<div class="controls">
								<input type="text" id="userName" name="userName" placeholder="Username" class="span8 tip" value="${user.userName}">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="basicinput">password</label>
							<div class="controls">
								<input type="password" id="password" name="password" placeholder="password" data-original-title="" class="span8 tip" value="${user.password}">
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="basicinput">Role</label>
							<div class="controls">
								<select tabindex="1" id="roleId" name="roleId" data-placeholder="Select here.." class="span8">
								<c:forEach items="${roles}" var="role">
								<c:set var="tmpRoleId" value="${role.roleId}"></c:set>
								<c:choose>
								<c:when test="${userRoleId == tmpRoleId}">
									<option value="${role.roleId}" selected>${role.roleName}</option>
								</c:when>
								<c:otherwise>
									<option value="${role.roleId}">${role.roleName}</option>
								</c:otherwise>
								</c:choose>
								</c:forEach>
								</select>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label">Active</label>
							<div class="controls">
								<label class="checkbox inline">
								<c:choose>
								<c:when test="${userActive == true}">
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
								<button type="submit" value="save" id="btn-create-user" class="btn btn-success">Submit</button>
								<button type="button" id="btn-cancel" class="btn btn-danger">Cancel</button>
							</div>
						</div>
					</form>
			</div>
		</div>
	</div><!--/.content-->

	<script type="text/javascript">
		$(document).ready(function(e){
			$('#btn-cancel').click(function(){
				document.location.href = "other-user-listing.html";
			})
		})
	</script>
</body>
</html>
