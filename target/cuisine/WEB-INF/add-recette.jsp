<%--
  Created by IntelliJ IDEA.
  User: Yassine
  Date: 27/04/2023
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cuisine | Ajouter une recette</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<header class="mb-4">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container-fluid">
            <img src="https://img.icons8.com/plasticine/64/null/blog.png"/>
            <a class="navbar-brand" href="#">The Blog</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="recettes">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="add-post">Ajouter une recette</a>
                    </li>
                </ul>
                <form class="d-flex" role="search" action="${pageContext.request.contextPath}/" method="get">
                    <input name="searchName" class="form-control me-2" type="search" placeholder="Search"
                           aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">chercher</button>
                </form>
            </div>
        </div>
    </nav>
</header>

<div class="container">

    <div class="col-6 offset-3">
        <h1>Ajouter une recette</h1>

        <form method="post" action="add-recette">
            <div class="input-group mb-3">
                <input type="text" class="form-control" name="name" placeholder="Nom de la recette...">
            </div>



            <div class="input-group mb-3">
                <select name="categoryId" class="form-select">
                    <c:forEach items="${categorys}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="input-group mb-3">
                <textarea class="form-control" name="ingredient" placeholder="ingrédients.."></textarea>
            </div>

            <div class="input-group mb-3">
                <textarea class="form-control" name="steps" placeholder="Etapes pour faire la recette.."></textarea>
            </div>

            <div class="input-group">
                <button type="submit" class="btn btn-outline-dark">Submit</button>
            </div>
        </form>
    </div>


</div>


</body>
</html>

