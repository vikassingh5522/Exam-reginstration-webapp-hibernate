<%@page contentType="text/html;charset=UTF-8" language="java" %> 
<html>
<head>
    <title>Student Registration Form</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 100px; }
        input[type=text], input[type=email] { padding: 5px; width: 200px; }
        .button { padding: 5px 10px; text-decoration: none; color: white; background-color: #4CAF50; }
    </style>
</head>
<body>
    <h2>${student == null ? 'Register Student' : 'Edit Student'}</h2>
    <form action="students" method="post">
        <input type="hidden" name="action" value="${student == null ? 'create' : 'update'}">
        <input type="hidden" name="id" value="${student != null ? student.id : ''}">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${student != null ? student.name : ''}" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${student != null ? student.email : ''}" required>
        </div>
        <div class="form-group">
            <label for="examName">Exam Name:</label>
            <input type="text" id="examName" name="examName" value="${student != null ? student.examName : ''}" required>
        </div>
        <button type="submit" class="button">Save</button>
        <a href="students" class="button" style="background-color: #ccc;">Cancel</a>
    </form>
</body>
</html>