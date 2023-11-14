package fr.gameblack.rcuhcv2.commands.global.host;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

public class CommandSetGroup implements CommandExecutor {

    private Main main;

    public CommandSetGroup(Main main) {
        this.main = main;
    }

    @SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

    	if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);
            
            if(args.length != 0) {
            
	            String nb = args[0];
	
	            if (main.getListHost().contains(joueur)) {
	            	
	            	for(Joueur j : main.getListJoueurs()) {
	            		
	            		System.out.println(j.getPlayer().getName());
	            		j.getPlayer().sendTitle("§cGroupe de " + nb, "Merci de respecter les groupes");
	            	
	            	}
	
	            } else {
	            	
	                player.sendMessage("Tu n'es pas l'host de la partie");
	
	            }
            
            } else {
            	
            	joueur.getPlayer().sendMessage("Merci de mettre un nombre");
            	
            }

        }

        return false;

    }

}
