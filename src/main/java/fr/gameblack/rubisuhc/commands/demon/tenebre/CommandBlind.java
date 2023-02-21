package fr.gameblack.rubisuhc.commands.demon.tenebre;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.demons.Tenebre;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBlind implements CommandExecutor {

    private Main main;

    public CommandBlind(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;

        if (args.length != 0) {

            Player cible = Bukkit.getPlayer(args[0]);

            if (cible != null) {

                if (main.getRole(player) == Roles.TENEBRE) {

                    if (!main.getCD().contains(Pouvoirs.TENEBRE_BLIND)) {

                        Tenebre.CommandeBlind(cible, main);

                        if (main.getRoles().contains(Roles.SLUP)) {

                            Player slup = main.getPlayerByRole(Roles.SLUP);

                            slup.sendMessage("Ténèbre a utilisé sa commande /rcblind");

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

            player.sendMessage("Merci de donner le pseudo de la cible (/rcblind <pseudo>");

        }

        return false;
    }

}
