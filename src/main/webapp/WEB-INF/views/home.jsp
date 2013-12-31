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

<P>  The time on the server is: ${serverTime}. </P>
<P>  Profile in use is: ${profile}. </P>
<P>  Profile variable set: ${profileVar}. </P>
<P>  Environment variable example: ${anotherVar}. </P>

<p> 
Properties:<br/>
<c:forEach items="${properties}" var="property" >
   <c:out value="${property}"/><br/>
</c:forEach>
</p>
<P> VCAP Services: </P>
<c:forEach items="${vcapServices}" var="property" >
   <c:out value="${property}"/><br/>
</c:forEach>

<p> 
Cloud Properties:<br/>
<c:forEach items="${cloudProperties}" var="property" >
   <c:out value="${property}"/><br/>
</c:forEach>
</p>

<p> 
Beans:<br/>
<c:forEach items="${beanNames}" var="property" >
   <c:out value="${property}"/><br/>
</c:forEach>
</p>

<p> 
Services:<br/>
<c:forEach items="${services}" var="service" >
	<c:forEach items="${service}" var="property" >
	   <c:out value="${property}"/><br/>
	</c:forEach>
</c:forEach>
</p>

</body>
</html>
