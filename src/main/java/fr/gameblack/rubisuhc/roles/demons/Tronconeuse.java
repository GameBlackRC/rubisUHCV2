package fr.gameblack.rubisuhc.roles.demons;

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

public class Tronconeuse {

    public static void Items(Player player) {

        Texte(player);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));

    }

    public static void ItemsKillTrial(Player player, Main main) {

        main.addPourcentEffet(player, "speed", 0.1);
        player.setMaxHealth(player.getMaxHealth() + 6);

        ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Affuter ses lames");
        coffre.setItemMeta(coffreM);
        player.getInventory().addItem(coffre);

    }

    public static void InteractLame(Player player, Main main) {

        if (!main.getCD().contains(Pouvoirs.TRONCONEUSE_LAME)) {

            main.getCD().add(Pouvoirs.TRONCONEUSE_LAME);

            if (main.getRoles().contains(Roles.SLUP)) {

                Player slup = main.getPlayerByRole(Roles.SLUP);

                slup.sendMessage("Le démon Tronçoneuse a utilisé son item 'Affuter ses lames'");

            }

            main.addPourcentEffet(player, "force", 0.15);
            ItemCD cycle = new ItemCD(main, player, "speed_moins", 60, player, null, null);
            cycle.runTaskTimer(main, 0, 20);
            ItemCD cycle2 = new ItemCD(main, player, "speed_plus", 360, player, null, null);
            cycle2.runTaskTimer(main, 0, 20);

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Tronçoneuse\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet speed I permanent et force I la nuit\n \nA chaque coup, vous avez 5% de chance d'infliger un effet de saignement qui retire 0.5 coeur toutes les 2 secondes pendant 10 secondes\n \nSi Trial meurt, vous recevez 10% de speed permanent, gagnez 3 coeurs supplémentaires et recevez un item nommé 'Affuter ses lames' vous permettant de recevoir l'effet force II pendant 1 minute\nUne fois la minute passer, votre speed II devient speed I pendant 5 minutes\n \nA chaque kill du camps rc que vous faites, vous pourrez choisir de récupérer leur orbe 1 fois dans la partie\n \nVous connaissez Slup\n \n____________________________________________________");

    }

}
