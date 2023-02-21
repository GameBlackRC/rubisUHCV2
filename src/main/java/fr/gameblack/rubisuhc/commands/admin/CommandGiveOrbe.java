package fr.gameblack.rubisuhc.commands.admin;

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

public class CommandGiveOrbe implements CommandExecutor {

    private Main main;

    public CommandGiveOrbe(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;

        if (args.length != 0 && args[0].equalsIgnoreCase("eau")) {

            if (main.getOrbe(player) == Orbe.EAU) {

                Eau.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.FEU) {

                Feu.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.FOUDRE) {

                Foudre.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.GLACE) {

                Glace.RemoveEffets(player, main);

            }

            main.setOrbe(player, Orbe.EAU);
            Eau.Effets(player, main);

        } else if (args.length != 0 && args[0].equalsIgnoreCase("feu")) {

            if (main.getOrbe(player) == Orbe.EAU) {

                Eau.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.FEU) {

                Feu.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.FOUDRE) {

                Foudre.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.GLACE) {

                Glace.RemoveEffets(player, main);

            }

            main.setOrbe(player, Orbe.FEU);
            Feu.Effets(player, main);

        } else if (args.length != 0 && args[0].equalsIgnoreCase("glace")) {

            if (main.getOrbe(player) == Orbe.EAU) {

                Eau.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.FEU) {

                Feu.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.FOUDRE) {

                Foudre.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.GLACE) {

                Glace.RemoveEffets(player, main);

            }

            main.setOrbe(player, Orbe.GLACE);
            Glace.Effets(player, main);

        } else if (args.length != 0 && args[0].equalsIgnoreCase("foudre")) {

            if (main.getOrbe(player) == Orbe.EAU) {

                Eau.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.FEU) {

                Feu.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.FOUDRE) {

                Foudre.RemoveEffets(player, main);

            } else if (main.getOrbe(player) == Orbe.GLACE) {

                Glace.RemoveEffets(player, main);

            }

            main.setOrbe(player, Orbe.FOUDRE);
            Foudre.Effets(player, main);

        }

        return false;
    }

}