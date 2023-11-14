package fr.gameblack.rcuhcv2.commands.v1.demons.cosmos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v1.demons.Cosmos;

public class CommandKill implements CommandExecutor {

    private Main main;

    public CommandKill(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);

        if (args.length != 0) {

            if (args[0] != null && (args[0].equalsIgnoreCase("effet") || args[0].equalsIgnoreCase("pantin"))) {

                if (joueur.getRole() == Roles.Cosmos) {
                		
                	Cosmos.CommandeKill(joueur, main, args[0], main.getKillCosmos());

                }
                else {

                    player.sendMessage("Vous n'avez pas le bon rôle");

                }

            } else {

                player.sendMessage("Merci de mettre une valeur valide (/rckill <effet|pantin>)");

            }

        } else {

            player.sendMessage("Merci de mettre une valeur (/rcchoose <coeur|effet>)");

        }

        return false;
    }

}