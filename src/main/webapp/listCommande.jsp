<%@page import="com.fstt.model.Commande"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Liste des Commandes</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" >Gestion Commandes</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gestion produit
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/Client-commande-produit/ControllerProduitServlet?action=addProduit">Ajouter produit</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/Client-commande-produit/ControllerProduitServlet?action=list">List des produis</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gestion Client
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/Client-commande-produit/ControllerClientServlet?action=addClient">Ajouter Client</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/Client-commande-produit/ControllerClientServlet?action=list">List des Clients</a>
        </div>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gestion Commandes
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/Client-commande-produit/ControllerCommandeServlet?action=addCommande">Ajouter Commande</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/Client-commande-produit/ControllerCommandeServlet?action=list">List des commandes</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
	<table class="table">
		<th scope="col">Id Commande</th>
		<th scope="col">Id Client</th>
		<th scope="col"></th>
		<% List<Commande> list = (List<Commande>) request.getAttribute("listcom"); 
		
		for(int i = 0 ; i <list.size() ; i++){ %>

		<tr>
			<td><%= list.get(i).getId_commande()  %> </td>


			<td><%= list.get(i).getClient().getId_client() %>  </td>

			<td> <a class="btn btn-danger" href="ControllerCommandeServlet?action=delete&id=<%= list.get(i).getId_commande() %>"> Supprimer</a> </td>

		</tr>

<%  } %>


</table>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>