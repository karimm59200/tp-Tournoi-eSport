<%--
  Created by IntelliJ IDEA.
  User: karim
  Date: 18/06/2023
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello depuis le formulaire de creation joueurs</h1>
<form action="Joueurs" method="post">
    <label for="nomUtil">nom utilisateur</label>
    <input  style="margin-bottom: 10px" type="text" name="nomUtilisateur" id="nomUtil">
<br>
    <label for="jeuSpe"> Spécialité jeu</label>
    <input type="text" name="jeuSpecialite" id="jeuSpe">

    <input type="submit" value="envoyer">
</form>
</body>
</html>
