package fr.gameblack.rcuhcv2.orbes.v1;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;

public class Foudre {

    public static void Effets(Joueur joueur, Main main) {

    	joueur.addForce(0.01);
    	joueur.addSpeed(0.06);
    	joueur.setStatutOrbe(true);

    }

    public static void RemoveEffets(Joueur joueur, Main main) {

        joueur.setStatutOrbe(false);
        joueur.removeForce(0.01);
    	joueur.removeSpeed(0.06);

    }

    public static void Malus(Joueur joueur, Main main) {
    	
        if(joueur.isOrbeActif() && joueur.getCamp() != Camps.SOLOS) {
    	
	    	RemoveEffets(joueur, main);
	    	joueur.removeSpeed(0.05);
	    	joueur.setMalusOrbe(true);
		    ItemCD cycle = new ItemCD(main, joueur, "foudre_malus", 60, joueur, null, null, 0, null);
		    cycle.runTaskTimer(main, 0, 20);
		    
    	}

    }

}