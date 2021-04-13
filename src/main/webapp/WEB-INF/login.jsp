<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 13/04/2021
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="/login">
    <h1 >Logowanie</h1>
    <div class="form-group">
        <input type="text" class="form-control" id="username" name="username" placeholder="podaj nazwę użytkownika" required>
    </div>
    <div class="form-group">
        <input type="password" class="form-control" id="password" name="password" placeholder="podaj hasło" required>
    </div>
    <button type="submit">Zaloguj</button>
</form>

</body>
</html>
