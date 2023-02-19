<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<table>
			<tr>
				<th><spring:message code="lbl.userName"/></th>
				<td>
					<input type="text" name="userName">
				</td>
			</tr>
			<tr>
				<th><spring:message code="lbl.password"/></th>
				<td>
					<input type="text" name="password">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="<spring:message code='btn.login'/>">
				</td>
			</tr>
		</table>
	</body>
</html>