package fr.gameblack.rubisuhc.orbes;

import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.task.ItemCD;

public class Feu {
	
	public static void Effets(Player player, Main main) {
		
		main.changeStatutOrbe(player, true);
		player.setMaxHealth(player.getMaxHealth() + 2);
		
	}
	
	public static void RemoveEffets(Player player, Main main) {
		
		main.changeStatutOrbe(player, false);
		
		player.setMaxHealth(player.getMaxHealth() - 2);
		
	}
	
	public static void Malus(Player player, Main main) {
		
		RemoveEffets(player, main);
		main.removePourcentEffet(player, "resi", 0.05);
		main.setMalusOrbe(player, true);
		ItemCD cycle = new ItemCD(main, player, "feu_malus", 60, player, null, null);
		cycle.runTaskTimer(main, 0, 20);
		
	}
	
}
