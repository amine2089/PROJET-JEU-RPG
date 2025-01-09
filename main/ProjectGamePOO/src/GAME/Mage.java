package GAME;

public class Mage extends Personnage {
	public Mage(String nom) {
        super(nom, 80, 15,20);
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " lance un sort sur " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " invoque une tempête magique !");
        cible.recevoirDegats(degats + 10);
    }

	@Override
	public void gagnerpointsdevie(int HP) {
		System.out.println(nom+"canalise l'énergie mystique, régénérant sa vitalité grâce à une aura de pouvoir arcane !");
		this.pointsDeVie+=5*HP;
		
	}
	
	
}
