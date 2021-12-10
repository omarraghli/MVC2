package com.fstt.model;

public class Client {
	private int id_client;
	private String nom;
	private String prenom;
	private int age;
	
	public Client(int id_client, String nom, String prenom, int age) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	public Client() {
		
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
