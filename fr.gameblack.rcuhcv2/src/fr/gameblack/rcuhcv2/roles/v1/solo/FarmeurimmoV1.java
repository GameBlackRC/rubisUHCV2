package fr.gameblack.rcuhcv2.roles.v1.solo;

import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

public class FarmeurimmoV1 {

    public static void Items(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);
        joueur.addForce(main.getForceIBaseV1());
        joueur.addResi(main.getResiIBaseV1());
        player.setMaxHealth(player.getMaxHealth() + 6);

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §6Farmeurimmo\n§rVous devez gagner §6seul§r\n \nVous avez les effets force I et résistance I permanent et speed II le jour (désactivable avec la commande /rcspeed)\n \nA chaque coup, vous retirez l'absorption du joueur frappé (peut être désactiver avec la commande /rcabso)\n \n____________________________________________________");

    }

}