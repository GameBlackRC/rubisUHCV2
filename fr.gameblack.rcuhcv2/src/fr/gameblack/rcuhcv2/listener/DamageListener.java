package fr.gameblack.rcuhcv2.listener;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;

import fr.gameblack.rcuhcv2.Classe;
import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.orbes.Glace;
import fr.gameblack.rcuhcv2.roles.joueur.Raptor;
import fr.gameblack.rcuhcv2.roles.uhc.Toinou;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class DamageListener implements Listener {
	
	private Main main;
	
	public DamageListener(Main main) {
		
		this.main = main;
		
	}
	
	public static void Mort(Joueur joueur, Joueur tueur, EntityDamageByEntityEvent event, Main main) {
		
		if(main.getJoueurByRole(Roles.GAMEBLACK) != null) {
        	
        	Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
        	
        	if(joueur == gb && tueur == main.getMaledictionGyomei()) {
        		
        		tueur.addForce(0.02);
        		
        	}
        	
        	Random r = new Random();
            int nb = r.nextInt(100);
        	
        	if(main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
	            
	            if(nb <= 10) {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient de tuer " + ChatColor.MAGIC + "aaaaa");
	            	
	            }
	            else {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + tueur.getPlayer().getName() + " vient de tuer " + joueur.getPlayer().getName());
	            	
	            }
	            
        	}
        	
        }
		
		if(main.getNeko() != null && joueur.getRole() == Roles.MAKA) {
			
			if(main.getNbJoueursStaff() == 5) {
    			main.getNeko().addSpeed(0.01);
    		}
    		else if(main.getNbJoueursStaff() == 4) {
    			main.getNeko().addSpeed(0.03);
    		}
    		else if(main.getNbJoueursStaff() == 3) {
    			main.getNeko().addSpeed(0.05);
    		}
    		else if(main.getNbJoueursStaff() == 2) {
    			main.getNeko().addSpeed(0.07);
    		}
    		else if(main.getNbJoueursStaff() == 1) {
    			main.getNeko().addSpeed(0.07);
    		}
			
		}
		
		if(main.getTueurNeko() == joueur && tueur.getRole() == Roles.MAKA) {
			
			if(tueur.getPlayer().getMaxHealth() <= 18) {
				
				tueur.getPlayer().setMaxHealth(18);
				main.setTueurNeko(null);
				tueur.addResi(0.02);
				if(main.getNbJoueursStaff() == 6) {
	    			tueur.addSpeed(0.01);
	    		}
				else if(main.getNbJoueursStaff() == 5) {
	    			tueur.addSpeed(0.02);
	    		}
	    		else if(main.getNbJoueursStaff() == 4) {
	    			tueur.addSpeed(0.05);
	    		}
	    		else if(main.getNbJoueursStaff() == 3) {
	    			tueur.addSpeed(0.07);
	    		}
	    		else if(main.getNbJoueursStaff() == 2) {
	    			tueur.addSpeed(0.1);
	    		}
	    		else if(main.getNbJoueursStaff() == 1) {
	    			tueur.addSpeed(0.15);
	    		}
				
			}
			
		}
		
		if(main.getJoueurByRole(Roles.MAKA) != null && main.getNeko() == joueur) {
			
			Joueur maka = main.getJoueurByRole(Roles.MAKA);
			
			maka.getPlayer().sendMessage("Neko vient de mourrir, vous perdrez donc 1 coeur permanent toutes les 5 minutes");
			
			ItemCD cycle = new ItemCD(main, joueur, "mortNeko", 300, joueur, null, null, null, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		
		if(joueur.getRole() == Roles.TRIAL && tueur.getRole() == Roles.KZOU && !joueur.isRespawnTrial()) {
			
			joueur.setRespawnTrial(true);
			
			Random r = new Random();
            int signe_x = r.nextInt(2);
            int signe_y = r.nextInt(2);
            int cos_x = r.nextInt(400);
            cos_x += 200;
            if (signe_x == 1) {
                cos_x = -cos_x;
            }

            int cos_y = r.nextInt(400);
            cos_y += 200;
            if (signe_y == 1) {
                cos_y = -cos_y;
            }
			
			joueur.getPlayer().teleport(new Location(Bukkit.getWorld("world"), cos_x, 100, cos_y));
			joueur.getPlayer().setMaxHealth(10);
			joueur.getPlayer().setHealth(10);
			
			return;
			
		}
		
		if(joueur.getRole() == Roles.LOUP && main.getJoueurByRole(Roles.TRIAL) != null) {
			
			if(tueur.getCamp().equalsIgnoreCase("uhc")) {
				
				Joueur trial = main.getJoueurByRole(Roles.TRIAL);
				
				Joueur slup = main.getJoueurByRole(Roles.SLUP);
				
				if(trial.getCamp() == "duo" || (slup != null && slup.getPacteSlup() == 2 && ((main.getTemps() <= 600 && main.getEpisode() <= 3 && main.getMode() == "normal") || (main.getEpisode() < 2 && main.getMode() == "rapide")))) {
					
					if(trial.getCamp() == "duo") {
						
						trial.getPlayer().sendMessage("Un joueur du camp UHC vient de tuer Loup. Voici son pseudo : " + tueur.getPlayer().getName());
						tueur.getPlayer().sendMessage("Trial vient de rejoindre votre camp. Pseudo de Trial : " + trial.getPlayer().getName());
						
					}
					else {
						
						trial.getPlayer().sendMessage("Loup vient de mourrir. Vous devez désormais gagner avec Slup. Le tueur de Loup appartient au camp uhc, voici son pseudo : " + tueur.getPlayer().getName());
						trial.setCamp("duo");
						
					}
					
				}
				else {
					
					trial.setCamp("uhc");
					trial.getPlayer().sendMessage("Un joueur du camp UHC vient de tuer Loup. Vous devez donc gagnez avec le camp UHC\nPseudo du tueur de Loup : " + tueur.getPlayer().getName());
					tueur.getPlayer().sendMessage("Trial vient de rejoindre votre camp. Pseudo de Trial : " + trial.getPlayer().getName());
					
				}
				
			}
			
			
		}
		
		if(tueur.getRole() == Roles.TRIAL) {
			
			if(tueur.getModeTrial() == "serieux") {
			
				tueur.addForce(0.02);
				
				if(tueur.getCamp() == "duo" && main.getJoueurByRole(Roles.SLUP) != null) {
					
					Joueur slup = main.getJoueurByRole(Roles.SLUP);
					
					slup.addForce(0.02);
					
				}
				
			}
			
		}
		if(joueur.isBonPapiers() && tueur.getRole() != Roles.TRIAL && tueur.getRole() != Roles.MAKA && tueur.getRole() != Roles.MALIVOL) {
			
			tueur.setBonPapiers(true);
			
		}
		else if(!joueur.isBonPapiers()) {
			
			tueur.setBonPapiers(false);
			
		}
		
	}
	
	@EventHandler
	public void onPvp(EntityDamageByEntityEvent event) {
		
		Entity victim = event.getEntity();

        if (victim instanceof Player) {
            Player player = (Player) victim;
            Joueur joueur = main.getJoueur(player);

            Entity damager = event.getDamager();
            Player killer = player;

            double damage = 0;

            if (damager instanceof Player) killer = (Player) damager;
            
            Joueur tueur = main.getJoueur(killer);

            if (main.getState() == Statut.PVP_ON && !joueur.isInvulnerable() && !tueur.isInvulnerable()) {

            	if(joueur != tueur) {
            		
            		joueur.addPourcentHack(2, main);
            		tueur.addPourcentHack(2, main);
            		
            		if(tueur.getComboSubi() != 0) {
            			
            			tueur.setComboSubi(0);
            			
            		}
            		
            		if(tueur != joueur.getLastHit()) {
            	
            			joueur.setLastHit(tueur);
            			joueur.setComboSubi(0);
            			
            		}
            		else if(joueur.getRole() == Roles.RAPTOR && joueur.getComboSubi() == 4 && !joueur.isCheatRaptorActif()) {
            			
            			Raptor.cheat(joueur, main);
            			joueur.setCheatRaptorActif(true);
            			joueur.setComboSubi(0);
            			
            			if(tueur.getRole() == Roles.TOINOU && !joueur.isCheatToinouActif()) {
            				
            				joueur.setCheatToinou(true);
            				Toinou.Cheat(tueur, main);
            				
            			}
            			
            		}
            		else {
            			
            			joueur.setComboSubi(joueur.getComboSubi()+1);
            			
            		}
            	
            	}
            	
            	if(main.isDebug()) {
                	
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
                
                if (tueur.getOrbe() == Orbe.GLACE && tueur.isOrbeActif()) {

                    Glace.Freeze(player);

                }
                
                if(main.isDebug()) {
                	
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
                
                if (damager instanceof Arrow) {

                    Arrow arrow = (Arrow) damager;
                    if (arrow.getShooter() instanceof Player) {
                        killer = (Player) arrow.getShooter();
                        tueur = main.getJoueur(killer);
                        joueur.setLastHit(tueur);
                        if(tueur.getRole() == Roles.GAMEBLACK && tueur.getClasseGB() == Classe.DISTANCE) {
                        	
                        	event.setDamage(event.getFinalDamage()*1.05);
                        	
                        }
                    }

                }
                else if(tueur != joueur) {
                	
                	double force = tueur.getForce();
                	
                	if(tueur.getRole() == Roles.MAKA && ((tueur.getForme().equalsIgnoreCase("normal") && tueur.isProche(Roles.GAMEBLACK, main)) || (tueur.getForme().equalsIgnoreCase("simp") && joueur.isFrappeNeko()))) {
                		
                		force += 2;
                		
                	}
                	
                	double damage_strenght = (event.getDamage(DamageModifier.BASE)*(force/100))*0.9;
                    double armure = event.getDamage(DamageModifier.ARMOR)*0.85;
                    event.setDamage(DamageModifier.BASE, damage_strenght);
                    event.setDamage(DamageModifier.ARMOR,armure);
                    
                    double res = joueur.getResi();
                    
                    if((main.getJoueurByRole(Roles.TEAM) != null && main.getJoueurByRole(Roles.FARMEURIMMO) != null) && main.getJoueurByRole(Roles.TEAM).isProche(Roles.FARMEURIMMO, main)) {
                    
                    	res *= 1.02;
                    
                    }
                    
                    double resi = event.getDamage(DamageModifier.BASE)*((res/100)-1);
                    event.setDamage(DamageModifier.RESISTANCE, -resi);
                	
                }
                
                damage = event.getFinalDamage();
                
                if(joueur.getRole() == Roles.GAMEBLACK && main.getJoueurByRole(Roles.GAMEBLACK).getCamp().equalsIgnoreCase("uhc")) {
            		
                	Random r = new Random();
                    int nb = r.nextInt(100);
                	
            		if(nb <= 5) {
            			
            			main.getJoueurByRole(Roles.GAMEBLACK).addSpeed(0.01);
            			
            		}
            		
            	}
                
                if(joueur == main.getNeko()) {
                	
                	if(!main.getNeko().isProche(Roles.MAKA, main)) {
                		
                		main.getJoueurByRole(Roles.MAKA).getPlayer().sendMessage("Neko vient de recevoir un coup de " + tueur.getPlayer().getName());
                		
                	}
                	
                	if(!tueur.isFrappeNeko()) {
                	
	                	tueur.setFrappeNeko(true);
	                	ItemCD cycle = new ItemCD(main, joueur, "frappe_neko", 10, tueur, null, null, null, null);
	        	        cycle.runTaskTimer(main, 0, 20);
	        	        
                	}
                	
                }
                
                if(joueur.getRole() == Roles.RAPTOR && tueur.getRole() == Roles.TOINOU && tueur.isCheatToinou()) {
        			
        			damage *= 1.03;
        			
        		}
                
                if(joueur.isFireOn() || (tueur.getOrbe() == Orbe.FEU && tueur.isOrbeActif()) || (tueur.getRole() == Roles.MAKA && tueur.getForme().equalsIgnoreCase("normal") && (tueur.getPlayer().getItemInHand().getType() == Material.DIAMOND_SWORD || tueur.getPlayer().getItemInHand().getType() == Material.IRON_SWORD))) {
                	
                	Random r = new Random();
                    int nb = r.nextInt(100);
                    
                    if(nb <= 10) {
                	
                    	joueur.getPlayer().setFireTicks(100);
                    	
                    }
                	
                }
                
                if (joueur.isAntiKB()) {

                    event.setCancelled(true);
                    player.damage(damage);

                }
                
                if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
                	
                	Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
                	
                	Random r = new Random();
                    int nb = r.nextInt(100);
                    
                    if(nb <= 80) {
                    	
                    	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient de mettre un coup à " + ChatColor.MAGIC + "aaaaa");
                    	
                    }
                    else {
                    	
                    	gb.getPlayer().sendMessage("[CONSOLE]" + tueur.getPlayer().getName() + " vient de mettre un coup à " + joueur.getPlayer().getName());
                    	
                    }
                	
                }
                
                if (tueur.getRole() == Roles.JOKO && tueur.isJokoItemActif()) {

                    if (joueur.getCube() != 0 && !main.getJokoStun().contains(joueur)) {

                        Random r = new Random();
                        int nb = r.nextInt(100);
                        int pourcent = joueur.getCube() * 2;

                        if (nb < pourcent + 1) {

                        	joueur.Stun(10, main);
                        	joueur.removeCube(main);
                            main.getJokoStun().add(joueur);

                            killer.sendMessage("Vous venez de stun " + player.getName());

                            ItemCD cycle = new ItemCD(main, tueur, "stun", 10, joueur, null, null, null, null);
                            cycle.runTaskTimer(main, 0, 20);

                        }

                    }

                }
                
                if (player.getHealth() <= damage) {

                    ItemCD cycle = new ItemCD(main, tueur, "mort", 10, joueur, event, null, null, joueur.getPlayer().getLocation());
                    cycle.runTaskTimer(main, 0, 20);
                    event.setDamage(0);
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage("Vous êtes mort mais vous avez encore une chance de ressucité");

                }
                
            }
            else {
            	
            	event.setCancelled(true);
            	
            }
            
        }
		
	}
	
    @EventHandler
    public void onDamage(EntityDamageEvent event) {

        Entity victim = event.getEntity();
        
        if(victim instanceof Player) {
        	
        	Joueur joueur = main.getJoueur((Player) victim);
        	
        	if(joueur.isInvulnerable()) {
        		
        		event.setCancelled(true);
        		
        	}
        	
        	if(event.getCause() == DamageCause.FALL && joueur.isNofall()) {
        		
        		event.setCancelled(true);
        		
        	}
        	
        }

    }

}
