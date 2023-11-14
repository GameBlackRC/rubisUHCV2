package fr.gameblack.rcuhcv2.roles.v1.rc;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RaptorV1 {

    public static void Items(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);
        ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Rage");
        coffre.setItemMeta(coffreM);
        player.getInventory().addItem(coffre);

    }

    public static void InteractRage(Joueur joueur, Main main) {

        if (!main.getCD().contains(Pouvoirs.RAPTOR_RAGE)) {

            main.getCD().add(Pouvoirs.RAPTOR_RAGE);

            if (main.getJoueurByRole(Roles.Slup) != null) {

                Joueur slup = main.getJoueurByRole(Roles.Slup);

                slup.getPlayer().sendMessage("Raptor a utilisé son item 'Rage'");

            }

            joueur.addForce(main.getForceIBaseV1());
            joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 0, false, false));
            ItemCD cycle = new ItemCD(main, joueur, "rage", 120, joueur, null, null, 0, null);
            cycle.runTaskTimer(main, 0, 20);

        } else {

            joueur.getPlayer().sendMessage("Vous avez déjà utiliser ce pouvoir durant cet épisode");

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aRaptor\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet résistance I de nuit\n \nA l'annonce des rôles, vous recevez un item nommé 'Rage' vous permettant de recevoir les effets force I et speed I pendant 2 minutes (cooldown de 12 minutes)\n \n____________________________________________________");

    }

}