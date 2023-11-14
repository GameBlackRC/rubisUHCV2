package fr.gameblack.rcuhcv2.commands.v1.rc.gameblack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.Pouvoirs_GB;
import fr.gameblack.rcuhcv2.roles.v1.rc.GameBlackV1;

public class CommandBack implements CommandExecutor {

    private Main main;

    public CommandBack(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);

        if (joueur.getRole() == Roles.GameBlack) {

        	if (joueur.getPouvoirGB() == Pouvoirs_GB.FLAIR) {

        		GameBlackV1.CommandBack(joueur, main);

        	} else {

        		player.sendMessage("Vous n'avez pas le pouvoir 'Flair'");

        	}

        } else {

        	player.sendMessage("Vous n'avez pas le bon rôle");

        }

        return false;
    }

}