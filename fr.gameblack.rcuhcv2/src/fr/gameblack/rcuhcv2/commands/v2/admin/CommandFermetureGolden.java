package fr.gameblack.rcuhcv2.commands.v2.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.evenement.v2.FermetureGolden;

public class CommandFermetureGolden implements CommandExecutor {
	
	private Main main;

    public CommandFermetureGolden(Main main) {
        this.main = main;
    }

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(!main.isFermetureGoldenActif()) {
		
			FermetureGolden.Active(main);
			
		}
		
		return false;
	}

}
