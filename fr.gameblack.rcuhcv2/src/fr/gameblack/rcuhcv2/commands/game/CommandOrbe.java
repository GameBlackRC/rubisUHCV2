package fr.gameblack.rcuhcv2.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.orbes.Eau;
import fr.gameblack.rcuhcv2.orbes.Feu;
import fr.gameblack.rcuhcv2.orbes.Foudre;
import fr.gameblack.rcuhcv2.orbes.Glace;

public class CommandOrbe implements CommandExecutor {

    private Main main;

    public CommandOrbe(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);

            if (joueur.getOrbe() != Orbe.NONE) {

                if (joueur.isOrbeActif()) {

                    joueur.setStatutOrbe(false);

                    if (joueur.getOrbe() == Orbe.EAU) {

                        Eau.RemoveEffets(joueur, main);
                        player.sendMessage("Tu viens de désactiver ton orbe");

                    } else if (joueur.getOrbe() == Orbe.FEU) {

                        Feu.RemoveEffets(joueur, main);
                        player.sendMessage("Tu viens de désactiver ton orbe");

                    } else if (joueur.getOrbe() == Orbe.FOUDRE) {

                        Foudre.RemoveEffets(joueur, main);
                        player.sendMessage("Tu viens de désactiver ton orbe");

                    } else if (joueur.getOrbe() == Orbe.GLACE) {

                        Glace.RemoveEffets(joueur, main);
                        player.sendMessage("Tu viens de désactiver ton orbe");

                    }

                } else {

                	joueur.setStatutOrbe(true);

                    if (joueur.getOrbe() == Orbe.EAU && joueur.canActiveOrbe()) {

                        Eau.Effets(joueur, main);
                        player.sendMessage("Tu viens d'activer ton orbe");

                    } else if (joueur.getOrbe() == Orbe.FEU && joueur.canActiveOrbe()) {

                        Feu.Effets(joueur, main);
                        player.sendMessage("Tu viens d'activer ton orbe");

                    } else if (joueur.getOrbe() == Orbe.FOUDRE && joueur.canActiveOrbe()) {

                        Foudre.Effets(joueur, main);
                        player.sendMessage("Tu viens d'activer ton orbe");

                    } else if (joueur.getOrbe() == Orbe.GLACE && joueur.canActiveOrbe()) {

                        Glace.Effets(joueur, main);
                        player.sendMessage("Tu viens d'activer ton orbe");

                    }

                }

            } else {

                player.sendMessage("Tu ne possède pas d'orbe");

            }

        }

        return false;
    }

}
