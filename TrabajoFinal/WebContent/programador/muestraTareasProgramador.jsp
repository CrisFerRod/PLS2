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
   .resaltar{color:red;}
</style>
</head>
<body>

<h1> Tareas asociadas al programador ${programador} </h1>

<table>
<tr>
 <th> Nombre tarea </th>
 <th> Asignada a </th>
 <th> Fecha prevista finalización </th>
 <th> Fecha finalizada </th>
</tr>
<c:forEach items="${tareas}" var="tarea">
   <tr <c:if test = "${tarea.fechaFinalizacion > tarea.fechaTope}"> class="resaltar" </c:if>> 
      <td>${tarea.nombre} </td> 
      <td>${tarea.programador} </td>
      <td>${tarea.fechaTope} </td>
      <td>${tarea.fechaFinalizacion} </td>
      <td><form action="/TrabajoFinal/programador/FinalizarTarea" method="POST">
              <input type="hidden" id="programador" name="programador" value="${programador}"/>
              <input type="hidden" id="id_tarea" name="id_tarea" value="${tarea.id}"/>
              <input type="submit" value="Finalizar" />
          </form>
      </td>
   </tr>
</c:forEach>
</table>

</body>
</html>