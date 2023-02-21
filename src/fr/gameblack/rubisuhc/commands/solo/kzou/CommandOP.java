package fr.gameblack.rubisuhc.commands.solo.kzou;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.solos.Kzou;

public class CommandOP implements CommandExecutor {
	
	private Main main;
	
	public CommandOP(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		Player player = (Player)sender;
		
		if(main.getRole(player) == Roles.KZOU) {
			
			Kzou.CommandOP(player, main);
			
			player.sendMessage("Le prochain joueurs que vous turez n'auras pas son véritable rôle d'activer");
			
		}
		
		return false;
	}

}
