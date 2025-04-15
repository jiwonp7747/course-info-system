<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>이수 학점 요약</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/credit-summary.css">
</head>
<body>

<h2>학기별 이수 학점 요약</h2>

<table>
    <thead>
    <tr>
        <th>수강년도</th>
        <th>학기</th>
        <th>총 학점</th>
        <th>상세 보기</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="summary" items="${creditSummary}">
        <tr>
            <td>${summary.year}</td>
            <td>${summary.semester}</td>
            <td>${summary.totalCredit}</td>
            <td>
                <a href="${pageContext.request.contextPath}/courses?year=${summary.year}&semester=${summary.semester}">상세보기</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h3>총 이수 학점: <span>${totalCredit}</span></h3>

</body>
</html>

