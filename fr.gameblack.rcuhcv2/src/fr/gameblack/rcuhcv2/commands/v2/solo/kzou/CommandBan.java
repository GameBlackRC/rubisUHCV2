package fr.gameblack.rcuhcv2.commands.v2.solo.kzou;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v1.solo.KzouV1;
import fr.gameblack.rcuhcv2.roles.v2.solo.Kzou;

public class CommandBan implements CommandExecutor {
	
	private Main main;

    public CommandBan(Main main) {
        this.main = main;
    }
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//if(main.isV2Actif()) {
		
			Player player = (Player) sender;
			Joueur joueur = main.getJoueur(player);
			
			if(main.getVersion() == 2 && (joueur.getRole() == Roles.KZOU || joueur.getRole() == Roles.TEST || (joueur.getRole() == Roles.FARMEURIMMO && joueur.getVol().contains(Pouvoirs.KZOU_BAN)))) {
				
				Player cible_ = Bukkit.getPlayer(args[0]);
	
	            if (cible_ != null) {
	            	
	            	Kzou.CommandBan(joueur, main.getJoueur(cible_), main);
	            	
	            }
				
			}
			else {
				
				Player cible_ = Bukkit.getPlayer(args[0]);
				
	            if (cible_ != null) {
	            	
	            	KzouV1.CommandBan(joueur, main.getJoueur(cible_), main);
	            	
	            }
				
			}
			
		//}
		
		return false;
		
	}

}
