<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="/resources/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

<div class="main">


<div class="container">
    <div class="signin-content">
        <div class="signin-image">
            <figure><img src="/resources/images/signin-image.jpg" alt="sing up image"></figure>
            <a href="<c:url value="/register"/> " class="signup-image-link">Create an account</a>
        </div>

        <div class="signin-form">
            <h2 class="form-title">Sign up</h2>
            <form method="post" class="register-form">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                    <label for="inputLogin"><i class="zmdi zmdi-account material-icons-name"></i></label>
                    <input type="text" name="username" id="inputLogin" placeholder="Twój login" required="required" autofocus="autofocus"/>
                </div>
                <div class="form-group">
                    <label for="inputPassword"><i class="zmdi zmdi-lock"></i></label>
                    <input type="password" name="password" id="inputPassword" placeholder="Hasło" required="required"/>
                </div>
                <div class="form-group form-button">
                    <input type="submit" class="form-submit" value="Login"/>
                </div>
            </form>
        </div>
    </div>
</div>

</div>

<!-- JS -->
<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>