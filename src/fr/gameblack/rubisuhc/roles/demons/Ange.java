package fr.gameblack.rubisuhc.roles.demons;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.task.ItemCD;

public class Ange {
	
	public static void Items(Player player) {
		
		Texte(player);
		ItemStack coffre = new ItemStack(Material.NETHER_STAR,1);
		ItemMeta coffreM = coffre.getItemMeta();
		coffreM.setDisplayName("Shop");
		coffre.setItemMeta(coffreM);
		player.getInventory().addItem(coffre);
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 0, false, false));
		
	}
	
	public static void InteractShop(Player player, Main main) {
		
		if(main.getRoles().contains(Roles.SLUP)) {
		
			Player slup = main.getPlayerByRole(Roles.SLUP);
			
			slup.sendMessage("Le démon ange a utilisé son item 'Shop'");
			
		}
		
		Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Shop");
		inv_pacte.setItem(10, Main.getItem(Material.GOLDEN_APPLE, "Absorption", "En échange de 5 points, vous obtenez 2 coeurs d'absorption"));
		inv_pacte.setItem(12, Main.getItem(Material.FEATHER, "Speed", "En échange de 10 points, vous obtenez l'effet speed I pendant 5 minutes"));
		inv_pacte.setItem(14, Main.getItem(Material.BLAZE_POWDER, "Force", "En échange de 12 points, vous obtenez l'effet force I pendant 5 minutes"));
		inv_pacte.setItem(16, Main.getItem(Material.APPLE, "1 coeur permanent", "En échange de 15 points, vous obtenez 1 coeur permanent supplémentaire"));
		player.openInventory(inv_pacte);
		
	}
	
	public static void InteractGApple(Player player, Main main) {
		
		if(main.getPointAnge() >= 5) {
			
			player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 99999, 0, false, false));
			
			main.removePointAnge(5);
			
		}
		else {
			
			player.sendMessage("Vous n'avez pas assez de points");
			
		}
		
	}
	
	public static void InteractSword(Player player, Main main) {
		
		if(main.getPointAnge() >= 12) {
			
			main.addPourcentEffet(player, "force", 0.15);
			ItemCD cycle = new ItemCD(main, player, "shopforce", 300, player, null, null);
			cycle.runTaskTimer(main, 0, 20);
			
			main.removePointAnge(12);
			
		}
		else {
			
			player.sendMessage("Vous n'avez pas assez de points");
			
		}
		
	}
	
	public static void InteractFeather(Player player, Main main) {
		
		if(main.getPointAnge() >= 10) {
			
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6000, 0, false, false));
			
			main.removePointAnge(10);
			
		}
		else {
			
			player.sendMessage("Vous n'avez pas assez de points");
			
		}
		
	}
	
	public static void InteractApple(Player player, Main main) {
		
		if(main.getPointAnge() >= 15) {
			
			player.setMaxHealth(player.getMaxHealth() + 2);
			
			main.removePointAnge(15);
			
		}
		else {
			
			player.sendMessage("Vous n'avez pas assez de points");
			
		}
		
	}
	
	public static void CommandPoint(Player player, Main main) {
		
		int points = main.getPointAnge();
		player.sendMessage("Vous avez " + points + " points");
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Ange\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet résistance I permanent\n \nA chaque coup que vous recevez, vous avez 25% de chance de gagner un point (votre nombre de point est visible avec la commande /rcpoint)\n \nCes points sont échangeable dans un shop contre différents bonus\n \nVous connaissez Slup\n \n____________________________________________________");
		
	}
	
}
