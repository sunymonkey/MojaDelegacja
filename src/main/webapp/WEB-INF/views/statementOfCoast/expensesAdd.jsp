<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

<main class="content">
    <div class="container-fluid p-0">

        <h1 class="h3 mb-3">Dodaj wydatek</h1>

        <form:form method="post" modelAttribute="expensesDao" enctype="multipart/form-data">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <div class="card-header">
                            <h5 class="card-title mb-0">Data wydatku</h5>
                        </div>

                        <div class="card-body">
                            <form:input type="date" path="dateExpenses" class="form-control" rows="2" placeholder="Cel podróży"/>
                        </div>

                        <div class="card-header">
                            <h5 class="card-title mb-0">Rodzaj wydatku</h5>
                        </div>
                        <div class="card-body">
                            <form:select class="form-select mb-3" items="${typeOfExpenses}" path="type" itemLabel="type" itemValue="id"/>
                        </div>

                        <div class="card-header">
                            <h5 class="card-title mb-0">Liczba (np. kilometrów)</h5>
                        </div>
                        <div class="card-body">
                            <form:input path="kmOrNumber" type="number" class="form-control"/>
                        </div>

                        <div class="card-header">
                            <h5 class="card-title mb-0">Kwota</h5>
                        </div>
                        <div class="card-body">
                            <form:input path="amount" type="number"  class="form-control"/>
                        </div>

                        <div class="card-header">
                            <h5 class="card-title mb-0">Waluta</h5>
                        </div>
                        <div class="card-body">
                            <form:input path="currency" type="text"  class="form-control"/>
                        </div>

                        <div class="card-header">
                            <h5 class="card-title mb-0">Rodzaj płatności</h5>
                        </div>
                        <div class="card-body">
                            <form:input path="paymentMethod" type="text"  class="form-control"/>
                        </div>

                        <div class="card-header">
                            <h5 class="card-title mb-0">Opis wydatku</h5>
                        </div>

                        <div class="card-body">
                            <form:input type="text" path="description" class="form-control" rows="2" placeholder="Szczegóły"/>
                        </div>

                        <div class="card-header">
                            <h5 class="card-title mb-0">Załącznik</h5>
                        </div>

                        <div class="card-body">
                            <form:input path="dbFile" type="file"/>
                        </div>
                        
                        <input type="hidden" value="<c:out value="${statementOfCoast}"/>" name="id">
                        
                        <input class="btn btn-success" type="submit" value="Zapisz">
                    </div>
                </div>
            </div>
            </form:form>

    </div>
</main>

<jsp:include page="../footer.jsp"/>