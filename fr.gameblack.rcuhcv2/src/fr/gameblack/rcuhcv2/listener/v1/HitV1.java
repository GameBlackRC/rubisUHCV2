package fr.gameblack.rcuhcv2.listener.v1;

import java.util.Random;

import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.Pouvoirs_GB;
import fr.gameblack.rcuhcv2.roles.v1.rc.GameBlackV1;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class HitV1 {
	
	public static void whenHit(Joueur joueur, Joueur tueur, Main main) {
		
		Random r = new Random();
        int nb;
        
        if(joueur.getRole() == Roles.Ange) {
        	
        	nb = r.nextInt(100);
        	
        	if(nb <= 25) {
        		
        		joueur.addPoint();
        		
        	}
        	
        }
        
        if(tueur.getRole() == Roles.Farmeurimmo && tueur.isJeannotAbso()) {
        	
        	if(joueur.getPlayer().hasPotionEffect(PotionEffectType.ABSORPTION)) joueur.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
        	
        }
        
        if(tueur.getRole() == Roles.Experimental) {
        	
        	nb = r.nextInt(100);
        	
        	if(nb <= 2) {
        		
        		joueur.Stun(4, main);
        		
        	}
        	
        }
        
        if(joueur.getRole() == Roles.GameBlack && joueur.getPouvoirGB() == Pouvoirs_GB.INVISIBLE && joueur.isInvisible()) {
        	
        	GameBlackV1.DesactInvi(joueur, main);
        	
        }
        
        if(joueur.getRole() == Roles.GameBlack && joueur.getPouvoirGB() == Pouvoirs_GB.SPEED) {
        	
        	nb = r.nextInt(100);
        	
        	if(nb <= 10) {
        		
        		joueur.addSpeed(0.01);
        		
        	}
        	
        }
		
        if (tueur.getRole() == Roles.Joko && tueur.isJokoItemActif()) {

            if (joueur.getCube() != 0 && !main.getJokoStun().contains(joueur)) {

                nb = r.nextInt(100);
                int pourcent = joueur.getCube() * 2;

                if (nb < pourcent + 1) {

                    joueur.Stun(10, main);
                    joueur.removeCube(main);
                    main.getJokoStun().add(joueur);

                    tueur.getPlayer().sendMessage("Vous venez de stun " + joueur.getPlayer().getName());

                    ItemCD cycle = new ItemCD(main, tueur, "stun", 10, joueur, null, null, 0, null);
                    cycle.runTaskTimer(main, 0, 20);

                }

            }

        }
		
	}

}
