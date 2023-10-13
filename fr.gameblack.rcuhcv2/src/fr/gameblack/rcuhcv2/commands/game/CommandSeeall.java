package fr.gameblack.rcuhcv2.commands.game;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;

public class CommandSeeall implements CommandExecutor {

    private Main main;

    public CommandSeeall(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            for(Player p : Bukkit.getOnlinePlayers()) {
            	
            	Joueur j = main.getJoueur(p);
            	
            	if(!j.isInvisible() || j.isSpec()) {
            	
            		((Player) sender).showPlayer(p);
            	
            	}
            	
            }

        }

        return false;
    }

}
