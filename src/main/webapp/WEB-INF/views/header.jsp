<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



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

