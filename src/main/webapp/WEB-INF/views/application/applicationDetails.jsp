<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

<main class="content">
  <div class="container-fluid p-0">

    <h1 class="h3 mb-3">Szczegóły wniosku</h1>
    <div class="row">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header">
            <h5 class="card-title mb-0">Nazwisko i imię pracownika</h5>
          </div>
          <div class="card-body">
            <div>${application.dokumentDetails.createUser.toString()}</div>
<%--            <input disabled type="text" value="${application.dokumentDetails.createUser.toString()}">--%>
          </div>
        </div>
        <div class="card">
          <div class="card-header">
            <h5 class="card-title mb-0">Kraj delegacji</h5>
          </div>
          <div class="card-body">
            <div>${application.countriesDiet.country}</div>
<%--            <input disabled type="text" value="${application.countriesDiet.country}">--%>
          </div>
        </div>
        <div class="card">
          <div class="card-header">
            <h5 class="card-title mb-0">Data wyjazdu</h5>
          </div>
          <div class="card-body">
            <div>${application.fromDate}</div>
<%--            <input disabled type="text" value="${application.fromDate}">--%>
          </div>
        </div>
        <div class="card">
          <div class="card-header">
            <h5 class="card-title mb-0">Planowana data powrotu</h5>
          </div>
          <div class="card-body">
            <div>${application.toDate}</div>
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
            <div>${application.purpose}</div>
<%--            <input disabled type="text" value="${application.purpose}">--%>
          </div>
        </div>
        <div class="card">
          <div class="card-header">
            <h5 class="card-title mb-0">Szczegóły</h5>
          </div>
          <div class="card-body">
            <div class="align-content-center">${application.description}</div>
<%--            <input disabled type="textarea" value="${application.description}">--%>
          </div>
        </div>
      </div>
    </div>


    </div>
</main>

<jsp:include page="../footer.jsp"/>