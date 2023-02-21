package fr.gameblack.rubisuhc.commands.solo.kzou;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.solos.Kzou;

public class CommandBan implements CommandExecutor {
	
	private Main main;
	
	public CommandBan(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		Player player = (Player)sender;
		
		if(args.length != 0) {
			
			Player cible = Bukkit.getPlayer(args[0]);
			
			if(cible != null) {
		
				if(main.getRole(player) == Roles.KZOU) {
					
					Kzou.CommandBan(player, cible, main);
					
					player.sendMessage("Vous venez de ban " + cible.getName());
					
					if(main.getRoles().contains(Roles.SLUP)) {
					
						Player slup = main.getPlayerByRole(Roles.SLUP);
						
						slup.sendMessage("Kzou a utilisé sa commande /rcban");
						
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
			
			player.sendMessage("Merci de mettre un pseudo (/rcban <pseudo>)");
			
		}
		
		return false;
	}

}
