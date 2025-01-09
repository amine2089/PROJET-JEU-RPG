package GAME;

public class Chevalier extends Personnage{
	public Chevalier(String nom) {
		super(nom,90,75,40);
	}

	@Override
	public void attaquer(Personnage cible) {
		
		System.out.println(nom + " Invoque la Lance du Destin " + cible.getNom() + " !");
		 
		cible.recevoirDegats(degats);
	}

	@Override
	public void utiliserCompetence(Personnage cible) {
		System.out.println(nom + " Invoque le Coup de Tonnerre " + cible.getNom() + " !");
		cible.recevoirDegats(degats + cible.degats);
	}

	@Override
	public void gagnerpointsdevie(int HP) {
		System.out.println("Active la guérison divine pour régénérer");
		this.pointsDeVie+=HP+50;
		
	}

}
