<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 22/04/2021
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/header.jsp" %>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<script>

</script>
<body>

<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <%--    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>--%>
    <%--    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>--%>
</div>


<div class="card shadow mb-4">
    <!-- Card Header - Accordion -->
    <a class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true"
       aria-controls="collapseCardExample">
        <h6 class="m-0 font-weight-bold text-primary">Dodaj dostawę</h6>
    </a>
    <!-- Card Content - Collapse -->
    <div class="collapse show">
        <div class="card-body">
            <ul class="list-group list-group-flush ">
                <li class="list-group-item d-flex justify-content-between align-items-center ">
                    <div class="ml-0">

                        <form method="post" action="/app/add/suppliers">

                            <div class="my-2"></div>


                            <input type="text" id="name" name="name" placeholder="Dodaj nowego dostawcę" required>

                            <div class="my-2"></div>
                            <button type="submit" class="btn btn-dark btn-sm">Dodaj</button>
                        </form>

                        <div class="my-2"></div>

                            <div class="card shadow mb-4">

                                <a class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
                                    <h6 class="m-0 font-weight-bold text-primary">Dostawcy</h6>
                                </a>

                                <div class="collapse show" id="collapseCardExample">

                                    <div class="card-body">

                                        <c:forEach items="${suppliers}" var="suppliers">
                                            <ul class="list-group list-group-flush " >
                                                <li class="list-group-item d-flex justify-content-between align-items-center " >
                                                    <div>

                                                        <div class="my-2"></div>
                                                        <p class="desc"> ${suppliers.name}</p>

                                                    </div>
                                                    <div>
                                                        <a class="btn btn-outline-danger btn-sm ml-2" href='<c:url value="/app/delete/suppliers?id=${suppliers.id}"/>' onclick="return confirm('Czy chcesz usunąć wybraną pozycję?');">Usuń</a>
                                                    </div>

                                                </li>
                                            </ul>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                    </div>

                </li>
            </ul>
        </div>
    </div>
</div>


</body>

<%@ include file="/WEB-INF/footer.jsp" %>

