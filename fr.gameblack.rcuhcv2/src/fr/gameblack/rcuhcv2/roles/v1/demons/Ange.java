package fr.gameblack.rcuhcv2.roles.v1.demons;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Ange {

    public static void Items(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);

        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 0, false, false));
        joueur.addResi(0.15);

    }

    public static void InteractShop(Player player, Main main) {

        if (main.getJoueurByRole(Roles.Slup) != null) {

            Joueur slup = main.getJoueurByRole(Roles.Slup);

            slup.getPlayer().sendMessage("Le démon ange a utilisé son item 'Shop'");

        }

        Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Shop");
        inv_pacte.setItem(10, Main.getItem(Material.GOLDEN_APPLE, "Absorption", "En échange de 5 points, vous obtenez 2 coeurs d'absorption"));
        inv_pacte.setItem(12, Main.getItem(Material.FEATHER, "Speed", "En échange de 10 points, vous obtenez l'effet speed I pendant 5 minutes"));
        inv_pacte.setItem(14, Main.getItem(Material.BLAZE_POWDER, "Force", "En échange de 12 points, vous obtenez l'effet force I pendant 5 minutes"));
        inv_pacte.setItem(16, Main.getItem(Material.APPLE, "1 coeur permanent", "En échange de 15 points, vous obtenez 1 coeur permanent supplémentaire"));
        player.openInventory(inv_pacte);

    }

    public static void InteractGApple(Joueur joueur, Main main) {

        if (joueur.getPoints() >= 5) {

            joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 99999, 0, false, false));

            joueur.removePoints(5);

        } else {

            joueur.getPlayer().sendMessage("Vous n'avez pas assez de points");

        }

    }

    public static void InteractSword(Joueur joueur, Main main) {

        if (joueur.getPoints() >= 12) {

            joueur.addForce(main.getForceIBaseV1());
            ItemCD cycle = new ItemCD(main, joueur, "shopforce", 300, joueur, null, null, 0, null);
            cycle.runTaskTimer(main, 0, 20);

            joueur.removePoints(12);

        } else {

            joueur.getPlayer().sendMessage("Vous n'avez pas assez de points");

        }

    }

    public static void InteractFeather(Joueur joueur, Main main) {

        if (joueur.getPoints() >= 10) {

            joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6000, 0, false, false));

            joueur.removePoints(10);

        } else {

            joueur.getPlayer().sendMessage("Vous n'avez pas assez de points");

        }

    }

    public static void InteractApple(Joueur joueur, Main main) {

        if (joueur.getPoints() >= 15) {

            joueur.getPlayer().setMaxHealth(joueur.getPlayer().getMaxHealth() + 2);

            joueur.removePoints(15);

        } else {

            joueur.getPlayer().sendMessage("Vous n'avez pas assez de points");

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Ange\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet résistance I permanent\n \nA chaque coup que vous recevez, vous avez 25% de chance de gagner un point (votre nombre de point est visible avec la commande /rcpoint)\n \nCes points sont échangeable dans un shop contre différents bonus\n \nVous connaissez Slup\n \n____________________________________________________");

    }

}