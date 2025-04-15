<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jiwonp
  Date: 2025. 4. 14.
  Time: 오후 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="offer" items="${id_offers}" >
        <p> <c:out value="${offer}"> </c:out> </p>
    </c:forEach>
</body>
</html>
