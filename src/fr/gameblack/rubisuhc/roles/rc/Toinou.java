package fr.gameblack.rubisuhc.roles.rc;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Toinou {

	public static void Items(Player player) {
		
		Texte(player);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes §aToinou\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet speed I tant que vous n'avez pas kill de démon\n \nA chaque kill du camps démon, il gagne des bonus cumulable (voir les bonus avec la commande /rcbonus)\n \n____________________________________________________");
		
	}
	
	public static void Texte_bonus(Player player) {
		
		player.sendMessage("____________________________________________________\n \nTrial:\nIl gagne l'effet force I permanent\n \nSlup :\nVous gagnez 5% de résistance\n \nMalivol :\nIl récupère son item 'Cheat'\n \nDémon ténèbre :\nGagne 3% de force à chaque kill\n \nDémon du sang :\nGagne la commande /rcsang\n \nDémon cosmos :\nRécupère la zone qui lui donne speed I\n \nDémon enfer :\nIl gagne l'effet résistance au feu I et à 20% de chance de mettre en feu\n \nDémon malédiction :\nIl peut mettre des malédictions de niveau 1 et niveau 2\n \nDémon éléctrique :\nIl gagne l'effet speed I\n \nDémon ange\nIl gagne résistance I\n \nDémon avenir :\nIl gagne une deuxième vie\n \nDémon tronçoneuse :\nIl inflige un saignement de 0.5 pendant 10 secondes\n \nDémon :\nIl gagne les pourcentages que le démon avait");
		
	}
	
}
