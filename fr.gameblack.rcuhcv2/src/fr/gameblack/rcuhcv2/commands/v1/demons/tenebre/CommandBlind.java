package fr.gameblack.rcuhcv2.commands.v1.demons.tenebre;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v1.demons.Tenebre;

public class CommandBlind implements CommandExecutor {

    private Main main;

    public CommandBlind(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);

        if (args.length != 0) {

            Player cible_ = Bukkit.getPlayer(args[0]);

            if (cible_ != null) {

                if (joueur.getRole() == Roles.Tenebre) {

                	if (joueur.getCD().contains(Pouvoirs.TENEBRE_BLIND)) {
                		
                		joueur.getCD().add(Pouvoirs.TENEBRE_BLIND);
                		
                        Tenebre.CommandeBlind(joueur, cible_, main);

                	} else {

                		player.sendMessage("Cette commande est en cooldown");

                	}

                } else {

                    player.sendMessage("Vous n'avez pas le bon rôle");

                }

            } else {

                player.sendMessage("Merci de mettre un pseudo valide");

            }

        } else {

            player.sendMessage("Merci de mettre un pseudo (/rcsang <pseudo>)");

        }

        return false;
    }

}