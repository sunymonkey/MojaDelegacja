<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<jsp:include page="../header.jsp"/>

<main class="content">
  <div class="container-fluid p-0">

    <h1 class="h3 mb-3">Lista pracowników</h1>

    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-header">
          </div>
          <div class="card-body">
            <table class="table table-hover my-0">
              <thead>
              <tr>
                <th class="d-none d-xl-table-cell">id</th>
                <th class="d-none d-xl-table-cell">Imię</th>
                <th class="d-none d-xl-table-cell">Nazwisko</th>
                <th class="d-none d-xl-table-cell">Email</th>
                <th class="d-none d-xl-table-cell">Login</th>
                <th class="d-none d-md-table-cell">Opcje</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${users}" var="users">
                <tr>
                  <td class="d-none d-xl-table-cell"><c:out value="${users.id}"/></td>
                  <td class="d-none d-xl-table-cell"><c:out value="${users.firstName}"/></td>
                  <td class="d-none d-xl-table-cell"><c:out value="${users.lastName}"/></td>
                  <td class="d-none d-xl-table-cell"><c:out value="${users.email}"/></td>
                  <td class="d-none d-xl-table-cell"><c:out value="${users.username}"/></td>
                  <td><div class="btn-group btn-group-sm mb-4" role="group" aria-label="Small button group">
                    <a href="/manager/user/details/<c:out value="${statementOfCosts.id}"/>" class="btn btn-success">Szczegóły</a>
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