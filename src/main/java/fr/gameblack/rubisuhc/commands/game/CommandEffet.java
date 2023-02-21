package fr.gameblack.rubisuhc.commands.game;

import fr.gameblack.rubisuhc.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEffet implements CommandExecutor {

    private Main main;

    public CommandEffet(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            double speed = (main.getPourcentEffet(player, "speed") - 1) * 100;
            double force = (main.getPourcentEffet(player, "force") - 1) * 100;
            double resi = (main.getPourcentEffet(player, "resi") - 1) * 100;

            player.sendMessage("Force : " + force + "%\nSpeed : " + speed + "%\nRésistance : " + resi + "%");

        }

        return false;
    }

}
