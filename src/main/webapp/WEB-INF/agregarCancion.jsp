<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
      <head>
            <meta charset="UTF-8">
            <title>Formulario Agregar Cancion</title>
      </head>
      <body>
            <h1>Formulario para agregar canción</h1>
            <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
                  <div>
                        <form:label path="titulo">Título: </form:label>
                        <form:input path="titulo"/>
                        <form:errors path="titulo"></form:errors>
                  </div>
                  <div>
                        <form:label path="artista">Artista: </form:label>
                        <form:input path="artista"/>
                        <form:errors path="artista"></form:errors>
                  </div>
                  <div>
                        <form:label path="album">Álbum: </form:label>
                        <form:input path="album"/>
                        <form:errors path="album"></form:errors>
                  </div>
                  <div>
                        <form:label path="genero">Género: </form:label>
                        <form:input path="genero"/>
                        <form:errors path="genero"></form:errors>
                  </div>
                  <div>
                        <form:label path="idioma">Idioma: </form:label>
                        <form:input path="idioma"/>
                        <form:errors path="idioma"></form:errors>
                  </div>
                  <button>Añadir canción</button>
            </form:form>
            
            <a href="/canciones">Volver a la lista de canciones</a>
      
      </body>
</html>