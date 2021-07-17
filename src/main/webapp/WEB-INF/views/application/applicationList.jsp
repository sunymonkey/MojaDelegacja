<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

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
                                <th class="d-none d-xl-table-cell">id</th>
                                <th class="d-none d-xl-table-cell">purpose</th>
                                <th class="d-none d-xl-table-cell">from date</th>
                                <th class="d-none d-xl-table-cell">to date</th>
                                <th class="d-none d-xl-table-cell">gdzie</th>
                                <th>Status</th>
                                <th class="d-none d-md-table-cell">Opcje</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${application}" var="application">
                                <tr>
                                    <td class="d-none d-xl-table-cell"><c:out value="${application.id}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${application.purpose}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${application.fromDate}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${application.toDate}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${application.countriesDiet.country}"/></td>
                                    <td><span class="badge bg-success"><c:out value="${application.status}"/></span></td>
                                    <td><div class="btn-group btn-group-sm mb-4" role="group" aria-label="Small button group">
                                        <a href="/application/details/<c:out value="${application.id}"/>" class="btn btn-success">Szczegóły</a>
                                        <a href="/application/change/<c:out value="${application.id}"/>" class="btn btn-success">Zmień status</a>
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