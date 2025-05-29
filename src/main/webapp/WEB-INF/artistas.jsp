<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
      <head>
            <meta charset="UTF-8">
            <title>Artistas</title>
      </head>
      <body>
            <h2>Lista de Artistas</h2>
            <div>
                  <ul>
                      <c:forEach var="artista" items="${listaArtistas}">
                          <li>
                              ${artista.nombre} ${artista.apellido} - <a href="/artistas/detalle/${artista.id}">Información</a>
                          </li>
                      </c:forEach>
                  </ul>
            </div>
            
            <a href="/canciones">Ir a canciones</a>
            
      </body>
</html>