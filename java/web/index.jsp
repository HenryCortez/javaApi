<%-- 
    Document   : index
    Created on : 20 may 2024, 7:46:06 a. m.
    Author     : henry
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.buscador.Student"%>
<%@page import="com.mycompany.buscador.apiConsumer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="GET">
            <label for="id">text</label>
            <input type="number" name="id">
            <input type="submit" value="Button">
        </form>
        <%
            if(request.getMethod().equals("GET"))
            {
            String id = request.getParameter("id");
            List<Student> estudiantes = apiConsumer.buscarEstudiante(id);
           %>
           <table>
               <thead>
               <th>id</th>
               <th>nombre</th>
               <th>apellido</th>
               <th>direccion</th>
               <th>telefono</th>
               </thead>
               <tbody>
                   <% for(Student student : estudiantes){
     
                   %>
                   <tr>
                       <td><%=student.getId() %></td>
                       <td><%=student.getNombre()%></td>
                       <td><%=student.getApellido()%></td>
                       <td><%=student.getDireccion()%></td>
                       <td><%=student.getTelefono()%></td>
                   </tr>
                   <%
                       }
                       %>
               </tbody>
               
           </table>
           <%
        }
            %>
    </body>
</html>
