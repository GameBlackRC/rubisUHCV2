package fr.gameblack.rcuhcv2.commands.staff.trial;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.staff.Trial;

public class CommandPlay implements CommandExecutor {
	
private Main main;
	
	public CommandPlay(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {
        	
        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);

        	Player cible_ = Bukkit.getPlayer(args[0]);
        	Joueur cible = main.getJoueur(cible_);

            if (cible_ != null && (joueur.getRole() == Roles.TRIAL && joueur.getModeTrial() == "fun")) {
            	
            	Trial.CommandPlay(joueur, cible, main);
            	
            }
            else {
            	
            	player.sendMessage("Erreur CommandPlay.java");
            	
            }

        }

        return false;
    }

}