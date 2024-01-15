package fr.gameblack.rcuhcv2.roles.v2.staff;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;
import fr.gameblack.rcuhcv2.task.v2.JeuCD;

import java.util.ArrayList;
import java.util.List;

public class Trial {
	
	private static int nbUtilisationCorruption = 0;
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		if(joueur.isBot()) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Trial");
			
		}
		
	}
	
	public static void ItemsSerieux(Joueur joueur) {
		
		joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.TRIAL_COLA));
		joueur.addResi(0.01);
		joueur.addForce(0.01);
		joueur.addSpeed(0.03);
		
	}
	
	public static void ItemsFun(Joueur joueur) {
		
		joueur.addForce(0.02);
		joueur.addSpeed(0.02);
		
	}
	
	public static void ItemsSerieuxSolo(Joueur joueur) {
		
		joueur.setForce(1.01);
		joueur.setSpeed(1.05);
		joueur.setResi(1.11);
		joueur.getPlayer().setMaxHealth(20);
		TexteSoloSerieux(joueur.getPlayer());
		
        joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.TRIAL_BENIHIME));
		
	}
	
	public static void ItemsFunSolo(Joueur joueur) {
		
		TexteSoloFun(joueur.getPlayer());
		
		joueur.setForce(1.01);
		joueur.setSpeed(1.05);
		joueur.setResi(1.11);
		joueur.getPlayer().setMaxHealth(20);
		
        joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.TRIAL_BENIHIME));
        
        joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.TRIAL_SAKASHIMA));
		
	}
	
	public static void InteractBouteille(Joueur joueur) {
		
		if(joueur.getTrialBouteille() > 0) {
			
			joueur.removeTrialBouteille(1);
			joueur.addTrialHydratation(100);
			
		}
		
	}
	
	public static void CommandPlay(Joueur joueur, Joueur cible, Main main) {
		
		Random r = new Random();
        int nb = r.nextInt(2);
        joueur.setInvulnerable(true);
        cible.setInvulnerable(true);
        
        if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
			
			Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
			
            nb = r.nextInt(100);
            
            if(nb <= 80) {
            	
            	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient d'effectuer une commande");
            	
            }
            else {
            	
            	gb.getPlayer().sendMessage("[CONSOLE]" + joueur.getPlayer().getName() + " vient d'effectuer une commande");
            	
            }
			
		}
        
        if(nb == 0) {
        	
        	main.getJoueurJeuTrial().add(joueur);
        	main.getJoueurJeuTrial().add(cible);
        	JeuCD cycle = new JeuCD(main, joueur, cible, "soleil", 33);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage("Le jeu choisi est soleil");
            cible.getPlayer().sendMessage("Vous jouez à 1, 2, 3, soleil avec Trial, ne bougez plus ! Le jeu se lance dans 3 secondes");
			if(main.getScenarios().contains(Scenarios.SON_EN_FOLIE)) {
				Bukkit.getWorld("world").playSound(joueur.getPlayer().getLocation(), Sound.ENDERDRAGON_HIT, 10, 1);
			}
        	
        }
        else { //if(nb == 1) {
        	
        	main.setJeuTrial(JeuxTrial.TAKAONI);
        	main.getJoueurJeuTrial().add(joueur);
        	main.getJoueurJeuTrial().add(cible);
        	JeuCD cycle = new JeuCD(main, joueur, cible, "takaoni", 8);
            cycle.runTaskTimer(main, 0, 20);
            joueur.getPlayer().sendMessage("Le jeu choisi est takaoni");
            cible.getPlayer().sendMessage("Vous jouez à takaoni avec Trial, montez le plus haut possible !");
        	
        }
        //else {
        	
        	//main.setJeuTrial(JeuxTrial.REFLEX);
        	//main.getJoueurJeuTrial().add(joueur);
        	//main.getJoueurJeuTrial().add(cible);
        	//JeuCD cycle = new JeuCD(main, joueur, cible, "reflex", 30);
            //cycle.runTaskTimer(main, 0, 20);
            //joueur.getPlayer().sendMessage("Le jeu choisi est reflex");
            //cible.getPlayer().sendMessage("Vous jouez à reflex avec Trial, cliquez le plus rapidement sur le message qui va apparaître dans le chat !");
        	
        //}
		
	}
	
	public static void FinJeuReflex(Joueur gagnant, Joueur perdant, Main main) {
		
		gagnant.addSpeed(0.05);
		gagnant.addResi(0.02);
		perdant.removeSpeed(0.02);
		ItemCD cycle = new ItemCD(main, gagnant, "speed_reflex_trial", 300, gagnant, null, null, 0, null);
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
			ItemCD cycle = new ItemCD(main, j2, "takaoni_trial", 300, j1, null, null, 0, null);
	        cycle.runTaskTimer(main, 0, 20);
	        j1.setInvulnerable(false);
	    	j2.setInvulnerable(false);
	    	main.setJeuTrial(null);
	    	main.getJoueurJeuTrial().clear();
	    	j2.getPlayer().sendMessage("Vous avez gagner le jeu");
			j1.getPlayer().sendMessage("Vous avez perdu le jeu");
			
		}
		else {
			
			j2.removeForce(0.02);
			j2.getPlayer().setMaxHealth(j2.getPlayer().getMaxHealth()-1);
			j1.setNofall(true);
			j1.addSpeed(0.03);
			ItemCD cycle = new ItemCD(main, j1, "takaoni_trial", 300, j2, null, null, 0, null);
	        cycle.runTaskTimer(main, 0, 20);
	        j1.setInvulnerable(false);
	    	j2.setInvulnerable(false);
	    	main.setJeuTrial(null);
	    	main.getJoueurJeuTrial().clear();
	    	j1.getPlayer().sendMessage("Vous avez gagner le jeu");
			j2.getPlayer().sendMessage("Vous avez perdu le jeu");
			
		}
		
	}
	
	public static void FinJeuSoleil(Joueur gagnant, Joueur perdant, Main main) {
		
		gagnant.getPlayer().sendMessage("Vous avez gagner le jeu, vous pouvez désormais bouger");
		perdant.getPlayer().sendMessage("Vous avez perdu le jeu, vous pouvez désormais bouger");
		perdant.removeSpeed(0.05);
		gagnant.addForce(0.02);
		gagnant.getPlayer().setMaxHealth(gagnant.getPlayer().getMaxHealth()+2);
		ItemCD cycle = new ItemCD(main, gagnant, "soleil_trial", 300, perdant, null, null, 0, null);
        cycle.runTaskTimer(main, 0, 20);
        gagnant.setInvulnerable(false);
    	perdant.setInvulnerable(false);
    	main.setJeuTrial(null);
    	main.getJoueurJeuTrial().clear();
		
	}
	
	public static void ItemSakashimaYokoshima(Joueur joueur, Main main) {
		
		if(joueur.getCD().contains(Pouvoirs.TRIAL_SAKASHIMA)) {
			
			joueur.getPlayer().sendMessage("Vous venez d'activer votre pouvoir 'Sakashima Yokoshima'");
			
			if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
				
				Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
				
				Random r = new Random();
				
	            int nb = r.nextInt(100);
	            
	            if(nb <= 80) {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient d'utiliser un item");
	            	
	            }
	            else {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + joueur.getPlayer().getName() + " vient d'utiliser un item");
	            	
	            }
				
			}
			
			joueur.getCD().contains(Pouvoirs.TRIAL_SAKASHIMA);
		
			List<Joueur> inZone = new ArrayList<>();
			List<Joueur> skin = new ArrayList<>();
			
			for(Entity entity : joueur.getPlayer().getNearbyEntities(45, 45, 45)) {
				
				if(entity instanceof Player) {
					
					Player pls = (Player) entity;
					Joueur j = main.getJoueur(pls);
					
					j.setInZoneSkinTrial(true);
					inZone.add(j);
					skin.add(j);
					
				}
				
			}
			
			for(Joueur j : inZone) {
				
				Random r = new Random();
		        int nb = r.nextInt(skin.size());
		        
		        j.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0, false, false));
		        	        
		        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "skin set " + j.getPlayer().getName() + " " + skin.get(nb).getPlayer().getName());
		        
		        j.getPlayer().teleport(skin.get(nb).getPlayer().getLocation());
				
		        skin.remove(nb);
		        
			}
			
			ItemCD cycle = new ItemCD(main, joueur, "sakashimayokoshima_trial", 90, joueur, null, inZone, 0, null);
	        cycle.runTaskTimer(main, 0, 20);
	        joueur.setInvisible(true);
	        joueur.hide(main);
	        
		}
		
	}
	
	public static void ItemBenihimeAratame(Joueur joueur, Main main) {
		
		if(joueur.getCD().contains(Pouvoirs.TRIAL_BENIHIME)) {
			
			joueur.getPlayer().sendMessage("Vous venez d'activer votre pouvoir 'Benihime Aratame'");
			
			if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
				
				Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
				
				Random r = new Random();
				
	            int nb = r.nextInt(100);
	            
	            if(nb <= 80) {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient d'utiliser un item");
	            	
	            }
	            else {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + joueur.getPlayer().getName() + " vient d'utiliser un item");
	            	
	            }
				
			}
			
			joueur.getCD().add(Pouvoirs.TRIAL_BENIHIME);
		
			main.setZoneBenihimeActif(true);
				
			ItemCD cycle = new ItemCD(main, joueur, "benihimeAratame_trial", 60, joueur, null, null, 0, null);
		    cycle.runTaskTimer(main, 0, 20);
		        
		}
		
	}
	
	public static void checkZoneBenihimeAratame(Main main) {
		
		Joueur trial = main.getJoueurByRole(Roles.TRIAL);
		
		if(trial != null && main.isZoneBenihimeActif()) {
			
			List<Joueur> inZone = new ArrayList<>();
			
			for(Entity entity : trial.getPlayer().getNearbyEntities(20, 20, 20)) {
				
				if(entity instanceof Player) {
					
					Player pls = (Player) entity;
					Joueur joueur = main.getJoueur(pls);
					
					if(!joueur.isInZoneBenihime()) {
						
						joueur.setInZoneBenihime(true);
						joueur.removeForce(0.02);
						trial.addSpeed(0.01);
						trial.addForce(0.01);
						
					}
					
					inZone.add(joueur);
					
				}
				
			}
			
			for(Joueur j : main.getJoueurInGame()) {
				
				if(!inZone.contains(j) && j.isInZoneBenihime()) {
					
					j.setInZoneBenihime(false);
					j.addForce(0.02);
					trial.removeSpeed(0.01);
					trial.removeForce(0.01);
					
				}
				
			}
			
		}
		
	}
	
	public static void commandCorruptionAmes(Joueur joueur, Joueur cible, Main main) {
		
		nbUtilisationCorruption += 1;
		
		cible.setCorrompu(true);
		cible.removeForce(0.02);
		cible.removeSpeed(0.03);
		joueur.getPlayer().sendMessage("Vous venez de corrompre " + cible.getPlayer().getName());
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
		ItemCD cycle = new ItemCD(main, joueur, "corruption_trial", 600, cible, null, null, 0, null);
        cycle.runTaskTimer(main, 0, 20);
		
	}
	
	public static void mortKzou(Joueur joueur, Main main) {
		
		joueur.setRespawnTrial(true);
		joueur.setInvulnerable(true);
		
		Random r = new Random();
        int signe_x = r.nextInt(2);
        int signe_y = r.nextInt(2);
        int cos_x = r.nextInt(400);
        cos_x += 200;
        if (signe_x == 1) {
            cos_x = -cos_x;
        }

        int cos_y = r.nextInt(400);
        cos_y += 200;
        if (signe_y == 1) {
            cos_y = -cos_y;
        }
		
		joueur.getPlayer().teleport(new Location(Bukkit.getWorld("world"), cos_x, 100, cos_y));
		joueur.getPlayer().setMaxHealth(10);
		joueur.getPlayer().setHealth(10);
		
		ItemCD cycle2 = new ItemCD(main, joueur, "respawn", 5, joueur, null, null, 0, null);
        cycle2.runTaskTimer(main, 0, 20);
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §9Trial\n§r"
        		+ "Vous devez gagner avec le §9camp staff§r\n \n"
        		+ "Avec la commande /rcmode <serieux/fun>, vous pouvez choisir votre mode qui définira vos pouvoirs durant la totalité de la partie\n \n"
        		+ "Mode Sérieux :\n"
        		+ "Vous recevez 2% de résistance et 3% de speed permanent\n"
        		+ "A chaque kill effectuer, vous obtenez 2% de force supplémentaire (Slup reçoit aussi 2% de force si vous êtes en duo avec lui)\n"
        		+ "Avec la commande /rcsacrifice <coeur|regen>, vous perdez 4% de force permanent et vous gagnez 1 coeur permanent ou vous régénérer 2 coeurs\n \n"
        		+ "Mode fun :\n"
        		+ "Vous recevez 2% de speed et 2% de force permanent\n \n"
        		+ "Avec la commande /rcplay <pseudo>, vous pouvez lancer un jeu avec un autre joueur (pour voir les jeux et les bonus/malus à recevoir, faites la commande /rcinfo). Vous et le joueur choisi seront invulnérables et ne pourrez pas mettre de coup.\n \n"
        		+ "Lorsque Loup vient à mourrir par un membre du camp UHC, si Slup a choisi le pacte 2 et qu'il n'est pas passé définitivement dans le camp joueur, vous devez gagnez avec lui, vous recevrez le pseudo du tueur de Loup et le tueur de Loup recevra votre pseudo. Sinon vous passez dans le camp UHC et vous recevez le pseudo du tueur de Loup et le tueur recevra votre pseudo.\n \n"
        		+ "Si l'évènement 'Fermeture de Golden' vient à se déclancher, vous serez averti et si vous êtes dans le camp UHC lorsque l'évènement se déclanche, vous devrez désormais gagner seul et vos pouvoirs changent\n \n"
        		+ "____________________________________________________");

    }
	
	public static void TexteSoloFun(Player player) {
		
		player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §6Trial\n§r"
        		+ "Vous devez gagner §6seul§r\n \n"
        		+ "Vous recevez 1% de force et de résistance ainsi que 5% de speed permanent\n \n"
        		+ "Vous recevez un item nommé 'Benihime Aratame' qui vous permet de créer une zone de 20 blocs autour de vous pendant 1 minute.\n"
        		+ "Les joueurs présent dans cette zone ne peuvent pas utiliser leur pouvoir et les pouvoirs actif sont désactiver.\n"
        		+ "Pour chaque joueur dans cette zone, vous recevez 1% de force et 2% de speed\n \n"
        		+ "Avec l'item 'Sakashima Yokoshima', vous créez une zone de 45 blocs pendant 1 minute et 30 secondes.\n"
        		+ "Dans cette zone, vous serez invisible et les autres joueurs auront leur skins et pseudos mélanger dont vous.\n \n"
        		+ "____________________________________________________");
		
	}
	
	public static void TexteSoloSerieux(Player player) {
		
		player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §6Trial\n§r"
        		+ "Vous devez gagner §6seul§r\n \n"
        		+ "Vous recevez 1% de force et de résistance ainsi que 5% de speed permanent\n \n"
        		+ "Vous recevez un item nommé 'Benihime Aratame' qui vous permet de créer une zone de 20 blocs autour de vous pendant 1 minute.\n"
        		+ "Les joueurs présent dans cette zone ne peuvent pas utiliser leur pouvoir et les pouvoirs actif sont désactiver.\n"
        		+ "Pour chaque joueur dans cette zone, vous recevez 1% de force et 2% de speed\n"
        		+ "Avec la commande /rccorruption <pseudo>, vous pouvez corrompre un joueur qui perdra 1% de force ainsi que 3% de speed pendant 10 minutes.\n \n"
        		+ "Les joueurs se trouvant autour du joueur corrompu perdront 1% de force\n"
        		+ "____________________________________________________");
		
	}

	public static int getNbUtilisationCorruption() {
		return nbUtilisationCorruption;
	}

}
