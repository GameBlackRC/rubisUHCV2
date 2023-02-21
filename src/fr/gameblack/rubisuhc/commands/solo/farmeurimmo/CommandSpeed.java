package fr.gameblack.rubisuhc.commands.solo.farmeurimmo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;

public class CommandSpeed implements CommandExecutor {
	
	private Main main;
	
	public CommandSpeed(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		Player player = (Player)sender;
		
		if(main.getRole(player) == Roles.FARMEURIMMO) {
			
			if(main.isSpeedFarmeur()) {
				
				player.sendMessage("Vous n'avez désormais plus speed II le jour");
				
				main.setSpeedFarmeur(false);
				
			}
			else {
				
				player.sendMessage("Vous avez désormais speed II le jour");
				
				main.setSpeedFarmeur(true);
				
			}
			
		}
		
		return false;
	}

}
