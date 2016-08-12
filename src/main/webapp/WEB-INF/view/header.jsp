<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>tactical</title>
        <style>
           <%@include file='style.css' %>
        </style>
	</head>

	<body>
        <div id="header">
            <div id="headerSign">
                <div id="contentDiv">
                    <ul id="signLinks">
                         <li><a href="/InternetShop">Home</a></li>
                         <li><a href="/InternetShop/getSertificates">Get Certificates</a></li>
                         <li>_____________________</li>
                         ${registrationSignInOrName}
                         <li><a href="cart">CART</a></li>
                         <li> total - ${sessionScope.order.totalPrise()}$</li>

                    </ul>
                </div>
            </div>

            <div id="headerNavigation">
                <div id="contentDiv">
                    <ul id="signLinks">
                         <li><a href="/InternetShop/footwear">FOOTWEAR</a></li>
                         <li><a href="/InternetShop/clothing">CLOTHING</a></li>
                         <li><a href="/InternetShop/gear">GEAR</a></li>
                         <li><a href="/InternetShop/deals">DEALS</a></li>
                         <li><a href="/InternetShop/brands">BRANDS</a></li>
                    </ul>
                </div>
            </div>
        </div>