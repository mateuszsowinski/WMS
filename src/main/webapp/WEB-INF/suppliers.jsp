<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 13/04/2021
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dostawcy</title>
</head>
<body>
<form method="post" action="/app/suppliers">
    <h1 >Dostawcy</h1>
    <div class="form-group">
        <input type="text" id="name" name="name" placeholder="podaj nazwę dostawcy" required>
    </div>

    <button type="submit">Dodaj</button>
</form>

</body>
</html>
