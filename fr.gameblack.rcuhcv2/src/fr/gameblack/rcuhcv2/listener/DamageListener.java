package fr.gameblack.rcuhcv2.listener;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Classe;
import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.orbes.Eau;
import fr.gameblack.rcuhcv2.orbes.Feu;
import fr.gameblack.rcuhcv2.orbes.Foudre;
import fr.gameblack.rcuhcv2.orbes.Glace;
import fr.gameblack.rcuhcv2.roles.joueur.Raptor;
import fr.gameblack.rcuhcv2.roles.uhc.Toinou;
import fr.gameblack.rcuhcv2.task.GameCycle;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class DamageListener implements Listener {
	
	private Main main;
	
	public DamageListener(Main main) {
		
		this.main = main;
		
	}
	
	public static void respawn(Joueur joueur, Main main) {
		
		if(joueur != main.getAdvBedwars() && (joueur.getRole() != Roles.GAMEBLACK || !joueur.getCamp().equalsIgnoreCase("joueur") || !main.getModeTrial().equalsIgnoreCase("fun") || main.getAdvBedwars() == null)) {
			
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
		
		joueur.setInvulnerable(true);
		
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

        joueur.getPlayer().setFoodLevel(20);

        joueur.getPlayer().setHealth(20);
        
        joueur.getPlayer().teleport(new Location(joueur.getPlayer().getWorld(), cos_x, 100, cos_y));
        
        ItemCD cycle2 = new ItemCD(main, joueur, "respawn", 5, joueur, null, null, null, null);
        cycle2.runTaskTimer(main, 0, 20);
		
	}
	
	public static void Mort(Joueur joueur, Joueur tueur, EntityDamageByEntityEvent event, Main main) {
		
		tueur.addKill();
		
		if(tueur.getRole() == Roles.TOINOU) {
			
			tueur.addPoint();
			
		}
		
		if(joueur.isProche(Roles.TEAM, main) && (joueur.getCamp().equalsIgnoreCase("staff") || joueur.getRole() == Roles.GAMEBLACK || joueur.getRole() == Roles.TRIAL)) {
			
			Random r = new Random();
            int nb = r.nextInt(3);
            
            if(nb == 1) {
            	
            	main.getJoueurByRole(Roles.TEAM).addForce(0.01);
            	main.getJoueurByRole(Roles.TEAM).getPlayer().sendMessage("Un joueur du staff vient de mourir dans un rayon de 20 blocs, vous recevez donc 1% de force");
            	
            }
            else if(nb == 2) {
            	
            	main.getJoueurByRole(Roles.TEAM).addResi(0.01);
            	main.getJoueurByRole(Roles.TEAM).getPlayer().sendMessage("Un joueur du staff vient de mourir dans un rayon de 20 blocs, vous recevez donc 1% de résistance");
            	
            }
            else {
            	
            	main.getJoueurByRole(Roles.TEAM).addSpeed(0.02);
            	main.getJoueurByRole(Roles.TEAM).getPlayer().sendMessage("Un joueur du staff vient de mourir dans un rayon de 20 blocs, vous recevez donc 2% de speed");
            	
            }
			
		}
		
		if(main.getJoueurByRole(Roles.GAMEBLACK) != null) {
        	
        	Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
        	
        	if(joueur == gb && tueur == main.getMaledictionGyomei()) {
        		
        		tueur.addForce(0.02);
        		
        	}
        	
        	Random r = new Random();
            int nb = r.nextInt(100);
        	
        	if(main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
	            
	            if(nb <= 10) {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE] " + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient de tuer " + ChatColor.MAGIC + "aaaaa");
	            	
	            }
	            else {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE] " + tueur.getPlayer().getName() + " vient de tuer " + joueur.getPlayer().getName());
	            	
	            }
	            
        	}
        	
        }
		
		if(tueur.getRole() == Roles.SLUP) {
			
			tueur.addSlime(4);
			
		}
		
		if(tueur.getRole() == Roles.NONOBOY && !tueur.getCamp().equalsIgnoreCase("farmeurimmo")) {
			
			if(tueur.getPlayer().getMaxHealth() <= 21) {
				
				tueur.getPlayer().setMaxHealth(tueur.getPlayer().getMaxHealth()+3);
				
			}
			else {
				
				tueur.getPlayer().setMaxHealth(24);
				
			}
			
		}
		
		if(main.getNeko() != null && joueur.getRole() == Roles.MAKA && !main.getNeko().isMort()) {
			
			if(main.getNbJoueursStaff() == 6) {
    			main.getNeko().addSpeed(0.01);
    		}
    		else if(main.getNbJoueursStaff() == 5) {
    			main.getNeko().addForce(0.01);
    		}
    		else if(main.getNbJoueursStaff() == 4) {
    			main.getNeko().addSpeed(0.05);
    		}
    		else if(main.getNbJoueursStaff() == 3) {
    			main.getNeko().addSpeed(0.05);
    			main.getNeko().addForce(0.01);
    		}
    		else if(main.getNbJoueursStaff() == 2) {
    			main.getNeko().addSpeed(0.07);
    			main.getNeko().addForce(0.01);
    		}
    		else if(main.getNbJoueursStaff() == 1) {
    			main.getNeko().addSpeed(0.07);
    			main.getNeko().addForce(0.02);
    		}
			
		}
		
		if(main.getTueurNeko() == joueur && tueur.getRole() == Roles.MAKA) {
			
			if(tueur.getPlayer().getMaxHealth() <= 18) {
				
				tueur.getPlayer().setMaxHealth(18);
				
			}
				
			main.setTueurNeko(null);
			if(main.getNbJoueursStaff() == 6) {
	    		tueur.addSpeed(0.01);
	    		tueur.addForce(0.01);
	    		tueur.addResi(0.01);
	    	}
			else if(main.getNbJoueursStaff() == 5) {
				tueur.addSpeed(0.03);
	    		tueur.addForce(0.01);
	    		tueur.addResi(0.01);
	    	}
	    	else if(main.getNbJoueursStaff() == 4) {
	    		tueur.addSpeed(0.07);
	    		tueur.addForce(0.01);
	    		tueur.addResi(0.01);
	    	}
	    	else if(main.getNbJoueursStaff() == 3) {
	    		tueur.addSpeed(0.07);
	    		tueur.addForce(0.02);
	    		tueur.addResi(0.01);
	    	}
	    	else if(main.getNbJoueursStaff() == 2) {
	    		tueur.addSpeed(0.1);
	    		tueur.addForce(0.02);
	    		tueur.addResi(0.02);
	    	}
	    	else if(main.getNbJoueursStaff() == 1) {
	    		tueur.addSpeed(0.15);
	    		tueur.addForce(0.02);
	    		tueur.addResi(0.02);
	    	}
			
		}
		
		if(main.getJoueurByRole(Roles.MAKA) != null && main.getNeko() == joueur) {
			
			Joueur maka = main.getJoueurByRole(Roles.MAKA);
			
			main.setTueurNeko(tueur);
			
			maka.getPlayer().sendMessage("Neko vient de mourrir, vous perdrez donc 1 coeur permanent toutes les 5 minutes");
			
			ItemCD cycle = new ItemCD(main, maka, "mortNeko", 30, maka, null, null, null, null);
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
		
		if(main.getJoueurByRole(Roles.OBSCUR) != null && joueur == main.getTueurToinou()) {
			
			Joueur obscur = main.getJoueurByRole(Roles.OBSCUR);
			
			if(main.isAdaptionObscurActif()) {
				
				obscur.addForce(0.01);
				
			} else {
				
				obscur.addForce(0.02);
				
			}
			obscur.setTueurToinouKill(true);
			
		}
		
		if(main.getJoueurByRole(Roles.OBSCUR) != null && joueur.getRole() == Roles.TOINOU) {
			
			Joueur obscur = main.getJoueurByRole(Roles.OBSCUR);
			obscur.getPlayer().sendMessage(tueur.getPlayer().getName() + " vient de tuer Toinou. Si vous parvenez à l'éliminer, vous obtiendrez 2% de force permanent");
			
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
						
						trial.getPlayer().sendMessage("Loup vient de mourir. Vous devez désormais gagner avec Slup. Le tueur de Loup appartient au camp uhc, voici son pseudo : " + tueur.getPlayer().getName());
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
		
		if(tueur.getRole() == Roles.FARMEURIMMO && tueur.getVol().contains(Pouvoirs.TRIAL_FORCE_KILL)) {
			
			tueur.addForce(0.02);
			
		}
		
		if(tueur.getRole() == Roles.FARMEURIMMO && tueur.getVol().contains(Pouvoirs.NONOBOY_COEUR_KILL)) {
			
			tueur.getPlayer().setMaxHealth(tueur.getPlayer().getMaxHealth()+1);
			
		}
		
		if(tueur.getRole() == Roles.TRIAL) {
			
			if(tueur.getModeTrial(main) == "serieux") {
			
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

            @SuppressWarnings("unused")
			double damage = 0;

            if (damager instanceof Player) killer = (Player) damager;
            
            Joueur tueur = main.getJoueur(killer);

            if (main.getState() == Statut.PVP_ON && !joueur.isInvulnerable() && !tueur.isInvulnerable()) {

            	if(joueur != tueur) {
            		
            		Random r = new Random();
                    int nb = r.nextInt(100);
                    
                    if(nb <= 50) {
            		
	            		joueur.addPourcentHack(2, main, GameCycle.getScoreboardFarmeurimmo());
	            		
                    }
            		
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
                    
                    ItemStack ames = new ItemStack(Material.DIAMOND_SWORD, 1);
                    ItemMeta amesM = ames.getItemMeta();
                    ames.addEnchantment(Enchantment.DAMAGE_ALL, 3);
                    amesM.setDisplayName("Épée des âmes");
                    ames.setItemMeta(amesM);
                    
                    if(tueur.getRole() == Roles.TOINOU && tueur.getPlayer().getItemInHand() == ames) {
                    	
                    	res = 110;
                    	
                    }
                    
                    double resi = event.getDamage(DamageModifier.BASE)*((res/100)-1);
                    event.setDamage(DamageModifier.RESISTANCE, -resi);
                	
                }
                
                damage = event.getFinalDamage();
                
                if(joueur.getRole() == Roles.GAMEBLACK && main.getJoueurByRole(Roles.GAMEBLACK).getCamp().equalsIgnoreCase("uhc")) {
            		
                	Random r = new Random();
                    int nb = r.nextInt(100);
                	
            		if(nb <= 5 && main.getJoueurByRole(Roles.GAMEBLACK).getSpeed() < 1.2) {
            			
            			main.getJoueurByRole(Roles.GAMEBLACK).addSpeed(0.01);
            			
            		}
            		
            	}
                
                if(joueur == main.getNeko()) {
                	
                	if(!main.getNeko().isProche(Roles.MAKA, main)) {
                		
                		main.getJoueurByRole(Roles.MAKA).getPlayer().sendMessage("Neko vient de recevoir un coup de " + tueur.getPlayer().getName());
                		
                	}
                	
                	if(!tueur.isFrappeNeko()) {
                		
	                	if(tueur.getRole() == Roles.OBSCUR && main.isAdaptionObscurActif() && !main.getAdaptionPermaObscur().contains(Pouvoirs.MAKA_NEKO)) {
	                		
	                		tueur.setFrappeNeko(true);
	                		ItemCD cycle = new ItemCD(main, joueur, "frappe_neko", 5, tueur, null, null, null, null);
		        	        cycle.runTaskTimer(main, 0, 20);
		        	        if(main.getAdaptionAvantObscur().contains(Pouvoirs.MAKA_NEKO)) {
		        	        	
		        	        	main.getAdaptionPermaObscur().add(Pouvoirs.MAKA_NEKO);
		        	        	
		        	        }
		        	        else {
		        	        	
		        	        	main.getAdaptionObscur().add(Pouvoirs.MAKA_NEKO);
		        	        	
		        	        }
	                		
	                	}
	                	else {
	                		
	                		tueur.setFrappeNeko(true);
		                	ItemCD cycle = new ItemCD(main, joueur, "frappe_neko", 10, tueur, null, null, null, null);
		        	        cycle.runTaskTimer(main, 0, 20);
		        	        
	                	}
	        	        
                	}
                	
                }
                
                if(joueur.getRole() == Roles.RAPTOR && tueur.getRole() == Roles.TOINOU && tueur.isCheatToinou()) {
        			
        			damage *= 1.03;
        			
        		}
                
                if(joueur.isFireOn() || (tueur.getRole() == Roles.MAKA && tueur.getForme().equalsIgnoreCase("normal"))) {
                	
                	Random r = new Random();
                    int nb = r.nextInt(100);
                    
                    if(nb <= 10) {
                	
                    	joueur.getPlayer().setFireTicks(100);
                    	
                    }
                	
                }
                
                //ORBES
                if(joueur.isOrbeActif()) {
                	
                	Random r = new Random();
                    int nb = r.nextInt(100);
                	
                	//BONUS
                	if(joueur.getOrbe() == Orbe.EAU && tueur.getOrbe() == Orbe.FEU) {
                        
                        if(nb <= 10) {
                    	
                        	Eau.Bonus(joueur, main, true);
                        	
                        }
                		
                	}
                	else if(joueur.getOrbe() == Orbe.FEU && tueur.getOrbe() == Orbe.GLACE) {
                        
                        if(nb <= 10) {
                    	
                        	Feu.Bonus(joueur, main, true);
                        	
                        }
                		
                	}
                	else if(joueur.getOrbe() == Orbe.GLACE && tueur.getOrbe() == Orbe.FOUDRE) {
                        
                        if(nb <= 10) {
                    	
                        	Glace.Bonus(joueur, main, true);
                        	
                        }
                		
                	}
                	else if(joueur.getOrbe() == Orbe.FOUDRE && tueur.getOrbe() == Orbe.EAU) {
                        
                        if(nb <= 10) {
                    	
                        	Foudre.Bonus(joueur, main, true);
                        	
                        }
                		
                	}
                	
                	//MALUS
                	if(joueur.getOrbe() == Orbe.EAU && tueur.getOrbe() == Orbe.FOUDRE) {
                        
                        if(nb <= 10) {
                    	
                        	Eau.Malus(joueur, main, true);
                        	
                        }
                		
                	}
                	else if(joueur.getOrbe() == Orbe.FEU && tueur.getOrbe() == Orbe.EAU) {
                        
                        if(nb <= 10) {
                    	
                        	Feu.Malus(joueur, main, true);
                        	
                        }
                		
                	}
                	else if(joueur.getOrbe() == Orbe.GLACE && tueur.getOrbe() == Orbe.FEU) {
                        
                        if(nb <= 10) {
                    	
                        	Glace.Malus(joueur, main, true);
                        	
                        }
                		
                	}
                	else if(joueur.getOrbe() == Orbe.FOUDRE && tueur.getOrbe() == Orbe.GLACE) {
                        
                        if(nb <= 10) {
                    	
                        	Foudre.Malus(joueur, main, true);
                        	
                        }
                		
                	}
                	
                }
                
                if(tueur.getOrbe() == Orbe.FEU) {
                	
                	Random r = new Random();
                    int nb = r.nextInt(100);
                    
                    if((tueur.isOrbePassifActif() && nb <= 5 && tueur.isMalusOrbeActif()) || (tueur.isOrbePassifActif() && nb <= 10 && !tueur.isMalusOrbeActif())) {
                	
                    	joueur.getPlayer().setFireTicks(100);
                    	
                    }
                	
                }
                
                if(tueur.getOrbe() == Orbe.GLACE && tueur.isOrbePassifActif()) {
                	
                	Glace.Freeze(player);
                	
                }
                
                //ANTI KB
                if (joueur.isAntiKB()) {

                    event.setCancelled(true);
                    player.damage(event.getFinalDamage());

                }
                
                if(joueur.getRole() == Roles.SLUP && main.getLocZoneSlup() != null) {
                	
                	if(joueur.isInSlupZone(main)) {
                		
                		Random r = new Random();
                        int nb = r.nextInt(100);
                        
                        if(nb <= 20) {
                        	
                        	event.setCancelled(true);
                        	
                        }
                		
                	}
                	
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
                        int pourcent = joueur.getCube() * 3;

                        if (nb < pourcent + 1 && !(joueur.getRole() == Roles.OBSCUR && main.getAdaptionPermaObscur().contains(Pouvoirs.JOKO_CUBE))) {
                        	
                        	if(joueur.getRole() == Roles.OBSCUR && main.isAdaptionObscurActif()) {
                        		
                        		if(main.getAdaptionAvantObscur().contains(Pouvoirs.JOKO_CUBE)) {
                        			
                        			main.getAdaptionPermaObscur().add(Pouvoirs.JOKO_CUBE);
                        			
                        		}
                        		else {
                        			
                        			main.getAdaptionObscur().add(Pouvoirs.JOKO_CUBE);
                        			joueur.Stun(5, main);
    	                        	joueur.removeCube(main, GameCycle.getScoreboardJoko());
    	                            main.getJokoStun().add(joueur);
    	
    	                            killer.sendMessage("Vous venez de stun " + player.getName());
    	
    	                            ItemCD cycle = new ItemCD(main, tueur, "stun", 5, joueur, null, null, null, null);
    	                            cycle.runTaskTimer(main, 0, 20);
                        			
                        		}
                        		
                        	}
                        	else {

	                        	joueur.Stun(10, main);
	                        	joueur.removeCube(main, GameCycle.getScoreboardJoko());
	                            main.getJokoStun().add(joueur);
	
	                            killer.sendMessage("Vous venez de stun " + player.getName());
	
	                            ItemCD cycle = new ItemCD(main, tueur, "stun", 10, joueur, null, null, null, null);
	                            cycle.runTaskTimer(main, 0, 20);
	                            
                        	}

                        }

                    }

                }
                
                if (player.getHealth() <= event.getFinalDamage()) {
                	
                	if(joueur.canRespawn()) {
                		
                		respawn(joueur, main);
                		
                	}
                	else {

	                    ItemCD cycle = new ItemCD(main, tueur, "mort", 0, joueur, event, null, null, joueur.getPlayer().getLocation());
	                    cycle.runTaskTimer(main, 0, 20);
	                    event.setDamage(0);
	                    player.setGameMode(GameMode.SPECTATOR);
	                    //player.sendMessage("Vous êtes mort mais vous avez encore une chance de ressucité");
	                    
                	}

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
        	
        	Player player = (Player) victim;
        	
        	if(joueur.isInvulnerable()) {
        		
        		event.setCancelled(true);
        		
        	}
        	
        	if(event.getCause() == DamageCause.FALL && joueur.isNofall()) {
        		
        		event.setCancelled(true);
        		
        	}
        	
        	if(event.getCause() == DamageCause.FIRE || event.getCause() == DamageCause.FIRE_TICK) {
        		
        		if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbePassifActif()) {
        			
        	        Random r = new Random();
        	        int nb = r.nextInt(100);

        	        if (nb <= 10) {

        	            joueur.getPlayer().setFireTicks(0);
        	            event.setCancelled(true);

        	        }
        			
        		}
        		
        	}
        	
        	if (player.getHealth() <= event.getFinalDamage()) {
        		
        		if(joueur.canRespawn()) {
        			
        			respawn(joueur, main);
        			
        		}
        		else {

	                ItemCD cycle = new ItemCD(main, joueur.getLastHit(), "mort", 0, joueur, null, null, null, joueur.getPlayer().getLocation());
	                cycle.runTaskTimer(main, 0, 20);
	                event.setDamage(0);
	                player.setGameMode(GameMode.SPECTATOR);
	                //player.sendMessage("Vous êtes mort mais vous avez encore une chance de ressucité");
	                
        		}

            }
        	
        }

    }

}
