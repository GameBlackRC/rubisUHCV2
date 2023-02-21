package fr.gameblack.rubisuhc.roles.rc;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.task.ItemCD;

public class Maka {

	public static void Items(Player player) {
		
		Texte(player);
		ItemStack dragon = new ItemStack(Material.NETHER_STAR,1);
		ItemMeta dragonM = dragon.getItemMeta();
		dragonM.setDisplayName("Furreur du dragon");
		dragon.setItemMeta(dragonM);
		player.getInventory().addItem(dragon);
		
	}
	
	public static void InteractDragon(Player player, Main main) {
		
		int slot = -1;
		int i = 0;
		
		if(main.getRoles().contains(Roles.SLUP)) {
		
			Player slup = main.getPlayerByRole(Roles.SLUP);
			
			slup.sendMessage("Maka a utilisé son item 'Furreur du dragon'");
			
		}
			
		for (ItemStack itemStack : player.getInventory().getContents()) {
				
			if(itemStack != null) {
				if (itemStack.getType() == Material.DIAMOND_SWORD) {
						
					slot = i;
						
				}
			
			}
			i += 1;
				
		}
		if(slot != -1) {
				
			ItemMeta epeeM = player.getInventory().getItem(slot).getItemMeta();
			if(main.MakaRageActif()) {
				epeeM.removeEnchant(Enchantment.FIRE_ASPECT);
				player.sendMessage("Vous venez de désactiver votre pouvoir");
			}
			else {
				epeeM.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
				player.sendMessage("Vous venez d'activer votre pouvoir");
			}
			ItemStack epee = player.getInventory().getItem(slot);
			epee.setItemMeta(epeeM);
				
		}
		
		main.ChangeMakaRage();
		
	}
	
	public static void CommandDon(Player player, Player cible, Main main) {
		
		ItemCD cycle = new ItemCD(main, player, "don", 300, cible, null, null);
		cycle.runTaskTimer(main, 0, 20);
		main.getCD().add(Pouvoirs.MAKA_DON);
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes §aMaka\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez les effets no fall permanent et speed I de jour\n \nSi Team vous connait, vous gagnez l'effet force I à coté de lui\n \nA l'annonce des rôles, vous recevez un item nommé 'Furreur du dragon' vous permettant d'enflammé votre épée et votre arc (si vos armes sont enflammé, les enchantements sont retirés)\n \n____________________________________________________");
		
	}
	
}
