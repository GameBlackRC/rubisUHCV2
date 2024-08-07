package fr.gameblack.rcuhcv2.orbes.v2;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Stats;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Feu {

	public static void Passif(Joueur joueur, Main main, boolean give) {
    	
    	if(give) {
    		
    		joueur.setOrbePassifActif(true);
	        
    	}
    	else {
    		
    		joueur.setOrbePassifActif(false);
    		if(joueur.isOrbeActif())
    		joueur.setStatutOrbe(false);
    		
    	}

    }
	
	public static void Active(Joueur joueur, boolean give) {
		
		if(give) {
			
			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()+2);
			
		}
		else if(joueur.isOrbeActif()) {
			
			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-2);
			
		}
		
	}

    public static void Bonus(Joueur joueur, Main main, boolean give) {
    	
    	if(give) {
    		
    		if(joueur.canHaveMalusBonusOrbe() && joueur.isOrbeActif()) {
    			
    			main.addStat(Stats.BONUS_ORBE, joueur);
    		
    			joueur.getPlayer().sendMessage("Le bonus de votre orbe vient de s'activer");
	    		joueur.addForce(0.01);
	    		joueur.setCanHaveMalusBonusOrbe(false);
	    		joueur.setBonusOrbe(true);
	    		ItemCD cycle = new ItemCD(main, joueur, "feu_bonus", 120, joueur, null, null, 0, null);
		        cycle.runTaskTimer(main, 0, 20);
		        
    		}
    		
    	}
    	else {
    		
    		joueur.getPlayer().sendMessage("Le bonus de votre orbe est désormais terminé");
    		joueur.setBonusOrbe(false);
    		joueur.removeForce(0.01);
    		
    	}

    }

    public static void Malus(Joueur joueur, Main main, boolean give) {
    	
    	if(give) {
    		
    		if(joueur.canHaveMalusBonusOrbe() && joueur.isOrbeActif()) {
    			
    			main.addStat(Stats.MALUS_ORBE, joueur);
    			
    			joueur.getPlayer().sendMessage("Le malus de votre orbe vient de s'activer");
	    		joueur.setCanHaveMalusBonusOrbe(false);
	    		joueur.setMalusOrbe(true);
	    		ItemCD cycle = new ItemCD(main, joueur, "feu_malus", 120, joueur, null, null, 0, null);
		        cycle.runTaskTimer(main, 0, 20);
		        
    		}
    		
    	}
    	else {
    		
    		joueur.setMalusOrbe(false);
    		joueur.getPlayer().sendMessage("Le malus de votre orbe est désormais terminé");
    		
    		if(!joueur.isOrbePassifActif()) {
    			
    			Passif(joueur, main, true);
    			
    		}
    		
    	}

    }

}