<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zaplanuj Jedzonko</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="/../resources/html/css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>

<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-between">
        <a href="/" class="navbar-brand main-logo main-logo-smaller">
            Zaplanuj <span>Jedzonko</span>
        </a>
        <div class="d-flex justify-content-around">
            <h4 class="text-light mr-3">${plan.admin.firstName}</h4>
            <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>
            <form class="nav-item ml-4" action="/logout" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
                <input  type="submit" value="Logout">
            </form>
        </div>
    </nav>
</header>

<jsp:include page="app-header.jsp"/>


<div class="m-4 p-3 width-medium">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <form:form method="post" action="/app/recipe/plan/added" modelAttribute="planRecipe">
        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding">
                <h3 class="color-header text-uppercase">DODAJ PRZEPIS DO PLANU</h3>
            </div>
            <div class="col d-flex justify-content-end mb-2 noPadding">
                <button class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4" type="submit">Zapisz
                </button>
            </div>
        </div>

            <div class="schedules-content">
                <div class="form-group row">
                    <label for="choosePlan" class="col-sm-2 label-size col-form-label">
                        Wybierz plan
                    </label>
                    <div class="col-sm-3">
                        <form:select class="form-control" path="plan.id" items="${plans}" itemLabel="name"
                                     itemValue="id" id="choosePlan"/>
                        <form:errors path="plan" element="div" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nameId" class="col-sm-2 label-size col-form-label">
                        Nazwa posiłku
                    </label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" path="mealName" id="nameId"
                                    placeholder="Nazwa posiłku"/>
                        <form:errors path="mealName" element="div" cssClass="error"/>

                    </div>
                </div>
                <div class="form-group row">
                    <label for="numberId" class="col-sm-2 label-size col-form-label">
                        Numer posiłku
                    </label>
                    <div class="col-sm-2">
                        <form:input type="number" class="form-control" path="ord" id="numberId"
                                    placeholder="Numer posiłku"/>
                        <form:errors path="ord" element="div" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="recipeId" class="col-sm-2 label-size col-form-label">
                        Przepis
                    </label>
                    <div class="col-sm-4">
                        <form:select class="form-control" path="recipe" items="${recipes}"
                                     itemLabel="name" itemValue="id" id="recipeId"/>
                        <form:errors path="recipe" element="div" cssClass="error"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="dayId" class="col-sm-2 label-size col-form-label">
                        Dzień
                    </label>
                    <div class="col-sm-2">
                        <form:select class="form-control" path="dayName.id" items="${days}" itemLabel="name"
                                     itemValue="id" id="dayId"/>
                        <form:errors path="dayName.id" element="div" cssClass="error"/>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>

</div>
</section>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>