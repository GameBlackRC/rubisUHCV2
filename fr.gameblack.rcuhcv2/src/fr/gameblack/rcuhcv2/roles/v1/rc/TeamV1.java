package fr.gameblack.rcuhcv2.roles.v1.rc;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

import java.util.Random;

public class TeamV1 {

    public static void Items(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));

        Random r = new Random();
        int nb = r.nextInt(2);
        if (nb == 1) {

            main.setConnaissanceTeam(Roles.GameBlack);

        } else {

            main.setConnaissanceTeam(Roles.Maka);

        }
        Texte(player, nb);

    }

    public static void Texte(Player player, int nb) {

        String connaissance;

        if (nb == 1) {

            connaissance = "GameBlack";

        } else {

            connaissance = "Maka";

        }

        player.sendMessage("____________________________________________________\n \nVous êtes §aTeam\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet speed I permanent\n \nA chaque mort d'un joueur de votre camps, vous recevez le rôle ou le pseudo du joueur l'ayant tuer\n \nVous connaissez " + connaissance + "\n \n____________________________________________________");

    }
    
    public static void effetConnaissance(Main main) {
    	
    	if (main.getConnaissanceTeam() == Roles.Maka) {

            Joueur maka = main.getJoueurByRole(Roles.Maka);
            Joueur team = main.getJoueurByRole(Roles.Team);

            for (Entity nearbyEntities : maka.getPlayer().getNearbyEntities(20, 20, 20)) {

                if (nearbyEntities instanceof Player && (Player) nearbyEntities == team && !maka.isForceProche()) {

                    maka.setForceProche(true);
                    maka.addForce(0.15);

                } else if (maka.isForceProche()) {

                	maka.setForceProche(false);
                	maka.removeForce(0.15);

                }

            }

        }
    	else {
    		
    		if(main.getJoueurByRole(Roles.GameBlack) != null && main.getJoueurByRole(Roles.Team) != null) {
    			
                Joueur team = main.getJoueurByRole(Roles.Team);
                
                if(team.isProche(Roles.GameBlack, main) && !team.isResiProche()) {
                	
                	team.addResi(main.getResiIBaseV1());
                	team.setResiProche(true);
                	
                }
                else if(!team.isProche(Roles.GameBlack, main) && team.isResiProche()) {
                	
                	team.removeResi(main.getResiIBaseV1());
                	team.setResiProche(false);
                	
                }
    			
    		}
    		
    	}
    	
    }
    
    public static void Invisible(Main main) {
    	
    	Joueur eclaireur = main.getJoueurByRole(Roles.Team);

        if (eclaireur.getPlayer().getInventory().getBoots() == null && eclaireur.getPlayer().getInventory().getChestplate() == null && eclaireur.getPlayer().getInventory().getHelmet() == null && eclaireur.getPlayer().getInventory().getLeggings() == null) {

            if (!eclaireur.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY))
                eclaireur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 0, false, false));
            if (!eclaireur.getPlayer().hasPotionEffect(PotionEffectType.SPEED))
                eclaireur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 1, false, false));

        } else {

            if (eclaireur.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY))
                eclaireur.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
            if (eclaireur.getPlayer().hasPotionEffect(PotionEffectType.SPEED))
                eclaireur.getPlayer().removePotionEffect(PotionEffectType.SPEED);

        }
    	
    }

}