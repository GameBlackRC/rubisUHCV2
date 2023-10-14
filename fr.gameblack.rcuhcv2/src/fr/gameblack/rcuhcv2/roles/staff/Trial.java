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
		
		if(joueur.getUtilisationSacrificeTrial() < 4) {
			
			joueur.addUtilisationSacrificeTrial();
		
			if(choix.equalsIgnoreCase("coeur")) {
				
				joueur.removeForce(0.04);
				joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth() + 1);
				
			}
			else {
				
				joueur.removeForce(0.04);
				joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0));
				
			}
			
		}
		else {
			
			joueur.getPlayer().sendMessage("Vous ne pouvez plus utiliser ce pouvoir");
			
		}
		
	}
	
	public static void CommandPlay(Joueur joueur, Joueur cible, Main main) {
		
		Random r = new Random();
        int nb = r.nextInt(3);
        joueur.setInvulnerable(true);
        cible.setInvulnerable(true);
        
        if(nb == 0) {
        	
        	main.getJoueurJeuTrial().add(joueur);
        	main.getJoueurJeuTrial().add(cible);
        	JeuCD cycle = new JeuCD(main, joueur, cible, "soleil", 33);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage("Le jeu choisi est soleil");
            cible.getPlayer().sendMessage("Vous jouez à 1, 2, 3, soleil avec Trial, ne bougez plus ! Le je se lance dans 3 secondes");
        	
        }
        else if(nb == 1) {
        	
        	main.setJeuTrial("takaoni");
        	main.getJoueurJeuTrial().add(joueur);
        	main.getJoueurJeuTrial().add(cible);
        	JeuCD cycle = new JeuCD(main, joueur, cible, "takaoni", 8);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage("Le jeu choisi est takaoni");
            cible.getPlayer().sendMessage("Vous jouez à takaoni avec Trial, montez le plus haut possible !");
        	
        }
        else {
        	
        	main.setJeuTrial("reflex");
        	main.getJoueurJeuTrial().add(joueur);
        	main.getJoueurJeuTrial().add(cible);
        	JeuCD cycle = new JeuCD(main, joueur, cible, "reflex", 30);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage("Le jeu choisi est reflex");
            cible.getPlayer().sendMessage("Vous jouez à reflex avec Trial, cliquez le plus rapidement sur le message qui va apparaître dans le chat !");
        	
        }
		
	}
	
	public static void FinJeuReflex(Joueur gagnant, Joueur perdant, Main main) {
		
		gagnant.addSpeed(0.05);
		gagnant.addResi(0.02);
		perdant.removeSpeed(0.02);
		ItemCD cycle = new ItemCD(main, gagnant, "speed_reflex_trial", 300, gagnant, null, null, null, null);
        cycle.runTaskTimer(main, 0, 20);
        gagnant.setInvulnerable(false);
    	perdant.setInvulnerable(false);
    	main.setJeuTrial(null);
    	main.getJoueurJeuTrial().clear();
		
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
	        j1.setInvulnerable(false);
	    	j2.setInvulnerable(false);
	    	main.setJeuTrial(null);
	    	main.getJoueurJeuTrial().clear();
			
		}
		else {
			
			j2.removeForce(0.02);
			j2.getPlayer().setMaxHealth(j2.getPlayer().getMaxHealth()-1);
			j1.setNofall(true);
			j1.addSpeed(0.03);
			ItemCD cycle = new ItemCD(main, j1, "takaoni_trial", 300, j2, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
	        j1.setInvulnerable(false);
	    	j2.setInvulnerable(false);
	    	main.setJeuTrial(null);
	    	main.getJoueurJeuTrial().clear();
			
		}
		
	}
	
	public static void FinJeuSoleil(Joueur gagnant, Joueur perdant, Main main) {
		
		gagnant.getPlayer().sendMessage("Vous avez gagner le jeu, vous pouvez désormais bouger");
		perdant.getPlayer().sendMessage("Vous avez perdu le jeu, vous pouvez désormais bouger");
		perdant.removeSpeed(0.05);
		gagnant.addForce(0.02);
		gagnant.getPlayer().setMaxHealth(gagnant.getPlayer().getMaxHealth()+2);
		ItemCD cycle = new ItemCD(main, gagnant, "soleil_trial", 300, perdant, null, null, null, null);
        cycle.runTaskTimer(main, 0, 20);
        gagnant.setInvulnerable(false);
    	perdant.setInvulnerable(false);
    	main.setJeuTrial(null);
    	main.getJoueurJeuTrial().clear();
		
	}
	
	public static void ItemBenihimeAratame(Joueur joueur) {
		
		
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9Trial\n§rVous devez gagner avec le §9camp staff§r\n \nAvec la commande /rcmode <serieux/fun>, vous pouvez choisir votre mode qui définira vos pouvoirs durant la totalité de la partie\n \nMode Sérieux :\nVous recevez 2% de résistance et 3% de speed permanent\nA chaque kill effectuer, vous obtenez 2% de force supplémentaire (Slup reçoit aussi 2% de force si vous êtes en duo avec lui)\nAvec la commande /rcsacrifice <coeur|regen>, vous perdez 4% de force permanent et vous gagnez 1 coeur permanent ou vous régénérer 2 coeurs\n \nMode fun :\nVous recevez 2% de speed et 2% de force permanent\n \nAvec la commande /rcplay <pseudo>, vous pouvez lancer un jeu avec un autre joueur (pour voir les jeux et les bonus/malus à recevoir, faites la commande /rcinfo). Vous et le joueur choisi seront invulnérables et ne pourrez pas mettre de coup.\n \nLorsque Loup vient à mourrir par un membre du camp UHC, si Slup a choisi le pacte 2 et qu'il n'est pas passé définitivement dans le camp joueur, vous devez gagnez avec lui, vous recevrez le pseudo du tueur de Loup et le tueur de Loup recevra votre pseudo. Sinon vous passez dans le camp UHC et vous recevez le pseudo du tueur de Loup et le tueur recevra votre pseudo.\n \n Si l'évènement 'Fermeture de Golden' vient à se déclancher, vous serez averti et si vous êtes dans le camp UHC lorsque l'évènement se déclance, vous devrez désormais gagner seul et vos pouvoirs changent\n \n____________________________________________________");

    }

}
