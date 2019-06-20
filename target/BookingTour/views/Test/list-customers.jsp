<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>javaguides.net</title>
<link href="<c:url value="/assets/css/bootstrap.min.css" />"
	rel="stylesheet" />
<script src="<c:url value="/assets/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/assets/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>CRM - Customer Relationship Manager</h2>
			<hr />

			<input type="button" value="Add Customer"
				onclick="window.location.href='showForm'; return false;"
				class="btn brn-primary" /> <br /> <br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Customer List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>

						<c:forEach var="tempCustomer" items="${customers}">
							<c:url var="updateLink" value="/customer/updateForm">
								<c:param name="customerId" value="${tempCustomer.id}" />
							</c:url>

							<c:url var="deleteLink" value="/customer/delete">
								<c:param name="customerId" value="${tempCustomer.id }" />
							</c:url>

							<tr>
								<td>${tempCustomer.firstName}</td>
								<td>${tempCustomer.lastName}</td>
								<td>${tempCustomer.email}</td>
								<td><a href="${updateLink}">Update</a></td> |
								<a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>

							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>