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
                                <th class="d-none d-md-table-cell">Opcje</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${statementOfCosts}" var="statementOfCosts">
                                <tr>
                                    <td class="d-none d-xl-table-cell"><c:out value="${statementOfCosts.id}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${statementOfCosts.purpose}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${statementOfCosts.fromDate}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${statementOfCosts.toDate}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${statementOfCosts.countriesDiet.country}"/></td>
                                    <td><div class="btn-group btn-group-sm mb-4" role="group" aria-label="Small button group">
                                        <a href="/diet/list/accept/<c:out value="${statementOfCosts.id}"/>" class="btn btn-success">Szczegóły i akceptacja</a>
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