package fr.gameblack.rcuhcv2.roles.v2.joueur;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

public class Nickoboop {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		if(joueur.isBot()) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Nickoboop");
			
		}
		
	}
	
	public static void checkProcheJeannot(Joueur joueur, Main main) {
		
		if(joueur.isProche(Roles.JEANNOT, main) && !joueur.isNickoProcheJeannot()) {
			
			joueur.addResi(0.02);
			joueur.setNickoProcheJeannot(true);
			
		}
		else if (!joueur.isProche(Roles.JEANNOT, main) && joueur.isNickoProcheJeannot()){
			
			joueur.removeResi(0.02);
			joueur.setNickoProcheJeannot(false);
			
		}
		
	}
	
	public static void CommandPapier(Joueur joueur, Joueur cible, Main main) {
		
		main.getSpecNicko().add(cible);
			
		if(cible.isBonPapiers()) {
				
			joueur.getPlayer().sendMessage("Les papiers de ce joueurs sont bons");
			cible.getPlayer().sendMessage("Vos papiers sont bons, bienvenue patriot");
				
		}
		else {
				
			joueur.getPlayer().sendMessage("Les papiers de ce joueurs sont faux");
			if(cible.getCamp() == Camps.SOLOS || cible.getCamp() == Camps.FARMEURIMMO) {
					
				cible.getPlayer().sendMessage("Nickoboop a inspecté vos faux papiers");
					
			}
				
		}
		
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
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §aNickoboop\n§r"
        		+ "Vous devez gagner avec le §acamp joueur§r\n \nAvec la commande §b/rcpapier§r, vous pouvez, une fois par épisode, regarder les papiers d'un joueur\n \n"
        		+ "Vous recevez §12% de résistance§r proche de §aJeannot§r\n \n"
        		+ "Vous connaissez §aJeannot§r\n \n"
        		+ "____________________________________________________");

    }

}
