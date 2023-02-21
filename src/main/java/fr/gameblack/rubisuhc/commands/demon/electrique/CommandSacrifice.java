package fr.gameblack.rubisuhc.commands.demon.electrique;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.demons.Electrique;
import fr.gameblack.rubisuhc.roles.solos.Experimental;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSacrifice implements CommandExecutor {

    private Main main;

    public CommandSacrifice(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;

        if (main.getRole(player) == Roles.ELECTRIQUE) {

            Electrique.CommandSacrifice(player, main);

            if (main.getRoles().contains(Roles.SLUP)) {

                Player slup = main.getPlayerByRole(Roles.SLUP);

                slup.sendMessage("Le démon Electrique a utilisé sa commande /rcsacrifice");

            }

        } else if (main.getRole(player) == Roles.EXPERIMENTAL) {

            Experimental.CommandSacrifice(player, main);

            if (main.getRoles().contains(Roles.SLUP)) {

                Player slup = main.getPlayerByRole(Roles.SLUP);

                slup.sendMessage("Le démon Expérimental a utilisé sa commande /rcsacrifice");

            }

        } else {

            player.sendMessage("Vous n'avez pas le bon rôle");

        }

        return false;
    }

}
