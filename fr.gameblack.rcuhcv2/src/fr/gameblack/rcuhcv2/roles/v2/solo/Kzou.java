package fr.gameblack.rcuhcv2.roles.v2.solo;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Kzou {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		joueur.addSpeed(0.1);
		if(joueur.isBot()) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Kzou");
			
		}
		
	}

    public static void CommandBan(Joueur joueur, Joueur cible, Main main) {

        if (!joueur.getCD().contains(Pouvoirs.KZOU_BAN)) {

        	if(cible.getRole() == Roles.NONOBOY) {
        	
        		cible.Stun(15, main);
        		ItemCD cycle = new ItemCD(main, joueur, "ban", 45, cible, null, null, 0, null);
                cycle.runTaskTimer(main, 0, 20);
        		
        	}
        	else {
        		
        		cible.Stun(30, main);
        		ItemCD cycle = new ItemCD(main, joueur, "ban", 90, cible, null, null, 0, null);
                cycle.runTaskTimer(main, 0, 20);
        		
        	}
        	
            Random r = new Random();
            int nb = r.nextInt(100);
            if (nb <= 5) {

                joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 0, false, false));

            }
            if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).getCamp() == Camps.STAFF) {
            	
            	int nb2 = r.nextInt(100);
            	
            	Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
            	
            	if(nb2 <= 25) {
            		
            		gb.getPlayer().sendMessage("[CONSOLE] " + cible.getPlayer().getName() + " vient de se faire bannir par Kzou");
            		
            	}
            	else {
            		
            		gb.getPlayer().sendMessage("[CONSOLE] Un joueur vient de se faire bannir par Kzou");
            		
            	}
            	
            }
            joueur.getCD().add(Pouvoirs.KZOU_BAN);

        }

    }

    public static void CommandDisperse(Joueur joueur, Joueur cible, Main main) {

        if (!joueur.getCD().contains(Pouvoirs.KZOU_DISPERSE)) {

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
            
            joueur.setNofall(true);

            ItemCD cycle = new ItemCD(main, joueur, "disperse", 5, cible, null, null, 0, null);
            cycle.runTaskTimer(main, 0, 20);
            ItemCD cycle2 = new ItemCD(main, joueur, "disnofall", 10, cible, null, null, 0, null);
            cycle2.runTaskTimer(main, 0, 20);
            joueur.getCD().add(Pouvoirs.KZOU_DISPERSE);
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

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §6Kzou\n§r"
        		+ "Vous devez gagner §6seul§r\n \n"
        		+ "Vous avez 10% de speed permanent ainsi que 2% de résistance de jour\n \n"
        		+ "Avec la commande /rcdisperse <pseudo>, vous pouvez téléporter un joueur aléatoirement sur la map\n \n"
        		+ "Avec la commande /rcban <pseudo>, le joueur ciblé ne peut plus bouger et devient invulnérable pendant 30 secondes\n \n"
        		+ "En sortant du ban, le joueur perd 2% de force pendant 1 minute\n \n"
        		+ "Si vous bannez un joueur en train de cheat, vous recevez 2% de force supplémentaire pendant 5 minutes\n \n"
        		+ "A chaque ban que vous faites, vous avez 5% de chance de perdre 2% de force pendant 30 secondes\n \n"
        		+ "Avec la commande /rcop, vous pouvez, 2 fois par partie avant que le message de mort s'affiche, changer le rôle du joueur mort (un autre rôle en vie seras choisi aléatoirement et vous recevrez le véritable rôle du joueur)\n \n"
        		+ "____________________________________________________");

    }
	
}
