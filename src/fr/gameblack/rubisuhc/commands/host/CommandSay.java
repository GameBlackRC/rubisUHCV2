package fr.gameblack.rubisuhc.commands.host;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;

public class CommandSay implements CommandExecutor {
	
	private Main main;

	public CommandSay(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(main.getRole(player) == Roles.TRIAL || main.getRole(player) == Roles.SLUP) {
			
				if(args.length > 0) {
					
					Player slup = main.getPlayerByRole(Roles.SLUP);
					Player trial = main.getPlayerByRole(Roles.TRIAL);
					
					String message = "";
						
					for(String arg : args) {
								
						message += arg;
								
					}
					
					if(player == trial) {
						
						trial.sendMessage("§4HOST§c" + player.getName() + " : §6" + message);
						slup.sendMessage("§4[Trial]§c" + player.getName() + " : §6" + message);
						
					}
					else if(player == slup) {
						
						trial.sendMessage("§4[Slup]§c" + player.getName() + " : §6" + message);
						slup.sendMessage("§4[Slup]§c" + player.getName() + " : §6" + message);
						
					}
					
				}
				else {
					
					player.sendMessage("Merci de mettre un message");
					
				}
				
			}
			else {
				
				player.sendMessage("Vous n'avez pas le bon rôle");
				
			}
			
		}
		return false;
	}

}
