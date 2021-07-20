<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

<main class="content">
    <div class="container-fluid p-0">

        <h1 class="h3 mb-3">Podsumowanie</h1>

        <div class="row">
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Podróż</h5>
                    </div>
                    <div class="card-body">
                        Data od: <c:out value="${statementOfCosts.fromDate}"/> <c:out value="${statementOfCosts.fromTime}"/>
                        Data do <c:out value="${statementOfCosts.toDate}"/> <c:out value="${statementOfCosts.toTime}"/>
                        Kraj: <c:out value="${statementOfCosts.countriesDiet.country}"/>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Liczba zapewnionych posiłków</h5>
                    </div>
                    <div class="card-body">
                        Śniadania <c:out value="${statementOfCosts.countBreakfast}"/>
                        Obiady <c:out value="${statementOfCosts.countDinner}"/>
                        Kolacje <c:out value="${statementOfCosts.countSupper}"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Kalkulacja diety</h5>
                    </div>
                    <div class="card-body">
                        Liczba pełnych dni: <c:out value="${statementOfCosts.delegationCosts.fullDay}"/>
                        Liczba dni do 12 godzin: <c:out value="${statementOfCosts.delegationCosts.halfDay}"/>
                        Liczba dni do 8 godzin: <c:out value="${statementOfCosts.delegationCosts.miniDay}"/>
                        Dieta <c:out value="${statementOfCosts.delegationCosts.returnedToTheEmployee}"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Wydatki</h5>
                        <a href="/diet/expenses/add/<c:out value="${statementOfCosts.id}"/>" class="btn btn-success">Dodaj wydatek</a>
                    </div>
                    <div class="card-body">
                        <table class="table table-hover my-0">
                            <thead>
                            <tr>
                                <th class="d-none d-xl-table-cell">id</th>
                                <th class="d-none d-xl-table-cell">amount</th>
                                <th class="d-none d-xl-table-cell">currency</th>
                                <th class="d-none d-xl-table-cell">description</th>
                                <th class="d-none d-xl-table-cell">payment method</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${statementOfCosts.expenses}" var="expenses">
                                <tr>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.id}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.amount}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.currency}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.description}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.paymentMethod}"/></td>
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