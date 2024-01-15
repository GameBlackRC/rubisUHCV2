package fr.gameblack.rcuhcv2.roles.v2.joueur;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Slup {
	
	public static void Items(Joueur joueur, Main main) {
		
		joueur.addSlime(5);
		
		if(main.getMode() == Modes.RAPIDE) {
			
			joueur.addSpeed(0.07);
			TexteRapide(joueur.getPlayer());

			if(joueur.isBot()) {
				
		        joueur.getPlayer().getInventory().setItem(7, Main.getItemRole(ItRoles.SLUP_SLIME));
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Slup");
				
			}
			else {
				
		        joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.SLUP_SLIME));
				
			}
			
		}
		else {
			
			Texte(joueur.getPlayer());
			
			if(joueur.isBot()) {
				
				joueur.getPlayer().getInventory().setItem(8, Main.getItemRole(ItRoles.SLUP_PACTES));
		        joueur.getPlayer().getInventory().setItem(7, Main.getItemRole(ItRoles.SLUP_SLIME));
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Slup");
				
			}
			else {
				
				joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.SLUP_PACTES));
		        joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.SLUP_SLIME));
				
			}
			
		}
		
	}
	
	public static void commandSlime(Joueur joueur) {
		
		if(joueur.isSlupBonusPalierActif()) {
			
			joueur.setSlupBonusPalierActif(false);
			
			if(joueur.getPalierSlup() == 1) {
				
				joueur.removeForce(0.01);
				
			}
			else if (joueur.getPalierSlup() == 2) {
				
				joueur.removeForce(0.02);
				
			}
			else if(joueur.getPalierSlup() == 3) {
				
				joueur.removeForce(0.03);
				
			}
			else if(joueur.getPalierSlup() == 4) {
				
				joueur.removeForce(0.05);
				
			}
			
			joueur.getPlayer().sendMessage("Vous avez désactiver votre bonus de palier, vos boules de slimes ne seront donc plus consommer");
			
		} else {
			
			joueur.setSlupBonusPalierActif(true);
			
			if(joueur.getPalierSlup() == 1) {
				
				joueur.addForce(0.01);
				
			}
			else if (joueur.getPalierSlup() == 2) {
				
				joueur.addForce(0.02);
				
			}
			else if(joueur.getPalierSlup() == 3) {
				
				joueur.addForce(0.03);
				
			}
			else if(joueur.getPalierSlup() == 4) {
				
				joueur.addForce(0.05);
				
			}
			
			joueur.getPlayer().sendMessage("Vous avez activer votre bonus de palier");
			
		}
		
	}
	
	public static void interactDroitSlime(Joueur joueur, Main main) {
		
		if(!joueur.getCD().contains(Pouvoirs.SLUP_SLIME)) {
			
			joueur.getCD().add(Pouvoirs.SLUP_SLIME);
			
			joueur.getPlayer().sendMessage("Vous venez d'utiliser votre item");
			
			main.setLocZoneSlup(joueur.getPlayer().getLocation());
			
			ItemCD cycle = new ItemCD(main, joueur, "slimezone_slup", 60, joueur, null, null, 0, null);
			cycle.runTaskTimer(main, 0, 20);
			
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
			
		}
		else {
			
			joueur.getPlayer().sendMessage("Ce pouvoir est en cooldown");
			
		}
		
	}
	
	public static void interactGaucheSlime(Joueur joueur) {
		
		if(!joueur.isMalusSlupActif()) {
		
			if(joueur.getPalierSlup() == 0) {
				
				joueur.getPlayer().sendMessage("Vous passez le palier 1");
				
				joueur.setPalierSlup(1);
				joueur.setSlupBonusPalierActif(true);
				joueur.addForce(0.01);
				
			}
			else if(joueur.getPalierSlup() == 1) {
				
				joueur.getPlayer().sendMessage("Vous passez le palier 2");
				
				joueur.setPalierSlup(2);
				if(joueur.isSlupBonusPalierActif()) {
					
					joueur.addForce(0.01);
					
				}
				else {
					
					joueur.setSlupBonusPalierActif(true);
					joueur.addForce(0.01);
					
				}
				
			}
			else if(joueur.getPalierSlup() == 2) {
				
				joueur.getPlayer().sendMessage("Vous passez le palier 3");
				
				joueur.setPalierSlup(3);
				if(joueur.isSlupBonusPalierActif()) {
					
					joueur.addForce(0.01);
					
				}
				else {
					
					joueur.setSlupBonusPalierActif(true);
					joueur.addForce(0.03);
					
				}
				
			}
			else if(joueur.getPalierSlup() == 3 && joueur.getCamp() == Camps.DUO) {
				
				joueur.getPlayer().sendMessage("Vous passez le palier 4");
				
				joueur.setPalierSlup(4);
				if(joueur.isSlupBonusPalierActif()) {
					
					joueur.addForce(0.02);
					
				}
				else {
					
					joueur.setSlupBonusPalierActif(true);
					joueur.addForce(0.05);
					
				}
				
			}
			
		}
		else {
			
			joueur.getPlayer().sendMessage("Tu ne peux pas passer de palier si tu n'as pas de boules de slime");
			
		}
		
	}
	
	public static void interactPacte(Joueur joueur) {
		
		Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Choix du pacte");
    	
        inv_pacte.setItem(11, Main.getItem(Material.APPLE,"Pacte 1", "Vous gagnez avec le camp joueur et recevez 7% de speed"));
        inv_pacte.setItem(15, Main.getItem(Material.NETHERRACK, "Pacte 2", "Si vous trouvez Trial avant 50 minutes avec la commande /rctrial, vous gagnez en duo avec lui"));

        joueur.getPlayer().openInventory(inv_pacte);
		
	}
	
	public static void CommandTrial(Joueur joueur, Joueur cible, Main main) {
	
		if(joueur.getPacteSlup() == 2) {
		
			if(cible.getRole() == Roles.TRIAL && cible.getCamp() != Camps.SOLOS) {
				
				cible.setCamp(Camps.DUO);
				joueur.setCamp(Camps.DUO);
				joueur.getPlayer().sendMessage("Vous avez trouvé Trial, vous devez désormais gagner ensemble");
				joueur.addResi(0.02);
				joueur.addSpeed(0.05);
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
			else {
				
				joueur.getPlayer().sendMessage("Vous n'avez pas trouvé Trial, vous devez donc gagner avec le camp joueur");
				
			}
			
		}
		
	}
	
	public static void fakeMort(Joueur joueur, Main main) {
			
		joueur.hide(main);
		Bukkit.broadcastMessage("_________________________\n" + joueur.getPlayer().getName() + " est mort. Il était : \n" + joueur.getCamp().getCouleur() + joueur.getRole().getTxt() + "§r\n_________________________");
		joueur.setInvulnerable(true);
		joueur.setInvisible(true);
		
		if(main.getMode() == Modes.RAPIDE) {
			
			ItemCD cycle = new ItemCD(main, joueur, "fakemort_slup", 30, joueur, null, null, 0, null);
			cycle.runTaskTimer(main, 0, 20);
			
		}
		else {
		
			ItemCD cycle = new ItemCD(main, joueur, "fakemort_slup", 300, joueur, null, null, 0, null);
			cycle.runTaskTimer(main, 0, 20);
			
		}
		
	}
	
	public static void choixPacte1(Joueur joueur) {
		
		if(joueur.getPacteSlup() == 0) {
			
			joueur.setPacteSlup(1);
			joueur.addSpeed(0.07);
			
		}
		
	}
	
	public static void choixPacte2(Joueur joueur) {
		
		if(joueur.getPacteSlup() == 0) {
			
			joueur.setPacteSlup(2);
			
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §aSlup\n§r"
        		+ "Vous devez gagner avec le §acamp joueur§r\n \n"
        		+ "A l'annonce des rôles, vous recevez un item nommé '§ePacte§r' vous permettant de choisir entre 2 pactes :\n "
        		+ "- Pacte 1 : Vous gagnez avec le §acamp joueur§r et recevez §17% de speed supplémentaire§r\n"
        		+ "- Pacte 2 : Si vous trouvez §9Trial§r avant 50 minutes de jeu avec la commande §b/rctrial <pseudo>§r, vous gagnez §5en duo§r avec lui et recevez §12% de résistance et 5% de speed§r proche de §9Trial§r sinon vous restez dans le §acamp joueur§r\n \n"
        		+ "Si vous avez choisi le pacte 2, de la 40ème à la 45ème minutes, vous recevez un message toutes les minutes vous informant si vous êtes proche de §9Trial§r. Si §9Loup§r vient à mourir avant 50 minutes et que vous avez choisis le pacte 2, vous gagnez avec §9Trial§r et vous recevez §12% de résistance et 5% de speed§r proche de §9Trial§r\n \n"
        		+ "Avec la commande §b/rcmort§r, vous devenez §1invisible§r pendant 5 minutes. Durant ce laps de temps vous êtes invulnérable et vous ne pouvez mettre aucun coup. Votre message de mort apparait dans le chat et vous serez §1invisible§r dans la liste des joueurs (TAB) pendant que vous êtes §1invisible§r\n \n"
        		+ "A l'annonce des rôles, vous recevez un item nommé '§eSlimetification§r'.\n  "
        		+ "Avec un clique gauche sur cet item, vous pouvez augmenter votre palier de force. Si vous n'avez plus assez de boules de slimes, vous perdez votre bonus et perdez de la speed en fonction du palier\n  "
        		+ "Avec un clique droit sur cet item, vous créez une zone de 20 blocs. Tous les joueurs à l'intérieur ne fesant pas partie de votre camp (joueur ou duo) perdront §15% de speed§r. Deplus, vous avez 20% de chance d'éviter les coups reçu. La zone dure 1 minute\n \n"
        		+ "____________________________________________________");

    }
	
	public static void TexteRapide(Player player) {
		
        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §aSlup\n§r"
        		+ "Vous devez gagner avec le §acamp joueur§r\n \n"
        		+ "Avec la commande §b/rcmort§r, vous devenez §1invisible§r pendant 30 secondes. Durant ce laps de temps vous êtes invulnérable et vous ne pouvez mettre aucun coup. Votre message de mort apparait dans le chat et vous serez §1invisible§r dans la liste des joueurs (TAB) pendant que vous êtes §1invisible§r\n \n"
        		+ "A l'annonce des rôles, vous recevez un item nommé '§eSlimetification§r'.\n  "
        		+ "Avec un clique gauche sur cet item, vous pouvez augmenter votre palier de force. Si vous n'avez plus assez de boules de slimes, vous perdez votre bonus et perdez de la speed en fonction du palier\n  "
        		+ "Avec un clique droit sur cet item, vous créez une zone de 20 blocs. Tous les joueurs à l'intérieur perdront §15% de speed§r. Deplus, vous avez 20% de chance d'éviter les coups reçu. La zone dure 1 minute\n \n"
        		+ "____________________________________________________");
		
	}

}
