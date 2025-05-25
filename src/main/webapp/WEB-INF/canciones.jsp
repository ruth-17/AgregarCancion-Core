<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
      <head>
            <meta charset="UTF-8">
            <title>Canciones</title>
            <link rel="stylesheet" href="css/canciones.css"/>
      </head>
      <body>
            <div class="container">
                  <table class="table">
                        <thead>
                               <tr>
                                   <th class="categories">Título</th>
                                   <th class="categories">Autor</th>
                                   <th class="categories">Detalle</th>
                               </tr>
                        </thead>
                        <tbody>
                              <c:forEach var="cancion" items="${listaCanciones}">
                                    <tr>
                                        <td>${cancion.titulo}</td>
                                        <td>${cancion.artista}</td>
                                        <td><a href="/canciones/detalle/${cancion.id}">Detalle</a></td>
                                    </tr>
                              </c:forEach>
                        </tbody>
                  </table>
                  <form action="/canciones/formulario/agregar">
                        <button type="submit">Añadir Canción</button>
                  </form>
                  
            </div>
      </body>
</html>