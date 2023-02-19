<!DOCTYPE HTML>
<html>
	<head>
		<title>AddProduct</title>
	</head>
	<body>
		<form action="addProduct" method="post">
			<table>
				<tr>
					<th>Product Name</th>
					<td>
						<input type="text" name="productName">
					</td>
				</tr>
				<tr>
					<th>Product Code</th>
					<td>
						<input type="text" name="productCode">
					</td>
				</tr>
				<tr>
					<th>Product Description</th>
					<td>
						<textarea name="productDescription"></textarea>
					</td>
				</tr>
				<tr>
					<th>Product Image Name</th>
					<td>
						<input type="text" name="productImageName">
					</td>
				</tr>
				<tr>
					<th>CategotyId</th>
					<td>
						<input type="text" name="categoryId">
					</td>
				</tr>
				<tr>
					<th>Product Status</th>
					<td>
						<input type="text" name="productStatus">
					</td>
				</tr>
				<tr>
					<th>SubCategoryId</th>
					<td>
						<input type="text" name="subCategoryId">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="AddProduct">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>