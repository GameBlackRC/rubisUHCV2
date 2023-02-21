package fr.gameblack.rubisuhc.commands.demon.obscur;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Orbe;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.demons.Obscur;
import fr.gameblack.rubisuhc.roles.demons.Trial;
import fr.gameblack.rubisuhc.roles.rc.Joko;

public class CommandSetPiece implements CommandExecutor {
	
	private Main main;
	
	public CommandSetPiece(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		Player player = (Player)sender;
		
		if(main.getRole(player) == Roles.OBSCUR) {
			
			if(args.length != 0) {
				
				if(main.getRoles().contains(Roles.SLUP)) {
					
					Player slup = main.getPlayerByRole(Roles.SLUP);
					
					slup.sendMessage("Obscur a utilisé sa commande /rcsetpiece");
					
				}
				
				Obscur.CommandSetPiece(player, args[0], main);
				
			}
			else {
				
				player.sendMessage("Merci de mettre la pièce que vous voulez équiper (/rcsetpiece <casque|plastron|jambiere|bottes|epee>)");
				
			}
					
		}
		
		return false;
	}

}
