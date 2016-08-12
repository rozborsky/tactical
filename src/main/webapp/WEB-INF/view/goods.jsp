<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />

<h1>${goods.getTitle()}</h1>

<p>${goods.getDescription()}</p>

<h1>${goods.getPrice()}</h1>

<jsp:include page="footer.jsp" />