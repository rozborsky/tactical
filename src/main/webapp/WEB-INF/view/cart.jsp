<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp" />

<h1>cart</h1>
<table border="0">
<c:forEach var="listValue" items="${order.getOrder ()}">
<tr>
    <td>
		${listValue.getTitle()}
	</td>
	<td>
		${listValue.getNumber()}
	 </td>
<tr>
</c:forEach>
</table>
<p>total - ${order.totalPrise()}$</p>
<jsp:include page="footer.jsp" />