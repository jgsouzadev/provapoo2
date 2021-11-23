<%-- 
    Document   : index
    Created on : 22 de nov. de 2021, 21:01:32
    Author     : joao.souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="WEB-INF/header.jspf" %>
        <% if (!usuarioLogado) { %>
        <h5 style="color: red">Faça Login para visualizar as tarefas</h5>

        <% } else { %>
        <form>
            <label for="title">Titulo da tarefa:
                <input id="title" name="title" required> 
                <button type="submit" name="store" value="store">Cadastrar</button>            
            </label>
        </form>

        <table>
            <thead>
            <th>Nome da tarefa</th>
        </thead>
        <tbody id="bodyTable">
            <!-- to doo -->
            <%
                System.out.println(tasks);
		for(int i = 0; i < tasks.size(); i++) {				
            %>
		
		<tr>
			<td> <%= tasks.get(i) %> </td>
		</tr>
		
		<% } %>
        </tbody>
    </table>


    <% }%>

</body>
</html>
