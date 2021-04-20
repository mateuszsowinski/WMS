<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 20/04/2021
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ include file="/WEB-INF/header.jsp" %>



<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
<%--    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>--%>
<%--    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>--%>
</div>

<c:forEach items="${details}" var="date">

<div class="card shadow mb-4">
    <!-- Card Header - Accordion -->
    <a class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
        <h6 class="m-0 font-weight-bold text-primary">${date.key}</h6>
    </a>
    <!-- Card Content - Collapse -->




    <div class="collapse show" id="collapseCardExample">

        <div class="card-body">


            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-warning shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">Pending Requests</div>
                                <div class="h5 mb-0 font-weight-bold text-gray-800">18</div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-comments fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



            <c:forEach items="${date.value}" var="details">
                <ul class="list-group list-group-flush " >
                    <li class="list-group-item d-flex justify-content-between align-items-center " >
                        <div>
                            <p class="deliveries">Dodane
                                przez: ${details.username}, ${details.localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))}</p>
                            <span class="badge badge-success badge-pill ml-2">${details.start}</span>
                            <span class="badge badge-success badge-pill ml-2">${details.end} </span>
                            <p class="h5 mb-0 font-weight-bold text-gray-800"> ${details.name}</p>

                            <c:if test="${details.packaging == '1'}">
                                <div>
                                    <span class="badge badge-success badge-pill ml-2">Opakowania do zwrotu</span>
                                </div>
                            </c:if>
                            <p class="desc"> ${details.description}</p>


                        </div>
                        <div>
                            <button class="btn btn-dark btn-sm">Zakończ</button>
                            <a class="btn btn-dark btn-sm" href="<c:url value="/app/edit?id=${details.id}"/> ">Edytuj</a>
                            <a class="btn btn-outline-danger btn-sm ml-2" href='<c:url value="/app/delete?id=${details.id}"/>' onclick="return confirm('Czy chcesz usunąć wybraną pozycję?');">Usuń</a>

                        </div>



                    </li>
                </ul>
            </c:forEach>
        </div>
    </div>
</div>

</c:forEach>


</main>



<!-- Footer -->

<%@ include file="/WEB-INF/footer.jsp" %>
