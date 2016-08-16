<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp" />

<h1>${goods.getTitle()}</h1>

<p>${goods.getDescription()}</p>

<h1>${goods.getPrice()}</h1>

<form:form action="${goods.getTitle()}" method="post"  modelAttribute="goodsInCart">
    <table border="0">
        <tr>
            <td>
                <form:input path="title" type="hidden" value="${goods.getTitle()}"/>
                <form:input path="prise" type="hidden" value="${goods.getPrice()}"/>
                <form:label path="number">number</form:label></br>
                <form:input path="number" value="1"/>
                <form:errors path="number" id="error"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit"  value="add to cart"/></td>
            </td>
        </tr>
    </table>
</form:form>
<p id="todo">prise fomat</p>
<jsp:include page="footer.jsp" />