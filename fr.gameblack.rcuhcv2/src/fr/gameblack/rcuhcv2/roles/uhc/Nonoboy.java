package fr.gameblack.rcuhcv2.roles.uhc;

import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;

public class Nonoboy {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §2Nonoboy\n§rVous devez gagner avec le §2camp UHC§r\n \n____________________________________________________");

    }

}
