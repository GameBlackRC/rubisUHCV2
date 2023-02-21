package fr.gameblack.rubisuhc.roles.demons;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.task.ItemCD;

public class Malivol {

	public static void Items(Player player) {
		
		Texte(player);
		ItemStack coffre = new ItemStack(Material.NETHER_STAR,1);
		ItemMeta coffreM = coffre.getItemMeta();
		coffreM.setDisplayName("Cheat");
		coffre.setItemMeta(coffreM);
		
		player.getInventory().addItem(coffre);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
		player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 0, false, false));
		
		if(player.getInventory().contains(Material.DIAMOND_PICKAXE)) {
			
			int slot = -1;
			int i = 0;
				
			for (ItemStack itemStack : player.getInventory().getContents()) {
					
				if(itemStack != null) {
					if (itemStack.getType() == Material.DIAMOND_PICKAXE) {
							
						slot = i;
							
					}
				
				}
				i += 1;
					
			}
			if(slot != -1) {
					
				ItemMeta epeeM = player.getInventory().getItem(slot).getItemMeta();
				epeeM.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
				ItemStack epee = player.getInventory().getItem(slot);
				epee.setItemMeta(epeeM);
					
			}
			player.getInventory().addItem(new ItemStack(Material.DIAMOND,3));
			
		}
		else {
			
			ItemStack pioche = new ItemStack(Material.DIAMOND_PICKAXE,1);
			ItemMeta piocheM = pioche.getItemMeta();
			piocheM.addEnchant(Enchantment.DIG_SPEED, 3, false);
			piocheM.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, false);
			pioche.setItemMeta(piocheM);
			player.getInventory().addItem(pioche);
			
		}
		
	}
	
	public static void InteractCheat(Player player, Main main) {
		
		if(!main.getCD().contains(Pouvoirs.MALIVOL_CHEAT)) {
			
			main.getCD().add(Pouvoirs.MALIVOL_CHEAT);
			
			if(main.getRoles().contains(Roles.SLUP)) {
				
				Player slup = main.getPlayerByRole(Roles.SLUP);
				
				slup.sendMessage("Malivol a utilisé son item 'Cheat'");
				
			}
		
			Random r = new Random();
			int nb = r.nextInt(4);
			
			if(nb == 1) {
				main.setMalivolCheat(1);
				player.sendMessage("Vous venez d'activer votre cheat speedhack");
				player.removePotionEffect(PotionEffectType.SPEED);
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1, false, false));
				if(player.getInventory().getBoots().getType() != null) {
						
					ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
					epeeM.addEnchant(Enchantment.DEPTH_STRIDER, 3, false);
					ItemStack epee = player.getInventory().getBoots();
					epee.setItemMeta(epeeM);
					player.getInventory().setBoots(epee);
						
				}
				ItemCD cycle = new ItemCD(main, player, "speedhack", 60, player, null, null);
				cycle.runTaskTimer(main, 0, 20);
			}
			else if(nb == 2) {
				
				main.setMalivolCheat(2);
				player.sendMessage("Vous venez d'activer votre cheat nofall");
				main.addPourcentEffet(player, "resi", 0.05);
				ItemCD cycle = new ItemCD(main, player, "nofall", 60, player, null, null);
				cycle.runTaskTimer(main, 0, 20);
				
			}
			else if(nb == 3) {
				main.setMalivolCheat(3);
				main.addPourcentEffet(player, "force", 0.20);
				player.sendMessage("Vous venez d'activer votre cheat fullcrit");
				ItemCD cycle = new ItemCD(main, player, "fullcrit", 60, player, null, null);
				cycle.runTaskTimer(main, 0, 20);
			}
			else{
				main.setMalivolCheat(4);
				//plus de kb et plus de resi
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 0, false, false));
				player.sendMessage("Vous venez d'activer votre cheat anti-kb");
				ItemCD cycle = new ItemCD(main, player, "antikb", 60, player, null, null);
				cycle.runTaskTimer(main, 0, 20);
			}
			
		}
		else {
			
			player.sendMessage("Vous avez déjà utiliser ce pouvoir durant cet épisode");
			
		}
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes §cMalivol\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez les effets speed I et haste I permanent\n \nA l'annonce des rôles, vous recevez un item nommé 'Cheat' vous permettant d'activer un cheat parmis la liste suivante qui restent actif 1 minute :\n- SpeedHack : vous recevez l'effet speed II et depth strider III\n- No fall : vous ne prenez plus de dégât de chute et vous recevez 5% de résistance supplémentaire\n- Full crit : vous recevez l'effet force I\n- Anti KB : vous ne recevez plus de kb et vous recevez l'effet résistance I\n \nVous connaissez Trial\n \n____________________________________________________");
		
	}
	
}
