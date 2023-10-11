package fr.gameblack.rcuhcv2.roles.solo;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class Kzou {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		
	}

    public static void CommandBan(Joueur joueur, Joueur cible, Main main) {

        if (!main.getCD().contains(Pouvoirs.KZOU_BAN)) {

        	if(cible.getRole() == Roles.NONOBOY) {
        	
        		cible.Stun(15, main);
        		
        	}
        	else {
        		
        		cible.Stun(30, main);
        		
        	}
        	
            Random r = new Random();
            int nb = r.nextInt(100);
            if (nb <= 5) {

                joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 0, false, false));

            }
            if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).getCamp().equalsIgnoreCase("staff")) {
            	
            	int nb2 = r.nextInt(100);
            	
            	Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
            	
            	if(nb2 <= 25) {
            		
            		gb.getPlayer().sendMessage("[CONSOLE] " + cible.getPlayer().getName() + " vient de se faire bannir par Kzou");
            		
            	}
            	else {
            		
            		gb.getPlayer().sendMessage("[CONSOLE] Un joueur vient de se faire bannir par Kzou");
            		
            	}
            	
            }
            ItemCD cycle = new ItemCD(main, joueur, "ban", 45, cible, null, null, null, null);
            cycle.runTaskTimer(main, 0, 20);
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

            ItemCD cycle = new ItemCD(main, joueur, "disperse", 5, cible, null, null, null, null);
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

        player.sendMessage("____________________________________________________\n \nVous êtes §6Kzou\n§rVous devez gagner §6seul§r\n \nVous avez l'effet speed I permanent, résistance I de jour et 2 coeurs supplémentaire\n \nAvec la commande /rcdisperse <pseudo>, vous pouvez téléporter un joueur aléatoirement sur la map\n \nAvec la commande /rcban <pseudo>, vous enfermez le joueur dans une cage en bedrock pendant 30 secondes\n \nEn sortant de la cage, le joueur reçoit l'effet faiblesse I pendant 1 minute\n \nA chaque ban que vous faites, vous avez 20% de chance de recevoir l'effet faiblesse I pendant 30 secondes\n \nAvec la commande /rcop, vous pouvre, 2 fois par partie avant que le message de mort s'affiche, changer le rôle du joueur mort (un autre rôle en vie seras choisi aléatoirement et vous recevrez le véritable rôle du joueur)\n \nVous connaissez Slup et vous pouvez donc vous infiltrez parmis les démon\n \nToutefois, si vous rester 10 minutes à coté de Slup, il recevra dans son chat 'Vous avez un mauvais préssentiment' (les autres démons ont 20% de chance d'afficher se message au lieu de leur pseudo)\n \n____________________________________________________");

    }
	
}
