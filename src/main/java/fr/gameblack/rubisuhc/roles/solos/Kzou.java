package fr.gameblack.rubisuhc.roles.solos;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.task.ItemCD;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Kzou {

    public static void Items(Player player) {

        Texte(player);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
        player.setMaxHealth(24);

    }

    public static void CommandBan(Player player, Player cible, Main main) {

        if (!main.getCD().contains(Pouvoirs.KZOU_BAN)) {

            main.Stun(player, 595, cible);
            Random r = new Random();
            int nb = r.nextInt(100);
            if (nb <= 5) {

                player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 0, false, false));

            }
            ItemCD cycle = new ItemCD(main, player, "ban", 30, cible, null, null);
            cycle.runTaskTimer(main, 0, 20);
            main.getCD().add(Pouvoirs.KZOU_BAN);

        }

    }

    public static void CommandDisperse(Player player, Player cible, Main main) {

        if (!main.getCD().contains(Pouvoirs.KZOU_DISPERSE)) {

            main.addInvulnerable(cible);
            Random r = new Random();
            int signe_x = r.nextInt(2);
            int signe_y = r.nextInt(2);
            int cos_x = r.nextInt(600);
            cos_x += 200;
            if (signe_x == 1) {
                cos_x = -cos_x;
            }

            int cos_y = r.nextInt(600);
            cos_y += 200;
            if (signe_y == 1) {
                cos_y = -cos_y;
            }

            cible.teleport(new Location(Bukkit.getWorld("world"), cos_x, 100, cos_y));

            ItemCD cycle = new ItemCD(main, player, "disperse", 5, cible, null, null);
            cycle.runTaskTimer(main, 0, 20);
            main.getCD().add(Pouvoirs.KZOU_DISPERSE);
            player.sendMessage("Vous venez de disperse " + cible.getName());

        } else {

            player.sendMessage("Vous avez déjà utiliser cette commande durant cette épisode");

        }

    }

    public static void CommandOP(Player player, Main main) {

        if (!main.hasOP() && main.getNbOP() != 2) {

            main.setOP(true);
            main.addNbOP();

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §6Kzou\n§rVous devez gagner §6seul§r\n \nVous avez l'effet speed I permanent, résistance I de jour et 2 coeurs supplémentaire\n \nAvec la commande /rcdisperse <pseudo>, vous pouvez téléporter un joueur aléatoirement sur la map\n \nAvec la commande /rcban <pseudo>, vous enfermez le joueur dans une cage en bedrock pendant 30 secondes\n \nEn sortant de la cage, le joueur reçoit l'effet faiblesse I pendant 1 minute\n \nA chaque ban que vous faites, vous avez 20% de chance de recevoir l'effet faiblesse I pendant 30 secondes\n \nAvec la commande /rcop, vous pouvre, 2 fois par partie avant que le message de mort s'affiche, changer le rôle du joueur mort (un autre rôle en vie seras choisi aléatoirement et vous recevrez le véritable rôle du joueur)\n \nVous connaissez Slup et vous pouvez donc vous infiltrez parmis les démon\n \nToutefois, si vous rester 10 minutes à coté de Slup, il recevra dans son chat 'Vous avez un mauvais préssentiment' (les autres démons ont 20% de chance d'afficher se message au lieu de leur pseudo)\n \n____________________________________________________");

    }

}
