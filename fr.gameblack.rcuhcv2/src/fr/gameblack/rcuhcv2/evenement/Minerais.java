package fr.gameblack.rcuhcv2.evenement;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class Minerais {
	
	public static void InteractMinerais(Joueur joueur, Material minerais, Location bloc_loc) {
		
		if(minerais == Material.GLOWSTONE) {
			
			if(joueur.getPlayer().getInventory().firstEmpty() == -1) {
				
				joueur.getPlayer().sendMessage("Votre inventaire est plein");
				
			}
			else {
				
				Bukkit.getWorld("world").getBlockAt(bloc_loc).setType(Material.AIR);
				joueur.getPlayer().getInventory().addItem(new ItemStack(Material.GLOWSTONE_DUST, 1));
				
			}
			
		}
		else if (minerais == Material.NETHER_BRICK) {
			
			if(joueur.getPlayer().getInventory().firstEmpty() == -1) {
				
				joueur.getPlayer().sendMessage("Votre inventaire est plein");
				
			}
			else {
				
				Bukkit.getWorld("world").getBlockAt(bloc_loc).setType(Material.AIR);
				joueur.getPlayer().getInventory().addItem(new ItemStack(Material.NETHER_BRICK_ITEM, 1));
				
			}
			
		}
		else if (minerais == Material.QUARTZ_BLOCK) {
			
			if(joueur.getPlayer().getInventory().firstEmpty() == -1) {
				
				joueur.getPlayer().sendMessage("Votre inventaire est plein");
				
			}
			else {
				
				Bukkit.getWorld("world").getBlockAt(bloc_loc).setType(Material.AIR);
				joueur.getPlayer().getInventory().addItem(new ItemStack(Material.QUARTZ, 1));
				
			}
			
		}
		
	}
	
	public static void InteractItemRubis(Joueur joueur, Main main) {
		
		joueur.getPlayer().getInventory().remove(Material.NETHER_BRICK);
		
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
		
		joueur.getPlayer().getInventory().remove(Material.QUARTZ_BLOCK);
		
		Random r = new Random();
        int nb = r.nextInt(3);
        
        if(nb == 1) {
        	
        	joueur.addForce(0.02);
        	
        }
        else if(nb == 2) {
        	
        	joueur.addResi(0.02);
        	
        }
        else {
        	
        	joueur.addSpeed(0.05);
        	
        }
		
	}
	
	public static void InteractItemTopaze(Joueur joueur, Main main) {
		
		joueur.getPlayer().getInventory().remove(Material.GLOWSTONE);
		
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
        
        joueur.getPlayer().sendMessage("Vous avez " + nb_allies + " alliés proche de vous");
		
	}
	
	public static void spawn(String type, Main main, Joueur joueur) {
		
		World world = main.getWorld(); // Obtenez le monde où le bloc doit apparaître
		
		if(world == null) {
			
			world = Bukkit.getWorld("world");
			
		}
		
		Random r = new Random();
        int signe_x = r.nextInt(2);
        int signe_z = r.nextInt(2);
        int cos_x = r.nextInt(200);
        int nb = r.nextInt(3);
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

        if(nb == 1) {
        
        	world.getBlockAt(x, y, z).setType(Material.GLOWSTONE);
        	
        }
        else if(nb == 2) {
        	
        	world.getBlockAt(x, y, z).setType(Material.QUARTZ_BLOCK);
        	
        }
        else {
        	
        	world.getBlockAt(x, y, z).setType(Material.NETHER_BRICK);
        	
        }
        
        int proba_malivol = r.nextInt(100);
        
        if(proba_malivol <= 50 && main.getJoueurByRole(Roles.MALIVOL) != null) {
        	
        	main.getJoueurByRole(Roles.MALIVOL).getPlayer().sendMessage("Un minerais vient d'apparaître. Grâce à votre X-ray, vous l'avez repérer (x: " + cos_x + "; z: " + cos_z + ")");
        	
        }
        
        if(joueur != null && joueur.isMort()) {
        	
        	joueur.getPlayer().sendMessage("Un minerais est apparu en x: " + cos_x + ", y: " + y + " et z: " + cos_z);
        	
        }
        
        Bukkit.broadcastMessage("Un minerais vient d'apparaitre");
        
	}

}
