package fr.gameblack.rcuhcv2.roles.v1.solo;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.task.v1.ItemCD;

public class KzouV1 {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
		joueur.getPlayer().setMaxHealth(24);
		
	}

    public static void CommandBan(Joueur joueur, Joueur cible, Main main) {

        if (!main.getCD().contains(Pouvoirs.KZOU_BAN)) {
        		
        	cible.Stun(30, main);
        	ItemCD cycle = new ItemCD(main, joueur, "ban", 90, cible, null, null, 0, null);
            cycle.runTaskTimer(main, 0, 20);
        	
            Random r = new Random();
            int nb = r.nextInt(100);
            if (nb <= 5) {

                joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 0, false, false));

            }
            main.getCD().add(Pouvoirs.KZOU_BAN);

        }

    }

    public static void CommandDisperse(Joueur joueur, Joueur cible, Main main) {

        if (!main.getCD().contains(Pouvoirs.KZOU_DISPERSE)) {

            cible.setInvulnerable(true);
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

            cible.getPlayer().teleport(new Location(Bukkit.getWorld("world"), cos_x, 100, cos_y));

            ItemCD cycle = new ItemCD(main, joueur, "disperse", 5, cible, null, null, 0, null);
            cycle.runTaskTimer(main, 0, 20);
            main.getCD().add(Pouvoirs.KZOU_DISPERSE);
            joueur.getPlayer().sendMessage("Vous venez de disperse " + cible.getPlayer().getName());

        } else {

            joueur.getPlayer().sendMessage("Vous avez déjà utiliser cette commande durant cette épisode");

        }

    }

    public static void CommandOP(Joueur joueur, Main main) {

        if (!joueur.isOpKzou() && joueur.getNbOpKzou() != 2) {

            joueur.setOpKzou(true);
            joueur.addNbOpKzou();

        }

    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §6Kzou\n§rVous devez gagner §6seul§r\n \nVous avez 5% de speed permanent ainsi que 2% de résistance de jour\n \nAvec la commande /rcdisperse <pseudo>, vous pouvez téléporter un joueur aléatoirement sur la map\n \nAvec la commande /rcban <pseudo>, le joueur cibler ne peut plus bouger et devient invulnérable pendant 30 secondes\n \nEn sortant du ban, le joueur perd 5% de force pendant 1 minute\n \nA chaque ban que vous faites, vous avez 5% de chance de perdre 10% de force pendant 30 secondes\n \nAvec la commande /rcop, vous pouvez, 2 fois par partie avant que le message de mort s'affiche, changer le rôle du joueur mort (un autre rôle en vie seras choisi aléatoirement et vous recevrez le véritable rôle du joueur)\n \n____________________________________________________");

    }
	
}
