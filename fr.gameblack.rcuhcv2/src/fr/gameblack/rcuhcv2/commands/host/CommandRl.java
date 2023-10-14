package fr.gameblack.rcuhcv2.commands.host;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;

public class CommandRl implements CommandExecutor {

    private Main main;

    public CommandRl(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

    	if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);

            if (main.getListHost().contains(joueur)) {

            	Bukkit.reload();

            } else {
            	
                player.sendMessage("Tu n'es pas l'host de la partie");

            }

        }

        return false;

    }

}
