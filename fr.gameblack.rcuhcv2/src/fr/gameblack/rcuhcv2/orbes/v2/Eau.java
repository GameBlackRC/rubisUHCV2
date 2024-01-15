package fr.gameblack.rcuhcv2.orbes.v2;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Eau {

	public static void Passif(Joueur joueur, Main main, boolean give) {

    	Player player = joueur.getPlayer();
    	
    	if(give) {
    		
    		joueur.setOrbePassifActif(true);
    		joueur.addSpeed(0.02);
    		if(joueur.getRole() == Roles.MAKA) {
    			
    			joueur.addSpeed(0.01);
    			
    		}

	        if (player.getInventory().getBoots().getType() != null) {
	
	            ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
	            epeeM.addEnchant(Enchantment.DEPTH_STRIDER, 1, false);
	            ItemStack epee = player.getInventory().getBoots();
	            epee.setItemMeta(epeeM);
	            player.getInventory().setBoots(epee);
	
	        }
	        
    	}
    	else {
    		
    		joueur.setOrbePassifActif(false);
    		joueur.setStatutOrbe(false);
    		joueur.removeSpeed(0.02);
    		if(joueur.getRole() == Roles.MAKA) {
    			
    			joueur.removeSpeed(0.01);
    			
    		}
    		
            if (player.getInventory().getBoots().getType() != null) {

                ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
                epeeM.removeEnchant(Enchantment.DEPTH_STRIDER);
                ItemStack epee = player.getInventory().getBoots();
                epee.setItemMeta(epeeM);
                player.getInventory().setBoots(epee);

            }
    		
    	}

    }
	
	public static void Active(Joueur joueur, boolean give) {
		
		if(give) {
			
			joueur.addSpeed(0.02);
			
		}
		else {
			
			joueur.removeSpeed(0.02);
			
		}
		
	}

    public static void Bonus(Joueur joueur, Main main, boolean give) {
    	
    	if(give) {
    		
    		if(joueur.canHaveMalusBonusOrbe() && joueur.isOrbeActif()) {
    			
    			joueur.getPlayer().sendMessage("Le bonus de votre orbe vient de s'activer");
    		
	    		joueur.addSpeed(0.05);
	    		joueur.setCanHaveMalusBonusOrbe(false);
	    		joueur.setBonusOrbe(true);
	    		ItemCD cycle = new ItemCD(main, joueur, "eau_bonus", 120, joueur, null, null, 0, null);
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
	    		joueur.removeSpeed(0.05);
	    		joueur.setCanHaveMalusBonusOrbe(false);
	    		joueur.setMalusOrbe(true);
	    		ItemCD cycle = new ItemCD(main, joueur, "eau_malus", 120, joueur, null, null, 0, null);
		        cycle.runTaskTimer(main, 0, 20);
		        
    		}
    		
    	}
    	else {
    		
    		joueur.setMalusOrbe(false);
    		joueur.addSpeed(0.05);
    		joueur.getPlayer().sendMessage("Le malus de votre orbe est désormais terminé");
    		
    		if(!joueur.isOrbePassifActif()) {
    			
    			Passif(joueur, main, true);
    			
    		}
    		
    	}

    }

}