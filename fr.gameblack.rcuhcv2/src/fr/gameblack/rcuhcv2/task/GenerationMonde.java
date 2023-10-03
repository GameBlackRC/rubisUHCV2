package fr.gameblack.rcuhcv2.task;

import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

public class GenerationMonde {
	
	WorldCreator world_ = new WorldCreator("uhc").environment(Environment.NORMAL).type(WorldType.NORMAL).generateStructures(true).generator(new CustomChunkGenerator());
	
	World world = world_.createWorld();

}
