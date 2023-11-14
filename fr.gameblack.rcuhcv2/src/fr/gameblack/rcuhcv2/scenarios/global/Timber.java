package fr.gameblack.rcuhcv2.scenarios.global;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class Timber {

	public static void breakTree(Block tree){
		if(tree.getType()!=Material.LOG) return;
		
		   tree.breakNaturally();
		   
		   for(BlockFace face: BlockFace.values())
		      breakTree(tree.getRelative(face));
	}
	
}
