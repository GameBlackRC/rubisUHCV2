package fr.gameblack.rcuhcv2.commands.v1.solo.experimental;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v1.solo.Experimental;

public class CommandSacrifice implements CommandExecutor {

    private Main main;

    public CommandSacrifice(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);

        if (joueur.getRole() == Roles.Experimental) {

        	if (joueur.getPlayer().getMaxHealth() > 2) {

        		Experimental.CommandSacrifice(joueur, main);

        	} else {

        		player.sendMessage("Vous ne pouvez plus utiliser cette commande");

        	}

        } else {

        	player.sendMessage("Vous n'avez pas le bon rôle");

        }

        return false;
    }

}