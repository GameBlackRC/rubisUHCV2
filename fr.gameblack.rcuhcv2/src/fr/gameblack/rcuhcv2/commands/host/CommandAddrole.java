package fr.gameblack.rcuhcv2.commands.host;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;

public class CommandAddrole implements CommandExecutor {

    private Main main;

    public CommandAddrole(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);

            if (main.getListHost().contains(joueur)) {

                if (args.length != 0 && args[0].equalsIgnoreCase("raptor")) {

                    //FINI
                	
                    main.getCompo().add(Roles.RAPTOR);
                    player.sendMessage("Tu as ajouté le rôle Raptor");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("jeannot")) {

                    //KILL RC -> A FAIRE
                	
                    main.getCompo().add(Roles.JEANNOT);
                    player.sendMessage("Tu as ajouté le rôle Jeannot");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("nickoboop")) {

                    main.getCompo().add(Roles.NICKOBOOP);
                    player.sendMessage("Tu as ajouté le rôle Nickoboop");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("slup")) {

                    main.getCompo().add(Roles.SLUP);
                    player.sendMessage("Tu as ajouté le rôle Slup");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("joko")) {

                    //KILL SLUP -> A FAIRE
                    //KILL MALEDICTION -> A FAIRE
                    //KILL SANG -> A FAIRE
                    //KILL TRONCONEUSE -> A FAIRE
                	
                    main.getCompo().add(Roles.JOKO);
                    player.sendMessage("Tu as ajouté le rôle Joko");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("team")) {

                    //FINI
                	
                    main.getCompo().add(Roles.TEAM);
                    player.sendMessage("Tu as ajouté le rôle Team");

                } else if ((args.length != 0 && args[0].equalsIgnoreCase("gameblack")) || (args.length != 0 && args[0].equalsIgnoreCase("game"))) {

                    //ANTI KB -> A FAIRE
                	
                    main.getCompo().add(Roles.GAMEBLACK);
                    player.sendMessage("Tu as ajouté le rôle GameBlack");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("maka")) {

                    //FINI
                	
                    main.getCompo().add(Roles.MAKA);
                    player.sendMessage("Tu as ajouté le rôle Maka");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("trial")) {

                    //FINI
                	
                    main.getCompo().add(Roles.TRIAL);
                    player.sendMessage("Tu as ajouté le rôle Trial");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("loup")) {

                    main.getCompo().add(Roles.LOUP);
                    player.sendMessage("Tu as ajouté le rôle Loup");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("captain")) {

                    //ARMURE INVINCIBLE -> ?
                	
                    main.getCompo().add(Roles.CAPTAIN);
                    player.sendMessage("Tu as ajouté le rôle Captain");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("hekow")) {

                    //FINI
                	
                    main.getCompo().add(Roles.HEKOW);
                    player.sendMessage("Tu as ajouté le rôle Hekow");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("malivol")) {

                    //FINI
                	
                    main.getCompo().add(Roles.MALIVOL);
                    player.sendMessage("Tu as ajouté le rôle Malivol");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("toinou")) {

                    main.getCompo().add(Roles.TOINOU);
                    player.sendMessage("Tu as ajouté le rôle Toinou");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("obscur")) {

                    //GERER MORT -> A FAIRE
                    //MORT DEF <3 coeurs -> A FAIRE
                    //INF -> A FAIRE
                	
                    main.getCompo().add(Roles.OBSCUR);
                    player.sendMessage("Tu as ajouté le rôle Obscur");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("nonoboy")) {

                    //ZONE -> A FAIRE
                    //KILL JOUEUR -> A FAIRE
                	
                    main.getCompo().add(Roles.NONOBOY);
                    player.sendMessage("Tu as ajouté le rôle Nonoboy");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("farmeurimmo")) {

                    //CONNAIT 1 DEMON -> A FAIRE
                	
                    main.getCompo().add(Roles.FARMEURIMMO);
                    player.sendMessage("Tu as ajouté le rôle Farmeurimmo");

                } else if (args.length != 0 && args[0].equalsIgnoreCase("kzou")) {

                    main.getCompo().add(Roles.KZOU);
                    player.sendMessage("Tu as ajouté le rôle Kzou");

                } else {

                    player.sendMessage("Non");

                }

            }

        }

        return false;
    }

}
