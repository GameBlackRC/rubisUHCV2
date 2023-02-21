package fr.gameblack.rubisuhc.roles.rc;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Archer {
	
	public static void Items(Player player) {
		
		Texte(player);
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 999999, 0, false, false));
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
		
		player.getInventory().addItem(new ItemStack(Material.ARROW,32));
		player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE,2));
		ItemStack book = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta)book.getItemMeta();
        meta.addStoredEnchant(Enchantment.ARROW_DAMAGE, 3, true);
        book.setItemMeta(meta);
        player.getInventory().addItem(book);
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes l'§aArcher\n§rVous devez gagner avec le §acamp rc§r\n \nVous avez les effets §9speed I §ret §9faiblesse I §rpermanent\n \nA l'annonce des rôles, vous recevez un §dlivre puissance III§r, §d32 flèches §ret §d2 pommes d'or§r\n \n____________________________________________________");
		
	}
	
}
