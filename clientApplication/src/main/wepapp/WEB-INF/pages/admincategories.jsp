<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>AdminCategories</title>
	</head>
	<body>
		<table>
			<tr>
				<th>SNO</th>
				<th>CategoryName</th>
				<th>CategoryCode</th>
				<th>CategoryDescription</th>
				<th> </th>
			</tr>
			<c:forEach items="${categories}" var="categories" varStatus="st">
				<tr>
					<td>${st.count}</td>
					<td>${categories.categoryName}</td>
					<td>${categories.categoryCode }</td>
					<td>${categories.categoryDescription }</td>
					<td>
						<a href="editcategory?categoryId=${categories.categoryId }">EditCategory</a>
						<a href="deletecategory?categoryId=${categories.categoryId }">DeleteCategory</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>