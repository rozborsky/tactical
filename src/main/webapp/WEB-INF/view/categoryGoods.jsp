<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />

<h1>${title}</h1>

<p>${description}</p>

<c:forEach var="listValue" items="${content}">
    <a href="/InternetShop/${title}/${listValue.getTitle()}"><img src="resources/footwear/army.jpg"/>${listValue.getTitle()}</a></br>
</c:forEach>

<jsp:include page="footer.jsp" />