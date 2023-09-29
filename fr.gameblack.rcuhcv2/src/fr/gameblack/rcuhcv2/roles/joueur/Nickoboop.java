package fr.gameblack.rcuhcv2.roles.joueur;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;

public class Nickoboop {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
	}
	
	public static void checkProcheJeannot(Joueur joueur, Main main) {
		
		boolean jeannotTrouver = false;
		
		for(Entity entity : joueur.getPlayer().getNearbyEntities(20, 20, 20)) {
			
			if(entity instanceof Player) {
				
				Player player = (Player) entity;
				Joueur j = main.getJoueur(player);
				
				if(j.getRole() == Roles.JEANNOT) {
					
					if(!joueur.isNickoProcheJeannot()) {
					
						joueur.addResi(0.03);
						joueur.setNickoProcheJeannot(true);
					
						return;
						
					}
					
					jeannotTrouver = true;
					
				}
				
			}
			
		}
		
		if(!jeannotTrouver && joueur.isNickoProcheJeannot()) {
			
			joueur.setNickoProcheJeannot(false);
			joueur.removeResi(0.03);
			
		}
		
	}
	
	public static void CommandPapier(Joueur joueur, Joueur cible, Main main) {
		
		if(!main.getCD().contains(Pouvoirs.NICKOBOOP_PAPIER)) {
			
			if(cible.isBonPapiers()) {
				
				joueur.getPlayer().sendMessage("Les papiers de ce joueurs sont bons");
				cible.getPlayer().sendMessage("Vos papiers sont bons, bienvenue patriot");
				
			}
			else {
				
				joueur.getPlayer().sendMessage("Les papiers de ce joueurs sont faux");
				if(cible.getCamp() == "solo") {
					
					cible.getPlayer().sendMessage("Nickoboop a inspecté vos faux papiers");
					
				}
				
			}
			
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aNickoboop\n§rVous devez gagner avec le §acamp joueur§r\n \nVous connaissez Jeannot\n \n____________________________________________________");

    }

}
