package fr.gameblack.rcuhcv2.roles.solo;

import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;

public class Kzou {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §6Kzou\n§rVous devez gagner §6seul§r\n \nVous avez l'effet speed I permanent, résistance I de jour et 2 coeurs supplémentaires\n \nAvec la commande /rcdisperse <pseudo>, vous pouvez téléporter un joueur aléatoirement sur la map\n \nAvec la commande /rcban <pseudo>, vous enfermez le joueur dans une cage en bedrock pendant 30 secondes\n \nEn sortant de la cage, le joueur reçoit l'effet faiblesse I pendant 1 minute\n \nA chaque ban que vous faites, vous avez 20% de chance de recevoir l'effet faiblesse I pendant 30 secondes\n \nAvec la commande /rcop, vous pouvre, 2 fois par partie avant que le message de mort s'affiche, changer le rôle du joueur mort (un autre rôle en vie seras choisi aléatoirement et vous recevrez le véritable rôle du joueur)\n \n____________________________________________________");

    }
	
}
