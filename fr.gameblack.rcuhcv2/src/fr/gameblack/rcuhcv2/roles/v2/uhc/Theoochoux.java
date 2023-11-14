package fr.gameblack.rcuhcv2.roles.v2.uhc;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Theoochoux {
	
	public static void Items(Joueur joueur) {
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("RollBack");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);
        joueur.addSpeed(0.2);
        Texte(joueur.getPlayer());
		
	}
	
	public static void interactRollback(Main main, Joueur joueur) {
		
		joueur.getPlayer().teleport(main.getTheoochouxLoc());
		joueur.getPlayer().getInventory().setContents(main.getTheoochouxInv().getContents());
		joueur.getPlayer().setHealth(main.getTheoochouxHP());
		joueur.getPlayer().setFoodLevel(main.getTheoochouxFood());
		
	}
	
	public static void checkBonus(Main main, Joueur joueur, Joueur victime) {
		
		Random r = new Random();
        int nb = r.nextInt(100);
		
		if(main.getStadeTheoochouxBonus() == 2 && nb <= 2) {
			
			joueur.setAntiKB(true);
			ItemCD cycle = new ItemCD(main, joueur, "theo_antikb", 2, joueur, null, null, 0, null);
	    	cycle.runTaskTimer(main, 0, 20);
			
		}
		else if(main.getStadeTheoochouxBonus() == 3 && nb <= 4) {
			
			nb = r.nextInt(2);
			
			if(nb == 1) {
				
				joueur.setAntiKB(true);
				ItemCD cycle = new ItemCD(main, joueur, "theo_antikb", 3, joueur, null, null, 0, null);
		    	cycle.runTaskTimer(main, 0, 20);
				
			}
			else {
				
				Location loc = victime.getPlayer().getLocation();
				
				joueur.getPlayer().teleport(loc);
				
			}
			
		}
		
		else if(main.getStadeTheoochouxBonus() == 4 && nb <= 6) {
			
			nb = r.nextInt(2);
			
			if(nb == 1) {
				
				joueur.setAntiKB(true);
				ItemCD cycle = new ItemCD(main, joueur, "theo_antikb", 5, joueur, null, null, 0, null);
		    	cycle.runTaskTimer(main, 0, 20);
				
			}
			else {
				
				Location loc = victime.getPlayer().getLocation();
				
				joueur.getPlayer().teleport(loc);
				
			}
			
		}
		else if(main.getStadeTheoochouxBonus() == 5 && nb <= 10) {
			
			nb = r.nextInt(2);
			
			if(nb == 1) {
				
				joueur.setAntiKB(true);
				ItemCD cycle = new ItemCD(main, joueur, "theo_antikb", 7, joueur, null, null, 0, null);
		    	cycle.runTaskTimer(main, 0, 20);
				
			}
			else {
				
				Location loc = victime.getPlayer().getLocation();
				
				joueur.getPlayer().teleport(loc);
				
			}
			
		}
		else if(main.getStadeTheoochouxBonus() == 6 && nb <= 12) {
			
			nb = r.nextInt(2);
			
			if(nb == 1) {
				
				joueur.setAntiKB(true);
				ItemCD cycle = new ItemCD(main, joueur, "theo_antikb", 10, joueur, null, null, 0, null);
		    	cycle.runTaskTimer(main, 0, 20);
				
			}
			else {
				
				Location loc = victime.getPlayer().getLocation();
				
				joueur.getPlayer().teleport(loc);
				
			}
			
		}
		else if(main.getStadeTheoochouxBonus() == 7 && nb <= 14) {
			
			nb = r.nextInt(2);
			
			if(nb == 1) {
				
				joueur.setAntiKB(true);
				ItemCD cycle = new ItemCD(main, joueur, "theo_antikb", 3, joueur, null, null, 0, null);
		    	cycle.runTaskTimer(main, 0, 20);
				
			}
			else {
				
				Location loc = victime.getPlayer().getLocation();
				
				joueur.getPlayer().teleport(loc);
				
			}
			
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §2Theoochoux\n§rVous devez gagner avec le §2camp UHC§r\n \n____________________________________________________");

    }

}
