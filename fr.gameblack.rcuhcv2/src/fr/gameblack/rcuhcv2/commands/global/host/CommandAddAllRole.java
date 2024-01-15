package fr.gameblack.rcuhcv2.commands.global.host;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

public class CommandAddAllRole implements CommandExecutor {

    private Main main;

    public CommandAddAllRole(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);

            if (main.getListHost().contains(joueur)) {
            	
            	if(main.getVersion() == 2) {
            	
	                main.getCompo().add(Roles.RAPTOR);
	                main.getCompo().add(Roles.JEANNOT);
	                main.getCompo().add(Roles.NICKOBOOP);
	                main.getCompo().add(Roles.SLUP);
	                main.getCompo().add(Roles.JOKO);
	                
	                main.getCompo().add(Roles.TEAM);
	                main.getCompo().add(Roles.GAMEBLACK);
	                main.getCompo().add(Roles.MAKA);
	                main.getCompo().add(Roles.TRIAL);
	                main.getCompo().add(Roles.LOUP);
	                main.getCompo().add(Roles.CAPTAIN);
	                main.getCompo().add(Roles.HEKOW);
	                
	                main.getCompo().add(Roles.MALIVOL);
	                main.getCompo().add(Roles.TOINOU);
	                main.getCompo().add(Roles.OBSCUR);
	                main.getCompo().add(Roles.NONOBOY);
	                main.getCompo().add(Roles.THEOOCHOUX);
	                main.getCompo().add(Roles.ROMPREMS);
	                
	                main.getCompo().add(Roles.FARMEURIMMO);
	                main.getCompo().add(Roles.KZOU);
	                
                	main.updateScoreboard();
	                
	                player.sendMessage("Vous venez d'ajouter tous les rôles fonctionnel dans la compo");
	                
            	}
            	else if(main.getVersion() == 1) {
            		
            		main.getCompo().add(Roles.GameBlack);
            		main.getCompo().add(Roles.Team);
            		main.getCompo().add(Roles.Joko);
            		main.getCompo().add(Roles.Maka);
            		main.getCompo().add(Roles.Loup);
            		main.getCompo().add(Roles.Raptor);
            		main.getCompo().add(Roles.Guerrier);
            		main.getCompo().add(Roles.Archer);
            		
            		main.getCompo().add(Roles.Malivol);
            		main.getCompo().add(Roles.Ange);
            		main.getCompo().add(Roles.Enfer);
            		main.getCompo().add(Roles.Electrique);
            		main.getCompo().add(Roles.Malediction);
            		main.getCompo().add(Roles.Sang);
            		main.getCompo().add(Roles.Tenebre);
            		
            		main.getCompo().add(Roles.Experimental);
            		main.getCompo().add(Roles.Farmeurimmo);
            		main.getCompo().add(Roles.Kzou);
            		
                	main.updateScoreboard();
            		
            		player.sendMessage("Vous venez d'ajouter tous les rôles fonctionnel dans la compo");
            		
            	}
                

            }

        }

        return false;
    }

}
