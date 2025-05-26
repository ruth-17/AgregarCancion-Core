<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
      <head>
            <meta charset="UTF-8">
            <title>Detalle de Canciones</title>
            <link rel="stylesheet" href="css/canciones.css"/>
      </head>
      <body>
            <h2>Detalles</h2>
            <div>
                  <h4>${cancion.titulo}</h4>
                  <p>Artista: ${cancion.artista}</p>
                  <p>Álbum: ${cancion.album}</p>
                  <p>Género: ${cancion.genero}</p>
                  <p>Idioma: ${cancion.idioma}</p>
                  <p>ID: ${cancion.id}</p>
                  <p>Fecha de Subida: ${cancion.fechaCreacion}</p>
                  <p>Última modificación: ${cancion.fechaActualizacion}</p>
            </div>
            <a href="/canciones/formulario/editar/${cancion.id}">
                  <button>Editar Canción</button>
            </a>
            <a href="/canciones">Volver a la lista de canciones</a>
      </body>
</html>