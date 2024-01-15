package fr.gameblack.rcuhcv2.utils;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class TreePopulator extends BlockPopulator {
	
	@Override
	public void populate(World world, Random random, Chunk chunk) {
			int amount = random.nextInt(50)+1;  // Amount of trees
		    for (int i = 1; i < amount; i++) {
		        int X = random.nextInt(15);
		        int Z = random.nextInt(15);
		        int Y;
		        for (Y = world.getMaxHeight()-1; chunk.getBlock(X, Y, Z).getType() == Material.AIR; Y--); // Find the highest block of the (X,Z) coordinate chosen.
		        int t = random.nextInt(18);
		        if(t == 1) {
		        	
		        	world.generateTree(chunk.getBlock(X, Y, Z).getLocation(), TreeType.DARK_OAK);
		        	
		        }
		        else {
		        	world.generateTree(chunk.getBlock(X, Y, Z).getLocation(), TreeType.TREE);
		        }// The tree type can be changed if you want.
		    }
	}

}
