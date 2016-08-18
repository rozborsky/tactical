<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp" />

<h1>cart</h1>
<table border="1">
<c:forEach var="listValue" items="${order.getOrder()}">
<tr>
    <td id="goods">
		${listValue.getTitle()}
	</td>
	<td id="number">
		${listValue.getNumber()}
	 </td>
	 <td>
		<form action="removeGoods" method="post">
			<input name="login" value="${listValue.getTitle()}" type="hidden"/>
			<input type="submit" value="delete" />
		</form>
	 </td>
<tr>
</c:forEach>
</table>
<p>total - ${order.totalPrise()}$</p>
<button><a href="personalCabinet">make a purchase</a></button>
<jsp:include page="footer.jsp" />