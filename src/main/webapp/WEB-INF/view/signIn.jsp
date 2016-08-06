<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp" />
<h1>signIn</h1>
<h3>${previousPage}</h3>
<div>
        <form:form action="signIn" method="post" modelAttribute="loggedBuyer">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Sign in</h2></td>
                </tr>
                <tr>
                    <td>login:</td>
                    <td><form:input path="login" /></td>
                    <td><form:errors path="login"  id="error"/></td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><form:input path="password"/></td>
                    <td><form:errors path="password"  id="error"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Sign In" /></td>
                </tr>
            </table>
        </form:form>

<jsp:include page="footer.jsp" />
