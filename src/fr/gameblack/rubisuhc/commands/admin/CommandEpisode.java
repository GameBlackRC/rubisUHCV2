package fr.gameblack.rubisuhc.commands.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;

public class CommandEpisode implements CommandExecutor {

	private Main main;
	
	public CommandEpisode(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {

		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(main.getHost() == player) {
		
				main.setTemps();
				
			}
			
		}
		
		return false;
	}

}
