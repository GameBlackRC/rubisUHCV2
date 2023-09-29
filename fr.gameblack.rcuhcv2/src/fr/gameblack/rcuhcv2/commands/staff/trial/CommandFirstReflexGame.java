package fr.gameblack.rcuhcv2.commands.staff.trial;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.roles.staff.Trial;

public class CommandFirstReflexGame implements CommandExecutor {
	
private Main main;
	
	public CommandFirstReflexGame(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {

        if (sender instanceof Player) {

        	List<Joueur> joueurs = main.getJoueurJeuTrial();
        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);
        	
        	if(joueurs.contains(joueur)) {
        	
	        	joueurs.remove(joueur);
	        	Joueur perdant = joueurs.get(0);
	        	Trial.FinJeuReflex(joueur, perdant, main);
	        	joueur.getPlayer().sendMessage("Vous avez gagner le jeu");
	        	perdant.getPlayer().sendMessage("Vous avez perdu le jeu");
	        	
        	}

        }

        return false;
    }

}
