package fr.gameblack.rcuhcv2.orbes;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class Foudre {

	public static void Passif(Joueur joueur, Main main, boolean give) {
    	
    	if(give) {
    		
    		joueur.setOrbePassifActif(true);
    		joueur.addSpeed(0.05);
	        
    	}
    	else {
    		
    		joueur.setOrbePassifActif(false);
    		joueur.removeSpeed(0.05);
    		joueur.setStatutOrbe(false);
    		
    	}

    }

    public static void Bonus(Joueur joueur, Main main, boolean give) {
    	
    	if(give) {
    		
    		if(joueur.canHaveMalusBonusOrbe() && joueur.isOrbeActif()) {
    		
    			joueur.getPlayer().sendMessage("Le bonus de votre orbe vient de s'activer");
	    		joueur.addSpeed(0.05);
	    		joueur.setCanHaveMalusBonusOrbe(false);
	    		joueur.setBonusOrbe(true);
	    		ItemCD cycle = new ItemCD(main, joueur, "foudre_bonus", 120, joueur, null, null, null, null);
		        cycle.runTaskTimer(main, 0, 20);
		        
    		}
    		
    	}
    	else {
    		
    		joueur.getPlayer().sendMessage("Le bonus de votre orbe est désormais terminé");
    		joueur.setBonusOrbe(false);
    		joueur.removeSpeed(0.05);
    		
    	}

    }

    public static void Malus(Joueur joueur, Main main, boolean give) {
    	
    	if(give) {
    		
    		if(joueur.canHaveMalusBonusOrbe() && joueur.isOrbeActif()) {
    		
    			joueur.getPlayer().sendMessage("Le malus de votre orbe vient de s'activer");
	    		joueur.removeForce(0.01);
	    		joueur.setCanHaveMalusBonusOrbe(false);
	    		joueur.setMalusOrbe(true);
	    		ItemCD cycle = new ItemCD(main, joueur, "foudre_malus", 120, joueur, null, null, null, null);
		        cycle.runTaskTimer(main, 0, 20);
		        
    		}
    		
    	}
    	else {
    		
    		joueur.setMalusOrbe(false);
    		joueur.addForce(0.01);
    		joueur.getPlayer().sendMessage("Le malus de votre orbe est désormais terminé");
    		
    		if(!joueur.isOrbePassifActif()) {
    			
    			Passif(joueur, main, true);
    			
    		}
    		
    	}

    }

}