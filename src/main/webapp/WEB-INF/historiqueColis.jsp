<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Historique du Colis</title>
</head>
<body>
<h1>Historique du Colis</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Poid</th>
        <th>Prix</th>
        <th>Origine</th>
        <th>Destination</th>
        <th>Localisation</th>
        <th>État</th>
        <th>Date de Modification</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<String> formattedHistories = (List<String>) request.getAttribute("formattedHistories");
        for (String row : formattedHistories) {
            out.println(row);
        }
    %>
    </tbody>
</table>

<a href="/jakartaee-deliver-transport/colisDashboard">Retour au Dashboard</a>
</body>
</html>
