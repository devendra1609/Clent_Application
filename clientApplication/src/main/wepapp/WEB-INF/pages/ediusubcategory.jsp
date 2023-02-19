<!DOCTYPE HTML>
<html>
	<head>
		<title>UpdateSubCategory</title>
	</head>
	<body>
		<form action="updateSubCategory" method="post">
			<table>
				<tr>
					<th>Sub Category Name</th>
					<td>
						<input type="text" name="subCategoryName" value="${requestScope.subCategory.subCategoryName }">
					</td>
				</tr>
				<tr>
					<th>Sub Category Code</th>
					<td>
						<input type="text" name="subCategoryCode" value="${requestScope.subCategory.subCategoryCode }">
					</td>
				</tr>
				<tr>
					<th>Sub Category Description</th>
					<td>
						<textarea name="subCategoryDescription" >${requestScope.subCategory.subCategoryDescription }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="update">
						<input type="hidden" name="subCategoryId" value="${requestScope.subcategory.subCategoryId }">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>