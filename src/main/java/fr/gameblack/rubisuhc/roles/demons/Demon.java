package fr.gameblack.rubisuhc.roles.demons;

import fr.gameblack.rubisuhc.Main;
import org.bukkit.entity.Player;

import java.util.Random;

public class Demon {

    public static void Items(Player player, Main main) {

        Texte(player, main);

    }

    public static void Texte(Player player, Main main) {

        Random r = new Random();
        int nb = r.nextInt(2);

        if (nb == 1) {
            player.sendMessage("____________________________________________________\n \nVous êtes un §cDémon\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet faiblesse I le jour et l'effet force I la nuit\n \nA chaque kill que vous faites, vous recevez 5% de force\n \nVous connaissez un démon aléatoire hormis Trial et Slup\n \n____________________________________________________");
            main.setEffetDemon("force");
        } else {
            player.sendMessage("____________________________________________________\n \nVous êtes un §cDémon\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet faiblesse I le jour et l'effet speed I la nuit\n \nA chaque kill que vous faites, vous recevez 5% de speed\n \nVous connaissez un démon aléatoire hormis Trial et Slup\n \n____________________________________________________");
            main.setEffetDemon("speed");
        }

    }

}
