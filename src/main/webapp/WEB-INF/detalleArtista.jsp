<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
      <head>
            <meta charset="UTF-8">
            <title>Detalle de Artista</title>
      </head>
      <body>
            <h2>Detalles</h2>
            <div>
                  <h4>${artista.nombre} ${artista.apellido}</h4>
                  <p>Biografía: ${artista.biografia}</p>
                  <ul>
                      <c:forEach var="canciones" items="${listaCanciones}">
                          <li>${artista.canciones}</li>
                      </c:forEach>
                  </ul>
                  <p>ID: ${artista.id}</p>
                  <p>Fecha de Subida: ${artista.fechaCreacion}</p>
                  <p>Última modificación: ${artista.fechaActualizacion}</p>
            </div>
            <a href="/artistas">Volver a la lista de artistas</a>
      </body>
</html>