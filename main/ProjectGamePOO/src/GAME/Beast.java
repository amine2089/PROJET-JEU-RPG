package GAME;



public class Beast extends Personnage{
   int Strike;
  
    public Beast(String nom) {
	        super(nom, 40, 75,75);
	        }

 @Override
	 public void attaquer(Personnage cible) {
 
		 System.out.println(nom + " Lance  Morsure Sauvage sur  " + cible.getNom() + " !");
		 cible.recevoirDegats(degats * 2);
	 }
 
 @Override
public void utiliserCompetence(Personnage cible) {
	
	 System.out.println(nom + " utilise sa compétence spéciale : Hurlement Ancestral !");
	 cible.recevoirDegats(degats * 5);
}

@Override
public void gagnerpointsdevie(int HP) {
	System.out.println(nom+"canalise sa force primitive, retrouvant une énergie féroce qui la rend plus redoutable que jamais !");
	this.pointsDeVie+=HP;
	
}
  

}
