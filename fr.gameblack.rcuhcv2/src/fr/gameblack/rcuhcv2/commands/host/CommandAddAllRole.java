package fr.gameblack.rcuhcv2.commands.host;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;

public class CommandAddAllRole implements CommandExecutor {

    private Main main;

    public CommandAddAllRole(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);

            if (main.getListHost().contains(joueur)) {
            	
                main.getCompo().add(Roles.RAPTOR);
                main.getCompo().add(Roles.JEANNOT);
                main.getCompo().add(Roles.NICKOBOOP);
                main.getCompo().add(Roles.SLUP);
                main.getCompo().add(Roles.JOKO);
                main.getCompo().add(Roles.GAMEBLACK);
                main.getCompo().add(Roles.TRIAL);
                main.getCompo().add(Roles.LOUP);
                main.getCompo().add(Roles.MALIVOL);
                main.getCompo().add(Roles.FARMEURIMMO);
                

            }

        }

        return false;
    }

}
