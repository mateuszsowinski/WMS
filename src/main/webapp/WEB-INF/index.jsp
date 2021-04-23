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

<div class="d-sm-flex align-items-center justify-content-between mb-4">
<%--    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>--%>
<%--    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>--%>
</div>

<c:forEach items="${details}" var="date">

<div class="card shadow mb-4">
    <!-- Card Header - Accordion -->
    <a class="d-block card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">${date.key}</h6>
    </a>
    <!-- Card Content - Collapse -->


    <div class="collapse show" id="collapseCardExample">

        <div class="card-body">

            <c:forEach items="${date.value}" var="details">
                <ul class="list-group list-group-flush " >
                    <li class="list-group-item d-flex justify-content-between align-items-center " >
                        <div>
                            <p class="deliveries">Dodane
                                przez: ${details.username}, ${details.localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))}</p>
                            <span class="btn btn-warning ">${details.start}</span>
                            <span class="btn btn-warning ">${details.end} </span>
                            <span class="h5 mb-0 font-weight-bold text-gray-800"> ${details.name}</span>

                            <c:if test="${details.packaging == '1'}">
                                <div class="my-2"></div>
                                <div>
                                    <span class="btn btn-info ">Opakowania do zwrotu</span>
                                </div>
                            </c:if>
                            <div class="my-2"></div>
                            <p class="desc"> ${details.description}</p>

                        </div>
                        <div>
                            <c:choose>
                                <c:when test="${details.status =='1'}">
                                <button class="btn btn-success" >Dostawa zakończona</button>
                                </c:when>
                                <c:otherwise>
                                    <a class="btn btn-dark" href="<c:url value="/app/status?id=${details.id}"/>" onclick="return confirm('Czy chcesz zamknąć dostawę?');">Zakończ</a>
                                </c:otherwise>
                            </c:choose>
                            <a class="btn btn-dark" href="<c:url value="/app/edit?id=${details.id}"/> ">Edytuj</a>
                            <a class="btn btn-danger" href='<c:url value="/app/delete?id=${details.id}"/>' onclick="return confirm('Czy chcesz usunąć wybraną pozycję?');">Usuń</a>

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
