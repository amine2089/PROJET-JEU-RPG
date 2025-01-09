package GAME;

import java.util.Random;
import java.util.Scanner;


public class Play02 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        //Les Personnages
	        Personnage guerrier = new Guerrier("Thor");
	        Personnage mage = new Mage("Gandalf");
	        Personnage voleur = new Voleur("Loki");
	        Personnage Beast = new Beast("Chimera");
	        Personnage Robot = new Robot("Optimus Prime");
	        Personnage chevalier= new Chevalier("Alexander");
	        
	        
	        int choix;
	        
	        // Choix du personnage par le joueur

	        System.out.println("Choisissez votre personnage :");
	        System.out.println("1. Guerrier");
	        System.out.println("2. Mage");
	        System.out.println("3. Voleur");
	        System.out.println("4. Beast");
	        System.out.println("5. Robot");
	        System.out.println("6. chevalier");
	         choix = scanner.nextInt();
	        
	         Personnage joueur;
	        switch (choix) {
	            case 1:
	                joueur = guerrier;
	                break;
	            case 2:
	                joueur = mage;
	                break;
	            case 3:
	            	 joueur = voleur;
	                break;
	            case 4:
	            	joueur = Beast;
	            	break;
	            case 5:
	            	joueur = Robot;
	            	break;
	            case 6:
	            	joueur= chevalier;
	            	break;
	            default:
	                System.out.println("Choix invalide. Le guerrier est sélectionné par défaut.");
	                joueur = guerrier;
	                break;
	        }

	     
	        // Boucle de combat
	        while ( joueur.estVivant() &&( guerrier.estVivant() || mage.estVivant() || voleur.estVivant() || Beast.estVivant() || Robot.estVivant() || chevalier.estVivant())) {
	            System.out.println("\n--- Tour de combat ---");
	            System.out.println("Choisissez une action :");
	            System.out.println("1. Attaquer un adversaire");
	            System.out.println("2. Utiliser compétence spéciale");
	            System.out.println("3. Gagner des points de vie");
	            System.out.println("4. Passer son tour");

	            int action = scanner.nextInt();

	            // Actions du joueur
	            switch (action) {
	                case 1:
	                	System.out.println("Choisissez un adversaire :");
	                    if(joueur != guerrier && guerrier.estVivant()) {
	                    	
	                    	System.out.println("1. " + (guerrier.estVivant() ? guerrier.getNom() : "Thor est vaincu"));
	                    }
	                	if(joueur != mage && mage.estVivant()) {
	                        
	                	    System.out.println("2. " + (mage.estVivant() ? mage.getNom() : "Gandalf est vaincu"));
	                    }
	                    if(joueur != voleur && voleur.estVivant()) {
	                   
	                    	System.out.println("3. " + (voleur.estVivant() ? voleur.getNom() : "Loki est vaincu"));
	                    }
	                    if(joueur != Beast && Beast.estVivant()) {
	                       
	                    	System.out.println("4. " + (Beast.estVivant() ? Beast.getNom() : "Chimera est vaincu"));
	                    }
	                    if(joueur != Robot && Robot.estVivant()) {
	                    	System.out.println("5. " + (Robot.estVivant() ? Robot.getNom() : "Optimus Prime est vaincu"));
	                    }
	                    if(joueur != chevalier && chevalier.estVivant()) {
	                    	
	                    	System.out.println("6. "+(chevalier.estVivant() ? chevalier.getNom() : "alexander est vaincu"));
	                    }
	                    int cible = scanner.nextInt();
                        if(cible == 1 && joueur !=guerrier && guerrier.estVivant()) {
                        	
                        	joueur.attaquer(guerrier);
                        	System.out.println(guerrier.getNom()+" : "+guerrier.pointsDeVie+" HP ");
                        }
	                    else if (cible == 2 && joueur !=mage && mage.estVivant()) {
	                        
	                    	joueur.attaquer(mage);
	                    	System.out.println(mage.getNom()+" : "+mage.pointsDeVie+" HP ");
	                    	
	                    } else if (cible == 3 && joueur !=voleur && voleur.estVivant()) {
	                        
	                    	joueur.attaquer(voleur);
	                    	System.out.println(voleur.getNom()+" : "+voleur.pointsDeVie+" HP ");
	                    	
	                    } else if(cible == 4 && joueur !=Beast && Beast.estVivant()){
	                    
	                    	joueur.attaquer(Beast);
	                    	System.out.println(Beast.getNom()+" : "+Beast.pointsDeVie+" HP ");
	                    	
	                    }else if(cible == 5 && joueur !=Robot && Robot.estVivant()) {
	                    
	                    	joueur.attaquer(Robot);
	                    	System.out.println(Robot.getNom()+" : "+Robot.pointsDeVie+" HP ");
	                    	
	                    }else if(cible == 6 && joueur !=chevalier && chevalier.estVivant()){
	                    
	                    	joueur.attaquer(chevalier);
	                    	System.out.println(chevalier.getNom()+" : "+chevalier.pointsDeVie+" HP ");
	                    	
	                    }else {
	                        
	                    	System.out.println("Cible invalide.");
	                    
	                    }
	                    break;

	                case 2:
	                    
	                	System.out.println("Choisissez un adversaire :");
	                   
	                	if(joueur != guerrier && guerrier.estVivant()) {
	                	 
	                		System.out.println("1. " + (guerrier.estVivant() ? guerrier.getNom() : "Thor est vaincu"));
	                   }
	                   
	                	if(joueur !=mage && mage.estVivant() ) {
	                    
	                		System.out.println("2. " + (mage.estVivant() ? mage.getNom() : "Gandalf est vaincu"));
	                   }
                        
	                	if(joueur !=voleur && voleur.estVivant()) {
	                    
	                		System.out.println("3. " + (voleur.estVivant() ? voleur.getNom() : "Loki est vaincu"));
                        }
                        if(joueur !=Beast && Beast.estVivant()) {
	                   
                        	System.out.println("4. " + (Beast.estVivant() ? Beast.getNom() : "Chimera est vaincu"));
                        }
                        if(joueur !=Robot && Robot.estVivant()) {
    	                    
                        	System.out.println("5. " + (Robot.estVivant() ? Robot.getNom() : "Optimus Prime est vaincu"));
                            }
                        
                        if(joueur !=chevalier && chevalier.estVivant()) {
    	                  
                        	System.out.println("6. " + (chevalier.estVivant() ? chevalier.getNom() : "Alexander est vaincu"));
                            }
                        
                        
                        cible = scanner.nextInt();
                        
                        if(cible == 1 && joueur !=guerrier && guerrier.estVivant()) {
                        
                        	joueur.utiliserCompetence(guerrier);
                        	System.out.println(guerrier.getNom()+" : "+guerrier.pointsDeVie+" HP ");
                        }
	                    
                        else if (cible == 2 && joueur != mage && mage.estVivant()) {
	                        
                        	joueur.utiliserCompetence(mage);
                        	System.out.println(mage.getNom()+" : "+mage.pointsDeVie+" HP ");
                        	
	                    } else if (cible == 3 && joueur != voleur && voleur.estVivant()) {
	                        
	                    	joueur.utiliserCompetence(voleur);
	                    	System.out.println(voleur.getNom()+" : "+voleur.pointsDeVie+" HP ");
	                    
	                    } else if (cible == 4 && joueur != Beast && Beast.estVivant()){
	                    	
	                    	joueur.utiliserCompetence(Beast);
	                    	System.out.println(Beast.getNom()+" : "+Beast.pointsDeVie+" HP ");
	                    	
	                    }else if(cible == 5 && joueur != Robot && Robot.estVivant()) {
	                    	
	                    	joueur.utiliserCompetence(Robot);
	                    	System.out.println(Robot.getNom()+" : "+Robot.pointsDeVie+" HP ");
	                    
	                    }else if(cible == 6 && joueur != chevalier && chevalier.estVivant()){
	                    	
	                    	joueur.utiliserCompetence(chevalier);
	                    	System.out.println(chevalier.getNom()+" : "+chevalier.pointsDeVie+" HP ");
	                    	
	                    }else {
	                        
	                    	System.out.println("Cible invalide.");
	                    }
	                    break;
	                case 3:
	                	
	                	int HP=joueur.pointsDeVie;
	                	
	                	System.out.println(joueur.getNom()+"Gagne des points de vie");
	                	
	                	joueur.gagnerpointsdevie(25);
	                	System.out.println(joueur.pointsDeVie+" HP ");
	                	break;
	                case 4:
	                    System.out.println(joueur.getNom() + " passe son tour.");
	                    break;

	                default:
	                    System.out.println("Action invalide.");
	                    break;
	            }
	            
	            

	            // Actions des adversaires
	            
	          //vecteur d'adversaire
	            
	        Personnage [] adversaire= { guerrier,mage,voleur,Beast,Robot,chevalier};
	        
	        for(Personnage cible : adversaire) {
	        	if(cible.estVivant() && cible != joueur) {
	        		 int actionAdversaire = new Random().nextInt(4);
	        		 switch(actionAdversaire) {
	        case 1:
	        			 Personnage Target= selectRandomTarget(cible,guerrier,mage,voleur,Beast,Robot,chevalier,joueur);
	        			 if(Target!=null) {
	 	        			
	 	        			cible.attaquer(Target);
	 	        			System.out.println(Target.pointsDeVie+" HP ");
	 	        			
	 	        			if(!Target.estVivant()) {
	 	        				System.out.println(Target.getNom()+" est vaincu !");
	 	        			break;
	 	        			}
	 	        		}
	        		
	        case 2:
	        	Personnage Target2= selectRandomTarget(cible,guerrier,mage,voleur,Beast,Robot,chevalier,joueur);
	        		 
	        	if(Target2!=null) {
	        		
	        		cible.utiliserCompetence(Target2);
	        		System.out.print(Target2.pointsDeVie+" HP ");
	        		if(Target2.estVivant()) {
	        			System.out.print(Target2.getNom()+" est vaincu !");
	        		}}
	        				
	        	break;	 
	        case 3:
                System.out.println(cible.getNom() + " utilise une potion de soin !");
                cible.gagnerpointsdevie(20); // Heals 20 points of health (adjust as needed)
                System.out.println(cible.getNom() + " a maintenant " + cible.pointsDeVie + " HP.");
                break;

	        	}
	        		
	        	}
	        	
	        	
	        }
	            
	        
	        }
	        
	        scanner.close();
	        System.out.println("Le combat est terminé !");
	  
	        if(joueur.estVivant()) {
	        	System.out.println("Vous avez Gagné !");
	        }else {
	        	System.out.println("Vous avez Perdu !");
	        }
	}
	       
	//une methode pour distinguer l'adversaire
	  private static Personnage selectRandomTarget(Personnage current, Personnage guerrier, Personnage mage, Personnage voleur, Personnage Beast, Personnage Robot,Personnage chevalier, Personnage joueur) {
	        Random random = new Random();
	        while (true) {
	            int TheTarget = random.nextInt(7); 
	            Personnage potentialTarget = null;

	            
	            switch (TheTarget) {
	                case 0: potentialTarget = guerrier; break;
	                case 1: potentialTarget = mage; break;
	                case 2: potentialTarget = voleur; break;
	                case 3: potentialTarget = Beast; break;
	                case 4: potentialTarget = Robot; break;
	                case 5: potentialTarget = chevalier; break;
	                case 6: potentialTarget = joueur; break;
	            }

	            
	            if (potentialTarget != null && potentialTarget != current && potentialTarget.estVivant()) {
	                return potentialTarget;
	            }
	        }
	 }
	 
	
}


