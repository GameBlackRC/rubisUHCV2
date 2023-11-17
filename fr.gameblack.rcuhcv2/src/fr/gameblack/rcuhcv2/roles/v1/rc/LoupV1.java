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

public class LoupV1 {

    public static void Items(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);
        ItemStack dragon = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta dragonM = dragon.getItemMeta();
        dragonM.setDisplayName("Transformation");
        dragon.setItemMeta(dragonM);
        player.getInventory().addItem(dragon);

    }

    public static void InteractLoup(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();

        if (!joueur.getCD().contains(Pouvoirs.LOUP_TRANSFO)) {

            joueur.getCD().add(Pouvoirs.LOUP_TRANSFO);

            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1, false, false));
            joueur.addForce(main.getForceIBaseV1());
            joueur.setSpeedInt(100);
            ItemCD cycle = new ItemCD(main, joueur, "loup", 120, joueur, null, null, joueur.getSpeedInt(), null);
            cycle.runTaskTimer(main, 0, 20);
            if (main.getJoueurByRole(Roles.Slup) != null) {

                Joueur slup = main.getJoueurByRole(Roles.Slup);

                slup.getPlayer().sendMessage("Loup a utilisé son item 'Transformation'");

            }

        } else {

            player.sendMessage("Vous avez déjà utiliser ce pouvoir durant cet épisode");

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aLoup\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez l'effet force I la nuit\n \nA l'annonce des rôles, vous recevez un item nommé 'Transformation' vous permettant de vous transformer en loup pendant 2 minutes (utilisable une fois par épisode). Votre transformation vous donne speed II et force I mais à la fin de la transformation, vous recevrez l'effet faiblesse I pendant 3 minutes\n \nPour chaque kill effectuer, vous recevrez 5% de speed supplémentaire (pour un maximum de 25%)\n \n____________________________________________________");

    }

}