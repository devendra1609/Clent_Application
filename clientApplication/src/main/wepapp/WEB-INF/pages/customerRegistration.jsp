<!DOCTYPE HTML>
<html>
<head>
<title>Customer Registration</title>
</head>
<body>
	<form action="customerRegistration" method="post">
		<table>
			<tr>
				<th>CustomerId</th>
				<td><input type="text" name="customerId"></td>
			</tr>
			<tr>
				<th>FirstName</th>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<th>lastName</th>
				<td><input type="text" name="lastName"></td>
			</tr>

			<tr>
				<th>EmailId</th>
				<td><input type="email" name="emailId"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th>MobileNumber</th>
				<td><input type="number" name="mobileNumber"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Registartion"></td>
			</tr>
		</table>
	</form>
</body>
</html>