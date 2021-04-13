<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 11/04/2021
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>

<a href="#" class="logo">
    <i class="fas fa-share-alt-square"></i>

</a>
<a href="/login" class="login-button">Zaloguj</a>
</nav>

<form method="post" action="/register" class="user-form">
    <h2 class="user-form-title">Zarejestruj się</h2>
    <input name="username" type="text" placeholder="Nazwa użytkownika" required>
    <input name="email" type="email" placeholder="Adres e-mail" required>
    <input name="password" type="password" placeholder="Hasło" required>
    <button class="user-form-button">Zarejestruj</button>
</form>

</body>
</html>
