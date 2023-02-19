<!DOCTYPE HTML>
<html>
	<head>
		<title>UpdateCategory</title>
	</head>
	<body>
		<form action="updateCategory" method="post">
			<table>
				<tr>
					<th>Category Name</th>
					<td>
						<input type="text" name="categoryName" value="${requestScope.category.categoryName }">
					</td>
				</tr>
				<tr>
					<th>Category Code</th>
					<td>
						<input type="text" name="categoryCode" value="${requestScope.category.categoryCode }">
					</td>
				</tr>
				<tr>
					<th>Category Description</th>
					<td>
						<textarea name="categoryDescription" >${requestScope.category.categoryDescription }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="update">
						<input type="hidden" name="categoryId" value="${requestScope.category.categoryId }">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>