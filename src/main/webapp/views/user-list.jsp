<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/></head>
<body>
<div class="content">
		<div class="module">
			<div class="module-head">
				<h3>User</h3>
			</div>
			<div class="btn-controls">
                <div class="btn-box-row row-fluid">
                	<a href="initAddUser"><button type="button" class="btn btn-primary" 
                	style="float: right; margin: 5px">Create</button></a>
                </div>
            </div>
			<div class="module-body table">
				<table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display" width="100%">
					<thead>
						<tr>
							<th>Name</th>
							<th>User Name</th>
							<th>Role</th>
							<th>Active</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.name}</td>
							<td>${user.userName}</td>
							<td>${user.roleId.roleName}</td>
							<td class="center">${user.active}</td>
							<td>
								<a href="initEditProfile?userId=${user.userId}" style="text-decoration: none;">Edit</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div><!--/.module-->					
	</div><!--/.content-->
    <!--/.content-->
</body>
</html>
