package fr.gameblack.rcuhcv2.task.v1;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.listener.global.Mort;

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
	@SuppressWarnings("unused")
	private List<Joueur> players = new ArrayList<>();
    private Joueur joueur;
    @SuppressWarnings("unused")
	private int nb;
    private Location loc;

    public ItemCD(Main main, Joueur joueur, String item, int timer, Joueur cible, EntityDamageByEntityEvent event, List<Joueur> players, int nb, Location loc) {
        this.main = main;
        this.player = joueur.getPlayer();
        this.joueur = joueur;
        this.item = item;
        this.timer = timer;
        this.cible = cible;
        this.event = event;
        this.players = players;
        this.nb = nb;
        this.loc = loc;
    }

    @Override
    public void run() {
    	
    	if(joueur.getRole() == Roles.Kzou && item == "ban" && timer == 60) {
    			
    		cible.removeForce(0.05);
    		
    	}
    	
    	if (timer == 8 || timer == 6 || timer == 4 || timer == 2) {

            if ((joueur.getRole() == Roles.Tronconeuse || (joueur.getRole() == Roles.Toinou && joueur.getVol().contains(Pouvoirs.TRONCONNEUSE_SAIGNEMENT))) && item == "saigne") {

                cible.getPlayer().damage(1);

            }

        }

        if (timer == 0) {
        	
	            cancel();
	            
	            if (item == "mort") {
	
	        		if (joueur.getRole() == Roles.Kzou) {
	
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
	    	        
	    	        cible.getPlayer().getWorld().dropItemNaturally(loc, cible.getPlayer().getInventory().getHelmet());
	    	        cible.getPlayer().getWorld().dropItemNaturally(loc, cible.getPlayer().getInventory().getChestplate());
	    	        cible.getPlayer().getWorld().dropItemNaturally(loc, cible.getPlayer().getInventory().getLeggings());
	    	        ItemStack bottes = cible.getPlayer().getInventory().getBoots();
	    	        if(bottes.containsEnchantment(Enchantment.DEPTH_STRIDER)) {
	    	        	bottes.removeEnchantment(Enchantment.DEPTH_STRIDER);
	    	        }
	    	        cible.getPlayer().getWorld().dropItemNaturally(loc, bottes);
	
	                Mort.setMort(cible, joueur, main);
	
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
            		
            	} else if(item == "check_malus_feu") {
	            	
	            	joueur.setCheckMalusEau(false);
	            	
	            } else if (item == "stun") {
	
	                cible.setInvulnerable(false);
	                
	            } else if (item == "foudre_malus") {
	
	            	joueur.addSpeed(0.05);
	                joueur.setMalusOrbe(false);
	                
	                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");
	
	            } else if (item == "eau_malus") {
	
	            	joueur.addForce(0.05);
	                joueur.setMalusOrbe(false);
	                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");
	
	            } else if (item == "feu_malus") {
	
	            	joueur.addResi(0.05);
	                joueur.setMalusOrbe(false);
	                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");
	
	            } else if (item == "glace_malus") {
	
	            	joueur.addForce(0.02);
	                joueur.setMalusOrbe(false);
	                player.sendMessage("Le malus est terminé. Vous pouvez réactiver votre orbe avec la commande /rcorbe");
	
	            } else if (joueur.getRole() == Roles.Malivol || joueur.getVol().contains(Pouvoirs.MALIVOL_CHEAT) && joueur.getMalivolCheat() != 0) {

	
	                if (item == "speedhack") {
	
	                    if (player.getInventory().getBoots().getType() != null) {
	
	                        ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
	                        epeeM.removeEnchant(Enchantment.DEPTH_STRIDER);
	                        ItemStack epee = player.getInventory().getBoots();
	                        epee.setItemMeta(epeeM);
	                        player.getInventory().setBoots(epee);
	                        player.removePotionEffect(PotionEffectType.SPEED);
	                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
	
	                    }
	
	                } else if (item == "nofall") {
	
	                	joueur.removeResi(0.05);
	                	joueur.setNofall(false);
	
	                } else if (item == "fullcrit") {
	
	                	joueur.removeForce(0.2);
	
	                } else if (item == "antikb") {
	
	                	joueur.setAntiKB(false);
	
	                }
	
	                joueur.setMalivolCheat(0);
	
	            } else if (joueur.getRole() == Roles.Joko) {
	
	                if (item == "cube") {
	
	                	joueur.removeSpeed(0.08);
	                	joueur.setJokoItemActif(false);
	                    player.sendMessage("Ton pouvoir est fini");
	                    if (!main.getJokoStun().isEmpty()) {
	
	                        player.sendMessage("Tu peux voler 3% de force ou de résistance à " + main.getJokoStun().get(0).getPlayer().getName() + " (pour choisir fait la commande /rcsteal <force|resi|resistance>)");
	
	                    }
	
	                } else if (item == "givecube") {
	
	                    joueur.getCD().remove(Pouvoirs.JOKO_GIVECUBE);
	
	                }
	
	            } else if(joueur.getRole() == Roles.Kzou) {
	            	
	            	if(item == "ban") {
	            		
	            		cible.addForce(0.05);
	            		
	            	}
	            	else if (item == "disperse") {
	            		
	            		cible.setInvulnerable(false);
	            		
	            	}
	            	
	            } else if (joueur.getRole() == Roles.Maka) {

	                if (item == "don") {

	                    if (cible == main.getTueurNeko()) {

	                        joueur.getPlayer().sendMessage("Le joueur " + cible.getPlayer().getName() + " a bien reçu votre cadeau");
	                        joueur.removeSpeed(0.02);
	                        cible.addSpeed(0.02);
	                        cible.getPlayer().sendMessage("Vous avez reçu 2% de speed de la part de maka");
	                        joueur.setFindTueurNeko(true);
	                        joueur.getCD().remove(Pouvoirs.MAKA_DON);

	                    } else {

	                        player.sendMessage("Le joueur " + cible.getPlayer().getName() + " vous a renvoyé le cadeau");

	                    }

	                }

	            } else if(joueur.getRole() == Roles.Loup) {
	            	
	            	if(item == "loup") {
	            		
	            		joueur.setSpeedInt(nb);
	            		joueur.removeForce(main.getForceIBaseV1());
	            		joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 180, 0, false, false));
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.Raptor) {
	            	
	            	joueur.removeForce(main.getForceIBaseV1());
	            	
	            } else if(joueur.getRole() == Roles.GameBlack) {
	            	
	            	if(item == "camouflage") {
	            		
	            		joueur.getCD().remove(Pouvoirs.GB_CAMOUFLAGE);
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.Ange) {
	            	
	            	if(item == "shopforce") {
	            		
	            		joueur.removeForce(main.getForceIBaseV1());
	            		
	            	}
	            	
	            } else if(joueur.getRole() == Roles.Enfer) {
	            	
	            	if(item == "fire") {
	            		
	                    for (Joueur j : players) {

	                    	if (j.getCamp() == Camps.DEMON) {

	                            int slot = -1;
	                            int i = 0;

	                            for (ItemStack itemStack : j.getPlayer().getInventory().getContents()) {

	                            	if (itemStack != null) {
	                            		if (itemStack.getType() == Material.DIAMOND_SWORD) {

	                            			slot = i;

	                                    }

	                                }
	                                i += 1;

	                            }
	                            if (slot != -1) {

	                            	ItemMeta epeeM = j.getPlayer().getInventory().getItem(slot).getItemMeta();
	                                epeeM.removeEnchant(Enchantment.FIRE_ASPECT);
	                                ItemStack epee = j.getPlayer().getInventory().getItem(slot);
	                                epee.setItemMeta(epeeM);
	                                j.getPlayer().getInventory().setItem(i, epee);
	                                j.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);


	                            }

	                    	}

	                    }
	            		
	            	}
	            	
	            }
	            if ((joueur.getRole() == Roles.Tronconeuse || (joueur.getRole() == Roles.Toinou && joueur.getVol().contains(Pouvoirs.TRONCONNEUSE_SAIGNEMENT))) && item == "saigne") {

	                cible.getPlayer().damage(1);
	                cible.setSaigne(false);

	            }
	            if(joueur.getRole() == Roles.Tronconeuse) {
	            	
	            	if(item == "speed_moins") {
	            		
	            		joueur.removeSpeed(0.1);
	            		
	            	} else if(item == "speed_plus") {
	            		
	            		joueur.addSpeed(0.08);
	            		
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