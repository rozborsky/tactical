<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>

<jsp:include page="header.jsp" />

	<h1>Spring Security - Sign In</h1>

	<div style="color: red">${message}</div>

	<form class="login-form" action="j_spring_security_check" method="POST">
			<label for="j_username">Username: </label>
		 	<input id="j_username" name="username" size="20" maxlength="50" type="text" />

			<label for="j_password">Password: </label>
			<input id="j_password" name="password" size="20" maxlength="50" type="password" />

			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

			<input type="submit" value="Login" />
	</form>

<jsp:include page="footer.jsp" />