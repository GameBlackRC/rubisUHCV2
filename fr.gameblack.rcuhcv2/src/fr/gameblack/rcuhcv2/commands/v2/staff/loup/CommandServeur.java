package fr.gameblack.rcuhcv2.commands.v2.staff.loup;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v2.staff.Loup;

public class CommandServeur implements CommandExecutor {
	
	private Main main;
	
	public CommandServeur(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {

        if (sender instanceof Player) {

        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);
        	
        	if(joueur.getRole() == Roles.LOUP || (joueur.getRole() == Roles.FARMEURIMMO && joueur.getVol().contains(Pouvoirs.LOUP_SERVEUR))) {
        		
        		Loup.CommandServeur(joueur, main);
        		
        	}

        }

        return false;
    }

}
