<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>학사 정보 시스템</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main-style.css">
</head>
<body>
<h1>📚 학사 정보 시스템 메인</h1>

<ul>
  <li>
    <a href="${pageContext.request.contextPath}/completed-courses">학년별 이수 학점 조회</a>
  </li>
  <li>
    <a href="${pageContext.request.contextPath}/register-course">수강 신청하기</a>
  </li>
  <li>
    <a href="${pageContext.request.contextPath}/registered-courses">수강 신청 조회</a>
  </li>
</ul>
</body>
</html>

