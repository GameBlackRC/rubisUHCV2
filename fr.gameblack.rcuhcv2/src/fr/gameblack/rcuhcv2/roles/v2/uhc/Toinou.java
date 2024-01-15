package fr.gameblack.rcuhcv2.roles.v2.uhc;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.JoueurMort;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Toinou {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		joueur.addSpeed(0.05);
		joueur.addForce(0.01);
		
		if(joueur.isBot()) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Toinou");
			
		}
		
	}
	
	public static void Cheat(Joueur joueur, Main main) {
		
		joueur.addSpeed(0.1);
		joueur.setCheatToinou(true);
		ItemCD cycle = new ItemCD(main, joueur, "speed_cheat_toinou", 120, joueur, null, null, 0, null);
        cycle.runTaskTimer(main, 0, 20);
        ItemCD cycle2 = new ItemCD(main, joueur, "force_cheat_toinou", 60, joueur, null, null, 0, null);
        cycle2.runTaskTimer(main, 0, 20);
		
	}
	
	public static void CommandVacance(Joueur joueur, Main main) {
		
		joueur.setInvulnerable(true);
		joueur.setInvisible(true);
		joueur.hide(main);
		joueur.addSpeed(0.1);
		
		if(main.getMode() == Modes.RAPIDE) {
			
			ItemCD cycle = new ItemCD(main, joueur, "vacance_toinou", 15, joueur, null, null, 0, null);
			cycle.runTaskTimer(main, 0, 20);
			
		}
		else {
		
			ItemCD cycle = new ItemCD(main, joueur, "vacance_toinou", 120, joueur, null, null, 0, null);
			cycle.runTaskTimer(main, 0, 20);
			
		}
		
		if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
			
			Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
			
			Random r = new Random();
			
            int nb = r.nextInt(100);
            
            if(nb <= 80) {
            	
            	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient d'effectuer une commande");
            	
            }
            else {
            	
            	gb.getPlayer().sendMessage("[CONSOLE]" + joueur.getPlayer().getName() + " vient d'effectuer une commande");
            	
            }
			
		}
		
	}
	
	public static void CommandShop(Joueur joueur) {
		
		Inventory inv_orbe = Bukkit.createInventory(null, 27, "§8Shop");
    	
		inv_orbe.setItem(10, Main.getItem(Material.GOLDEN_APPLE, "3 gaps", "Coût : 1 point;Permet de recevoir 3 pommes d'or"));
        inv_orbe.setItem(11, Main.getItem(Material.COMPASS, "Traqueur", "Coût : 1 point;Permet de traquer un joueur au choix"));
        inv_orbe.setItem(12, Main.getItem(Material.BOOK, "Livre", "Coût : 1 point;Permet de connaître le rôle ou le pseudo du tueur;d'un joueur au choix"));
        inv_orbe.setItem(13, Main.getItem(Material.GLASS, "Nuage Flottant", "Coût : 2 points;Donne 5% de speed supplémentaire;lorsqu'elle est tenu en main"));
        inv_orbe.setItem(14, Main.getItem(Material.NETHERRACK, "Épée maudite", "Coût : 2 points;Donne 2% de force supplémentaire;lorsqu'elle est tenu en main"));
        inv_orbe.setItem(15, Main.getItem(Material.SOUL_SAND, "Épée des âmes", "Coût : 3 points;Permet de ne pas prendre en compte; la résistance de l'adversaire"));
        inv_orbe.setItem(16, Main.getItem(Material.REDSTONE_BLOCK, "Totem", "Coût : 4 points;Permet de ressuciter un joueur de votre camp"));

        joueur.getPlayer().openInventory(inv_orbe);
		
	}
	
	public static void InteractBook(Joueur joueur, Main main) {
		
		Inventory inv = Bukkit.createInventory(null, 27, "§8Morts");
    	
		int slot = 0;
		
		for(JoueurMort j : main.getMorts()) {
    	
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
			SkullMeta skull = (SkullMeta) item.getItemMeta();
			skull.setDisplayName(j.getPseudo());
			skull.setOwner(j.getPseudo());
			item.setItemMeta(skull);
				
			inv.setItem(slot, item);
			    
			    slot++;
		
		}

        joueur.getPlayer().openInventory(inv);
		
	}
	
	public static void InteractTotemCible(Joueur joueur, String cible, Main main) {
		
		Joueur j = main.getJoueurByPseudo(cible);
		
		joueur.removePoints(4);
		
		JoueurMort mort = main.getMort(cible);
		
		j.reset(main);
		
		j.setInvulnerable(true);
		
		Random r = new Random();
        int signe_x = r.nextInt(2);
        int signe_y = r.nextInt(2);
        int cos_x = r.nextInt(100);
        cos_x += 200;
        if (signe_x == 1) {
            cos_x = -cos_x;
        }

        int cos_y = r.nextInt(100);
        cos_y += 200;
        if (signe_y == 1) {
            cos_y = -cos_y;
        }

        j.getPlayer().setFoodLevel(20);

        j.getPlayer().setHealth(20);
        
        j.getPlayer().teleport(new Location(joueur.getPlayer().getWorld(), cos_x, 100, cos_y));
        
        j.setOrbe(mort.getOrbe());
        
        j.setRole(mort.getRole(), main);
        
        j.setCamp(mort.getCamp());
        
        j.getPlayer().setMaxHealth(j.getPlayer().getMaxHealth()-4);
        
        j.getPlayer().setGameMode(GameMode.SURVIVAL);
        
        ItemCD cycle2 = new ItemCD(main, joueur, "respawn", 5, joueur, null, null, 0, null);
        cycle2.runTaskTimer(main, 0, 20);
		
	}
	
	public static void InteractTotem(Joueur joueur, Main main) {
		
		Inventory inv = Bukkit.createInventory(null, 27, "§8Revive");
    	
		int slot = 0;
		boolean hasMortInCamp = false;
		
		for(JoueurMort j : main.getMorts()) {
			
			Player pls = Bukkit.getPlayer(j.getPseudo());
			
			if(j.getCamp() == joueur.getCamp() && Bukkit.getOnlinePlayers().contains(pls)) {
				
				hasMortInCamp = true;
    	
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
				SkullMeta skull = (SkullMeta) item.getItemMeta();
				skull.setDisplayName(j.getPseudo());
				skull.setOwner(j.getPseudo());
				item.setItemMeta(skull);
					
				inv.setItem(slot, item);
				    
				slot++;
				
			}
		
		}
		
		if(!hasMortInCamp) {
			
			joueur.getPlayer().sendMessage("Il n'y a aucun mort dans votre camp ou aucun mort n'est connecté");
			
		}
		else {
			
			joueur.getPlayer().openInventory(inv);
			
		}
		
	}
	
	public static void InteractBookCible(Joueur joueur, String cible, Main main) {
		
		Random r = new Random();
        int nb = r.nextInt(2);
        JoueurMort mort = main.getMort(cible);
        if(nb == 1) {
        	
        	joueur.getPlayer().sendMessage("Le pseudo du tueur de " + mort.getPseudoCouleur() + "§r est : " + mort.getTueur());
        	
        }
        else {
        	
        	joueur.getPlayer().sendMessage("Le rôle du tueur de " + mort.getPseudoCouleur() + "§r est : " + mort.getRoleTueur());
        	
        }
        
        joueur.getPlayer().getInventory().remove(Main.getItemRole(ItRoles.TOINOU_LIVRE));
		
	}

	public static void CommandTraque(Joueur joueur, Joueur cible, Main main) {
		
		if(joueur.getTraqueToinou() == joueur) {
		
			if(joueur.getUtilisationTraquerToinou() < 3) {
			
				joueur.setTraqueToinou(cible);
				joueur.addUtilisationTraquerToinou(1);
				
			}
			else {
				
				joueur.getPlayer().sendMessage("Vous avez atteint la limite de traque");
				
			}
			
		} else {
			
			joueur.getPlayer().sendMessage("Vous n'avez pas acheté le traqueur ou il est déjà en cours d'utilisation");
			
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §2Toinou\n§r"
        		+ "Vous devez gagner avec le §2camp UHC§r\n \n"
        		+ "Avec la commande /rcvacance, vous devenez invisible avec votre armure pendant 2 minutes et vous ne pouvez pas recevoir ou mettre de coup pendant que vous êtes invisible\n \n"
        		+ "Si Raptor active son cheat contre vous, vous recevez 10% de speed pendant 2 minutes et vos coup mis à Raptor auront 5% de force supplémentaire\n \n"
        		+ "Avec la commande /rcshop, vous pouvez acheter des objects avec vos points\n"
        		+ "A chaque kill vous obtenez 1 point supplémentaire et à l'annonce des rôles, vous pouvez acheter un objet avec un coût maximum de 2 points hormis les pommes d'or\n \n"
        		+ "____________________________________________________");

    }

}
