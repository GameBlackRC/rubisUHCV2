package fr.gameblack.rubisuhc.roles.rc;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;

public class Guerrier {

	public static void Items(Player player, Main main) {
		
		Texte(player);
		main.addPourcentEffet(player, "force", 0.15);
		player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE,3));
		ItemStack book = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta)book.getItemMeta();
        meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 3, true);
        book.setItemMeta(meta);
        player.getInventory().addItem(book);
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes le §aguerrier\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet §9force I §rpermanent\n \nA l'annonce des rôles, vous recevez un §dlivre tranchant III §ret §d3 pommes d'or§r\n \n____________________________________________________");
		
	}
	
}
