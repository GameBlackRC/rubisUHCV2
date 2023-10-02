package fr.gameblack.rcuhcv2.orbes;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.task.ItemCD;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Eau {

    public static void Effets(Joueur joueur, Main main) {

    	Player player = joueur.getPlayer();
    	
        joueur.setStatutOrbe(true);
        joueur.addSpeed(0.03);

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

        if (player.getInventory().getBoots().getType() != null) {

            ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
            epeeM.removeEnchant(Enchantment.DEPTH_STRIDER);
            ItemStack epee = player.getInventory().getBoots();
            epee.setItemMeta(epeeM);
            player.getInventory().setBoots(epee);

        }

    }

    public static void Malus(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();
    		
    	RemoveEffets(joueur, main);
        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1200, 0, false, false));
        joueur.setMalusOrbe(true);
        ItemCD cycle = new ItemCD(main, joueur, "eau_malus", 60, joueur, null, null, null, null);
        cycle.runTaskTimer(main, 0, 20);

    }

}