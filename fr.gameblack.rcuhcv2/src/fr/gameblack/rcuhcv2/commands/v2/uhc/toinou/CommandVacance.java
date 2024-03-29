package fr.gameblack.rcuhcv2.commands.v2.uhc.toinou;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v2.uhc.Toinou;

public class CommandVacance implements CommandExecutor {

    private Main main;

    public CommandVacance(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            
            Joueur joueur = main.getJoueur(player);
            
            if(joueur != null) {
            	
            	if(!joueur.getCD().contains(Pouvoirs.TOINOU_VACANCES)) {

		            if ((joueur.getRole() == Roles.TOINOU && (main.getJoueurByRole(Roles.FARMEURIMMO) == null || !main.getJoueurByRole(Roles.FARMEURIMMO).getVol().contains(Pouvoirs.TOINOU_VACANCES) || joueur.getCamp() != Camps.FARMEURIMMO)) || (joueur.getRole() == Roles.FARMEURIMMO && joueur.getVol().contains(Pouvoirs.TOINOU_VACANCES))) {
		            	
		            	Toinou.CommandVacance(joueur, main);
		
		            }
		            else {
		            	
		            	player.sendMessage("Tu n'as pas le bon rôle");
		            	
		            }
		            
            	}
            	else {
            		
            		player.sendMessage("Ce pouvoir est en cooldown");
            		
            	}
	            
            }
            else {
            	
            	player.sendMessage("Vous n'avez pas été enregistrer dans la partie, veuillez déco-reco");
            	
            }

        }

        return false;

    }

}
