package fr.gameblack.rcuhcv2.commands.v1.demons.trial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v1.demons.TrialV1;

public class CommandBroken implements CommandExecutor {

    private Main main;

    public CommandBroken(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);

        if (joueur.getRole() == Roles.Trial) {

        	TrialV1.CommandBroken(joueur, main);

        } else {

        	player.sendMessage("Vous n'avez pas le bon rôle");

        }

        return false;
    }

}