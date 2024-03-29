package fr.gameblack.rcuhcv2.roles.v2.uhc;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.ItRoles;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Malivol {

    public static void Items(Joueur joueur) {

    	Player player = joueur.getPlayer();
    	
        Texte(player);
        
		if(joueur.isBot()) {
			
			player.getInventory().setItem(8, Main.getItemRole(ItRoles.MALIVOL_CHEAT));
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Malivol");
			
		}
		else {
			
			player.getInventory().addItem(Main.getItemRole(ItRoles.MALIVOL_CHEAT));
			
		}

        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 0, false, false));
        joueur.addSpeed(0.05);

        if (player.getInventory().contains(Material.DIAMOND_PICKAXE)) {

            int slot = -1;
            int i = 0;

            for (ItemStack itemStack : player.getInventory().getContents()) {

                if (itemStack != null) {
                    if (itemStack.getType() == Material.DIAMOND_PICKAXE) {

                        slot = i;

                    }

                }
                i += 1;

            }
            if (slot != -1) {

                ItemMeta epeeM = player.getInventory().getItem(slot).getItemMeta();
                epeeM.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
                ItemStack epee = player.getInventory().getItem(slot);
                epee.setItemMeta(epeeM);

            }
            player.getInventory().addItem(new ItemStack(Material.DIAMOND, 3));

        } else {

            ItemStack pioche = new ItemStack(Material.DIAMOND_PICKAXE, 1);
            ItemMeta piocheM = pioche.getItemMeta();
            piocheM.addEnchant(Enchantment.DIG_SPEED, 3, false);
            piocheM.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
            pioche.setItemMeta(piocheM);
            player.getInventory().addItem(pioche);

        }

    }

    public static void InteractCheat(Joueur joueur, Main main, boolean pas_sacrifice) {
    	
    	Player player = joueur.getPlayer();

        if (!joueur.getCD().contains(Pouvoirs.MALIVOL_CHEAT)) {

            joueur.getCD().add(Pouvoirs.MALIVOL_CHEAT);

            Random r = new Random();
            int nb = r.nextInt(4);
            
            if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
				
				Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
				
	            nb = r.nextInt(100);
	            
	            if(nb <= 80) {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient d'utiliser un item");
	            	
	            }
	            else {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE]" + joueur.getPlayer().getName() + " vient d'utiliser un item");
	            	
	            }
				
			}

            if (nb == 1) {
            	
                joueur.setMalivolCheat(4);
                //plus de kb et plus de resi
                joueur.setAntiKB(true);
                player.sendMessage("Vous venez d'activer votre cheat anti-kb");
                if(pas_sacrifice) {
                	ItemCD cycle = new ItemCD(main, joueur, "antikb", 30, joueur, null, null, 0, null);
                	cycle.runTaskTimer(main, 0, 20);
                }
                else {
                	ItemCD cycle = new ItemCD(main, joueur, "antikb", 15, joueur, null, null, 0, null);
                	cycle.runTaskTimer(main, 0, 20);
                }
            } else if (nb == 2) {

                joueur.setMalivolCheat(2);
                player.sendMessage("Vous venez d'activer votre cheat nofall");
                joueur.addResi(0.03);
                joueur.setNofall(true);
                if(pas_sacrifice) {
                	ItemCD cycle = new ItemCD(main, joueur, "nofall", 60, joueur, null, null, 0, null);
                	cycle.runTaskTimer(main, 0, 20);
                }
                else {
                	ItemCD cycle = new ItemCD(main, joueur, "nofall", 30, joueur, null, null, 0, null);
                	cycle.runTaskTimer(main, 0, 20);
                }

            } else if (nb == 3) {
                joueur.setMalivolCheat(3);
                joueur.addForce(0.07);
                player.sendMessage("Vous venez d'activer votre cheat fullcrit");
                if(pas_sacrifice) {
                	ItemCD cycle = new ItemCD(main, joueur, "fullcrit", 30, joueur, null, null, 0, null);
                	cycle.runTaskTimer(main, 0, 20);
                }
                else {
                	ItemCD cycle = new ItemCD(main, joueur, "fullcrit", 30, joueur, null, null, 0, null);
                	cycle.runTaskTimer(main, 0, 20);
                }
            } else {
            	
            	joueur.setMalivolCheat(1);
                player.sendMessage("Vous venez d'activer votre cheat speedhack");
                joueur.addSpeed(0.15);
                if (player.getInventory().getBoots().getType() != null) {

                    ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
                    epeeM.addEnchant(Enchantment.DEPTH_STRIDER, 3, false);
                    ItemStack epee = player.getInventory().getBoots();
                    epee.setItemMeta(epeeM);
                    player.getInventory().setBoots(epee);

                }
                if(pas_sacrifice) {
                	ItemCD cycle = new ItemCD(main, joueur, "speedhack", 60, joueur, null, null, 0, null);
                	cycle.runTaskTimer(main, 0, 20);
                }
                else {
                	ItemCD cycle = new ItemCD(main, joueur, "speedhack", 30, joueur, null, null, 0, null);
                	cycle.runTaskTimer(main, 0, 20);
                }
            }

        } else {

            player.sendMessage("Vous avez déjà utiliser ce pouvoir durant cet épisode");

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §2Malivol\n§r"
        		+ "Vous devez gagner avec le §2camp UHC§r\n \n"
        		+ "Vous avez l'effet haste I ainsi que 5% de speed permanent\n \n"
        		+ "A l'annonce des rôles, vous recevez un item nommé 'Cheat' vous permettant d'activer un cheat parmis la liste suivante qui restent actif 1 minute :\n"
        		+ "- SpeedHack : vous recevez 15% de speed et depth strider III\n"
        		+ "- No fall : vous ne prenez plus de dégât de chute et vous recevez 3% de résistance supplémentaire\n"
        		+ "- Full crit (dure 30 secondes) : vous recevez 7% de force\n"
        		+ "- Anti KB (dure 30 secondes) : vous ne recevez plus de kb\n \n"
        		+ "A chaque spawn de minerais, vous avez 50% de chance de recevoir les coordonnées du minerais\n \n"
        		+ "____________________________________________________");

    }
	
}
