package fr.gameblack.rcuhcv2.roles.v1.solo;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

public class Experimental {

    public static void Items(Joueur joueur, Main main) {

    	Player player = joueur.getPlayer();
    	
        Texte(player);
        joueur.addForce(main.getForceIBaseV1());
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
        joueur.setNofallPerma(true);

    }

    public static void CommandSacrifice(Joueur joueur, Main main) {

    	Player player = joueur.getPlayer();
    	
    	joueur.addForce(0.02);
    	joueur.addResi(0.02);
        player.setMaxHealth(player.getMaxHealth() - 2);
        player.sendMessage("Vous venez de sacrifier §d1 coeur permanent§r contre  §92% de résistance§r et §92% de force§r");

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes le §6Démon expérimental\n§rVous devez gagner §6seul§r\n \nVous avez les effets force I, speed I et no fall permanent\n \nA chaque kill que vous faites, vous recevez 5% de speed en plus\n \nAvec la commande /rcsacrifice, vous sacrifiez un coeur permanent pour recevoir 5% de force et de résistance en plus\n \nA chaque coup, vous avez 2% de chance d'immobilisé le joueur taper qui deviendra invunérable (peut être désactiver avec la commande /rcstun)\n \n____________________________________________________");

    }

}