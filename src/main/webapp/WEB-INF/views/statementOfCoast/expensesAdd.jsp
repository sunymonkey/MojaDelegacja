<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
    <meta name="author" content="AdminKit">
    <meta name="keywords" content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="shortcut icon" href="img/icons/icon-48x48.png" />

    <title>Moja Delegacja</title>

    <link href="/resources/css/app.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>

<body>

<div class="wrapper">

<jsp:include page="../header.jsp"/>
<div class="main">
    <jsp:include page="../navbar.jsp" />

<main class="content">
    <div class="container-fluid p-0">

        <h1 class="h3 mb-3">Dodaj wydatek</h1>

        <form:form method="post" modelAttribute="expensesDao" enctype="multipart/form-data">
        <div class="row">
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Data wydatku</h5>
                    </div>
                    <div class="card-body">
                        <form:input type="date" path="dateExpenses" class="form-control" rows="2" placeholder="Cel podróży"/>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Rodzaj wydatku</h5>
                    </div>
                    <div class="card-body">
                        <form:select class="form-select mb-3" items="${typeOfExpenses}" path="type" itemLabel="type" itemValue="id"/>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Waluta</h5>
                    </div>
                    <div class="card-body">
                        <form:select path="currency" items="${currencyList}" itemValue="id" itemLabel="currency" class="form-select mb-3"/>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Rodzaj płatności</h5>
                    </div>
                    <div class="card-body">
                        <form:select class="form-select mb-3" items="${paymentMethodList}" path="paymentMethod" itemLabel="method" itemValue="id"/>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Kwota</h5>
                    </div>
                    <div class="card-body">
                        <form:input path="amount" type="number"  class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Liczba (np. kilometrów)</h5>
                    </div>
                    <div class="card-body">
                        <form:input path="kmOrNumber" type="number" class="form-control"/>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Opis wydatku</h5>
                    </div>
                    <div class="card-body">
                        <form:textarea path="description" class="form-control" rows="2" placeholder="Szczegóły"/>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Załącznik</h5>
                    </div>
                    <div class="card-body">
                        <form:input path="dbFile" type="file"/>
                        <input type="hidden" value="<c:out value="${statementOfCoast}"/>" name="id">
                    </div>
                </div>
            </div>
        </div>
            <input class="btn btn-success" type="submit" value="Zapisz">
        </form:form>

    </div>
</main>

<jsp:include page="../footer.jsp"/>

</div>
</div>


<script src="/resources/js/app.js"></script>
</body>

</html>