<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />
<h1>footwear</h1>
<p>
    You`ve known what an important piece of the uniform tactical boots are from the day you enlisted. In training you went on grueling marches, stood in formation during heat and rain, and tackled tough obstacle courses. Every day during that life-changing experience you relied on your boots to provide you with support and keep your feet protected so you could successfully finish boot camp a tougher, stronger, better service member. You found out just how important the right pair of combat boots can be.
    Now that you are looking for tactical boots for your career, you know that you need to choose a pair that keeps you on the path to being a better service member. You don’t want your boots to be a reason that you aren’t in the best shape. Whether this is one of your first pairs of military boots or this is one of a long history of pairs that have served you well while you were serving your country, we want to make your purchase as easy as possible.
    Finding the right pair of military boots for your branch does not have to be a difficult task. U.S. Patriot Tactical has all types and brands of tactical boots. We are a veteran-owned business, so we know that you need to find your footwear without a lot of hassle and get back to serving your country and your community. Thank you for choosing U.S. Patriot, and thank you for your service.

    Free exchanges on most boots and shoes! If your footwear doesn't meet your expectations, we'll pick up the round trip shipping one time to get you another pair (50 US states only, excludes Rothco products). See complete policy for details.
</p>
<c:forEach var="listValue" items="${goodsCategories}">
	<a href="/InternetShop/footwear/${listValue.getName()}"><img src="resources/footwear/${listValue.getImage()}"/></a>
</c:forEach>

<jsp:include page="footer.jsp" />