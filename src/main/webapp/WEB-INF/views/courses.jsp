<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>학기별 수강 과목 상세보기</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/courses.css">
</head>
<body>

<h2>${param.year}년도 ${param.semester}학기 수강 과목 목록</h2>

<table>
    <thead>
    <tr>
        <th>년도</th>
        <th>학기</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>담당교수</th>
        <th>학점</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.year}</td>
            <td>${course.semester}</td>
            <td>${course.courseName}</td>
            <td>${course.courseType}</td>
            <td>${course.professor}</td>
            <td>${course.credit}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a href="${pageContext.request.contextPath}/completed-courses">← 학점 요약으로 돌아가기</a></p>

</body>
</html>

