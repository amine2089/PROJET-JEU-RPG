package GAME;

import java.util.Random;

public class Voleur extends Personnage{
	 public Voleur(String nom) {
	        super(nom, 70, 12,40);
	    }

	    @Override
	    public void attaquer(Personnage cible) {
	        System.out.println(nom + " attaque furtivement " + cible.getNom() + " !");
	        cible.recevoirDegats(degats);
	        // Chance d'une attaque critique
	        if (Math.random() < 0.2) {
	            System.out.println(nom + " inflige un coup critique !");
	            cible.recevoirDegats(degats);
	        }
	    }

	    @Override
	    public void utiliserCompetence(Personnage cible) {
	        System.out.println(nom + " utilise sa compétence spéciale : Attaque rapide !");
	        cible.recevoirDegats(degats * 3);
	    }

		@Override
		public void gagnerpointsdevie(int HP) {
			System.out.println(nom+"exploite son agilité et son instinct pour se régénérer furtivement, récupérant ses forces dans l'ombre !");
			this.pointsDeVie+=HP;
		}
}
