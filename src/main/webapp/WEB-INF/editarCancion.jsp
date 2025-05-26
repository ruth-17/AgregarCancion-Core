<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
      <head>
            <meta charset="UTF-8">
            <title>Formulario editar cancion</title>
      </head>
      <body>
            <form:form action="/canciones/procesa/editar/${cancion.id}" method="POST" modelAttribute="cancion">
                  <input type="hidden" name="_method" value="PUT"/>
                  <div>
                        <form:label path="titulo" for="titulo">Título: </form:label>
                        <form:input path="titulo" value="${cancion.titulo}"/>
                        <form:errors path="titulo"></form:errors>
                  </div>
                  <div>
                        <form:label path="artista" for="artista">Artista: </form:label>
                        <form:input path="artista" value="${cancion.artista}"/>
                        <form:errors path="artista"></form:errors>
                  </div>
                  <div>
                        <form:label path="album" for="album">Álbum: </form:label>
                        <form:input path="album" value="${cancion.album}"/>
                        <form:errors path="album"></form:errors>
                  </div>
                  <div>
                        <form:label path="genero" for="genero">Género: </form:label>
                        <form:input path="genero" value="${cancion.genero}"/>
                        <form:errors path="genero"></form:errors>
                  </div>
                  <div>
                        <form:label path="idioma" for="idioma">Idioma: </form:label>
                        <form:input path="idioma" value="${cancion.idioma}"/>
                        <form:errors path="idioma"></form:errors>
                  </div>
                  <button>Añadir cambios</button>
            </form:form>
            
            <a href="/canciones">Volver a la lista de canciones</a>
      
      </body>
</html>