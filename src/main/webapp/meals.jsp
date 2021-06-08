<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
</body>
<table border="1" cellpadding="7">
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <%--@elvariable id="meals" type="java.util.List"--%>
    <c:forEach items="${requestScope.meals}" var="meal">
        <tr  style="color:${(meal.excess != true ? 'green' : 'red')}">
            <th>
              <c:out value="${meal.dateTime.toLocalDate()}"> </c:out>
                <c:out value="${meal.dateTime.toLocalTime()}"> </c:out>
            </th>
            <th>
                <c:out value="${meal.description}"> </c:out>
            </th>
            <th>
                <c:out value="${meal.calories}"> </c:out>
            </th>
        </tr>
    </c:forEach>

</table>
</html>