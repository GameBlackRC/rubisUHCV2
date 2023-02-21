package fr.gameblack.rubisuhc.roles.rc;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.task.ItemCD;

public class Raptor {

	public static void Items(Player player) {
		
		Texte(player);
		ItemStack coffre = new ItemStack(Material.NETHER_STAR,1);
		ItemMeta coffreM = coffre.getItemMeta();
		coffreM.setDisplayName("Rage");
		coffre.setItemMeta(coffreM);
		player.getInventory().addItem(coffre);
		
	}
	
	public static void InteractRage(Player player, Main main) {
		
		if(!main.getCD().contains(Pouvoirs.RAPTOR_RAGE)) {
			
			main.getCD().add(Pouvoirs.RAPTOR_RAGE);
		
			if(main.getRoles().contains(Roles.SLUP)) {
			
				Player slup = main.getPlayerByRole(Roles.SLUP);
			
				slup.sendMessage("Raptor a utilisé son item 'Rage'");
				
			}
			
			main.addPourcentEffet(player, "force", 0.15);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 0, false, false));
			ItemCD cycle = new ItemCD(main, player, "rage", 120, player, null, null);
			cycle.runTaskTimer(main, 0, 20);
			
		}
		else {
			
			player.sendMessage("Vous avez déjà utiliser ce pouvoir durant cet épisode");
			
		}
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes §aRaptor\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet résistance I de nuit\n \nA l'annonce des rôles, vous recevez un item nommé 'Rage' vous permettant de recevoir les effets force I et speed I pendant 2 minutes (cooldown de 12 minutes)\n \n____________________________________________________");
		
	}
	
}
