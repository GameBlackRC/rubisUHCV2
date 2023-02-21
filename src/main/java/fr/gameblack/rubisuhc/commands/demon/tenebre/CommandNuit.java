package fr.gameblack.rubisuhc.commands.demon.tenebre;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.demons.Tenebre;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandNuit implements CommandExecutor {

    private Main main;

    public CommandNuit(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;

        if (main.getRole(player) == Roles.TENEBRE) {

            Tenebre.CommandeNuit(main);

        } else {

            player.sendMessage("Vous n'avez pas le bon rôle");

        }

        return false;
    }

}
