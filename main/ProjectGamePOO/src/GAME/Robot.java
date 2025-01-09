package GAME;

public class Robot extends Personnage{
	
public Robot(String nom) {
	super(nom,90,40,100);
}

@Override
public void attaquer(Personnage cible) {

	 System.out.println(nom + " Déclenche Frappe Mécatronique sur  " + cible.getNom() + " !");
	 cible.recevoirDegats(degats + cible.défense);
}

@Override
public void utiliserCompetence(Personnage cible) {
	
	 System.out.println(nom + " Active Rayon Plasma Surpuissant !");
	 cible.recevoirDegats(degats*3);
}

@Override
public void gagnerpointsdevie(int HP) {
	System.out.println(nom+"active son module d'auto-réparation, restaurant ses systèmes et optimisant ses performances pour le combat !");
	this.pointsDeVie+=2*HP;
	
}
  
}
