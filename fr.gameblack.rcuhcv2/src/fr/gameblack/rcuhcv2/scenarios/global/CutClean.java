package fr.gameblack.rcuhcv2.scenarios.global;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class CutClean {
	
	public static void setCutClean(Block bloc) {
		
		Material type = bloc.getType();
		
		if(type == Material.IRON_ORE) {
			
			Bukkit.getWorld("world").getBlockAt(bloc.getLocation()).setType(Material.AIR);
			Bukkit.getWorld("world").dropItemNaturally(bloc.getLocation(), new ItemStack(Material.IRON_INGOT, 1));
			
		} else if(type == Material.GOLD_ORE) {
			
			Bukkit.getWorld("world").getBlockAt(bloc.getLocation()).setType(Material.AIR);
			Bukkit.getWorld("world").dropItemNaturally(bloc.getLocation(), new ItemStack(Material.GOLD_INGOT, 1));
			
		}
		
	}

}
