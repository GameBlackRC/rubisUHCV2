package fr.gameblack.rubisuhc.commands.demon.sang;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.demons.Sang;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSang implements CommandExecutor {

    private Main main;

    public CommandSang(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;

        if (args.length != 0) {

            Player cible = Bukkit.getPlayer(args[0]);

            if (cible != null) {

                if (main.getRole(player) == Roles.SANG || (main.getRole(player) == Roles.TOINOU && main.ToinouKill(Roles.SANG))) {

                    if (!main.getCD().contains(Pouvoirs.SANG_SANG)) {

                        Sang.CommandSang(player, cible, main);

                        if (main.getRoles().contains(Roles.SLUP)) {

                            Player slup = main.getPlayerByRole(Roles.SLUP);

                            slup.sendMessage("Le démon Sang a utilisé sa commande /rcsang");

                        }

                    } else {

                        player.sendMessage("Vous avez déjà utilisé ce pouvoir cet épisode");

                    }

                } else {

                    player.sendMessage("Vous n'avez pas le bon rôle");

                }

            } else {

                player.sendMessage("Merci de mettre un pseudo valide");

            }

        } else {

            player.sendMessage("Merci de mettre un pseudo (/rcsang <pseudo>)");

        }

        return false;
    }

}
