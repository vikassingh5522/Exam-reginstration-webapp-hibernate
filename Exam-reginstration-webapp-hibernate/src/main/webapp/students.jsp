<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Exam Registration</title>
    <style> 
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .button { padding: 5px 10px; text-decoration: none; color: white; background-color: #4CAF50; }
        .button.delete { background-color: #f44336; }
    </style>
</head>
<body>
    <h2>Exam Registration</h2>
    <a href="student-form.jsp" class="button">Register New Student</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Exam Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.examName}</td>
                <td>
                    <a href="students?action=edit&id=${student.id}" class="button">Edit</a>
                    <a href="students?action=delete&id=${student.id}" class="button delete" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>