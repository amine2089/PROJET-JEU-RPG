package GAME;

import java.util.Scanner;


public class Play {

	public static void main(String[] args) {
		
		        Scanner scanner = new Scanner(System.in);
		        
		        Personnage guerrier = new Guerrier("Thor");
		        Personnage mage = new Mage("Gandalf");
		        Personnage voleur = new Voleur("Loki");
		        Personnage Beast = new Beast("Chimera");
		        Personnage Robot= new Robot("Optimus Prime");
		        while (guerrier.estVivant() && mage.estVivant() && voleur.estVivant() && Beast.estVivant() && Robot.estVivant()) {
		            System.out.println("\n--- Tour de combat ---");
		            guerrier.attaquer(mage);
		            mage.gagnerExperience(10);
		            if (!mage.estVivant()) {
		                System.out.println(mage.getNom() + " est vaincu !");
		                break;
		            }

		            mage.attaquer(guerrier);
		            guerrier.gagnerExperience(10);
		            if (!guerrier.estVivant()) {
		                System.out.println(guerrier.getNom() + " est vaincu !");
		                break;
		            }

		            voleur.attaquer(mage);
		            voleur.gagnerExperience(10);
		            if (!mage.estVivant()) {
		                System.out.println(mage.getNom() + " est vaincu !");
		                break;
		            }

		            voleur.utiliserCompetence(guerrier);
		            if (!guerrier.estVivant()) {
		                System.out.println(guerrier.getNom() + " est vaincu !");
		                break;
		            }
		        Beast.attaquer(voleur);
		        Beast.gagnerExperience(10);
		        if(!voleur.estVivant()) {
		        	 System.out.println(voleur.getNom() + " est vaincu !");
		                break;
		        	
		        }
		        
		        
		        }
		        
		        scanner.close();
		    }

	}


