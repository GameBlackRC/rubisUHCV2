package fr.gameblack.rcuhcv2.roles.v2.solo;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.orbes.v2.Eau;
import fr.gameblack.rcuhcv2.orbes.v2.Feu;
import fr.gameblack.rcuhcv2.orbes.v2.Foudre;
import fr.gameblack.rcuhcv2.orbes.v2.Glace;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;
import fr.gameblack.rcuhcv2.task.v2.GameCycle;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Farmeurimmo {
	
	public static void Items(Joueur joueur) {
		
		joueur.getPlayer().setMaxHealth(22);
		joueur.addForce(0.03);
		
		Texte(joueur.getPlayer());
		if(joueur.isBot()) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Farmeurimmo");
			
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §6Farmeurimmo\n§r"
        		+ "Vous devez gagner §6seul§r\n \n"
        		+ "Vous avez 3% de force ainsi que 1 coeur permanent supplémentaire\n \n"
        		+ "Au dessus de chaque joueur, vous voyez un poucentage de hack. Losqu'un joueur atteint 50%, vous pouvez utiliser la commande /rchack <joueur> sur lui. Lorsqu'un joueur atteint les 100%, vous pouvez utiliser la commande /rcvol <joueur> sur lui.\n \n"
        		+ "Avec la commande /rcvol, vous volez un pouvoir du joueur (effets, commandes ou items). Une fois cette commande utiliser sur un joueur, la commande /rchack n'est plus utilisable sur lui.\n \n"
        		+ "Avec la commande /rchack <joueur>, vous pouvez modifier/récuperer des informations sur le joueur (voir les possibilités avec la commande /rcinfo ou sur le doc).\n \n"
        		+ "Avec la commande /rccamp <joueur>, vous pouvez modifier le camp d'un joueur qui devra désormais gagner avec vous en échange d'1 coeur permanent. La commande est utilisable uniquement sur les joueurs que vous avez voler et qui ont atteint une 2ème fois les 100%. Le pouvoir volé seras innutilisable par le joueur.\n \n"
        		+ "____________________________________________________");

    }
	
	public static void commandSteal(Joueur joueur, Joueur cible, Main main) {
		
		if(joueur.getVol().size() < 2) {
			
			if(cible.getPourcentHack() >= 100) {
				
				if(!cible.isHack()) {
					
					cible.removePourcentHack(50, main, GameCycle.getScoreboardFarmeurimmo());
					
					if(cible.getRole() == Roles.RAPTOR) {
				        	
				        joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.RAPTOR_RAGE));
				        joueur.getPlayer().sendMessage("Vous venez de recevoir le pouvoir 'rage' de Raptor");
				        cible.setHack(true);
						
					} else if(cible.getRole() == Roles.JEANNOT) {
						
						joueur.addForce(0.02);
						joueur.getPlayer().sendMessage("Vous venez de recevoir la force de Jeannot");
						joueur.getVol().add(Pouvoirs.EFFET);
						cible.setHack(true);
						
					} else if(cible.getRole() == Roles.NICKOBOOP) {
						
						joueur.getPlayer().sendMessage("Vous venez de recevoir le pouvoir de résistance de Nickoboop. Vous gagnez désormais 3% de résistance proche de Jeannot");
						joueur.getVol().add(Pouvoirs.NICKOBOOP_PROCHE_JEANNOT);
						cible.setHack(true);
						
					} else if(cible.getRole() == Roles.SLUP) {
						
						joueur.addSpeed(0.05);
						joueur.getVol().add(Pouvoirs.EFFET);
						joueur.getPlayer().sendMessage("Vous venez de recevoir la speed de Slup");
						cible.setHack(true);
						
					} else if(cible.getRole() == Roles.JOKO) {
						
						joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.JOKO_SPEEDCUBING));
						joueur.getVol().add(Pouvoirs.JOKO_CUBE);
						cible.setHack(true);
						joueur.getPlayer().sendMessage("Vous recevez le pouvoir 'SpeedCubing' de joko ainsi que la commande /rccube");
						
					} else if(cible.getRole() == Roles.TEAM) {
						
						joueur.getVol().add(Pouvoirs.TEAM_INVISIBLE);
						cible.setHack(true);
						joueur.getPlayer().sendMessage("Vous pouvez désormais devenir invisible en retirant votre armure grâce au pouvoir de Team");
						
					} else if(cible.getRole() == Roles.GAMEBLACK) {
						
						if(cible.getCamp() == Camps.STAFF) {
							
							joueur.getVol().add(Pouvoirs.GAMEBLACK_MALUS_ORBE);
							cible.setHack(true);
							joueur.getPlayer().sendMessage("Vous ne pouvez plus recevoir de malus avec votre orbe grâce au pouvoir de GameBlack");
							
						} else if(cible.getCamp() == Camps.JOUEUR) {
							
							joueur.addSpeed(0.1);
							joueur.getVol().add(Pouvoirs.EFFET);
							joueur.getPlayer().sendMessage("Vous venez de recevoir la speed de GameBlack");
							cible.setHack(true);
							
						} else if(cible.getCamp() == Camps.UHC) {
							
							joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.GAMEBLACK_FUITE));
							
							joueur.getVol().add(Pouvoirs.GAMEBLACK_FUITE);
							cible.setHack(true);
							joueur.getPlayer().sendMessage("Vous venez de recevoir l'item 'Fuite' de GameBlack");
							
						}
						
					} else if(cible.getRole() == Roles.TRIAL) {
						
						if(cible.getModeTrial().equalsIgnoreCase("fun")) {
							
							joueur.addForce(0.02);
							joueur.getVol().add(Pouvoirs.EFFET);
							cible.setHack(true);
							joueur.getPlayer().sendMessage("Vous venez de recevoir la force de Trial");
							
						} else {
							
							joueur.getVol().add(Pouvoirs.TRIAL_FORCE_KILL);
							cible.setHack(true);
							joueur.getPlayer().sendMessage("Vous obtenez désormais 1% de force supplémentaire par kill grâce au pouvoir de Trial");
							
						}
						
					} else if(cible.getRole() == Roles.LOUP) {
						
						joueur.getVol().add(Pouvoirs.LOUP_SUPERBATEAU);
						cible.setHack(true);
						joueur.getPlayer().sendMessage("Vous venez de recevoir l'item 'Super bateau' de Loup");
						
						joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.LOUP_BATEAU));
						
					} else if(cible.getRole() == Roles.CAPTAIN) {
						
						joueur.getVol().add(Pouvoirs.CAPTAIN_REPAIR);
						cible.setHack(true);
						joueur.getPlayer().sendMessage("Vous venez de recevoir la commande /rcrepair de Captain");
						
					} else if(cible.getRole() == Roles.HEKOW) {
						
						joueur.getVol().add(Pouvoirs.EFFET);
						joueur.addResi(0.02);
						cible.setHack(true);
						joueur.getPlayer().sendMessage("Vous venez de recevoir la résistance de Hekow");
						
					} else if(cible.getRole() == Roles.MALIVOL) {
						
						joueur.getVol().add(Pouvoirs.MALIVOL_CHEAT);
						cible.setHack(true);
						joueur.getPlayer().sendMessage("Vous venez de recevoir l'item 'Cheat' de Malivol");
						
						joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.MALIVOL_CHEAT));
						
					} else if(cible.getRole() == Roles.TOINOU) {
						
						joueur.getVol().add(Pouvoirs.TOINOU_VACANCES);
						cible.setHack(true);
						joueur.getPlayer().sendMessage("Vous venez de recevoir la commande /rcvacance de Toinou");
						
					} else if(cible.getRole() == Roles.NONOBOY) {
						
						joueur.getVol().add(Pouvoirs.NONOBOY_COEUR_KILL);
						cible.setHack(true);
						joueur.getPlayer().sendMessage("Vous venez de recevoir le pouvoir de Nonoboy, vous recevez donc 1 demi-coeur supplémentaire à chaque kill");
						
					} else if(cible.getRole() == Roles.OBSCUR) {
						
						joueur.getVol().add(Pouvoirs.EFFET);
						joueur.addForce(0.02);
						cible.setHack(true);
						joueur.getPlayer().sendMessage("Vous venez de recevoir la force d'Obscur");
						
					} else if(cible.getRole() == Roles.THEOOCHOUX) {
						
						joueur.getVol().add(Pouvoirs.THEOOCHOUX_MINIROLLBACK);
						cible.setHack(true);
						joueur.getPlayer().getInventory().addItem(Main.getItemRole(ItRoles.THEOCHOUX_ROLLBACK));
						joueur.getPlayer().sendMessage("Vous venez de recevoir le pouvoir 'Mini Rollback' de Theoochoux");
						
					} else if(cible.getRole() == Roles.ROMPREMS) {
						
						if(main.getMode() == Modes.RAPIDE) {
							
							if(cible.getFirstKill() == null) {
						        	
						        joueur.addForce(0.01);
								
							}
							else if(cible.getFirstKill().equalsIgnoreCase("blaze")) {
								
								joueur.addResi(0.02);
								
							}
							else {
								
								joueur.addSpeed(0.05);
								
							}
							
						}
						
					} if(cible.getRole() == Roles.KZOU) {
						
						joueur.getVol().add(Pouvoirs.KZOU_BAN);
						cible.setHack(true);
						joueur.getPlayer().sendMessage("Vous venez de recevoir la commande /rcban de Kzou");
						
					}
					
				}
				else {
					
					joueur.getPlayer().sendMessage("Vous avez déjà volé ce joueur");
					
				}
				
			}
			else {
				
				joueur.getPlayer().sendMessage("Ce joueur n'a pas encore atteint les 100%");
				
			}
			
		}
		else {
			
			joueur.getPlayer().sendMessage("Vous ne pouvez plus utiliser cette commande");
			
		}
		
	}
	
	public static void commandCamp(Joueur joueur, Joueur cible, Main main) {
		
		if(cible.isHack() && cible.getPourcentHack() >= 100) {
			
			if(main.getMode() != Modes.RAPIDE) {
			
				cible.setCamp(Camps.FARMEURIMMO);
				cible.getPlayer().sendMessage("Farmeurimmo vient de changer votre camp, vous devez désormais gagner avec lui");
				joueur.getPlayer().sendMessage(cible.getPlayer().getName() + " doit désormais gagner avec vous");
			
			}
			
			joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth()-2);
			
			if(cible.getRole() == Roles.RAPTOR) {
	        	
		        cible.getPlayer().getInventory().remove(Main.getItemRole(ItRoles.RAPTOR_RAGE));
		        cible.getPlayer().sendMessage("Vous venez donc de perdre votre pouvoir 'Rage'");
				
			} else if(cible.getRole() == Roles.JEANNOT) {
				
				cible.removeForce(0.02);
				cible.getPlayer().sendMessage("Vous venez donc de perdre 2% de force");
				
			} else if(cible.getRole() == Roles.NICKOBOOP) {
				
				cible.getPlayer().sendMessage("Vous ne recevez donc plus votre résistance proche de Jeannot");
				
			} else if(cible.getRole() == Roles.SLUP) {
				
				cible.removeSpeed(0.05);
				cible.getPlayer().sendMessage("Vous perdez donc 5% de speed");
				
			} else if(cible.getRole() == Roles.JOKO) {
				
				cible.getPlayer().getInventory().remove(Main.getItemRole(ItRoles.JOKO_SPEEDCUBING));
				cible.getPlayer().sendMessage("Vous perdez donc votre pouvoir 'SpeedCubing'");
				
			} else if(cible.getRole() == Roles.TEAM) {
				
				cible.getPlayer().sendMessage("Vous perdez donc votre pouvoir d'invisibilité");
				
			} else if(cible.getRole() == Roles.GAMEBLACK) {
				
				if(cible.getCamp() == Camps.STAFF) {
					
					cible.getPlayer().sendMessage("Vous recevez donc à 100% le malus de votre orbe");
					
				} else if(cible.getCamp() == Camps.JOUEUR) {
					
					cible.removeSpeed(0.1);
					cible.getPlayer().sendMessage("Vous perdez donc 10% de speed");
					
				} else if(cible.getCamp() == Camps.UHC) {
					
					cible.getPlayer().getInventory().remove(Main.getItemRole(ItRoles.GAMEBLACK_FUITE));
					cible.getPlayer().sendMessage("Vous perdez donc votre pouvoir 'Fuite'");
					
				}
				
			} else if(cible.getRole() == Roles.TRIAL) {
				
				if(cible.getModeTrial().equalsIgnoreCase("fun")) {
					
					cible.removeForce(0.02);
					cible.getPlayer().sendMessage("Vous perdez donc 2% de force");
					
				} else {
					
					cible.getPlayer().sendMessage("Vous ne gagnez donc plus 2% de force à chaque kill");
					
				}
				
			} else if(cible.getRole() == Roles.LOUP) {
				
				cible.getPlayer().sendMessage("Vous perdez donc votre pouvoir 'Super bateau'");
				
				cible.getPlayer().getInventory().remove(Main.getItemRole(ItRoles.LOUP_BATEAU));
				
			} else if(cible.getRole() == Roles.CAPTAIN) {
				
				cible.getPlayer().sendMessage("Vous perdez donc la commande /rcrepair");
				
			} else if(cible.getRole() == Roles.HEKOW) {
				
				cible.removeResi(0.02);
				cible.getPlayer().sendMessage("Vous perdez donc 2% de résistance");
				
			} else if(cible.getRole() == Roles.MALIVOL) {
				
				cible.getPlayer().sendMessage("Vous perdez donc votre pouvoir 'Cheat'");
				
				cible.getPlayer().getInventory().remove(Main.getItemRole(ItRoles.MALIVOL_CHEAT));
				
			} else if(cible.getRole() == Roles.TOINOU) {
				
				cible.getPlayer().sendMessage("Vous perdez donc la commande /rcvacance");
				
			} else if(cible.getRole() == Roles.OBSCUR) {
				
				cible.removeForce(0.02);
				cible.getPlayer().sendMessage("Vous perdez donc 2% de force permanent");
				
			} else if(cible.getRole() == Roles.THEOOCHOUX) {
				
				cible.getPlayer().sendMessage("Vous perdez donc votre pouvoir 'mini rollback'");
				
			} else if(cible.getRole() == Roles.KZOU) {
				
				cible.getPlayer().sendMessage("Vous perdez donc la commande /rcban");
				
			}
			
		}
		else {
			
			joueur.getPlayer().sendMessage("Vous ne pouvez pas encore modifier le camp de ce joueur");
			
		}
		
	}

	public static void commandCode(Joueur joueur, Joueur cible, Main main) {
		
		if(cible.getPourcentHack() >= 50 && !cible.isHack()) {
			
			if(main.getScenarios().contains(Scenarios.SON_EN_FOLIE)) {
				Bukkit.getWorld("world").playSound(joueur.getPlayer().getLocation(), Sound.BLAZE_HIT, 10, 1);
			}
		
			joueur.getCD().add(Pouvoirs.FARMEURIMMO_HACK);
			cible.removePourcentHack(50, main, GameCycle.getScoreboardFarmeurimmo());
			
			Random r = new Random();
	        int nb = r.nextInt(100);
	        
	        if (nb <= 10) {
	        	
	        	//clear abso de la cible pendant 2min (fonctionnel)
	        	cible.setAbso(false);
	        	ItemCD cycle = new ItemCD(main, joueur, "abso", 120, cible, null, null, 0, null);
	            cycle.runTaskTimer(main, 0, 20);
	            joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " ne peux plus recevoir d'absorption pendant 2 minutes");
	        	
	        }
	        else if (nb <= 20) {
	        	
	        	//connaître les pourcentages d'effets que le joueur possède ainsi que son orbe
	        	double speed = cible.getSpeed() - 100;
	            double force = cible.getForce() - 100;
	            double resi = cible.getResi() - 110;
	        	joueur.getPlayer().sendMessage("Effets du joueur " + cible.getPlayer().getName() + ": _______________________________\n \nForce : " + force + "%\nSpeed : " + speed + "%\nRésistance : " + resi + "%\n \n_______________________________\n \nOrbe : " + cible.getOrbe().toString());
	        	
	        }
	        else if (nb <= 30) {
	        	
	        	//modif l'enchant de l'épée (BUG)
	        	
	        	if (joueur.getPlayer().getInventory().contains(Material.DIAMOND_SWORD) || joueur.getPlayer().getInventory().contains(Material.IRON_SWORD)) {
	
	                for (ItemStack itemStack : cible.getPlayer().getInventory().getContents()) {
	
	                    if (itemStack != null) {
	                        if (itemStack.getType() == Material.DIAMOND_SWORD || itemStack.getType() == Material.IRON_SWORD) {
	
	                            int niv = itemStack.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
	                            niv -= 2;
	                            if(niv < 1) {
	                            	niv = 0;
	                            }
	                            
	                            itemStack.removeEnchantment(Enchantment.DAMAGE_ALL);
	                            itemStack.addEnchantment(Enchantment.DAMAGE_ALL, niv);
	
	                        }
	
	                    }
	
	                }
	
	            }
	        	
	        	ItemCD cycle = new ItemCD(main, joueur, "enchant_epee", 60, cible, null, null, 0, null);
	            cycle.runTaskTimer(main, 0, 20);
	            joueur.getPlayer().sendMessage("L'enchantement de l'épée de " + cible.getPlayer().getDisplayName() + " a été modifier pendant 1 minute");
	        	
	        }
	        else if(nb <= 40) {
	        	
	        	//retire 10% d'un effet aléatoire
	        	int nb2 = r.nextInt(3);
	        	if(nb2 == 1) {
	        		
	        		cible.removeForce(0.05);
	        		ItemCD cycle = new ItemCD(main, joueur, "add_force_farmeurimmo", 60, cible, null, null, 0, null);
	                cycle.runTaskTimer(main, 0, 20);
	                joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " a perdu 10% de force pendant 1 minute");
	        		
	        	}
	        	else if(nb2 == 2) {
	        		
	        		cible.removeResi(0.05);
	        		ItemCD cycle = new ItemCD(main, joueur, "add_resi_farmeurimmo", 60, cible, null, null, 0, null);
	                cycle.runTaskTimer(main, 0, 20);
	                joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " a perdu 10% de résistance pendant 1 minute");
	        		
	        	}
	        	else {
	        		
	        		cible.removeSpeed(0.05);
	        		ItemCD cycle = new ItemCD(main, joueur, "add_speed_farmeurimmo", 60, cible, null, null, 0, null);
	                cycle.runTaskTimer(main, 0, 20);
	                joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " a perdu 10% de speed pendant 1 minute");
	        		
	        	}
	        	
	        }
	        else if(nb <= 50) {
	        	
	        	//connaitre le camp du joueur
	        	joueur.getPlayer().sendMessage("Ce joueur fait partie du camp " + cible.getCamp());
	        	
	        }
	        else if(nb <= 55) {
	        	
	        	//désactive l'orbe du joueur et active le malus (s'il n'a pas d'orbe il perd 5% de speed et de force pendant 1min)
	        	if(cible.getOrbe() != Orbe.NONE) {
	        		
	        		if(cible.getOrbe() == Orbe.EAU) {
	        			
	        			Eau.Malus(cible, main, true);
	        			Eau.Passif(cible, main, false);
	        			
	        		}
	        		else if(cible.getOrbe() == Orbe.FEU){
	        			
	        			Feu.Malus(cible, main, true);
	        			Feu.Passif(cible, main, false);
	        			
	        		}
	        		else if(cible.getOrbe() == Orbe.GLACE) {
	        			
	        			Glace.Malus(cible, main, true);
	        			Glace.Passif(cible, main, false);
	        			
	        		}
	        		else {
	        			
	        			Foudre.Malus(cible, main, true);
	        			Foudre.Passif(cible, main, false);
	        			
	        		}
	        		
	        		joueur.getPlayer().sendMessage("Le malus de l'orbe de " + cible.getPlayer().getDisplayName() + " a été activer");
	        		
	        	}
	        	
	        }
	        else if(nb <= 70) {
	        	
	        	//désactive l'orbe du joueur pendant 1min (s'il n'a pas d'orbe, il perd 5% de force pendant 1min)
	        	
	        	if(cible.getOrbe() != Orbe.NONE) {
	        		
	        		if(cible.getOrbe() == Orbe.EAU) {
	        			
	        			Eau.Passif(cible, main, false);
	        			
	        		}
	        		else if(cible.getOrbe() == Orbe.FEU){
	        			
	        			Feu.Passif(cible, main, false);
	        			
	        		}
	        		else if(cible.getOrbe() == Orbe.GLACE) {
	        			
	        			Glace.Passif(cible, main, false);
	        			
	        		}
	        		else {
	        			
	        			Foudre.Passif(cible, main, false);
	        			
	        		}
	        		
	        		ItemCD cycle = new ItemCD(main, joueur, "desac_orbe", 60, cible, null, null, 0, null);
	                cycle.runTaskTimer(main, 0, 20);
	                
	                joueur.getPlayer().sendMessage("L'orbe de " + cible.getPlayer().getDisplayName() + " est desactivé pendant 1 minute");
	        		
	        	}
	        	else {
	        		
	        		cible.removeForce(0.05);
	        		
	        		ItemCD cycle = new ItemCD(main, joueur, "effet_desac_orbe", 60, cible, null, null, 0, null);
	                cycle.runTaskTimer(main, 0, 20);
	        		
	        	}
	        	
	        }
	        else if(nb <= 80) {
	        	
	        	//retire 2 coeurs permanent pendant 1min
	        	cible.getPlayer().setMaxHealth(cible.getPlayer().getMaxHealth()-4);
	        	ItemCD cycle = new ItemCD(main, joueur, "malus_coeur_farmeurimmo", 60, cible, null, null, 0, null);
	            cycle.runTaskTimer(main, 0, 20);
	            joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " perd 2 coeurs permanent pendant 1 minute");
	        	
	        }
	        else if(nb <= 90) {
	        	
	        	//le joueur a 10% de chance de recevoir des coup enflammé à chaque coup subis pendant 2 minutes
	        	cible.setFire(true);
	        	
	        	ItemCD cycle = new ItemCD(main, joueur, "malus_feu_farmeurimmo", 60, cible, null, null, 0, null);
	            cycle.runTaskTimer(main, 0, 20);
	            joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " peut être enflammer pendant 1 minute");
	        	
	        }
	        else {
	        	
	        	//l'arc du joueur est innutilisable (disparait de l'inv pendant 1min)
	        	for(ItemStack item : cible.getPlayer().getInventory().getContents()) {
	        		if(item != null && item.getType() == Material.BOW) {
	        			item.setType(Material.BARRIER);
	        		}
	        	}
	        	ItemCD cycle = new ItemCD(main, joueur, "malus_bow_farmeurimmo", 60, cible, null, null, 0, null);
	            cycle.runTaskTimer(main, 0, 20);
	            joueur.getPlayer().sendMessage(cible.getPlayer().getDisplayName() + " ne peux plus utiliser son arc pendant 1 minute");
	        	
	        }
	        
	        ItemCD cycle = new ItemCD(main, joueur, "cd_hack_farmeurimmo", 300, cible, null, null, 0, null);
	        cycle.runTaskTimer(main, 0, 20);
	        
		}
		else {
			
			joueur.getPlayer().sendMessage("Ce joueur n'a pas encore atteint les 50%");
			
		}
		
	}
	
}
