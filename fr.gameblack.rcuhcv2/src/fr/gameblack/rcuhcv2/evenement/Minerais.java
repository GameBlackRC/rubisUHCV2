package fr.gameblack.rcuhcv2.evenement;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class Minerais {
	
	public static void InteractMinerais(Joueur joueur, String minerais) {
		
		if(minerais.equalsIgnoreCase("topaze")) {
			
			
			
		}
		
	}
	
	public static void InteractItemRubis(Joueur joueur, Main main) {
		
		Random r = new Random();
        int nb = r.nextInt(3);
        
        if(nb == 1) {
        	
        	joueur.addForce(0.02);
        	ItemCD cycle = new ItemCD(main, joueur, "rubis_force", 60, joueur, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
        	
        }
        else if(nb == 2) {
        	
        	joueur.addResi(0.02);
        	ItemCD cycle = new ItemCD(main, joueur, "rubis_resi", 60, joueur, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
        	
        }
        else {
        	
        	joueur.addSpeed(0.02);
        	ItemCD cycle = new ItemCD(main, joueur, "rubis_speed", 60, joueur, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
        	
        }
		
	}
	
	public static void InteractItemRubisBleu(Joueur joueur, Main main) {
		
		Random r = new Random();
        int nb = r.nextInt(3);
        
        if(nb == 1) {
        	
        	joueur.addForce(0.02);
        	
        }
        else if(nb == 2) {
        	
        	joueur.addResi(0.02);
        	
        }
        else {
        	
        	joueur.addSpeed(0.02);
        	
        }
		
	}
	
	public static void InteractItemTopaze(Joueur joueur, Main main) {
		
		Random r = new Random();
        int nb = r.nextInt(100);
        int nb_2 = r.nextInt(1);
        
        int nb_allies = 0;
        
        for(Entity entity : joueur.getPlayer().getNearbyEntities(20, 20, 20)) {
        	
        	if(entity instanceof Player) {
        		
        		Player player = (Player) entity;
        		Joueur j = main.getJoueur(player);
        		
        		if(j.getCamp() == joueur.getCamp()) {
        			
        			nb_allies += 1;
        			
        		}
        		
        	}
        	
        }
        
        if(nb <= 5) {
        	
        	if(nb_2 == 1) {
        		
        		nb_allies += 1;
        		
        	}
        	else {
        		
        		nb_allies -= 1;
        		
        	}
        	
        }
		
	}
	
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
