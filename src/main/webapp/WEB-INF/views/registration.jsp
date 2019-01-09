<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

    <section class="dashboard-section">
        <div class="container pt-4 pb-4">
            <div class="border-dashed view-height">
                <div class="container w-25">
                    <form:form class="padding-small text-center" method="post" modelAttribute="admin">
                        <h1 class="text-color-darker">Rejestracja</h1>
                        <div class="form-group">
                            <form:input type="text" path="firstName" id="firstNameId" class="form-control" placeholder="podaj imię"/>
                            <form:errors path="firstName" element="div"/>
                        </div>
                        <div class="form-group">
                            <form:input type="text" class="form-control" id="lastNameId" path="lastName" placeholder="podaj nazwisko"/>
                            <form:errors path="lastName" element="div"/>
                        </div>

                        <div class="form-group">
                            <form:input type="text" class="form-control" id="usernameId" path="username" placeholder="podaj username"/>
                            <form:errors path="username" element="div"/>
                        </div>

                        <div class="form-group">
                            <form:input type="text" class="form-control" id="emailId" path="email" placeholder="podaj email"/>
                            <form:errors path="email" element="div"/>
                        </div>
                        <div class="form-group">
                            <form:input type="password" class="form-control" id="passwordId" path="password" placeholder="podaj hasło"/>
                            <form:errors path="password" element="div"/>
                        </div>
                        <div class="form-group">
                            <form:input type="password" class="form-control" id="passwordCheckId" path="passwordCheck" placeholder="powtórz hasło"/>
                            <form:errors path="passwordCheck" element="div"/>
                        </div>
                        <button class="btn btn-color rounded-0" type="submit">Zarejestruj</button>
                    </form:form>
                 </div>
            </div>
        </div>
    </section>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

<jsp:include page="footer.jsp"/>