<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CoinMarketCap</title>


<spring:url value="../resources/DataTables/datatables.css" var="datatablesCssUrl"/>
<spring:url value="../resources/DataTables/datatables.js" var="datatablesJsUrl"/>
<spring:url value="../resources/jquery-ui.js" var="jqueryUiJsUrl"/>
<spring:url value="../resources/coinMarketCap.js" var="coinMarketCapJsUrl"/>
<spring:url value="../resources/coinMarketCap.css" var="coinMarketCapCssUrl"/>
<spring:url value="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.4.2/knockout-debug.js" var="KnockoutJsUrl"></spring:url>


<%@ include file="commonFiles.jsp" %>

<link href="${datatablesCssUrl}" rel="stylesheet">
<link href="${coinMarketCapCssUrl}" rel="stylesheet">
<script type="text/javascript" src="${jqueryUiJsUrl}"></script>
<script type="text/javascript" src="${coinMarketCapJsUrl}"></script>
<script type="text/javascript" src="${datatablesJsUrl}"></script>
<script src="${KnockoutJsUrl}"></script>


</head>
<body>

 <%@ include file="navigation.jsp" %>

<table id="fulldata" border="2" class="row-border hover order-column" style="width:100%">

	<thead>
		<tr>
			<th>#</th>
			<th>Name</th>
			<th>Market Cap (USD)</th>
			<th>Price (USD)</th>
			<th>Volume (24h)(USD) </th>
			<th>Circulating Supply</th>
			<th>Change (24h) </th>
		</tr>	
	</thead>
	
	<tbody data-bind="foreach: coinMarketCapFullData">

		<%-- <c:forEach items="${coinMarketCapFullData.data}" var="entry"> --%>
			
			<tr>
				<td data-bind="text: rank"></td>
				<td data-bind="text: name"></td>
				<td data-bind="text: market_cap"></td>
				<td data-bind="text: price"></td>
				<td data-bind="text: volume_24h"></td>
				<td data-bind="text: circulating_supply"></td>
				<td data-bind="text: percent_change_24h"></td>
			</tr>
				
	<%-- 	</c:forEach> --%>
		
	</tbody>

</table>


</body>
</html>