package com.fstt.model;

public class Produit {

	private int id_produit;
	private String nom_produit;
	private int prix_produit;
	
	public Produit() {
		// TODO Auto-generated constructor stub
	}

	
	public Produit(int id_produit, String nom_produit, int prix_produit) {
		super();
		this.id_produit = id_produit;
		this.nom_produit = nom_produit;
		this.prix_produit = prix_produit;
	}


	public int getId_produit() {
		return id_produit;
	}


	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}


	public String getNom_produit() {
		return nom_produit;
	}


	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}


	public int getPrix_produit() {
		return prix_produit;
	}


	public void setPrix_produit(int prix_produit) {
		this.prix_produit = prix_produit;
	}
	
}
