<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

<main class="content">
    <div class="container-fluid p-0">

        <h1 class="h3 mb-3">Nowy wniosek</h1>

        <form:form method="post" modelAttribute="applicationDto">
        <div class="row">
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb0">Cel podróży</h5>
                    </div>
                    <div class="card-body">
                        <form:input type="text" path="purpose" class="form-control" rows="2" placeholder="Cel podróży"/>
                        <form:errors path="purpose"/>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Kraj delegacji</h5>
                    </div>
                    <div class="card-body">
                        <form:select class="form-select mb-3" items="${countries}" path="country" itemLabel="country" itemValue="id"/>
                        <form:errors path="country"/>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Data wyjazdu</h5>
                    </div>
                    <div class="card-body">
                        <form:input path="fromDate" type="date" class="form-control"/>
                        <form:errors path="fromDate"/>
                        <c:if test="${not empty error}">
                            <div class="alert alert-success">${error}</div>
                        </c:if>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Planowana data powrotu</h5>
                    </div>
                    <div class="card-body">
                        <form:input path="toDate" type="date"  class="form-control"/>
                        <form:errors path="toDate"/>
                    </div>
                </div>
            </div>
            <div class="col-6 h-100">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Szczegóły(opcjonalnie)</h5>
                    </div>
                    <div class="card-body">
                        <form:textarea type="text" path="description" class="form-control" rows="2" placeholder="Szczegóły"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="offset-5">
                <div class="col-2">
                    <input class="btn btn-success" type="submit" value="Zapisz">
                </div>
            </div>
        </div>
        </form:form>
    </div>
</main>

<jsp:include page="../footer.jsp"/>