<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
</head>
<body>
    <h1>Update Profile</h1>
    
    <c:if test="${not empty alert}">
        <div class="alert">
            <c:out value="${alert}"/>
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/updateProfile" method="post" enctype="multipart/form-data">
        <input type="hidden" name="username" value="${param.username}"/>
        
        <label for="fullname">Full Name:</label>
        <input type="text" id="fullname" name="fullname" value="${param.fullname}" required/><br/><br/>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="${param.phone}" required/><br/><br/>

        <label for="image">Avatar:</label>
        <input type="file" id="image" name="image"/><br/><br/>

        <input type="submit" value="Update"/>
    </form>
    
    <a href="${pageContext.request.contextPath}/home">Back to Home</a>
</body>
</html>