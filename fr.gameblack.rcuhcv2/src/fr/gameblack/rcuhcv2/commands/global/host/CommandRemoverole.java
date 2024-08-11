package fr.gameblack.rcuhcv2.commands.global.host;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

public class CommandRemoverole implements CommandExecutor {

    private Main main;

    public CommandRemoverole(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);

            if (main.getListHost().contains(joueur)) {
            	
            	if(main.getVersion() == 2) {

	                if (args.length != 0 && args[0].equalsIgnoreCase("raptor")) {
	
	                    //FINI
	                	
	                    main.getCompo().remove(Roles.RAPTOR);
	                    player.sendMessage("Tu as retiré le rôle Raptor");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("yuri")) {
	                	
	                    main.getCompo().remove(Roles.YURI);
	                    player.sendMessage("Tu as retiré le rôle Yuri");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("jeannot")) {
	
	                    //KILL RC -> A FAIRE
	                	
	                    main.getCompo().remove(Roles.JEANNOT);
	                    player.sendMessage("Tu as retiré le rôle Jeannot");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("nickoboop")) {
	
	                    main.getCompo().remove(Roles.NICKOBOOP);
	                    player.sendMessage("Tu as retiré le rôle Nickoboop");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("slup")) {
	
	                    main.getCompo().remove(Roles.SLUP);
	                    player.sendMessage("Tu as retiré le rôle Slup");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("joko")) {
	
	                    //KILL SLUP -> A FAIRE
	                    //KILL MALEDICTION -> A FAIRE
	                    //KILL SANG -> A FAIRE
	                    //KILL TRONCONEUSE -> A FAIRE
	                	
	                    main.getCompo().remove(Roles.JOKO);
	                    player.sendMessage("Tu as retiré le rôle Joko");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("team")) {
	
	                    //FINI
	                	
	                    main.getCompo().remove(Roles.TEAM);
	                    player.sendMessage("Tu as retiré le rôle Team");
	
	                } else if ((args.length != 0 && args[0].equalsIgnoreCase("gameblack")) || (args.length != 0 && args[0].equalsIgnoreCase("game"))) {
	
	                    //ANTI KB -> A FAIRE
	                	
	                    main.getCompo().remove(Roles.GAMEBLACK);
	                    player.sendMessage("Tu as retiré le rôle GameBlack");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("maka")) {
	
	                    //FINI
	                	
	                    main.getCompo().remove(Roles.MAKA);
	                    player.sendMessage("Tu as retiré le rôle Maka");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("trial")) {
	
	                    //FINI
	                	
	                    main.getCompo().remove(Roles.TRIAL);
	                    player.sendMessage("Tu as retiré le rôle Trial");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("loup")) {
	
	                    main.getCompo().remove(Roles.LOUP);
	                    player.sendMessage("Tu as retiré le rôle Loup");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("captain")) {
	
	                    //ARMURE INVINCIBLE -> ?
	                	
	                    main.getCompo().remove(Roles.CAPTAIN);
	                    player.sendMessage("Tu as retiré le rôle Captain");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("hekow")) {
	
	                    //FINI
	                	
	                    main.getCompo().remove(Roles.HEKOW);
	                    player.sendMessage("Tu as retiré le rôle Hekow");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("malivol")) {
	
	                    //FINI
	                	
	                    main.getCompo().remove(Roles.MALIVOL);
	                    player.sendMessage("Tu as retiré le rôle Malivol");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("toinou")) {
	
	                    main.getCompo().remove(Roles.TOINOU);
	                    player.sendMessage("Tu as retiré le rôle Toinou");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("obscur")) {
	
	                    //GERER MORT -> A FAIRE
	                    //MORT DEF <3 coeurs -> A FAIRE
	                    //INF -> A FAIRE
	                	
	                    main.getCompo().remove(Roles.OBSCUR);
	                    player.sendMessage("Tu as retiré le rôle Obscur");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("nonoboy")) {
	
	                    //ZONE -> A FAIRE
	                    //KILL JOUEUR -> A FAIRE
	                	
	                    main.getCompo().remove(Roles.NONOBOY);
	                    player.sendMessage("Tu as retiré le rôle Nonoboy");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("theoochoux")) {
	
	                    //ZONE -> A FAIRE
	                    //KILL JOUEUR -> A FAIRE
	                	
	                    main.getCompo().add(Roles.THEOOCHOUX);
	                    player.sendMessage("Tu as retiré le rôle Theoochoux");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("romprems")) {
	
	                    //ZONE -> A FAIRE
	                    //KILL JOUEUR -> A FAIRE
	                	
	                    main.getCompo().add(Roles.ROMPREMS);
	                    player.sendMessage("Tu as retiré le rôle RomPrems");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("farmeurimmo")) {
	
	                    //CONNAIT 1 DEMON -> A FAIRE
	                	
	                    main.getCompo().remove(Roles.FARMEURIMMO);
	                    player.sendMessage("Tu as retiré le rôle Farmeurimmo");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("kzou")) {
	
	                    main.getCompo().remove(Roles.KZOU);
	                    player.sendMessage("Tu as retiré le rôle Kzou");
	
	                } else {
	
	                    player.sendMessage("Le rôle n'existe pas");
	
	                }
	                
                	main.updateScoreboard();
	                
            	}
            	else if(main.getVersion() == 1) {
            		
                    if (args.length != 0 && args[0].equalsIgnoreCase("gameblack")) {

                        //FINI

                        main.getCompo().remove(Roles.GameBlack);
                        player.sendMessage("Tu as retiré le rôle GameBlack");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("trial")) {

                        //KILL RC -> A FAIRE
                        main.getCompo().remove(Roles.Trial);
                        player.sendMessage("Tu as retiré le rôle Trial");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("team")) {

                        main.getCompo().remove(Roles.Team);
                        player.sendMessage("Tu as retiré le rôle Team");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("slup")) {

                        main.getCompo().remove(Roles.Slup);
                        player.sendMessage("Tu as retiré le rôle Slup");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("toinou")) {

                        //KILL SLUP -> A FAIRE
                        //KILL MALEDICTION -> A FAIRE
                        //KILL SANG -> A FAIRE
                        //KILL TRONCONEUSE -> A FAIRE
                        main.getCompo().remove(Roles.Toinou);
                        player.sendMessage("Tu as retiré le rôle Toinou");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("maka")) {

                        //FINI
                        main.getCompo().remove(Roles.Maka);
                        player.sendMessage("Tu as retiré le rôle Maka");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("malivol")) {

                        //ANTI KB -> A FAIRE
                        main.getCompo().remove(Roles.Malivol);
                        player.sendMessage("Tu as retiré le rôle Malivol");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("archer")) {

                        //FINI
                        main.getCompo().remove(Roles.Archer);
                        player.sendMessage("Tu as retiré le rôle Archer");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("guerrier")) {

                        //FINI
                        main.getCompo().remove(Roles.Guerrier);
                        player.sendMessage("Tu as retiré le rôle Guerrier");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("eclaireur")) {

                        main.getCompo().remove(Roles.Eclaireur);
                        player.sendMessage("Tu as retiré le rôle Eclaireur");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("joko")) {

                        //ARMURE INVINCIBLE -> ?
                        main.getCompo().remove(Roles.Joko);
                        player.sendMessage("Tu as retiré le rôle Joko");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("loup")) {

                        //FINI
                        main.getCompo().remove(Roles.Loup);
                        player.sendMessage("Tu as retiré le rôle Loup");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("raptor")) {

                        //FINI
                        main.getCompo().remove(Roles.Raptor);
                        player.sendMessage("Tu as retiré le rôle Raptor");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("ange")) {

                        main.getCompo().remove(Roles.Ange);
                        player.sendMessage("Tu as retiré le rôle Ange");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("avenir")) {

                        //GERER MORT -> A FAIRE
                        //MORT DEF <3 coeurs -> A FAIRE
                        //INF -> A FAIRE
                        main.getCompo().remove(Roles.Avenir);
                        player.sendMessage("Tu as retiré le rôle Avenir");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("cosmos")) {

                        //ZONE -> A FAIRE
                        //KILL JOUEUR -> A FAIRE
                        main.getCompo().remove(Roles.Cosmos);
                        player.sendMessage("Tu as retiré le rôle Cosmos");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("demon")) {

                        main.getCompo().remove(Roles.Demon);
                        player.sendMessage("Tu as retiré le rôle Démon");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("electrique")) {

                        main.getCompo().remove(Roles.Electrique);
                        player.sendMessage("Tu as retiré le rôle Electrique");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("enfer")) {

                        main.getCompo().remove(Roles.Enfer);
                        player.sendMessage("Tu as retiré le rôle Enfer");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("malediction")) {

                        //LANCER MALEDICTION -> A FAIRE
                        main.getCompo().remove(Roles.Malediction);
                        player.sendMessage("Tu as retiré le rôle Malédiction");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("sang")) {

                        main.getCompo().remove(Roles.Sang);
                        player.sendMessage("Tu as retiré le rôle Sang");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("tenebre")) {

                        main.getCompo().remove(Roles.Tenebre);
                        player.sendMessage("Tu as retiré le rôle Ténèbre");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("farmeurimmo")) {

                        main.getCompo().remove(Roles.Farmeurimmo);
                        player.sendMessage("Tu as retiré le rôle Farmeurimmo");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("kzou")) {

                        //CHANGER ROLE MORT -> A FAIRE
                        main.getCompo().remove(Roles.Kzou);
                        player.sendMessage("Tu as retiré le rôle Kzou");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("experimental")) {

                        //STUN -> A FAIRE
                        main.getCompo().remove(Roles.Experimental);
                        player.sendMessage("Tu as retiré le rôle Expérimental");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("tronconeuse")) {

                        //EFFET SAIGNEMENT
                        //MORT TRIAL
                        //POUVOIR AFFUTER SES LAMES -> A FAIRE
                        //ORBE ELEMENTAIRE -> A FAIRE
                        main.getCompo().remove(Roles.Tronconeuse);
                        player.sendMessage("Tu as retiré le rôle Tronconeuse");

                    } else if (args.length != 0 && args[0].equalsIgnoreCase("obscur")) {

                        main.getCompo().remove(Roles.Obscur);
                        player.sendMessage("Tu as retiré le rôle Obscur");

                    } else {

                        player.sendMessage("Le rôle n'existe pas");

                    }
                    
                	main.updateScoreboard();
            		
            	}

            }

        }

        return false;
    }

}
