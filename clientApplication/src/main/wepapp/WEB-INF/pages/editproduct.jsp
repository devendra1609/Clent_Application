<!DOCTYPE HTML>
<html>
	<head>
		<title>EditProduct</title>
	</head>
	<body>
		<form action="updateProduct" method="post">
			<table>
				<tr>
					<th>Product Name</th>
					<td>
						<input type="text" name="productName" value="${requestScope.product.productName }">
					</td>
				</tr>
				<tr>
					<th>Product Code</th>
					<td>
						<input type="text" name="productCode" value="${requestScope.product.productCode }">
					</td>
				</tr>
				<tr>
					<th>Product Description</th>
					<td>
						<textarea name="productDescription" >${requestScope.product.productDescription }</textarea>
					</td>
				</tr>
				<tr>
					<th>category Id</th>
					<td>
						<textarea name="categoryId" >${requestScope.product.categoryId }</textarea>
					</td>
				</tr>
				<tr>
					<th>Sub category Id</th>
					<td>
						<textarea name="subCategoryId" >${requestScope.product.subCategoryId }</textarea>
					</td>
				</tr>
				<tr>
					<th>Product Status</th>
					<td>
						<textarea name="productStatus" >${requestScope.product.productStatus }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="update">
						<input type="hidden" name="productId" value="${requestScope.product.productId }">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>