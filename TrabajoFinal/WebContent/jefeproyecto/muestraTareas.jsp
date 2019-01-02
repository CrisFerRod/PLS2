<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tareas</title>
<style type="text/css">
   table {border-collapse: collapse;} 
   table, tr, td , th {border: 1px solid blue;} 
   th {font-weight: bold;}
   td {padding-left: 2em; padding-right:2em;}
</style>
</head>
<body>

<h1> Tareas asociadas al proyecto ${proyecto.nombre} </h1>

<table>
<tr>
 <th> Nombre tarea </th>
 <th> Asignada a </th>
 <th> Fecha prevista finalización </th>
 <th> Fecha finalizada </th>
</tr>
<c:forEach items="${tareas}" var="tarea">
   <tr> 
      <td>${tarea.nombre} </td> 
      <td>${tarea.programador} </td>
      <td>${tarea.fechaTope} </td>
      <td>${tarea.fechaFinalizacion} </td>
   </tr>
</c:forEach>
</table>

<h2> Crear una nueva tarea </h2>

<form action="/TrabajoFinal/jefeproyecto/AddTarea" method="POST">
  <input type="hidden" id="id_pr" name="id_pr" value="${proyecto.id}"/>
  Nombre de la tarea: <input type="text" name="nombre" /> <br>
  Asignar tarea a: <input type="text" name="programador" /> <br>
  Fecha prevista finalización: <br>
  Año(yyyy) <input type="number" name="anyo" /> 
  Mes(mm) <input type="number" name="mes" /> 
  Día(dd) <input type="number" name="dia" /><br>
  <input type="submit" value="Añadir tarea" />
</form>

</body>
</html>