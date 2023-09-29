package fr.gameblack.rcuhcv2.roles.joueur;

import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;

public class Nickoboop {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aNickoboop\n§rVous devez gagner avec le §acamp joueur§r\n \nVous connaissez Jeannot\n \n____________________________________________________");

    }

}
