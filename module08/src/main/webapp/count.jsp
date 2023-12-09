<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Count</title>
</head>
<body>

<h1>Результат:</h1>
<p>
    <b>Count: <%= request.getAttribute("count")%>
    </b>
</p>
<hr/>


</body>
</html>