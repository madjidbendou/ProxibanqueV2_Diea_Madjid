<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><link rel ="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form  method= "post" action="ClientCree">
Nom : <input type="text" placeholder="nom" name="nom"/>
Prenom : <input type= "text" placeholder="prenom" name="prenom"/>
Email : <input type= "text" placeholder="email" name="email"/>
Adresse : <input type= "text" placeholder="adresse" name="adresse"/>
Solde ($): <input type= "number"placeholder="00.0 $" name="solde"/>
<input  type= "submit"  value="valider"> 
</form>


</body>
</html>