package fr.gameblack.rubisuhc.roles.demons;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Slup {

	public static void Items(Player player) {
		
		Texte(player);
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 0, false, false));
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes §cSlup\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet résistance I permanent et force I la nuit\n \nVous pouvez communiquer avec Trial avec la commande /rcmsg\n \nVous êtes averti à chaque fois qu'un joueur utilise son pouvoir\n \nSi un démon reste 5 minutes proche de vous, vous recevrez son pseudo\nIl y a 20% de chance que le pseudo sois remplacer par le message 'Vous avez un mauvais pressentiment' (si le role kzou reste proche de vous, vous recevrez forcément ce message)\n \n____________________________________________________");
		
	}
	
}
