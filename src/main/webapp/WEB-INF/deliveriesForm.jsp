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
    $(function () {
        $("#datepicker-1").datepicker({
            dateFormat: "dd-mm-yy",
            monthNames: ["Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec",
                "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"],
            dayNamesMin: ["Ni", "Po", "Wt", "Śr", "Cz", "Pi", "So"]
        });
    });
    $(function (){
        $("#startTime").timepicker({
            timeFormat: 'HH:mm',
            interval: 60,
            startTime: '06:00',
        })
    });
    $(function (){
        $("#endTime").timepicker({
            timeFormat: 'HH:mm',
            interval: 60,
            startTime: '06:00',
        });

    });
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
    <div class="collapse show" id="collapseCardExample">

        <div class="card-body">


            <ul class="list-group list-group-flush ">
                <li class="list-group-item d-flex justify-content-between align-items-center ">
                    <div class="ml-0">

                        <form method="post" action="/app/add/deliveries">

                            <p>Data: <input type="text" name="date" id="datepicker-1" required></p>
                            <p>Godzina rozpoczęcia: <input type="text"  name="start" id="startTime" required></p>
                            <p>Godzina zakończenia: <input type="text" name="end" id="endTime" required></p>

                            <select class="form-control col-sm-10" id="chooseSuppliers" name="suppliersId" required>

                                <c:forEach items="${suppliers}" var="suppliers">
                                    <option value="${suppliers.id}">${suppliers.name} </option>
                                </c:forEach>
                            </select>
                            <div class="my-2"></div>

                            <input class="col-sm-5" name="description" type="text" placeholder="Uwagi"><br>

                            Opakowania <input type="checkbox" name="packaging" value="1"><br>
                            <input type="hidden" name="packaging" value="0">

                            <div class="my-2"></div>
                            <button type="submit" class="btn btn-dark btn-sm">Dodaj</button>
                        </form>
                        <div class="my-2"></div>
                    </div>

                </li>
            </ul>
        </div>
    </div>
</div>


</body>

<%@ include file="/WEB-INF/footer.jsp" %>

