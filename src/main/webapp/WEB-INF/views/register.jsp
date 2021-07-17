<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <div class="signup-content">
      <div class="signup-form">
        <h2 class="form-title">Sign up</h2>

        <form:form method="POST">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

          <div class="form-group">
            <label for="firstName"><i class="zmdi zmdi-account material-icons-name"></i></label>
            <input type="text" name="firstName" id="firstName" placeholder="Twoje imię" required="required"/>
          </div>

          <div class="form-group">
            <label for="lastName"><i class="zmdi zmdi-account material-icons-name"></i></label>
            <input type="text" name="lastName" id="lastName" placeholder="Twoje nazwisko" required="required"/>
          </div>

          <div class="form-group">
            <label for="login"><i class="zmdi zmdi-account material-icons-name"></i></label>
            <input type="text" name="login" id="login" placeholder="Twój login" required="required"/>
          </div>

          <div class="form-group">
            <label for="email"><i class="zmdi zmdi-email"></i></label>
            <input type="email" name="email" id="email" placeholder="Twój Email" required="required"/>
          </div>

          <div class="form-group">
            <label for="password"><i class="zmdi zmdi-lock"></i></label>
            <input type="password" name="password" id="password" placeholder="Hasło" required="required"/>
          </div>

          <div class="form-group">
            <label for="confirm_password"><i class="zmdi zmdi-lock-outline"></i></label>
            <input type="password" name="confirm_password" id="confirm_password" placeholder="Powtórz swoje hasło" required="required"/>
          </div>

          <div class="form-group form-button">
            <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
          </div>
        </form:form>
      </div>
      <div class="signup-image">
        <figure><img src="/resources/images/signup-image.jpg" alt="sing up image"></figure>
        <a href="<c:url value="/login"/> " class="signup-image-link">I am already member</a>
      </div>
    </div>
  </div>
</div>

<!-- JS -->
<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>