<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="shared/header.jsp" />

<div role="main" class="container" style="margin-top:100px;">
		<h1>Liste des ${nameObjet}</h1>
		<table class="table table-hover table-striped w-auto" style="color: #583333;">
            <thead style="background-color: #8fd8e2;">
                <tr>
                    <th class="col-sm-10">Libellé</th>
                    <th class="col-sm-1"></th>
                    <th class="col-sm-1"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${liste}" var="item">
                    <tr>
                        <td>${item.libelle}</td>
                        <td>
                            <form method="POST" action="<%=request.getContextPath() %>/main?page=${item.getClass()}&action=edit&id=${item.id}">
                            <button title="Edit" class="btn btn-outline-info" type="submit">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
                                  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                                </svg>
                            </button>
                            </form>
                        </td>
                        <td>
                            <button title="Delete" class="btn btn-outline-danger ajaxdelete" type="submit" href="<%=request.getContextPath() %>/webapp/delete?typeObj=${nameBean}&id=${item.getId()}">
                                <i class="fa fa-trash pl-0"></i>
                            </button>
                        </td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
</div>

<script>
    var httpRequest = new XMLHttpRequest()

    var links = document.querySelectorAll('.ajaxdelete')

    for(var i = 0; i < links.length; i++){
        var link = links[i]
        link.addEventListener('click', function (e){
            e.preventDefault()

            var httpRequest = new XMLHttpRequest()

            httpRequest.onreadystatechange = function () {

                if (httpRequest.readyState === 4) {
                    if (httpRequest.status === 200) {
                        notify(httpRequest.responseText)
                    } else {
                        // Le serveur a renvoyé un status d'erreur
                    }
                }
            }

            httpRequest.open('GET', this.getAttribute('href'), true)
            httpRequest.send()
        })
    }

    function notify(message) {
      alert(message)
    }
</script>
<jsp:include page="shared/footer.jsp" />