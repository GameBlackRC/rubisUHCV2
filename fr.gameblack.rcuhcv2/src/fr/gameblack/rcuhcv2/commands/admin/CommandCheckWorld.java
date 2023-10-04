package fr.gameblack.rcuhcv2.commands.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;

public class CommandCheckWorld implements CommandExecutor {
	
	Main main;
	
	public CommandCheckWorld(Main main) {
		
		this.main = main;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			player.sendMessage("Tu es dans le monde : " + player.getWorld().getName());
			
		}
		
		return false;
	}

}
