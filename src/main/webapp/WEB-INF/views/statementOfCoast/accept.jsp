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
    <jsp:include page="../navbar.jsp" />

<main class="content">
    <div class="container-fluid p-0">

<%--        <h1 class="h3 mb-3">Czy na pewno chcesz zaakceptować te rozliczenie ?</h1>--%>

        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h1 class="h3 mb-3">Czy na pewno chcesz zaakceptować te rozliczenie ?</h1>
                    </div>
                    <div class="card-body">
                        <form:form method="post">
                            <input hidden name="id" value="${statementOfCosts.id}">
                            <table class="table-primary">
                                <tbody>
                                <tr>
                                    <td>Łączny koszt delegacji:</td>
                                    <td> <c:out value="${statementOfCosts.delegationCosts.totalCostsOfTheDelegation}"/></td>
                                </tr>
                                <tr>
                                    <td>Wydatki opłacone przez pracownika:</td>
                                    <td> <c:out value="${statementOfCosts.delegationCosts.sumExpendedEmployee}"/></td>
                                </tr>
                                <tr>
                                    <td>Pobrane zaliczki:</td>
                                    <td> <c:out value="${statementOfCosts.delegationCosts.sumAdvancesCollected}"/></td>
                                </tr>
                                <tr>
                                    <td>Do zwrotu pracownikowi:</td>
                                    <td> <c:out value="${statementOfCosts.delegationCosts.returnedToTheEmployee}"/></td>
                                </tr>
                                <tr>
                                    <td>Wydatki opłacone kartą firmową:</td>
                                    <td> <c:out value="${statementOfCosts.delegationCosts.sumExpendedFirmCard}"/></td>
                                </tr>
                                <tr>
                                    <td>Wydatki opłacone przelewem:</td>
                                    <td> <c:out value="${statementOfCosts.delegationCosts.sumExpendedFirmTransfer}"/></td>
                                </tr>
                                </tbody>
                            </table>
                            <input class="btn btn-primary btn-lg" value="Akceptuje" type="submit"/>
                            <a href="/index" class="btn btn-warning">Anuluj</a>
                        </form:form>
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