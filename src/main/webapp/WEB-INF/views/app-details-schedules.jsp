<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="m-4 p-3 width-medium ">
    <div class="dashboard-content border-dashed p-3 m-4">
        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding">
                <h3 class="color-header text-uppercase">SZCZEGÓŁY PLANU</h3>
            </div>
            <div class="col d-flex justify-content-end mb-2 noPadding">
                <a href="/app/plan/list" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
            </div>
        </div>

        <div class="schedules-content">
            <div class="schedules-content-header">
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Nazwa planu
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">${plan.name}</p>
                    </div>
                </div>
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Opis planu
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">
                            ${plan.description}
                        </p>
                    </div>
                </div>
            </div>

            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Poniedziałek</th>
                    <th class="col-2"></th>
                    <th class="col-6"></th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>

                </thead>
                <tbody class="text-color-lighter">
                <tr class="d-flex">
                    <th class="col-2">Posiłek</th>
                    <th class="col-2">Potrawa</th>
                    <th class="col-6">Opis</th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                <c:forEach var="planrecipe" items="${monday}">
                    <tr class="d-flex">
                        <td class="col-2">${planrecipe.mealName}</td>
                        <td class="col-2">${planrecipe.recipe.name}</td>
                        <td class="col-6">${planrecipe.recipe.description}</td>
                        <td class="col-1 center">
                            <a href="/app/recipe/delete/${planrecipe.id}/${plan.id}" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                        </td>
                        <td class="col-1 center">
                            <a href="/app/recipe/details/${planrecipe.recipe.id}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Wtorek</th>
                    <th class="col-2"></th>
                    <th class="col-6"></th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                </thead>
                <tbody class="text-color-lighter">
                <tr class="d-flex">
                    <th class="col-2">Posiłek</th>
                    <th class="col-2">Potrawa</th>
                    <th class="col-6">Opis</th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                <c:forEach var="planrecipe" items="${tuesday}">
                    <tr class="d-flex">
                        <td class="col-2">${planrecipe.mealName}</td>
                        <td class="col-2">${planrecipe.recipe.name}</td>
                        <td class="col-6">${planrecipe.recipe.description}</td>
                        <td class="col-1 center">
                            <a href="/app/recipe/delete/${planrecipe.id}/${plan.id}" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                        </td>
                        <td class="col-1 center">
                            <a href="/app/recipe/details/${planrecipe.recipe.id}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Środa</th>
                    <th class="col-2"></th>
                    <th class="col-6"></th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                </thead>
                <tbody class="text-color-lighter">
                <tr class="d-flex">
                    <th class="col-2">Posiłek</th>
                    <th class="col-2">Potrawa</th>
                    <th class="col-6">Opis</th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                <c:forEach var="planrecipe" items="${wednesday}">
                    <tr class="d-flex">
                        <td class="col-2">${planrecipe.mealName}</td>
                        <td class="col-2">${planrecipe.recipe.name}</td>
                        <td class="col-6">${planrecipe.recipe.description}</td>
                        <td class="col-1 center">
                            <a href="/app/recipe/delete/${planrecipe.id}/${plan.id}" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                        </td>
                        <td class="col-1 center">
                            <a href="/app/recipe/details/${planrecipe.recipe.id}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Czwartek</th>
                    <th class="col-2"></th>
                    <th class="col-6"></th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                </thead>
                <tbody class="text-color-lighter">
                <tr class="d-flex">
                    <th class="col-2">Posiłek</th>
                    <th class="col-2">Potrawa</th>
                    <th class="col-6">Opis</th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                <c:forEach var="planrecipe" items="${thursday}">
                    <tr class="d-flex">
                        <td class="col-2">${planrecipe.mealName}</td>
                        <td class="col-2">${planrecipe.recipe.name}</td>
                        <td class="col-6">${planrecipe.recipe.description}</td>
                        <td class="col-1 center">
                            <a href="/app/recipe/delete/${planrecipe.id}/${plan.id}" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                        </td>
                        <td class="col-1 center">
                            <a href="/app/recipe/details/${planrecipe.recipe.id}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Piątek</th>
                    <th class="col-2"></th>
                    <th class="col-6"></th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                </thead>
                <tbody class="text-color-lighter">
                <tr class="d-flex">
                    <th class="col-2">Posiłek</th>
                    <th class="col-2">Potrawa</th>
                    <th class="col-6">Opis</th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                <c:forEach var="planrecipe" items="${friday}">
                    <tr class="d-flex">
                        <td class="col-2">${planrecipe.mealName}</td>
                        <td class="col-2">${planrecipe.recipe.name}</td>
                        <td class="col-6">${planrecipe.recipe.description}</td>
                        <td class="col-1 center">
                            <a href="/app/recipe/delete/${planrecipe.id}/${plan.id}" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                        </td>
                        <td class="col-1 center">
                            <a href="/app/recipe/details/${planrecipe.recipe.id}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Sobota</th>
                    <th class="col-2"></th>
                    <th class="col-6"></th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                </thead>
                <tbody class="text-color-lighter">
                <tr class="d-flex">
                    <th class="col-2">Posiłek</th>
                    <th class="col-2">Potrawa</th>
                    <th class="col-6">Opis</th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                <c:forEach var="planrecipe" items="${saturday}">
                    <tr class="d-flex">
                        <td class="col-2">${planrecipe.mealName}</td>
                        <td class="col-2">${planrecipe.recipe.name}</td>
                        <td class="col-6">${planrecipe.recipe.description}</td>
                        <td class="col-1 center">
                            <a href="/app/recipe/delete/${planrecipe.id}/${plan.id}" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                        </td>
                        <td class="col-1 center">
                            <a href="/app/recipe/details/${planrecipe.recipe.id}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Niedziela</th>
                    <th class="col-2"></th>
                    <th class="col-6"></th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                </thead>
                <tbody class="text-color-lighter">
                <tr class="d-flex">
                    <th class="col-2">Posiłek</th>
                    <th class="col-2">Potrawa</th>
                    <th class="col-6">Opis</th>
                    <th class="col-1"></th>
                    <th class="col-1"></th>
                </tr>
                <c:forEach var="planrecipe" items="${sunday}">
                    <tr class="d-flex">
                        <td class="col-2">${planrecipe.mealName}</td>
                        <td class="col-2">${planrecipe.recipe.name}</td>
                        <td class="col-6">${planrecipe.recipe.description}</td>
                        <td class="col-1 center">
                            <a href="/app/recipe/delete/${planrecipe.id}/${plan.id}" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                        </td>
                        <td class="col-1 center">
                            <a href="/app/recipe/details/${planrecipe.recipe.id}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
</section>








<jsp:include page="footer.jsp"/>
