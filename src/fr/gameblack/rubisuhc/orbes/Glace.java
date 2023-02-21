package fr.gameblack.rubisuhc.orbes;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.task.ItemCD;

public class Glace {
	
	public static void Effets(Player player, Main main) {
		
		main.changeStatutOrbe(player, true);
		main.addPourcentEffet(player, "resi", 0.05);
		
	}
	
	public static void RemoveEffets(Player player, Main main) {
		
		main.changeStatutOrbe(player, false);
		main.removePourcentEffet(player, "resi", 0.05);
		
	}
	
	public static void Malus(Player player, Main main) {
		
		RemoveEffets(player, main);
		main.removePourcentEffet(player, "force", 0.05);
		main.setMalusOrbe(player, true);
		ItemCD cycle = new ItemCD(main, player, "glace_malus", 60, player, null, null);
		cycle.runTaskTimer(main, 0, 20);
		
	}
	
	public static void Freeze(Player player) {
		
		Random r = new Random();
		int nb = r.nextInt(100);
		
		if(nb <= 5) {
			
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1, false, false));
			
		}
		
	}
	
}
