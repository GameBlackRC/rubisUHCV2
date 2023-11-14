package fr.gameblack.rcuhcv2.commands.v1.rc.gameblack;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.Pouvoirs_GB;
import fr.gameblack.rcuhcv2.roles.v1.rc.GameBlackV1;

public class CommandInspect implements CommandExecutor {

    private Main main;

    public CommandInspect(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        
        Joueur joueur = main.getJoueurByRole(Roles.GameBlack);

        if (args.length != 0) {

            Player cible_ = Bukkit.getPlayer(args[0]);

            if (cible_ != null) {
            	
            	Joueur cible = main.getJoueur(cible_);

                if (joueur.getRole() == Roles.GameBlack) {

                    if (!main.getCD().contains(Pouvoirs.GB_INSPECT)) {

                        if (joueur.getPouvoirGB() == Pouvoirs_GB.SPEED) {

                            GameBlackV1.CommandInspect(joueur, cible, main, true);

                        } else {

                            player.sendMessage("Vous n'avez pas le pouvoir 'Speed'");

                        }

                    } else {

                        player.sendMessage("Vous avez déjà utiliser cette commande durant cet épisode");

                    }

                } else {

                    player.sendMessage("Vous n'avez pas le bon rôle");

                }

            } else {

                player.sendMessage("Merci de mettre un pseudo valide");

            }

        } else {

            player.sendMessage("Merci de mettre un pseudo (/rcinspect <pseudo>)");

        }

        return false;
    }

}