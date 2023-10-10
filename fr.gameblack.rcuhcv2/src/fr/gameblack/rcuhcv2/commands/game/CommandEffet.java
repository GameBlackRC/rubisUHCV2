package fr.gameblack.rcuhcv2.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;

public class CommandEffet implements CommandExecutor {

    private Main main;

    public CommandEffet(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);

            double speed = joueur.getSpeed() - 100;
            double force = joueur.getForce() - 100;
            double resi = joueur.getResi() - 110;

            player.sendMessage("_______________________________\n \nForce : " + force + "%\nSpeed : " + speed + "%\nRésistance : " + resi + "%\n \n_______________________________");

        }

        return false;
    }

}
