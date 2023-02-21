package fr.gameblack.rubisuhc.roles.solos;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;

public class Experimental {

	public static void Items(Player player, Main main) {
		
		Texte(player);
		main.addPourcentEffet(player, "force", 0.15);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
		
	}
	
	public static void CommandSacrifice(Player player, Main main) {
		
		main.addPourcentEffet(player, "force", 0.05);
		main.addPourcentEffet(player, "resi", 0.05);
		player.setMaxHealth(player.getMaxHealth() - 2);
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes le §6Démon expérimental\n§rVous devez gagner §6seul§r\n \nVous avez les effets force I, speed I et no fall permanent\n \nA chaque kill que vous faites, vous recevez 5% de speed en plus\n \nAvec la commande /rcsacrifice, vous sacrifiez un coeur permanent pour recevoir 5% de force et de résistance en plus\n \nA chaque coup, vous avez 2% de chance d'immobilisé le joueur taper qui deviendra invunérable (peut être désactiver avec la commande /rcstun)\n \n____________________________________________________");
		
	}
	
}
