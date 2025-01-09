package GAME;

import java.util.Random;

public abstract class Personnage implements Attaquable{

	protected String nom;
	protected int pointsDeVie;
	protected int degats; // Dégâts de base
	protected int défense; //défense de base
	protected int niveau;
	protected int experience;

	public Personnage(String nom, int pointsDeVie, int degats, int défense) {
		this.nom = nom;
		this.pointsDeVie = pointsDeVie;
		this.degats = degats;
		this.défense=défense;
		this.niveau = 1;
		this.experience = 0;
	}

	public void recevoirDegats(int degats) {
		défense -= degats;
		if(défense <= 0) {
		pointsDeVie -= degats;
		System.out.println(nom + " a reçu " + degats + " points de dégâts. Points de vie restants : " + pointsDeVie);
		}
	}

	public boolean estVivant() {
		return pointsDeVie > 0;
	}

	public String getNom() {
		return nom;
	}

	public void setPointsDeVie(int pointsDeVie) {
	    this.pointsDeVie = pointsDeVie;
	}
	
	public void gagnerExperience(int xp) {
		experience += xp;
		if (experience >= 100) {
			niveau++;
			experience = 0;
			System.out.println(nom + " a atteint le niveau " + niveau + " !");
		}
	}
	
	
	
}
