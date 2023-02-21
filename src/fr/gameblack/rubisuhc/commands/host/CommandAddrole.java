package fr.gameblack.rubisuhc.commands.host;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;

public class CommandAddrole implements CommandExecutor {
	
	private Main main;

	public CommandAddrole(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
		
			Player player = (Player)sender;
			
			if(main.getHost() == player) {
	
				if(args.length != 0 && args[0].equalsIgnoreCase("gameblack")) {
					
					//FINI
					
					main.getRoleGame().add(Roles.GAMEBLACK);
					main.getCompo().add(Roles.GAMEBLACK);
					player.sendMessage("Tu as ajouté le rôle GameBlack");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("trial")) {
					
					//KILL RC -> A FAIRE
					main.getRoleGame().add(Roles.TRIAL);
					main.getCompo().add(Roles.TRIAL);
					player.sendMessage("Tu as ajouté le rôle Trial");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("team")) {
					
					main.getRoleGame().add(Roles.TEAM);
					main.getCompo().add(Roles.TEAM);
					player.sendMessage("Tu as ajouté le rôle Team");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("slup")) {
					
					main.getRoleGame().add(Roles.SLUP);
					main.getCompo().add(Roles.SLUP);
					player.sendMessage("Tu as ajouté le rôle Slup");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("toinou")) {
					
					//KILL SLUP -> A FAIRE
					//KILL MALEDICTION -> A FAIRE
					//KILL SANG -> A FAIRE
					//KILL TRONCONEUSE -> A FAIRE
					main.getRoleGame().add(Roles.TOINOU);
					main.getCompo().add(Roles.TOINOU);
					player.sendMessage("Tu as ajouté le rôle Toinou");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("maka")) {
					
					//FINI
					main.getRoleGame().add(Roles.MAKA);
					main.getCompo().add(Roles.MAKA);
					player.sendMessage("Tu as ajouté le rôle Maka");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("malivol")) {
					
					//ANTI KB -> A FAIRE
					main.getRoleGame().add(Roles.MALIVOL);
					main.getCompo().add(Roles.MALIVOL);
					player.sendMessage("Tu as ajouté le rôle Malivol");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("archer")) {
					
					//FINI
					main.getRoleGame().add(Roles.ARCHER);
					main.getCompo().add(Roles.ARCHER);
					player.sendMessage("Tu as ajouté le rôle Archer");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("guerrier")) {
					
					//FINI
					main.getRoleGame().add(Roles.GUERRIER);
					main.getCompo().add(Roles.GUERRIER);
					player.sendMessage("Tu as ajouté le rôle Guerrier");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("eclaireur")) {
					
					main.getRoleGame().add(Roles.ECLAIREUR);
					main.getCompo().add(Roles.ECLAIREUR);
					player.sendMessage("Tu as ajouté le rôle Eclaireur");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("joko")) {
					
					//ARMURE INVINCIBLE -> ?
					main.getRoleGame().add(Roles.JOKO);
					main.getCompo().add(Roles.JOKO);
					player.sendMessage("Tu as ajouté le rôle Joko");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("loup")) {
					
					//FINI
					main.getRoleGame().add(Roles.LOUP);
					main.getCompo().add(Roles.LOUP);
					player.sendMessage("Tu as ajouté le rôle Loup");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("raptor")) {
					
					//FINI
					main.getRoleGame().add(Roles.RAPTOR);
					main.getCompo().add(Roles.RAPTOR);
					player.sendMessage("Tu as ajouté le rôle Raptor");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("ange")) {
					
					main.getRoleGame().add(Roles.ANGE);
					main.getCompo().add(Roles.ANGE);
					player.sendMessage("Tu as ajouté le rôle Ange");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("avenir")) {
					
					//GERER MORT -> A FAIRE
					//MORT DEF <3 coeurs -> A FAIRE
					//INF -> A FAIRE
					main.getRoleGame().add(Roles.AVENIR);
					main.getCompo().add(Roles.AVENIR);
					player.sendMessage("Tu as ajouté le rôle Avenir");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("cosmos")) {
					
					//ZONE -> A FAIRE
					//KILL JOUEUR -> A FAIRE
					main.getRoleGame().add(Roles.COSMOS);
					main.getCompo().add(Roles.COSMOS);
					player.sendMessage("Tu as ajouté le rôle Cosmos");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("demon")) {
					
					//CONNAIT 1 DEMON -> A FAIRE
					main.getRoleGame().add(Roles.DEMON);
					main.getCompo().add(Roles.DEMON);
					player.sendMessage("Tu as ajouté le rôle Démon");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("electrique")) {
					
					main.getRoleGame().add(Roles.ELECTRIQUE);
					main.getCompo().add(Roles.ELECTRIQUE);
					player.sendMessage("Tu as ajouté le rôle Electrique");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("enfer")) {
					
					main.getRoleGame().add(Roles.ENFER);
					main.getCompo().add(Roles.ENFER);
					player.sendMessage("Tu as ajouté le rôle Enfer");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("malediction")) {
					
					//LANCER MALEDICTION -> A FAIRE
					main.getRoleGame().add(Roles.MALEDICTION);
					main.getCompo().add(Roles.MALEDICTION);
					player.sendMessage("Tu as ajouté le rôle Malediction");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("sang")) {
					
					main.getRoleGame().add(Roles.SANG);
					main.getCompo().add(Roles.SANG);
					player.sendMessage("Tu as ajouté le rôle Sang");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("tenebre")) {
					
					main.getRoleGame().add(Roles.TENEBRE);
					main.getCompo().add(Roles.TENEBRE);
					player.sendMessage("Tu as ajouté le rôle Tenebre");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("farmeurimmo")) {
					
					main.getRoleGame().add(Roles.FARMEURIMMO);
					main.getCompo().add(Roles.FARMEURIMMO);
					player.sendMessage("Tu as ajouté le rôle Farmeurimmo");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("kzou")) {
					
					//CHANGER ROLE MORT -> A FAIRE
					main.getRoleGame().add(Roles.KZOU);
					main.getCompo().add(Roles.KZOU);
					player.sendMessage("Tu as ajouté le rôle Kzou");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("experimental")) {
					
					//STUN -> A FAIRE
					main.getRoleGame().add(Roles.EXPERIMENTAL);
					main.getCompo().add(Roles.EXPERIMENTAL);
					player.sendMessage("Tu as ajouté le rôle Expérimental");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("tronconeuse")) {
					
					//EFFET SAIGNEMENT
					//MORT TRIAL
					//POUVOIR AFFUTER SES LAMES -> A FAIRE
					//ORBE ELEMENTAIRE -> A FAIRE
					main.getRoleGame().add(Roles.TRONCONEUSE);
					main.getCompo().add(Roles.TRONCONEUSE);
					player.sendMessage("Tu as ajouté le rôle Tronconeuse");
					
				}
				else if(args.length != 0 && args[0].equalsIgnoreCase("obscur")) {
					
					main.getRoleGame().add(Roles.OBSCUR);
					main.getCompo().add(Roles.OBSCUR);
					player.sendMessage("Tu as ajouté le rôle Obscur");
					
				}
				else {
					
					player.sendMessage("Non");
					
				}
				
			}
			
		}
		
		return false;
	}

}