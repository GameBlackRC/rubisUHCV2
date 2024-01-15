package fr.gameblack.rcuhcv2.roles.v2.staff;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

public class Captain {

	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		if(joueur.isBot()) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Captain");
			
		}
		
		joueur.addSpeed(0.05);
		
		ItemStack casque = joueur.getPlayer().getInventory().getHelmet();
		ItemStack plastron = joueur.getPlayer().getInventory().getChestplate();
		ItemStack jambieres = joueur.getPlayer().getInventory().getLeggings();
		ItemStack bottes = joueur.getPlayer().getInventory().getBoots();
		
		if(joueur.getPlayer().getInventory().getHelmet() != null) {
			
			ItemMeta casqueM = casque.getItemMeta();
			casqueM.spigot().setUnbreakable(true);
			casque.setItemMeta(casqueM);
			
		}
		if(joueur.getPlayer().getInventory().getChestplate() != null) {
			
			ItemMeta plastronM = plastron.getItemMeta();
			plastronM.spigot().setUnbreakable(true);
			plastronM.addEnchant(Enchantment.THORNS, 2, false);
			plastron.setItemMeta(plastronM);
			
		}
		if(jambieres != null) {
			
			ItemMeta jambieresM = jambieres.getItemMeta();
			jambieresM.spigot().setUnbreakable(true);
			jambieres.setItemMeta(jambieresM);
			
		}
		if(bottes != null) {
			
			ItemMeta bottesM = bottes.getItemMeta();
			bottesM.spigot().setUnbreakable(true);
			bottes.setItemMeta(bottesM);
			
		}
		
	}
	
	public static void commandRepair(Joueur joueur, Joueur cible, Main main) {
		
		Inventory inv_orbe = Bukkit.createInventory(null, 27, "§8Réparation " + cible.getPlayer().getName());
    	
        inv_orbe.setItem(10, cible.getPlayer().getInventory().getHelmet());
        inv_orbe.setItem(12, cible.getPlayer().getInventory().getChestplate());
        inv_orbe.setItem(14, cible.getPlayer().getInventory().getLeggings());
        inv_orbe.setItem(16, cible.getPlayer().getInventory().getBoots());

        joueur.getPlayer().openInventory(inv_orbe);
        
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
	
	public static void commandEnchant(Joueur joueur, Joueur cible, Main main) {
		
		Inventory inv_orbe = Bukkit.createInventory(null, 27, "§8Enchantement " + cible.getPlayer().getName());
    	
        inv_orbe.setItem(10, cible.getPlayer().getInventory().getHelmet());
        inv_orbe.setItem(12, cible.getPlayer().getInventory().getChestplate());
        inv_orbe.setItem(14, cible.getPlayer().getInventory().getLeggings());
        inv_orbe.setItem(16, cible.getPlayer().getInventory().getBoots());

        joueur.getPlayer().openInventory(inv_orbe);
        
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
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §9Captain\n§r"
        		+ "Vous devez gagner avec le §9camp staff§r\n \n"
        		+ "Vous avez 5% de speed permanent ainsi que l'enchantement thorns II sur votre plastron. Votre armure est incassable\n \n"
        		+ "Avec la commande /rcrepair <pseudo>, vous pouvez une fois par épisode réparer une pièce d'armure du joueur ciblé\n \n"
        		+ "Avec la commande /rcenchant <pseudo>, vous pouvez une fois par épisode modifier les enchantements d'une pièce de votre armure et une pièce d'armure d'un joueur au choix\n \n"
        		+ "____________________________________________________");

    }
	
}
