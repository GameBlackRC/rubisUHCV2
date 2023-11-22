package fr.gameblack.rcuhcv2.orbes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Main;

public class Craft {
	
	public static void setCraft(Main main) {
		
    	ItemStack orbes = new ItemStack(Material.SLIME_BALL);
    	
    	ItemMeta orbesM = orbes.getItemMeta();
    	orbesM.setDisplayName("§4Orbe");
    	orbes.setItemMeta(orbesM);
    	
    	newCraftOrbe("LBW", "%*%", "RBI", orbes, main);
    	newCraftOrbe("LBW", "%*%", "IBR", orbes, main);
    	newCraftOrbe("WBL", "%*%", "IBR", orbes, main);
    	newCraftOrbe("WBL", "%*%", "RBI", orbes, main);
    	
    	newCraftOrbe("L%W", "B*B", "R%I", orbes, main);
    	newCraftOrbe("L%W", "B*B", "I%R", orbes, main);
    	newCraftOrbe("W%L", "B*B", "I%R", orbes, main);
    	newCraftOrbe("W%L", "B*B", "R%I", orbes, main);
    	
    	newCraftOrbe("LBW", "%*%", "RBI", orbes, main);
    	newCraftOrbe("LBW", "%*%", "IBR", orbes, main);
    	newCraftOrbe("WBL", "%*%", "IBR", orbes, main);
    	newCraftOrbe("WBL", "%*%", "RBI", orbes, main);
    	
    	newCraftOrbe("L%W", "B*B", "R%I", orbes, main);
    	newCraftOrbe("L%W", "B*B", "I%R", orbes, main);
    	newCraftOrbe("W%L", "B*B", "I%R", orbes, main);
    	newCraftOrbe("W%L", "B*B", "R%I", orbes, main);
    	
    	newCraftOrbe("BL%", "R*I", "%WB", orbes, main);
    	newCraftOrbe("%LB", "R*I", "BW%", orbes, main);
    	newCraftOrbe("BL%", "I*R", "%WB", orbes, main);
    	newCraftOrbe("%LB", "I*R", "BW%", orbes, main);
    	newCraftOrbe("BR%", "L*W", "%IB", orbes, main);
    	newCraftOrbe("%RB", "L*W", "BI%", orbes, main);
    	newCraftOrbe("BR%", "W*L", "%IB", orbes, main);
    	newCraftOrbe("%RB", "W*L", "BI%", orbes, main);
		
	}
	
	public static void newCraftOrbe(String str1, String str2, String str3, ItemStack orbes, Main main) {
		
		ShapedRecipe craftOrbe = new ShapedRecipe(orbes);
    	
		craftOrbe.shape(str1,str2,str3);
		craftOrbe.setIngredient('L', Material.LAVA_BUCKET);
		craftOrbe.setIngredient('I', Material.ICE);
		craftOrbe.setIngredient('R', Material.REDSTONE_BLOCK);
		craftOrbe.setIngredient('%', Material.IRON_BLOCK);
		craftOrbe.setIngredient('*', Material.DIAMOND);
		craftOrbe.setIngredient('B', Material.OBSIDIAN);
		craftOrbe.setIngredient('W', Material.WATER_BUCKET);
    	main.getServer().addRecipe(craftOrbe);
    	
    	ShapedRecipe craftOrbe2 = new ShapedRecipe(orbes);
    	
		craftOrbe2.shape(str3,str2,str1);
		craftOrbe2.setIngredient('L', Material.LAVA_BUCKET);
		craftOrbe2.setIngredient('I', Material.ICE);
		craftOrbe2.setIngredient('R', Material.REDSTONE_BLOCK);
		craftOrbe2.setIngredient('%', Material.IRON_BLOCK);
		craftOrbe2.setIngredient('*', Material.DIAMOND);
		craftOrbe2.setIngredient('B', Material.OBSIDIAN);
		craftOrbe2.setIngredient('W', Material.WATER_BUCKET);
    	main.getServer().addRecipe(craftOrbe2);
		
	}

}
