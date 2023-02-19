<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>AdminProducts</title>
	</head>
	<body>
		<table>
			<tr>
				<th>SNO</th>
				<th>ProductName</th>
				<th>ProductCode</th>
				<th>ProductDescription</th>
				<th>ProductImageName</th>
				<th>CategoryId</th>
				<th>SubCategoryId</th>
				<th>ProductStatus</th>
			</tr>
			<c:forEach items="${products}" var="products" varStatus="st">
				<tr>
					<td>${st.count}</td>
					<td>${products.categoryName}</td>
					<td>${products.categoryCode }</td>
					<td>${products.categoryDescription }</td>
					<td>${products.productImageName}</td>
					<td>${products.categoryId}</td>
					<td>${products.subCategoryId}</td>
					<td>${products.productStatus}</td>
					<td>
						<a href="editproduct?productId=${products.productId }">EditProduct</a>
						<a href="deleteproduct?productId=${products.productId }">DeleteProduct</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>