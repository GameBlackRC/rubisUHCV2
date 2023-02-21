package fr.gameblack.rubisuhc.commands.game;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Orbe;
import fr.gameblack.rubisuhc.orbes.Eau;
import fr.gameblack.rubisuhc.orbes.Feu;
import fr.gameblack.rubisuhc.orbes.Foudre;
import fr.gameblack.rubisuhc.orbes.Glace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandOrbe implements CommandExecutor {

    private Main main;

    public CommandOrbe(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (main.getOrbe(player) != Orbe.NONE) {

                if (main.isOrbeActif(player)) {

                    main.changeStatutOrbe(player, false);

                    if (main.getOrbe(player) == Orbe.EAU) {

                        Eau.RemoveEffets(player, main);

                    } else if (main.getOrbe(player) == Orbe.FEU) {

                        Feu.RemoveEffets(player, main);

                    } else if (main.getOrbe(player) == Orbe.FOUDRE) {

                        Foudre.RemoveEffets(player, main);

                    } else if (main.getOrbe(player) == Orbe.GLACE) {

                        Glace.RemoveEffets(player, main);

                    }

                } else {

                    main.changeStatutOrbe(player, true);

                    if (main.getOrbe(player) == Orbe.EAU && !main.isOrbeMalus(player)) {

                        Eau.Effets(player, main);

                    } else if (main.getOrbe(player) == Orbe.FEU && !main.isOrbeMalus(player)) {

                        Feu.Effets(player, main);

                    } else if (main.getOrbe(player) == Orbe.FOUDRE && !main.isOrbeMalus(player)) {

                        Foudre.Effets(player, main);

                    } else if (main.getOrbe(player) == Orbe.GLACE && !main.isOrbeMalus(player)) {

                        Glace.Effets(player, main);

                    }

                }

            } else {

                player.sendMessage("Tu ne possède pas d'orbe");

            }

        }

        return false;
    }

}
