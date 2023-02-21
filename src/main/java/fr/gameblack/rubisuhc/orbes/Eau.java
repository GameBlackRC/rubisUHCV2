package fr.gameblack.rubisuhc.orbes;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.task.ItemCD;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Eau {

    public static void Effets(Player player, Main main) {

        main.changeStatutOrbe(player, true);

        if (player.getInventory().getBoots().getType() != null) {

            ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
            epeeM.addEnchant(Enchantment.DEPTH_STRIDER, 2, false);
            ItemStack epee = player.getInventory().getBoots();
            epee.setItemMeta(epeeM);
            player.getInventory().setBoots(epee);

        }

    }

    public static void RemoveEffets(Player player, Main main) {

        main.changeStatutOrbe(player, false);

        if (player.getInventory().getBoots().getType() != null) {

            ItemMeta epeeM = player.getInventory().getBoots().getItemMeta();
            epeeM.removeEnchant(Enchantment.DEPTH_STRIDER);
            ItemStack epee = player.getInventory().getBoots();
            epee.setItemMeta(epeeM);
            player.getInventory().setBoots(epee);

        }

    }

    public static void Malus(Player player, Main main) {

        RemoveEffets(player, main);
        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1200, 0, false, false));
        main.setMalusOrbe(player, true);
        ItemCD cycle = new ItemCD(main, player, "eau_malus", 60, player, null, null);
        cycle.runTaskTimer(main, 0, 20);

    }

}
