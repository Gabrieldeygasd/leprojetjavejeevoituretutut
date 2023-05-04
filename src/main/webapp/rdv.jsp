<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prendre un rendez-vous</title>
</head>
<body>
<h1>Prendre un rendez-vous</h1>

<a href="./">Accueil</a>

<form method="post" action="appointment">

    <label for="mechanicName">Nom du mécanicien :</label>
    <input type="text" name="mechanicName" id="mechanicName" required><br>

    <label for="appointmentDate">Date et heure du rendez-vous :</label>
    <input type="datetime-local" name="appointmentDate" id="appointmentDate" required><br>

    <input type="submit" value="Prendre rendez-vous">
</form>
</body>
</html>