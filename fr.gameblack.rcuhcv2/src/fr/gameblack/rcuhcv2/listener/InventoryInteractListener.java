package fr.gameblack.rcuhcv2.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.orbes.Eau;
import fr.gameblack.rcuhcv2.orbes.Feu;
import fr.gameblack.rcuhcv2.orbes.Foudre;
import fr.gameblack.rcuhcv2.orbes.Glace;
import fr.gameblack.rcuhcv2.roles.joueur.Slup;

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

                    inv_pacte.setItem(18, Main.getItem(Material.REDSTONE_BLOCK, "§aRaptor", ""));
                    inv_pacte.setItem(19, Main.getItem(Material.DIAMOND_HOE, "§aJeannot", ""));
                    inv_pacte.setItem(20, Main.getItem(Material.PAPER, "§aNickoboop", ""));
                    inv_pacte.setItem(21, Main.getItem(Material.SLIME_BALL, "§aSlup", ""));
                    inv_pacte.setItem(22, Main.getItem(Material.QUARTZ_BLOCK, "§aJoko", ""));

                    player.openInventory(inv_pacte);

                    break;

                case COMMAND:

                	inv_pacte.setItem(1, Main.getItem(Material.DIAMOND_PICKAXE, "§aCamp Joueur", ""));
                    inv_pacte.setItem(3, Main.getItem(Material.COMMAND, "§9Camp Staff", ""));
                    inv_pacte.setItem(5, Main.getItem(Material.GOLDEN_APPLE, "§2Camp UHC", ""));
                    inv_pacte.setItem(7, Main.getItem(Material.GOLD_INGOT, "§6Solo", ""));

                    inv_pacte.setItem(18, Main.getItem(Material.GLASS, "§9Team", ""));
                    inv_pacte.setItem(19, Main.getItem(Material.COMMAND, "§9GameBlack", ""));
                    inv_pacte.setItem(20, Main.getItem(Material.RED_ROSE, "§9Maka", ""));
                    inv_pacte.setItem(21, Main.getItem(Material.NETHERRACK, "§9Trial", ""));
                    inv_pacte.setItem(22, Main.getItem(Material.QUARTZ_BLOCK, "§9Loup", ""));
                    inv_pacte.setItem(22, Main.getItem(Material.QUARTZ_BLOCK, "§9Captain", ""));
                    inv_pacte.setItem(22, Main.getItem(Material.QUARTZ_BLOCK, "§9Hekow", ""));

                    player.openInventory(inv_pacte);

                    break;

                case GOLD_INGOT:

                    inv_pacte.setItem(3, Main.getItem(Material.DIAMOND_BLOCK, "Camp RC", ""));
                    inv_pacte.setItem(4, Main.getItem(Material.NETHER_BRICK, "Camp Démon", ""));
                    inv_pacte.setItem(5, Main.getItem(Material.GOLD_INGOT, "Solo", ""));

                    inv_pacte.setItem(9, Main.getItem(Material.BREWING_STAND_ITEM, "Démon Expérimental", ""));
                    inv_pacte.setItem(10, Main.getItem(Material.GOLDEN_APPLE, "Farmeurimmo", ""));
                    inv_pacte.setItem(11, Main.getItem(Material.STICK, "Kzou", ""));

                    player.openInventory(inv_pacte);

                    break;

                default:
                    break;

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
        	
        } else if(inv.getName().equalsIgnoreCase("§8Choix de l'orbe")) {
        	
        	event.setCancelled(true);
        	Joueur joueur = main.getJoueur(player);
        	
        	switch (current.getType()) {
        	
        		case WATER_BUCKET:
        			
        			if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbeActif()) {
        				
        				Eau.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FEU && joueur.isOrbeActif()) {
        				
        				Feu.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.GLACE && joueur.isOrbeActif()) {
        				
        				Glace.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FOUDRE && joueur.isOrbeActif()) {
        				
        				Foudre.RemoveEffets(joueur, main);
        				
        			}
        			
        			joueur.setOrbe(Orbe.EAU);
        			joueur.setStatutOrbe(false);
        			joueur.getPlayer().sendMessage("Vous avez choisi l'orbe d'eau");
        			
        			break;
        			
        		case LAVA_BUCKET:
        			
        			if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbeActif()) {
        				
        				Eau.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FEU && joueur.isOrbeActif()) {
        				
        				Feu.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.GLACE && joueur.isOrbeActif()) {
        				
        				Glace.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FOUDRE && joueur.isOrbeActif()) {
        				
        				Foudre.RemoveEffets(joueur, main);
        				
        			}
        			
        			joueur.setOrbe(Orbe.FEU);
        			joueur.setStatutOrbe(false);
        			joueur.getPlayer().sendMessage("Vous avez choisi l'orbe de feu");
        			
        			break;
        			
        		case REDSTONE_BLOCK:
        			
        			if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbeActif()) {
        				
        				Eau.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FEU && joueur.isOrbeActif()) {
        				
        				Feu.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.GLACE && joueur.isOrbeActif()) {
        				
        				Glace.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FOUDRE && joueur.isOrbeActif()) {
        				
        				Foudre.RemoveEffets(joueur, main);
        				
        			}
        			
        			joueur.setOrbe(Orbe.FOUDRE);
        			joueur.setStatutOrbe(false);
        			joueur.getPlayer().sendMessage("Vous avez choisi l'orbe de foudre");
        			
        			break;
        			
        		case ICE:
        			
        			if(joueur.getOrbe() == Orbe.EAU && joueur.isOrbeActif()) {
        				
        				Eau.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FEU && joueur.isOrbeActif()) {
        				
        				Feu.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.GLACE && joueur.isOrbeActif()) {
        				
        				Glace.RemoveEffets(joueur, main);
        				
        			}
        			
        			if(joueur.getOrbe() == Orbe.FOUDRE && joueur.isOrbeActif()) {
        				
        				Foudre.RemoveEffets(joueur, main);
        				
        			}
        			
        			joueur.setOrbe(Orbe.GLACE);
        			joueur.setStatutOrbe(false);
        			joueur.getPlayer().sendMessage("Vous avez choisi l'orbe de glace");
        			
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
        				main.setV2Actif(false);
        				
        			}
        			break;
        		
        		case GOLDEN_APPLE:
        			
        			if(main.getHostBase() == null) {
        				
        				main.setV2Actif(true);
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
        	
        } else if (inv.getName().equalsIgnoreCase("§8Création de la partie")) {

            event.setCancelled(true);
            player.closeInventory();
            Joueur joueur = main.getJoueur(player);

            switch (current.getType()) {

                case SUGAR:

                	if (main.getHostBase() == joueur) {
                		
                		main.setMode("rapide");
                		player.sendMessage("Vous avez selectionner le mode rapide");
                		
                	}
                	else {
                		
                		player.sendMessage("Host : " + main.getHostBase());
                		
                	}

                    break;

                case DIAMOND_PICKAXE:

                	if (main.getHostBase() == joueur) {
                		
                		main.setMode("normal");
                		player.sendMessage("Vous avez selectionner le mode normal");
                		
                	}

                    break;

                default:
                    break;

            }

        }

    }

}
