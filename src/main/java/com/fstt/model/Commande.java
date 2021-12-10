package com.fstt.model;

public class Commande {
	private int id_commande;
	private Client client;
	
	public Commande() {
		// TODO Auto-generated constructor stub
	}
	public Commande(int id_commande, Client client) {
		super();
		this.id_commande = id_commande;
		this.client = client;
	}

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
