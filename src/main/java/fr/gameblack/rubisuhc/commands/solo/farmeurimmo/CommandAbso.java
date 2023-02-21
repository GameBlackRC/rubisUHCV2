package fr.gameblack.rubisuhc.commands.solo.farmeurimmo;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAbso implements CommandExecutor {

    private Main main;

    public CommandAbso(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;

        if (main.getRole(player) == Roles.FARMEURIMMO) {

            if (main.isAbsoFarmeur()) {

                player.sendMessage("Vous ne retirez désormais plus l'absorption à chaque coup");

                main.setAbsoFarmeur(false);

            } else {

                player.sendMessage("Vous retirez désormais l'absorption à chaque coup");

                main.setAbsoFarmeur(true);

            }

        }

        return false;
    }

}
