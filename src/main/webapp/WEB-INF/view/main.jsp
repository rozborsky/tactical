<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<div id="contentDiv">

<h1>mainPage</h1>
<c:forEach var="listValue" items="${goodsCategories}">
	<a href="/InternetShop/${listValue.getName()}"><img src="resources/homePage/${listValue.getImage()}"/></a>
</c:forEach>

</div>
<jsp:include page="footer.jsp" />
