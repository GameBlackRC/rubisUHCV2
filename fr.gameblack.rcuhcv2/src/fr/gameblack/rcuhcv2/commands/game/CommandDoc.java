package fr.gameblack.rcuhcv2.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDoc implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            player.sendMessage("https://rc-uhc-v2.gitbook.io/rc-uhc-v2/");

        }

        return false;
    }

}
