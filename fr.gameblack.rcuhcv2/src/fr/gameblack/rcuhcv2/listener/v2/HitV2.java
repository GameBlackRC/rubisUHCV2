package fr.gameblack.rcuhcv2.listener.v2;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Raptor;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Theoochoux;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Toinou;
import fr.gameblack.rcuhcv2.task.v2.GameCycle;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class HitV2 {
	
	public static void botHit(Joueur joueur, Joueur tueur, Main main) {
		
		if(tueur == null) {
			
			tueur = joueur.getCibleBot();
			
		}
        	
        if(tueur != joueur.getLastHit()) {
        		
        	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " stoppvp");
        	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " pvp " + tueur.getPlayer().getName());
        	joueur.setCibleBot(tueur);
        		
        }
        if(joueur.getPlayer().getHealth() < 4) {
        		
        	if((joueur.getRole() == Roles.FARMEURIMMO && joueur.getVol().contains(Pouvoirs.TOINOU_VACANCES)) || (joueur.getRole() == Roles.TOINOU && joueur.getCamp() != Camps.FARMEURIMMO)) {
        			
        		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " toinouvacance");
        			
        	}
        	else if(joueur.getRole() == Roles.SLUP) {
        			
        		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " slupmort");
        			
        	}
        	else if((joueur.getRole() == Roles.FARMEURIMMO && joueur.getVol().contains(Pouvoirs.KZOU_BAN)) || (joueur.getRole() == Roles.KZOU && joueur.getCamp() != Camps.FARMEURIMMO)) {
        			
        		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " kzouban " + tueur.getPlayer().getName());
        			
        	}
        		
        }
        if(joueur.getPlayer().getHealth() < 8 && joueur.getPlayer().getInventory().contains(Material.GOLDEN_APPLE) && !joueur.isBOTMange()) {
        		
        	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " stoppvp");
        	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " mange");
        	joueur.setBOTMange(true);
        	ItemCD cycle = new ItemCD(main, joueur, "BOTmange", 3, joueur, null, null, 0, null);
        	cycle.runTaskTimer(main, 0, 20);
        		
        }
		
	}
	
	public static void whenHit(Joueur joueur, Joueur tueur, Main main, EntityDamageByEntityEvent event) {
		
		Random r = new Random();
        int nb = r.nextInt(100);
        
        if(joueur.isBot()) {
        	
        	botHit(joueur, tueur, main);
        	
        }
        
        if(tueur.getRole() == Roles.ROMPREMS && tueur.getNbKillBlaze() > 0) {
        	
			nb = r.nextInt(100);
			
			if(tueur.getNbKillBlaze()*2 > nb) {
				
				joueur.getPlayer().setFireTicks(100);
				
			}
        	
        }
        
        if(tueur.getRole() == Roles.TRIAL && tueur.getModeTrial().equalsIgnoreCase("serieux")) {
			
        	nb = r.nextInt(100);
            
            if(nb <= 20) {
			
            	tueur.removeTrialHydratation(1);
			
            }
            
            if(tueur.getTrialStadeActif() == 10) {
            	
            	nb = r.nextInt(100);
                
                if(nb <= 2) {
                	
                	tueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,100,0));
                	
                }
            	
            }
            
            if(tueur.getTrialStadeActif() == 11) {
            	
            	nb = r.nextInt(100);
                
                if(nb <= 5) {
                	
                	tueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,100,0));
                	
                }
            	
            }
			
		}
        
        if(tueur.getRole() == Roles.THEOOCHOUX) {
        	
        	Theoochoux.checkBonus(main, tueur, joueur);
        	
        }
        
        if((nb <= 50 && joueur.getRole() != Roles.THEOOCHOUX) || (joueur.getRole() == Roles.THEOOCHOUX && nb <= (50-joueur.getStadeTheochouxHack()))) {
		
        	if(main.getMode() == Modes.RAPIDE) {
        	
        		joueur.addPourcentHack(2, main, GameCycle.getScoreboardFarmeurimmo());
        		
        	}
        	else {
        		
        		joueur.addPourcentHack(1, main, GameCycle.getScoreboardFarmeurimmo());
        		
        	}
    		
        }
        
        if(tueur.getRole() == Roles.HEKOW && tueur.isHekowJeuActif()) {
        	
        	tueur.addHekowPourcent(1);
        	
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
		
        if(joueur.getRole() == Roles.GAMEBLACK && main.getJoueurByRole(Roles.GAMEBLACK).getCamp() == Camps.UHC) {
    		
            nb = r.nextInt(100);
        	
    		if(nb <= 5 && main.getJoueurByRole(Roles.GAMEBLACK).getNbSpeedGBUHC() < 10) {
    			
    			main.getJoueurByRole(Roles.GAMEBLACK).addSpeed(0.01);
    			main.getJoueurByRole(Roles.GAMEBLACK).addNbSpeedGBUHC(1);
    			
    		}
    		
    	}
        
        if(tueur.getRole() == Roles.JEANNOT && tueur.isJeannotAbso() && joueur.isAbsoOn()) {
        	
            nb = r.nextInt(100);
            if(nb <= 5) {
            	
            	if(joueur.getRole() == Roles.OBSCUR) {
            		
            		if(main.isAdaptionObscurActif()) {
            		
	            		if(main.getAdaptionAvantObscur().contains(Pouvoirs.JEANNOT_ABSO)) {
	            			
	            			main.getAdaptionPermaObscur().add(Pouvoirs.JEANNOT_ABSO);
	            			
	            		}
	            		else if(!main.getAdaptionPermaObscur().contains(Pouvoirs.JEANNOT_ABSO)){
	            			
	            			main.getAdaptionObscur().add(Pouvoirs.JEANNOT_ABSO);
	            			joueur.setAbso(false);
	                    	ItemCD cycle = new ItemCD(main, tueur, "abso_jeannot", 7, joueur, null, null, 0, null);
	            	        cycle.runTaskTimer(main, 0, 20);
	            			
	            		}
	            		
            		}
            		else if(!main.getAdaptionPermaObscur().contains(Pouvoirs.JEANNOT_ABSO)) {
            			
            			joueur.setAbso(false);
                    	ItemCD cycle = new ItemCD(main, tueur, "abso_jeannot", 15, joueur, null, null, 0, null);
            	        cycle.runTaskTimer(main, 0, 20);
            			
            		}
            		
            	}
            	else {
            		
            		joueur.setAbso(false);
                	ItemCD cycle = new ItemCD(main, tueur, "abso_jeannot", 15, joueur, null, null, 0, null);
        	        cycle.runTaskTimer(main, 0, 20);
            		
            	}
            	
            }
        	
        }
        
        if(joueur == main.getNeko()) {
        	
        	if(!main.getNeko().isProche(Roles.MAKA, main)) {
        		
        		main.getJoueurByRole(Roles.MAKA).getPlayer().sendMessage("Neko vient de recevoir un coup de " + tueur.getPlayer().getName());
        		
        	}
        	
        	if(!tueur.isFrappeNeko()) {
        		
            	if(tueur.getRole() == Roles.OBSCUR && main.isAdaptionObscurActif() && !main.getAdaptionPermaObscur().contains(Pouvoirs.MAKA_NEKO)) {
            		
            		tueur.setFrappeNeko(true);
            		ItemCD cycle = new ItemCD(main, joueur, "frappe_neko", 5, tueur, null, null, 0, null);
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
                	ItemCD cycle = new ItemCD(main, joueur, "frappe_neko", 10, tueur, null, null, 0, null);
        	        cycle.runTaskTimer(main, 0, 20);
        	        
            	}
    	        
        	}
        	
        }
        
        if(joueur.isFireOn() || (tueur.getRole() == Roles.MAKA && tueur.getForme().equalsIgnoreCase("normal"))) {
        	
            nb = r.nextInt(100);
            
            if(nb <= 10) {
        	
            	joueur.getPlayer().setFireTicks(100);
            	
            }
        	
        }
        
        if(joueur.getRole() == Roles.SLUP && main.getLocZoneSlup() != null) {
        	
        	if(joueur.isInSlupZone(main)) {
        		
                nb = r.nextInt(100);
                
                if(nb <= 20) {
                	
                	event.setCancelled(true);
                	
                }
        		
        	}
        	
        }
        
        if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
        	
        	Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
        	
            nb = r.nextInt(100);
            
            if(nb <= 80) {
            	
            	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient de mettre un coup à " + ChatColor.MAGIC + "aaaaa");
            	
            }
            else {
            	
            	gb.getPlayer().sendMessage("[CONSOLE]" + tueur.getPlayer().getName() + " vient de mettre un coup à " + joueur.getPlayer().getName());
            	
            }
        	
        }
        
        if (tueur.getRole() == Roles.JOKO && tueur.isJokoItemActif()) {

            if (joueur.getCube() != 0 && !main.getJokoStun().contains(joueur)) {

                nb = r.nextInt(100);
                int pourcent = joueur.getCube() * 3;

                if (nb < pourcent + 1 && !(joueur.getRole() == Roles.OBSCUR && main.getAdaptionPermaObscur().contains(Pouvoirs.JOKO_CUBE))) {
                	
                	if(joueur.getRole() == Roles.OBSCUR && main.isAdaptionObscurActif()) {
                		
                		if(main.getAdaptionAvantObscur().contains(Pouvoirs.JOKO_CUBE)) {
                			
                			main.getAdaptionPermaObscur().add(Pouvoirs.JOKO_CUBE);
                			
                		}
                		else {
                			
                			main.getAdaptionObscur().add(Pouvoirs.JOKO_CUBE);
                			joueur.Stun(5, main);
                        	joueur.removeCube(main);
                            main.getJokoStun().add(joueur);

                            tueur.getPlayer().sendMessage("Vous venez de stun " + joueur.getPlayer().getName());

                            ItemCD cycle = new ItemCD(main, tueur, "stun", 5, joueur, null, null, 0, null);
                            cycle.runTaskTimer(main, 0, 20);
                			
                		}
                		
                	}
                	else {
                		
                		if(joueur.getRole() != Roles.Obscur && !main.getAdaptionPermaObscur().contains(Pouvoirs.JOKO_CUBE)) {

	                    	joueur.Stun(10, main);
	                    	joueur.removeCube(main);
	                        main.getJokoStun().add(joueur);
	
	                        tueur.getPlayer().sendMessage("Vous venez de stun " + joueur.getPlayer().getName());
	
	                        ItemCD cycle = new ItemCD(main, tueur, "stun", 10, joueur, null, null, 0, null);
	                        cycle.runTaskTimer(main, 0, 20);
	                        
                		}
                        
                	}

                }

            }

        }
		
	}

}
