package fr.gameblack.rcuhcv2.roles.v1.rc;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

public class Guerrier {

    public static void Items(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);
        joueur.addForce(main.getForceIBaseV1());
        player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 3, true);
        book.setItemMeta(meta);
        player.getInventory().addItem(book);

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §aguerrier\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet §9force I §rpermanent\n \nA l'annonce des rôles, vous recevez un §dlivre tranchant III §ret §d3 pommes d'or§r\n \n____________________________________________________");

    }

}