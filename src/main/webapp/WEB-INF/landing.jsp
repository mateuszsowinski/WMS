<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.format.DateTimeFormatter" %>


<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Dostawy- Hurtownia Nowak</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
    <script src="https://fer-api.coderslab.pl/bootstrap/js/index.min.js"></script>
    <script>new CL ({

        fontAwesome: true
    });</script>
    <script src="script.js"></script>
</head>
<body>
<main id="app" class="js-tasks-list container mb-5">
    <c:forEach items="${details}" var="date">

        <section class="card mt-5 shadow-sm">
            <div class="card-header d-flex justify-content-between align-items-center">
                <div>
                    <h5>${date.key}</h5>
                </div>
                <div>
                    <button class="btn btn-outline-danger btn-sm ml-2">Delete</button>
                </div>
            </div>
        <c:forEach items="${date.value}" var="details">
            <ul class="list-group list-group-flush">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <div>
                        <p class="deliveries">Dodane przez: ${details.username}, ${details.localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))}</p>
                        <span class="badge badge-success badge-pill ml-2">${details.start}</span>
                        <span class="badge badge-success badge-pill ml-2">${details.end}</span>
                        ${details.name}

                    </div>
                </li>
            </ul>
        </c:forEach>
        </section>

    </c:forEach>





</main>
</body>
</html>
