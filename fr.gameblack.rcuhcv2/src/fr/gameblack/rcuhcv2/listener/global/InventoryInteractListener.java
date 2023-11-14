package fr.gameblack.rcuhcv2.listener.global;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.Pieces;
import fr.gameblack.rcuhcv2.classes.v2.Classe;
import fr.gameblack.rcuhcv2.listener.v1.CompoV1;
import fr.gameblack.rcuhcv2.listener.v2.CompoV2;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.orbes.v2.Eau;
import fr.gameblack.rcuhcv2.orbes.v2.Feu;
import fr.gameblack.rcuhcv2.orbes.v2.Foudre;
import fr.gameblack.rcuhcv2.orbes.v2.Glace;
import fr.gameblack.rcuhcv2.roles.v1.demons.Ange;
import fr.gameblack.rcuhcv2.roles.v1.demons.ObscurV1;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Slup;
import fr.gameblack.rcuhcv2.roles.v2.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.v2.staff.Loup;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class InventoryInteractListener implements Listener {

    private Main main;

    public InventoryInteractListener(Main main) {
        this.main = main;
    }

    //public void onRenderName(RenderNameTagEvent event) {
    //Player player = event.getPlayer();
    //if (main.getRole(player) == Roles.GAMEBLACK && main.getPacteGB() == 1) {
    //int health = (int) player.getHealth();
    //event.setTag(event.getTag() + ": " + health);
    //}
    //}

	@EventHandler
    public void onClick(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        //if(current == null) return;

        if (inv.getName().equalsIgnoreCase("§8Compo")) {

            event.setCancelled(true);

            Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Compo");

            switch (current.getType()) {

                case DIAMOND_PICKAXE:

                	inv_pacte.setItem(1, Main.getItem(Material.DIAMOND_PICKAXE, "§aCamp Joueur", ""));
                    inv_pacte.setItem(3, Main.getItem(Material.COMMAND, "§9Camp Staff", ""));
                    inv_pacte.setItem(5, Main.getItem(Material.GOLDEN_APPLE, "§2Camp UHC", ""));
                    inv_pacte.setItem(7, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));
                    
                    int slot = 18;
                    
                    if(main.getCompo().contains(Roles.RAPTOR)) {
                    	
                    	inv_pacte.setItem(slot, Main.getItem(Material.REDSTONE_BLOCK, "§aRaptor", ""));
                    	slot += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.JEANNOT)) {
                    	
                    	inv_pacte.setItem(slot, Main.getItem(Material.DIAMOND_HOE, "§aJeannot", ""));
                    	slot += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.NICKOBOOP)) {
                    	
                    	inv_pacte.setItem(slot, Main.getItem(Material.PAPER, "§aNickoboop", ""));
                    	slot += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.SLUP)) {
                    	
                    	inv_pacte.setItem(slot, Main.getItem(Material.SLIME_BALL, "§aSlup", ""));
                    	slot += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.JOKO)) {
                    	
                    	inv_pacte.setItem(slot, Main.getItem(Material.QUARTZ_BLOCK, "§aJoko", ""));
                    	slot += 1;
                    	
                    }

                    player.openInventory(inv_pacte);

                    break;

                case COMMAND:

                	inv_pacte.setItem(1, Main.getItem(Material.DIAMOND_PICKAXE, "§aCamp Joueur", ""));
                    inv_pacte.setItem(3, Main.getItem(Material.COMMAND, "§9Camp Staff", ""));
                    inv_pacte.setItem(5, Main.getItem(Material.GOLDEN_APPLE, "§2Camp UHC", ""));
                    inv_pacte.setItem(7, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));
                    
                    int slot1 = 18;
                    
                    if(main.getCompo().contains(Roles.TEAM)) {
                    	
                    	inv_pacte.setItem(slot1, Main.getItem(Material.GLASS, "§9Team", ""));
                    	slot1 += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.GAMEBLACK)) {
                    	
                    	inv_pacte.setItem(slot1, Main.getItem(Material.COMMAND, "§9GameBlack", ""));
                    	slot1 += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.MAKA)) {
                    	
                    	inv_pacte.setItem(slot1, Main.getItem(Material.RED_ROSE, "§9Maka", ""));
                    	slot1 += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.TRIAL)) {
                    	
                    	inv_pacte.setItem(slot1, Main.getItem(Material.NETHERRACK, "§9Trial", ""));
                    	slot1 += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.LOUP)) {
                    	
                    	inv_pacte.setItem(slot1, Main.getItem(Material.BOAT, "§9Loup", ""));
                    	slot1 += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.CAPTAIN)) {
                    	
                    	inv_pacte.setItem(slot1, Main.getItem(Material.IRON_CHESTPLATE, "§9Captain", ""));
                    	slot1 += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.HEKOW)) {
                    	
                    	inv_pacte.setItem(slot1, Main.getItem(Material.GOLD_BLOCK, "§9Hekow", ""));
                    	slot1 += 1;
                    	
                    }

                    player.openInventory(inv_pacte);

                    break;

                case GOLDEN_APPLE:

                	inv_pacte.setItem(1, Main.getItem(Material.DIAMOND_PICKAXE, "§aCamp Joueur", ""));
                    inv_pacte.setItem(3, Main.getItem(Material.COMMAND, "§9Camp Staff", ""));
                    inv_pacte.setItem(5, Main.getItem(Material.GOLDEN_APPLE, "§2Camp UHC", ""));
                    inv_pacte.setItem(7, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));
                    
                    int slot2 = 18;
                    
                    if(main.getCompo().contains(Roles.MALIVOL)) {
                    	
                    	inv_pacte.setItem(slot2, Main.getItem(Material.BEDROCK, "§2Malivol", ""));
                    	slot2 += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.TOINOU)) {
                    	
                    	inv_pacte.setItem(slot2, Main.getItem(Material.GLASS, "§2Toinou", ""));
                    	slot2 += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.OBSCUR)) {
                    	
                    	inv_pacte.setItem(slot2, Main.getItem(Material.OBSIDIAN, "§2Obscur", ""));
                    	slot2 += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.NONOBOY)) {
                    	
                    	inv_pacte.setItem(slot2, Main.getItem(Material.NETHERRACK, "§2Nonoboy", ""));
                    	slot2 += 1;
                    	
                    }

                    player.openInventory(inv_pacte);

                    break;
                    
                case GOLD_INGOT:

                	inv_pacte.setItem(1, Main.getItem(Material.DIAMOND_PICKAXE, "§aCamp Joueur", ""));
                    inv_pacte.setItem(3, Main.getItem(Material.COMMAND, "§9Camp Staff", ""));
                    inv_pacte.setItem(5, Main.getItem(Material.GOLDEN_APPLE, "§2Camp UHC", ""));
                    inv_pacte.setItem(7, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));
                    
                    int slot3 = 18;
                    
                    if(main.getCompo().contains(Roles.FARMEURIMMO)) {
                    	
                    	inv_pacte.setItem(slot3, Main.getItem(Material.COMMAND, "§2Farmeurimmo", ""));
                    	slot3 += 1;
                    	
                    }
                    if(main.getCompo().contains(Roles.KZOU)) {
                    	
                    	inv_pacte.setItem(slot3, Main.getItem(Material.DIAMOND, "§2Kzou", ""));
                    	slot3 += 1;
                    	
                    }

                    player.openInventory(inv_pacte);

                    break;

                default:
                    break;

            }

        } else if(inv.getName().equalsIgnoreCase("§8Choix de la pièce")) {
        	
        	event.setCancelled(true);
        	Joueur joueur = main.getJoueur(player);
        	
        	switch (current.getType()) {
        	
        		case DIAMOND_HELMET:
        			
        			player.closeInventory();
        			ObscurV1.CommandSetPiece(joueur, Pieces.CASQUE, main);
        			
        			break;
        			
        		case DIAMOND_CHESTPLATE:
        			
        			player.closeInventory();
        			ObscurV1.CommandSetPiece(joueur, Pieces.PLASTRON, main);
        			
        			break;
        			
        		case DIAMOND_LEGGINGS:
        			
        			player.closeInventory();
        			ObscurV1.CommandSetPiece(joueur, Pieces.JAMBIERE, main);
        			
        			break;
        			
        		case DIAMOND_BOOTS:
        			
        			player.closeInventory();
        			ObscurV1.CommandSetPiece(joueur, Pieces.BOTTES, main);
        			
        			break;
        			
        		case DIAMOND_SWORD:
        			
        			player.closeInventory();
        			ObscurV1.CommandSetPiece(joueur, Pieces.EPEE, main);
        			
        			break;
        			
        		default: break;
        	
        	}
        	
        } else if(inv.getName().startsWith("§8Réparation")) {
        	
        	String[] pseudos = inv.getName().split(" ");
        	String pseudo = pseudos[1];
        	event.setCancelled(true);
        	Joueur cible = main.getJoueurByPseudo(pseudo);
        	Joueur joueur = main.getJoueur(player);
        	
        	switch (current.getType()) {
        	
        		case IRON_HELMET:
        				
        			ItemStack item = new ItemStack(Material.IRON_HELMET);
        				
        			ItemMeta t = item.getItemMeta();
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
        					
        				t.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.OXYGEN)) {
        					
        				t.addEnchant(Enchantment.OXYGEN, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.OXYGEN), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS)) {
        					
        				t.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.PROTECTION_FALL)) {
        					
        				t.addEnchant(Enchantment.PROTECTION_FALL, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_FALL), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.PROTECTION_FIRE)) {
        					
        				t.addEnchant(Enchantment.PROTECTION_FIRE, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_FIRE), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.PROTECTION_PROJECTILE)) {
        					
        				t.addEnchant(Enchantment.PROTECTION_PROJECTILE, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.DURABILITY)) {
        					
        				t.addEnchant(Enchantment.DURABILITY, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.DURABILITY), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.THORNS)) {
        					
        				t.addEnchant(Enchantment.THORNS, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.THORNS), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.WATER_WORKER)) {
        					
        				t.addEnchant(Enchantment.WATER_WORKER, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.WATER_WORKER), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.DEPTH_STRIDER)) {
        					
        				t.addEnchant(Enchantment.DEPTH_STRIDER, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.DEPTH_STRIDER), false);
        					
        			}
        				
        			item.setItemMeta(t);
        				
        			cible.getPlayer().getInventory().setHelmet(item);
        			
        			if(!main.getCD().contains(Pouvoirs.CAPTAIN_REPAIR)) {
        			
	        			main.getCD().add(Pouvoirs.CAPTAIN_REPAIR);
	        			joueur.setRepairCaptain(0);
	        			
        			}
        			
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		case DIAMOND_HELMET:
        			
        			ItemStack item2 = new ItemStack(Material.DIAMOND_HELMET);
    				
        			ItemMeta t2 = item2.getItemMeta();
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
        					
        				t2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.OXYGEN)) {
        					
        				t2.addEnchant(Enchantment.OXYGEN, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.OXYGEN), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS)) {
        					
        				t2.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.PROTECTION_FALL)) {
        					
        				t2.addEnchant(Enchantment.PROTECTION_FALL, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_FALL), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.PROTECTION_FIRE)) {
        					
        				t2.addEnchant(Enchantment.PROTECTION_FIRE, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_FIRE), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.PROTECTION_PROJECTILE)) {
        					
        				t2.addEnchant(Enchantment.PROTECTION_PROJECTILE, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.DURABILITY)) {
        					
        				t2.addEnchant(Enchantment.DURABILITY, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.DURABILITY), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.THORNS)) {
        					
        				t2.addEnchant(Enchantment.THORNS, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.THORNS), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.WATER_WORKER)) {
        					
        				t2.addEnchant(Enchantment.WATER_WORKER, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.WATER_WORKER), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getHelmet().containsEnchantment(Enchantment.DEPTH_STRIDER)) {
        					
        				t2.addEnchant(Enchantment.DEPTH_STRIDER, cible.getPlayer().getInventory().getHelmet().getEnchantmentLevel(Enchantment.DEPTH_STRIDER), false);
        					
        			}
        				
        			item2.setItemMeta(t2);
        				
        			cible.getPlayer().getInventory().setHelmet(item2);
        			
        			if(!main.getCD().contains(Pouvoirs.CAPTAIN_REPAIR)) {
            			
	        			main.getCD().add(Pouvoirs.CAPTAIN_REPAIR);
	        			joueur.setRepairCaptain(0);
	        			
        			}
        			
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		case IRON_CHESTPLATE:
        			
        			ItemStack armure = cible.getPlayer().getInventory().getChestplate();
        			
        			ItemStack item3 = new ItemStack(Material.IRON_CHESTPLATE);
    				
        			ItemMeta t3 = item3.getItemMeta();
        			if(armure.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
        					
        				t3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, armure.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL), false);
        					
        			}
        			if(cible.getPlayer().getInventory().getChestplate().containsEnchantment(Enchantment.OXYGEN)) {
        					
        				t3.addEnchant(Enchantment.OXYGEN, armure.getEnchantmentLevel(Enchantment.OXYGEN), false);
        					
        			}
        			if(armure.containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS)) {
        					
        				t3.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, armure.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS), false);
        					
        			}
        			if(armure.containsEnchantment(Enchantment.PROTECTION_FALL)) {
        					
        				t3.addEnchant(Enchantment.PROTECTION_FALL, armure.getEnchantmentLevel(Enchantment.PROTECTION_FALL), false);
        					
        			}
        			if(armure.containsEnchantment(Enchantment.PROTECTION_FIRE)) {
        					
        				t3.addEnchant(Enchantment.PROTECTION_FIRE, armure.getEnchantmentLevel(Enchantment.PROTECTION_FIRE), false);
        					
        			}
        			if(armure.containsEnchantment(Enchantment.PROTECTION_PROJECTILE)) {
        					
        				t3.addEnchant(Enchantment.PROTECTION_PROJECTILE, armure.getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE), false);
        					
        			}
        			if(armure.containsEnchantment(Enchantment.DURABILITY)) {
        					
        				t3.addEnchant(Enchantment.DURABILITY, armure.getEnchantmentLevel(Enchantment.DURABILITY), false);
        					
        			}
        			if(armure.containsEnchantment(Enchantment.THORNS)) {
        					
        				t3.addEnchant(Enchantment.THORNS, armure.getEnchantmentLevel(Enchantment.THORNS), false);
        					
        			}
        			if(armure.containsEnchantment(Enchantment.WATER_WORKER)) {
        					
        				t3.addEnchant(Enchantment.WATER_WORKER, armure.getEnchantmentLevel(Enchantment.WATER_WORKER), false);
        					
        			}
        			if(armure.containsEnchantment(Enchantment.DEPTH_STRIDER)) {
        					
        				t3.addEnchant(Enchantment.DEPTH_STRIDER, armure.getEnchantmentLevel(Enchantment.DEPTH_STRIDER), false);
        					
        			}
        				
        			item3.setItemMeta(t3);
        				
        			cible.getPlayer().getInventory().setChestplate(item3);
        			
        			if(!main.getCD().contains(Pouvoirs.CAPTAIN_REPAIR)) {
            			
	        			main.getCD().add(Pouvoirs.CAPTAIN_REPAIR);
	        			joueur.setRepairCaptain(0);
	        			
        			}
        			
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		case DIAMOND_CHESTPLATE:
        			
        			ItemStack armure1 = cible.getPlayer().getInventory().getChestplate();
        			
        			ItemStack item4 = new ItemStack(Material.DIAMOND_CHESTPLATE);
    				
        			ItemMeta t4 = item4.getItemMeta();
        			if(armure1.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
        					
        				t4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, armure1.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL), false);
        					
        			}
        			if(armure1.containsEnchantment(Enchantment.OXYGEN)) {
        					
        				t4.addEnchant(Enchantment.OXYGEN, armure1.getEnchantmentLevel(Enchantment.OXYGEN), false);
        					
        			}
        			if(armure1.containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS)) {
        					
        				t4.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, armure1.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS), false);
        					
        			}
        			if(armure1.containsEnchantment(Enchantment.PROTECTION_FALL)) {
        					
        				t4.addEnchant(Enchantment.PROTECTION_FALL, armure1.getEnchantmentLevel(Enchantment.PROTECTION_FALL), false);
        					
        			}
        			if(armure1.containsEnchantment(Enchantment.PROTECTION_FIRE)) {
        					
        				t4.addEnchant(Enchantment.PROTECTION_FIRE, armure1.getEnchantmentLevel(Enchantment.PROTECTION_FIRE), false);
        					
        			}
        			if(armure1.containsEnchantment(Enchantment.PROTECTION_PROJECTILE)) {
        					
        				t4.addEnchant(Enchantment.PROTECTION_PROJECTILE, armure1.getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE), false);
        					
        			}
        			if(armure1.containsEnchantment(Enchantment.DURABILITY)) {
        					
        				t4.addEnchant(Enchantment.DURABILITY, armure1.getEnchantmentLevel(Enchantment.DURABILITY), false);
        					
        			}
        			if(armure1.containsEnchantment(Enchantment.THORNS)) {
        					
        				t4.addEnchant(Enchantment.THORNS, armure1.getEnchantmentLevel(Enchantment.THORNS), false);
        					
        			}
        			if(armure1.containsEnchantment(Enchantment.WATER_WORKER)) {
        					
        				t4.addEnchant(Enchantment.WATER_WORKER, armure1.getEnchantmentLevel(Enchantment.WATER_WORKER), false);
        					
        			}
        			if(armure1.containsEnchantment(Enchantment.DEPTH_STRIDER)) {
        					
        				t4.addEnchant(Enchantment.DEPTH_STRIDER, armure1.getEnchantmentLevel(Enchantment.DEPTH_STRIDER), false);
        					
        			}
        				
        			item4.setItemMeta(t4);
        				
        			cible.getPlayer().getInventory().setChestplate(item4);
        			
        			if(!main.getCD().contains(Pouvoirs.CAPTAIN_REPAIR)) {
            			
	        			main.getCD().add(Pouvoirs.CAPTAIN_REPAIR);
	        			joueur.setRepairCaptain(0);
	        			
        			}
        			
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		case IRON_LEGGINGS:
        			
        			ItemStack armure2 = cible.getPlayer().getInventory().getLeggings();
        			
        			ItemStack item5 = new ItemStack(Material.IRON_LEGGINGS);
    				
        			ItemMeta t5 = item5.getItemMeta();
        			if(armure2.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
        					
        				t5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, armure2.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL), false);
        					
        			}
        			if(armure2.containsEnchantment(Enchantment.OXYGEN)) {
        					
        				t5.addEnchant(Enchantment.OXYGEN, armure2.getEnchantmentLevel(Enchantment.OXYGEN), false);
        					
        			}
        			if(armure2.containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS)) {
        					
        				t5.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, armure2.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS), false);
        					
        			}
        			if(armure2.containsEnchantment(Enchantment.PROTECTION_FALL)) {
        					
        				t5.addEnchant(Enchantment.PROTECTION_FALL, armure2.getEnchantmentLevel(Enchantment.PROTECTION_FALL), false);
        					
        			}
        			if(armure2.containsEnchantment(Enchantment.PROTECTION_FIRE)) {
        					
        				t5.addEnchant(Enchantment.PROTECTION_FIRE, armure2.getEnchantmentLevel(Enchantment.PROTECTION_FIRE), false);
        					
        			}
        			if(armure2.containsEnchantment(Enchantment.PROTECTION_PROJECTILE)) {
        					
        				t5.addEnchant(Enchantment.PROTECTION_PROJECTILE, armure2.getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE), false);
        					
        			}
        			if(armure2.containsEnchantment(Enchantment.DURABILITY)) {
        					
        				t5.addEnchant(Enchantment.DURABILITY, armure2.getEnchantmentLevel(Enchantment.DURABILITY), false);
        					
        			}
        			if(armure2.containsEnchantment(Enchantment.THORNS)) {
        					
        				t5.addEnchant(Enchantment.THORNS, armure2.getEnchantmentLevel(Enchantment.THORNS), false);
        					
        			}
        			if(armure2.containsEnchantment(Enchantment.WATER_WORKER)) {
        					
        				t5.addEnchant(Enchantment.WATER_WORKER, armure2.getEnchantmentLevel(Enchantment.WATER_WORKER), false);
        					
        			}
        			if(armure2.containsEnchantment(Enchantment.DEPTH_STRIDER)) {
        					
        				t5.addEnchant(Enchantment.DEPTH_STRIDER, armure2.getEnchantmentLevel(Enchantment.DEPTH_STRIDER), false);
        					
        			}
        				
        			item5.setItemMeta(t5);
        				
        			cible.getPlayer().getInventory().setLeggings(item5);
        			
        			if(!main.getCD().contains(Pouvoirs.CAPTAIN_REPAIR)) {
            			
	        			main.getCD().add(Pouvoirs.CAPTAIN_REPAIR);
	        			joueur.setRepairCaptain(0);
	        			
        			}
        			
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		case DIAMOND_LEGGINGS:
        			
        			ItemStack armure3 = cible.getPlayer().getInventory().getLeggings();
        			
        			ItemStack item6 = new ItemStack(Material.DIAMOND_LEGGINGS);
    				
        			ItemMeta t6 = item6.getItemMeta();
        			if(armure3.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
        					
        				t6.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, armure3.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL), false);
        					
        			}
        			if(armure3.containsEnchantment(Enchantment.OXYGEN)) {
        					
        				t6.addEnchant(Enchantment.OXYGEN, armure3.getEnchantmentLevel(Enchantment.OXYGEN), false);
        					
        			}
        			if(armure3.containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS)) {
        					
        				t6.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, armure3.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS), false);
        					
        			}
        			if(armure3.containsEnchantment(Enchantment.PROTECTION_FALL)) {
        					
        				t6.addEnchant(Enchantment.PROTECTION_FALL, armure3.getEnchantmentLevel(Enchantment.PROTECTION_FALL), false);
        					
        			}
        			if(armure3.containsEnchantment(Enchantment.PROTECTION_FIRE)) {
        					
        				t6.addEnchant(Enchantment.PROTECTION_FIRE, armure3.getEnchantmentLevel(Enchantment.PROTECTION_FIRE), false);
        					
        			}
        			if(armure3.containsEnchantment(Enchantment.PROTECTION_PROJECTILE)) {
        					
        				t6.addEnchant(Enchantment.PROTECTION_PROJECTILE, armure3.getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE), false);
        					
        			}
        			if(armure3.containsEnchantment(Enchantment.DURABILITY)) {
        					
        				t6.addEnchant(Enchantment.DURABILITY, armure3.getEnchantmentLevel(Enchantment.DURABILITY), false);
        					
        			}
        			if(armure3.containsEnchantment(Enchantment.THORNS)) {
        					
        				t6.addEnchant(Enchantment.THORNS, armure3.getEnchantmentLevel(Enchantment.THORNS), false);
        					
        			}
        			if(armure3.containsEnchantment(Enchantment.WATER_WORKER)) {
        					
        				t6.addEnchant(Enchantment.WATER_WORKER, armure3.getEnchantmentLevel(Enchantment.WATER_WORKER), false);
        					
        			}
        			if(armure3.containsEnchantment(Enchantment.DEPTH_STRIDER)) {
        					
        				t6.addEnchant(Enchantment.DEPTH_STRIDER, armure3.getEnchantmentLevel(Enchantment.DEPTH_STRIDER), false);
        					
        			}
        				
        			item6.setItemMeta(t6);
        				
        			cible.getPlayer().getInventory().setLeggings(item6);
        			
        			if(!main.getCD().contains(Pouvoirs.CAPTAIN_REPAIR)) {
            			
	        			main.getCD().add(Pouvoirs.CAPTAIN_REPAIR);
	        			joueur.setRepairCaptain(0);
	        			
        			}
        			
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		case IRON_BOOTS:
        			
        			ItemStack armure4 = cible.getPlayer().getInventory().getBoots();
        			
        			ItemStack item7 = new ItemStack(Material.IRON_BOOTS);
    				
        			ItemMeta t7 = item7.getItemMeta();
        			if(armure4.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
        					
        				t7.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, armure4.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL), false);
        					
        			}
        			if(armure4.containsEnchantment(Enchantment.OXYGEN)) {
        					
        				t7.addEnchant(Enchantment.OXYGEN, armure4.getEnchantmentLevel(Enchantment.OXYGEN), false);
        					
        			}
        			if(armure4.containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS)) {
        					
        				t7.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, armure4.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS), false);
        					
        			}
        			if(armure4.containsEnchantment(Enchantment.PROTECTION_FALL)) {
        					
        				t7.addEnchant(Enchantment.PROTECTION_FALL, armure4.getEnchantmentLevel(Enchantment.PROTECTION_FALL), false);
        					
        			}
        			if(armure4.containsEnchantment(Enchantment.PROTECTION_FIRE)) {
        					
        				t7.addEnchant(Enchantment.PROTECTION_FIRE, armure4.getEnchantmentLevel(Enchantment.PROTECTION_FIRE), false);
        					
        			}
        			if(armure4.containsEnchantment(Enchantment.PROTECTION_PROJECTILE)) {
        					
        				t7.addEnchant(Enchantment.PROTECTION_PROJECTILE, armure4.getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE), false);
        					
        			}
        			if(armure4.containsEnchantment(Enchantment.DURABILITY)) {
        					
        				t7.addEnchant(Enchantment.DURABILITY, armure4.getEnchantmentLevel(Enchantment.DURABILITY), false);
        					
        			}
        			if(armure4.containsEnchantment(Enchantment.THORNS)) {
        					
        				t7.addEnchant(Enchantment.THORNS, armure4.getEnchantmentLevel(Enchantment.THORNS), false);
        					
        			}
        			if(armure4.containsEnchantment(Enchantment.WATER_WORKER)) {
        					
        				t7.addEnchant(Enchantment.WATER_WORKER, armure4.getEnchantmentLevel(Enchantment.WATER_WORKER), false);
        					
        			}
        			if(armure4.containsEnchantment(Enchantment.DEPTH_STRIDER)) {
        					
        				t7.addEnchant(Enchantment.DEPTH_STRIDER, armure4.getEnchantmentLevel(Enchantment.DEPTH_STRIDER), false);
        					
        			}
        				
        			item7.setItemMeta(t7);
        				
        			cible.getPlayer().getInventory().setBoots(item7);
        			
        			if(!main.getCD().contains(Pouvoirs.CAPTAIN_REPAIR)) {
            			
	        			main.getCD().add(Pouvoirs.CAPTAIN_REPAIR);
	        			joueur.setRepairCaptain(0);
	        			
        			}
        			
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		case DIAMOND_BOOTS:
        			
        			ItemStack armure5 = cible.getPlayer().getInventory().getBoots();
        			
        			ItemStack item8 = new ItemStack(Material.DIAMOND_BOOTS);
    				
        			ItemMeta t8 = item8.getItemMeta();
        			if(armure5.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
        					
        				t8.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, armure5.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL), false);
        					
        			}
        			if(armure5.containsEnchantment(Enchantment.OXYGEN)) {
        					
        				t8.addEnchant(Enchantment.OXYGEN, armure5.getEnchantmentLevel(Enchantment.OXYGEN), false);
        					
        			}
        			if(armure5.containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS)) {
        					
        				t8.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, armure5.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS), false);
        					
        			}
        			if(armure5.containsEnchantment(Enchantment.PROTECTION_FALL)) {
        					
        				t8.addEnchant(Enchantment.PROTECTION_FALL, armure5.getEnchantmentLevel(Enchantment.PROTECTION_FALL), false);
        					
        			}
        			if(armure5.containsEnchantment(Enchantment.PROTECTION_FIRE)) {
        					
        				t8.addEnchant(Enchantment.PROTECTION_FIRE, armure5.getEnchantmentLevel(Enchantment.PROTECTION_FIRE), false);
        					
        			}
        			if(armure5.containsEnchantment(Enchantment.PROTECTION_PROJECTILE)) {
        					
        				t8.addEnchant(Enchantment.PROTECTION_PROJECTILE, armure5.getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE), false);
        					
        			}
        			if(armure5.containsEnchantment(Enchantment.DURABILITY)) {
        					
        				t8.addEnchant(Enchantment.DURABILITY, armure5.getEnchantmentLevel(Enchantment.DURABILITY), false);
        					
        			}
        			if(armure5.containsEnchantment(Enchantment.THORNS)) {
        					
        				t8.addEnchant(Enchantment.THORNS, armure5.getEnchantmentLevel(Enchantment.THORNS), false);
        					
        			}
        			if(armure5.containsEnchantment(Enchantment.WATER_WORKER)) {
        					
        				t8.addEnchant(Enchantment.WATER_WORKER, armure5.getEnchantmentLevel(Enchantment.WATER_WORKER), false);
        					
        			}
        			if(armure5.containsEnchantment(Enchantment.DEPTH_STRIDER)) {
        					
        				t8.addEnchant(Enchantment.DEPTH_STRIDER, armure5.getEnchantmentLevel(Enchantment.DEPTH_STRIDER), false);
        					
        			}
        				
        			item8.setItemMeta(t8);
        				
        			cible.getPlayer().getInventory().setBoots(item8);
        			
        			if(!main.getCD().contains(Pouvoirs.CAPTAIN_REPAIR)) {
            			
	        			main.getCD().add(Pouvoirs.CAPTAIN_REPAIR);
	        			joueur.setRepairCaptain(0);
	        			
        			}
        			
        			joueur.getPlayer().closeInventory();
        			
        			break;
        	
        		default: break;
        			
        	}
        	
        } else if(inv.getName().startsWith("§8Enchantement")) {
        	
        	String[] pseudos = inv.getName().split(" ");
        	String pseudo = pseudos[1];
        	event.setCancelled(true);
        	Joueur cible = main.getJoueurByPseudo(pseudo);
        	Joueur joueur = main.getJoueur(player);
        	
        	switch (current.getType()) {
        	
        		case IRON_HELMET:
        			
        			joueur.getPlayer().closeInventory();
        				
        			Inventory inv_ = Bukkit.createInventory(null, 27, "§8Enchant casque " + cible.getPlayer().getName());
        	    	
        	        inv_.setItem(12, Main.getItem(Material.IRON_BLOCK, "Protection", "Clique droit : Ajouter 1 niveau;Clique gauche : Retirer 1 niveau"));
        	        inv_.setItem(13, Main.getItem(Material.IRON_SWORD, "Thorns", "Ajouter 1 niveau"));
        	        inv_.setItem(14, Main.getItem(Material.OBSIDIAN, "Unbreaking", "Clique droit : Ajouter 2 niveaux;Clique gauche : Retirer 2 niveaux"));

        	        joueur.getPlayer().openInventory(inv_);
        			
        			break;
        			
        		case DIAMOND_HELMET:
        			
        			joueur.getPlayer().closeInventory();
        			
        			Inventory inv1 = Bukkit.createInventory(null, 27, "§8Enchant casque " + cible.getPlayer().getName());
        	    	
        	        inv1.setItem(12, Main.getItem(Material.IRON_BLOCK, "Protection", "Clique droit : Ajouter 1 niveau;Clique gauche : Retirer 1 niveau"));
        	        inv1.setItem(13, Main.getItem(Material.IRON_SWORD, "Thorns", "Ajouter 1 niveau"));
        	        inv1.setItem(14, Main.getItem(Material.OBSIDIAN, "Unbreaking", "Clique droit : Ajouter 2 niveaux;Clique gauche : Retirer 2 niveaux"));

        	        joueur.getPlayer().openInventory(inv1);
        			
        			break;
        			
        		case IRON_CHESTPLATE:
        			
        			joueur.getPlayer().closeInventory();
        			
        			Inventory inv2 = Bukkit.createInventory(null, 27, "§8Enchant plastron " + cible.getPlayer().getName());
        	    	
        	        inv2.setItem(12, Main.getItem(Material.IRON_BLOCK, "Protection", "Clique droit : Ajouter 1 niveau;Clique gauche : Retirer 1 niveau"));
        	        inv2.setItem(13, Main.getItem(Material.IRON_SWORD, "Thorns", "Ajouter 1 niveau"));
        	        inv2.setItem(14, Main.getItem(Material.OBSIDIAN, "Unbreaking", "Clique droit : Ajouter 2 niveaux;Clique gauche : Retirer 2 niveaux"));

        	        joueur.getPlayer().openInventory(inv2);
        			
        			break;
        			
        		case DIAMOND_CHESTPLATE:
        			
        			joueur.getPlayer().closeInventory();
        			
        			Inventory inv3 = Bukkit.createInventory(null, 27, "§8Enchant plastron " + cible.getPlayer().getName());
        	    	
        	        inv3.setItem(12, Main.getItem(Material.IRON_BLOCK, "Protection", "Clique droit : Ajouter 1 niveau;Clique gauche : Retirer 1 niveau"));
        	        inv3.setItem(13, Main.getItem(Material.IRON_SWORD, "Thorns", "Ajouter 1 niveau"));
        	        inv3.setItem(14, Main.getItem(Material.OBSIDIAN, "Unbreaking", "Clique droit : Ajouter 2 niveaux;Clique gauche : Retirer 2 niveaux"));

        	        joueur.getPlayer().openInventory(inv3);
        			
        			break;
        			
        		case IRON_LEGGINGS:
        			
        			joueur.getPlayer().closeInventory();
        			
        			Inventory inv4 = Bukkit.createInventory(null, 27, "§8Enchant jambières " + cible.getPlayer().getName());
        	    	
        	        inv4.setItem(12, Main.getItem(Material.IRON_BLOCK, "Protection", "Clique droit : Ajouter 1 niveau;Clique gauche : Retirer 1 niveau"));
        	        inv4.setItem(13, Main.getItem(Material.IRON_SWORD, "Thorns", "Ajouter 1 niveau"));
        	        inv4.setItem(14, Main.getItem(Material.OBSIDIAN, "Unbreaking", "Clique droit : Ajouter 2 niveaux;Clique gauche : Retirer 2 niveaux"));

        	        joueur.getPlayer().openInventory(inv4);
        			
        			break;
        			
        		case DIAMOND_LEGGINGS:
        			
        			joueur.getPlayer().closeInventory();
        			
        			Inventory inv5 = Bukkit.createInventory(null, 27, "§8Enchant jambières " + cible.getPlayer().getName());
        	    	
        	        inv5.setItem(12, Main.getItem(Material.IRON_BLOCK, "Protection", "Clique droit : Ajouter 1 niveau;Clique gauche : Retirer 1 niveau"));
        	        inv5.setItem(13, Main.getItem(Material.IRON_SWORD, "Thorns", "Ajouter 1 niveau"));
        	        inv5.setItem(14, Main.getItem(Material.OBSIDIAN, "Unbreaking", "Clique droit : Ajouter 2 niveaux;Clique gauche : Retirer 2 niveaux"));

        	        joueur.getPlayer().openInventory(inv5);
        			
        			break;
        			
        		case IRON_BOOTS:
        			
        			joueur.getPlayer().closeInventory();
        			
        			Inventory inv6 = Bukkit.createInventory(null, 27, "§8Enchant bottes " + cible.getPlayer().getName());
        	    	
        	        inv6.setItem(12, Main.getItem(Material.IRON_BLOCK, "Protection", "Clique droit : Ajouter 1 niveau;Clique gauche : Retirer 1 niveau"));
        	        inv6.setItem(13, Main.getItem(Material.IRON_SWORD, "Thorns", "Ajouter 1 niveau"));
        	        inv6.setItem(14, Main.getItem(Material.OBSIDIAN, "Unbreaking", "Clique droit : Ajouter 2 niveaux;Clique gauche : Retirer 2 niveaux"));

        	        joueur.getPlayer().openInventory(inv6);
        			
        			break;
        			
        		case DIAMOND_BOOTS:
        			
        			joueur.getPlayer().closeInventory();
        			
        			Inventory inv7 = Bukkit.createInventory(null, 27, "§8Enchant bottes " + cible.getPlayer().getName());
        	    	
        	        inv7.setItem(12, Main.getItem(Material.IRON_BLOCK, "Protection", "Clique droit : Ajouter 1 niveau;Clique gauche : Retirer 1 niveau"));
        	        inv7.setItem(13, Main.getItem(Material.IRON_SWORD, "Thorns", "Ajouter 1 niveau"));
        	        inv7.setItem(14, Main.getItem(Material.OBSIDIAN, "Unbreaking", "Clique droit : Ajouter 2 niveaux;Clique gauche : Retirer 2 niveaux"));

        	        joueur.getPlayer().openInventory(inv7);
        			
        			break;
        	
        		default: break;
        		
        	}
        	
        } else if(inv.getName().startsWith("§8Enchant ")) {
        	
        	String[] args = inv.getName().split(" ");
        	String pseudo = args[2];
        	String piece = args[1];
        	event.setCancelled(true);
        	Joueur cible = main.getJoueurByPseudo(pseudo);
        	Joueur joueur = main.getJoueur(player);
        	
        	if(piece.equalsIgnoreCase("casque")) {
        		
        		ItemStack armure = cible.getPlayer().getInventory().getHelmet();
        		
        		switch (current.getType()) {
        		
        			case IRON_BLOCK:
        				
        				if(event.getClick() == ClickType.RIGHT || event.getClick() == ClickType.SHIFT_RIGHT) {
        					
        					joueur.getPlayer().closeInventory();
        				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        int niv = niv_base + 1;
	        				
	                        armure.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        armure.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, niv);
	                        ItemCD cycle = new ItemCD(main, joueur, "protection_casque_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				else if(event.getClick() == ClickType.LEFT || event.getClick() == ClickType.SHIFT_LEFT) {
        					
        					joueur.getPlayer().closeInventory();
        				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        int niv = niv_base - 1;
	                        if(niv < 1) {
                            	niv = 0;
                            }
	        				
	                        armure.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        armure.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "protection_casque_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				
        				break;
        				
        			case IRON_SWORD:
        				
        				joueur.getPlayer().closeInventory();
        				
        				int niv_base_ = armure.getEnchantmentLevel(Enchantment.THORNS);
                        int niv_ = niv_base_ + 2;
        				
                        armure.removeEnchantment(Enchantment.THORNS);
                        armure.addEnchantment(Enchantment.THORNS, niv_);
                        
                        ItemCD cycle_ = new ItemCD(main, joueur, "thorns_casque_captain", 60, cible, null, null, niv_base_, null);
        	            cycle_.runTaskTimer(main, 0, 20);
        				
        				break;
        				
        			case OBSIDIAN:
        				
        				if(event.getClick() == ClickType.RIGHT || event.getClick() == ClickType.SHIFT_RIGHT) {
        					
        					joueur.getPlayer().closeInventory();
            				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.DURABILITY);
	                        int niv = niv_base + 2;
	        				
	                        armure.removeEnchantment(Enchantment.DURABILITY);
	                        armure.addEnchantment(Enchantment.DURABILITY, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "unbreaking_casque_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				else if(event.getClick() == ClickType.LEFT || event.getClick() == ClickType.SHIFT_LEFT) {
        					
        					joueur.getPlayer().closeInventory();
        				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.DURABILITY);
	                        int niv = niv_base - 2;
	                        if(niv < 1) {
                            	niv = 0;
                            }
	        				
	                        armure.removeEnchantment(Enchantment.DURABILITY);
	                        armure.addEnchantment(Enchantment.DURABILITY, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "unbreaking_casque_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				
        				break;
        				
        			default: break;
        		
        		}
        		
        	}
        	else if(piece.equalsIgnoreCase("plastron")) {
        		
        		ItemStack armure = cible.getPlayer().getInventory().getChestplate();
        		
        		switch (current.getType()) {
        		
        			case IRON_BLOCK:
        				
        				if(event.getClick() == ClickType.RIGHT || event.getClick() == ClickType.SHIFT_RIGHT) {
        				
        					joueur.getPlayer().closeInventory();
        					
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        int niv = niv_base + 1;
	        				
	                        armure.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        armure.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "protection_plastron_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				else if(event.getClick() == ClickType.LEFT || event.getClick() == ClickType.SHIFT_LEFT) {
        				
        					joueur.getPlayer().closeInventory();
        					
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        int niv = niv_base - 1;
	                        if(niv < 1) {
                            	niv = 0;
                            }
	        				
	                        armure.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        armure.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "protection_plastron_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				
        				break;
        				
        			case IRON_SWORD:
        				
        				joueur.getPlayer().closeInventory();
        				
        				int niv_base_ = armure.getEnchantmentLevel(Enchantment.THORNS);
                        int niv_ = niv_base_ + 2;
        				
                        armure.removeEnchantment(Enchantment.THORNS);
                        armure.addEnchantment(Enchantment.THORNS, niv_);
                        
                        ItemCD cycle_ = new ItemCD(main, joueur, "thorns_plastron_captain", 60, cible, null, null, niv_base_, null);
        	            cycle_.runTaskTimer(main, 0, 20);
        				
        				break;
        				
        			case OBSIDIAN:
        				
        				if(event.getClick() == ClickType.RIGHT || event.getClick() == ClickType.SHIFT_RIGHT) {
            				
        					joueur.getPlayer().closeInventory();
        					
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.DURABILITY);
	                        int niv = niv_base + 2;
	        				
	                        armure.removeEnchantment(Enchantment.DURABILITY);
	                        armure.addEnchantment(Enchantment.DURABILITY, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "unbreaking_plastron_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				else if(event.getClick() == ClickType.LEFT || event.getClick() == ClickType.SHIFT_LEFT) {
        				
        					joueur.getPlayer().closeInventory();
        					
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.DURABILITY);
	                        int niv = niv_base - 2;
	                        if(niv < 1) {
                            	niv = 0;
                            }
	        				
	                        armure.removeEnchantment(Enchantment.DURABILITY);
	                        armure.addEnchantment(Enchantment.DURABILITY, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "unbreaking_plastron_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				
        				break;
        				
        			default: break;
        		
        		}
        		
        	}
        	else if(piece.equalsIgnoreCase("jambières")) {
        		
        		ItemStack armure = cible.getPlayer().getInventory().getLeggings();
        		
        		switch (current.getType()) {
        		
        			case IRON_BLOCK:
        				
        				if(event.getClick() == ClickType.RIGHT || event.getClick() == ClickType.SHIFT_RIGHT) {
        					
        					joueur.getPlayer().closeInventory();
        				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        int niv = niv_base + 1;
	        				
	                        armure.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        armure.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "protection_jambieres_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				else if(event.getClick() == ClickType.LEFT || event.getClick() == ClickType.SHIFT_LEFT) {
        					
        					joueur.getPlayer().closeInventory();
        				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        int niv = niv_base - 1;
	                        if(niv < 1) {
                            	niv = 0;
                            }
	        				
	                        armure.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        armure.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "protection_jambieres_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				
        				break;
        				
        			case IRON_SWORD:
        				
        				joueur.getPlayer().closeInventory();
        				
        				int niv_base_ = armure.getEnchantmentLevel(Enchantment.THORNS);
                        int niv_ = niv_base_ + 2;
        				
                        armure.removeEnchantment(Enchantment.THORNS);
                        armure.addEnchantment(Enchantment.THORNS, niv_);
                        
                        ItemCD cycle_ = new ItemCD(main, joueur, "thorns_jambieres_captain", 60, cible, null, null, niv_base_, null);
        	            cycle_.runTaskTimer(main, 0, 20);
        				
        				break;
        				
        			case OBSIDIAN:
        				
        				if(event.getClick() == ClickType.RIGHT || event.getClick() == ClickType.SHIFT_RIGHT) {
        					
        					joueur.getPlayer().closeInventory();
            				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.DURABILITY);
	                        int niv = niv_base + 2;
	        				
	                        armure.removeEnchantment(Enchantment.DURABILITY);
	                        armure.addEnchantment(Enchantment.DURABILITY, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "unbreaking_jambieres_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				else if(event.getClick() == ClickType.LEFT || event.getClick() == ClickType.SHIFT_LEFT) {
        					
        					joueur.getPlayer().closeInventory();
        				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.DURABILITY);
	                        int niv = niv_base - 2;
	                        if(niv < 1) {
                            	niv = 0;
                            }
	        				
	                        armure.removeEnchantment(Enchantment.DURABILITY);
	                        armure.addEnchantment(Enchantment.DURABILITY, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "unbreaking_jambieres_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
        				}
        				
        				break;
        				
        			default: break;
        		
        		}
        		
        	}
        	else if(piece.equalsIgnoreCase("bottes")) {
        		
        		ItemStack armure = cible.getPlayer().getInventory().getBoots();
        		
        		switch (current.getType()) {
        		
	    			case IRON_BLOCK:
	    				
	    				if(event.getClick() == ClickType.RIGHT || event.getClick() == ClickType.SHIFT_RIGHT) {
	    					
	    					joueur.getPlayer().closeInventory();
	    				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        int niv = niv_base + 1;
	        				
	                        armure.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        armure.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "protection_bottes_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
	    				}
	    				else if(event.getClick() == ClickType.LEFT || event.getClick() == ClickType.SHIFT_LEFT) {
	    					
	    					joueur.getPlayer().closeInventory();
	    				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        int niv = niv_base - 1;
	                        if(niv < 1) {
	                        	niv = 0;
	                        }
	        				
	                        armure.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL);
	                        armure.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "protection_bottes_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
	    				}
	    				
	    				break;
	    				
	    			case IRON_SWORD:
	    				
	    				joueur.getPlayer().closeInventory();
	    				
	    				int niv_base_ = armure.getEnchantmentLevel(Enchantment.THORNS);
	                    int niv_ = niv_base_ + 2;
	    				
	                    armure.removeEnchantment(Enchantment.THORNS);
	                    armure.addEnchantment(Enchantment.THORNS, niv_);
	                    
	                    ItemCD cycle_ = new ItemCD(main, joueur, "thorns_bottes_captain", 60, cible, null, null, niv_base_, null);
	    	            cycle_.runTaskTimer(main, 0, 20);
	    				
	    				break;
	    				
	    			case OBSIDIAN:
	    				
	    				if(event.getClick() == ClickType.RIGHT || event.getClick() == ClickType.SHIFT_RIGHT) {
	    					
	    					joueur.getPlayer().closeInventory();
	        				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.DURABILITY);
	                        int niv = niv_base + 2;
	        				
	                        armure.removeEnchantment(Enchantment.DURABILITY);
	                        armure.addEnchantment(Enchantment.DURABILITY, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "unbreaking_bottes_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
	    				}
	    				else if(event.getClick() == ClickType.LEFT || event.getClick() == ClickType.SHIFT_LEFT) {
	    					
	    					joueur.getPlayer().closeInventory();
	    				
	        				int niv_base = armure.getEnchantmentLevel(Enchantment.DURABILITY);
	                        int niv = niv_base - 2;
	                        if(niv < 1) {
	                        	niv = 0;
	                        }
	        				
	                        armure.removeEnchantment(Enchantment.DURABILITY);
	                        armure.addEnchantment(Enchantment.DURABILITY, niv);
	                        
	                        ItemCD cycle = new ItemCD(main, joueur, "unbreaking_bottes_captain", 60, cible, null, null, niv_base, null);
	        	            cycle.runTaskTimer(main, 0, 20);
	        			
	    				}
	    				
	    				break;
	    				
	    			default: break;
	    		
	    		}
        		
        	}
        	
        } else if(inv.getName().equalsIgnoreCase("§8Shop")) {
        	
        	event.setCancelled(true);
        	Joueur joueur = main.getJoueur(player);
        	
        	if(main.getVersion() == 2) {
        	
	        	switch (current.getType()) {
	        	
	        		case GOLDEN_APPLE:
	        			
	        			if(joueur.getPoints() >= 1) {
	        				
	        				joueur.removePoints(1);
	        			
		        			ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 3);
		                    joueur.getPlayer().getInventory().addItem(gaps);
		        			joueur.getPlayer().closeInventory();
		        			
	        			}
	        			
	        			break;
	        			
	        		case BOOK:
	        			
	        			ItemStack book = new ItemStack(Material.BOOK, 1);
	                    ItemMeta bookM = book.getItemMeta();
	                    bookM.setDisplayName("Livre des morts");
	                    book.setItemMeta(bookM);
	                    
	                    //joueur.getPlayer().getInventory().addItem(book);
	        			
	        			break;
	        			
	        		case GLASS:
	        			
	        			if(joueur.getPoints() >= 2) {
	        				
	        				joueur.removePoints(2);
	        			
		        			ItemStack nuage = new ItemStack(Material.DIAMOND_SWORD, 1);
		                    ItemMeta nuageM = nuage.getItemMeta();
		                    nuageM.addEnchant(Enchantment.DAMAGE_ALL, 4, false);
		                    nuageM.setDisplayName("Nuage Flottant");
		                    nuage.setItemMeta(nuageM);
		                    joueur.getPlayer().getInventory().addItem(nuage);
		                    joueur.getPlayer().closeInventory();
	                    
	        			}
	        			else if(!joueur.isFirstItemToinou()) {
	        				
	        				joueur.setFirstItemToinou(true);
	        				
	        				ItemStack nuage = new ItemStack(Material.DIAMOND_SWORD, 1);
		                    ItemMeta nuageM = nuage.getItemMeta();
		                    nuageM.addEnchant(Enchantment.DAMAGE_ALL, 4, false);
		                    nuageM.setDisplayName("Nuage Flottant");
		                    nuage.setItemMeta(nuageM);
		                    joueur.getPlayer().getInventory().addItem(nuage);
		                    joueur.getPlayer().closeInventory();
	        				
	        			}
	        			
	        			break;
	        			
	        		case NETHERRACK:
	        			
	        			if(joueur.getPoints() >= 2) {
	        				
	        				joueur.removePoints(2);
	        			
		        			ItemStack maudit = new ItemStack(Material.DIAMOND_SWORD, 1);
		                    ItemMeta mauditM = maudit.getItemMeta();
		                    mauditM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
		                    mauditM.setDisplayName("Épée maudite");
		                    maudit.setItemMeta(mauditM);
		                    joueur.getPlayer().getInventory().addItem(maudit);
		                    joueur.getPlayer().closeInventory();
	                    
	        			}
	        			else if(!joueur.isFirstItemToinou()) {
	        				
	        				joueur.setFirstItemToinou(true);
	        				
		        			ItemStack maudit = new ItemStack(Material.DIAMOND_SWORD, 1);
		                    ItemMeta mauditM = maudit.getItemMeta();
		                    mauditM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
		                    mauditM.setDisplayName("Épée maudite");
		                    maudit.setItemMeta(mauditM);
		                    joueur.getPlayer().getInventory().addItem(maudit);
		                    joueur.getPlayer().closeInventory();
	        				
	        			}
	        			
	        			break;
	        			
	        		case SOUL_SAND:
	        			
	        			if(joueur.getPoints() >= 3) {
	        				
	        				joueur.removePoints(3);
	        				
		        			ItemStack ames = new ItemStack(Material.DIAMOND_SWORD, 1);
		                    ItemMeta amesM = ames.getItemMeta();
		                    amesM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
		                    amesM.setDisplayName("Épée des âmes");
		                    ames.setItemMeta(amesM);
		                    joueur.getPlayer().getInventory().addItem(ames);
		                    joueur.getPlayer().closeInventory();
		                    
	        			}
	        			
	        			break;
	        			
	        		case REDSTONE_BLOCK:
	        			
	        			break;
	        			
	        		default:
	        			break;
	        	
	        	}
	        	
        	}
        	else if(main.getVersion() == 1) {
        		
	        	switch (current.getType()) {
	        	
	        		case GOLDEN_APPLE:
	        			
	        			Ange.InteractGApple(joueur, main);
	        			
	        			break;
	        			
	        		case FEATHER:
	        			
	        			Ange.InteractFeather(joueur, main);
	        			
	        			break;
	        			
	        		case BLAZE_POWDER:
	        			
	        			Ange.InteractSword(joueur, main);
	        			
	        			break;
	        			
	        		case APPLE:
	        			
	        			Ange.InteractApple(joueur, main);
	        			
	        			break;
	        			
	        			
	        		default:
	        			break;
	        	
	        	}
        		
        	}
        	
        } else if(inv.getName().equalsIgnoreCase("§8Choix du pacte")) {
        	
        	event.setCancelled(true);
        	Joueur joueur = main.getJoueur(player);
        	
        	ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta coffreM = coffre.getItemMeta();
            coffreM.setDisplayName("Pactes");
            coffre.setItemMeta(coffreM);
        	
        	switch (current.getType()) {
        	
        		case APPLE:
        			
        			Slup.choixPacte1(joueur);
        			joueur.getPlayer().sendMessage("Vous avez choisi le pacte 1");
        			joueur.getPlayer().getInventory().remove(coffre);
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		case NETHERRACK:
        			
        			Slup.choixPacte2(joueur);
        			joueur.getPlayer().sendMessage("Vous avez choisi le pacte 2");
        			joueur.getPlayer().getInventory().remove(coffre);
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		default:
        			break;
        	
        	}
        	
        } else if(inv.getName().equalsIgnoreCase("§8Choix de la classe")) {
        	
        	event.setCancelled(true);
        	Joueur joueur = main.getJoueur(player);
        	
        	switch (current.getType()) {
        	
        		case IRON_SWORD:
        			
        			GameBlack.CommandeClasse(joueur, Classe.ATTAQUANT, main);
        			break;
        			
        		case IRON_CHESTPLATE:
        			
        			GameBlack.CommandeClasse(joueur, Classe.DEFENSEUR, main);
        			break;
        			
        		case BOW:
        			
        			GameBlack.CommandeClasse(joueur, Classe.DISTANCE, main);
        			break;
        			
        		case FEATHER:
        			
        			GameBlack.CommandeClasse(joueur, Classe.RAPIDE, main);
        			break;
        			
        		case APPLE:
        			
        			GameBlack.CommandeClasse(joueur, Classe.SUPPORT, main);
        			break;
        			
        		case BARRIER:
        			
        			GameBlack.CommandeClasse(joueur, Classe.RIEN, main);
        			break;
        			
        		default: break;
        	
        	}
        	
        	
        } else if(inv.getName().equalsIgnoreCase("§8Choix de l'orbe")) {
        	
        	event.setCancelled(true);
        	Joueur joueur = main.getJoueur(player);
        	
        	switch (current.getType()) {
        	
        		case WATER_BUCKET:
        			
        			if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbePassifActif()) {
        				
        				Eau.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FEU && joueur.isOrbePassifActif()) {
        				
        				Feu.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.GLACE && joueur.isOrbePassifActif()) {
        				
        				Glace.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FOUDRE && joueur.isOrbePassifActif()) {
        				
        				Foudre.Passif(joueur, main, false);
        				
        			}
        			
        			Eau.Passif(joueur, main, true);
        			joueur.setOrbe(Orbe.EAU);
        			joueur.setStatutOrbe(false);
        			joueur.getPlayer().sendMessage("Vous avez choisi l'orbe d'eau");
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		case LAVA_BUCKET:
        			
        			if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbePassifActif()) {
        				
        				Eau.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FEU && joueur.isOrbePassifActif()) {
        				
        				Feu.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.GLACE && joueur.isOrbePassifActif()) {
        				
        				Glace.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FOUDRE && joueur.isOrbePassifActif()) {
        				
        				Foudre.Passif(joueur, main, false);
        				
        			}
        			
        			Feu.Passif(joueur, main, true);
        			joueur.setOrbe(Orbe.FEU);
        			joueur.setStatutOrbe(false);
        			joueur.getPlayer().sendMessage("Vous avez choisi l'orbe de feu");
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		case REDSTONE_BLOCK:
        			
        			if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbePassifActif()) {
        				
        				Eau.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FEU && joueur.isOrbePassifActif()) {
        				
        				Feu.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.GLACE && joueur.isOrbePassifActif()) {
        				
        				Glace.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FOUDRE && joueur.isOrbePassifActif()) {
        				
        				Foudre.Passif(joueur, main, false);
        				
        			}
        			
        			Foudre.Passif(joueur, main, true);
        			joueur.setOrbe(Orbe.FOUDRE);
        			joueur.setStatutOrbe(false);
        			joueur.getPlayer().sendMessage("Vous avez choisi l'orbe de foudre");
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		case ICE:
        			
        			if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbePassifActif()) {
        				
        				Eau.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FEU && joueur.isOrbePassifActif()) {
        				
        				Feu.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.GLACE && joueur.isOrbePassifActif()) {
        				
        				Glace.Passif(joueur, main, false);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FOUDRE && joueur.isOrbePassifActif()) {
        				
        				Foudre.Passif(joueur, main, false);
        				
        			}
        			
        			Glace.Passif(joueur, main, true);
        			joueur.setOrbe(Orbe.GLACE);
        			joueur.setStatutOrbe(false);
        			joueur.getPlayer().sendMessage("Vous avez choisi l'orbe de glace");
        			joueur.getPlayer().closeInventory();
        			
        			break;
        			
        		default:
        			break;
        	
        	}
        	
        } else if(inv.getName().equalsIgnoreCase("§8Création de la partie - Séléction version")) {
        	
        	event.setCancelled(true);
        	Joueur joueur = main.getJoueur(player);
        	
        	switch(current.getType()) {
        	
        		case NETHERRACK:
        			
        			if(main.getHostBase() == null) {
        				
        				main.setHostBase(joueur);
        				//main.setV2Actif(false);
        				
        			}
        			break;
        		
        		case GOLDEN_APPLE:
        			
        			if(main.getHostBase() == null) {
        				
        				//main.setV2Actif(true);
        				main.setHostBase(joueur);
        				player.closeInventory();
        				Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Création de la partie");
        				inv_pacte.setItem(11, Main.getItem(Material.SUGAR, "Rapide", "Le stuff est directement give au début de la partie. \nCertains rôles changent pour s'adapter à ce mode"));
    	                inv_pacte.setItem(15, Main.getItem(Material.DIAMOND_PICKAXE, "Normal", "C'est le mode de jeu de base avec du minage\net aucun changement de rôles"));
    	                player.openInventory(inv_pacte);
    	                
        			}
        			break;
        			
        		default: break;
        	
        	}
        	
        } else if(inv.getName().equalsIgnoreCase("§8Création de la partie - Version")) {
        	
        	event.setCancelled(true);
        	
        	switch(current.getType()) {
        	
        		case NETHERRACK:
        			
        			main.setVersion(1);
        			main.getCompo().clear();
        			main.getScenarios().clear();
	            	Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Création de la partie - Mode");
	            	inv_pacte.setItem(11, Main.getItem(Material.SUGAR, "Rapide", "Le stuff est directement give au début de la partie;et tous les joueurs sont téléporter au même endroit"));
	                inv_pacte.setItem(13, Main.getItem(Material.REDSTONE, "Meetup", "Le stuff est directement give au début de la partie.;Certains rôles changent pour s'adapter à ce mode"));
	                inv_pacte.setItem(15, Main.getItem(Material.DIAMOND_PICKAXE, "Normal", "C'est le mode de jeu de base avec du minage;et aucun changement de rôles"));
	
	                player.openInventory(inv_pacte);
	                
	                player.sendMessage("Vous avez choisi la V1");
        			
        			break;
        			
        		case DIAMOND_SWORD:
        			
        			main.setVersion(2);
        			main.getCompo().clear();
        			main.getScenarios().clear();
	            	Inventory inv_ = Bukkit.createInventory(null, 27, "§8Création de la partie - Mode");
	            	inv_.setItem(11, Main.getItem(Material.SUGAR, "Rapide", "Le stuff est directement give au début de la partie;et tous les joueurs sont téléporter au même endroit"));
	                inv_.setItem(13, Main.getItem(Material.REDSTONE, "Meetup", "Le stuff est directement give au début de la partie.;Certains rôles changent pour s'adapter à ce mode"));
	                inv_.setItem(15, Main.getItem(Material.DIAMOND_PICKAXE, "Normal", "C'est le mode de jeu de base avec du minage;et aucun changement de rôles"));
	
	                player.openInventory(inv_);
	                
	                player.sendMessage("Vous avez choisi la V2");
	                
	                break;
        			
        		default: break;
        	
        	}
        	
        } else if (inv.getName().equalsIgnoreCase("§8Création de la partie - Mode")) {

            event.setCancelled(true);
            Joueur joueur = main.getJoueur(player);

            switch (current.getType()) {

                case SUGAR:

                	if (main.getHostBase() == null) {
                		
                		main.setMode("rapide");
                		player.sendMessage("Vous avez selectionner le mode rapide");
                		System.out.println("Mode : " + main.getMode());
                		main.setHostBase(joueur);
                		player.getInventory().clear();
                		
                		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
                        ItemMeta coffreM = coffre.getItemMeta();
                        coffreM.setDisplayName("§8Paramètre de la partie");
                        coffre.setItemMeta(coffreM);
                        joueur.getPlayer().getInventory().addItem(coffre);
                        
                        joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
                		
                	}
                	else {
                		
                		player.sendMessage("Host : " + main.getHostBase());
                		
                	}
                	
                	player.closeInventory();

                    break;
                    
                case REDSTONE:
                	
                	if (main.getHostBase() == null) {
                		
                		main.setMode("meetup");
                		player.sendMessage("Vous avez selectionner le mode meetup");
                		System.out.println("Mode : " + main.getMode());
                		main.setHostBase(joueur);
                		player.getInventory().clear();
                		
                		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
                        ItemMeta coffreM = coffre.getItemMeta();
                        coffreM.setDisplayName("§8Paramètre de la partie");
                        coffre.setItemMeta(coffreM);
                        joueur.getPlayer().getInventory().addItem(coffre);
                        
                        joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
                		
                	}
                	else {
                		
                		player.sendMessage("Host : " + main.getHostBase());
                		
                	}
                	
                	player.closeInventory();
                	
                	break;

                case DIAMOND_PICKAXE:

                	if (main.getHostBase() == null) {
                		
                		main.setMode("normal");
                		player.sendMessage("Vous avez selectionner le mode normal");
                		System.out.println("Mode : " + main.getMode());
                		main.setHostBase(joueur);
                		player.getInventory().clear();
                		
                		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
                        ItemMeta coffreM = coffre.getItemMeta();
                        coffreM.setDisplayName("§8Paramètre de la partie");
                        coffre.setItemMeta(coffreM);
                        joueur.getPlayer().getInventory().addItem(coffre);
                        
                        joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
                		
                	}
                	
                	player.closeInventory();

                    break;

                default:
                    break;

            }

        } else if (inv.getName().equalsIgnoreCase("§8Choix du mode de jeu")) {

            event.setCancelled(true);

            switch (current.getType()) {

                case SUGAR:
                		
                	main.setMode("rapide");
                	player.sendMessage("Vous avez selectionner le mode rapide");
                	
                	player.closeInventory();

                    break;
                    
                case REDSTONE:
                		
                	main.setMode("meetup");
                	player.sendMessage("Vous avez selectionner le mode meetup");
                	
                	break;

                case DIAMOND_PICKAXE:

                	main.setMode("normal");
                	player.sendMessage("Vous avez selectionner le mode normal");

                    break;

                default:
                    break;

            }

        } else if (inv.getName().equalsIgnoreCase("§8Gestion Compo")) {

            event.setCancelled(true);

            if(main.getVersion() == 2) {
            
            	CompoV2.interactCompo(current, player, main, true);
            	
            }
            else if(main.getVersion() == 1) {
            	
            	CompoV1.interactCompo(current, player, main, true);
            	
            }

        } else if(inv.getName().equalsIgnoreCase("§8Choix du mode")) {
        	
        	event.setCancelled(true);
        	
        	switch(current.getType()) {
        	
        		case DIAMOND_PICKAXE:
        			
	            	Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Choix du mode de jeu");
	            	inv_pacte.setItem(11, Main.getItem(Material.SUGAR, "Rapide", "Le stuff est directement give au début de la partie;et tous les joueurs sont téléporter au même endroit"));
	                inv_pacte.setItem(13, Main.getItem(Material.REDSTONE, "Meetup", "Le stuff est directement give au début de la partie.;Certains rôles changent pour s'adapter à ce mode"));
	                inv_pacte.setItem(15, Main.getItem(Material.DIAMOND_PICKAXE, "Normal", "C'est le mode de jeu de base avec du minage;et aucun changement de rôles"));
	
	                player.openInventory(inv_pacte);
	                
	                break;
	                
        		case GOLDEN_APPLE:
        			
	            	Inventory inv_ = Bukkit.createInventory(null, 27, "§8Choix de la version");
	            	inv_.setItem(12, Main.getItem(Material.NETHERRACK, "RC UHC V1", ""));
	                inv_.setItem(14, Main.getItem(Material.DIAMOND_SWORD, "RC UHC V2", ""));
	                
	                player.openInventory(inv_);
                	
                	break;
                	
                default: break;
        	
        	}
        	
        } else if(inv.getName().equalsIgnoreCase("§8Choix de la version")) {
        	
        	event.setCancelled(true);
        	
        	switch(current.getType()) {
        	
        		case NETHERRACK:
        			
        			main.setVersion(1);
        			main.getCompo().clear();
        			main.getScenarios().clear();
        			
        			break;
        			
        		case DIAMOND_SWORD:
        			
        			main.setVersion(2);
        			main.getCompo().clear();
        			main.getScenarios().clear();
        			
        		default: break;
        	
        	}
        	
        } else if(inv.getName().equalsIgnoreCase("§8Paramètre de la partie")) {
        	
            event.setCancelled(true);

            switch (current.getType()) {

                case DIAMOND_PICKAXE:
                	
	            	Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Choix du mode");
	            	inv_pacte.setItem(12, Main.getItem(Material.DIAMOND_PICKAXE, "Choix du mode de jeu", ""));
	                inv_pacte.setItem(14, Main.getItem(Material.GOLDEN_APPLE, "Choix de la version", ""));
	                
	                player.openInventory(inv_pacte);
                	
                	break;
                	
                case COMMAND:
                	
                	Inventory inv_scen = Bukkit.createInventory(null, 27, "§8Choix des scénarios");
                	int slot_ = 0;
                	
                	for(Scenarios s : Scenarios.values()) {
                	
	                    ItemStack item = new ItemStack(s.getItem(), 1);
	                    
	                    if(!main.getScenarios().contains(s)) {
	                    	
	                    	item.setAmount(0);
	                    	
	                    }
	                    
	                    ItemMeta itemM = item.getItemMeta();
	                    itemM.setDisplayName(s.getNom());
	                    itemM.setLore(Arrays.asList(s.getDescription().split(";")));
	                    item.setItemMeta(itemM);
	                	
		            	inv_scen.setItem(slot_, item);
		            	slot_ ++;
		            	
                	}
	
	                player.openInventory(inv_scen);
                	
                	break;
                	
                case DIAMOND_SWORD:
                	
                	if(main.getVersion() == 1) {
                		
                		CompoV1.getCompoRC(player, main, true);
                		
                	}
                	else if(main.getVersion() == 2) {
                		
                		CompoV2.getCompoJoueur(player, main, true);
                		
                	}
                	
                	break;
                	
                default:
                    break;

            }
        	
        } else if(inv.getName().equalsIgnoreCase("§8Choix des scénarios")) {
        	
        	event.setCancelled(true);
        	for(Scenarios s : Scenarios.values()) {
        		
        		if(s.getItem() == current.getType() && s.getNom() == current.getItemMeta().getDisplayName()) {
        			
        			if(main.getScenarios().contains(s)) {
        				
        				main.getScenarios().remove(s);
        				
        			}
        			else {
        				
        				main.getScenarios().add(s);
        				
        			}
        			
        		}
        		
        	}
        	
        	player.closeInventory();
        	
        	Inventory inv_scen = Bukkit.createInventory(null, 27, "§8Choix des scénarios");
        	int slot = 0;
        	
        	for(Scenarios s : Scenarios.values()) {
        	
                ItemStack item = new ItemStack(s.getItem(), 1);
                
                if(!main.getScenarios().contains(s)) {
                	
                	item.setAmount(0);
                	
                }
                
                ItemMeta itemM = item.getItemMeta();
                itemM.setDisplayName(s.getNom());
                itemM.setLore(Arrays.asList(s.getDescription().split(";")));
                item.setItemMeta(itemM);
            	
            	inv_scen.setItem(slot, item);
            	
            	slot++;
            	
        	}

            player.openInventory(inv_scen);        	
        	
        } else if(inv.getName().equalsIgnoreCase("§8Accès Super Bateau")) {
        	
            event.setCancelled(true);
            Joueur joueur = main.getJoueur(player);
            String[] args = current.getItemMeta().getDisplayName().split(" ");
            String pseudo = args[1];
            Joueur j = main.getJoueurByPseudo(pseudo);

            switch (current.getType()) {

                case SKULL_ITEM:

                	if(!main.getAccesBateauLoup().contains(j)) {
                	
	                	main.getAccesBateauLoup().add(j);
	                	joueur.getPlayer().sendMessage(pseudo + " a désormais accès à votre super bateau");
	                	player.closeInventory();
	                	Loup.menuAccesBateau(joueur, main);
	                	
                	}
                	else {
                		
                		main.getAccesBateauLoup().remove(j);
	                	joueur.getPlayer().sendMessage(pseudo + " n'a désormais plus accès à votre super bateau");
	                	player.closeInventory();
	                	Loup.menuAccesBateau(joueur, main);
                		
                	}
                	
                default:
                    break;

            }
        	
        }

    }

}
