<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Créer un compte</title>
</head>
<body>
<h1>Créer un compte client</h1>
<form method="post" action="createuser.jsp">
    <label for="firstName">Prénom :</label>
    <input type="text" id="firstName" name="firstName"><br>
    <label for="lastName">Nom :</label>
    <input type="text" id="lastName" name="lastName"><br>
    <label for="email">Adresse e-mail :</label>
    <input type="email" id="email" name="email"><br>
    <label for="address">Adresse :</label>
    <textarea id="address" name="address"></textarea><br>
    <input type="submit" value="Créer un compte">
</form>
</body>
</html>