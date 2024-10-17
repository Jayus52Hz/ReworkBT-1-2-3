<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<form action="${pageContext.request.contextPath}/admin/category/update"
	method="post" enctype="multipart/form-data">
	<input type="text" id="categoryid" name="categoryid"
		value="${cate.categoryid}" hidden="hidden"><br> <label
		for="categoryname">Category name:</label><br> <input type="text"
		id="categoryname" name="categoryname" value="${cate.categoryname}"><br>
	<label for="images">Images:</label><br>
	<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
	<td><img height="150" width="200" src="${imgUrl}" id="imagess" /></td>
	<c:choose>
		<c:when test="${cate.images.substring(0,5)=='https'}">
			<c:url value="${cate.images}" var="imgUrl"></c:url>
		</c:when>
		<c:otherwise>
			<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
		</c:otherwise>
	</c:choose>
	<input type="file" name="images" value="/image?fname=${cate.images}"
		onchange="choosefile(this)"><br> <br> <label
		for="status">Status:</label><br> <input type="text" id="status"
		name="status" value="${cate.status}"><br> <br> <input
		type="submit" value="Submit">

</form>
