package fr.gameblack.rcuhcv2.roles.staff;

import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;

public class GameBlack {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9GameBlack\n§rVous devez gagner avec le §9camp staff§r\n \nVous connaissez Trial\n \n____________________________________________________");

    }

}
