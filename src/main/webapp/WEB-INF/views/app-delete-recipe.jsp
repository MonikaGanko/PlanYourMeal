<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<jsp:include page="app-header.jsp"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<h1>Czy na pewno chcesz usunac ten przepis?</h1>
<form method="post">
    <input type="hidden" name="toDelete" value="true">
    <input type="submit" value="Usun">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>
<form method="post">
    <input type="hidden" name="toDelete" value="false">
    <input type="submit" value="Anuluj">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>
<jsp:include page="footer.jsp"/>