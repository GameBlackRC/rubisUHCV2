package fr.gameblack.rcuhcv2.roles.staff;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.task.ItemCD;
import fr.gameblack.rcuhcv2.task.JeuCD;

public class Trial {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
	}
	
	public static void ItemsSerieux(Joueur joueur) {
		
		joueur.addResi(0.02);
		joueur.addSpeed(0.03);
		
	}
	
	public static void ItemsFun(Joueur joueur) {
		
		joueur.addForce(0.02);
		joueur.addSpeed(0.02);
		
	}
	
	public static void ItemsSerieuxSolo(Joueur joueur) {
		
		joueur.setForce(1.05);
		joueur.setSpeed(1.05);
		joueur.setResi(1.15);
		joueur.getPlayer().setMaxHealth(24);
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Benihime Aratame");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);
        
        ItemStack coffre2 = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM2 = coffre2.getItemMeta();
        coffreM2.setDisplayName("Corruption d'âmes");
        coffre2.setItemMeta(coffreM2);
        joueur.getPlayer().getInventory().addItem(coffre2);
		
	}
	
	public static void ItemsFunSolo(Joueur joueur) {
		
		joueur.setForce(1.05);
		joueur.setSpeed(1.05);
		joueur.setResi(1.15);
		joueur.getPlayer().setMaxHealth(24);
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Benihime Aratame");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);
        
        ItemStack coffre2 = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM2 = coffre2.getItemMeta();
        coffreM2.setDisplayName("Sakashima Yokoshima");
        coffre2.setItemMeta(coffreM2);
        joueur.getPlayer().getInventory().addItem(coffre2);
		
	}
	
	public static void CommandSacrifice(Joueur joueur, String choix) {
		
		if(choix.equalsIgnoreCase("coeur")) {
			
			joueur.removeForce(0.04);
			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth() + 1);
			
		}
		else {
			
			joueur.removeForce(0.04);
			joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0));
			
		}
		
	}
	
	public static void CommandPlay(Joueur joueur, Joueur cible, Main main) {
		
		Random r = new Random();
        int nb = r.nextInt(3);
        
        if(nb == 0) {
        	
        	main.setJeuTrial("soleil");
        	main.getJoueurJeuTrial().add(joueur);
        	main.getJoueurJeuTrial().add(cible);
        	JeuCD cycle = new JeuCD(main, joueur, cible, "soleil", 60);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage("soleil");
        	
        }
        else if(nb == 1) {
        	
        	main.setJeuTrial("takaoni");
        	main.getJoueurJeuTrial().add(joueur);
        	main.getJoueurJeuTrial().add(cible);
        	JeuCD cycle = new JeuCD(main, joueur, cible, "takaoni", 18);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage("takaoni");
        	
        }
        else {
        	
        	main.setJeuTrial("reflex");
        	main.getJoueurJeuTrial().add(joueur);
        	main.getJoueurJeuTrial().add(cible);
        	JeuCD cycle = new JeuCD(main, joueur, cible, "reflex", 30);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage("reflex");
        	
        }
		
	}
	
	public static void FinJeuReflex(Joueur gagnant, Joueur perdant, Main main) {
		
		gagnant.addSpeed(0.05);
		gagnant.addResi(0.02);
		perdant.removeSpeed(0.02);
		ItemCD cycle = new ItemCD(main, gagnant, "speed_reflex_trial", 300, gagnant, null, null, null, null);
        cycle.runTaskTimer(main, 0, 20);
		
	}
	
	public static void FinJeuTakaoni(Joueur j1, Joueur j2, Main main) {
		
		double y_j1 = j1.getPlayer().getLocation().getY();
		double y_j2 = j2.getPlayer().getLocation().getY();
		
		if(y_j2 > y_j1) {
			
			j1.removeForce(0.02);
			j1.getPlayer().setMaxHealth(j1.getPlayer().getMaxHealth()-1);
			j2.setNofall(true);
			j2.addSpeed(0.03);
			ItemCD cycle = new ItemCD(main, j2, "takaoni_trial", 300, j1, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		else {
			
			j2.removeForce(0.02);
			j2.getPlayer().setMaxHealth(j2.getPlayer().getMaxHealth()-1);
			j1.setNofall(true);
			j1.addSpeed(0.03);
			ItemCD cycle = new ItemCD(main, j1, "takaoni_trial", 300, j2, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		
	}
	
	public static void FinJeuSoleil(Joueur gagnant, Joueur perdant, Main main) {
		
		gagnant.getPlayer().sendMessage("Vous avez gagner le jeu, vous pouvez désormais bouger");
		gagnant.getPlayer().sendMessage("Vous avez perdu le jeu, vous pouvez désormais bouger");
		perdant.removeSpeed(0.05);
		gagnant.addForce(0.02);
		gagnant.getPlayer().setMaxHealth(gagnant.getPlayer().getMaxHealth()+2);
		ItemCD cycle = new ItemCD(main, gagnant, "soleil_trial", 300, perdant, null, null, null, null);
        cycle.runTaskTimer(main, 0, 20);
		
	}
	
	public static void ItemBenihimeAratame(Joueur joueur) {
		
		
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9Trial\n§rVous devez gagner avec le §9camp staff§r\n \n____________________________________________________");

    }

}
