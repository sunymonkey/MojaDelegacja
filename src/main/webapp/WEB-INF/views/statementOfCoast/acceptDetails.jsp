<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

<main class="content">
    <div class="container-fluid p-0">

        <h1 class="h3 mb-3">Rozliczenie delegacji</h1>

        <div class="row">
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Podróż</h5>
                    </div>
                    <div class="card-body">
                        <table class="table-info">
                            <tbody>
                            <tr>
                                <td>Kraj delegacji:</td>
                                <td>  <c:out value="${statementOfCosts.countriesDiet.country}"/></td>
                            </tr>
                            <tr>
                                <td> Data wyjazdu:</td>
                                <td>  <c:out value="${statementOfCosts.fromDate}"/> <c:out value="${statementOfCosts.fromTime}"/></td>
                            </tr>
                            <tr>
                                <td>Data powrotu:</td>
                                <td>  <c:out value="${statementOfCosts.toDate}"/> <c:out value="${statementOfCosts.toTime}"/></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-auto">Liczba zapewnionych posiłków na delegacji</h5>
                    </div>
                    <div class="card-body">
                        <table class="table-primary">
                            <tbody>
                            <tr>
                                <td>Liczba śniadań:</td>
                                <td> <c:out value="${statementOfCosts.countBreakfast}"/></td>
                            </tr>
                            <tr>
                                <td>Liczba obiadów:</td>
                                <td> <c:out value="${statementOfCosts.countDinner}"/></td>
                            </tr>
                            <tr>
                                <td>Liczba kolacji:</td>
                                <td> <c:out value="${statementOfCosts.countSupper}"/></td>
                            </tr>
                            </tbody>
                        </table>
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
                        <table class="table-info">
                            <tr>
                                <td>Liczba pełnych dni:</td>
                                <td><c:out value="${statementOfCosts.delegationCosts.fullDay}"/></td>
                            </tr>
                            <tr>
                                <td>Liczba dni do 12 godzin:</td>
                                <td><c:out value="${statementOfCosts.delegationCosts.halfDay}"/></td>
                            </tr>
                            <tr>
                                <td>Liczba dni do 8 godzin:</td>
                                <td><c:out value="${statementOfCosts.delegationCosts.miniDay}"/></td>
                            </tr>
                            <tr>
                                <td>Wyliczona dieta(zł)</td>
                                <td><c:out value="${statementOfCosts.delegationCosts.returnedToTheEmployee}"/></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Wydatki</h5>
                    </div>
                    <div class="card-body">
                        <table class="table table-hover my-0">
                            <thead>
                            <tr>
                                <th class="d-none d-xl-table-cell">Id</th>
                                <th class="d-none d-xl-table-cell">Kwota</th>
                                <th class="d-none d-xl-table-cell">Waluta</th>
                                <th class="d-none d-xl-table-cell">Opis wydatku</th>
                                <th class="d-none d-xl-table-cell">Metoda płatności</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${statementOfCosts.expenses}" var="expenses" varStatus="id">
                                <tr>
                                    <td class="d-none d-xl-table-cell"><c:out value="${pageScope.id.index + 1}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.amount}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.currency.currency}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.description}"/></td>
                                    <td class="d-none d-xl-table-cell"><c:out value="${expenses.paymentMethod.method}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    Podsumowanie
                </div>
                <div class="card-body">
                    <table class="table-primary">
                        <tbody>
                        <tr>
                            <td>Łączny koszt delegacji:</td>
                            <td> <c:out value="${statementOfCosts.delegationCosts.totalCostsOfTheDelegation}"/></td>
                        </tr>
                        <tr>
                            <td>Wydatki opłacone przez pracownika:</td>
                            <td> <c:out value="${statementOfCosts.delegationCosts.sumExpendedEmployee}"/></td>
                        </tr>
                        <tr>
                            <td>Pobrane zaliczki:</td>
                            <td> <c:out value="${statementOfCosts.delegationCosts.sumAdvancesCollected}"/></td>
                        </tr>
                        <tr>
                            <td>Do zwrotu pracownikowi:</td>
                            <td> <c:out value="${statementOfCosts.delegationCosts.returnedToTheEmployee}"/></td>
                        </tr>
                        <tr>
                            <td>Wydatki opłacone kartą firmową:</td>
                            <td> <c:out value="${statementOfCosts.delegationCosts.sumExpendedFirmCard}"/></td>
                        </tr>
                        <tr>
                            <td>Wydatki opłacone przelewem:</td>
                            <td> <c:out value="${statementOfCosts.delegationCosts.sumExpendedFirmTransfer}"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="col-4 offset-4">
                <div class="card">
                    <div class="card-header">
                        <div class="offset-4">
                            <h5 class="card-title mb-0">Opcje</h5>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="offset-3">
                            <div class="btn-group btn-group-sm mb-4">
                                <a href="/index" class="btn btn-warning">Anuluj</a>
                                <a href="/diet/accept/<c:url value="${statementOfCosts.id}"/>" class="btn btn-primary btn-lg">Akceptuj rozliczenie</a>
                                <a href="/diet/reject/<c:url value="${statementOfCosts.id}"/>" class="btn btn-primary btn-lg">Odrzuć rozliczenie</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</main>

<jsp:include page="../footer.jsp"/>