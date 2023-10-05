package fr.gameblack.rcuhcv2.roles.staff;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;

public class GameBlack {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
		ItemStack orbes = new ItemStack(Material.SLIME_BALL);
    	
    	ItemMeta orbesM = orbes.getItemMeta();
    	orbesM.setDisplayName("§4Orbe");
    	orbes.setItemMeta(orbesM);
		
		joueur.addSpeed(0.05);
		joueur.getPlayer().getInventory().addItem(orbes);
		
	}
	
	public static void commandChangeOrbe(Joueur joueur) {
		
		Inventory inv_orbe = Bukkit.createInventory(null, 27, "§8Choix de l'orbe");
    	
        inv_orbe.setItem(10, Main.getItem(Material.WATER_BUCKET, "Eau", ""));
        inv_orbe.setItem(12, Main.getItem(Material.LAVA_BUCKET, "Feu", ""));
        inv_orbe.setItem(14, Main.getItem(Material.ICE, "Glace", ""));
        inv_orbe.setItem(16, Main.getItem(Material.REDSTONE_BLOCK, "Foudre", ""));

        joueur.getPlayer().openInventory(inv_orbe);
		
	}
	
	public static void commandCheckOrbe(Joueur joueur, Joueur cible) {
		
		String orbe = null;
		
		if(cible.getOrbe() == Orbe.EAU) {
			
			orbe = "§1orbe d'eau";
			
		}
		else if(cible.getOrbe() == Orbe.FEU) {
			
			orbe = "§corbe de feu";
			
		}
		else if(cible.getOrbe() == Orbe.GLACE) {
			
			orbe = "§borbe de glace";
			
		}
		else if(cible.getOrbe() == Orbe.FOUDRE) {
			
			orbe = "§eorbe de foudre";
			
		}
		
		if(orbe == null) {
			
			joueur.getPlayer().sendMessage(cible.getPlayer().getName() + " ne possède pas d'orbe");
			
		}
		else {
			
			joueur.getPlayer().sendMessage(cible.getPlayer().getName() + " possède l'" + orbe);
			
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9GameBlack\n§rVous devez gagner avec le §9camp staff§r\n \nVous connaissez Trial\n \n____________________________________________________");

    }

}
