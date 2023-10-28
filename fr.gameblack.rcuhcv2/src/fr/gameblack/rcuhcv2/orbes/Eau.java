package fr.gameblack.rcuhcv2.orbes;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.task.ItemCD;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Eau {

	public static void Passif(Joueur joueur, Main main, boolean give) {

    	Player player = joueur.getPlayer();
    	
    	if(give) {
    		
    		joueur.setOrbePassifActif(true);

	        if (player.getInventory().getBoots().getType() != null) {
	
	            ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
	            epeeM.addEnchant(Enchantment.DEPTH_STRIDER, 2, false);
	            ItemStack epee = player.getInventory().getBoots();
	            epee.setItemMeta(epeeM);
	            player.getInventory().setBoots(epee);
	
	        }
	        
    	}
    	else {
    		
    		joueur.setOrbePassifActif(false);
    		joueur.setStatutOrbe(false);
    		
            if (player.getInventory().getBoots().getType() != null) {

                ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
                epeeM.removeEnchant(Enchantment.DEPTH_STRIDER);
                ItemStack epee = player.getInventory().getBoots();
                epee.setItemMeta(epeeM);
                player.getInventory().setBoots(epee);

            }
    		
    	}

    }

    public static void Bonus(Joueur joueur, Main main, boolean give) {
    	
    	if(give) {
    		
    		if(joueur.canHaveMalusBonusOrbe() && joueur.isOrbeActif()) {
    			
    			joueur.getPlayer().sendMessage("Le bonus de votre orbe vient de s'activer");
    		
	    		joueur.addSpeed(0.05);
	    		joueur.setCanHaveMalusBonusOrbe(false);
	    		joueur.setBonusOrbe(true);
	    		ItemCD cycle = new ItemCD(main, joueur, "eau_bonus", 120, joueur, null, null, null, null);
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
	    		ItemCD cycle = new ItemCD(main, joueur, "eau_malus", 120, joueur, null, null, null, null);
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