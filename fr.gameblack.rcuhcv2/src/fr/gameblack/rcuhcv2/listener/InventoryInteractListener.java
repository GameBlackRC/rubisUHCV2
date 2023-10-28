package fr.gameblack.rcuhcv2.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Classe;
import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.orbes.Eau;
import fr.gameblack.rcuhcv2.orbes.Feu;
import fr.gameblack.rcuhcv2.orbes.Foudre;
import fr.gameblack.rcuhcv2.orbes.Glace;
import fr.gameblack.rcuhcv2.roles.joueur.Slup;
import fr.gameblack.rcuhcv2.roles.staff.GameBlack;

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

        } else if(inv.getName().equalsIgnoreCase("§8Shop")) {
        	
        	event.setCancelled(true);
        	Joueur joueur = main.getJoueur(player);
        	
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
	                    nuage.addEnchantment(Enchantment.DAMAGE_ALL, 4);
	                    nuageM.setDisplayName("Nuage Flottant");
	                    nuage.setItemMeta(nuageM);
	                    joueur.getPlayer().getInventory().addItem(nuage);
	                    joueur.getPlayer().closeInventory();
                    
        			}
        			else if(!joueur.isFirstItemToinou()) {
        				
        				joueur.setFirstItemToinou(true);
        				
        				ItemStack nuage = new ItemStack(Material.DIAMOND_SWORD, 1);
	                    ItemMeta nuageM = nuage.getItemMeta();
	                    nuage.addEnchantment(Enchantment.DAMAGE_ALL, 4);
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
	                    maudit.addEnchantment(Enchantment.DAMAGE_ALL, 3);
	                    mauditM.setDisplayName("Épée maudite");
	                    maudit.setItemMeta(mauditM);
	                    joueur.getPlayer().getInventory().addItem(maudit);
	                    joueur.getPlayer().closeInventory();
                    
        			}
        			else if(!joueur.isFirstItemToinou()) {
        				
        				joueur.setFirstItemToinou(true);
        				
	        			ItemStack maudit = new ItemStack(Material.DIAMOND_SWORD, 1);
	                    ItemMeta mauditM = maudit.getItemMeta();
	                    maudit.addEnchantment(Enchantment.DAMAGE_ALL, 3);
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
	                    ames.addEnchantment(Enchantment.DAMAGE_ALL, 3);
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

                	if (main.getHostBase() == null) {
                		
                		main.setMode("rapide");
                		player.sendMessage("Vous avez selectionner le mode rapide");
                		main.setHostBase(joueur);
                		
                	}
                	else {
                		
                		player.sendMessage("Host : " + main.getHostBase());
                		
                	}

                    break;
                    
                case REDSTONE:
                	
                	if (main.getHostBase() == null) {
                		
                		main.setMode("meetup");
                		player.sendMessage("Vous avez selectionner le mode meetup");
                		main.setHostBase(joueur);
                		
                	}
                	else {
                		
                		player.sendMessage("Host : " + main.getHostBase());
                		
                	}

                case DIAMOND_PICKAXE:

                	if (main.getHostBase() == null) {
                		
                		main.setMode("normal");
                		player.sendMessage("Vous avez selectionner le mode normal");
                		main.setHostBase(joueur);
                		
                	}

                    break;

                default:
                    break;

            }

        }

    }

}
