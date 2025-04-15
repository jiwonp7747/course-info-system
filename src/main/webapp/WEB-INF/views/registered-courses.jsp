<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>현재 학기 수강 신청 내역</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/courses.css">
</head>
<body>

<h2>${year}년도 ${semester}학기 수강 신청 현황</h2>

<c:choose>
    <c:when test="${empty courses}">
        <p style="text-align: center;">수강 신청 내역이 없습니다.</p>
    </c:when>
    <c:otherwise>
        <table>
            <thead>
            <tr>
                <th>교과목명</th>
                <th>교과코드</th>
                <th>교과구분</th>
                <th>담당교수</th>
                <th>학점</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.courseName}</td>
                    <td>${course.courseCode}</td>
                    <td>${course.courseType}</td>
                    <td>${course.professor}</td>
                    <td>${course.credit}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

<p style="text-align: center;">
    <a href="${pageContext.request.contextPath}/">← 메인으로</a>
</p>

</body>
</html>

