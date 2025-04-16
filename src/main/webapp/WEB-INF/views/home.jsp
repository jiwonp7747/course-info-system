<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>학사 정보 시스템</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main-style.css">
</head>
<body>

<h1>📚 학사 정보 시스템 메인</h1>

<div class="button-container">
  <a href="${pageContext.request.contextPath}/completed-courses" class="main-button">
    <img src="${pageContext.request.contextPath}/resources/images/grade.png" alt="이수 학점" />
    <span>학년별 이수 학점 조회</span>
  </a>
  <a href="${pageContext.request.contextPath}/register-course" class="main-button">
    <img src="${pageContext.request.contextPath}/resources/images/register.png" alt="수강 신청" />
    <span>수강 신청하기</span>
  </a>
  <a href="${pageContext.request.contextPath}/registered-courses" class="main-button">
    <img src="${pageContext.request.contextPath}/resources/images/check.png" alt="신청 조회" />
    <span>수강 신청 조회</span>
  </a>
</div>

</body>
</html>


