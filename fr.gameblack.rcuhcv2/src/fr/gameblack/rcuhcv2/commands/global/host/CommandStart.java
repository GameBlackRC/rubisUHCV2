package fr.gameblack.rcuhcv2.commands.global.host;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.task.Autostart;

public class CommandStart implements CommandExecutor {

    private Main main;

    public CommandStart(Main main) {
        this.main = main;
    }

    @SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

    	if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);

            if (main.getListHost().contains(joueur)) {

                if (main.getState() == Statut.WAITING) {
                	
                	if(main.getVersion() != 0) {

	                    main.setState(Statut.STARTING);
	                    
	                    main.addIDGame();
	                    
	                    for(Joueur j : main.getListJoueurs()) {
	                    
	                    	j.getPlayer().sendTitle("§cAttention ", "Si vous n'avez pas le ressource pack, il est conseillé désactiver le son des créatures");
	
	                    }
	                    
	                    Bukkit.getScheduler().runTaskAsynchronously(main, () -> {
	
	                        Autostart start = new Autostart(main, main.getBoard_spec(), main.getBoard_pourcent());
	                        start.runTaskTimer(main, 0, 20);
	
	                    });
	                    
                	}
                	else {
                		
                		player.sendMessage("Vous n'avez pas choisis de versions");
                		
                	}

                } else {

                	player.sendMessage("La partie a déjà commencé");

                }

            } else {
            	
                player.sendMessage("Tu n'es pas l'host de la partie");

            }

        }

        return false;

    }

}
