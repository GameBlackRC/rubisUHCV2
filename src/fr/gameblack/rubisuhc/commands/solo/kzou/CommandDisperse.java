package fr.gameblack.rubisuhc.commands.solo.kzou;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.solos.Kzou;

public class CommandDisperse implements CommandExecutor {
	
	private Main main;
	
	public CommandDisperse(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		Player player = (Player)sender;
		
		if(args.length != 0) {
			
			Player cible = Bukkit.getPlayer(args[0]);
			
			if(cible != null) {
		
				if(main.getRole(player) == Roles.KZOU) {
					
					Kzou.CommandDisperse(player, cible, main);
					
					if(main.getRoles().contains(Roles.SLUP)) {
					
						Player slup = main.getPlayerByRole(Roles.SLUP);
						
						slup.sendMessage("Kzou a utilisé sa commande /rcdisperse");
						
					}
					
				}
				else {
					
					player.sendMessage("Vous n'avez pas le bon rôle");
					
				}
				
			}
			else {
				
				player.sendMessage("Merci de mettre un pseudo valide");
				
			}
			
		}
			
		else {
				
			player.sendMessage("Merci de mettre un pseudo (/rcdisperse <pseudo>)");
				
		}
		
		return false;
	}

}
