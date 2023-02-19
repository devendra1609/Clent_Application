<!DOCTYPE HTML>
<html>
	<head>
		<title>AddCategory</title>
	</head>
	<body>
		<form action="addCategory" method="post">
			<table>
				<tr>
					<th>Category Name</th>
					<td>
						<input type="text" name="categoryName">
					</td>
				</tr>
				<tr>
					<th>Category Code</th>
					<td>
						<input type="text" name="categoryCode">
					</td>
				</tr>
				<tr>
					<th>Category Description</th>
					<td>
						<textarea name="categoryDescription"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="AddCategory">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>