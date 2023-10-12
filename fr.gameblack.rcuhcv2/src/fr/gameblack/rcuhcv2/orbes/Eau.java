package fr.gameblack.rcuhcv2.orbes;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.task.ItemCD;

import java.util.Random;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Eau {

    public static void Effets(Joueur joueur, Main main) {

    	Player player = joueur.getPlayer();
    	
        joueur.setStatutOrbe(true);
        joueur.addSpeed(0.03);
        joueur.setNofall(true);

        if (player.getInventory().getBoots().getType() != null) {

            ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
            epeeM.addEnchant(Enchantment.DEPTH_STRIDER, 2, false);
            ItemStack epee = player.getInventory().getBoots();
            epee.setItemMeta(epeeM);
            player.getInventory().setBoots(epee);

        }

    }

    public static void RemoveEffets(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();
    	
    	joueur.setStatutOrbe(false);
    	
    	joueur.removeSpeed(0.03);
    	
    	joueur.setNofall(false);

        if (player.getInventory().getBoots().getType() != null) {

            ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
            epeeM.removeEnchant(Enchantment.DEPTH_STRIDER);
            ItemStack epee = player.getInventory().getBoots();
            epee.setItemMeta(epeeM);
            player.getInventory().setBoots(epee);

        }

    }

    public static void Malus(Joueur joueur, Main main) {
    	
    	Random r = new Random();
        int nb = r.nextInt(100);
    	
    	if(joueur.isOrbeActif() && (joueur.getRole() != Roles.GAMEBLACK || (joueur.getRole() == Roles.GAMEBLACK && nb <= 50)) && !(joueur.getRole() == Roles.FARMEURIMMO && joueur.getVol().contains(Pouvoirs.GAMEBLACK_MALUS_ORBE))) {
	    		
	    	RemoveEffets(joueur, main);
	        joueur.removeForce(0.05);
	        joueur.setMalusOrbe(true);
	        ItemCD cycle = new ItemCD(main, joueur, "eau_malus", 60, joueur, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
    	}

    }

}