package fr.gameblack.rubisuhc.roles.rc;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Eclaireur {

    public static void Items(Player player) {

        Texte(player);
        player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 5));

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes l'§aéclaireur\n§rVous devez gagner avec le §acamps rc§r\n \nA l'annonce des rôles, vous recevez §d5 pommes d'or§r\n \nVous avez la possibilité de devenir §9invisible §ren retirant votre armure mais vous obtenez l'effet §9faiblesse I§r\n \n____________________________________________________");

    }

}
