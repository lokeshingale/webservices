<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Get Student List</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty listDto}">
			<table>
				<tr>
					<td>Serial NO</td>
					<td>Student NO</td>
					<td>Name</td>
					<td>DOB</td>
					<td>DOJ</td>
				</tr>
				<c:forEach var="dto" items="${listDto}">
					<tr>
						<td>${dto.SerialNo}</td>
						<td>${dto.Student_No}</td>
						<td>${dto.name}</td>
						<td>${dto.dob}</td>
						<td>${dto.doj}</td>
					</tr>

				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h3>Data not found</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>