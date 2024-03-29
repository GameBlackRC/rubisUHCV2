package fr.gameblack.rcuhcv2.commands.v2.staff.maka;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v2.staff.Maka;

public class CommandForme implements CommandExecutor {
	
	private Main main;
	
	public CommandForme(Main main) {
		
		this.main = main;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			Joueur joueur = main.getJoueur(player);
			
			if(joueur.getRole() == Roles.MAKA) {
				
				Maka.FormeSimp(joueur, main);
				
			}
			
		}
		
		return false;
	}

}
