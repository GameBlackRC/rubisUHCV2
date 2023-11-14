package fr.gameblack.rcuhcv2.roles.v1.rc;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MakaV1 {

    public static void Items(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();
    	joueur.setNofallPerma(true);

        Texte(player);
        ItemStack dragon = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta dragonM = dragon.getItemMeta();
        dragonM.setDisplayName("Furreur du dragon");
        dragon.setItemMeta(dragonM);
        player.getInventory().addItem(dragon);

    }

    public static void InteractDragon(Joueur joueur, Main main) {

        int slot = -1;
        int i = 0;
        
        Player player = joueur.getPlayer();

        if (main.getJoueurByRole(Roles.Slup) != null) {

            Joueur slup = main.getJoueurByRole(Roles.Slup);

            slup.getPlayer().sendMessage("Maka a utilisé son item 'Furreur du dragon'");

        }

        for (ItemStack itemStack : player.getInventory().getContents()) {

            if (itemStack != null) {
                if (itemStack.getType() == Material.DIAMOND_SWORD) {

                    slot = i;

                }

            }
            i += 1;

        }
        if (slot != -1) {

            ItemMeta epeeM = player.getInventory().getItem(slot).getItemMeta();
            if (joueur.isMakaRageActif()) {
                epeeM.removeEnchant(Enchantment.FIRE_ASPECT);
                player.sendMessage("Vous venez de désactiver votre pouvoir");
                joueur.setMakaRageActif(false);
            } else {
                epeeM.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
                player.sendMessage("Vous venez d'activer votre pouvoir");
                joueur.setMakaRageActif(true);
            }
            ItemStack epee = player.getInventory().getItem(slot);
            epee.setItemMeta(epeeM);

        }

    }

    public static void CommandDon(Joueur joueur, Joueur cible, Main main) {

        ItemCD cycle = new ItemCD(main, joueur, "don", 300, cible, null, null, 0, null);
        cycle.runTaskTimer(main, 0, 20);
        main.getCD().add(Pouvoirs.MAKA_DON);

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §aMaka\n§rVous devez gagner avec le §acamps rc§r\n \nVous avez les effets no fall permanent et speed I de jour\n \nSi Team vous connait, vous gagnez l'effet force I à coté de lui\n \nA l'annonce des rôles, vous recevez un item nommé 'Furreur du dragon' vous permettant d'enflammé votre épée et votre arc (si vos armes sont enflammé, les enchantements sont retirés)\n \n____________________________________________________");

    }

}