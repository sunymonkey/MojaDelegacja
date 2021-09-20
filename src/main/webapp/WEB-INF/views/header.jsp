<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
  <nav id="sidebar" class="sidebar js-sidebar">
    <div class="sidebar-content js-simplebar">
      <a class="sidebar-brand" href="<c:url value="/"/>">
        <span class="align-middle">Moja delegacja</span>
      </a>

      <ul class="sidebar-nav">
        <li class="sidebar-header">Wnioski</li>

        <li class="sidebar-item">
          <a class="sidebar-link" href="<c:url value="/application/add"/>">
            <i class="align-middle" data-feather="check-square"></i> <span class="align-middle">Nowy wniosek</span>
          </a>
        </li>

        <li class="sidebar-item">
          <a class="sidebar-link" href="<c:url value="/application/list"/> ">
            <i class="align-middle" data-feather="list"></i> <span class="align-middle">Lista wniosków</span>
          </a>
        </li>

        <li class="sidebar-header">Delegacje</li>

        <li class="sidebar-item">
          <a class="sidebar-link" href="<c:url value="/diet/add"/>">
            <i class="align-middle" data-feather="check-square"></i> <span class="align-middle">Rozliczenie delegacji</span>
          </a>
        </li>

        <li class="sidebar-item">
          <a class="sidebar-link" href="<c:url value="/delegation/list"/>">
            <i class="align-middle" data-feather="list"></i> <span class="align-middle">Polecenia delegacji</span>
          </a>
        </li>

        <li class="sidebar-item">
          <a class="sidebar-link" href="<c:url value="/diet/list/person"/>">
            <i class="align-middle" data-feather="list"></i> <span class="align-middle">Moje rozliczenia delegacji</span>
          </a>
        </li>

        <sec:authorize access="hasRole('ADMIN')">


        <li class="sidebar-header">Kierownik</li>

        <li class="sidebar-item">
          <a class="sidebar-link" href="<c:url value="/delegation/add"/>">
            <i class="align-middle" data-feather="bookmark"></i> <span class="align-middle">Nowe polecenie delegacji</span>
          </a>
        </li>

        <li class="sidebar-item">
          <a class="sidebar-link" href="<c:url value="/diet/list/accept"/>">
            <i class="align-middle" data-feather="list"></i> <span class="check-circle">Akceptacja rozliczeń delegacji</span>
          </a>
        </li>

          <li class="sidebar-item">
            <a class="sidebar-link" href="<c:url value="/diet/list"/>">
              <i class="align-middle" data-feather="list"></i> <span class="align-middle">Lista rozliczeń delegacji</span>
            </a>
          </li>

        <li class="sidebar-item">
          <a class="sidebar-link" href="<c:url value="/manager/employeeList"/>">
            <i class="align-middle" data-feather="list"></i> <span class="align-middle">Lista pracowników</span>
          </a>
        </li>
        </sec:authorize>
      </ul>


    </div>
  </nav>

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
                <span class="text-dark"><security:authentication property="principal.username" /></span>
            </a>
            <div class="dropdown-menu dropdown-menu-end">
              <a class="dropdown-item" href="<c:url value="/manager/profile"/>"><i class="align-middle me-1" data-feather="user"></i> Profile</a>
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