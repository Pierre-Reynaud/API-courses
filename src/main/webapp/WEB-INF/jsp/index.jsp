<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="shared/header.jsp" />
<style><%@include file="./shared/style.css"%></style>
<div role="main" class="container" style="margin-top:100px;">
		<h1>Bienvenue sur Coursesrapides !</h1>

        <h2>${message}</h2>

        <ul>
            <li class="categorie">Catégories
                <ul class="menucategorie submenu">
                    <li><a href="./liste?objet=categorie">Tout voir</a></li>
                    <li>Ajouter une catégorie AJAX</li>
                </ul>
            </li>
            <li class="ingredient">Ingrédients
                <ul class="menuingredient submenu">
                    <li><a href="./liste?objet=ingredient">Tout voir</a></li>
                    <li>Ajouter un ingredient AJAX</li>
                    <!-- Pour chaque catégorie...-->
                    <li>Fruit</li>
                    <li>Viande</li>
                </ul>
            </li>
            <li class="recette">Recettes
                <ul class="menurecette submenu">
                    <li><a href="./liste?objet=recette">Tout voir</a></li>
                    <li>Ajouter une recette AJAX</li>
                </ul>
            </li>
            <li class="listecourse">Listes de courses
                <ul class="menulistecourse submenu">
                    <li><a href="./liste?objet=listecourse">Tout voir</a></li>
                    <li>Nouvelle liste AJAX</li>
                    <li>DERNIERE LISTE CREE</li>
                </ul>
            </li>
        </ul>
</div>

<jsp:include page="shared/footer.jsp" />