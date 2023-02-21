package fr.gameblack.rubisuhc.roles.rc;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.task.ItemCD;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Loup {

    public static void Items(Player player) {

        Texte(player);
        ItemStack dragon = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta dragonM = dragon.getItemMeta();
        dragonM.setDisplayName("Transformation");
        dragon.setItemMeta(dragonM);
        player.getInventory().addItem(dragon);

    }

    public static void InteractLoup(Player player, Main main) {

        if (!main.getCD().contains(Pouvoirs.LOUP_TRANSFO)) {

            main.getCD().add(Pouvoirs.LOUP_TRANSFO);
            main.setLoupPouvoir(true);

            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 0, false, false));
            ItemCD cycle = new ItemCD(main, player, "loup", 120, player, null, null);
            cycle.runTaskTimer(main, 0, 20);
            if (main.getRoles().contains(Roles.SLUP)) {

                Player slup = main.getPlayerByRole(Roles.SLUP);

                slup.sendMessage("Loup a utilisé son item 'Transformation'");

            }

        } else {

            player.sendMessage("Vous avez déjà utiliser ce pouvoir durant cet épisode");

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aLoup\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet force I la nuit\n \nA l'annonce des rôles, vous recevez un item nommé 'Transformation' vous permettant de vous transformer en loup pendant 2 minutes (utilisable une fois par épisode). Votre transformation vous donne speed II et force I mais à la fin de la transformation, vous recevrez l'effet faiblesse I pendant 3 minutes\n \nPour chaque kill effectuer, vous recevrez 5% de speed supplémentaire (pour un maximum de 25%)\n \n____________________________________________________");

    }

}
