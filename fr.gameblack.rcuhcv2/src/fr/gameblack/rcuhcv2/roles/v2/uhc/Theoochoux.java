package fr.gameblack.rcuhcv2.roles.v2.uhc;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Theoochoux {
	
	public static void Items(Joueur joueur, Main main) {
        
		if(joueur.isBot()) {
			
			joueur.getPlayer().getInventory().setItem(8, Main.getItemRole(ItRoles.THEOCHOUX_ROLLBACK));
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Theoochoux");
			
		}
		else {
			
			joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.THEOCHOUX_ROLLBACK));
			
		}
        joueur.addSpeed(0.1);
        if(main.getMode() != Modes.RAPIDE) {
        	
        	joueur.addSpeed(0.1);
        	
        }
        Texte(joueur.getPlayer(), main);
		
	}
	
	public static void interactRollback(Main main, Joueur joueur) {
		
		if(!joueur.getCD().contains(Pouvoirs.THEOOCHOUX_ROLLBACK)) {
			
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
			
			joueur.getCD().add(Pouvoirs.THEOOCHOUX_ROLLBACK);
			joueur.getPlayer().teleport(joueur.getTheoochouxLoc());
			joueur.getPlayer().getInventory().setContents(joueur.getTheoochouxInv().getContents());
			joueur.getPlayer().setHealth(joueur.getTheoochouxHP());
			joueur.getPlayer().setFoodLevel(joueur.getTheoochouxFood());
			
		}
		else {
			
			joueur.getPlayer().sendMessage("Ce pouvoir est en cooldown");
			
		}
		
	}
	
	public static void interactRollBackPetit(Main main, Joueur joueur) {
		
		if(!joueur.getCD().contains(Pouvoirs.THEOOCHOUX_MINIROLLBACK)) {
			
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
			
			joueur.getCD().add(Pouvoirs.THEOOCHOUX_MINIROLLBACK);
		
			joueur.getPlayer().teleport(joueur.getTheoochouxLoc3sec());
			
			if(main.getMode() == Modes.RAPIDE) {
				ItemCD cycle3 = new ItemCD(main, joueur, "theoochoux_minirollbackcd", 30, joueur, null, null, 0, null);
		        cycle3.runTaskTimer(main, 0, 20);
			}
			else {
				
				ItemCD cycle3 = new ItemCD(main, joueur, "theoochoux_minirollbackcd", 120, joueur, null, null, 0, null);
		        cycle3.runTaskTimer(main, 0, 20);
				
			}
		
		}
		else {
			
			joueur.getPlayer().sendMessage("Ce pouvoir est en cooldown");
			
		}
		
	}
	
	public static void checkBonus(Main main, Joueur joueur, Joueur victime) {
		
		Random r = new Random();
        int nb = r.nextInt(100);
		
		if(joueur.getStadeTheoochouxBonus() == 2 && nb <= 2) {
			
			joueur.setAntiKB(true);
			ItemCD cycle = new ItemCD(main, joueur, "theo_antikb", 2, joueur, null, null, 0, null);
	    	cycle.runTaskTimer(main, 0, 20);
			
		}
		else if(joueur.getStadeTheoochouxBonus() == 3 && nb <= 4) {
			
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
		
		else if(joueur.getStadeTheoochouxBonus() == 4 && nb <= 6) {
			
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
		else if(joueur.getStadeTheoochouxBonus() == 5 && nb <= 10) {
			
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
		else if(joueur.getStadeTheoochouxBonus() == 6 && nb <= 12) {
			
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
		else if(joueur.getStadeTheoochouxBonus() == 7 && nb <= 14) {
			
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
	
	public static void Texte(Player player, Main main) {
		
		if(main.getMode() == Modes.RAPIDE) {
			
			player.sendMessage("____________________________________________________\n \n"
					+ "Vous êtes §2Theoochoux\n§r"
					+ "Vous devez gagner avec le §2camp UHC§r\n \n"
					+ "Vous avez 10% de speed permanent\n \n"
					+ "Lorsque vous faites un clique gauche sur votre item, vous revenez 3 secondes en arrière (seul la position est affecté) (cooldown : 30sec)\n \n"
					+ "Lorsque vous faites un clique droit sur votre item, vous revenez 5 secondes en arrière (votre position, votre vie, vootre inventaire et votre barre de nourriture sont affecté)\n \n"
					+ "____________________________________________________");
			
		}
		else {

			player.sendMessage("____________________________________________________\n \n"
					+ "Vous êtes §2Theoochoux\n§r"
					+ "Vous devez gagner avec le §2camp UHC§r\n \n"
					+ "Vous avez 20% de speed permanent\n \n"
					+ "Toutes les 5min, vous perdez 2% de speed permanent (vous garderez au minimum 2% de speed)\n \n"
					+ "Plus la partie avance plus vous avez de chance de recevoir un anti-kb ou de vous téléporter sur l'adversaire à chaque coup\n \n"
					+ "Lorsque vous faites un clique gauche sur votre item, vous revenez 3 secondes en arrière (seul la position est affecté) (cooldown : 2min)\n \n"
					+ "Lorsque vous faites un clique droit sur votre item, vous revenez 5 secondes en arrière (votre position, votre vie, vootre inventaire et votre barre de nourriture sont affecté)\n \n"
					+ "Avec la commande /rcinspect <pseudo>, vous recevrez aléatoirement le pourcentage des effets de la cible. Plus la partie avance plus le temps entre l'execution de la commande et la reception des informations seras longue\n \n"
					+ "____________________________________________________");

		}
        
    }

}
