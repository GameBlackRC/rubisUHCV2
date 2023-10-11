package fr.gameblack.rcuhcv2.task;

import fr.gameblack.rcuhcv2.Classe;
import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.listener.DamageListener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ItemCD extends BukkitRunnable {

	private Main main;
    private Player player;
    private String item;
    private int timer;
    private Joueur cible;
	private EntityDamageByEntityEvent event;
	private List<Joueur> players = new ArrayList<>();
    private Joueur joueur;
    @SuppressWarnings("unused")
	private ItemStack item_;
    private Location loc;

    public ItemCD(Main main, Joueur joueur, String item, int timer, Joueur cible, EntityDamageByEntityEvent event, List<Joueur> players, ItemStack item_, Location loc) {
        this.main = main;
        this.player = joueur.getPlayer();
        this.joueur = joueur;
        this.item = item;
        this.timer = timer;
        this.cible = cible;
        this.event = event;
        this.players = players;
        this.item_ = item_;
        this.loc = loc;
    }

    @Override
    public void run() {
    	
    	if(joueur.getRole() == Roles.GAMEBLACK && joueur.getClasseGB() != Classe.SUPPORT && (item == "buffgb_coeur" || item == "buffgb_speed" || item == "buffgb_resi" || item == "buffgb_force")) {
    		
    		timer = 0;
    		
    	}
    	
    	if(item == "mortNeko") {
    		
    		if(main.getTueurNeko() == null) {
    			
    			cancel();
    			
    		}
    		
    	}
    	
    	if(item == "frappe_neko") {
    		
    		cible.setFrappeNeko(false);
    		
    	}
    	
    	if(item == "soleil_trial" && timer == 285) {
        	
        	cible.addSpeed(0.05);
        	
        }
    	
    	if(joueur.getRole() == Roles.GAMEBLACK && item == "fuite" && timer == 58) {
    		
    		joueur.setInvulnerable(false);
    		
    	}
    	
    	if(joueur.getRole() == Roles.KZOU && item == "ban") {
    		
    		cible.removeForce(0.05);
    		
    	}

        if (timer == 0) {
        	
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
	    	
	    	        	if (item != null && item.getType() != Material.NETHER_STAR) {
	    	
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
	    	
	    	                cible.getPlayer().getWorld().dropItemNaturally(loc, item);
	    	
	    	        	}
	    	
	    	        }
	
	                DamageListener.Mort(cible, joueur, event, main);
	
	            } else if(item == "maudit_uhc_1") {
            		
            		joueur.removeForce(0.03);
            		joueur.setAbso(true);
            		cible.setAbso(true);
            		cible.removeForce(0.03);
            		main.getMaudit().clear();
            		main.setNiv_maledition(0);
            		
            		
            		
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
	                
	            } else if (item == "foudre_malus") {
	
	                joueur.setMalusOrbe(false);
	                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");
	
	            } else if (item == "eau_malus") {
	
	            	joueur.addSpeed(0.05);
	                joueur.setMalusOrbe(false);
	                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");
	
	            } else if (item == "feu_malus") {
	
	            	joueur.addResi(0.05);
	                joueur.setMalusOrbe(false);
	                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");
	
	            } else if (item == "glace_malus") {
	
	            	joueur.addForce(0.05);
	                joueur.setMalusOrbe(false);
	                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");
	
	            } 
	            else if (item == "speed_reflex_trial") {
	            	
	            	joueur.removeSpeed(0.05);
	            	
	            } else if(item == "takaoni_trial") {
	            	
	            	joueur.setNofall(false);
	            	cible.addForce(0.02);
	            	
	            } else if(item == "soleil_trial") {
	            	
	            	joueur.removeForce(0.02);
	            	
	            } else if (joueur.getRole() == Roles.MALIVOL || joueur.getVol().contains(Pouvoirs.MALIVOL_CHEAT) && joueur.getMalivolCheat() != 0) {
	
	                if (item == "speedhack") {
	
	                    if (player.getInventory().getBoots().getType() != null) {
	
	                        ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
	                        epeeM.removeEnchant(Enchantment.DEPTH_STRIDER);
	                        ItemStack epee = player.getInventory().getBoots();
	                        epee.setItemMeta(epeeM);
	                        player.getInventory().setBoots(epee);
	                        joueur.removeSpeed(0.1);
	
	                    }
	
	                } else if (item == "nofall") {
	
	                	joueur.removeResi(0.03);
	                	joueur.setNofall(false);
	
	                } else if (item == "fullcrit") {
	
	                	joueur.removeForce(0.10);
	
	                } else if (item == "antikb") {
	
	                	joueur.setAntiKB(false);
	
	                }
	
	                joueur.setMalivolCheat(0);
	
	            } else if(joueur.getRole() == Roles.FARMEURIMMO) {
	            	
	            	if(item == "abso") {
	            		
	            		cible.setAbso(true);
	            		
	            	} else if(item == "enchant_epee") {
	                	
	            		if (joueur.getPlayer().getInventory().contains(Material.DIAMOND_SWORD) || joueur.getPlayer().getInventory().contains(Material.IRON_SWORD)) {

	                        for (ItemStack itemStack : joueur.getPlayer().getInventory().getContents()) {

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
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.RAPTOR) {
	            	
	            	if(item == "antikb_raptor") {
	            		
	            		joueur.setAntiKB(false);
	            		
	            	} else if(item == "force_raptor") {
	            		
	            		joueur.removeForce(0.05);
	            		
	            	} else if(item == "5_force_raptor") {
	            		
	            		joueur.removeForce(0.03);
	            		
	            	} else if(item == "resi_raptor") {
	            		
	            		joueur.removeResi(0.03);
	            		
	            	} else if(item == "speed_raptor") {
	            		
	            		joueur.removeSpeed(0.10);
	            		
	            	} else if(item == "rage_raptor") {
	            		
	            		joueur.removeForce(0.07);
	            		joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,400,0));
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.TOINOU) {
	            	
	            	if(item == "speed_cheat_toinou") {
	            		
	            		joueur.removeSpeed(0.1);
	            		
	            	} else if(item == "force_cheat_toinou") {
	            		
	            		joueur.setCheatToinou(false);
	            		
	            	} else if(item == "vacance_toinou") {
	            		
	            		joueur.show(main);
	            		joueur.setInvulnerable(false);
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.SLUP) {
	            	
	            	if(item == "fakemort_slup") {
	            		
	            		for(Joueur j : main.getListJoueurs()) {
	            			
	            			j.getPlayer().showPlayer(joueur.getPlayer());
	            			joueur.setInvulnerable(false);
	            			
	            		}
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.LOUP) {
	            	
	            	if(item == "vol_loup") {
	            		
	            		joueur.getPlayer().sendMessage("Votre bateau viens de se casser");
	            		joueur.getPlayer().setFlying(false);
	            		joueur.setInvulnerable(false);
	            		
	            	} else if(item == "vol_loup_pb") {
	            		
	            		joueur.getPlayer().sendMessage("Flying is not enable on this server");
	            		joueur.getPlayer().setFlying(false);
	            		joueur.setInvulnerable(false);
	            		
	            	} else if(item == "vol_loup_cd") {
	            		
	            		joueur.getPlayer().sendMessage("Vous venez de récupérer votre super bateau");
	            		main.getCD().remove(Pouvoirs.LOUP_SUPERBATEAU);
	            		
	            	} else if(item == "vol_loup_nf") {
	            		
	            		joueur.setNofall(false);
	            		joueur.getPlayer().setAllowFlight(false);
	            		
	            	} else if(item == "serveur_loup") {
	            		
	            		for(Joueur j : players) {
	            			
	            			j.addForce(0.5);
	            			
	            		}
	            		
	            	}
	            	
	            } else if (joueur.getRole() == Roles.JOKO) {
	
	                if (item == "cube") {
	
	                	joueur.removeSpeed(0.04);
	                	joueur.setJokoItemActif(false);
	                    player.sendMessage("Ton pouvoir est fini");
	                    if (!main.getJokoStun().isEmpty()) {
	
	                        player.sendMessage("Tu peux voler 1% de force ou de résistance à " + main.getJokoStun().get(0).getPlayer().getName() + " (pour choisir fait la commande /rcsteal <force|resi|resistance>)");
	
	                    }
	
	                } else if (item == "givecube") {
	
	                    main.getCD().remove(Pouvoirs.JOKO_GIVECUBE);
	
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
	            		
	            	} else if(item == "fuite") {
	            		
	            		joueur.removeSpeed(0.1);
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.KZOU) {
	            	
	            	if(item == "ban") {
	            		
	            		if(cible.getRole() == Roles.NONOBOY) {
	            			
	            			cible.removeSpeed(0.1);
	            			
	            		}
	            		
	            		cible.addForce(0.05);
	            		
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