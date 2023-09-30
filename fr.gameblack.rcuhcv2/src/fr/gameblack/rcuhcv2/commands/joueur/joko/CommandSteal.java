package fr.gameblack.rcuhcv2.commands.joueur.joko;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.joueur.Joko;

public class CommandSteal implements CommandExecutor {

    private Main main;

    public CommandSteal(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        
        Joueur joueur = main.getJoueur(player);

        if (joueur.getRole() == Roles.JOKO) {

            if (args.length != 0) {

                if (args[0].equalsIgnoreCase("force")) {
                    Joko.CommandSteal(joueur, main, "force");

                } else if (args[0].equalsIgnoreCase("resi") || args[0].equalsIgnoreCase("resistance")) {
                    Joko.CommandSteal(joueur, main, "resi");

                }

            } else {

                player.sendMessage("Merci de mettre l'effet que vous souhaitez voler (/rcsteal <force|resi|resistance>)");

            }

        } else {

            player.sendMessage("Vous n'avez pas le bon rôle");

        }

        return false;
    }

}