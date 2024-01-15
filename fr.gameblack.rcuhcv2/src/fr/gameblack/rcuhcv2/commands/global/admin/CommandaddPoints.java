package fr.gameblack.rcuhcv2.commands.global.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

public class CommandaddPoints implements CommandExecutor {
	
	private Main main;
	
	public CommandaddPoints(Main main) {
		
		this.main = main;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//if(main.isV2Actif()) {
		
			@SuppressWarnings("unused")
			Player player = (Player) sender;
	        
	        Player cible_ = Bukkit.getPlayer(args[0]);
	        
	        @SuppressWarnings("unused")
			String nb_ = args[1];
	
	        if (cible_ != null) {
	        	
	        	Joueur cible = main.getJoueur(cible_);
	
				if(main.getVersion() == 2) {
				        	
				   	cible.addPoint();
				        	
				}
		        
	        }
	        
		//}
		
		return false;
		
	}

}
