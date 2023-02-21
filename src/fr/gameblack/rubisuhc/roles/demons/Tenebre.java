package fr.gameblack.rubisuhc.roles.demons;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;

public class Tenebre {
	
	public static void Items(Player player) {
		
		Texte(player);
		
	}
	
	public static void CommandeNuit(Main main) {
		
		if(!main.isNuitTenebre()) {
		
			main.setNuitTenebre(true);
			
		}
		
	}
	
	public static void CommandeBlind(Player cible, Main main) {
		
		main.getCD().add(Pouvoirs.TENEBRE_BLIND);
		
		cible.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 0, false, false));
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon ténèbre\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet faiblesse I le jour et les effets force I et résistance I la nuit\n \nAvec la commande /rcnuit, vous pourrez, 2 fois dans la partie, transformer le prochain jour en nuit\n \nAvec la commande /rcblind <pseudo>, vous donner à la cible l'effet blindness I pendant 15 secondes\n \nA chaque kill que vous effectuer, vous gagnez 3% de force\n \nVous connaissez Slup\n \n____________________________________________________");
		
	}
	
}
