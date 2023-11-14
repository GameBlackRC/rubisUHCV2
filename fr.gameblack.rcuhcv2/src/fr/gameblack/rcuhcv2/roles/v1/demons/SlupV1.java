package fr.gameblack.rcuhcv2.roles.v1.demons;

import java.util.Random;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

public class SlupV1 {

    public static void Items(Joueur joueur, Main main) {
    	
    	Player player = joueur.getPlayer();

        Texte(player);
        joueur.addResi(main.getResiIBaseV1());

    }
    
    public static void CheckProcheSlup(Roles role, Joueur slup, Entity nearbyEntities, Main main) {
    	
    	Joueur j = main.getJoueurByRole(role);

        if (j != null && j.getProcheSlup() < 300) {

            j.addProcheSlup();

        } else if (j.getProcheSlup() == 300) {

            j.addProcheSlup();
            Random r = new Random();
            int nb = r.nextInt(100);
            if (nb < 21) {

                slup.getPlayer().sendMessage("Vous avez un mauvais pressentiment");

            } else {

                slup.getPlayer().sendMessage("Vous avez confiance en " + j.getPlayer().getName());

            }

        }

    }
    
    public static void checkProche(Main main) {
    	
    	Joueur slup = main.getJoueurByRole(Roles.Slup);

        for (Entity nearbyEntities : slup.getPlayer().getNearbyEntities(30, 30, 30)) {

            if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Ange) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Ange).getPlayer()) {

                CheckProcheSlup(Roles.Ange, slup, nearbyEntities, main);

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Cosmos) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Cosmos).getPlayer()) {

                CheckProcheSlup(Roles.Cosmos, slup, nearbyEntities, main);

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Avenir) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Avenir).getPlayer()) {

                CheckProcheSlup(Roles.Avenir, slup, nearbyEntities, main);

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Demon) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Demon).getPlayer()) {

                CheckProcheSlup(Roles.Demon, slup, nearbyEntities, main);

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Electrique) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Electrique).getPlayer()) {

                CheckProcheSlup(Roles.Electrique, slup, nearbyEntities, main);

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Enfer) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Enfer).getPlayer()) {

                CheckProcheSlup(Roles.Enfer, slup, nearbyEntities, main);

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Kzou) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Kzou).getPlayer()) {

            	Joueur kzou = main.getJoueurByRole(Roles.Kzou);
            	
                if (kzou.getProcheSlup() < 300) {

                    kzou.addProcheSlup();

                } else if (kzou.getProcheSlup() == 300) {

                    kzou.addProcheSlup();

                    slup.getPlayer().sendMessage("Vous avez un mauvais pressentiment");

                }

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Malediction) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Malediction).getPlayer()) {

                CheckProcheSlup(Roles.Malediction, slup, nearbyEntities, main);

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Malivol) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Malivol).getPlayer()) {

                CheckProcheSlup(Roles.Malivol, slup, nearbyEntities, main);

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Obscur) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Obscur).getPlayer()) {

                CheckProcheSlup(Roles.Obscur, slup, nearbyEntities, main);

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Sang) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Sang).getPlayer()) {

                CheckProcheSlup(Roles.Sang, slup, nearbyEntities, main);

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Tenebre) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Tenebre).getPlayer()) {

                CheckProcheSlup(Roles.Tenebre, slup, nearbyEntities, main);

            } else if (nearbyEntities instanceof Player && main.getJoueurByRole(Roles.Tronconeuse) != null && (Player) nearbyEntities == main.getJoueurByRole(Roles.Tronconeuse).getPlayer()) {

                CheckProcheSlup(Roles.Tronconeuse, slup, nearbyEntities, main);

            }

        }
    	
    }

    public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §cSlup\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet résistance I permanent et force I la nuit\n \nVous pouvez communiquer avec Trial avec la commande /rcmsg\n \nVous êtes averti à chaque fois qu'un joueur utilise son pouvoir\n \nSi un démon reste 5 minutes proche de vous, vous recevrez son pseudo\nIl y a 20% de chance que le pseudo sois remplacer par le message 'Vous avez un mauvais pressentiment' (si le role kzou reste proche de vous, vous recevrez forcément ce message)\n \n____________________________________________________");

    }

}