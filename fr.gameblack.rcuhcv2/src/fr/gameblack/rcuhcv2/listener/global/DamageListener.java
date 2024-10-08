package fr.gameblack.rcuhcv2.listener.global;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v2.Classe;
import fr.gameblack.rcuhcv2.listener.v1.HitV1;
import fr.gameblack.rcuhcv2.listener.v2.HitV2;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.orbes.v2.HitOrbeV2;
import fr.gameblack.rcuhcv2.roles.v2.staff.Loup;
import fr.gameblack.rcuhcv2.roles.v2.staff.Trial;
import fr.gameblack.rcuhcv2.roles.v2.staff.Yuri;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class DamageListener implements Listener {
	
	private Main main;
	
	public DamageListener(Main main) {
		
		this.main = main;
		
	}
	
	public static void respawn(Joueur joueur, Main main) {
		
		if(main.getScenarios().contains(Scenarios.DEBUG)) {
			
			System.out.println("ADV BED -> " + main.getAdvBedwars());
			System.out.println("Joueur -> " + joueur.getPlayer().getDisplayName());
			
		}
		
		joueur.setInvulnerable(true);
		
		if((joueur.getRole() != Roles.GAMEBLACK || joueur.getCamp() != Camps.JOUEUR || joueur.getModeTrial() == null || !joueur.getModeTrial().equalsIgnoreCase("fun") || main.getAdvBedwars() == null) && joueur != main.getAdvBedwars()) {
			
			joueur.setRespawn(false);
			
		}
		else {
			
			Random r = new Random();
	        int nb = r.nextInt(4);
	        
	        if(nb == 1) {
	        	
	        	joueur.removeForce(0.02);
	        	
	        } else if(nb == 2) {
	        	
	        	joueur.removeResi(0.02);
	        	
	        } else if(nb == 3) {
	        	
	        	joueur.removeSpeed(0.03);
	        	
	        } else {
	        	
	        	if(joueur.getPlayer().getMaxHealth() >= 4) {
	        	
	        	joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth() - 2);
	        	
	        	}
	        	else {
	        		
	        		joueur.getPlayer().setMaxHealth(2);
	        		
	        	}
	        	
	        }
			
		}
		
		Random r = new Random();
        int signe_x = r.nextInt(2);
        int signe_y = r.nextInt(2);
        int cos_x = r.nextInt(100);
        cos_x += 200;
        if (signe_x == 1) {
            cos_x = -cos_x;
        }

        int cos_y = r.nextInt(100);
        cos_y += 200;
        if (signe_y == 1) {
            cos_y = -cos_y;
        }
        
        World world;
        
        if(main.getWorld() == null) {
        	
        	world = Bukkit.getWorld("world");
        	
        }
        else {
        	
        	world = main.getWorld();
        	
        }
        
        int h = world.getHighestBlockYAt(cos_x, cos_y);

        joueur.getPlayer().setFoodLevel(20);

        joueur.getPlayer().setHealth(joueur.getPlayer().getMaxHealth());
        
        joueur.getPlayer().teleport(new Location(joueur.getPlayer().getWorld(), cos_x, h+1, cos_y));
        
        ItemCD cycle2 = new ItemCD(main, joueur, "respawn", 5, joueur, null, null, 0, null);
        cycle2.runTaskTimer(main, 0, 20);
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPvp(EntityDamageByEntityEvent event) {
		
		Entity victim = event.getEntity();
		
		if(victim instanceof Boat) {
        	
        	Boat boat = (Boat) victim;
        	
        	if(boat == Loup.getBoat()) {
        		
        		event.setCancelled(true);
        		
        	}
			
		}

        if (victim instanceof Player) {
            Player player = (Player) victim;
            Joueur joueur = main.getJoueur(player);

            Entity damager = event.getDamager();
            Player killer = player;

            @SuppressWarnings("unused")
			double damage = 0;

            if (damager instanceof Player) { 
            	
            	killer = (Player) damager;
            
	            Joueur tueur = main.getJoueur(killer);
	
	            if (main.getState() == Statut.PVP_ON && !joueur.isInvulnerable() && !tueur.isInvulnerable()) {
	            	
	            	if(main.getScenarios().contains(Scenarios.DEBUG)) {
	                	
	                	System.out.println("_________________________________________");
	                	System.out.println("Abso : " + event.getDamage(DamageModifier.ABSORPTION));
	                	System.out.println("Armure : " + event.getDamage(DamageModifier.ARMOR));
	                	System.out.println("Base : " + event.getDamage(DamageModifier.BASE));
	                	System.out.println("Blocking : " + event.getDamage(DamageModifier.BLOCKING));
	                	System.out.println("Hard hat : " + event.getDamage(DamageModifier.HARD_HAT));
	                	System.out.println("Enchant : " + event.getDamage(DamageModifier.MAGIC));
	                	System.out.println("Resistance : " + event.getDamage(DamageModifier.RESISTANCE));
	                	System.out.println("Final : " + event.getFinalDamage());
	                	System.out.println("__________________");
	                	
	                }
	                
	                if(main.getScenarios().contains(Scenarios.DEBUG)) {
	                	
	                	System.out.println("Abso : " + event.getDamage(DamageModifier.ABSORPTION));
	                	System.out.println("Armure : " + event.getDamage(DamageModifier.ARMOR));
	                	System.out.println("Base : " + event.getDamage(DamageModifier.BASE));
	                	System.out.println("Blocking : " + event.getDamage(DamageModifier.BLOCKING));
	                	System.out.println("Hard hat : " + event.getDamage(DamageModifier.HARD_HAT));
	                	System.out.println("Enchant : " + event.getDamage(DamageModifier.MAGIC));
	                	System.out.println("Resistance : " + event.getDamage(DamageModifier.RESISTANCE));
	                	System.out.println("Final : " + event.getFinalDamage());
	                	System.out.println("_________________________________________");
	                	
	                }
	                if(tueur != joueur) {
	                	
	                	double force = tueur.getForce();
	                	
	                	if(tueur.getRole() == Roles.MAKA && ((tueur.getForme().equalsIgnoreCase("normal") && tueur.isProche(Roles.GAMEBLACK, main)) || (tueur.getForme().equalsIgnoreCase("simp") && joueur.isFrappeNeko()))) {
	                		
	                		force += 2;
	                		
	                	}
	                	
	                	double nerf_force = 1;
	                	
	                	if(main.getVersion() == 2) {
	                		
	                		nerf_force = 0.9;
	                		
	                	}
	                	else if(main.getVersion() == 1) {
	                		
	                		nerf_force = 0.8;
	                		
	                	}
	                	double damage_strenght = (event.getDamage(DamageModifier.BASE)*(force/100))*nerf_force;
	                    double armure = event.getDamage(DamageModifier.ARMOR)*0.85;
	                    event.setDamage(DamageModifier.BASE, damage_strenght);
	                    event.setDamage(DamageModifier.ARMOR,armure);
	                    
	                    double res = joueur.getResi();
	                    
	                    if((main.getJoueurByRole(Roles.TEAM) != null && main.getJoueurByRole(Roles.FARMEURIMMO) != null) && main.getJoueurByRole(Roles.TEAM).isProche(Roles.FARMEURIMMO, main)) {
	                    
	                    	res += 2;
	                    
	                    }
	                    
	                    ItemStack ames = new ItemStack(Material.DIAMOND_SWORD, 1);
	                    ItemMeta amesM = ames.getItemMeta();
	                    ames.addEnchantment(Enchantment.DAMAGE_ALL, 3);
	                    amesM.setDisplayName("Épée des âmes");
	                    ames.setItemMeta(amesM);
	                    
	                    if(tueur.getRole() == Roles.TOINOU && tueur.getPlayer().getItemInHand().hasItemMeta() && tueur.getPlayer().getItemInHand().getItemMeta().getDisplayName() == "Épée des âmes") {
	                    	
	                    	res = 110;
	                    	
	                    }
	                    
	                	double nerf_resi = 1;
	                	
	                	if(main.getVersion() == 2) {
	                		
	                		nerf_resi = 0.9;
	                		
	                	}
	                	else if(main.getVersion() == 1) {
	                		
	                		nerf_resi = 0.7;
	                		
	                	}
	                    
	                    res = ((res/100)-1)*nerf_resi;
	                    
	                    double nerf_armure = 0.95;
	                    
	                    nerf_armure *= event.getDamage(DamageModifier.ARMOR);
	                    
	                    event.setDamage(DamageModifier.ARMOR, nerf_armure);
	                    
	                    double resi = event.getDamage(DamageModifier.BASE)*res;
	                    event.setDamage(DamageModifier.RESISTANCE, -resi);
	                	
	                }
	                
	                if(joueur.getRole() == Roles.RAPTOR && tueur.getRole() == Roles.TOINOU && tueur.isCheatToinou()) {
	        			
	        			damage *= 1.03;
	        			
	        		}
	                
	                damage = event.getFinalDamage();
	                
	                if(joueur != tueur) {
	                	
	                	if(main.getVersion() == 2) {
	            		
		            		HitV2.whenHit(joueur, tueur, main, event);
		            		
		                    //ORBES
		                    HitOrbeV2.whenHit(joueur, tueur, main);
		                    
	                	}
	                	else if(main.getVersion() == 1) {
	                		
	                		HitV1.whenHit(joueur, tueur, main);
	                		
	                	}
	            	
	            	}
	                
	                //ANTI KB
	                if (joueur.isAntiKB()) {
	
	                    event.setCancelled(true);
	                    player.damage(event.getFinalDamage()*1.05);
	
	                }
	                
	                if (player.getHealth() <= event.getFinalDamage()) {
	                	
	                	if(joueur.getRole() == Roles.TRIAL && tueur.getRole() == Roles.KZOU && !joueur.isRespawnTrial()) {
	            			
	            			Trial.mortKzou(joueur, main);
	            			
	            			return;
	            			
	            		} else {
	                	
		                	if(joueur.canRespawn()) {
		                		
		                		respawn(joueur, main);
		                		
		                	}
		                	else {
		                		
		                		Mort.setMortV2(joueur, joueur.getLastHit(), main);
			                    ItemCD cycle = new ItemCD(main, tueur, "mort", 2, joueur, event, null, 0, joueur.getPlayer().getLocation());
			                    cycle.runTaskTimer(main, 0, 20);
			                    event.setDamage(0);
			                    player.setGameMode(GameMode.SPECTATOR);
			                    //player.sendMessage("Vous êtes mort mais vous avez encore une chance de ressucité");
			                    
		                	}
	                	
	            		}
	
	                }
	                
	            }
	            else {
	            	
	            	event.setCancelled(true);
	            	
	            }
	            
            }
            else if(damager instanceof Arrow) {
            	
                Arrow arrow = (Arrow) damager;
                if (arrow.getShooter() instanceof Player) {
                    killer = (Player) arrow.getShooter();
                    Joueur tueur = main.getJoueur(killer);
                    joueur.setLastHit(tueur);
                    
                    if (main.getState() == Statut.PVP_ON && !joueur.isInvulnerable() && !tueur.isInvulnerable()) {
                    	
                    	event.setDamage(event.getDamage(DamageModifier.BASE)*0.90);
                    	
                    	if(tueur.getRole() == Roles.GAMEBLACK && tueur.getClasseGB() == Classe.DISTANCE) {
                        	
                        	event.setDamage(event.getDamage(DamageModifier.BASE)*1.15);
                        	
                        } if(tueur != joueur) {
                        	
    	                	if(main.getVersion() == 2) {
        	            		
    		            		HitV2.whenHit(joueur, tueur, main, event);
    		            		
    		                    //ORBES
    		                    HitOrbeV2.whenHit(joueur, tueur, main);
    		                    
    	                	}
    	                	else if(main.getVersion() == 1) {
    	                		
    	                		HitV1.whenHit(joueur, tueur, main);
    	                		
    	                	}
    	                	
    	                }
    	                
    	                //ANTI KB
    	                if (joueur.isAntiKB()) {
    	
    	                    event.setCancelled(true);
    	                    player.damage(event.getFinalDamage());
    	
    	                }
    	                
    	                if (player.getHealth() <= event.getFinalDamage()) {
    	                	
    	                	if(joueur.getRole() == Roles.TRIAL && tueur.getRole() == Roles.KZOU && !joueur.isRespawnTrial()) {
    	            			
    	            			Trial.mortKzou(joueur, main);
    	            			
    	            			return;
    	            			
    	            		} else {
    	                	
    		                	if(joueur.canRespawn()) {
    		                		
    		                		respawn(joueur, main);
    		                		
    		                	}
    		                	else {
    		                		
    		                		Mort.setMortV2(joueur, joueur.getLastHit(), main);
    			                    ItemCD cycle = new ItemCD(main, tueur, "mort", 2, joueur, event, null, 0, joueur.getPlayer().getLocation());
    			                    cycle.runTaskTimer(main, 0, 20);
    			                    event.setDamage(0);
    			                    player.setGameMode(GameMode.SPECTATOR);
    			                    //player.sendMessage("Vous êtes mort mais vous avez encore une chance de ressucité");
    			                    
    		                	}
    	                	
    	            		}
    	
    	                }
    	                
    	            }
    	            else {
    	            	
    	            	event.setCancelled(true);
    	            	
    	            }
                    
                }
            	
            }
            else if(damager instanceof Zombie) {
            	
            	Zombie zombie = (Zombie) damager;
            	
            	if(zombie == Yuri.getAziz()) {
            		
            		joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 4, false, false));
            		joueur.removeForce(0.02);
            		ItemCD cycle = new ItemCD(main, joueur, "stun_aziz", 5, joueur, null, null, 0, null);
        	        cycle.runTaskTimer(main, 0, 20);
            		Location loc = zombie.getLocation();
            		zombie.remove();
            		main.getWorld().getBlockAt(loc).setType(Material.ENDER_CHEST);
            		ItemCD cycle2 = new ItemCD(main, joueur, "ec_aziz", 15, joueur, null, null, 0, loc);
        	        cycle2.runTaskTimer(main, 0, 20);
            		
            	}
            	
            }
            
        }
		
	}
	
	@EventHandler
	public void onTarget(EntityTargetEvent event) {
		
		Entity victim = event.getTarget();
		
		Entity mob = event.getEntity();
		
		if(mob instanceof Zombie) {
			
			Zombie zombie = (Zombie) mob;
			
			if(mob == Yuri.getAziz()) {
				
				if(victim instanceof Player) {
					
					Player player = (Player) victim;
					
					Joueur joueur = main.getJoueur(player);
					
					if(joueur.getRole() == Roles.YURI) {
						
						event.setCancelled(true);
						
					}
					
				}
				
			}
			
		}
		
	}
	
    @EventHandler
    public void onDamage(EntityDamageEvent event) {

        Entity victim = event.getEntity();
        
        if(victim instanceof Player) {
        	
        	Joueur joueur = main.getJoueur((Player) victim);
        	
        	Player player = (Player) victim;
        	
            if(joueur.isBot()) {
            	
            	HitV2.botHit(joueur, null, main);
            	
            }
        	
        	if(joueur.isInvulnerable()) {
        		
        		event.setCancelled(true);
        		
        	}
        	
        	if(event.getCause() == DamageCause.FALL && (joueur.isNofall() || joueur.isNofallPerma())) {
        		
        		event.setCancelled(true);
        		
        	}
        	
        	if(event.getCause() == DamageCause.FIRE || event.getCause() == DamageCause.FIRE_TICK) {
        		
        		if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbePassifActif()) {
        			
        	        Random r = new Random();
        	        int nb = r.nextInt(100);

        	        if ((nb <= 10) || (joueur.isBonusOrbeActif() && nb <= 25)) {

        	            joueur.getPlayer().setFireTicks(0);
        	            joueur.getPlayer().sendMessage("Vous venez de vous éteindre grâce à l'orbe d'eau");
        	            event.setCancelled(true);

        	        }
        			
        		}
        		
        	}
        	
        	if (player.getHealth() <= event.getFinalDamage()) {
        		
        		if(joueur.getRole() == Roles.TRIAL && joueur.getLastHit() != null && joueur.getLastHit().getRole() == Roles.KZOU && !joueur.isRespawnTrial()) {
        			
        			Trial.mortKzou(joueur, main);
        			
        			return;
        			
        		} else {
        		
	        		if(joueur.canRespawn()) {
	        			
	        			respawn(joueur, main);
	        			
	        		}
	        		else {
	        			
	        			Mort.setMortV2(joueur, joueur.getLastHit(), main);
		                ItemCD cycle = new ItemCD(main, joueur.getLastHit(), "mort", 2, joueur, null, null, 0, joueur.getPlayer().getLocation());
		                cycle.runTaskTimer(main, 0, 20);
		                event.setDamage(0);
		                player.setGameMode(GameMode.SPECTATOR);
		                //player.sendMessage("Vous êtes mort mais vous avez encore une chance de ressucité");
		                
	        		}
	        		
        		}

            }
        	
        }

    }
    
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
    	
    	if(main.getScenarios().contains(Scenarios.BETA_ZOMBIE)) {
    	
	    	if(event.getEntityType() == EntityType.ZOMBIE) {
	    		
	    		event.getDrops().clear();
	    		event.getDrops().add(new ItemStack(Material.FEATHER, 2));
	    		
	    	}
	    	
    	}
    	
    }
    
    @EventHandler
    public void onDamageBoat(VehicleDamageEvent event) {

        Vehicle victim = event.getVehicle();
        
        if(victim instanceof Boat) {
        	
        	Boat boat = (Boat) victim;
        	
        	if(boat == Loup.getBoat()) {
        		
        		event.setCancelled(true);
        		
        	}
        	
        }

    }

}
