<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />

    <div>
        <form:form action="confirmRegistration" method="post" commandName="buyer">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Registration</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="name" /></td><td><form:errors path="name"/></td>
                </tr>
                <tr>
                    <td>surname:</td>
                    <td><form:input path="surname" /></td><td><form:errors path="surname"/></td>
                </tr>
                <tr>
                    <td>eMail:</td>
                    <td><form:input path="eMail" /></td><td><form:errors path="eMail"/></td>
                </tr>
                <tr>
                    <td>address:</td>
                    <td><form:input path="address" /></td><td><form:errors path="address"/></td>
                </tr>
                <tr>
                    <td>phone:</td>
                    <td><form:input path="phone" /></td><td><form:errors path="phone"/></td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><form:input path="password" /></td><td><form:errors path="password"/></td>
                </tr>
                <tr>
                    <td>confirm password:</td>
                    <td><form:input path="password" /></td><td><form:errors path="password"/></td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form:form>

        <p>message error eMail</p>
    </div>
<jsp:include page="footer.jsp" />