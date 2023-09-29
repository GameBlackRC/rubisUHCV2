package fr.gameblack.rcuhcv2.commands.host;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.task.Autostart;

public class CommandStart implements CommandExecutor {

    private Main main;
    
    private Scoreboard board_base = Bukkit.getScoreboardManager().getNewScoreboard();
    
    private Scoreboard board_pourcent = Bukkit.getScoreboardManager().getNewScoreboard();

    public CommandStart(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

    	if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);

            if (main.getListHost().contains(joueur)) {

                if (main.getState() == Statut.WAITING) {

                    main.setState(Statut.STARTING);

                    Bukkit.getScheduler().runTaskAsynchronously(main, () -> {

                        Autostart start = new Autostart(main, board_base, board_pourcent);
                        start.runTaskTimer(main, 0, 20);

                    });

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
