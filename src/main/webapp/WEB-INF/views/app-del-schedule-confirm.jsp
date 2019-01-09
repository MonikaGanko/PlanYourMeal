<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>
<jsp:include page="app-header.jsp"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<div class="m-4 p-3 width-medium">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding">
                <h3 class="color-header text-uppercase">CZY NA PEWNO CHCESZ USUNĄĆ TEN PLAN ?</h3>
            </div>
        </div>

        <div class="schedules-content">
            <table class="table border-bottom">
                <thead>
                    <tr class="d-flex">
                        <th class="col-1">ID</th>
                        <th class="col-2">NAZWA</th>
                        <th class="col-7">OPIS</th>
                        <th class="col-2 center">AKCJE</th>
                    </tr>
                </thead>
                <tbody class="text-color-lighter">
                <c:if test="${not empty plan}">
                        <tr class="d-flex">
                            <td class="col-1">${plan.id}</td>
                            <td class="col-2">${plan.name}</td>
                            <td class="col-7">${plan.description}</td>

                                <form:input type="hidden" path="plan.id"/>
                                <td class="col-2 d-flex align-items-center justify-content-center flex-wrap">
                                    <a href="/app/plan/deleted/${plan.id}" class="btn btn-danger rounded-0 text-light m-1" type="submit">Usuń</a>
                                    <a href="/app/plan/list" class="btn btn-info rounded-0 text-light m-1">Anuluj</a>
                                </td>
                        </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
</section>

<jsp:include page="footer.jsp"/>
