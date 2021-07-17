<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

<main class="content">
  <div class="container-fluid p-0">

    <h1 class="h3 mb-3">Blank Page</h1>

    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
            <div class="row">
              <div class="col-12">
                <div class="card">
                  <div class="card-header">

                    <div class="card-header">
                      <h5 class="card-title mb-0">Nazwisko i imię pracownika</h5>
                    </div>
                    <div class="card-body">
                      <input disabled type="text" value="${delegation.mandatory.toString()}">
<%--                      <form:select class="form-select mb-3" items="${users}" path="mandatory" itemLabel="lastName" itemValue="id"/>--%>
                    </div>

                    <div class="card-header">
                      <h5 class="card-title mb-0">Cel podróży</h5>
                    </div>

                    <div class="card-body">
                      <input disabled type="text" value="${delegation.purpose}">
<%--                      <form:input type="text" path="purpose" class="form-control" rows="2" placeholder="Cel podróży"/>--%>
                    </div>

                    <div class="card-header">
                      <h5 class="card-title mb-0">Kraj delegacji</h5>
                    </div>
                    <div class="card-body">
                      <input disabled type="text" value="${delegation.countriesDiet.country}">
<%--                      <form:select class="form-select mb-3" items="${countries}" path="country" itemLabel="country" itemValue="id"/>--%>

                      <%--                                <select class="form-select mb-3">--%>
                      <%--                                    <option selected>Open this select menu</option>--%>
                      <%--                                    <option>One</option>--%>
                      <%--                                    <option>Two</option>--%>
                      <%--                                    <option>Three</option>--%>
                      <%--                                </select>--%>
<%--                    </div>--%>
                  </div>

                  <div class="card-header">
                    <h5 class="card-title mb-0">Data wyjazdu</h5>
                  </div>
                  <div class="card-body">
                    <input disabled type="text" value="${delegation.fromDate}">
<%--                    <form:input path="fromDate" type="date" class="form-control"/>--%>
                  </div>

                  <div class="card-header">
                    <h5 class="card-title mb-0">Planowana data powrotu</h5>
                  </div>
                  <div class="card-body">
                    <input disabled type="text" value="${delegation.toDate}">
<%--                    <form:input path="toDate" type="date"  class="form-control"/>--%>
                  </div>

                  <div class="card-header">
                    <h5 class="card-title mb-0">Szczegóły</h5>
                  </div>

                  <div class="card-body">
                    <input disabled type="text" value="${delegation.description}">
<%--                    <form:input type="text" path="description" class="form-control" rows="2" placeholder="Szczegóły"/>--%>
                  </div>
                  <input class="btn btn-success" type="submit" value="Zapisz">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</main>

<jsp:include page="../footer.jsp"/>