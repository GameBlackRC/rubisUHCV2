package fr.gameblack.rcuhcv2.roles.v1.demons;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.Pieces;
import fr.gameblack.rcuhcv2.orbes.Orbe;

public class ObscurV1 {

    public static void Items(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);

        int slot_arc = -1;
        int slot_epee = -1;
        int i = 0;

        for (ItemStack itemStack : player.getInventory().getContents()) {

            if (itemStack != null) {
                if (itemStack.getType() == Material.BOW) {

                    slot_arc = i;

                } else if (itemStack.getType() == Material.DIAMOND_SWORD) {

                    slot_epee = i;

                }

            }
            i += 1;

        }
        if (slot_arc != -1) {

            ItemMeta epeeM = player.getInventory().getItem(slot_arc).getItemMeta();
            epeeM.addEnchant(Enchantment.ARROW_DAMAGE, 3, false);
            ItemStack epee = player.getInventory().getItem(slot_arc);
            epee.setItemMeta(epeeM);

        } else {

            ItemStack pioche = new ItemStack(Material.BOW, 1);
            ItemMeta piocheM = pioche.getItemMeta();
            piocheM.addEnchant(Enchantment.ARROW_DAMAGE, 3, false);
            pioche.setItemMeta(piocheM);
            player.getInventory().addItem(pioche);

        }
        if (slot_epee != -1) {

            ItemMeta epeeM = player.getInventory().getItem(slot_epee).getItemMeta();
            epeeM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
            ItemStack epee = player.getInventory().getItem(slot_epee);
            epee.setItemMeta(epeeM);
            player.getInventory().addItem(new ItemStack(Material.DIAMOND, 3));

        } else {

            ItemStack pioche = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta piocheM = pioche.getItemMeta();
            piocheM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
            pioche.setItemMeta(piocheM);
            player.getInventory().addItem(pioche);

        }

    }

    public static void CommandCopie(Joueur joueur, Joueur cible, Main main) {

        if (cible.getNBObscurCopie() == 300 || main.getMode() == "rapide") {

            if (cible.getOrbe() == Orbe.NONE) {

                joueur.getPlayer().sendMessage("Ce joueur ne possède pas d'orbe");

            } else {

                joueur.getPlayer().sendMessage("Tu viens de copier une orbe ( " + cible.getOrbe().toString() + " )");
                main.setOrbeCopieObscur(cible.getOrbe());

            }

        }
        else {
        	
        	joueur.getPlayer().sendMessage("Vous n'avez pas encore eu le temps de copier son orbe, restez proche du joueur pour pouvoir copier son orbe");
        	
        }

    }
    
    public static void ChangePiece(Pieces piece, Main main, Joueur joueur) {
    	
    	if(joueur.getOrbePiece(piece) == Orbe.EAU) {
    		
    		if(piece == Pieces.CASQUE && joueur.isCasqueObscurActif()) {
    			
    			joueur.removeResi(0.15);
    			
    		}
    		
    		if(piece == Pieces.JAMBIERE && joueur.isJambiereObscurActif()) {
    			
    			joueur.removeForce(0.10);
    			
    		}
    		
    		if(piece == Pieces.BOTTES) {
    			
    			joueur.getPlayer().getInventory().getBoots().removeEnchantment(Enchantment.DEPTH_STRIDER);
    			
    		}
    		
    	}
    	else if(joueur.getOrbePiece(piece) == Orbe.FEU) {
    		
    		if(piece == Pieces.CASQUE && joueur.isCasqueObscurActif()) {
    			
    			joueur.removeForce(0.10);
    			
    		}
    		
    		if(piece == Pieces.JAMBIERE && joueur.isJambiereObscurActif()) {
    			
    			joueur.removeResi(0.10);
    			
    		}
    		
    		if(piece == Pieces.BOTTES && joueur.isBottesObscurActif()) {
    			
    			joueur.removeSpeed(0.15);
    			
    		}
    		
    	}
    	else if(joueur.getOrbePiece(piece) == Orbe.GLACE) {
    		
    		if(piece == Pieces.BOTTES) {
    			
    			joueur.removeSpeed(0.10);
    			
    		}
    		else if(piece == Pieces.EPEE) {
    			
    			main.resetPlayerPourcentGlace();
    			
    		}
    		
    	}
    	else if(joueur.getOrbePiece(piece) == Orbe.FOUDRE) {
    		
    		if(piece == Pieces.CASQUE) {
    			
    			if(main.getStackFerObscur() == 5) {
					
    				joueur.removeForce(0.2);
    				joueur.removeResi(0.1);
					
				}
				else if(main.getStackFerObscur() == 4) {
					
					joueur.removeForce(0.2);
    				joueur.removeResi(0.08);
					
				}
				else if(main.getStackFerObscur() == 3) {
					
					joueur.removeForce(0.15);
    				joueur.removeResi(0.06);
					
				}
				else if(main.getStackFerObscur() == 2) {
					
					joueur.removeForce(0.1);
    				joueur.removeResi(0.04);
					
				}
				else if(main.getStackFerObscur() == 1) {
					
					joueur.removeForce(0.05);
    				joueur.removeResi(0.02);
					
				}
    			
    		}
    		else if(piece == Pieces.BOTTES) {
    			
    			joueur.removeSpeed(0.05);
    			if(joueur.getPlayer().hasPotionEffect(PotionEffectType.SPEED)) {
    				
    				joueur.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    				
    			}
    			
    		}
    		
    	}
    	
    }
    
    public static void CheckPassif(Main main, Joueur joueur) {
    	
    	if(!joueur.obscurHasOrbe(Orbe.EAU)) {
    		
    		joueur.removeSpeed(0.05);
    		
    	}
    	
    	if(!joueur.obscurHasOrbe(Orbe.FEU)) {
    		
    		joueur.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    		
    	}
    	
    	if(!joueur.obscurHasOrbe(Orbe.GLACE)) {
    		
    		joueur.removeResi(0.05);
    		
    	}
    	
    	if(!joueur.obscurHasOrbe(Orbe.FOUDRE)) {
    		
    		joueur.removeForce(0.05);
    		
    	}
    	
    }

    public static void CommandSetPiece(Joueur joueur, Pieces piece, Main main) {
    	
    	Player player = joueur.getPlayer();

        if (main.getOrbeCopieObscur() != Orbe.NONE) {

            if (piece == Pieces.CASQUE) {
                
                if(main.getOrbeCopieObscur() == Orbe.EAU) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe d'eau sur ton casque");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.EAU)) {
                		
                		joueur.addSpeed(0.05);
                		
                	}
                	joueur.setCasqueObscur(main.getOrbeCopieObscur());
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.FEU) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de feu sur ton casque");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.FEU)) {
                		
                		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 0, false, false));
                		
                	}
                	joueur.setCasqueObscur(Orbe.FEU);
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.GLACE) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de glace sur ton casque");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.GLACE)) {
                		
                		joueur.addResi(0.05);
                		
                	}
                	joueur.setCasqueObscur(Orbe.GLACE);
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.FOUDRE) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de foudre sur ton casque");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.FOUDRE)) {
                		
                		joueur.addForce(0.05);
                		
                	}
                	joueur.setCasqueObscur(Orbe.FOUDRE);
                	
                	CheckPassif(main, joueur);
                	
                }
                main.setOrbeCopieObscur(Orbe.NONE);

            } else if (piece == Pieces.PLASTRON) {

            	if(main.getOrbeCopieObscur() == Orbe.EAU) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe d'eau sur ton plastron");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.EAU)) {
                		
                		joueur.addSpeed(0.05);
                		
                	}
                	joueur.setPlastronObscur(main.getOrbeCopieObscur());
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.FEU) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de feu sur ton plastron");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.FEU)) {
                		
                		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 0, false, false));
                		
                	}
                	joueur.setPlastronObscur(Orbe.FEU);
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.GLACE) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de glace sur ton plastron");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.GLACE)) {
                		
                		joueur.addResi(0.05);
                		
                	}
                	joueur.setPlastronObscur(Orbe.GLACE);
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.FOUDRE) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de foudre sur ton plastron");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.FOUDRE)) {
                		
                		joueur.addForce(0.05);
                		
                	}
                	joueur.setPlastronObscur(Orbe.FOUDRE);
                	
                	CheckPassif(main, joueur);
                	
                }
                main.setOrbeCopieObscur(Orbe.NONE);

            } else if (piece == Pieces.JAMBIERE) {

            	if(main.getOrbeCopieObscur() == Orbe.EAU) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe d'eau sur tes jambières");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.EAU)) {
                		
                		joueur.addSpeed(0.05);
                		
                	}
                	joueur.setJambiereObscur(main.getOrbeCopieObscur());
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.FEU) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de feu sur tes jambières");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.FEU)) {
                		
                		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 0, false, false));
                		
                	}
                	joueur.setJambiereObscur(Orbe.FEU);
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.GLACE) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de glace sur tes jambières");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.GLACE)) {
                		
                		joueur.addResi(0.05);
                		
                	}
                	joueur.setJambiereObscur(Orbe.GLACE);
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.FOUDRE) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de foudre sur tes jambières");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.FOUDRE)) {
                		
                		joueur.addForce(0.05);
                		
                	}
                	joueur.setJambiereObscur(Orbe.FOUDRE);
                	
                	CheckPassif(main, joueur);
                	
                }
                main.setOrbeCopieObscur(Orbe.NONE);

            } else if (piece == Pieces.BOTTES) {

            	if(main.getOrbeCopieObscur() == Orbe.EAU) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe d'eau sur tes bottes");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.EAU)) {
                		
                		joueur.addSpeed(0.05);
                		
                	}
                	joueur.setBottesObscur(main.getOrbeCopieObscur());
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.FEU) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de feu sur tes bottes");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.FEU)) {
                		
                		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 0, false, false));
                		
                	}
                	joueur.setBottesObscur(Orbe.FEU);
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.GLACE) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de glace sur tes bottes");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.GLACE)) {
                		
                		joueur.addResi(0.05);
                		
                	}
                	joueur.setBottesObscur(Orbe.GLACE);
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.FOUDRE) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de foudre sur tes bottes");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.FOUDRE)) {
                		
                		joueur.addForce(0.05);
                		
                	}
                	joueur.setBottesObscur(Orbe.FOUDRE);
                	
                	CheckPassif(main, joueur);
                	
                }
                main.setOrbeCopieObscur(Orbe.NONE);

            } else if (piece == Pieces.EPEE) {

            	if(main.getOrbeCopieObscur() == Orbe.EAU) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe d'eau sur ton épée");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.EAU)) {
                		
                		joueur.addSpeed(0.05);
                		
                	}
                	joueur.setEpeeObscur(main.getOrbeCopieObscur());
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.FEU) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de feu sur ton épée");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.FEU)) {
                		
                		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 0, false, false));
                		
                	}
                	joueur.setEpeeObscur(Orbe.FEU);
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.GLACE) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de glace sur ton épée");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.GLACE)) {
                		
                		joueur.addResi(0.05);
                		
                	}
                	joueur.setEpeeObscur(Orbe.GLACE);
                	
                	CheckPassif(main, joueur);
                	
                }
                else if(main.getOrbeCopieObscur() == Orbe.FOUDRE) {
                	
                	player.sendMessage("Tu viens d'équiper l'orbe de foudre sur ton épée");
                	
                	ChangePiece(piece, main, joueur);
                	
                	if(!joueur.obscurHasOrbe(Orbe.FOUDRE)) {
                		
                		joueur.addForce(0.05);
                		
                	}
                	joueur.setEpeeObscur(Orbe.FOUDRE);
                	
                	CheckPassif(main, joueur);
                	
                }
                main.setOrbeCopieObscur(Orbe.NONE);

            }
            else {
            	
            	player.sendMessage("Merci de mettre un équipement valide (§b/rcsetpiece <casque|plastron|jambiere|bottes|epee>§r)");
            	
            }

        } else {

            player.sendMessage("Tu n'as pas d'orbe copier");

        }

    }

    public static void effetFoudre(Main main, String piece) {
    	
    	Joueur obscur = main.getJoueurByRole(Roles.Obscur);
    	
    	if(piece.equalsIgnoreCase("jambiere")) {
        	
        	for(Entity entity : obscur.getPlayer().getNearbyEntities(20, 20, 20)) {
        		
        		if(entity instanceof Player) {
        			
        			Player cible = (Player) entity;
        			
        			Material m = cible.getLocation().getBlock().getType();
        	        if (m == Material.STATIONARY_WATER || m == Material.WATER) {
        	        	
        	        	if(cible.getHealth() > 1) {
        	        		
        	        		cible.setHealth(cible.getHealth()-1);
        	        		
        	        	}
        	        	
        	        }
        			
        		}
        		
        	}
    		
    	}
    	else if(piece.equalsIgnoreCase("casque")) {
    		
    		int nb_fer = 0;
    		
    		for(ItemStack item : obscur.getPlayer().getInventory()) {
    			
    			if(item != null && item.getType() == Material.IRON_INGOT) {
    				
    				nb_fer += item.getAmount();
    				
    			}
    			
    		}
    		
    		if(nb_fer >= 320) {
    			
    			if(main.getStackFerObscur() != 5) {
    				
    				if(main.getStackFerObscur() == 4) {
    					
    					obscur.removeForce(0.2);
        				obscur.removeResi(0.08);
    					
    				}
    				else if(main.getStackFerObscur() == 3) {
    					
    					obscur.removeForce(0.15);
        				obscur.removeResi(0.06);
    					
    				}
    				else if(main.getStackFerObscur() == 2) {
    					
    					obscur.removeForce(0.1);
        				obscur.removeResi(0.04);
    					
    				}
    				else if(main.getStackFerObscur() == 1) {
    					
    					obscur.removeForce(0.05);
        				obscur.removeResi(0.02);
    					
    				}
    				
    				main.setStackFerObscur(5);
    				obscur.addForce(0.2);
    				obscur.addResi(0.1);
    				
    			}
    			
    		}
    		else if(nb_fer >= 256) {
    			
    			if(main.getStackFerObscur() != 4) {
    				
    				if(main.getStackFerObscur() == 5) {
    					
    					obscur.removeForce(0.2);
        				obscur.removeResi(0.1);
    					
    				}
    				else if(main.getStackFerObscur() == 3) {
    					
    					obscur.removeForce(0.15);
        				obscur.removeResi(0.06);
    					
    				}
    				else if(main.getStackFerObscur() == 2) {
    					
    					obscur.removeForce(0.1);
        				obscur.removeResi(0.04);
    					
    				}
    				else if(main.getStackFerObscur() == 1) {
    					
    					obscur.removeForce(0.05);
        				obscur.removeResi(0.02);
    					
    				}
    				
    				main.setStackFerObscur(4);
    				obscur.addForce(0.2);
    				obscur.addResi(0.08);
    				
    			}
    			
    		}
    		else if(nb_fer >= 192) {
    			
    			if(main.getStackFerObscur() != 3) {
    				
    				if(main.getStackFerObscur() == 5) {
    					
    					obscur.removeForce(0.2);
        				obscur.removeResi(0.1);
    					
    				}
    				else if(main.getStackFerObscur() == 4) {
    					
    					obscur.removeForce(0.2);
        				obscur.removeResi(0.08);
    					
    				}
    				else if(main.getStackFerObscur() == 2) {
    					
    					obscur.removeForce(0.1);
        				obscur.removeResi(0.04);
    					
    				}
    				else if(main.getStackFerObscur() == 1) {
    					
    					obscur.removeForce(0.05);
        				obscur.removeResi(0.02);
    					
    				}
    				
    				main.setStackFerObscur(3);
    				obscur.addForce(0.15);
    				obscur.addResi(0.06);
    				
    			}
    			
    		}
    		else if(nb_fer >= 128) {
    			
    			if(main.getStackFerObscur() != 2) {
    				
    				if(main.getStackFerObscur() == 5) {
    					
    					obscur.removeForce(0.2);
        				obscur.removeResi(0.1);
    					
    				}
    				else if(main.getStackFerObscur() == 4) {
    					
    					obscur.removeForce(0.2);
        				obscur.removeResi(0.08);
    					
    				}
    				else if(main.getStackFerObscur() == 3) {
    					
    					obscur.removeForce(0.15);
        				obscur.removeResi(0.06);
    					
    				}
    				else if(main.getStackFerObscur() == 1) {
    					
    					obscur.removeForce(0.05);
        				obscur.removeResi(0.02);
    					
    				}
    				
    				main.setStackFerObscur(2);
    				obscur.addForce(0.1);
    				obscur.addResi(0.04);
    				
    			}
    			
    		}
    		else if(nb_fer >= 64) {
    			
    			if(main.getStackFerObscur() != 1) {
    				
    				if(main.getStackFerObscur() == 5) {
    					
    					obscur.removeForce(0.2);
        				obscur.removeResi(0.1);
    					
    				}
    				else if(main.getStackFerObscur() == 4) {
    					
    					obscur.removeForce(0.2);
        				obscur.removeResi(0.08);
    					
    				}
    				else if(main.getStackFerObscur() == 3) {
    					
    					obscur.removeForce(0.15);
        				obscur.removeResi(0.06);
    					
    				}
    				else if(main.getStackFerObscur() == 2) {
    					
    					obscur.removeForce(0.1);
        				obscur.removeResi(0.04);
    					
    				}
    				
    				main.setStackFerObscur(1);
    				obscur.addForce(0.05);
    				obscur.addResi(0.02);
    				
    			}
    			
    		}
    		else {
    			
    			if(main.getStackFerObscur() != 0) {
    				
    				if(main.getStackFerObscur() == 5) {
    					
    					obscur.removeForce(0.2);
        				obscur.removeResi(0.1);
    					
    				}
    				else if(main.getStackFerObscur() == 4) {
    					
    					obscur.removeForce(0.2);
        				obscur.removeResi(0.08);
    					
    				}
    				else if(main.getStackFerObscur() == 3) {
    					
    					obscur.removeForce(0.15);
        				obscur.removeResi(0.06);
    					
    				}
    				else if(main.getStackFerObscur() == 2) {
    					
    					obscur.removeForce(0.1);
        				obscur.removeResi(0.04);
    					
    				}
    				else if(main.getStackFerObscur() == 1) {
    					
    					obscur.removeForce(0.05);
        				obscur.removeResi(0.02);
    					
    				}
    				
    				main.setStackFerObscur(0);
    				
    			}
    			
    		}
    		
    	}
    	else if(piece.equalsIgnoreCase("bottes")) {
    		
    		int nb_joueurs = 0;
        	
        	for(Entity entity : obscur.getPlayer().getNearbyEntities(20, 20, 20)) {
        		
        		if(entity instanceof Player) {
        			
        			Player player = (Player) entity;
        			Joueur j = main.getJoueur(player);
        			
        			if(j.getRole() != Roles.Trial && !player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
        				
        				nb_joueurs += 1;
        				
        			}
        			
        		}
        		
        	}
        	
        	if(nb_joueurs == 0 && !obscur.getPlayer().hasPotionEffect(PotionEffectType.SPEED)) {
        		
        		obscur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0, false, false));
        		
        	}
        	else if(nb_joueurs != 0 && obscur.getPlayer().hasPotionEffect(PotionEffectType.SPEED)) {
        		
        		obscur.getPlayer().removePotionEffect(PotionEffectType.SPEED);
        		
        	}
    		
    	}
    	
    }
    
    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §cObscur\n§rVous devez gagner avec le §ccamps démon§r\n \nAvec la commande /rccopie <pseudo>, vous pourrez copier l'orbe d'un jouer\n \nAvec la commande /rcsetpiece, vous pourrez mettre une orbe sur une pièce au choix\n \nBonus :\n  Eau:\n    - passif: vous recevez 5% de speed\n    - casque : Vous gagnez 15% de résistance dans l'eau\n    - plastron : Vous ne prenez plus de dégâts de feu\n    - jambière : Vous gagnez 10% de force dans l'eau\n    - bottes : Vous obtenez no fall et l'enchantement depth strider II sur vos bottes\n  Feu:\n    - passif : Vous avez l'effet résistance au feu I\n    - casque : Vous gagnez 10% de force lorsque vous êtes en feu\n    - plastron : A chaque coup subis, vous avez 5% de chance de mettre l'adversaire en feu\n    - jambiere : Vous gagnez 10% de résistance lorsque vous êtes en feu\n    - bottes : Vous gagnez 15% de speed lorsque vous êtes en feu\n    - epee : Vous avez 5% de chance de mettre en feu\n  Glace :\n    - passif : Vous gagnez 5% de résistance\n    - casque : Les dégâts subis par les flèches sont réduits de 30%\n    - plastron : Vous avez 5% de chance de ralentir un adversaire à chaque coup que vous subissez\n    - jambiere : Vous êtes immuniser de l'effet lenteur\n    - bottes : Vous gagnez 10% de speed\n    - epee : Vous avez 20% de chance a chaque coup de retirer 1% de speed à l'adversaire mais vous perdez 1% de force. Les % sont récupérer après un certains temps ou après avoir frappé un autre adversaire\n  Foudre :\n    - passif : Vous gagnez 5% de force\n    - casque : Selon le nombre de fer que vous possedez, vous gagnez des % de force et de résistance\n    - plastron : Lorsque vous subissez un coup, vous avez 10% de chance d'infliger 75% des dégâts reçu à l'adversaire\n    - jambiere : Si vous êtes dans l'eau, les joueurs à proximité se trouvant dans de l'eau subirons des dégâts\n    - bottes : Vous gagnez 5% de speed. Si aucun joueur (hormis Trial) n'est autour de vous, vous recevez l'effet speed I\n    - epee : Vous avez 5% de chance par coup de stun l'adversaire\n\n \nVous connaissez Trial\n \n____________________________________________________");

    }

}