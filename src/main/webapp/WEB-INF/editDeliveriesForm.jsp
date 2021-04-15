<%--
  Created by IntelliJ IDEA.
  User: mateuszsowinski
  Date: 14/04/2021
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<html>
<head>
    <title>Dostawa</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
    <%--    <link rel="stylesheet" href="/css/style.css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
</head>
<body>


<form method="post" action="/app/edit">
<h2 class="user-form-title">Dodaj dostawę</h2>
    <input type="hidden" name="id" value="${edit.id}">

<div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker3'>
                    <input name="date" type='text' class="form-control"required/>
                    <span class="input-group-addon">
               <span class="glyphicon glyphicon-calendar"></span>
               </span>
                </div>
            </div>
        </div>

    </div>
</div>


<div class="container">
    <div class='col-md-5'>
        <div class="form-group">
            <div class='input-group date' id='datetimepicker6'>
                <input name="start" type='text' class="form-control" value="${edit.start}" required/>
                <span class="input-group-addon">
            <span class="glyphicon glyphicon-time"></span>
            </span>
            </div>
        </div>
    </div>
    <div class='col-md-5'>
        <div class="form-group">
            <div class='input-group date' id='datetimepicker7'>
                <input name="end" type='text' class="form-control" value="${edit.end}" required/>
                <span class="input-group-addon">
            <span class="glyphicon glyphicon-time"></span>
            </span>
            </div>
        </div>
    </div>
</div>

<select class="form-control" id="chooseSuppliers" name="suppliersId">
    <c:forEach items="${suppliers}" var="suppliers">
        <option value="${suppliers.id}">${suppliers.name} </option>
    </c:forEach>
</select>

Uwagi<input name="description" type="text" value="${edit.description}"></br>
Opakowania <input type="checkbox" name="packaging" value="1" ></br>
    <input type="hidden" name="packaging" value="0">

<button type="submit">Dodaj</button>

</form>


<script type="text/javascript">
    $(function () {
        $('#datetimepicker3').datetimepicker({
            viewMode: 'days',
            format: 'DD-MM-YYYY',
            locale: 'pl'

        });
    });

    $(function () {
        $('#datetimepicker6').datetimepicker({
            sideBySide: true,
            format: 'HH:mm',

        });
        $('#datetimepicker7').datetimepicker({
            useCurrent: false, //Important! See issue #1075
            format: 'HH:mm',
            sideBySide: true
        });
        $("#datetimepicker6").on("dp.change", function (e) {
            $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker7").on("dp.change", function (e) {
            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
        });
    });
</script>


</body>
</html>
