package fr.gameblack.rcuhcv2.roles.v2.staff;

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

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v2.Classe;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class GameBlack {
	
	public static void Items(Joueur joueur, Main main) {
		
		int test = 0;
		
		ItemStack orbes = new ItemStack(Material.SLIME_BALL);
    	
    	ItemMeta orbesM = orbes.getItemMeta();
    	orbesM.setDisplayName("§4Orbe");
    	orbes.setItemMeta(orbesM);
		
		joueur.addSpeed(0.1);
		joueur.getPlayer().getInventory().addItem(orbes);
		
		if(main.getMode() == Modes.RAPIDE && test == 1) {
			
			Random r = new Random();
	        int nb = r.nextInt(100);
	        
	        if(nb <= 10) {
	        	
	        	Texte(joueur.getPlayer());
	        	joueur.setChoixGbCamp(true);
	    		if(joueur.isBot()) {
	    			
	    			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role GB_staff");
	    			
	    		}
	        	
	        }
	        else if(nb <= 60) {
	        	
	        	ItemsUHC(joueur, main);
	        	joueur.setChoixGbCamp(true);
	    		if(joueur.isBot()) {
	    			
	    			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role GB_uhc");
	    			
	    		}
	        	
	        }
	        else if(nb <= 80) {
	        	
	        	itemJoueurFun(joueur, main);
	    		if(joueur.isBot()) {
	    			
	    			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role GB_fun");
	    			
	    		}
	        	
	        }
	        else {
	        	
	        	itemJoueurSerieux(joueur, main);
	    		if(joueur.isBot()) {
	    			
	    			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role GB_serieux");
	    			
	    		}
	        	
	        }
			
		}
		else {
			
			Texte(joueur.getPlayer());
			
		}
		
	}
	
	public static void ItemsUHC(Joueur joueur, Main main) {
        
        if(joueur.isBot()) {
        	
        	joueur.getPlayer().getInventory().setItem(8, Main.getItemRole(ItRoles.GAMEBLACK_FUITE));
        	
        }
        else {
        	
        	joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.GAMEBLACK_FUITE));
        	
        }
        
        TexteUHC(joueur.getPlayer());
        
        Random r = new Random();
        int nb = r.nextInt(100);
        
        if(nb <= 10 && main.getJoueurInCamp(Camps.UHC).size() < main.getJoueurInGame().size()) {
        	
	        	joueur.getPlayer().sendMessage("Vous êtes touché par la malédiction de Gyomei");
	        	joueur.addSpeed(0.02);
	        	joueur.addResi(0.02);
	        	
	        	int nb_2 = r.nextInt(main.getListJoueurs().size());
	        	while(main.getListJoueurs().get(nb_2).getCamp() == Camps.UHC) {
	        		
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
	
	public static void itemJoueurFun(Joueur joueur, Main main) {
		
		TexteJoueurFun(joueur.getPlayer());
		
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
	
	public static void itemJoueurSerieux(Joueur joueur, Main main) {
		
		joueur.removeSpeed(0.1);
		TexteJoueurSerieux(joueur.getPlayer());
		
	}
	
	public static void itemJoueur(Joueur joueur, Main main) {
		
		if(main.getJoueurByRole(Roles.TRIAL).getModeTrial().equalsIgnoreCase("fun")) {
			
			joueur.setModeTrial("fun");
			itemJoueurFun(joueur, main);
			
		}
		else {
			
			joueur.setModeTrial("serieux");
			itemJoueurSerieux(joueur, main);
			
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
		
		if(!joueur.getCD().contains(Pouvoirs.GAMEBLACK_FUITE)) {
			
			joueur.getPlayer().sendMessage("Vous activez votre pouvoir");
			
			joueur.setInvulnerable(true);
			joueur.addSpeed(0.1);
			for(Entity entity : joueur.getPlayer().getNearbyEntities(10, 10, 10)) {
				
				if(entity instanceof Player) {
					
					Player p = (Player) entity;
					
					Joueur j = main.getJoueur(p);
					
					if(j.getRole() == Roles.Obscur && main.isAdaptionObscurActif()) {
						
						if(main.getAdaptionAvantObscur().contains(Pouvoirs.GAMEBLACK_FUITE)) {
                			
                			main.getAdaptionPermaObscur().add(Pouvoirs.GAMEBLACK_FUITE);
                			
                		}
                		else {
                			
                			main.getAdaptionObscur().add(Pouvoirs.GAMEBLACK_FUITE);
                			
                			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100 , 0));
                			
                		}
						
					}
					else {
						
						if(joueur.getRole() != Roles.Obscur && !main.getAdaptionPermaObscur().contains(Pouvoirs.GAMEBLACK_FUITE)) {
							
							p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100 , 0));
							
						}
						
					}
					
				}
				
			}
			
			if(joueur.isProche(Roles.TOINOU, main)) {
				
				main.getJoueurByRole(Roles.TOINOU).addForce(0.01);
				
				ItemCD cycle = new ItemCD(main, joueur, "fuite", 60, joueur, null, null, 1, null);
		        cycle.runTaskTimer(main, 0, 20);
				
			}
			else {
				
				ItemCD cycle = new ItemCD(main, joueur, "fuite", 60, joueur, null, null, 0, null);
		        cycle.runTaskTimer(main, 0, 20);
				
			}
			
			joueur.getCD().add(Pouvoirs.GAMEBLACK_FUITE);
	        
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
			
			joueur.addSpeed(0.20);
			joueur.removeResi(0.07);
			
		}
		else if(joueur.getClasseGB() == Classe.DISTANCE) {
			
			joueur.removeSpeed(0.05);
			joueur.addForce(0.1);
			
		}
		else if(joueur.getClasseGB() == Classe.RAPIDE) {
			
			joueur.removeSpeed(0.20);
			joueur.addForce(0.03);
			joueur.setAbso(true);
			
		}
		else if(joueur.getClasseGB() == Classe.SUPPORT) {
			
			joueur.removeSpeed(0.05);
			joueur.addResi(0.02);
			
		}
		
		if(classe == Classe.ATTAQUANT) {
			
			joueur.addForce(0.1);
			joueur.removeResi(0.07);
			joueur.getPlayer().sendMessage("Vous avez choisi la classe attaquant");
			joueur.setClasseGB(classe);
			
		}
		else if(classe == Classe.DEFENSEUR) {
			
			joueur.removeSpeed(0.20);
			joueur.addResi(0.07);
			joueur.getPlayer().sendMessage("Vous avez choisi la classe defenseur");
			joueur.setClasseGB(classe);
			
		}
		else if(classe == Classe.DISTANCE) {
			
			joueur.addSpeed(0.05);
			joueur.removeForce(0.1);
			joueur.getPlayer().sendMessage("Vous avez choisi la classe distance");
			joueur.setClasseGB(classe);
			
		}
		else if(classe == Classe.RAPIDE) {
			
			joueur.addSpeed(0.20);
			joueur.removeForce(0.03);
			joueur.setAbso(false);
			joueur.getPlayer().sendMessage("Vous avez choisi la classe rapide");
			joueur.setClasseGB(classe);
			
		}
		else if(classe == Classe.SUPPORT) {
			
			joueur.addSpeed(0.05);
			joueur.removeResi(0.02);
			joueur.getPlayer().sendMessage("Vous avez choisi la classe support");
			joueur.setClasseGB(classe);
			
		}
		else {
			
			joueur.getPlayer().sendMessage("Vous n'avez plus d'effets de classes");
			
		}
		
	}
	
	public static void CommandeBuff(Joueur joueur, Joueur cible, String buff, Main main) {
		
		if(buff.equalsIgnoreCase("coeur")) {
			
			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-2);
			cible.getPlayer().setMaxHealth(cible.getPlayer().getMaxHealth()+2);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_coeur", 60, cible, null, null, 0, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		else if(buff.equalsIgnoreCase("force")) {
			
			joueur.removeForce(0.02);
			cible.addForce(0.02);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_force", 60, cible, null, null, 0, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		else if(buff.equalsIgnoreCase("resi")) {
			
			joueur.removeResi(0.02);
			cible.addResi(0.02);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_resi", 60, cible, null, null, 0, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		else if(buff.equalsIgnoreCase("speed")) {
			
			joueur.removeSpeed(0.05);
			cible.addSpeed(0.05);
			ItemCD cycle = new ItemCD(main, joueur, "buffgb_speed", 60, cible, null, null, 0, null);
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

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §9GameBlack\n§r"
        		+ "Vous devez gagner avec le §9camp staff§r\n \n"
        		+ "Vous avez 10% de speed permanent et vous recevez une orbe à l'annonce des rôles\n \n"
        		+ "Si vous venez à croiser Malivol avant Team ou Maka, vous passez dans le camp UHC\n \n"
        		+ "Vous avez 50% de chance de ne pas recevoir le malus de votre orbe\n \n"
        		+ "Avec la commande /rcchangeorbe, vous pouvez changer votre orbe\n \n"
        		+ "Avec la commande /rccheckorbe <pseudo>, vous pouvez voir quelle orbe possède le joueur ciblé\n \n"
        		+ "Lorsque Kzou ban un joueur, vous recevez un message vous avertissant du ban et vous avez 25% de chance de connaître le pseudo du banni\n \n"
        		+ "Avec la commande /rcconsole, vous pouvez voir la console pendant 30 secondes\n"
        		+ "Vous recevez un message pour chaque action parmi les suivants : un joueur frappe un autre joueur, un joueur tue un joueur, un joueur a un changement d'effet, un joueur active son pouvoir.\n"
        		+ "A la fin des 30 secondes, vous recevez un rôle d'un joueur proche aléatoirement (sans avoir le pseudo du joueur) (50% de chance d'être brouiller)\n"
        		+ "Chaque action a une certaine chance d'avoir les pseudos brouiller\n \n"
        		+ "____________________________________________________");

    }
	
	public static void TexteJoueurFun(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §9GameBlack\n§r"
        		+ "Vous devez gagner avec le §acamp joueur§r\n \n"
        		+ "Vous avez 10% de speed permanent\n \n"
        		+ "Vous avez 50% de chance de ne pas recevoir le malus de votre orbe\n \n"
        		+ "2 lits viennent d'apparaitre sur la map : un pour vous et un pour votre adversaire\n \n"
        		+ "Votre lit apparait en 200 100 200 et celui de votre adversaire en 200 100 -200\n \n"
        		+ "Tant qu'aucun lit n'est cassé, vous et votre adversaire pouvez respawn à l'infini avec un malus pour chaque mort\n \n"
        		+ "Lorsqu'un des 2 lits est cassé, l'autre se détruit automatiquement\n"
        		+ "Si vous cassez le lit de votre adversaire, vous recevez 2% d'un effet aléatoire (5% si l'effet est speed)\n"
        		+ "Si un joueur autre que vous casse le lit de votre adversaire, il perd 1% d'un effet aléatoire (3% si l'effet est speed)\n"
        		+ "Si votre adversaire casse votre lit, il reçoit 2% d'un effet aléatoire (5% si l'effet est speed)\n \n"
        		+ "Si un joueur autre que votre adversaire casse votre lit, vous perdez 1% d'un effet aléatoire (3% si l'effet est speed)\n \n"
        		+ "____________________________________________________");

    }
	
	public static void TexteJoueurSerieux(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §9GameBlack\n§r"
        		+ "Vous devez gagner avec le §acamp joueur§r\n \n"
        		+ "Avec la commande /rcclasse <classe>, vous pouvez choisir une classe parmis les 5 suivants\n \n"
        		+ "Attaquant : vous recevez 10% de force mais vous perdez 7% de résistance\n"
        		+ "Défenseur : vous recevez 7% de resistance mais vous perdez 20% de speed\n"
        		+ "Rapide : vous recevez 20% de speed mais vous ne recevez plus d'absorption et vous perdez 3% de force\n"
        		+ "Distance : vous recevez 5% de speed et vous infliger 5% plus de dégâts à l'arc mais vous perdez 10% de force\n"
        		+ "Support : vous obtenez 5% de speed et la commande /rcbuff mais vous perdez 2% de résistance.\n"
        		+ "Avec la commande /rcbuff <pseudo>, vous passez un effet au choix au joueur ciblé pendant 1 minute\n"
        		+ "Vous pouvez retirer les effets d'une classe avec la commande /rcclasse rien\n"
        		+ "____________________________________________________");

    }
	
	public static void TexteUHC(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §9GameBlack\n§r"
        		+ "Vous devez gagner avec le §2camp UHC§r\n \n"
        		+ "Vous avez 5% de speed permanent\n \n"
        		+ "Si l'évènement 'Fermeture de Golden' se déclanche, vous avez 50% de chance de passer dans le camp Joueur\n \n"
        		+ "Vous avez 50% de chance de ne pas recevoir le malus de votre orbe\n \n"
        		+ "Avec la commande /rcchangeorbe, vous pouvez changer votre orbe\n \n"
        		+ "Avec l'item 'Fuite', vous devenez invulnérable et vous ne poupez plus mettre de coup pendant 2 secondes\n"
        		+ "Vous recevez 10% de speed pendant 1 minute\nLes joueur proche de vous recevront l'effet blindness pendant 10 secondes\n"
        		+ "Si Toinou est proche de vous lors de l'utilisation, il reçoit 1% de force pendant 1 minute\n \n"
        		+ "A chaque coup d'épée subi, vous avez 5% de chance de recevoir 1% de speed supplémentaire permanent\n \n"
        		+ "____________________________________________________");

    }

}
