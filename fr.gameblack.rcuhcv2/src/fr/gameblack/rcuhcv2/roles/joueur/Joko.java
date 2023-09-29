package fr.gameblack.rcuhcv2.roles.joueur;

import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;

public class Joko {

	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aJoko\n§rVous devez gagner avec le §acamp joueur§r\n \nVous avez l'effet speed I permanent\n \nA l'annonce des rôles, vous recevez un item nommé '§dSpeedCubing§r' vous permettant de recevoir 10% de speed supplémentaire pendant 1 minute.\nChaque coup que vous mettez pendant ce pouvoir à 2% de chance par rubik's cube, que le joueur taper soit stun\n \nA la fin de votre pouvoir, vous recevez 2% de speed permanent et, si vous avez stun au moins un joueur, vous pourrez, avec la commande /rcsteal, voler 3% de force ou 3% de resistance au premier joueur stun\n \nVous possèdez la commande /rccube qui permet de donner un cube à un joueur (5 minutes de cooldown)\n \n____________________________________________________");

    }
	
}
