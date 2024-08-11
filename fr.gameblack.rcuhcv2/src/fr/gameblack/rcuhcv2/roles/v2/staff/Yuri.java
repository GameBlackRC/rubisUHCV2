package fr.gameblack.rcuhcv2.roles.v2.staff;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Zombie;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Yuri {
	
	private static Zombie aziz;
	
	public static void Items(Joueur joueur) {
		
		joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.YURI_AZIZ));
		Texte(joueur.getPlayer());
		if(joueur.isBot()) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Yuri");
			
		}
		joueur.setAziz(true);
		
	}
	
	public static void ItemAziz(Joueur joueur, Main main) {
		
		if(!joueur.getCD().contains(Pouvoirs.YURI_AZIZ)) {
		
			joueur.getCD().add(Pouvoirs.YURI_AZIZ);
			
			setAziz((Zombie) joueur.getPlayer().getWorld().spawnEntity(joueur.getPlayer().getLocation(), EntityType.ZOMBIE));
			
			aziz.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 3, false, false));
			aziz.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 1, false, false));
			aziz.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 1, false, false));
			
			if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
				
				Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
				
				Random r = new Random();
		        int nb = r.nextInt(100);
				
	            nb = r.nextInt(100);
	            
	            if(nb <= 80) {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient d'utiliser un item");
	            	
	            }
	            else {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + joueur.getPlayer().getName() + " vient d'utiliser un item");
	            	
	            }
				
			}
			
		}
		
	}
	
	public static Zombie getAziz() {
		return aziz;
	}

	public static void setAziz(Zombie aziz) {
		Yuri.aziz = aziz;
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §9Yuri\n§r"
        		+ "Vous devez gagner avec le §9camp staff§r\n \n"
        		+ "AZIZZZZZZZZZZZZZZZ\n \n"
        		+ "____________________________________________________");

    }

}
