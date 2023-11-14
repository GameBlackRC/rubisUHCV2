package fr.gameblack.rcuhcv2.commands.v1.rc.gameblack;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.Pouvoirs_GB;
import fr.gameblack.rcuhcv2.roles.v1.rc.GameBlackV1;

public class CommandFlair implements CommandExecutor {

    private Main main;

    public CommandFlair(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);

        if (args.length != 0) {

            Player cible_ = Bukkit.getPlayer(args[0]);

            if (cible_ != null) {
            	
            	Joueur cible = main.getJoueur(cible_);

                if (joueur.getRole() == Roles.GameBlack) {

                	if (joueur.getPouvoirGB() == Pouvoirs_GB.FLAIR) {

                        GameBlackV1.CommandFlair(joueur, cible, main);

                	} else {

                		player.sendMessage("Vous n'avez pas le pouvoir 'Flair'");

                	}

                } else {

                    player.sendMessage("Vous n'avez pas le bon rôle");

                }

            } else {

                player.sendMessage("Merci de mettre un pseudo valide");

            }

        } else {

            player.sendMessage("Merci de mettre un pseudo (/rcrecrut <pseudo>)");

        }

        return false;
    }

}