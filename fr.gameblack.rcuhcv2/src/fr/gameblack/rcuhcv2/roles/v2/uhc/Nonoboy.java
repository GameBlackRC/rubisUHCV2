package fr.gameblack.rcuhcv2.roles.v2.uhc;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Nonoboy {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		joueur.addForce(0.02);
		
		if(joueur.isBot()) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Nonoboy");
			
		}
		
	}
	
	public static void CommandMaudit(Joueur joueur, Joueur cible1, Joueur cible2, Main main, int niveau) {
    	
    	if(cible1.getCamp() == Camps.UHC && cible2.getCamp() == Camps.UHC) {
    		
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
    	
    		main.getMaudit().add(cible1);
    		main.getMaudit().add(cible2);
    		main.setNiv_maledition(niveau);
    		if(niveau == 1) {
    			
    			if(joueur.getPlayer().getMaxHealth()-2 > 4) {
        			
        			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-2);
        			
        		}
    			else {
    				joueur.getPlayer().sendMessage("Vous ne pouvez pas utilisé la commande");
    				return;
    			}
    			
    			cible1.addForce(0.03);
    			cible2.addForce(0.03);
    			ItemCD cycle = new ItemCD(main, cible1, "maudit_uhc_1", 180, cible2, null, null, 0, null);
                cycle.runTaskTimer(main, 0, 20);
    			
    		}
    		else if(niveau == 2){
    			
    			if(joueur.getPlayer().getMaxHealth()-4 > 4) {
        			
        			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-4);
        			
        		}
    			else {
    				joueur.getPlayer().sendMessage("Vous ne pouvez pas utilisé la commande");
    				return;
    			}
    			
    			cible1.addSpeed(0.1);
    			cible2.addSpeed(0.1);
    			ItemCD cycle = new ItemCD(main, cible1, "maudit_uhc_2", 120, cible2, null, null, 0, null);
                cycle.runTaskTimer(main, 0, 20);
    			
    		}
    		else {
    			
    			if(joueur.getPlayer().getMaxHealth()-6 > 4) {
        			
        			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-6);
        			
        		}
    			else {
    				joueur.getPlayer().sendMessage("Vous ne pouvez pas utilisé la commande");
    				return;
    			}
    			
    			cible1.addForce(0.03);
    			cible1.addSpeed(0.05);
    			cible2.addForce(0.03);
    			cible2.addSpeed(0.05);
    			ItemCD cycle = new ItemCD(main, cible1, "maudit_uhc_3", 120, cible2, null, null, 0, null);
                cycle.runTaskTimer(main, 0, 20);
    			
    		}
    		
    	}
    	else if(cible1.getCamp() == cible2.getCamp()) {
    		
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
    	
    		main.getMaudit().add(cible1);
    		main.getMaudit().add(cible2);
    		main.setNiv_maledition(niveau);
    		if(niveau == 1) {
    			
    			if(joueur.getPlayer().getMaxHealth()-2 > 4) {
        			
        			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-2);
        			
        		}
    			else {
    				joueur.getPlayer().sendMessage("Vous ne pouvez pas utilisé la commande");
    				return;
    			}
    			
    			cible1.removeForce(0.02);
    			cible2.removeForce(0.02);
    			ItemCD cycle = new ItemCD(main, cible1, "maudit_autre_1", 120, cible2, null, null, 0, null);
                cycle.runTaskTimer(main, 0, 20);
    			
    		}
    		else if(niveau == 2){
    			
    			if(joueur.getPlayer().getMaxHealth()-3 > 4) {
        			
        			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-3);
        			
        		}
    			else {
    				joueur.getPlayer().sendMessage("Vous ne pouvez pas utilisé la commande");
    				return;
    			}
    			
    			cible1.removeSpeed(0.07);
    			cible2.removeSpeed(0.07);
    			ItemCD cycle = new ItemCD(main, cible1, "maudit_autre_2", 120, cible2, null, null, 0, null);
                cycle.runTaskTimer(main, 0, 20);
    			
    		}
    		else {
    			
    			if(joueur.getPlayer().getMaxHealth()-4 > 4) {
        			
        			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-4);
        			
        		}
    			else {
    				joueur.getPlayer().sendMessage("Vous ne pouvez pas utilisé la commande");
    				return;
    			}
    			
    			cible1.removeForce(0.02);
    			cible1.removeSpeed(0.05);
    			cible2.removeForce(0.02);
    			cible2.removeSpeed(0.05);
    			ItemCD cycle = new ItemCD(main, cible1, "maudit_autre_3", 60, cible2, null, null, 0, null);
                cycle.runTaskTimer(main, 0, 20);
    			
    		}
    		
    	}
    	else {
    		
    		joueur.getPlayer().sendMessage("Ces 2 joueurs ne font pas parti du même camps");
    		
    	}
    	
    }
	
	public static void CommandMauditRapide(Joueur joueur, Joueur cible1, Main main, int niveau) {
    	
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
		
    	main.getMaudit().add(cible1);
    	main.getMaudit().add(joueur);
    	main.setNiv_maledition(niveau);
    	if(niveau == 1) {
    			
    		if(joueur.getPlayer().getMaxHealth()-2 > 4) {
        			
        		joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-2);
        			
        	}
    		else {
    			joueur.getPlayer().sendMessage("Vous ne pouvez pas utilisé la commande");
    				return;
    		}
    			
    		cible1.removeForce(0.01);
    		ItemCD cycle = new ItemCD(main, joueur, "maudit_rapide_1", 120, cible1, null, null, 0, null);
            cycle.runTaskTimer(main, 0, 20);
    			
    	}
    	else if(niveau == 2){
    			
    		if(joueur.getPlayer().getMaxHealth()-3 > 4) {
        			
        		joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-3);
        			
        		}
    		else {
    			joueur.getPlayer().sendMessage("Vous ne pouvez pas utilisé la commande");
    			return;
    		}
    			
    		cible1.removeSpeed(0.05);
    		ItemCD cycle = new ItemCD(main, joueur, "maudit_rapide_2", 120, cible1, null, null, 0, null);
            cycle.runTaskTimer(main, 0, 20);
    			
    	}
    	else {
    			
    		if(joueur.getPlayer().getMaxHealth()-4 > 4) {
        			
        		joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-4);
        			
        	}
    		else {
    			joueur.getPlayer().sendMessage("Vous ne pouvez pas utilisé la commande");
    			return;
    		}
    			
    		cible1.removeForce(0.01);
    		cible1.removeSpeed(0.05);
    		ItemCD cycle = new ItemCD(main, joueur, "maudit_rapide_3", 60, cible1, null, null, 0, null);
    		cycle.runTaskTimer(main, 0, 20);
    			
    	}
    	
    }
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §2Nonoboy\n§r"
        		+ "Vous devez gagner avec le §2camp UHC§r\n \n"
        		+ "Vous avez 2% de force permanent\n \n"
        		+ "Avec la commande /rcmaudit <pseudo> <pseudo> <niveau>, vous pourrez maudire 2 joueurs du même camps. Le bonus et le malus dépendent du camps et du niveaux :\n \n"
        		+ "Pour le camps UHC :\n"
        		+ "- Niveau 1 : 3% de force supplémentaire pour les 2 joueurs pendant 3 minutes\n"
        		+ "- Niveau 2 : 10% de speed supplémentaire pour les 2 joueurs pendant 2 minutes\n"
        		+ "- Niveau 3 : 3% de force et 5% de speed supplémentaire pour les 2 joueurs pendant 2 minutes\n \n"
        		+ "Pour les autres camps :\n"
        		+ "- Niveau 1 : 2% de force en moins pour les 2 joueurs pendant 2 minutes\n"
        		+ "- Niveau 2 : 7% de speed en moins pour les 2 joueurs pendant 2 minutes\n"
        		+ "- Niveau 3 : 2% de force et 5% de speed en moins pour les 2 joueurs pendant 1 minute\n \n"
        		+ "Vous perdrez des coeurs permanent en fonction du niveau de la malédiction :\n"
        		+ "- Niveau 1 : 1 coeur\n"
        		+ "- Niveau 2 : 1.5 coeurs permanent\n"
        		+ "- Niveau 3 : 2 coeurs permanent\n \n"
        		+ "A chaque kill, vous recevrez 1.5 coeur supplémentaire (maximum : 12 coeurs)\n \n"
        		+ "____________________________________________________");

    }

}
