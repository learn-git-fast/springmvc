<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Currency Conversion</title>
</head>
<body>
	<H3>Enter dollar (&#36;) amount to convert to Euro(&#8364;) &#38;
		Yen(&#165;)</H3>
	<form action="convert.request" method="post">
		U.S. Dollars(&#36;) to convert:<input type="text" name="usd" /><br />
		<input type="submit" value="Convert" />
	</form>
</body>
</html>