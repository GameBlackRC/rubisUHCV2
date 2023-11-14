package fr.gameblack.rcuhcv2.commands.v2.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.evenement.v2.Minerais;

public class CommandSpawnMinerais implements CommandExecutor {
	
	private Main main;

    public CommandSpawnMinerais(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {

        if (sender instanceof Player) {
        	
        	Joueur joueur = main.getJoueur((Player)sender);
        	Minerais.spawn("rubis", main, joueur);

        }

        return false;
    }

}
