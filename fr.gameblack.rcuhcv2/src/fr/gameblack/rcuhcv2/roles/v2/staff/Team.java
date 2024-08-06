package fr.gameblack.rcuhcv2.roles.v2.staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Team {
	
	public static void Items(Joueur joueur, Main main) {
		
		Texte(joueur.getPlayer());
        joueur.addSpeed(0.1);
		if(joueur.isBot()) {
			
			joueur.getPlayer().getInventory().setItem(8, Main.getItemRole(ItRoles.TEAM_JUSTICE));
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Team");
			
		}
		else {
			
			if(!main.getScenarios().contains(Scenarios.INTROUVABLE)) {
				joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.TEAM_JUSTICE));
			}
			
		}
		
	}
	
	public static void InteractJusticeStaff(Joueur joueur, Main main) {
		
		if(!joueur.getCD().contains(Pouvoirs.TEAM_JUSTICE)) {
			
			joueur.getCD().add(Pouvoirs.TEAM_JUSTICE);
			joueur.getPlayer().sendMessage("Vous venez d'activer votre pouvoir 'Justice'");
			main.setZoneJusticeActif(true);
			
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
			
			joueur.addSpeed(0.05);
			ItemCD cycle = new ItemCD(main, joueur, "justice_team", 60, joueur, null, null, 0, null);
		    cycle.runTaskTimer(main, 0, 20);
			
		}
		
	}
	
	public static void checkZoneJustice(Main main) {
		
		Joueur team = main.getJoueurByRole(Roles.TEAM);
		
		if(team != null && main.isZoneJusticeActif()) {
			
			List<Joueur> inZone = new ArrayList<>();
			
			for(Entity entity : team.getPlayer().getNearbyEntities(20, 20, 20)) {
				
				if(entity instanceof Player) {
					
					Player pls = (Player) entity;
					Joueur joueur = main.getJoueur(pls);
					
					if(!joueur.isInZoneJustice()) {
						
						joueur.setInZoneJustice(true);
						
						if(main.getMode() != Modes.RAPIDE && (joueur.getCamp() == Camps.STAFF || joueur.getRole() == Roles.TRIAL || joueur.getRole() == Roles.GAMEBLACK)) {
							
							joueur.addSpeed(0.05);
							
						}
						else {
							
							if(joueur.getRole() == Roles.Obscur && main.isAdaptionObscurActif()) {
								
								if(main.getAdaptionAvantObscur().contains(Pouvoirs.TEAM_JUSTICE)) {
		                			
		                			main.getAdaptionPermaObscur().add(Pouvoirs.TEAM_JUSTICE);
		                			joueur.setInZoneJustice(false);
		                			
		                		}
		                		else {
		                			
		                			main.getAdaptionObscur().add(Pouvoirs.TEAM_JUSTICE);
		                			
		                			joueur.removeResi(0.01);
									joueur.removeForce(0.01);
		                			
		                		}
								
							}
							else {
								
								if(joueur.getRole() != Roles.Obscur && !main.getAdaptionPermaObscur().contains(Pouvoirs.TEAM_JUSTICE)) {
									
									joueur.removeResi(0.01);
									joueur.removeForce(0.01);
									
								}
								else {
									
									joueur.setInZoneJustice(false);
									
								}
								
							}
							
						}
						
					}
					
					inZone.add(joueur);
					
				}
				
			}
			
			for(Joueur j : main.getJoueurInGame()) {
				
				if(!inZone.contains(j) && j.isInZoneJustice()) {
					
					j.setInZoneJustice(false);

					if(j.getCamp() == Camps.STAFF || j.getRole() == Roles.TRIAL || j.getRole() == Roles.GAMEBLACK) {
						
						j.removeSpeed(0.05);
						
					}
					else {
						
						j.addResi(0.01);
						j.addForce(0.01);
						
					}
					
				}
				
			}
			
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §9Team\n§r"
        		+ "Vous devez gagner avec le §9camp staff§r\n \n"
        		+ "Vous avez 10% de speed permanent et vous recevez 2% de résistance supplémentaire lorsque vous êtes proche de Farmeurimmo (invisible avec le /rceffet)\n \n"
        		+ "A chaque mort d'un membre du staff proche de vous (dont Trial et GameBlack peut importe leur camp), vous obtenez 1% d'un effet aléatoire (2% si l'effet est speed)\n \n"
        		+ "Avec l'item 'Justice', vous créer une zone de 20 blocs autour de vous pendant 1 minute. Tous les membres du staff (dont Trial et GameBlack peut importe leur camp) reçoivent 5% de speed supplémentaire. Les autres joueurs perdent 1% de force et de résistance dans cette zone\n"
        		+ "Seul vous recevez les messages de mort lorsqu'un joueur meurt dans votre zone\n \n"
        		+ "Vous pouvez retirer votre armure pour devenir invisible. Lorsque vous êtes invisible, vous recevez 20% de speed ainsi que 5% de résistance\n \n"
        		+ "Lorsque vous redevenez visible, vous perder la speed et la résistance supplémentaire et vous perdez 2% de force pendant un certaint temps (30 secondes en mode rapide et 2 minutes dans les autres modes)\n \n"
        		+ "____________________________________________________");

    }

}
