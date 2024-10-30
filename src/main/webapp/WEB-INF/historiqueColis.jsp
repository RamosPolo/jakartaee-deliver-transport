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
    <c:forEach var="history" items="${histories}">
        <tr>
            <td>${history.colisId}</td>
            <td>${history.poid}</td>
            <td>${history.prix}</td>
            <td>(${history.origineX}, ${history.origineY})</td>
            <td>(${history.destinationX}, ${history.destinationY})</td>
            <td>(${history.localisationX}, ${history.localisationY})</td>
            <td>${history.etat}</td>
            <td>${history.modifiedAt}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/jakartaee-deliver-transport/colisDashboard">Retour au Dashboard</a>
</body>
</html>
