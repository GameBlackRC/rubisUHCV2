package fr.gameblack.rcuhcv2.roles.v1.rc;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.Pouvoirs_GB;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBlackV1 {

    public static void Items(Joueur joueur, Main main) {
    	
    	Random r = new Random();
        int nb = r.nextInt(4);
        
        if(nb == 1) {
        	
        	PouvoirFlair(joueur);
        	
        }
        else if(nb == 2) {
        	
        	PouvoirInvisible(joueur, main);
        	
        }
        else if(nb == 3) {
        	
        	PouvoirSpeed(joueur);
        	
        }
        else {
        	
        	//PouvoirPourcent(joueur);
        	PouvoirSpeed(joueur);
        	
        }

    }
    
    public static void PouvoirFlair(Joueur joueur) {
    	
    	Texte(joueur.getPlayer(), 0);
    	joueur.setPouvoirGB(Pouvoirs_GB.FLAIR);
    	joueur.setFlairGB(true);
    	
    }
    
    public static void PouvoirInvisible(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();
    	
    	Texte(player, 1);
    	joueur.setPouvoirGB(Pouvoirs_GB.INVISIBLE);
    	joueur.addForce(main.getForceIBaseV1());
    	joueur.addResi(0.05);
    	ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Camouflage");
        coffre.setItemMeta(coffreM);
        player.getInventory().addItem(coffre);
    }
    
    public static void PouvoirSpeed(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();
    	
    	Texte(player, 2);
    	joueur.setPouvoirGB(Pouvoirs_GB.SPEED);
    	player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
    	
    }
    
    public static void PouvoirPourcent(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();
    	
    	Texte(player, 3);
    	joueur.setPouvoirGB(Pouvoirs_GB.POURCENT);
    	player.setMaxHealth(18);
    	
    }
    
    public static void DesactInvi(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();
    	
    	joueur.show(main);
    	joueur.setInvisible(false);
		joueur.addForce(main.getForceIBaseV1());
		joueur.addResi(0.05);
		joueur.removeSpeed(0.15);
    	player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1200, 0, false, false));
    	main.getCD().add(Pouvoirs.GB_CAMOUFLAGE);
    	ItemCD cycle = new ItemCD(main, joueur, "camouflage", 600, joueur, null, null, 0, null);
        cycle.runTaskTimer(main, 0, 20);
    	
    }
    
    public static void InteractCamouflage(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();
    	
    	if(joueur.getPouvoirGB() == Pouvoirs_GB.INVISIBLE) {
    		
    		if(!joueur.isInvisible()) {
    			
    			if(!main.getCD().contains(Pouvoirs.GB_CAMOUFLAGE)) {
    	
			    	joueur.hide(main);
			    	joueur.setInvisible(true);
			    	
			    	joueur.removeForce(main.getForceIBaseV1());
			    	joueur.removeResi(0.05);
			    	joueur.addSpeed(0.15);
			    	
    			}
    			else {
    				
    				player.sendMessage("Ce pouvoir est en cooldown");
    				
    			}
	    	
    		}
    		else {
    			
    			DesactInvi(joueur, main);
    			
    		}
	    	
    	}
    	
    }

    //public static void InteractApple(Player player, Main main) {

        //player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
        //player.setMaxHealth(16);
        //main.setPacteGB(1);
        //player.getInventory().remove(Material.NETHER_STAR);
        //player.sendMessage("Vous avez choisis le pacte 1");

    //}

    //public static void InteractSword(Player player, Main main) {

        //player.setMaxHealth(14);
        //if (!player.getInventory().contains(new ItemStack(Material.DIAMOND_SWORD, 1))) {

            //ItemStack coffre = new ItemStack(Material.DIAMOND_SWORD, 1);
            //ItemMeta coffreM = coffre.getItemMeta();
            //coffreM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
            //coffre.setItemMeta(coffreM);
            //player.getInventory().addItem(coffre);

        //} else {

            //ItemStack coffre = new ItemStack(Material.DIAMOND, 2);
            //player.getInventory().addItem(coffre);

        //}
        //main.setPacteGB(2);
        //player.getInventory().remove(Material.NETHER_STAR);
        //player.sendMessage("Vous avez choisis le pacte 2");

    //}

    public static void CommandNerf(Joueur joueur, Main main) {

        main.getCD().add(Pouvoirs.GB_NERF);

        Random r = new Random();
        int nb = r.nextInt(2);

        if (nb == 1) {
            joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0, false, false));
        } else {
            joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0, false, false));
        }

    }

    public static void CommandRecrut(Player player, Joueur cible, Main main) {

        //main.getCD().add(Pouvoirs.GB_RECRUT);

        if (cible.getRole() == Roles.Farmeurimmo || cible.getRole() == Roles.GameBlack || cible.getRole() == Roles.Joko || cible.getRole() == Roles.Maka || cible.getRole() == Roles.Loup || cible.getRole() == Roles.Team || cible.getRole() == Roles.Trial) {

            player.sendMessage("§aCe joueur fait partie du staff de Rubis Craft");

        } else {

            player.sendMessage("§cCe joueur ne fait pas partie du staff de Rubis Craft");

        }

    }
    
    public static void CommandFlair(Joueur joueur, Joueur cible, Main main) {
    	
    	if(main.getFlairGB() == joueur) {
    	
	    	main.getFlairGB().setFlairGB(false);
	    	cible.setFlairGB(true);
	    	
    	}
    	else {
    		
    		joueur.getPlayer().sendMessage("Un autre joueur possède déjà votre pouvoir 'Flair'");
    		
    	}
    	
    }
    
    public static void CommandBack(Joueur joueur, Main main) {
    	
    	if(main.getFlairGB() != joueur) {
        	
	    	main.getFlairGB().setFlairGB(false);
	    	joueur.setFlairGB(true);
	    	
    	}
    	else {
    		
    		joueur.getPlayer().sendMessage("Vous possedez déjà votre pouvoir 'Flair'");
    		
    	}
    	
    }
    
    public static void CommandChoose(Joueur joueur, Main main, boolean coeur) {
    	
    	Player player = joueur.getPlayer();
    	
    	if(joueur.getPouvoirGB() == Pouvoirs_GB.SPEED) {
    	
	    	if(main.getGbKill() != null) {
	    	
		    	if(coeur) {
		    		
		    		player.setMaxHealth(player.getMaxHealth() + 1);
		    		
		    	}
		    	else {
		    		
		    		Random r = new Random();
		            int nb = r.nextInt(2);
		
		            if (nb == 1) {
		            	joueur.addForce(0.05);
		            } else {
		            	joueur.addResi(0.05);
		            }
		    		
		    	}
		    	
		    	main.setGbKill(null);
		    	
	    	}
	    	else {
	    		
	    		player.sendMessage("Vous devez faire un kill avant d'utiliser cette commande");
	    		
	    	}
	    	
    	}
    	else if(joueur.getPouvoirGB() == Pouvoirs_GB.POURCENT) {
    		
    		if(coeur) {
	    		
	    		player.setMaxHealth(player.getMaxHealth() - 1);
	    		
	    	}
	    	else {
	    		
	    		Random r = new Random();
	            int nb = r.nextInt(3);
	
	            if (nb == 1) {
	            	joueur.removeForce(0.02);
	            } else if(nb == 2){
	            	joueur.removeResi(0.02);
	            } else {
	            	joueur.removeSpeed(0.02);
	            }
	    		
	    	}
    		
    	}
    	else {
    		
    		player.sendMessage("Vous avez ni le pouvoir 'Speed', ni le pouvoir 'Pourcent'");
    		
    	}
    	
    }
    
    public static void CommandChooseOther(Joueur joueur, Main main, boolean coeur) {
    	
    	Player player = joueur.getPlayer();
	    	
    	if(coeur) {
		    		
    		player.setMaxHealth(player.getMaxHealth() - 1);
		    		
    	}
		else {
		    		
			player.sendMessage("Voici le pseudo de GameBlack : " + main.getJoueurByRole(Roles.GameBlack).getPlayer().getName());
			main.getJoueurByRole(Roles.GameBlack).getPlayer().sendMessage(player.getName() + " connaît désormais votre identité");
		    		
		}
		
		joueur.setUseChoose(true);
    	
    }
    
    public static void CommandPourcent(Player player, Joueur cible, Main main) {
    	
    	player.sendMessage(cible.getPlayer().getName() + " : " + cible.getGBPourcent() + "(" + cible.getLVLGBRestant() + ")");
    	
    }
    
    public static void CommandDemon(Joueur joueur, Joueur cible, Main main) {
    	
    	Player player = joueur.getPlayer();
    	
    	if(cible.getCamp().equalsIgnoreCase("demon")) {
    		
    		player.sendMessage(cible.getPlayer().getName() + " est bien un démon");
    		cible.setGBFindThisDemon(true);
    		
    	}
    	else {
    		
    		player.setMaxHealth(player.getMaxHealth() - 4);
    		
    	}
    	
    }
    
    public static void CommandBuff(Player player, Joueur cible, Main main, int nb) {
    	
    	if(cible.getLVLGBRestant() != 0) {
    	
	    	if((nb*10) - cible.getGBPourcent() <= 100 && nb > 0) {
	    	
		    	if(player.getLevel() >= nb) {
		    		
		    		player.setLevel(player.getLevel() - nb);
		    		cible.setLVLGBRestant(nb);
		    		
		    		
		    	}
		    	else {
		    		
		    		player.sendMessage("Vous n'avez pas assez de niveau");
		    		
		    	}
		    	
	    	}
	    	else {
	    		
	    		player.sendMessage("Vous avez rentrer un nombre invalide : le nombre doit être compris entre 0 et 10 - la dizaine de poucentage que le joueur possède déjà");
	    		
	    	}
	    	
    	}
    	else {
    		
    		player.sendMessage("Les poucentages de ce joueur sont déjà en train d'augmenter");
    		
    	}
    	
    }
    
    public static void CommandCos(Player player, Main main) {
    	
    	//String txt = "";
    	
    	//for(Player pls : main.getPlayers()) {
    		
    		//if(main.getRole(pls) != Roles.None && main.getGBPourcent(pls) >= 60) {
    			
    			//txt += "\n" + pls.getName() + " : " + pls.getLocation().getX() + ", " + pls.getLocation().getY() + ", " + pls.getLocation().getZ();
    			
    		//}
    		
    	//}
    	//player.sendMessage(txt);
    	
    }

    public static void CommandInspect(Joueur joueur, Joueur cible, Main main, boolean cd) {

    	if(cd) {
    		main.getCD().add(Pouvoirs.GB_INSPECT);
    	}

        List<String> effets = new ArrayList<>();
        if (cible.getResi() >= (110 + (main.getResiIBaseV1()*100))) {

            effets.add("§7résistance");

        } 
        if (cible.getPlayer().hasPotionEffect(PotionEffectType.FAST_DIGGING)) {

            effets.add("§ehaste");

        } 
        if (cible.getPlayer().hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {

            effets.add("§6résistance au feu");

        } 
        if (cible.getForce() >= 1 + main.getForceIBaseV1()) {

            effets.add("§cforce");

        } 
        if (cible.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY)) {

            effets.add("§binvisibilité");

        } 
        if (cible.getPlayer().hasPotionEffect(PotionEffectType.SPEED)) {

            effets.add("§9rapidité");

        } 
        if (cible.getPlayer().hasPotionEffect(PotionEffectType.WEAKNESS)) {

            effets.add("§4faiblesse");

        }

        if (effets.size() == 0) {

            joueur.getPlayer().sendMessage("§cLe joueur " + cible.getPlayer().getName() + " n'a pas d'effet");

        } else {

            Random r = new Random();
            int nb = r.nextInt(effets.size());

            joueur.getPlayer().sendMessage("Le joueur " + cible.getPlayer().getName() + " possède l'effet " + effets.get(nb));

        }

    }
    
    public static void giveLVL(Main main, String type) {
    	
    	Joueur gb = main.getJoueurByRole(Roles.GameBlack);
    	
    	if(type.equalsIgnoreCase("episode")) {
    		
    		if(main.getEpisode() != 1) {
    		
	    		if(gb != null && gb.getPouvoirGB() == Pouvoirs_GB.POURCENT) {
	            	
	            	if(main.getEpisode() <= 3) {
	            	
	            		gb.getPlayer().setLevel(gb.getPlayer().getLevel() + 2);
	            	
	            	}
	            	else {
	            		
	            		gb.getPlayer().setLevel(gb.getPlayer().getLevel() + 1);
	            		
	            	}
	            	
	            }
	    		
    		}
    		
    	}
    	
    }
    
    public static void checkProche(Main main) {
    	
    	Joueur gb = main.getJoueurByRole(Roles.GameBlack);
    	
    	if(gb != null && gb.getPouvoirGB() == Pouvoirs_GB.POURCENT) {
        	
        	List<Joueur> proche_gb = new ArrayList<>();
        	
        	for(Entity entity : gb.getPlayer().getNearbyEntities(20, 20, 20)) {
        		
        		if(entity instanceof Player) {
        			
        			Player pls = (Player) entity;
        			Joueur j = main.getJoueur(pls);
        			proche_gb.add(j);
        			
        			if(j.getGBPourcent() >= 30) {
        				
        				if(j.getCamp().equalsIgnoreCase("rc")) {
        					
        					if(!j.isEffetProcheGB()) {
        					
        						if(j.getBonusPalier10GB().equalsIgnoreCase("force")) {
        							
        							j.addForce(0.05);
        							
        						}
        						else if(j.getBonusPalier10GB().equalsIgnoreCase("resi")) {
        							
        							j.addResi(0.05);
        							
        						}
        						
        					}
        					
        				}
        				else {
        					
        					if(!j.isEffetProcheGB()) {
            					
        						if(j.getBonusPalier10GB().equalsIgnoreCase("force")) {
        							
        							j.removeForce(0.05);
        							
        						}
        						else if(j.getBonusPalier10GB().equalsIgnoreCase("resi")) {
        							
        							j.removeResi(0.05);
        							
        						}
        						
        					}
        					
        				}
        				
        				if(!j.isEffetProcheGB()) {
        					
        					j.setEffetProcheGB(true);
    						
    					}
        				
        			}
        			else if(j.getGBPourcent() >= 10) {
        				
        				if(j.getCamp().equalsIgnoreCase("rc")) {
        					
        					if(!j.isEffetProcheGB()) {
        					
        						if(j.getBonusPalier10GB().equalsIgnoreCase("force")) {
        							
        							j.addForce(0.05);
        							
        						}
        						else if(j.getBonusPalier10GB().equalsIgnoreCase("resi")) {
        							
        							j.addResi(0.05);
        							
        						}
        						
        					}
        					
        				}
        				else {
        					
        					if(!j.isEffetProcheGB()) {
            					
        						if(j.getBonusPalier10GB().equalsIgnoreCase("force")) {
        							
        							j.removeForce(0.05);
        							
        						}
        						else if(j.getBonusPalier10GB().equalsIgnoreCase("resi")) {
        							
        							j.removeResi(0.05);
        							
        						}
        						
        					}
        					
        				}
        				
        				if(!j.isEffetProcheGB()) {
        					
        					j.setEffetProcheGB(true);
    						
    					}
        				
        			}
        			
        		}
        		
        	}
        	
            	for(Joueur j : main.getListJoueurs()) {
            		
            		if(!proche_gb.contains(j) && j.getRole() != Roles.NONE && !j.isMort() && j.isEffetProcheGB()) {
            			
            			if(j.getGBPourcent() >= 30) {
            				
            				if(j.getCamp().equalsIgnoreCase("rc")) {
            					
            					if(j.getBonusPalier10GB().equalsIgnoreCase("force")) {
        							
        							j.removeForce(0.05);
        							
        						}
        						else if(j.getBonusPalier10GB().equalsIgnoreCase("resi")) {
        							
        							j.removeResi(0.05);
        							
        						}
            					
            				}
            				else {
            					
            					if(j.getBonusPalier10GB().equalsIgnoreCase("force")) {
        							
        							j.addForce(0.05);
        							
        						}
        						else if(j.getBonusPalier10GB().equalsIgnoreCase("resi")) {
        							
        							j.addResi(0.05);
        							
        						}
            					
            				}
            				
            				j.setEffetProcheGB(false);
            				
            			}
            			else if(j.getGBPourcent() >= 10) {
            				
            				if(j.getCamp().equalsIgnoreCase("rc")) {
            					
            					if(j.getBonusPalier10GB().equalsIgnoreCase("force")) {
        							
        							j.removeForce(0.02);
        							
        						}
        						else if(j.getBonusPalier10GB().equalsIgnoreCase("resi")) {
        							
        							j.removeResi(0.02);
        							
        						}
            					
            				}
            				else {
            					
            					if(j.getBonusPalier10GB().equalsIgnoreCase("force")) {
        							
        							j.addForce(0.02);
        							
        						}
        						else if(j.getBonusPalier10GB().equalsIgnoreCase("resi")) {
        							
        							j.addResi(0.02);
        							
        						}
            					
            				}
            				
            				j.setEffetProcheGB(false);
            				
            			}
            			
            		}
            		
            	}
        	
        }
    	
    }
    
    public static void getRole(Main main) {
    	
    	Joueur gb = main.getJoueurByRole(Roles.GameBlack);
    	
    	if(gb != null && gb.getPouvoirGB() == Pouvoirs_GB.POURCENT) {
    		
    		if(main.getCampRCVie().size() >= 3 && main.getCampDemonVie().size() >= 2) {
    			
    			if(main.getSoloVie().size() == 0) {
    				
    				for(Joueur j : main.getListJoueurs()) {
    					
    					if(j.getRole() != Roles.NONE && !j.isMort() && j.getGBPourcent() >= 50) {
    						
    						List<Joueur> proche = new ArrayList<>();
    						
    						for(Entity entity : j.getPlayer().getNearbyEntities(20, 20, 20)) {
    							
    							if(entity instanceof Player && (Player) entity != gb.getPlayer()) {
    								Player pls = (Player) entity;
    								proche.add(main.getJoueur(pls));
    								
    							}
    							
    						}
    						
    						if(proche.size() != 0) {
    							
    							Random r = new Random();
    					        int nb = r.nextInt(proche.size());
    					        Joueur cible = proche.get(nb);
    					        String txt = "Voici 4 rôles possible pour " + cible.getPlayer().getName() + " : ";
    					        
    					        if(cible.getCamp().equalsIgnoreCase("rc")) {
    					        	
    					        	int nb1_rc = r.nextInt(main.getCampRCVie().size());
    					        	while(main.getCampRCVie().get(nb1_rc) == cible || main.getCampRCVie().get(nb1_rc).getRole() == Roles.GameBlack) {
    					        		
    					        		nb1_rc = r.nextInt(main.getCampRCVie().size());
    					        		
    					        	}
    					        	int nb1_demon = r.nextInt(main.getCampDemonVie().size());
    					        	
    					        	int nb2_demon = r.nextInt(main.getCampDemonVie().size());
    					        	while(main.getCampDemonVie().get(nb1_demon) == main.getCampDemonVie().get(nb2_demon)) {
    					        		
    					        		nb2_demon = r.nextInt(main.getCampDemonVie().size());
    					        		
    					        	}
    					        	int place = r.nextInt(2);
    					        	
    					        	if(place == 1) {
    					        		
    					        		txt += cible.getRole().toString() + ", " + main.getCampRCVie().get(nb1_rc).getRole().toString() + ", ";
    					        		
    					        	}
    					        	else {
    					        		
    					        		txt += main.getCampRCVie().get(nb1_rc).getRole().toString() + ", " + cible.getRole().toString() + ", ";
    					        		
    					        	}
    					        	
    					        	txt += main.getCampDemonVie().get(nb1_demon).getRole().toString() + ", " + main.getCampDemonVie().get(nb2_demon).getRole().toString();
    					        	
    					        	gb.getPlayer().sendMessage(txt);
    					        	
    					        }
    					        else if(cible.getCamp().equalsIgnoreCase("demon")) {
    					        	
    					        	int nb1_demon = r.nextInt(main.getCampDemonVie().size());
    					        	while(main.getCampDemonVie().get(nb1_demon) == cible) {
    					        		
    					        		nb1_demon = r.nextInt(main.getCampDemonVie().size());
    					        		
    					        	}
    					        	int nb1_rc = r.nextInt(main.getCampRCVie().size());
    					        	
    					        	int nb2_rc = r.nextInt(main.getCampRCVie().size());
    					        	while(main.getCampRCVie().get(nb1_rc) == main.getCampRCVie().get(nb2_rc) || main.getCampRCVie().get(nb1_rc).getRole() == Roles.GameBlack || main.getCampRCVie().get(nb2_rc).getRole() == Roles.GameBlack) {
    					        		
    					        		nb2_rc = r.nextInt(main.getCampRCVie().size());
    					        		
    					        	}
    					        	int place = r.nextInt(2);
    					        	
    					        	txt += main.getCampRCVie().get(nb1_rc).getRole().toString() + ", " + main.getCampRCVie().get(nb2_rc).getRole().toString();
    					        	
    					        	if(place == 1) {
    					        		
    					        		txt += cible.getRole().toString() + ", " + main.getCampDemonVie().get(nb1_demon).getRole().toString();
    					        		
    					        	}
    					        	else {
    					        		
    					        		txt += main.getCampDemonVie().get(nb1_demon).getRole().toString() + ", " + cible.getRole().toString();
    					        		
    					        	}
    					        	
    					        	gb.getPlayer().sendMessage(txt);
    					        	
    					        }
    					        
    							
    						}
    						
    					}
    					
    				}
    				
    			}
    			else {
    				
    				for(Joueur j : main.getListJoueurs()) {
    					
    					if(j.getRole() != Roles.NONE && !j.isMort() && j.getGBPourcent() >= 50) {
    						
    						List<Joueur> proche = new ArrayList<>();
    						
    						for(Entity entity : j.getPlayer().getNearbyEntities(20, 20, 20)) {
    							
    							if(entity instanceof Player && (Player) entity != gb.getPlayer()) {
    								Player pls = (Player) entity;
    								proche.add(main.getJoueur(pls));
    								
    							}
    							
    						}
    						
    						if(proche.size() != 0) {
    							
    							Random r = new Random();
    					        int nb = r.nextInt(proche.size());
    					        Joueur cible = proche.get(nb);
    					        String txt = "Voici 4 rôles possible pour " + cible.getPlayer().getName() + " : ";
    					        
    					        if(cible.getCamp().equalsIgnoreCase("rc")) {
    					        	
    					        	int nb1_rc = r.nextInt(main.getCampRCVie().size());
    					        	while(main.getCampRCVie().get(nb1_rc) == cible || main.getCampRCVie().get(nb1_rc).getRole() == Roles.GameBlack) {
    					        		
    					        		nb1_rc = r.nextInt(main.getCampRCVie().size());
    					        		
    					        	}
    					        	int nb1_demon = r.nextInt(main.getCampDemonVie().size());
    					        	
    					        	int nb2_demon = r.nextInt(main.getCampDemonVie().size());
    					        	while(main.getCampDemonVie().get(nb1_demon) == main.getCampDemonVie().get(nb2_demon)) {
    					        		
    					        		nb2_demon = r.nextInt(main.getCampDemonVie().size());
    					        		
    					        	}
    					        	int nb1_solo = r.nextInt(main.getSoloVie().size());
    					        	int place = r.nextInt(2);
    					        	
    					        	if(place == 1) {
    					        		
    					        		txt += cible.getRole().toString() + ", " + main.getCampRCVie().get(nb1_rc).getRole().toString() + ", ";
    					        		
    					        	}
    					        	else {
    					        		
    					        		txt += main.getCampRCVie().get(nb1_rc).getRole().toString() + ", " + cible.getRole().toString() + ", ";
    					        		
    					        	}
    					        	
    					        	txt += main.getCampDemonVie().get(nb1_demon).getRole().toString() + ", " + main.getCampDemonVie().get(nb2_demon).getRole().toString() + ", " + main.getSoloVie().get(nb1_solo).getRole().toString();
    					        	
    					        	gb.getPlayer().sendMessage(txt);
    					        	
    					        }
    					        else if(cible.getCamp().equalsIgnoreCase("demon")) {
    					        	
    					        	int nb1_demon = r.nextInt(main.getCampDemonVie().size());
    					        	while(main.getCampDemonVie().get(nb1_demon) == cible) {
    					        		
    					        		nb1_demon = r.nextInt(main.getCampDemonVie().size());
    					        		
    					        	}
    					        	int nb1_rc = r.nextInt(main.getCampRCVie().size());
    					        	
    					        	int nb2_rc = r.nextInt(main.getCampRCVie().size());
    					        	while(main.getCampRCVie().get(nb1_rc) == main.getCampRCVie().get(nb2_rc) || main.getCampRCVie().get(nb1_rc).getRole() == Roles.GameBlack || main.getCampRCVie().get(nb2_rc).getRole() == Roles.GameBlack) {
    					        		
    					        		nb2_rc = r.nextInt(main.getCampRCVie().size());
    					        		
    					        	}
    					        	int nb1_solo = r.nextInt(main.getSoloVie().size());
    					        	int place = r.nextInt(2);
    					        	
    					        	txt += main.getCampRCVie().get(nb1_rc).getRole().toString() + ", " + main.getCampRCVie().get(nb2_rc).getRole().toString();
    					        	
    					        	if(place == 1) {
    					        		
    					        		txt += cible.getRole().toString() + ", " + main.getCampDemonVie().get(nb1_demon).getRole().toString();
    					        		
    					        	}
    					        	else {
    					        		
    					        		txt += main.getCampDemonVie().get(nb1_demon).getRole().toString() + ", " + cible.getRole().toString();
    					        		
    					        	}
    					        	
    					        	txt += ", " + main.getSoloVie().get(nb1_solo).getRole().toString();
    					        	
    					        	gb.getPlayer().sendMessage(txt);
    					        	
    					        }
    					        else {
    					        	
    					        	int nb1_demon = r.nextInt(main.getCampDemonVie().size());
    					        	int nb2_demon = r.nextInt(main.getCampDemonVie().size());
    					        	while(main.getCampDemonVie().get(nb1_demon) == main.getCampDemonVie().get(nb2_demon)) {
    					        		
    					        		nb2_demon = r.nextInt(main.getCampDemonVie().size());
    					        		
    					        	}
    					        	
    					        	int nb1_rc = r.nextInt(main.getCampRCVie().size());
    					        	int nb2_rc = r.nextInt(main.getCampRCVie().size());
    					        	while(main.getCampRCVie().get(nb1_rc) == main.getCampRCVie().get(nb2_rc) || main.getCampRCVie().get(nb1_rc).getRole() == Roles.GameBlack || main.getCampRCVie().get(nb2_rc).getRole() == Roles.GameBlack) {
    					        		
    					        		nb2_rc = r.nextInt(main.getCampRCVie().size());
    					        		
    					        	}
    					        	
    					        	txt += main.getCampRCVie().get(nb1_rc).toString() + ", " + main.getCampRCVie().get(nb2_rc).toString() + ", " + main.getCampDemonVie().get(nb1_demon).toString() + ", " + main.getCampDemonVie().get(nb2_demon).toString() + ", " + cible.getRole().toString();
    					        	
    					        	gb.getPlayer().sendMessage(txt);
    					        		
    					        }
    							
    						}
    						
    					}
    					
    				}
    				
    			}
    			
    		}
    		
    	}
    	
    }
    
    public static void useFlair(Main main) {
    	
    	Joueur gb = main.getJoueurByRole(Roles.GameBlack);
    	
    	if(gb != null && main.getFlairGB() == gb) {
        	int nb_demon = 0;
        	for(Entity entity: gb.getPlayer().getNearbyEntities(20, 20, 20)) {
        		
        		if(entity instanceof Player) {
        			
        			Player player = (Player) entity;
        			
        			Joueur j = main.getJoueur(player);
        			
        			if((j.getCamp().equalsIgnoreCase("demon") && j.getRole() != Roles.Slup) || j.getRole() == Roles.Experimental) {
        				
        				nb_demon += 1;
        				
        			}
        			
        		}
        		
        	}
        	
        	Random r = new Random();
            int nb = r.nextInt(10);
            
            if(nb == 1) {
            	
            	nb_demon += 1;
            	
            }
            
            if(nb_demon < 2) {
            
            	gb.getPlayer().sendMessage("Il y a " + nb_demon + " démon proche de vous");
            	
            }
            else {
            	
            	gb.getPlayer().sendMessage("Il y a " + nb_demon + " démons proche de vous");
            	
            }
            
    	}
    	else {
    		
        	int nb_demon = 0;
        	boolean gb_proche = false;
        	for(Entity entity: main.getFlairGB().getPlayer().getNearbyEntities(20, 20, 20)) {
        		
        		if(entity instanceof Player) {
        			
        			Player player = (Player) entity;
        			Joueur j = main.getJoueur(player);
        			
        			if((j.getCamp().equalsIgnoreCase("demon") && j.getRole() != Roles.Slup) || j.getRole() == Roles.Experimental) {
        				
        				nb_demon += 1;
        				
        			}
        			
        			if(j.getRole() == Roles.GameBlack) {
        				
        				gb_proche = true;
        				
        			}
        			
        		}
        		
        	}
        	
        	if(gb_proche) {
        		
            	Random r = new Random();
                int nb = r.nextInt(2);
                
                if(nb == 1) {
                	
                	nb_demon += 1;
                	
                }
                
        	}
            
            if(nb_demon < 2) {
            
            	gb.getPlayer().sendMessage("Il y a " + nb_demon + " démon proche du joueur");
            	
            }
            else {
            	
            	gb.getPlayer().sendMessage("Il y a " + nb_demon + " démons proche du joueur");
            	
            }
    		
    	}
    	
    }

    public static void GBProcheFlair(Main main) {
    	
    	Joueur flair = main.getFlairGB();
    	Joueur gb = main.getJoueurByRole(Roles.GameBlack);
    	
    	if(flair.isProche(Roles.GameBlack, main)) {
    		
    		if(!gb.isNerfFlairGB()) {
    			
    			gb.setNerfFlairGB(true);
    			gb.removeForce(0.05);
    			gb.removeResi(0.05);
    			
    		}
    		
    	}
    	else {
    		
    		if(gb.isNerfFlairGB()) {
    			
    			gb.setNerfFlairGB(false);
    			gb.addForce(0.05);
    			gb.addResi(0.05);
    			
    		}
    		
    	}
    	
    }
    
    public static void Texte(Player player, int pouvoir) {
    	
    	if(pouvoir == 0) {
    		
    		player.sendMessage("____________________________________________________\n \nVous êtes §aGameBlack\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez le pouvoir 'Flair'\n A chaque début d'épisode, vous recevez un message vous avertissant du nombre de démons proche de vous. Il y a 10% de chance que le nombre sois faux (ajout d'un démon)\n \nAvec la commande §b/rcflair <pseudo>§r, vous pouvez transférer votre pouvoir à un autre jour qui ne seras pas avertit. Dans ce cas, à chaque début d'épisode vous recevrez le nombre de démons proche de ce joueur (il n'est pas compter dedans). Si vous êtes proche du joueur, vous perdrez §95% de force et de résistance§r et la chance que le nombre sois faux passeras à 50% sinon la chance que le nombre sois faux passeras à 0%.\n Lorsque le joueur possèdant le flair meurt, vous recevrez §92% de speed§r ainsi que le rôle du tueur et vous récuperez votre pouvoir.\nAvec la commande §b/rcback§r, vous récuperez votre pouvoir si un joueur le possède\n \n____________________________________________________");
    		
    	}
    	else if(pouvoir == 1) {
    		
    		player.sendMessage("____________________________________________________\n \nVous êtes §aGameBlack\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez le pouvoir 'Invisibilité'\n \nVous avez l'effet §9force I §rlorsque vous êtes visible ainsi que §920% de résistance§r et §915% de speed§r quand vous êtes invisible\n \nA l'annonce des rôles, vous recevez un item nommé '§dCamouflage§r' vous retirant votre armure (elle sera mise dans les 4 slots en haut à droite de votre inventaire en supprimant les items qui était à ces emplacements) et vous rendant invisible. Vous restez invisible tant que vous n'infliger aucun dégâts ou que vous ne réutiliser pas votre item. Lorsque vous redevenez visible, vous obtiendrez l'effet §9faiblesse I§r pendant 1 minute, votre armure seras automatiquement équiper et vous ne pourrez plus devenir invisible pendant 10 minutes. Lorsque vous êtes invisible et qu'un joueur meurt, vous obtiendrez une liste de 5 pseudos qui contient le tueur de ce joueur\n \n____________________________________________________");
    		
    	}
    	else if(pouvoir == 2) {
    		
    		player.sendMessage("____________________________________________________\n \nVous êtes §aGameBlack\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez le pouvoir 'Speed'\n \nVous avez l'effet §9speed I §rpermanent\n \nA chaque coup que vous recevez, vous avez 10% de chance de recevoir §91% de speed§r supplémentaire\n \nA chaque kill que vous effectuez, vous pouvez choisir avec la commande §b/rcchoose <cœur|effet>§r entre recevoir 1/2 cœur supplémentaire ou §95% d’un effet aléatoire entre force et résistance§r\n \nAvec la commande §b/rcinspect <pseudo>§r, vous connaîtrez un effet de la personne ciblé\n \nAvec la commande §b/rcnerf <pseudo>§r, vous donnerez aléatoirement l'effet §9faiblesse I§r ou §9lenteur I§r pendant 10 secondes\n \n____________________________________________________");
    		
    	}
    	else if(pouvoir == 3) {
    		
    		player.sendMessage("____________________________________________________\n \nVous êtes §aGameBlack\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez le pouvoir 'Pourcent'\n \nVous avez 2 cœurs permanent en moins\n \nAvec la commande §b/rcbuff <pseudo> <nombre>§r, vous pourrez augmenter le pourcentage du joueur (10% fois le nombre donner) en échange de niveaux d’xp (en fonction du nombre)\n \nLorsque vous tuer un démon ou un solo ayant atteint les 100%, vous recevez §95% de speed§r supplémentaire\nLorsqu’un joueur du camp rc ayant atteint les 100% viens à mourir, vous avez le choix entre perdre 1/2 cœur permanent ou perdre §92% d’un effet aléatoire§r\n \nAvec la commande §b/rcdemon <pseudo>§r, vous êtes mis au courant si le joueur est un démon et le palier des 100% peut désormais être actif. Si le joueur n’est pas démon, vous perdez 2 cœurs permanent\n \nVous pouvez voir l’avancement du pourcentage d’un joueur au-dessus de sa tête et avec la commande §b/rcpourcent <pseudo>§r\n \nEn plus des moyens vanilla de gagner de l’xp, vous gagnerez 2 niveaux au début des épisodes 1 et 2 (1 niveaux pour ceux d’après), vous aurez 10% de chance d’en gagner un à chaque coup d’épée et vous gagnerez 5 niveaux à chaque kill\n \nPour connaître les effets de chaque palier atteint, faites la commande §b/rcpalier <rc|demon|solo>§r\n \n____________________________________________________");
    		
    	}

        //player.sendMessage("____________________________________________________\n \nVous êtes §aGameBlack\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet §9force I §rpermanent\n \nA l'annonce des rôles, vous recevez un item nommé '§dPactes§r' vous permettant de choisir entre 2 pactes :\n- Pacte 1 : Contre §92 coeurs §rpermanents, vous recevez l'effet §9speed I §ret vous possèdez la commande §b/rcrecrut §rqui vous permet de savoir si le joueur fait parti du staff de Rubis Craft\n- Pacte 2 : Contre §93 coeurs §rpermanents, vous recevez une §dépée en diamant tranchant III §r(§d2 diamants §rsi vous en avez déjà une) et à chaque kill effectuer, vous recevez §91 coeur §rpermanent supplémentaire. Vous possèdez aussi la commande §b/rcinspect §rqui vous permet de connaitre un effet de la personne ciblé\n \nVous possèdez la commande §b/rcnerf §rvous permettant de donner aléatoirement l'effet §9faiblesse I §rou §9lenteur I §rpendant 10 secondes\n \n____________________________________________________");

    }

}