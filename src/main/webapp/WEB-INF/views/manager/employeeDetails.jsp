<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../header.jsp"/>

<main class="content">
    <div class="container-fluid p-0">

        <h1 class="h3 mb-3">Szczegóły pracownika</h1>

        <div class="row">
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Imię:</h5>
                    </div>
                    <div class="card-body">
                        ${employee.firstName}
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Nazwisko:</h5>
                    </div>
                    <div class="card-body">
                        ${employee.lastName}
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Email</h5>
                    </div>
                    <div class="card-body">
                        ${employee.email}
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title mb-0">Nazwa konta</h5>
                    </div>
                    <div class="card-body">
                        ${employee.username}
                    </div>
                </div>
            </div>
        </div>
        <a href="/index" class="btn btn-warning">Anuluj</a>

    </div>
</main>

<jsp:include page="../footer.jsp"/>