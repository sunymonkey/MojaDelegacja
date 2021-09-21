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

        <h1 class="h3 mb-3">Lista wniosków</h1>

        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover my-0">
                            <thead>
                            <tr>
                                <th class="d-none d-xl-table-cell">Id</th>
                                <th class="d-none d-xl-table-cell">Kto</th>
                                <th class="d-none d-xl-table-cell">Cel</th>
                                <th class="d-none d-xl-table-cell">Od daty</th>
                                <th class="d-none d-xl-table-cell">Do daty</th>
                                <th class="d-none d-xl-table-cell">Kraj</th>
                                <th>Status</th>
                                <th class="d-none d-md-table-cell">Opcje</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${statementOfCosts}" var="statementOfCosts">
                                <tr>
                                    <td class="d-none d-xl-table-cell"><c:out value="${statementOfCosts.id}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${statementOfCosts.dokumentDetails.createUser.username}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${statementOfCosts.purpose}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${statementOfCosts.fromDate}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${statementOfCosts.toDate}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${statementOfCosts.countriesDiet.country}"/></td>
                                    <td><span class="badge bg-success"><c:out value="${statementOfCosts.dokumentDetails.status.status}"/></span></td>
                                    <td><div class="btn-group btn-group-sm mb-4" role="group" aria-label="Small button group">
                                        <a href="/diet/details/<c:out value="${statementOfCosts.id}"/>" class="btn btn-success">Szczegóły</a>
<%--                                        <a href="/diet/change/<c:out value="${statementOfCosts.id}"/>" class="btn btn-success">Zmień status</a>--%>
                                    </div> </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

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