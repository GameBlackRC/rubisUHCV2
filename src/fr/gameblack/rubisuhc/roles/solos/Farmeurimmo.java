package fr.gameblack.rubisuhc.roles.solos;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;

public class Farmeurimmo {

	public static void Items(Player player, Main main) {
		
		Texte(player);
		main.addPourcentEffet(player, "force", 0.15);
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 0, false, false));
		player.setMaxHealth(player.getMaxHealth() + 6);
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes §6Farmeurimmo\n§rVous devez gagner §6seul§r\n \nVous avez les effets force I et résistance I permanent et speed II le jour (désactivable avec la commande /rcspeed)\n \nA chaque coup, vous retirez l'absorption du joueur frappé (peut être désactiver avec la commande /rcabso)\n \n____________________________________________________");
		
	}
	
}
