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

        <h1 class="h3 mb-3">Szczegóły polecenia delegacji</h1>
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Nazwisko i imię pracownika</h5>
                    </div>
                    <div class="card-body">
                        <div>${delegation.mandatory.toString()}</div>
                        <%--            <input disabled type="text" value="${application.dokumentDetails.createUser.toString()}">--%>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Kraj delegacji</h5>
                    </div>
                    <div class="card-body">
                        <div>${delegation.countriesDiet.country}</div>
                        <%--            <input disabled type="text" value="${application.countriesDiet.country}">--%>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Data wyjazdu</h5>
                    </div>
                    <div class="card-body">
                        <div>${delegation.fromDate}</div>
                        <%--            <input disabled type="text" value="${application.fromDate}">--%>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Planowana data powrotu</h5>
                    </div>
                    <div class="card-body">
                        <div>${delegation.toDate}</div>
                        <%--            <input disabled type="text" value="${application.toDate}">--%>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Cel podróży</h5>
                    </div>
                    <div class="card-body">
                        <div>${delegation.purpose}</div>
                        <%--            <input disabled type="text" value="${application.purpose}">--%>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Szczegóły</h5>
                    </div>
                    <div class="card-body">
                        <div class="align-content-center">${delegation.description}</div>
                        <%--            <input disabled type="textarea" value="${application.description}">--%>
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