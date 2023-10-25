package fr.gameblack.rcuhcv2.roles.joueur;

import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;

public class Nickoboop {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
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
			
		if(cible.isBonPapiers()) {
				
			joueur.getPlayer().sendMessage("Les papiers de ce joueurs sont bons");
			cible.getPlayer().sendMessage("Vos papiers sont bons, bienvenue patriot");
				
		}
		else {
				
			joueur.getPlayer().sendMessage("Les papiers de ce joueurs sont faux");
			if(cible.getCamp() == "solo" || cible.getCamp().equalsIgnoreCase("farmeurimmo")) {
					
				cible.getPlayer().sendMessage("Nickoboop a inspecté vos faux papiers");
					
			}
				
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aNickoboop\n§rVous devez gagner avec le §acamp joueur§r\n \nAvec la commande /rcpapier, vous pouvez, une fois par épisode, regarder les papiers d'un joueur\n \nVous recevez 3% de résistance proche de Jeannot\n \nVous connaissez Jeannot\n \n____________________________________________________");

    }

}
