<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Moja delegacja</title>
</head>
<body>

<h1>Wylicz diete: </h1>
<form:form method="post" modelAttribute="diet">
    <div>
        Liczba śniadań: <form:input path="countBreakfast" type="number"/>
    </div>
    <div>
        Liczba obiadów: <form:input path="countDinner" type="number"/>
    </div>
    <div>
        Liczba kolacji: <form:input path="countSupper" type="number"/>
    </div>
    <div>
        Początek delegacji: <form:input path="fromDate" type="date"/>
        <form:input path="fromTime" type="time"/>
    </div>
    <div>
        Koniec delegacji: <form:input path="toDate" type="date"/>
        <form:input path="toTime" type="time"/>
    </div>
    <div>
        Kraj delegacji: <form:select items="${countries}" path="country" itemLabel="country" itemValue="id"/>
    </div>
    <input type="submit" value="Zapisz">
</form:form>

</body>
</html>
