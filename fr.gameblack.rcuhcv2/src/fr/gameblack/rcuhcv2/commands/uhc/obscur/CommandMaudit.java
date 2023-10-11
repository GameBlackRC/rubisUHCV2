package fr.gameblack.rcuhcv2.commands.uhc.obscur;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.uhc.Obscur;

public class CommandMaudit implements CommandExecutor {

    private Main main;

    public CommandMaudit(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

    	Player player = (Player) sender;
    	
    	Joueur joueur = main.getJoueur(player);

        if (args.length >= 3) {

            Player cible1_ = Bukkit.getPlayer(args[0]);
            
            Joueur cible1 = main.getJoueur(cible1_);
            
            Player cible2_ = Bukkit.getPlayer(args[1]);
            
            Joueur cible2 = main.getJoueur(cible2_);
            
            int niveau = Integer.parseInt(args[2]);

            if (cible1 != null && cible2 != null && args[2] != null && niveau > 0 && niveau < 4) {

                if (joueur.getRole() == Roles.OBSCUR) {

                    if (main.getNiv_maledition() == 0) {
                    	
                    		Obscur.CommandMaudit(joueur, cible1, cible2, main, niveau);

                    } else {

                        player.sendMessage("Vous avez déjà une malédiction en cours");

                    }

                } else {

                    player.sendMessage("Vous n'avez pas le bon rôle");

                }

            } else {

                player.sendMessage("Merci de mettre un pseudo valide");

            }

        } else {

            player.sendMessage("Merci de donner le pseudo de la cible (/rcmaudit <pseudo1> <pseudo2> <1|2|3>");

        }

        return false;

    }

}
