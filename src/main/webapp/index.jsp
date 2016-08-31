<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1, width=device-width, initial-scale=1">
<title>User Database Home Page</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">

			<!-- side bar -->
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="add.html">Add a user</a></li>
				</ul>
			</div>

			<!-- main content -->
			<div class="col-sm-6">
				<div class="row placeholders">

					<h2 class="Users">Users</h2>
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th class="col-sm-1">ID #</th>
									<th class="col-sm-3">Username</th>
									<th class="col-sm-2">First name</th>
									<th class="col-sm-3">Email</th>
									<th class="col-sm-1">Age</th>
									<th class="col-sm-1">Edit</th>
									<th class="col-sm-1">Delete</th>
								</tr>
							</thead>
							<tbody>

								<%@ page
									import="java.util.ArrayList, com.usernameDB.DAO, com.usernameDB.Users"%>
								<%!ArrayList<Users> allUsers = new ArrayList<>();%>
								<%!String uID = null;%>
								<%
									allUsers = DAO.readFromDB();
								%>
								<%
									for (int i = 0; i < allUsers.size(); i++) {
								%>

								<%
									Users currentUser = allUsers.get(i);
								%>
								<%
									uID = currentUser.getUserID();
								%>
								<tr>
									<td id="id<%out.print(uID);%>">
										<%
											out.print(uID);
										%>
									</td>
									<td>
										<%
											out.print(currentUser.getUserName());
										%>
									</td>
									<td>
										<%
											out.print(currentUser.getRealName());
										%>
									</td>
									<td>
										<%
											out.print(currentUser.getEmail());
										%>
									</td>
									<td>
										<%
											out.print(currentUser.getAge());
										%>
									</td>
									<td><button id="edit">
											<img src="file_edit.png" width="17" height="17"
												class="img-responsive">
										</button></td>
									<form name="delete" action="DeleteUserServlet" method="post">
									<td><button name="delete" type="submit" value="<%out.print(uID);%>">
											<img src="file_delete.png" width="16" height="16"
												class="img-responsive">
										</button></td>
									</form>
								</tr>

								<%
									} // for loop
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>