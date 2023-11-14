package fr.gameblack.rcuhcv2.commands.global.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

public class CommandSetRole implements CommandExecutor {
	
	private Main main;
	
	public CommandSetRole(Main main) {
		
		this.main = main;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//if(main.isV2Actif()) {
		
			Player player = (Player) sender;
			Joueur joueur = main.getJoueur(player);
	
	        player.setMaxHealth(20);
	        if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
	            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	        if (player.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE))
	            player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
	        if (player.hasPotionEffect(PotionEffectType.HEALTH_BOOST))
	            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
	        if (player.hasPotionEffect(PotionEffectType.SPEED)) player.removePotionEffect(PotionEffectType.SPEED);
	        if (player.hasPotionEffect(PotionEffectType.WEAKNESS)) player.removePotionEffect(PotionEffectType.WEAKNESS);
	        if (player.hasPotionEffect(PotionEffectType.SLOW)) player.removePotionEffect(PotionEffectType.SLOW);
	        if (player.hasPotionEffect(PotionEffectType.FAST_DIGGING))
	            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
	        if (player.hasPotionEffect(PotionEffectType.JUMP)) player.removePotionEffect(PotionEffectType.JUMP);
	        if (player.hasPotionEffect(PotionEffectType.SLOW_DIGGING))
	            player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
	
	        if (args.length != 0 && args[0].equalsIgnoreCase("farmeurimmo")) {
	
	            joueur.setRole(Roles.FARMEURIMMO, main);
	            player.sendMessage("Vous êtes désormais le rôle §cFarmeurimmo");
	            
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("test")) {
	
	            joueur.setRole(Roles.TEST, main);
	            player.sendMessage("Vous êtes désormais le rôle Test");
	            
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("malivol")) {
	        	
	        	joueur.setRole(Roles.MALIVOL, main);
	        	player.sendMessage("Vous êtes désormais le rôle §2Malivol");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("raptor")) {
	        	
	        	joueur.setRole(Roles.RAPTOR, main);
	        	player.sendMessage("Vous êtes désormais le rôle §aRaptor");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("jeannot")) {
	        	
	        	joueur.setRole(Roles.JEANNOT, main);
	        	player.sendMessage("Vous êtes désormais le rôle §aJeannot");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("nickoboop")) {
	        	
	        	joueur.setRole(Roles.NICKOBOOP, main);
	        	player.sendMessage("Vous êtes désormais le rôle §aNickoboop");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("slup")) {
	        	
	        	joueur.setRole(Roles.SLUP, main);
	        	player.sendMessage("Vous êtes désormais le rôle §aSlup");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("joko")) {
	        	
	        	joueur.setRole(Roles.JOKO, main);
	        	player.sendMessage("Vous êtes désormais le rôle §aJoko");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("team")) {
	        	
	        	joueur.setRole(Roles.TEAM, main);
	        	player.sendMessage("Vous êtes désormais le rôle §9Team");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("gameblack")) {
	        	
	        	joueur.setRole(Roles.GAMEBLACK, main);
	        	player.sendMessage("Vous êtes désormais le rôle §9GameBlack");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("maka")) {
	        	
	        	joueur.setRole(Roles.MAKA, main);
	        	player.sendMessage("Vous êtes désormais le rôle §9Maka");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("trial")) {
	        	
	        	joueur.setRole(Roles.TRIAL, main);
	        	player.sendMessage("Vous êtes désormais le rôle §9Trial");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("loup")) {
	        	
	        	joueur.setRole(Roles.LOUP, main);
	        	player.sendMessage("Vous êtes désormais le rôle §9Loup");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("captain")) {
	        	
	        	joueur.setRole(Roles.CAPTAIN, main);
	        	player.sendMessage("Vous êtes désormais le rôle §9Captain");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("hekow")) {
	        	
	        	joueur.setRole(Roles.HEKOW, main);
	        	player.sendMessage("Vous êtes désormais le rôle §9Hekow");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("toinou")) {
	        	
	        	joueur.setRole(Roles.TOINOU, main);
	        	player.sendMessage("Vous êtes désormais le rôle §2Toinou");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("obscur")) {
	        	
	        	joueur.setRole(Roles.OBSCUR, main);
	        	player.sendMessage("Vous êtes désormais le rôle §2Obscur");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("nonoboy")) {
	        	
	        	joueur.setRole(Roles.NONOBOY, main);
	        	player.sendMessage("Vous êtes désormais le rôle §2Nonoboy");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("kzou")) {
	        	
	        	joueur.setRole(Roles.KZOU, main);
	        	player.sendMessage("Vous êtes désormais le rôle §6Kzou");
	        	
	        }
	        
		//}
		
		return false;
		
	}

}
