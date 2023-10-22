package fr.gameblack.rcuhcv2.roles.staff;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Classe;
import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class GameBlack {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
		ItemStack orbes = new ItemStack(Material.SLIME_BALL);
    	
    	ItemMeta orbesM = orbes.getItemMeta();
    	orbesM.setDisplayName("§4Orbe");
    	orbes.setItemMeta(orbesM);
		
		joueur.addSpeed(0.05);
		joueur.getPlayer().getInventory().addItem(orbes);
		
	}
	
	public static void ItemsUHC(Joueur joueur, Main main) {
		
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Fuite");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);
        
        TexteUHC(joueur.getPlayer());
        
        Random r = new Random();
        int nb = r.nextInt(100);
        
        if(nb <= 10) {
        	
        	joueur.getPlayer().sendMessage("Vous êtes touché par la malédiction de Gyomei");
        	joueur.addSpeed(0.02);
        	joueur.addSpeed(0.02);
        	
        	int nb_2 = r.nextInt(main.getListJoueurs().size());
        	while(main.getListJoueurs().get(nb_2).getCamp() == "uhc") {
        		
        		nb_2 = r.nextInt(main.getListJoueurs().size());
        		
        	}
	        main.setMaledictionGyomei(main.getListJoueurs().get(nb_2));
	        main.getMaledictionGyomei().getPlayer().sendMessage("Vous venez de recevoir " + joueur.getPlayer().getName() + " pour cible. SI vous parvenez à le tuer, vous recevrez 2% de force supplémentaire");
        	
        }
		
	}
	
	public static void bedwarsLancement(Joueur joueur, Joueur adv, Main main) {
		
		generationLit(main);
		joueur.getPlayer().sendMessage("Vous lancez une partie de Bedwars avec " + adv.getPlayer().getName());
		adv.getPlayer().sendMessage("Vous lancez une partie de Bedwars avec GameBlack");
		joueur.setRespawn(true);
		adv.setRespawn(true);
		main.setAdvBedwars(adv);
		
	}
	
	public static void itemJoueur(Joueur joueur, Main main) {
		
		if(main.getModeTrial().equalsIgnoreCase("fun")) {
			
			if(main.getCampJoueur().size() >= main.getCampStaff().size() || main.getCampJoueur().size() >= main.getCampUHC().size()) {
				
				if(joueur.getOrbe() == Orbe.GLACE || joueur.getOrbe() == Orbe.FEU) {
					
					joueur.setSpeed(1.05);
					
				}
				else if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbeActif()) {
					
					joueur.setSpeed(1.1);
					
				}
				else if(joueur.getOrbe() == Orbe.FOUDRE && joueur.isOrbeActif()) {
					
					joueur.setSpeed(1.11);
					
				}
				
			}
			
			Random r = new Random();
	        int nb = r.nextInt(2);
	        
	        Joueur adv = null;
	        
	        List<Joueur> staff = main.getCampStaff();
	        List<Joueur> uhc = main.getCampUHC();
	        
	        if(!uhc.isEmpty() && (nb == 1 || staff.isEmpty())) {
	        	
	        	int nb2 = r.nextInt(uhc.size());
	        	adv = uhc.get(nb2);
	        	
	        }
	        else if(!staff.isEmpty()){
	        	
	        	int nb2 = r.nextInt(staff.size());
	        	adv = staff.get(nb2);
	        	
	        }
			
			bedwarsLancement(joueur, adv, main);
			
		}
		
	}
	
	public static void litGBCasser(Joueur joueur, Main main) {
		
		suppressionLit(main);
		
		if(main.getJoueurByRole(Roles.GAMEBLACK) != null) {
			
			Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
			
			if(joueur == main.getAdvBedwars()) {
				
				Random r = new Random();
		        int nb = r.nextInt(3);
		        
		        if(nb == 1) {
		        	
		        	joueur.addResi(0.03);
		        	
		        }
		        else if(nb == 2) {
		        	
		        	joueur.addForce(0.03);
		        	
		        }
		        else {
		        	
		        	joueur.addSpeed(0.05);
		        	
		        }
				
			}
			else {
				
				Random r = new Random();
		        int nb = r.nextInt(3);
		        
		        if(nb == 1) {
		        	
		        	gb.removeResi(0.03);
		        	
		        }
		        else if(nb == 2) {
		        	
		        	gb.removeForce(0.03);
		        	
		        }
		        else {
		        	
		        	gb.removeSpeed(0.05);
		        	
		        }
				
			}
			
			main.getAdvBedwars().setRespawn(false);
			gb.setRespawn(false);
			
		}
		
	}
	
	public static void litAutreCasser(Joueur joueur, Main main) {
		
		suppressionLit(main);
		
		if(main.getJoueurByRole(Roles.GAMEBLACK) != null) {
			
			if(joueur.getRole() == Roles.GAMEBLACK) {
				
				Random r = new Random();
		        int nb = r.nextInt(3);
		        
		        if(nb == 1) {
		        	
		        	joueur.addResi(0.05);
		        	
		        }
		        else if(nb == 2) {
		        	
		        	joueur.addForce(0.05);
		        	
		        }
		        else {
		        	
		        	joueur.addSpeed(0.10);
		        	
		        }
				
			}
			else {
				
				Random r = new Random();
		        int nb = r.nextInt(3);
		        
		        if(nb == 1) {
		        	
		        	main.getAdvBedwars().removeResi(0.03);
		        	
		        }
		        else if(nb == 2) {
		        	
		        	main.getAdvBedwars().removeForce(0.03);
		        	
		        }
		        else {
		        	
		        	main.getAdvBedwars().removeSpeed(0.05);
		        	
		        }
				
			}
			
		}
		main.getAdvBedwars().setRespawn(false);
		main.getJoueurByRole(Roles.GAMEBLACK).setRespawn(false);
		
	}
	
	public static void InteractFuite(Joueur joueur, Main main) {
		
		if(!main.getCD().contains(Pouvoirs.GAMEBLACK_FUITE)) {
			
			joueur.setInvulnerable(true);
			joueur.addSpeed(0.1);
			for(Entity entity : joueur.getPlayer().getNearbyEntities(10, 10, 10)) {
				
				if(entity instanceof Player) {
					
					Player p = (Player) entity;
					
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100 , 0));
					
				}
				
			}
			
			main.getCD().add(Pouvoirs.GAMEBLACK_FUITE);
			
			ItemCD cycle = new ItemCD(main, joueur, "fuite", 60, joueur, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
		}
		else {
			
			joueur.getPlayer().sendMessage("Ce pouvoir est en cooldown");
			
		}
		
	}
	
	public static void commandChangeOrbe(Joueur joueur) {
		
		Inventory inv_orbe = Bukkit.createInventory(null, 27, "§8Choix de l'orbe");
    	
        inv_orbe.setItem(10, Main.getItem(Material.WATER_BUCKET, "Eau", ""));
        inv_orbe.setItem(12, Main.getItem(Material.LAVA_BUCKET, "Feu", ""));
        inv_orbe.setItem(14, Main.getItem(Material.ICE, "Glace", ""));
        inv_orbe.setItem(16, Main.getItem(Material.REDSTONE_BLOCK, "Foudre", ""));

        joueur.getPlayer().openInventory(inv_orbe);
		
	}
	
	public static void commandCheckOrbe(Joueur joueur, Joueur cible) {
		
		String orbe = null;
		
		if(cible.getOrbe() == Orbe.EAU) {
			
			orbe = "§1orbe d'eau";
			
		}
		else if(cible.getOrbe() == Orbe.FEU) {
			
			orbe = "§corbe de feu";
			
		}
		else if(cible.getOrbe() == Orbe.GLACE) {
			
			orbe = "§borbe de glace";
			
		}
		else if(cible.getOrbe() == Orbe.FOUDRE) {
			
			orbe = "§eorbe de foudre";
			
		}
		
		if(orbe == null) {
			
			joueur.getPlayer().sendMessage(cible.getPlayer().getName() + " ne possède pas d'orbe");
			
		}
		else {
			
			joueur.getPlayer().sendMessage(cible.getPlayer().getName() + " possède l'" + orbe);
			
		}
		
	}
	
	public static void CommandeClasse(Joueur joueur, Classe classe, Main main) {
		
		if(joueur.getClasseGB() == Classe.ATTAQUANT) {
			
			joueur.removeForce(0.1);
			joueur.addResi(0.07);
			
		}
		else if(joueur.getClasseGB() == Classe.DEFENSEUR) {
			
			joueur.addSpeed(0.15);
			joueur.removeResi(0.07);
			
		}
		else if(joueur.getClasseGB() == Classe.DISTANCE) {
			
			joueur.removeSpeed(0.05);
			joueur.addForce(0.1);
			
		}
		else if(joueur.getClasseGB() == Classe.RAPIDE) {
			
			joueur.removeSpeed(0.25);
			joueur.addForce(0.03);
			joueur.setAbso(true);
			
		}
		else if(joueur.getClasseGB() == Classe.SUPPORT) {
			
			joueur.removeSpeed(0.05);
			joueur.addResi(0.02);
			
		}
		
		if(joueur.getClasseGB() == Classe.ATTAQUANT) {
			
			joueur.addForce(0.1);
			joueur.removeResi(0.07);
			joueur.getPlayer().sendMessage("Vous avez choisi la classe attaquant");
			
		}
		else if(joueur.getClasseGB() == Classe.DEFENSEUR) {
			
			joueur.removeSpeed(0.15);
			joueur.addResi(0.07);
			joueur.getPlayer().sendMessage("Vous avez choisi la classe defenseur");
			
		}
		else if(joueur.getClasseGB() == Classe.DISTANCE) {
			
			joueur.addSpeed(0.05);
			joueur.removeForce(0.1);
			joueur.getPlayer().sendMessage("Vous avez choisi la classe distance");
			
		}
		else if(joueur.getClasseGB() == Classe.RAPIDE) {
			
			joueur.addSpeed(0.25);
			joueur.removeForce(0.03);
			joueur.setAbso(false);
			joueur.getPlayer().sendMessage("Vous avez choisi la classe rapide");
			
		}
		else if(joueur.getClasseGB() == Classe.SUPPORT) {
			
			joueur.addSpeed(0.05);
			joueur.removeResi(0.02);
			joueur.getPlayer().sendMessage("Vous avez choisi la classe support");
			
		}
		else {
			
			joueur.getPlayer().sendMessage("Vous n'avez plus d'effets de classes");
			
		}
		
	}
	
	public static void CommandeBuff(Joueur joueur, Joueur cible, String buff, Main main) {
		
		if(buff.equalsIgnoreCase("coeur")) {
			
			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-2);
			cible.getPlayer().setMaxHealth(cible.getPlayer().getMaxHealth()+2);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_coeur", 60, cible, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		else if(buff.equalsIgnoreCase("force")) {
			
			joueur.removeForce(0.02);
			cible.addForce(0.02);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_force", 60, cible, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		else if(buff.equalsIgnoreCase("resi")) {
			
			joueur.removeResi(0.02);
			cible.addResi(0.02);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_resi", 60, cible, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		else if(buff.equalsIgnoreCase("speed")) {
			
			joueur.removeSpeed(0.05);
			cible.addSpeed(0.05);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_speed", 60, cible, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		
	}
	
	public static void suppressionLit(Main main) {
        
		//Lit GB
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, 201)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, 200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, 201)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, 200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, 199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, 202)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, 201)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, 200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, 201)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, 200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, 200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, 201)).setType(Material.AIR);
        
        //Lit adv
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -198)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -201)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -200)).setType(Material.AIR);
        
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 98, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 102, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 98, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 102, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -198)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -198)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -201)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -201)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 101, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 99, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 101, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 99, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 101, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 99, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 101, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 99, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 202, 100, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 202, 100, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 198, 100, -199)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 198, 100, -200)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -198)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -198)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -201)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -201)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -202)).setType(Material.AIR);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -197)).setType(Material.AIR);
		
	}
	
	@SuppressWarnings("deprecation")
	public static void generationLit(Main main) {
		
		Block bloc1 = Bukkit.getWorld("world").getBlockAt(new Location(Bukkit.getWorld("world"), 200, 100, 200));
		
		Block bloc2 = Bukkit.getWorld("world").getBlockAt(new Location(Bukkit.getWorld("world"), 200, 100, -200));

        BlockState bedFoot = bloc1.getState();
        BlockState bedHead = bedFoot.getBlock().getRelative(BlockFace.SOUTH).getState();
        bedFoot.setType(Material.BED_BLOCK);
        bedHead.setType(Material.BED_BLOCK);
        bedFoot.setRawData((byte) 0x0);
        bedHead.setRawData((byte) 0x8);
        bedFoot.update(true, false);
        bedHead.update(true, true);
        
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, 201)).setType(Material.OBSIDIAN);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, 200)).setType(Material.OBSIDIAN);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, 201)).setType(Material.OBSIDIAN);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, 200)).setType(Material.OBSIDIAN);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, 199)).setType(Material.OBSIDIAN);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, 202)).setType(Material.OBSIDIAN);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, 201)).setType(Material.OBSIDIAN);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, 200)).setType(Material.OBSIDIAN);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, 201)).setType(Material.OBSIDIAN);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, 200)).setType(Material.OBSIDIAN);
        
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -200)).setType(Material.WOOD);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -199)).setType(Material.WOOD);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -200)).setType(Material.WOOD);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -199)).setType(Material.WOOD);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -198)).setType(Material.WOOD);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -201)).setType(Material.WOOD);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -200)).setType(Material.WOOD);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -199)).setType(Material.WOOD);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -200)).setType(Material.WOOD);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -199)).setType(Material.WOOD);
        
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 98, -200)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 102, -200)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 98, -199)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 102, -199)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -198)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -198)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -201)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -201)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 101, -200)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 99, -200)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 101, -199)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 99, -199)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 101, -200)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 99, -200)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 101, -199)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 99, -199)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 202, 100, -199)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 202, 100, -200)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 198, 100, -199)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 198, 100, -200)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -198)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -198)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -201)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -201)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -202)).setType(Material.ENDER_STONE);
        main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -197)).setType(Material.ENDER_STONE);
        
        BlockState bedFoot2 = bloc2.getState();
        BlockState bedHead2 = bedFoot2.getBlock().getRelative(BlockFace.SOUTH).getState();
        bedFoot2.setType(Material.BED_BLOCK);
        bedHead2.setType(Material.BED_BLOCK);
        bedFoot2.setRawData((byte) 0x0);
        bedHead2.setRawData((byte) 0x8);
        bedFoot2.update(true, false);
        bedHead2.update(true, true);
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9GameBlack\n§rVous devez gagner avec le §9camp staff§r\n \nVous avez 5% de speed permanent et vous recevez une orbe à l'annonce des rôles\n \nSi vous venez à croiser Malivol avant Team ou Maka, vous passez dans le camp UHC\n \nVous avez 50% de chance de ne pas recevoir le malus de votre orbe\n \nAvec la commande /rcchangeorbe, vous pouvez changer votre orbe\n \nAvec la commande /rccheckorbe <pseudo>, vous pouvez voir quelle orbe possède le joueur ciblé\n \nLorsque Kzou ban un joueur, vous recevez un message vous avertissant du ban et vous avez 25% de chance de connaître le pseudo du banni\n \nAvec la commande /rcconsole, vous pouvez voir la console pendant 30 secondes\nVous recevez un message pour chaque action parmi les suivants : un joueur frappe un autre joueur, un joueur tue un joueur, un joueur a un changemment d'effet, un joueur active son pouvoir.\nChaque action a une certaine chance d'avoir les pseudos brouiller\n \n____________________________________________________");

    }
	
	public static void TexteUHC(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9GameBlack\n§rVous devez gagner avec le §2camp UHC§r\n \nVous avez 5% de speed permanent\n \nSi l'évènement 'Fermeture de Golden' se déclanche, vous avez 50% de chance de passer dans le camp Joueur\n \nVous avez 50% de chance de ne pas recevoir le malus de votre orbe\n \nAvec la commande /rcchangeorbe, vous pouvez changer votre orbe\n \nAvec l'item 'Fuite', vous devenez invulnérable et vous ne pouvez plus mettre de coup pendant 2 secondes\nVous recevez 10% de speed pendant 1 minute\nLes joueur proche de vous recevront l'effet blindness pendant 10 secondes\nSi Toinou est proche de vous lors de l'utilisation, il reçoit 2% de force pendant 1 minute\n \nA chaque coup d'épée subi, vous avez 5% de chance de recevoir 1% de speed supplémentaire permanent\n \n____________________________________________________");

    }
	
	public static void TexteJoueur(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9GameBlack\n§rVous devez gagner avec le §acamp joueur§r\n \nVous avez 5% de speed permanent\n \nSi l'évènement 'Fermeture de Golden' se déclanche, vous avez 50% de chance de passer dans le camp Joueur\n \nVous avez 50% de chance de ne pas recevoir le malus de votre orbe\n \nAvec la commande /rcchangeorbe, vous pouvez changer votre orbe\n \nAvec l'item 'Fuite', vous devenez invulnérable et vous ne poupez plus mettre de coup pendant 2 secondes\nVous recevez 10% de speed pendant 1 minute\nLes joueur proche de vous recevront l'effet blindness pendant 10 secondes\nSi Toinou est proche de vous lors de l'utilisation, il reçoit 2% de force pendant 1 minute\n \nA chaque coup d'épée subi, vous avez 5% de chance de recevoir 1% de speed supplémentaire permanent\n \n____________________________________________________");

    }

}
