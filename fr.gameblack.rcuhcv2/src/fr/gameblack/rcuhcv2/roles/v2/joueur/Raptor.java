package fr.gameblack.rcuhcv2.roles.v2.joueur;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Raptor {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
		if(joueur.isBot()) {
			
			joueur.getPlayer().getInventory().setItem(8, Main.getItemRole(ItRoles.RAPTOR_RAGE));
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Raptor");
			
		}
		else {
			
			joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.RAPTOR_RAGE));
			
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §aRaptor\n§r"
        		+ "Vous devez gagner avec le §acamp joueur§r\n \n"
        		+ "A l'annonce des rôles, vous recevez un item nommé '§eRage§r' vous permettant de recevoir §17% de force§r pendant 20 secondes.\n"
        		+ "A la fin du pouvoir, vous recevrez l'effet §1Nausée I §rpendant 20 secondes.\n \n"
        		+ "Lorsque vous subissez 5 coups du même adversaire sans l'avoir toucher, vous activez un cheat qui vous donne un avantage parmi les suivants aléatoirement :\n"
        		+ "- 10% de chance de rien recevoir\n"
        		+ "- 10% de chance d'avoir un anti-kb pendant 10 secondes\n"
        		+ "- 15% de chance de recevoir §15% de force supplémentaire§r pendant 1 minute\n"
        		+ "- 20% de chance de recevoir §13% de force supplémentaire§r pendant 1 minute\n"
        		+ "- 20% de chance de recevoir §13% de resistance supplémentaire§r pendant 1 minute\n"
        		+ "- 25% de chance de recevoir §110% de speed supplémentaire§r pendant 1 minute\n \n"
        		+ "____________________________________________________");

    }
	
	public static void ItemRage(Joueur joueur, Main main) {
		
		if(!joueur.getCD().contains(Pouvoirs.RAPTOR_RAGE)) {
			
			if(!joueur.isPouvoirRaptorActif()) {
				
				joueur.setPouvoirRaptorActif(true);
				
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
			
				joueur.getPlayer().sendMessage("Vous activez votre pouvoir");
				joueur.getCD().add(Pouvoirs.RAPTOR_RAGE);
				joueur.addForce(0.07);
				ItemCD cycle = new ItemCD(main, joueur, "rage_raptor", 20, joueur, null, null, 0, null);
		        cycle.runTaskTimer(main, 0, 20);
	        
			}
			else {
				
				joueur.getPlayer().sendMessage("Votre cheat est actif, vous ne pouvez pas activer votre pouvoir");
				
			}
	        
		}
		else {
			
			joueur.getPlayer().sendMessage("Ce pouvoir est en cooldown");
			
		}
		
	}

	public static void cheat(Joueur joueur, Main main) {
		
		if(!joueur.getCD().contains(Pouvoirs.RAPTOR_CHEAT)) {
			
			if(!joueur.isPouvoirRaptorActif()) {
				
				joueur.setPouvoirRaptorActif(true);
			
				joueur.getCD().add(Pouvoirs.RAPTOR_CHEAT);
			
				Random r = new Random();
		        int nb = r.nextInt(100);
		        
		        if(nb <= 10) {
		        	
		        	//rien
		        	joueur.setPouvoirRaptorActif(false);
		        	
		        }
		        else if(nb <= 20) {
		        	
		        	//anti-kb pendant 5 secondes
		        	joueur.setAntiKB(true);
		        	ItemCD cycle = new ItemCD(main, joueur, "antikb_raptor", 5, joueur, null, null, 0, null);
		            cycle.runTaskTimer(main, 0, 20);
		            joueur.getPlayer().sendMessage("Vous activez votre cheat anti-kb pendant 5 secondes");
		        	
		        }
		        else if(nb <= 35) {
		        	
		        	//10% de force pendant 1min
		        	joueur.addForce(0.05);
		        	ItemCD cycle = new ItemCD(main, joueur, "force_raptor", 30, joueur, null, null, 0, null);
		            cycle.runTaskTimer(main, 0, 20);
		            joueur.getPlayer().sendMessage("Vous activez votre cheat, vous recevez donc 5% de force supplémentaire pendant 30 secondes");
		        	
		        }
		        else if(nb <= 55) {
		        	
		        	//5% de force pendant 1min
		        	joueur.addForce(0.02);
		        	ItemCD cycle = new ItemCD(main, joueur, "5_force_raptor", 60, joueur, null, null, 0, null);
		            cycle.runTaskTimer(main, 0, 20);
		            joueur.getPlayer().sendMessage("Vous activez votre cheat, vous recevez donc 2% de force supplémentaire pendant 1 minute");
		        	
		        }
		        else if(nb <= 75) {
		        	
		        	//5% de resi pendant 1min
		        	joueur.addResi(0.02);
		        	ItemCD cycle = new ItemCD(main, joueur, "resi_raptor", 60, joueur, null, null, 0, null);
		            cycle.runTaskTimer(main, 0, 20);
		            joueur.getPlayer().sendMessage("Vous activez votre cheat, vous recevez donc 2% de résistance supplémentaire pendant 1 minute");
		        	
		        }
		        else {
		        	
		        	//10% de speed pendant 1min
		        	joueur.addSpeed(0.10);
		        	ItemCD cycle = new ItemCD(main, joueur, "speed_raptor", 60, joueur, null, null, 0, null);
		            cycle.runTaskTimer(main, 0, 20);
		            joueur.getPlayer().sendMessage("Vous activez votre cheat, vous recevez donc 10% de speed supplémentaire pendant 1 minute");
		        	
		        }
		        
			}
	        
		}
		
	}
	
}
