<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>수강 신청</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register-course.css">
</head>
<body>

<h2>📝 수강 신청 등록</h2>

<form:form modelAttribute="courseRegisterRequest" action="${pageContext.request.contextPath}/course" method="post">
    <table>
        <tr>
            <td>수강년도:</td>
            <td>
                <form:input path="year"/>
                <form:errors path="year" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>학기:</td>
            <td>
                <form:select path="semester">
                    <form:option value="1" label="1학기"/>
                    <form:option value="2" label="2학기"/>
                </form:select>
                <form:errors path="semester" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>교과코드:</td>
            <td>
                <form:input path="courseCode"/>
                <form:errors path="courseCode" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>교과목명:</td>
            <td>
                <form:input path="courseName"/>
                <form:errors path="courseName" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>교과구분:</td>
            <td>
                <form:input path="courseType"/>
                <form:errors path="courseType" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>담당교수:</td>
            <td>
                <form:input path="professor"/>
                <form:errors path="professor" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>학점:</td>
            <td>
                <form:input path="credit"/>
                <form:errors path="credit" cssClass="error"/>
            </td>
        </tr>
    </table>
    <br>
    <div class="center">
        <button type="submit">신청 완료</button>
        <a href="${pageContext.request.contextPath}/">메인으로</a>
    </div>
</form:form>

</body>
</html>

