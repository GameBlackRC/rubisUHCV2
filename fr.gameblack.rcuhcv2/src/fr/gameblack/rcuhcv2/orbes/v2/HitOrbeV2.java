package fr.gameblack.rcuhcv2.orbes.v2;

import java.util.Random;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.orbes.Orbe;

public class HitOrbeV2 {
	
	public static void whenHit(Joueur joueur, Joueur tueur, Main main) {
		
		if(joueur.isOrbeActif()) {
        	
        	Random r = new Random();
            int nb = r.nextInt(100);
        	
        	//BONUS
        	if(joueur.getOrbe() == Orbe.EAU && tueur.getOrbe() == Orbe.FEU) {
                
                if(nb <= 10) {
                	
                	Eau.Bonus(joueur, main, true);
                	
                }
        		
        	}
        	else if(joueur.getOrbe() == Orbe.FEU && tueur.getOrbe() == Orbe.GLACE) {
                
                if(nb <= 10) {
            	
                	Feu.Bonus(joueur, main, true);
                	
                }
        		
        	}
        	else if(joueur.getOrbe() == Orbe.GLACE && tueur.getOrbe() == Orbe.FOUDRE) {
                
                if(nb <= 10) {
            	
                	Glace.Bonus(joueur, main, true);
                	
                }
        		
        	}
        	else if(joueur.getOrbe() == Orbe.FOUDRE && tueur.getOrbe() == Orbe.EAU) {
                
                if(nb <= 10) {
            	
                	Foudre.Bonus(joueur, main, true);
                	
                }
        		
        	}
        	
        	//MALUS
        	if(joueur.getOrbe() == Orbe.EAU && tueur.getOrbe() == Orbe.FOUDRE) {
                
                if(nb <= 10) {
                	
                	nb = r.nextInt(100);
            	
                	if((joueur.getRole() != Roles.GAMEBLACK || nb > 50 || joueur.getCampGB().equalsIgnoreCase("staff")) && (joueur.getRole() != Roles.FARMEURIMMO || !joueur.getVol().contains(Pouvoirs.GAMEBLACK_MALUS_ORBE))) {
                    	
                		Eau.Malus(joueur, main, false);
                	
                	}
                	
                }
        		
        	}
        	else if(joueur.getOrbe() == Orbe.FEU && tueur.getOrbe() == Orbe.EAU) {
                
                if(nb <= 10) {
                	
                	nb = r.nextInt(100);
            	
                	if((joueur.getRole() != Roles.GAMEBLACK || nb > 50 || joueur.getCampGB().equalsIgnoreCase("staff")) && (joueur.getRole() != Roles.FARMEURIMMO || !joueur.getVol().contains(Pouvoirs.GAMEBLACK_MALUS_ORBE))) {
                    	
                		Feu.Malus(joueur, main, false);
                	
                	}
                	
                }
        		
        	}
        	else if(joueur.getOrbe() == Orbe.GLACE && tueur.getOrbe() == Orbe.FEU) {
                
                if(nb <= 10) {
            	
                	nb = r.nextInt(100);
                	
                	if((joueur.getRole() != Roles.GAMEBLACK || nb > 50 || joueur.getCampGB().equalsIgnoreCase("staff")) && (joueur.getRole() != Roles.FARMEURIMMO || !joueur.getVol().contains(Pouvoirs.GAMEBLACK_MALUS_ORBE))) {
                    	
                		Glace.Malus(joueur, main, false);
                	
                	}
                	
                }
        		
        	}
        	else if(joueur.getOrbe() == Orbe.FOUDRE && tueur.getOrbe() == Orbe.GLACE) {
                
                if(nb <= 10) {
            	
                	nb = r.nextInt(100);
                	
                	if((joueur.getRole() != Roles.GAMEBLACK || nb > 50 || joueur.getCampGB().equalsIgnoreCase("staff")) && (joueur.getRole() != Roles.FARMEURIMMO || !joueur.getVol().contains(Pouvoirs.GAMEBLACK_MALUS_ORBE))) {
                    	
                		Foudre.Malus(joueur, main, false);
                	
                	}
                	
                }
        		
        	}
        	
        }
        
        if(tueur.getOrbe() == Orbe.FEU) {
        	
        	Random r = new Random();
            int nb = r.nextInt(100);
            
            if((tueur.isOrbePassifActif() && nb <= 5 && tueur.isMalusOrbeActif()) || (tueur.isOrbePassifActif() && nb <= 10 && !tueur.isMalusOrbeActif())) {
        	
            	joueur.getPlayer().setFireTicks(100);
            	
            }
        	
        }
        
        if(tueur.getOrbe() == Orbe.GLACE && tueur.isOrbePassifActif()) {
        	
        	Glace.Freeze(joueur.getPlayer());
        	
        }
		
	}

}
