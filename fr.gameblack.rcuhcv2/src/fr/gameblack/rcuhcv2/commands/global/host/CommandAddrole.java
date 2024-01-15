package fr.gameblack.rcuhcv2.commands.global.host;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

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
	        	
	        	if(main.getVersion() == 2) {
	
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
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("theoochoux")) {
	
	                    //ZONE -> A FAIRE
	                    //KILL JOUEUR -> A FAIRE
	                	
	                    main.getCompo().add(Roles.THEOOCHOUX);
	                    player.sendMessage("Tu as ajouté le rôle Theoochoux");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("romprems")) {
	
	                    //ZONE -> A FAIRE
	                    //KILL JOUEUR -> A FAIRE
	                	
	                    main.getCompo().add(Roles.ROMPREMS);
	                    player.sendMessage("Tu as ajouté le rôle RomPrems");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("farmeurimmo")) {
	
	                    //CONNAIT 1 DEMON -> A FAIRE
	                	
	                    main.getCompo().add(Roles.FARMEURIMMO);
	                    player.sendMessage("Tu as ajouté le rôle Farmeurimmo");
	
	                } else if (args.length != 0 && args[0].equalsIgnoreCase("kzou")) {
	
	                    main.getCompo().add(Roles.KZOU);
	                    player.sendMessage("Tu as ajouté le rôle Kzou");
	
	                } else {
	
	                    player.sendMessage("Le rôle n'existe pas");
	
	                }
	                
                	main.updateScoreboard();
	
	            } else if(main.getVersion() == 1) {
	            	
	                if (args.length != 0 && args[0].equalsIgnoreCase("gameblack")) {

	                    //FINI

	                    main.getCompo().add(Roles.GameBlack);
	                    player.sendMessage("Tu as ajouté le rôle GameBlack");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("trial")) {

	                    //KILL RC -> A FAIRE
	                    main.getCompo().add(Roles.Trial);
	                    player.sendMessage("Tu as ajouté le rôle Trial");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("team")) {

	                    main.getCompo().add(Roles.Team);
	                    player.sendMessage("Tu as ajouté le rôle Team");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("slup")) {

	                    main.getCompo().add(Roles.Slup);
	                    player.sendMessage("Tu as ajouté le rôle Slup");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("toinou")) {

	                    //KILL SLUP -> A FAIRE
	                    //KILL MALEDICTION -> A FAIRE
	                    //KILL SANG -> A FAIRE
	                    //KILL TRONCONEUSE -> A FAIRE
	                    main.getCompo().add(Roles.Toinou);
	                    player.sendMessage("Tu as ajouté le rôle Toinou");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("maka")) {

	                    //FINI
	                    main.getCompo().add(Roles.Maka);
	                    player.sendMessage("Tu as ajouté le rôle Maka");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("malivol")) {

	                    //ANTI KB -> A FAIRE
	                    main.getCompo().add(Roles.Malivol);
	                    player.sendMessage("Tu as ajouté le rôle Malivol");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("archer")) {

	                    //FINI
	                    main.getCompo().add(Roles.Archer);
	                    player.sendMessage("Tu as ajouté le rôle Archer");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("guerrier")) {

	                    //FINI
	                    main.getCompo().add(Roles.Guerrier);
	                    player.sendMessage("Tu as ajouté le rôle Guerrier");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("eclaireur")) {

	                    main.getCompo().add(Roles.Eclaireur);
	                    player.sendMessage("Tu as ajouté le rôle Eclaireur");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("joko")) {

	                    //ARMURE INVINCIBLE -> ?
	                    main.getCompo().add(Roles.Joko);
	                    player.sendMessage("Tu as ajouté le rôle Joko");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("loup")) {

	                    //FINI
	                    main.getCompo().add(Roles.Loup);
	                    player.sendMessage("Tu as ajouté le rôle Loup");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("raptor")) {

	                    //FINI
	                    main.getCompo().add(Roles.Raptor);
	                    player.sendMessage("Tu as ajouté le rôle Raptor");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("ange")) {

	                    main.getCompo().add(Roles.Ange);
	                    player.sendMessage("Tu as ajouté le rôle Ange");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("avenir")) {

	                    //GERER MORT -> A FAIRE
	                    //MORT DEF <3 coeurs -> A FAIRE
	                    //INF -> A FAIRE
	                    main.getCompo().add(Roles.Avenir);
	                    player.sendMessage("Tu as ajouté le rôle Avenir");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("cosmos")) {

	                    //ZONE -> A FAIRE
	                    //KILL JOUEUR -> A FAIRE
	                    main.getCompo().add(Roles.Cosmos);
	                    player.sendMessage("Tu as ajouté le rôle Cosmos");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("demon")) {

	                    //CONNAIT 1 DEMON -> A FAIRE
	                    main.getCompo().add(Roles.Demon);
	                    player.sendMessage("Tu as ajouté le rôle Démon");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("electrique")) {

	                    main.getCompo().add(Roles.Electrique);
	                    player.sendMessage("Tu as ajouté le rôle Electrique");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("enfer")) {

	                    main.getCompo().add(Roles.Enfer);
	                    player.sendMessage("Tu as ajouté le rôle Enfer");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("malediction")) {

	                    //LANCER MALEDICTION -> A FAIRE
	                    main.getCompo().add(Roles.Malediction);
	                    player.sendMessage("Tu as ajouté le rôle Malediction");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("sang")) {

	                    main.getCompo().add(Roles.Sang);
	                    player.sendMessage("Tu as ajouté le rôle Sang");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("tenebre")) {

	                    main.getCompo().add(Roles.Tenebre);
	                    player.sendMessage("Tu as ajouté le rôle Tenebre");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("farmeurimmo")) {

	                    main.getCompo().add(Roles.Farmeurimmo);
	                    player.sendMessage("Tu as ajouté le rôle Farmeurimmo");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("kzou")) {

	                    //CHANGER ROLE MORT -> A FAIRE
	                    main.getCompo().add(Roles.Kzou);
	                    player.sendMessage("Tu as ajouté le rôle Kzou");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("experimental")) {

	                    //STUN -> A FAIRE
	                    main.getCompo().add(Roles.Experimental);
	                    player.sendMessage("Tu as ajouté le rôle Expérimental");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("tronconeuse")) {

	                    //EFFET SAIGNEMENT
	                    //MORT TRIAL
	                    //POUVOIR AFFUTER SES LAMES -> A FAIRE
	                    //ORBE ELEMENTAIRE -> A FAIRE
	                    main.getCompo().add(Roles.Tronconeuse);
	                    player.sendMessage("Tu as ajouté le rôle Tronconeuse");

	                } else if (args.length != 0 && args[0].equalsIgnoreCase("obscur")) {

	                    main.getCompo().add(Roles.Obscur);
	                    player.sendMessage("Tu as ajouté le rôle Obscur");

	                } else {

	                    player.sendMessage("Non");

	                }
	                
                	main.updateScoreboard();
	            	
	            }
	            
        	}

        }

        return false;
    }

}
