package fr.gameblack.rcuhcv2.roles.v1.demons;

import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.classes.Joueur;

import java.util.Random;

public class Demon {

    public static void Items(Joueur joueur) {

        Texte(joueur);

    }

    public static void Texte(Joueur joueur) {
    	
    	Player player = joueur.getPlayer();

        Random r = new Random();
        int nb = r.nextInt(2);

        if (nb == 1) {
            player.sendMessage("____________________________________________________\n \nVous êtes un §cDémon\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet faiblesse I le jour et l'effet force I la nuit\n \nA chaque kill que vous faites, vous recevez 5% de force\n \nVous connaissez un démon aléatoire hormis Trial et Slup\n \n____________________________________________________");
            //main.setEffetDemon("force");
        } else {
            player.sendMessage("____________________________________________________\n \nVous êtes un §cDémon\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet faiblesse I le jour et l'effet speed I la nuit\n \nA chaque kill que vous faites, vous recevez 5% de speed\n \nVous connaissez un démon aléatoire hormis Trial et Slup\n \n____________________________________________________");
            //main.setEffetDemon("speed");
        }

    }

}