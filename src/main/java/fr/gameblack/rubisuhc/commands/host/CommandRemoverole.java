package fr.gameblack.rubisuhc.commands.host;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRemoverole implements CommandExecutor {

    private Main main;

    public CommandRemoverole(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (main.getHost() == player) {

                if (args.length != 0 && args[0].equalsIgnoreCase("gameblack")) {

                    //FINI

                    main.getRoleGame().remove(Roles.GAMEBLACK);
                    main.getCompo().remove(Roles.GAMEBLACK);
                    player.sendMessage("Tu as retiré le rôle GameBlack");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("trial")) {

                    //KILL RC -> A FAIRE
                    main.getRoleGame().remove(Roles.TRIAL);
                    main.getCompo().remove(Roles.TRIAL);
                    player.sendMessage("Tu as retiré le rôle Trial");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("team")) {

                    main.getRoleGame().remove(Roles.TEAM);
                    main.getCompo().remove(Roles.TEAM);
                    player.sendMessage("Tu as retiré le rôle Team");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("slup")) {

                    main.getRoleGame().remove(Roles.SLUP);
                    main.getCompo().remove(Roles.SLUP);
                    player.sendMessage("Tu as retiré le rôle Slup");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("toinou")) {

                    //KILL SLUP -> A FAIRE
                    //KILL MALEDICTION -> A FAIRE
                    //KILL SANG -> A FAIRE
                    //KILL TRONCONEUSE -> A FAIRE
                    main.getRoleGame().remove(Roles.TOINOU);
                    main.getCompo().remove(Roles.TOINOU);
                    player.sendMessage("Tu as retiré le rôle Toinou");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("maka")) {

                    //FINI
                    main.getRoleGame().remove(Roles.MAKA);
                    main.getCompo().remove(Roles.MAKA);
                    player.sendMessage("Tu as retiré le rôle Maka");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("malivol")) {

                    //ANTI KB -> A FAIRE
                    main.getRoleGame().remove(Roles.MALIVOL);
                    main.getCompo().remove(Roles.MALIVOL);
                    player.sendMessage("Tu as retiré le rôle Malivol");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("archer")) {

                    //FINI
                    main.getRoleGame().remove(Roles.ARCHER);
                    main.getCompo().remove(Roles.ARCHER);
                    player.sendMessage("Tu as retiré le rôle Archer");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("guerrier")) {

                    //FINI
                    main.getRoleGame().remove(Roles.GUERRIER);
                    main.getCompo().remove(Roles.GUERRIER);
                    player.sendMessage("Tu as retiré le rôle Guerrier");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("eclaireur")) {

                    main.getRoleGame().remove(Roles.ECLAIREUR);
                    main.getCompo().remove(Roles.ECLAIREUR);
                    player.sendMessage("Tu as retiré le rôle Eclaireur");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("joko")) {

                    //ARMURE INVINCIBLE -> ?
                    main.getRoleGame().remove(Roles.JOKO);
                    main.getCompo().remove(Roles.JOKO);
                    player.sendMessage("Tu as retiré le rôle Joko");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("loup")) {

                    //FINI
                    main.getRoleGame().remove(Roles.LOUP);
                    main.getCompo().remove(Roles.LOUP);
                    player.sendMessage("Tu as retiré le rôle Loup");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("raptor")) {

                    //FINI
                    main.getRoleGame().remove(Roles.RAPTOR);
                    main.getCompo().remove(Roles.RAPTOR);
                    player.sendMessage("Tu as retiré le rôle Raptor");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("ange")) {

                    main.getRoleGame().remove(Roles.ANGE);
                    main.getCompo().remove(Roles.ANGE);
                    player.sendMessage("Tu as retiré le rôle Ange");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("avenir")) {

                    //GERER MORT -> A FAIRE
                    //MORT DEF <3 coeurs -> A FAIRE
                    //INF -> A FAIRE
                    main.getRoleGame().remove(Roles.AVENIR);
                    main.getCompo().remove(Roles.AVENIR);
                    player.sendMessage("Tu as retiré le rôle Avenir");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("cosmos")) {

                    //ZONE -> A FAIRE
                    //KILL JOUEUR -> A FAIRE
                    main.getRoleGame().remove(Roles.COSMOS);
                    main.getCompo().remove(Roles.COSMOS);
                    player.sendMessage("Tu as retiré le rôle Cosmos");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("demon")) {

                    main.getRoleGame().remove(Roles.DEMON);
                    main.getCompo().remove(Roles.DEMON);
                    player.sendMessage("Tu as retiré le rôle Démon");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("electrique")) {

                    main.getRoleGame().remove(Roles.ELECTRIQUE);
                    main.getCompo().remove(Roles.ELECTRIQUE);
                    player.sendMessage("Tu as retiré le rôle Electrique");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("enfer")) {

                    main.getRoleGame().remove(Roles.ENFER);
                    main.getCompo().remove(Roles.ENFER);
                    player.sendMessage("Tu as retiré le rôle Enfer");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("malediction")) {

                    //LANCER MALEDICTION -> A FAIRE
                    main.getRoleGame().remove(Roles.MALEDICTION);
                    main.getCompo().remove(Roles.MALEDICTION);
                    player.sendMessage("Tu as retiré le rôle Malédiction");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("sang")) {

                    main.getRoleGame().remove(Roles.SANG);
                    main.getCompo().remove(Roles.SANG);
                    player.sendMessage("Tu as retiré le rôle Sang");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("tenebre")) {

                    main.getRoleGame().remove(Roles.TENEBRE);
                    main.getCompo().remove(Roles.TENEBRE);
                    player.sendMessage("Tu as retiré le rôle Ténèbre");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("farmeurimmo")) {

                    main.getRoleGame().remove(Roles.FARMEURIMMO);
                    main.getCompo().remove(Roles.FARMEURIMMO);
                    player.sendMessage("Tu as retiré le rôle Farmeurimmo");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("kzou")) {

                    //CHANGER ROLE MORT -> A FAIRE
                    main.getRoleGame().remove(Roles.KZOU);
                    main.getCompo().remove(Roles.KZOU);
                    player.sendMessage("Tu as retiré le rôle Kzou");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("experimental")) {

                    //STUN -> A FAIRE
                    main.getRoleGame().remove(Roles.EXPERIMENTAL);
                    main.getCompo().remove(Roles.EXPERIMENTAL);
                    player.sendMessage("Tu as retiré le rôle Expérimental");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("tronconeuse")) {

                    //EFFET SAIGNEMENT
                    //MORT TRIAL
                    //POUVOIR AFFUTER SES LAMES -> A FAIRE
                    //ORBE ELEMENTAIRE -> A FAIRE
                    main.getRoleGame().remove(Roles.TRONCONEUSE);
                    main.getCompo().remove(Roles.TRONCONEUSE);
                    player.sendMessage("Tu as retiré le rôle Tronconeuse");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("obscur")) {

                    main.getRoleGame().remove(Roles.OBSCUR);
                    main.getCompo().remove(Roles.OBSCUR);
                    player.sendMessage("Tu as retiré le rôle Obscur");

                } else {

                    player.sendMessage("Non");

                }

            }

        }

        return false;
    }

}