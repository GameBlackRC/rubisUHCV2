package fr.gameblack.rcuhcv2.evenement;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;

public class Minerais {
	
	public static void spawn(String type, Main main, Joueur joueur) {
		
		World world = main.getWorld(); // Obtenez le monde où le bloc doit apparaître
		
		if(world == null) {
			
			world = Bukkit.getWorld("world");
			
		}
		
		Random r = new Random();
        int signe_x = r.nextInt(1);
        int signe_z = r.nextInt(1);
        int cos_x = r.nextInt(200);
        cos_x += 150;
        if (signe_x == 1) {
            cos_x = -cos_x;
        }

        int cos_z = r.nextInt(200);
        cos_z += 150;
        if (signe_z == 1) {
            cos_z = -cos_z;
        }
		
        int x = cos_x; // Obtenez une coordonnée X aléatoire
        int z = cos_z; // Obtenez une coordonnée Z aléatoire
        int y = world.getHighestBlockYAt(x, z); // Obtenez la hauteur de la surface à ces coordonnées 

        // Faites apparaître le bloc aléatoire à la surface
        world.getBlockAt(x, y, z).setType(Material.GLOWSTONE); // Remplacez Material.DIAMOND_BLOCK par le bloc que vous souhaitez
		
        int proba_malivol = r.nextInt(100);
        
        if(proba_malivol <= 50 && main.getJoueurByRole(Roles.MALIVOL) != null) {
        	
        	main.getJoueurByRole(Roles.MALIVOL).getPlayer().sendMessage("Un minerais vient d'apparaître. Grâce à votre X-ray, vous l'avez repérer (x: " + cos_x + "; z: " + cos_z + ")");
        	
        }
        
        if(joueur != null) {
        	
        	joueur.getPlayer().sendMessage("Un minerais est apparu en x: " + cos_x + ", y: " + y + " et z: " + cos_z);
        	
        }
        
	}

}
