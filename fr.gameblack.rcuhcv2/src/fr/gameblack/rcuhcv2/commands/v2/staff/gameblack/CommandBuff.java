package fr.gameblack.rcuhcv2.commands.v2.staff.gameblack;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.Pouvoirs_GB;
import fr.gameblack.rcuhcv2.roles.v1.rc.GameBlackV1;
import fr.gameblack.rcuhcv2.roles.v2.staff.GameBlack;

public class CommandBuff implements CommandExecutor {
	
private Main main;
	
	public CommandBuff(Main main) {
		
		this.main = main;
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player && args.length > 1) {
        	
        	Player player = (Player) sender;
        	Joueur joueur = main.getJoueur(player);
        	
        	if(main.getVersion() == 2) {

	        	Player cible_ = Bukkit.getPlayer(args[0]);
	        	Joueur cible = main.getJoueur(cible_);
	        	
	        	String buff = args[1];
	
	            if (cible_ != null && (joueur.getRole() == Roles.GAMEBLACK && joueur.getModeTrial() == "serieux")) {
	            	
	            	if(buff.equalsIgnoreCase("coeur") || buff.equalsIgnoreCase("force") || buff.equalsIgnoreCase("speed") || buff.equalsIgnoreCase("resi")) {
	                	
	            		GameBlack.CommandeBuff(joueur, cible, msg, main);
	            	
	            	}
	            	
	            }
	            
        	}
        	else if(main.getVersion() == 1) {
        		
                if (args.length > 1) {

                    Player cible_ = Bukkit.getPlayer(args[0]);
                    
                    int nb = Integer.parseInt(args[1]);

                    if (cible_ != null) {

                        if (joueur.getRole() == Roles.GameBlack) {

                                if (joueur.getPouvoirGB() == Pouvoirs_GB.POURCENT) {
                                	
                                	Joueur cible = main.getJoueur(cible_);

                                	GameBlackV1.CommandBuff(player, cible, main, nb);

                                } else {

                                    player.sendMessage("Vous n'avez pas le pouvoir 'Pourcent'");

                                }

                        } else {

                            player.sendMessage("Vous n'avez pas le bon rôle");

                        }

                    } else {

                        player.sendMessage("Merci de mettre un pseudo et un nombre valide");

                    }

                } else {

                    player.sendMessage("Merci de donner le pseudo de la cible (/rcbuff <pseudo> <nombre>");

                }
        		
        	}

        }

        return false;
    }

}
