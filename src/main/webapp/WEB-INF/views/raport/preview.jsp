<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

<main class="content">
  <div class="container-fluid p-0">

    <h1 class="h3 mb-3">Podsumowanie delegacji</h1>

    <div class="row">
      <div class="col-6">
        <div class="card">
          <div class="card-header">
            Dane podstawowe
          </div>
          <div class="card-body">
            <table class="table-info">
              <tr>
                <td>Imię</td>
                <td>${statementOfCosts.delegationMember.firstName}</td>
              </tr>
              <tr>
                <td>Nazwisko</td>
                <td>${statementOfCosts.delegationMember.lastName}</td>
              </tr>
            </table>
          </div>
        </div>
      </div>
      <div class="col-6">
        <div class="card">
          <div class="card-header">
            Przebieg podróży
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
      <div class="col-6">
        <div class="card">
          <div class="card-header">
            Kalkulacja diety
          </div>
          <div class="card-body">
            <table class="table-primary">
              <tbody>
              <tr>
                <td>Dieta:</td>
                <td> <c:out value="${statementOfCosts.delegationCosts.dailyDiet}"/></td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <div class="col-6">
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
      <div class="col-6">
        <div class="card">
          <div class="card-header">
            Przelicznik kursu
          </div>
          <div class="card-body">
            Przelicznik z dnia: <c:out value="${statementOfCosts.exchangeRateDay}"/>
            Kurs: <c:out value="${statementOfCosts.rate}"/>
            Waluta <c:out value="${statementOfCosts.countriesDiet.currency}"/>
          </div>
        </div>
      </div>
    </div>
    <a href="/diet/details/<c:out value="${statementOfCosts.id}"/> " class="btn btn-warning">Anuluj</a>
  </div>
</main>

<jsp:include page="../footer.jsp"/>