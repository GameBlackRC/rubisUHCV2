package fr.gameblack.rubisuhc.commands.host;
import org.bukkit.Bukkit;
//4.05
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.State;
import fr.gameblack.rubisuhc.task.Autostart;

public class CommandStart implements CommandExecutor {
	
	private Main main;
	
	public CommandStart(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
		
			Player player = (Player) sender;
			
			if(main.getState() == State.WAITING) {
			
				if(main.getHost() == player) {
				
					main.setState(State.STARTING);
					
					Bukkit.getScheduler().runTaskAsynchronously(main, ()-> {
						
						Autostart start = new Autostart(main);
						start.runTaskTimer(main, 0, 20);
						
					});
			
				}
				else {
					
					player.sendMessage("Tu n'es pas l'host de la partie");
					
				}
				
			}
			else {
				
				player.sendMessage("La partie a déjà commencé");
				
			}
				
		}
		
		return false;
	}

}
