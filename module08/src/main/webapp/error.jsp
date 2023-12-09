<%--
  Created by IntelliJ IDEA.
  User: 79038
  Date: 02.12.2023
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error:</h1>
<p>
    <b><%= request.getAttribute("errorMessage")%>
    </b>
</p>
<hr/>
</body>
</html>
