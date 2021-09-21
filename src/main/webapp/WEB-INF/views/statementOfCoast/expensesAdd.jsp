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
    <nav class="navbar navbar-expand navbar-light navbar-bg">
        <a class="sidebar-toggle js-sidebar-toggle">
            <i class="hamburger align-self-center"></i>
        </a>

        <div class="navbar-collapse collapse">
            <ul class="navbar-nav navbar-align">
                <li class="nav-item dropdown">
                    <a class="nav-icon dropdown-toggle" href="#" id="alertsDropdown" data-bs-toggle="dropdown">
                        <div class="position-relative">
                            <i class="align-middle" data-feather="bell"></i>
                            <span class="indicator">4</span>
                        </div>
                    </a>
                    <div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0" aria-labelledby="alertsDropdown">
                        <div class="dropdown-menu-header">
                            4 New Notifications
                        </div>
                        <div class="list-group">
                            <a href="#" class="list-group-item">
                                <div class="row g-0 align-items-center">
                                    <div class="col-2">
                                        <i class="text-danger" data-feather="alert-circle"></i>
                                    </div>
                                    <div class="col-10">
                                        <div class="text-dark">Update completed</div>
                                        <div class="text-muted small mt-1">Restart server 12 to complete the update.</div>
                                        <div class="text-muted small mt-1">30m ago</div>
                                    </div>
                                </div>
                            </a>
                            <a href="#" class="list-group-item">
                                <div class="row g-0 align-items-center">
                                    <div class="col-2">
                                        <i class="text-warning" data-feather="bell"></i>
                                    </div>
                                    <div class="col-10">
                                        <div class="text-dark">Lorem ipsum</div>
                                        <div class="text-muted small mt-1">Aliquam ex eros, imperdiet vulputate hendrerit et.</div>
                                        <div class="text-muted small mt-1">2h ago</div>
                                    </div>
                                </div>
                            </a>
                            <a href="#" class="list-group-item">
                                <div class="row g-0 align-items-center">
                                    <div class="col-2">
                                        <i class="text-primary" data-feather="home"></i>
                                    </div>
                                    <div class="col-10">
                                        <div class="text-dark">Login from 192.186.1.8</div>
                                        <div class="text-muted small mt-1">5h ago</div>
                                    </div>
                                </div>
                            </a>
                            <a href="#" class="list-group-item">
                                <div class="row g-0 align-items-center">
                                    <div class="col-2">
                                        <i class="text-success" data-feather="user-plus"></i>
                                    </div>
                                    <div class="col-10">
                                        <div class="text-dark">New connection</div>
                                        <div class="text-muted small mt-1">Christina accepted your request.</div>
                                        <div class="text-muted small mt-1">14h ago</div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="dropdown-menu-footer">
                            <a href="#" class="text-muted">Show all notifications</a>
                        </div>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#" data-bs-toggle="dropdown">
                        <i class="align-middle" data-feather="settings"></i>
                    </a>

                    <a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-bs-toggle="dropdown">
                        <!--                <img src="img/avatars/avatar.jpg" class="avatar img-fluid rounded me-1" alt="Charles Hall" /> -->

                        <c:if test="${not empty principal.username}">
                            <span class="text-dark"><security:authentication property="principal.username" /></span>
                        </c:if>
                    </a>
                    <div class="dropdown-menu dropdown-menu-end">
                        <a class="dropdown-item" href="<cs:url value="/manager/profile"/>"><i class="align-middle me-1" data-feather="user"></i> Profile</a>
                        <%--              <a class="dropdown-item" href="index.html"><i class="align-middle me-1" data-feather="settings"></i> Settings & Privacy</a>--%>
                        <a class="dropdown-item" href="#"><i class="align-middle me-1" data-feather="help-circle"></i> Help Center</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item">
                            <form method="post" action="/logout">
                                <input name="${_csrf.parameterName}" value="${_csrf.token}" hidden>
                                <input type="submit" value="Logout" class="align-middle me-1">
                            </form>
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>


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