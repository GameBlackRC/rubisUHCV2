package fr.gameblack.rcuhcv2.task.v2;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v2.Classe;
import fr.gameblack.rcuhcv2.listener.global.Mort;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.orbes.v2.Eau;
import fr.gameblack.rcuhcv2.orbes.v2.Feu;
import fr.gameblack.rcuhcv2.orbes.v2.Foudre;
import fr.gameblack.rcuhcv2.orbes.v2.Glace;
import fr.gameblack.rcuhcv2.roles.v2.staff.Hekow;
import fr.gameblack.rcuhcv2.roles.v2.staff.Loup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ItemCD extends BukkitRunnable {

	private Main main;
    private Player player;
    private String item;
    private int timer;
    private Joueur cible;
	private EntityDamageByEntityEvent event;
	private List<Joueur> players = new ArrayList<>();
    private Joueur joueur;
	private int nombre;
    private Location loc;

    public ItemCD(Main main, Joueur joueur, String item, int timer, Joueur cible, EntityDamageByEntityEvent event, List<Joueur> players, int nombre, Location loc) {
        this.main = main;
        this.player = joueur.getPlayer();
        this.joueur = joueur;
        this.item = item;
        this.timer = timer;
        this.cible = cible;
        this.event = event;
        this.players = players;
        this.nombre = nombre;
        this.loc = loc;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void run() {
    	
    	if(main.getState() != Statut.PVP_ON) {
    		
    		cancel();
    		
    	}
    	
    	if(joueur.getRole() == Roles.GAMEBLACK && joueur.getClasseGB() != Classe.SUPPORT && (item == "buffgb_coeur" || item == "buffgb_speed" || item == "buffgb_resi" || item == "buffgb_force")) {
    		
    		timer = 0;
    		
    	}
    	
    	if(item == "mortNeko") {
    		
    		if(main.getTueurNeko() == null) {
    			
    			cancel();
    			
    		}
    		
    	}
    	
    	if(item == "jackpot_hekow" && timer%10 == 0) {
    		
    		if(joueur.getPlayer().getHealth() + 1 < joueur.getPlayer().getMaxHealth()) {
    			
    			joueur.getPlayer().setHealth(joueur.getPlayer().getHealth() + 1);
    			
    		}
    		else {
    			
    			joueur.getPlayer().setHealth(joueur.getPlayer().getMaxHealth());
    			
    		}
    		
    	}
    	
    	if(item == "frappe_neko") {
    		
    		cible.setFrappeNeko(false);
    		
    	}
    	
    	if(item == "soleil_trial" && timer == 285) {
        	
        	cible.addSpeed(0.05);
        	
        }
    	
    	if(item == "soleil" && timer == 30) {
    		
    		main.setJeuTrial("soleil");
    		joueur.getPlayer().sendMessage("Le jeu 1, 2, 3 soleil commence !");
    		cible.getPlayer().sendMessage("Le jeu 1, 2, 3 soleil commence !");
    		
    	}
    	
    	if(joueur.getRole() == Roles.GAMEBLACK && item == "fuite" && timer == 58) {
    		
    		joueur.setInvulnerable(false);
    		
    	}
    	
    	if(joueur.getRole() == Roles.KZOU && item == "ban") {
    		
    		if(cible.getRole() == Roles.NONOBOY) {
    			
    			if(timer == 30) {
    		
    				cible.removeForce(0.05);
    			
    			}
    			
    		}
    		else if(timer == 60) {
    			
    			cible.removeForce(0.05);
    			
    		}
    		
    	}
    	
    	//ORBE
    	if(timer == 60) {
    		
	        if (item == "foudre_malus") {
	
	        	Foudre.Malus(joueur, main, false);
	
	        } else if (item == "eau_malus") {
	
	        	Eau.Malus(joueur, main, false);
	
	        } else if (item == "feu_malus") {
	
	            Feu.Malus(joueur, main, false);
	
	        } else if (item == "glace_malus") {
	
	        	Glace.Malus(joueur, main, false);
	
	        } else if (item == "foudre_bonus") {
	
	        	Foudre.Bonus(joueur, main, false);
	
	        } else if (item == "eau_bonus") {
	
	        	Eau.Bonus(joueur, main, false);
	
	        } else if (item == "feu_bonus") {
	
	        	Feu.Bonus(joueur, main, false);
	
	        } else if (item == "glace_bonus") {
	
	        	Glace.Bonus(joueur, main, false);
	
	        } 
    	
    	}

    	else if (timer == 0) {
        	
        	if(item == "mortNeko") {
        		
        		timer = 30;
        		joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-2);
        		
        	}
        	else {
        	
	            cancel();
	            
	            if (item == "mort") {
	
	        		if (joueur.getRole() == Roles.KZOU) {
	
	        			if (joueur.isOpKzou()) {
	
	        				joueur.setOpKzou(false);
	                        main.eliminate(cible, true);
	
	        			} else {
	
	        				main.eliminate(cible, false);
	
	                    }
	
	        		} else {
	
	                    main.eliminate(cible, false);
	
	                }
	
	    	        for (ItemStack item : cible.getPlayer().getInventory().getContents()) {
	    	
	    	        	if (item != null && item.getType() != Material.NETHER_STAR && item.getTypeId() != 351) {
	    	
	    	        		if (item.getItemMeta().hasEnchant(Enchantment.DEPTH_STRIDER)) {
	    	
	    	        			ItemMeta itemM = item.getItemMeta();
	    	                    itemM.removeEnchant(Enchantment.DEPTH_STRIDER);
	    	                    item.setItemMeta(itemM);
	    	
	    	            	}
	    	
	    	                if (item.getItemMeta().hasEnchant(Enchantment.FIRE_ASPECT)) {
	    	
	    	                   	ItemMeta itemM = item.getItemMeta();
	    	                    itemM.removeEnchant(Enchantment.FIRE_ASPECT);
	    	                    item.setItemMeta(itemM);
	    	
	    	                }
	    	
	    	                if (item.getItemMeta().hasEnchant(Enchantment.ARROW_FIRE)) {
	    	
	    	                   	ItemMeta itemM = item.getItemMeta();
	    	                    itemM.removeEnchant(Enchantment.ARROW_FIRE);
	    	                    item.setItemMeta(itemM);
	    	
	    	                }
	    	                
	    	                if (item.getItemMeta().hasEnchant(Enchantment.THORNS)) {
	    	        	    	
	    	                   	ItemMeta itemM = item.getItemMeta();
	    	                    itemM.removeEnchant(Enchantment.THORNS);
	    	                    item.setItemMeta(itemM);
	    	
	    	                }
	    	
	    	                cible.getPlayer().getWorld().dropItemNaturally(loc, item);
	    	
	    	        	}
	    	
	    	        }
	    	        
	                if (cible.getPlayer().getInventory().getHelmet().getItemMeta().hasEnchant(Enchantment.THORNS)) {
	        	    	
	                   	ItemMeta itemM = cible.getPlayer().getInventory().getHelmet().getItemMeta();
	                    itemM.removeEnchant(Enchantment.THORNS);
	                    cible.getPlayer().getInventory().getHelmet().setItemMeta(itemM);
	
	                }
	                
	                if (cible.getPlayer().getInventory().getChestplate().getItemMeta().hasEnchant(Enchantment.THORNS)) {
	        	    	
	                   	ItemMeta itemM = cible.getPlayer().getInventory().getChestplate().getItemMeta();
	                    itemM.removeEnchant(Enchantment.THORNS);
	                    cible.getPlayer().getInventory().getChestplate().setItemMeta(itemM);
	
	                }
	                
	                if (cible.getPlayer().getInventory().getLeggings().getItemMeta().hasEnchant(Enchantment.THORNS)) {
	        	    	
	                   	ItemMeta itemM = cible.getPlayer().getInventory().getLeggings().getItemMeta();
	                    itemM.removeEnchant(Enchantment.THORNS);
	                    cible.getPlayer().getInventory().getLeggings().setItemMeta(itemM);
	
	                }
	                
	                if (cible.getPlayer().getInventory().getBoots().getItemMeta().hasEnchant(Enchantment.THORNS)) {
	        	    	
	                   	ItemMeta itemM = cible.getPlayer().getInventory().getBoots().getItemMeta();
	                    itemM.removeEnchant(Enchantment.THORNS);
	                    cible.getPlayer().getInventory().getBoots().setItemMeta(itemM);
	
	                }
	    	        
	    	        cible.getPlayer().getWorld().dropItemNaturally(loc, cible.getPlayer().getInventory().getHelmet());
	    	        cible.getPlayer().getWorld().dropItemNaturally(loc, cible.getPlayer().getInventory().getChestplate());
	    	        cible.getPlayer().getWorld().dropItemNaturally(loc, cible.getPlayer().getInventory().getLeggings());
	    	        ItemStack bottes = cible.getPlayer().getInventory().getBoots();
	    	        if(bottes.containsEnchantment(Enchantment.DEPTH_STRIDER)) {
	    	        	bottes.removeEnchantment(Enchantment.DEPTH_STRIDER);
	    	        }
	    	        cible.getPlayer().getWorld().dropItemNaturally(loc, bottes);
	
	                Mort.setMort(cible, joueur, event, main);
	
	            } else if(item == "maudit_uhc_1") {
            		
            		joueur.removeForce(0.03);
            		joueur.setAbso(true);
            		cible.setAbso(true);
            		cible.removeForce(0.03);
            		main.getMaudit().clear();
            		main.setNiv_maledition(0);
            		
            		
            		
            	} else if(item == "respawn") {
            		
            		joueur.setInvulnerable(false);
            		
            	} else if(item == "maudit_uhc_2") {
            		
            		joueur.removeSpeed(0.1);
            		joueur.setAbso(true);
            		cible.setAbso(true);
            		cible.removeSpeed(0.1);
            		main.getMaudit().clear();
            		main.setNiv_maledition(0);
            		
            	} else if(item == "maudit_uhc_3") {
            		
            		joueur.removeSpeed(0.05);
            		joueur.removeForce(0.03);
            		joueur.setAbso(true);
            		cible.setAbso(true);
            		cible.removeSpeed(0.05);
            		cible.removeForce(0.03);
            		main.getMaudit().clear();
            		main.setNiv_maledition(0);
            		
            	} else if(item == "maudit_autre_1"){
            		
            		joueur.addForce(0.02);
            		joueur.setAbso(true);
            		cible.setAbso(true);
            		cible.addForce(0.02);
            		main.getMaudit().clear();
            		main.setNiv_maledition(0);
            		
            	} else if(item == "maudit_autre_2") {
            		
            		joueur.addSpeed(0.07);
            		joueur.setAbso(true);
            		cible.setAbso(true);
            		cible.addSpeed(0.07);
            		main.getMaudit().clear();
            		main.setNiv_maledition(0);
            		
            	} else if(item == "maudit_autre_3") {
            		
            		joueur.addSpeed(0.05);
            		joueur.addForce(0.02);
            		joueur.setAbso(true);
            		cible.setAbso(true);
            		cible.addSpeed(0.05);
            		cible.addForce(0.02);
            		main.getMaudit().clear();
            		main.setNiv_maledition(0);
            		
            	} else if(item == "maudit_rapide_1"){
            		
            		cible.setAbso(true);
            		cible.addForce(0.01);
            		main.getMaudit().clear();
            		main.setNiv_maledition(0);
            		
            	} else if(item == "maudit_rapide_2") {
            		
            		cible.setAbso(true);
            		cible.addSpeed(0.05);
            		main.getMaudit().clear();
            		main.setNiv_maledition(0);
            		
            	} else if(item == "maudit_rapide_3") {
            		
            		cible.setAbso(true);
            		cible.addSpeed(0.05);
            		cible.addForce(0.01);
            		main.getMaudit().clear();
            		main.setNiv_maledition(0);
            		
            	} else if(item == "rubis_force") {
	            	
	            	joueur.removeForce(0.02);
	            	
	            } else if(item == "rubis_resi") {
	            	
	            	joueur.removeResi(0.02);
	            	
	            } else if(item == "rubis_speed") {
	            	
	            	joueur.removeSpeed(0.02);
	            	
	            } else if(item == "check_malus_feu") {
	            	
	            	joueur.setCheckMalusEau(false);
	            	
	            } else if (item == "stun") {
	
	                cible.setInvulnerable(false);
	                
	            }
	            	            
	            //ORBE
	            else if (item == "foudre_malus") {
	
	                joueur.setCanHaveMalusBonusOrbe(true);
	
	            } else if (item == "eau_malus") {
	
	                joueur.setCanHaveMalusBonusOrbe(true);
	
	            } else if (item == "feu_malus") {
	
	                joueur.setCanHaveMalusBonusOrbe(true);
	
	            } else if (item == "glace_malus") {
	
	                joueur.setCanHaveMalusBonusOrbe(true);
	
	            } else if (item == "foudre_bonus") {
	
	                joueur.setCanHaveMalusBonusOrbe(true);
	
	            } else if (item == "eau_bonus") {
	
	                joueur.setCanHaveMalusBonusOrbe(true);
	
	            } else if (item == "feu_bonus") {
	
	                joueur.setCanHaveMalusBonusOrbe(true);
	
	            } else if (item == "glace_bonus") {
	
	                joueur.setCanHaveMalusBonusOrbe(true);
	
	            } 
	            
	            else if (item == "speed_reflex_trial") {
	            	
	            	joueur.removeSpeed(0.05);
	            	
	            } else if(item == "takaoni_trial") {
	            	
	            	joueur.setNofall(false);
	            	cible.addForce(0.02);
	            	
	            } else if(item == "soleil_trial") {
	            	
	            	joueur.removeForce(0.02);
	            	
	            } else if(item == "soleil") {
	            	
	            	joueur.setInvulnerable(false);
	            	cible.setInvulnerable(false);
	            	cible.getPlayer().sendMessage("Le jeu est fini");
	            	joueur.getPlayer().sendMessage("Le jeu est fini");
	            	main.setJeuTrial(null);
	            	main.getJoueurJeuTrial().clear();
	            	
	            } else if(item == "no_fall") {
	            		
	            	joueur.setNofall(false);
	            		
	            } else if (joueur.getRole() == Roles.MALIVOL || joueur.getVol().contains(Pouvoirs.MALIVOL_CHEAT) && joueur.getMalivolCheat() != 0) {

	
	                if (item == "speedhack") {
	
	                    if (player.getInventory().getBoots().getType() != null) {
	
	                        ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
	                        epeeM.removeEnchant(Enchantment.DEPTH_STRIDER);
	                        ItemStack epee = player.getInventory().getBoots();
	                        epee.setItemMeta(epeeM);
	                        player.getInventory().setBoots(epee);
	                        joueur.removeSpeed(0.15);
	
	                    }
	
	                } else if (item == "nofall") {
	
	                	joueur.removeResi(0.03);
	                	joueur.setNofall(false);
	
	                } else if (item == "fullcrit") {
	
	                	joueur.removeForce(0.07);
	
	                } else if (item == "antikb") {
	
	                	joueur.setAntiKB(false);
	
	                }
	
	                joueur.setMalivolCheat(0);
	
	            } else if(joueur.getRole() == Roles.FARMEURIMMO) {
	            	
	            	if(item == "abso") {
	            		
	            		cible.setAbso(true);
	            		
	            	} else if(item == "enchant_epee") {
	                	
	            		if (joueur.getPlayer().getInventory().contains(Material.DIAMOND_SWORD) || joueur.getPlayer().getInventory().contains(Material.IRON_SWORD)) {

	                        for (ItemStack itemStack : cible.getPlayer().getInventory().getContents()) {

	                            if (itemStack != null) {
	                                if (itemStack.getType() == Material.DIAMOND_SWORD || itemStack.getType() == Material.IRON_SWORD) {

	                                    int niv = itemStack.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
	                                    niv += 2;
	                                    
	                                    itemStack.removeEnchantment(Enchantment.DAMAGE_ALL);
	                                    itemStack.addEnchantment(Enchantment.DAMAGE_ALL, niv);

	                                }

	                            }

	                        }

	                    }
	            		
	            	} else if(item == "add_force_farmeurimmo") {
	            		
	            		cible.addForce(0.05);
	            		
	            	} else if(item == "add_speed_farmeurimmo") {
	            		
	            		cible.addSpeed(0.05);
	            		
	            	} else if(item == "add_resi_farmeurimmo") {
	            		
	            		cible.addResi(0.05);
	            		
	            	} else if(item == "enchant_armure") {
	            		
	            		
	            		
	            	} else if(item == "desac_orbe") {
	            		
	            		if(cible.getOrbe() == Orbe.EAU) {
	            			
	            			Eau.Passif(cible, main, true);
	            			
	            		}
	            		else if(cible.getOrbe() == Orbe.FEU) {
	            			
	            			Feu.Passif(cible, main, true);
	            			
	            		}
	            		else if(cible.getOrbe() == Orbe.FOUDRE) {
	            			
	            			Foudre.Passif(cible, main, true);
	            			
	            		}
	            		else if(cible.getOrbe() == Orbe.GLACE) {
	            			
	            			Glace.Passif(cible, main, true);
	            			
	            		}
	            		
	            	} else if(item == "effet_desac_orbe") {
	            		
	            		cible.addForce(0.05);
	            		
	            	} else if(item == "malus_coeur_farmeurimmo") {
	            		
	            		cible.getPlayer().setMaxHealth(cible.getPlayer().getMaxHealth()+4);
	            		
	            	} else if(item == "malus_feu_farmeurimmo") {
	            		
	            		cible.setFire(false);
	            		
	            	} else if(item == "malus_bow_farmeurimmo") {
	            		
	            		for(ItemStack item_ : cible.getPlayer().getInventory().getContents()) {
	            			if(item_.getType() == Material.BARRIER) {
	            				item_.setType(Material.BOW);
	            			}
	            		}
	            		
	            	} else if(item == "cd_hack_farmeurimmo") {
	            		
	            		joueur.getCD().remove(Pouvoirs.FARMEURIMMO_HACK);
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.RAPTOR || joueur.getVol().contains(Pouvoirs.RAPTOR_RAGE)) {
	            	
	            	if(item == "antikb_raptor") {
	            		
	            		joueur.setAntiKB(false);
	            		joueur.setPouvoirRaptorActif(false);
	            		joueur.getPlayer().sendMessage("Votre cheat est désormais fini");
	            		
	            	} else if(item == "force_raptor") {
	            		
	            		joueur.removeForce(0.05);
	            		joueur.setPouvoirRaptorActif(false);
	            		joueur.getPlayer().sendMessage("Votre cheat est désormais fini");
	            		
	            	} else if(item == "5_force_raptor") {
	            		
	            		joueur.removeForce(0.02);
	            		joueur.setPouvoirRaptorActif(false);
	            		joueur.getPlayer().sendMessage("Votre cheat est désormais fini");
	            		
	            	} else if(item == "resi_raptor") {
	            		
	            		joueur.removeResi(0.02);
	            		joueur.setPouvoirRaptorActif(false);
	            		joueur.getPlayer().sendMessage("Votre cheat est désormais fini");
	            		
	            	} else if(item == "speed_raptor") {
	            		
	            		joueur.removeSpeed(0.10);
	            		joueur.setPouvoirRaptorActif(false);
	            		joueur.getPlayer().sendMessage("Votre cheat est désormais fini");
	            		
	            	} else if(item == "rage_raptor") {
	            		
	            		joueur.removeForce(0.07);
	            		joueur.setPouvoirRaptorActif(false);
	            		joueur.getPlayer().sendMessage("Votre pouvoir est désormais fini");
	            		joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,400,0));
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.TOINOU || joueur.getVol().contains(Pouvoirs.TOINOU_VACANCES)) {
	            	
	            	if(item == "speed_cheat_toinou") {
	            		
	            		joueur.removeSpeed(0.1);
	            		
	            	} else if(item == "force_cheat_toinou") {
	            		
	            		joueur.setCheatToinou(false);
	            		
	            	} else if(item == "vacance_toinou") {
	            		
	            		joueur.show(main);
	            		joueur.setInvulnerable(false);
	            		joueur.setInvisible(false);
	            		joueur.removeSpeed(0.07);
	            		joueur.removeForce(0.01);
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.SLUP) {
	            	
	            	if(item == "fakemort_slup") {
	            		
	            		for(Joueur j : main.getListJoueurs()) {
	            			
	            			j.getPlayer().showPlayer(joueur.getPlayer());
	            			joueur.setInvulnerable(false);
	            			joueur.setInvisible(false);
	            			
	            		}
	            		
	            	} else if(item == "slimezone_slup") {
	            		
	            		main.setLocZoneSlup(null);
	            		
	            		for(Joueur j : main.getJoueurInGame()) {
	            			
	            			if(j.isMalusZoneSlup()) {
	            				
	            				j.setMalusZoneSlup(false);
	            				j.addSpeed(0.05);
	            				
	            			}
	            			
	            		}
	            		
	            		joueur.getPlayer().sendMessage("Votre pouvoir est désormais fini");
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.TRIAL) {
	            	
	            	if(item == "benihimeAratame_trial") {
	            		
	            		main.setZoneBenihimeActif(false);
	            		
	            		for(Joueur j : main.getJoueurInGame()) {
	            			
	            			if(j.isInZoneBenihime()) {
	            				
	            				joueur.removeForce(0.01);
	            				joueur.removeSpeed(0.01);
	            				j.addForce(0.02);
	            				j.setInZoneBenihime(false);
	            				
	            			}
	            			
	            		}
	            		
	            		joueur.getPlayer().sendMessage("Votre pouvoir 'Benihime Aratame' est fini");
	            		
	            	} else if(item == "corruption_trial") {
	            		
	            		cible.addForce(0.02);
	            		cible.addSpeed(0.03);
	            		cible.setCorrompu(false);
	            		joueur.getCD().remove(Pouvoirs.TRIAL_CORRUPTION);
	            		joueur.getPlayer().sendMessage("Le joueur " + cible.getPlayer().getName() + " n'est plus corrompu");
	            		
	            	} else if(item == "sakashimayokoshima_trial") {
	            		
	            		joueur.setInvisible(false);
	            		joueur.show(main);
	            		for(Joueur j : players) {
	            			
	            			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "skin set " + j.getPlayer().getName() + " " + j.getPlayer().getName());
	            			
	            		}
	            		
	            		joueur.getPlayer().sendMessage("Votre pouvoir 'Sakashima Yokoshima' est fini");
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.LOUP || joueur.getVol().contains(Pouvoirs.LOUP_SUPERBATEAU)) {
	            	
	            	if(item == "vol_loup") {
	            		
	            		joueur.getPlayer().sendMessage("Votre bateau viens de se casser");
	            		joueur.getPlayer().setFlying(false);
	            		joueur.getPlayer().setAllowFlight(false);
	            		joueur.setInvulnerable(false);
	            		joueur.show(main);
	            		joueur.setInvisible(false);
	            		joueur.setSuperBateauLoup(false);
	            		Loup.getBoat().remove();
	            		Loup.setBoat(null);
	            		
	            	} else if(item == "vol_loup_pb") {
	            		
	            		joueur.getPlayer().sendMessage("Flying is not enable on this server");
	            		joueur.getPlayer().setFlying(false);
	            		joueur.getPlayer().setAllowFlight(false);
	            		joueur.setInvulnerable(false);
	            		joueur.show(main);
	            		joueur.setInvisible(false);
	            		joueur.setSuperBateauLoup(false);
	            		Loup.getBoat().remove();
	            		Loup.setBoat(null);
	            		
	            	} else if(item == "vol_loup_cd") {
	            		
	            		joueur.getPlayer().sendMessage("Vous venez de récupérer votre super bateau");
	            		joueur.getCD().remove(Pouvoirs.LOUP_SUPERBATEAU);
	            		
	            	} else if(item == "vol_loup_nf") {
	            		
	            		joueur.setNofall(false);
	            		main.getPassagerSuperBateau().setNofall(false);
	            		main.setPassagerSuperBateau(null);
	            		joueur.getPlayer().setAllowFlight(false);
	            		
	            	} else if(item == "serveur_loup") {
	            		
	            		for(Joueur j : players) {
	            			
	            			j.addForce(0.03);
	            			
	            		}
	            		
	            		joueur.getPlayer().sendMessage("Votre pouvoir est désormais fini");
	            		
	            	}
	            	
	            } else if (joueur.getRole() == Roles.JOKO || joueur.getVol().contains(Pouvoirs.JOKO_CUBE)) {
	
	                if (item == "cube") {
	
	                	joueur.removeSpeed(0.08);
	                	joueur.setJokoItemActif(false);
	                    player.sendMessage("Ton pouvoir est fini");
	                    if (!main.getJokoStun().isEmpty()) {
	
	                    	joueur.setJokoSteal(true);
	                        player.sendMessage("Tu peux voler 1% de force ou de résistance à " + main.getJokoStun().get(0).getPlayer().getName() + " (pour choisir fait la commande /rcsteal <force|resi|resistance>)");
	
	                    }
	
	                } else if (item == "givecube") {
	
	                    joueur.getCD().remove(Pouvoirs.JOKO_GIVECUBE);
	
	                }
	
	            } else if(joueur.getRole() == Roles.GAMEBLACK) {
	            	
	            	if(item == "buffgb_coeur") {
	            		
	            		joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()+2);
	        			cible.getPlayer().setMaxHealth(cible.getPlayer().getMaxHealth()-2);
	            		
	            	}
	            	else if(item == "buffgb_speed") {
	            		
	            		if(joueur.getClasseGB() == Classe.SUPPORT) {
	            			
	            			joueur.addSpeed(0.05);
	            			
	            		}
	            		cible.removeSpeed(0.05);
	            		
	            	}
	            	else if(item == "buffgb_force") {
	            		
	            		if(joueur.getClasseGB() == Classe.SUPPORT) {
	            			
	            			joueur.addForce(0.02);
	            			
	            		}
	            		cible.removeForce(0.02);
	            		
	            	}
	            	else if(item == "buffgb_resi") {
	            		
	            		if(joueur.getClasseGB() == Classe.SUPPORT) {
	            			
	            			joueur.addResi(0.02);
	            			
	            		}
	            		cible.removeResi(0.02);
	            		
	            	}
	            	
	            	if(item == "console") {
	            		
	            		joueur.setConsoleGBActif(false);
	            		
	            		Random r = new Random();
	                    int nb = r.nextInt(100);
	                    
	                    if(nb <= 50) {
	                    	
	                    	List<Roles> roles = new ArrayList<>();
	                    	
	                    	for(Entity entity : joueur.getPlayer().getNearbyEntities(20, 20, 20)) {
	                    		
	                    		if(entity instanceof Player) {
	                    			
	                    			Player p = (Player) entity;
	                    			Joueur j = main.getJoueur(p);
	                    			roles.add(j.getRole());
	                    			
	                    		}
	                    		
	                    	}
	                    	
	                    	if(!roles.isEmpty()) {
	                    		
	                    		if(roles.size() == 1) {
	                    			
	                    			joueur.getPlayer().sendMessage("[CONSOLE] Le rôle " + roles.get(0).getTxt() + " est proche de vous");
	                    			
	                    		}
	                    		else {
	                    			
	                    			nb = r.nextInt(roles.size());
	                    			
	                    			Roles role_choisi = roles.get(nb);
	                    			
	                    			joueur.getPlayer().sendMessage("[CONSOLE] Le rôle " + role_choisi.getTxt() + " est proche de vous");
	                    			
	                    		}
	                    		
	                    	}
	                    	
	                    }
	                    else {
	                        	
	                    	joueur.getPlayer().sendMessage("[CONSOLE] Le rôle " + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " est proche de vous");
	                        	
	                    }
	            		
	            	} else if(item == "fuite") {
	            		
	            		joueur.getPlayer().sendMessage("Votre pouvoir est désormais fini");
	            		
	            		joueur.removeSpeed(0.1);
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.KZOU || joueur.getVol().contains(Pouvoirs.KZOU_BAN)) {
	            	
	            	if(item == "ban") {
	            		
	            		if(cible.getRole() == Roles.NONOBOY) {
	            			
	            			//cible.removeSpeed(0.1);
	            			
	            		}
	            		
	            		cible.addForce(0.05);
	            		
	            	}
	            	else if (item == "disperse") {
	            		
	            		cible.setInvulnerable(false);
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.OBSCUR) {
	            	
	            	main.setAdaptionObscurActif(false);
	            	joueur.removeResi(0.02);
	            	joueur.removeSpeed(0.05);
	            	if(joueur.isTueurToinouKill()) {
	            		
	            		joueur.addForce(0.01);
	            		
	            	}
	            	
	            	main.setAdaptionAvantObscur(main.getAdaptionObscur());
	            	main.getAdaptionObscur().clear();
	            	
	            } else if(joueur.getRole() == Roles.TEAM) {
	            	
	            	if(item == "force_team") {
	            		
	            		joueur.addForce(0.02);
	            	
	            	} else if(item == "justice_team") {
	            	
		            	main.setZoneJusticeActif(false);
		            	joueur.removeSpeed(0.05);
	            		
	            		for(Joueur j : main.getJoueurInGame()) {
	            			
	            			if(j.isInZoneJustice()) {
	            				
	            				j.setInZoneJustice(false);

	        					if(j.getCamp().equalsIgnoreCase("staff") || j.getRole() == Roles.TRIAL || j.getRole() == Roles.GAMEBLACK) {
	        						
	        						j.removeSpeed(0.05);
	        						
	        					}
	        					else {
	        						
	        						j.addResi(0.01);
	        						j.addForce(0.01);
	        						
	        					}
	            				
	            			}
	            			
	            		}
		            	
	            	}
	            	
	            } else if(joueur.getRole() == Roles.CAPTAIN) {
	            	
	            	if(item.startsWith("protection")) {
	            		
	            		ItemStack armure;
	            		
	            		if(item == "protection_casque_captain") {
	            			
	            			armure = cible.getPlayer().getInventory().getHelmet();
	            			
	            		} else if(item == "protection_plastron_captain") {
	            			
	            			armure = cible.getPlayer().getInventory().getChestplate();
	            			
	            		} else if(item == "protection_jambieres_captain") {
	            			
	            			armure = cible.getPlayer().getInventory().getLeggings();
	            			
	            		} else {
	            			
	            			armure = cible.getPlayer().getInventory().getBoots();
	            			
	            		}
	            		
	            		armure.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
	            		
	            		if(nombre != 0) {
	            			
	            			armure.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, nombre);
	            			
	            		}
	            		
	            	}
	            	else if(item.startsWith("thorns")) {
	            		
	            		ItemStack armure;
	            		
	            		if(item == "thorns_casque_captain") {
	            			
	            			armure = cible.getPlayer().getInventory().getHelmet();
	            			
	            		} else if(item == "thorns_plastron_captain") {
	            			
	            			armure = cible.getPlayer().getInventory().getChestplate();
	            			
	            		} else if(item == "thorns_jambieres_captain") {
	            			
	            			armure = cible.getPlayer().getInventory().getLeggings();
	            			
	            		} else {
	            			
	            			armure = cible.getPlayer().getInventory().getBoots();
	            			
	            		}
	            		
	            		armure.removeEnchantment(Enchantment.THORNS);
	            		
	            		if(nombre != 0) {
	            			
	            			armure.addEnchantment(Enchantment.THORNS, nombre);
	            			
	            		}
	            		
	            	}
	            	else if(item.startsWith("unbreaking")) {
	            		
	            		ItemStack armure;
	            		
	            		if(item == "unbreaking_casque_captain") {
	            			
	            			armure = cible.getPlayer().getInventory().getHelmet();
	            			
	            		} else if(item == "unbreaking_plastron_captain") {
	            			
	            			armure = cible.getPlayer().getInventory().getChestplate();
	            			
	            		} else if(item == "unbreaking_jambieres_captain") {
	            			
	            			armure = cible.getPlayer().getInventory().getLeggings();
	            			
	            		} else {
	            			
	            			armure = cible.getPlayer().getInventory().getBoots();
	            			
	            		}
	            		
	            		armure.removeEnchantment(Enchantment.DURABILITY);
	            		
	            		if(nombre != 0) {
	            			
	            			armure.addEnchantment(Enchantment.DURABILITY, nombre);
	            			
	            		}
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.HEKOW) {
	            	
	            	if(item == "jeu_hekow") {
	            	
		            	joueur.setHekowJeuActif(false);
		            	Random r = new Random();
		                int nb = r.nextInt(100);
		                joueur.getPlayer().sendMessage("Votre pouvoir est désormais fini");
		                if(nb <= joueur.getHekowPourcent()) {
		                	
		                	joueur.getPlayer().sendMessage("Votre compétence jackpot vient de s'activer");
		                	Hekow.activeJackpot(joueur, main);
		                	
		                }
		                
		                joueur.setHekowPourcent(0);
		                
	            	} else if(item == "jackpot_hekow") {
	            		
	            		joueur.getPlayer().sendMessage("Votre compétence jackpot est désormais fini");
	            		joueur.removeSpeed(0.1);
	            		joueur.removeForce(0.02);
	            		if(!joueur.getCamp().equalsIgnoreCase("farmeurimmo")) {
	            			
	            			joueur.addResi(0.02);
	            		
	            		}
	            		Random r = new Random();
		                int nb = r.nextInt(100);
		                if(nb <= 50) {
		                	
		                	joueur.getPlayer().sendMessage("Vous pouvez réutiliser votre pouvoir");
		                	joueur.getCD().remove(Pouvoirs.HEKOW_JEU);
		                	
		                }
	            		
	            	}
	            	
	            }
	            else if(joueur.getRole() == Roles.JEANNOT) {
	            	
	            	if(item == "abso_jeannot") {
	            		
	            		cible.setAbso(true);
	            		
	            	}
	            	
	            }
	            else if(joueur.getRole() == Roles.THEOOCHOUX) {
	            	
	            	if(item == "theo_antikb") {
	            		
	            		joueur.setAntiKB(false);
	            		
	            	}
	            	else if(item == "theoochoux_minirollbackcd") {
	            		
	            		joueur.getCD().remove(Pouvoirs.THEOOCHOUX_MINIROLLBACK);
	            		joueur.getPlayer().sendMessage("Le cooldown de votre mini rollback est désormais fini");
	            		
	            	}
	            	
	            }
	            
        	}

        }

        timer--;

    }

    public ItemStack getItem(Material material, String customName, String desc) {
        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        if (customName != null) itM.setDisplayName(customName);
        itM.setLore(Arrays.asList(desc.split(",")));
        itM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        it.setItemMeta(itM);
        return it;
    }

}