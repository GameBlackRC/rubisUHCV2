package fr.gameblack.rcuhcv2.orbes.v2;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Foudre {

	public static void Passif(Joueur joueur, Main main, boolean give) {
    	
    	if(give) {
    		
    		joueur.setOrbePassifActif(true);
    		joueur.addSpeed(0.05);
	        if (joueur.getPlayer().getInventory().getChestplate().getType() != null) {
	        	
	        	int lvl = joueur.getPlayer().getInventory().getChestplate().getEnchantmentLevel(Enchantment.THORNS);
	        	lvl += 1;
	        	
	            ItemMeta epeeM = joueur.getPlayer().getInventory().getChestplate().getItemMeta();
	            epeeM.addEnchant(Enchantment.THORNS, lvl, false);
	            ItemStack epee = joueur.getPlayer().getInventory().getChestplate();
	            epee.setItemMeta(epeeM);
	            joueur.getPlayer().getInventory().setChestplate(epee);
	
	        }
	        
    	}
    	else {
    		
    		joueur.setOrbePassifActif(false);
    		joueur.removeSpeed(0.05);
    		joueur.setStatutOrbe(false);
	        if (joueur.getPlayer().getInventory().getChestplate().getType() != null) {
	        	
	        	int lvl = joueur.getPlayer().getInventory().getChestplate().getEnchantmentLevel(Enchantment.THORNS);
	        	if(lvl != 0) {
	        		lvl -= 1;
	        	}
	        	
	            ItemMeta epeeM = joueur.getPlayer().getInventory().getChestplate().getItemMeta();
	            epeeM.removeEnchant(Enchantment.THORNS);
	            if(lvl != 0) {
	            	epeeM.addEnchant(Enchantment.THORNS, lvl, false);
	            }
	            ItemStack epee = joueur.getPlayer().getInventory().getChestplate();
	            epee.setItemMeta(epeeM);
	            joueur.getPlayer().getInventory().setChestplate(epee);
	
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
	    		ItemCD cycle = new ItemCD(main, joueur, "foudre_bonus", 120, joueur, null, null, 0, null);
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
	    		ItemCD cycle = new ItemCD(main, joueur, "foudre_malus", 120, joueur, null, null, 0, null);
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