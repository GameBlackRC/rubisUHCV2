package fr.gameblack.rcuhcv2.commands.v1.rc.maka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v1.rc.MakaV1;

public class CommandDon implements CommandExecutor {

    private Main main;

    public CommandDon(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        
        Joueur joueur = main.getJoueur(player);

        if (args.length != 0) {

            Player cible_ = Bukkit.getPlayer(args[0]);

            if (cible_ != null) {
            	
            	Joueur cible = main.getJoueur(cible_);

                if (joueur.getRole() == Roles.GameBlack) {

                    if (!joueur.getCD().contains(Pouvoirs.MAKA_DON)) {

                        MakaV1.CommandDon(joueur, cible, main);

                    } else {

                        player.sendMessage("Vous avez déjà utiliser cette commande durant cet épisode");

                    }

                } else {

                    player.sendMessage("Vous n'avez pas le bon rôle");

                }

            } else {

                player.sendMessage("Merci de mettre un pseudo valide");

            }

        } else {

            player.sendMessage("Merci de donner le pseudo de la cible (/rcnerf <pseudo>");

        }

        return false;
    }

}