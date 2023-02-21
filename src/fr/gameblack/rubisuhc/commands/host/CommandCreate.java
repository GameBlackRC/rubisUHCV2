package fr.gameblack.rubisuhc.commands.host;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;

	public class CommandCreate implements CommandExecutor {

	private Main main;

	public CommandCreate(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
		
			if(main.getHost() == null) {
				
				main.setHost(player);
				
			}
			
		}
		
		return false;
		
	}
	
}
