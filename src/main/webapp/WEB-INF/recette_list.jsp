<%--
  Created by IntelliJ IDEA.
  User: Yassine
  Date: 27/04/2023
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Cuisine | Liste des recettes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<c:import url="header.jsp"></c:import>

<div class="container">
    <h1>Recettes</h1>

    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-3 align-content-center">
        <c:forEach var="r" items="${recettes}">
            <div class="col">
                <div class="card">
                    <img src="${r.getCategory().getCategoryPicUr()}" class="card-img-top" alt="${r.getCategory().getName()}">
                    <div class="card-body">
                        <h5 class="card-title">${r.name}</h5>
                        <p class="card-text">${r.user.firstname} ${r.user.lastname}</p>
                        <fmt:parseDate value="${r.createdAt}" pattern="yyyy-MM-dd'T'HH:mm" var="postDate" type="date"/>
                        <p class="card-text">${r.category.name}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>

