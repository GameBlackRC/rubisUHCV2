package fr.gameblack.rcuhcv2.roles.staff;

import java.util.List;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;

public class Maka {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 0, false, false));
		
	}
	
	public static void FormeSimp(Joueur joueur, Main main) {
		
		List<Joueur> campStaff = main.getCampStaff();
		
		if(campStaff.size() > 1) {
		
			joueur.setForme("simp");
			
			Random r = new Random();
			
			campStaff.remove(joueur);
			
	        int nb = r.nextInt(campStaff.size());
			
			main.setNeko(campStaff.get(nb));
			
			main.setNbJoueursStaff(campStaff.size());
			
			joueur.getPlayer().sendMessage("Voici le pseudo de Neko : " + main.getNeko().getPlayer().getName());
			
			main.getNeko().getPlayer().sendMessage("Maka vient de passer dans sa forme simp, vous êtes Neko");
			
		}
		else {
			
			joueur.getPlayer().sendMessage("Vous ne pouvez pas passer en forme Simp car il n'y a plus aucun membre du staff");
			
		}
			
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9Maka\n§rVous devez gagner avec le §9camp staff§r\n \nVous avez l'effet résistance au feu permanent\n \nAvec la commande /rcforme, vous pouvez passer en forme simp\nMoins il reste de joueur dans le camp staff lors du changement de forme, plus vous obtiendrez de speed dans les différents cas\n \nTant que vous n'êtes pas en forme simp, vous avez 10% de chance de mettre un joueur en feu, vous recevez aussi 2% de résistance proche de Team et 2% de force (invisible avec le /rceffet) proche de GameBlack\n \nLorsque vous passez en mode simp, un joueur est désigné comme Neko\nLorsque vous êtes proche de Neko, vous et Neko recevez de la speed supplémentaire\nLorsque Neko subi un coup et que vous êtes à plus de 20 blocs, vous recevez le pseudo du joueur lui mettant un coup\nLorsqu'un joueur frappe Neko, il subira 2% de dégâts supplémentaire de votre part pendant 10 secondes\nSi Neko vient à mourrir, vous perdez un coeur permanent toutes les 5 minutes tant que le tueur de Neko n'est pas mort\n si vous parvenez à tuer le tueur de neko, vous retournez à 9 coeurs permanent si vous en avez moins, vous recevez de manière permanente les pourcent de speed reçu proche de Neko et vous recevez 2% de résistance\nSi vous venez à mourrir avant Neko, Neko recevra des pourcent de speed permanent\n \n____________________________________________________");

    }

}
