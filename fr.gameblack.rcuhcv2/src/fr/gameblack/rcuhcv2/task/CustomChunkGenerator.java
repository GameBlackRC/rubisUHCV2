package fr.gameblack.rcuhcv2.task;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;

public class CustomChunkGenerator extends ChunkGenerator {
	
	@Override
    public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
        ChunkData chunkData = createChunkData(world);
        
        generateCustomOre(chunkData, random, x, z);

        // Vérifiez si le chunk se trouve dans la région centrale où vous voulez le biome spécial.
        if (Math.abs(x) <= 200 && Math.abs(z) <= 200) {
            // Remplissez le chunk avec le biome "roofed forest" (exemple).
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    biome.setBiome(i, j, Biome.ROOFED_FOREST);
                }
            }
        }

        return chunkData;
    }
	
	private void generateCustomOre(ChunkData chunkData, Random random, int chunkX, int chunkZ) {
	    // Exemple : génération de diamants personnalisée
	    for (int i = 0; i < 10; i++) { // Modifiez le nombre selon vos besoins
	        int x = chunkX * 16 + random.nextInt(16);
	        int y = random.nextInt(20); // Modifiez la hauteur de génération selon vos besoins
	        int z = chunkZ * 16 + random.nextInt(16);
	        chunkData.setBlock(x, y, z, Material.DIAMOND_ORE);
	    }

	    // Exemple : génération d'or personnalisée
	    for (int i = 0; i < 20; i++) { // Modifiez le nombre selon vos besoins
	        int x = chunkX * 16 + random.nextInt(16);
	        int y = random.nextInt(32); // Modifiez la hauteur de génération selon vos besoins
	        int z = chunkZ * 16 + random.nextInt(16);
	        chunkData.setBlock(x, y, z, Material.GOLD_ORE);
	    }
	}

}
