package com.fstt.model;

public class HasManyCommandeProduit {
	private int id_commandeproduit;
	private Commande cmnd;
	private Produit prod;

	public HasManyCommandeProduit() {
		
	}

	public HasManyCommandeProduit(int id_commandeproduit, Commande cmnd, Produit prod) {
		super();
		this.id_commandeproduit = id_commandeproduit;
		this.cmnd = cmnd;
		this.prod = prod;
	}

	public int getId_commandeproduit() {
		return id_commandeproduit;
	}

	public void setId_commandeproduit(int id_commandeproduit) {
		this.id_commandeproduit = id_commandeproduit;
	}

	public Commande getCmnd() {
		return cmnd;
	}

	public void setCmnd(Commande cmnd) {
		this.cmnd = cmnd;
	}

	public Produit getProd() {
		return prod;
	}

	public void setProd(Produit prod) {
		this.prod = prod;
	}

	
	

}
