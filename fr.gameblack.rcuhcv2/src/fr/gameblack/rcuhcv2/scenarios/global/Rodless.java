package fr.gameblack.rcuhcv2.scenarios.global;

import org.bukkit.Material;
import org.bukkit.event.inventory.CraftItemEvent;

public class Rodless {

	public static void setRodless(CraftItemEvent event) {
		
		Material type = event.getRecipe().getResult().getType();
		
		if(type == Material.FISHING_ROD) {
			
			event.setCancelled(true);
			
		}
		
	}
	
}
