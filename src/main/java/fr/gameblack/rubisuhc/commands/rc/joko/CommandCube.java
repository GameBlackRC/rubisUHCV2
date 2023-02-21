package fr.gameblack.rubisuhc.commands.rc.joko;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.rc.Joko;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCube implements CommandExecutor {

    private Main main;

    public CommandCube(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;

        if (args.length != 0) {

            Player cible = Bukkit.getPlayer(args[0]);

            if (cible != null) {

                if (main.getRole(player) == Roles.JOKO) {

                    if (!main.getCD().contains(Pouvoirs.JOKO_GIVECUBE)) {

                        Joko.CommandCube(player, cible, main);

                        if (main.getRoles().contains(Roles.SLUP)) {

                            Player slup = main.getPlayerByRole(Roles.SLUP);

                            slup.sendMessage("Joko a utilisé sa commande /rccube");

                        }

                    } else {

                        player.sendMessage("Attendez 5 minutes avant de réutiliser cette commande");

                    }

                } else {

                    player.sendMessage("Vous n'avez pas le bon rôle");

                }

            } else {

                player.sendMessage("Merci de mettre un pseudo valide");

            }

        } else {

            player.sendMessage("Merci de mettre un pseudo (/rccube <pseudo>");

        }

        return false;
    }

}
