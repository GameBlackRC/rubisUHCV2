package fr.gameblack.rcuhcv2.scenarios.global;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HasteyBoys {

	public static void setHasteyBoys(CraftItemEvent event) {
		
		Material type = event.getRecipe().getResult().getType();
		
		if(type == Material.WOOD_AXE || type == Material.WOOD_PICKAXE || type == Material.WOOD_SPADE || type == Material.STONE_AXE || type == Material.STONE_PICKAXE || type == Material.STONE_SPADE || type == Material.GOLD_AXE || type == Material.GOLD_PICKAXE || type == Material.GOLD_SPADE || type == Material.IRON_AXE || type == Material.IRON_PICKAXE || type == Material.IRON_SPADE ||type == Material.DIAMOND_AXE || type == Material.DIAMOND_PICKAXE || type == Material.DIAMOND_SPADE) {
			
			ItemStack item = event.getRecipe().getResult();
			
			ItemMeta itemM = item.getItemMeta();
			itemM.addEnchant(Enchantment.DIG_SPEED, 3, false);
			itemM.addEnchant(Enchantment.DURABILITY, 1, false);
			item.setItemMeta(itemM);
			event.getInventory().setResult(item);
			
		}
		
	}
	
}
