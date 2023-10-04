package fr.gameblack.rcuhcv2.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;

public class CommandTpWorld implements CommandExecutor {
	
	Main main;
	
	public CommandTpWorld(Main main) {
		
		this.main = main;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			
			if(args.length > 0 && args[0].equalsIgnoreCase("uhc")) {
				
				if(main.getWorld() != null) {
					
					Player player = (Player) sender;
					
					Location loc = player.getLocation();
					loc.setWorld(main.getWorld());
					player.teleport(loc);
					
				}
				else {
					
					sender.sendMessage("Ce monde n'est pas encore générer");
					
				}
				
			}
			else {
				
				Player player = (Player) sender;
				
				Location loc = player.getLocation();
				loc.setWorld(Bukkit.getWorld("world"));
				player.teleport(loc);
				
			}
			
		}
		
		return false;
	}

}
