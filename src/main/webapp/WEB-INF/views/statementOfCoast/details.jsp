<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
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

        <jsp:include page="../navbar.jsp"/>

<main class="content">
    <div class="container-fluid p-0">

        <h1 class="h3 mb-3">Podsumowanie</h1>

        <div class="row">
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Podróż</h5>
                    </div>
                    <div class="card-body">
                        <table class="table-info">
                            <tbody>
                            <tr>
                                <td>Kraj delegacji:</td>
                                <td>  <c:out value="${statementOfCosts.countriesDiet.country}"/></td>
                            </tr>
                            <tr>
                                <td> Data wyjazdu:</td>
                                <td>  <c:out value="${statementOfCosts.fromDate}"/> <c:out value="${statementOfCosts.fromTime}"/></td>
                            </tr>
                            <tr>
                                <td>Data powrotu:</td>
                                <td>  <c:out value="${statementOfCosts.toDate}"/> <c:out value="${statementOfCosts.toTime}"/></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-auto">Liczba zapewnionych posiłków na delegacji</h5>
                    </div>
                    <div class="card-body">
                        <table class="table-primary">
                            <tbody>
                            <tr>
                                <td>Liczba śniadań:</td>
                                <td> <c:out value="${statementOfCosts.countBreakfast}"/></td>
                            </tr>
                            <tr>
                                <td>Liczba obiadów:</td>
                                <td> <c:out value="${statementOfCosts.countDinner}"/></td>
                            </tr>
                            <tr>
                                <td>Liczba kolacji:</td>
                                <td> <c:out value="${statementOfCosts.countSupper}"/></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Kalkulacja diety</h5>
                    </div>
                    <div class="card-body">
                        <table class="table-info">
                            <tr>
                                <td>Liczba pełnych dni:</td>
                                <td><c:out value="${statementOfCosts.delegationCosts.fullDay}"/></td>
                            </tr>
                            <tr>
                                <td>Liczba dni do 12 godzin:</td>
                                <td><c:out value="${statementOfCosts.delegationCosts.halfDay}"/></td>
                            </tr>
                            <tr>
                                <td>Liczba dni do 8 godzin:</td>
                                <td><c:out value="${statementOfCosts.delegationCosts.miniDay}"/></td>
                            </tr>
                            <tr>
                                <td>Wyliczona dieta(zł)</td>
                                <td><c:out value="${statementOfCosts.delegationCosts.returnedToTheEmployee}"/></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Wydatki</h5>
                    </div>
                    <div class="card-body">
                        <a href="/diet/expenses/add/<c:out value="${statementOfCosts.id}"/>" class="btn btn-success">Dodaj wydatek</a>
                        <table class="table table-hover my-0">
                            <thead>
                            <tr>
                                <th class="d-none d-xl-table-cell">Id</th>
                                <th class="d-none d-xl-table-cell">Kwota</th>
                                <th class="d-none d-xl-table-cell">Waluta</th>
                                <th class="d-none d-xl-table-cell">Opis wydatku</th>
                                <th class="d-none d-xl-table-cell">Metoda płatności</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${statementOfCosts.expenses}" var="expenses" varStatus="id">
                                <tr>
                                    <td class="d-none d-xl-table-cell"><c:out value="${pageScope.id.index + 1}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.amount}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.currency.currency}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.description}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.paymentMethod.method}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="col-4 offset-4">
                <div class="card">
                    <div class="card-header">
                        <div class="offset-4">
                            <h5 class="card-title mb-0">Podsumowanie</h5>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="offset-3">
                            <a href="/diet/details" class="btn btn-warning">Anuluj</a>
                            <a href="/diet/final/<c:url value="${statementOfCosts.id}"/>" class="btn btn-primary btn-lg">Podgląd</a>
<%--                            <button class="btn btn-primary btn-lg">Usuń</button>--%>
                            <c:if test="${statementOfCosts.dokumentDetails.status.status eq 'Nowy'}">
                                <a href="/diet/send/<c:url value="${statementOfCosts.id}"/>" class="btn btn-primary btn-lg">Wyślij</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</main>

<jsp:include page="../footer.jsp"/>

</div>
</div>


<script src="/resources/js/app.js"></script>
</body>

</html>