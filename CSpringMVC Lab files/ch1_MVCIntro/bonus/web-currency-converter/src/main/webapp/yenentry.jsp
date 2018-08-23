<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Currency Conversion</title>
</head>
<body>
<H3>Enter Yen(&#165;) amount to convert to Euro(&#8364;) &#38; dollar(&#36;)</H3> 
<form action ="convertYen.request" method="post">
Yen(&#165;) to convert:<input type="text" name="yen"/><br/>
<input type="submit" value="Convert" />
</form>
</body>
</html>