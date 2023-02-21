package fr.gameblack.rubisuhc.commands.rc.gameblack;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.rc.GameBlack;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandInspect implements CommandExecutor {

    private Main main;

    public CommandInspect(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;

        if (args.length != 0) {

            Player cible = Bukkit.getPlayer(args[0]);

            if (cible != null) {

                if (main.getRole(player) == Roles.GAMEBLACK) {

                    if (!main.getCD().contains(Pouvoirs.GB_INSPECT)) {

                        if (main.getPacteGB() == 2) {

                            if (main.getRoles().contains(Roles.SLUP)) {

                                Player slup = main.getPlayerByRole(Roles.SLUP);

                                slup.sendMessage("GameBlack a utilisé sa commande /rcinspect");

                            }

                            GameBlack.CommandInspect(player, cible, main);

                        } else {

                            player.sendMessage("Vous n'avez choisis le pacte 2");

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
