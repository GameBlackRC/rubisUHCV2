package fr.gameblack.rcuhcv2.roles.staff;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.task.ItemCD;

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
	
	public static void ItemsUHC(Joueur joueur) {
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Fuite");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);
		
	}
	
	public static void InteractFuite(Joueur joueur, Main main) {
		
		if(!main.getCD().contains(Pouvoirs.GAMEBLACK_FUITE)) {
			
			joueur.setInvulnerable(true);
			joueur.addSpeed(0.1);
			for(Entity entity : joueur.getPlayer().getNearbyEntities(10, 10, 10)) {
				
				if(entity instanceof Player) {
					
					Player p = (Player) entity;
					
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100 , 0));
					
				}
				
			}
			
			main.getCD().add(Pouvoirs.GAMEBLACK_FUITE);
			
			ItemCD cycle = new ItemCD(main, joueur, "fuite", 60, joueur, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
		}
		else {
			
			joueur.getPlayer().sendMessage("Ce pouvoir est en cooldown");
			
		}
		
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
