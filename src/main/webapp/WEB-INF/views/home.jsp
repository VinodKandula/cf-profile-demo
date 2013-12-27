<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  Profile in use is ${profile}. </P>
<P>  Profile variable set ${profileVar}. </P>
<P>  environment variable ${anotherVar}. </P>
<P>  aaa: ${aaa}. </P>
<P>  bbb: ${bbb}. </P>

<c:forEach items="${properties}" var="property" >
   <p> <c:out value="${property}"/></p>
</c:forEach>
<P> VCAP Properties: </P>
<c:forEach items="${vcapProperties}" var="property" >
   <p> <c:out value="${property}"/></p>
</c:forEach>
</body>
</html>
