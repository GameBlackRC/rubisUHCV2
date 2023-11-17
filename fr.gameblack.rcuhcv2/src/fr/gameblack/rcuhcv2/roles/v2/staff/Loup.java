package fr.gameblack.rcuhcv2.roles.v2.staff;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.Boat;
import org.bukkit.inventory.meta.SkullMeta;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

import java.util.ArrayList;
import java.util.List;

public class Loup {
	
	private static Boat boat;
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
		joueur.addResi(0.02);
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Super bateau");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);
		
	}
	
	public static void ItemSuperBateau(Joueur joueur, Main main) {
		
		joueur.getCD().add(Pouvoirs.LOUP_SUPERBATEAU);
		
		Bukkit.getWorld("world").playSound(joueur.getPlayer().getLocation(), Sound.BLAZE_DEATH, 10, 1);
		setBoat((Boat)joueur.getPlayer().getWorld().spawnEntity(joueur.getPlayer().getLocation(), EntityType.BOAT));
		boat.setCustomName("Super Bateau");
		boat.setCustomNameVisible(true);
		joueur.setSuperBateauLoup(true);
		joueur.hide(main);
		joueur.setInvisible(true);
		
		joueur.getPlayer().sendMessage("Vous activez votre pouvoir");
		
		Random r = new Random();
        int nb = r.nextInt(100);
		
		joueur.setNofall(true);
		joueur.getPlayer().setAllowFlight(true);
		joueur.getPlayer().setFlying(true);
		joueur.setInvulnerable(true);
		
		if(nb <= 10) {
	        
	        ItemCD cycle = new ItemCD(main, joueur, "vol_loup_pb", 10, joueur, null, null, 0, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
	        ItemCD cycle2 = new ItemCD(main, joueur, "vol_loup_nf", 15, joueur, null, null, 0, null);
	        cycle2.runTaskTimer(main, 0, 20);
			
		}
		else {
			
			ItemCD cycle = new ItemCD(main, joueur, "vol_loup", 20, joueur, null, null, 0, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
	        ItemCD cycle2 = new ItemCD(main, joueur, "vol_loup_nf", 25, joueur, null, null, 0, null);
	        cycle2.runTaskTimer(main, 0, 20);
			
		}
		
		ItemCD cycle3 = new ItemCD(main, joueur, "vol_loup_cd", 300, joueur, null, null, 0, null);
        cycle3.runTaskTimer(main, 0, 20);
		
	}
	
	public static void menuAccesBateau(Joueur joueur, Main main) {
		
		Inventory inv = Bukkit.createInventory(null, 36, "§8Accès Super Bateau");
		
		int slot = 0;
		
		for(Joueur j : main.getJoueurInGame()) {
			
			if(j != joueur) {
    	
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
			    SkullMeta skull = (SkullMeta) item.getItemMeta();
			    if(j.isAccesSuperBateau(main)) {
			    	
			    	skull.setDisplayName("§a " + j.getPlayer().getName() + " §r");
			    	
			    }
			    else {
			    	
			    	skull.setDisplayName("§c " + j.getPlayer().getName() + " §r");
			    	
			    }
			    skull.setOwner(j.getPlayer().getName());
			    item.setItemMeta(skull);
			    
			    if(!j.isAccesSuperBateau(main)) {
			    	item.setAmount(0);
			    }
				
			    inv.setItem(slot, item);
			    
			    slot++;
			    
			}
		
		}

        joueur.getPlayer().openInventory(inv);
		
	}
	
	public static void CommandServeur(Joueur joueur, Main main) {
		
		if(!joueur.getCD().contains(Pouvoirs.LOUP_SERVEUR)) {
			
			joueur.getPlayer().sendMessage("Vous activez votre pouvoirs");
			
			joueur.getCD().add(Pouvoirs.LOUP_SERVEUR);
		
			List<Joueur> joueurs = new ArrayList<>();
			
			for(Joueur j : main.getJoueurInGame()) {
				
				if(j.getRole() != Roles.NONE && j.getRole() != Roles.TRIAL && j.getRole() != Roles.LOUP) {
					
					j.removeForce(0.03);
					joueurs.add(j);
					
				}
				
			}
			
			ItemCD cycle = new ItemCD(main, joueur, "serveur_loup", 30, joueur, null, joueurs, 0, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9Loup\n§rVous devez gagner avec le §9camp staff§r\n \nVous avez 2% de résistance supplémentaire\n \nA l'annonce des rôles, vous recevez un item nommé 'Super bateau' qui vous transforme en bateau\nIl y a 10% de chance que la durée de vol soit réduite. Dans ce cas vous recevrez le message 'Flying is not enable on this server' à la fin du vol\n \nAvec la commande /rcbateau, vous pouvez choisir qui peut monter dans le 'Super bateau'\n \nAvec la commande /rcserveur, si Trial est proche de vous, tous les joueurs de la partie, sauf vous et Trial, perdent 5% de force pendant 30 secondes\n \n____________________________________________________");

    }

	public static Boat getBoat() {
		return boat;
	}

	public static void setBoat(Boat boat) {
		Loup.boat = boat;
	}

}
