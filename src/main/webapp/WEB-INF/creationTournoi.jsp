<%--
  Created by IntelliJ IDEA.
  User: karim
  Date: 18/06/2023
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Formulaire de création de tournoi.</h1>

<form action="CreationTournoi" method="post">

    <label for="nom">Nom du tournoi</label>
    <input type="text" id="nom" name="nom" placeholder="Nom du tournoi" required>
    <br>
    <label for="date">Date et heure du tournoi</label>
    <input type="text" id="date" name="date" placeholder=" yyyy-MM-dd-HH-mm-ss-ns" required>
<%--    Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)--%>
    <br>
    <label for="jeu">Jeu</label>
    <input type="text" id="jeu" name="jeu" placeholder="jeu" required>
    <br>
    <label for="équip">Les équipes</label>
    <input type="text" id="équip" name="équipes" placeholder="les équipes" required>
    <br>
    <button type="submit">Créer le tournoi</button>
</form>


</body>
</html>
