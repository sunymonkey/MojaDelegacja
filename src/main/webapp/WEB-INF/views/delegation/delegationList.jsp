<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

<main class="content">
    <div class="container-fluid p-0">

        <h1 class="h3 mb-3">Lista poleceń delegacji</h1>

        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover my-0">
                            <thead>
                            <tr>
                                <th class="d-none d-xl-table-cell">Id</th>
                                <th class="d-none d-xl-table-cell">Cel</th>
                                <th class="d-none d-xl-table-cell">Od(data)</th>
                                <th class="d-none d-xl-table-cell">Do(data)</th>
                                <th class="d-none d-xl-table-cell">Miejsce delegacji</th>
                                <th>Status</th>
                                <th class="d-none d-md-table-cell">Opcje</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${delegation}" var="delegation">
                                <tr>
                                    <td class="d-none d-xl-table-cell"><c:out value="${delegation.id}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${delegation.purpose}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${delegation.fromDate}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${delegation.toDate}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${delegation.countriesDiet.country}"/></td>
                                    <td><span class="badge bg-success"><c:out value="${delegation.dokumentDetails.status.status}"/></span></td>
                                    <td><div class="btn-group btn-group-sm mb-4" role="group" aria-label="Small button group">
                                        <a href="/delegation/details/<c:out value="${delegation.id}"/>" class="btn btn-success">Szczegóły</a>
                                        <a href="/delegation/change/<c:out value="${delegation.id}"/>" class="btn btn-success">Zmień status</a>
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