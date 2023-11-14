package fr.gameblack.rcuhcv2.evenement.v1;

import java.util.Random;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

public class TueurNeko {
	
	public static void setTueur(Main main) {
		
		if(main.getCampDemonVie().size() != 0) {
		
			Random r = new Random();
	        int nb = r.nextInt(main.getCampDemonVie().size()-1);
	        
	        Joueur tueur = main.getCampDemonVie().get(nb);
	        tueur.getPlayer().sendMessage("Vous êtes le tueur de neko ! Vous recevez 2% de force, de résistance et de speed");
	        tueur.addForce(0.02);
	        tueur.addResi(0.02);
	        tueur.addSpeed(0.02);
	        
		}
		
	}

}
