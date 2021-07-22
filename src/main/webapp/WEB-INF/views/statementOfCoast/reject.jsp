<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

<main class="content">
    <div class="container-fluid p-0">

        <%--        <h1 class="h3 mb-3">Czy na pewno chcesz zaakceptować te rozliczenie ?</h1>--%>

        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h1 class="h3 mb-3">Czy na pewno chcesz odrzucić te rozliczenie ?</h1>
                    </div>
                    <div class="card-body">
                        <form:form method="post">
                            <input hidden name="id" value="${statementOfCosts.id}">
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
                            <input class="btn btn-primary btn-lg" value="Odrzucam" type="submit"/>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</main>

<jsp:include page="../footer.jsp"/>