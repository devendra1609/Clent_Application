<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>AdminSubCategories</title>
	</head>
	<body>
		<table>
			<tr>
				<th>SNO</th>
				<th>SubCategoryName</th>
				<th>SubCategoryCode</th>
				<th>SubCategoryDescription</th>
				<th> </th>
			</tr>
			<c:forEach items="${subCategories}" var="subcategories" varStatus="st">
				<tr>
					<td>${st.count}</td>
					<td>${subcategories.subCategoryName}</td>
					<td>${subcategories.subCategoryCode }</td>
					<td>${subcategories.subCategoryDescription }</td>
					<td>
						<a href="editsubcaretory?subCategoryId=${subcategories.subCategoryId }">EditSubCategory</a>
						<a href="deletesubcategory?subCategoryId=${subcategories.subCategoryId }">DeleteSubCategory</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>