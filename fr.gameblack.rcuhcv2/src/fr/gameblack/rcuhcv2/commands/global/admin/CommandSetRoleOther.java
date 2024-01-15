package fr.gameblack.rcuhcv2.commands.global.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

public class CommandSetRoleOther implements CommandExecutor {
	
	private Main main;
	
	public CommandSetRoleOther(Main main) {
		
		this.main = main;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//if(main.isV2Actif()) {
		
			Player player = (Player) sender;
	
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
	        
	        Player cible_ = Bukkit.getPlayer(args[0]);
	
	        if (cible_ != null) {
	        	
	        	Joueur cible = main.getJoueur(cible_);
	
		        if (args.length > 1 && args[1].equalsIgnoreCase("farmeurimmo")) {
		
		            cible.setRole(Roles.FARMEURIMMO, main);
		            cible_.sendMessage("Vous êtes désormais le rôle §cFarmeurimmo");
		            
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("test")) {
		
		            cible.setRole(Roles.TEST, main);
		            cible_.sendMessage("Vous êtes désormais le rôle Test");
		            
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("malivol")) {
		        	
		        	cible.setRole(Roles.MALIVOL, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §2Malivol");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("raptor")) {
		        	
		        	cible.setRole(Roles.RAPTOR, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §aRaptor");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("jeannot")) {
		        	
		        	cible.setRole(Roles.JEANNOT, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §aJeannot");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("nickoboop")) {
		        	
		        	cible.setRole(Roles.NICKOBOOP, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §aNickoboop");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("slup")) {
		        	
		        	cible.setRole(Roles.SLUP, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §aSlup");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("joko")) {
		        	
		        	cible.setRole(Roles.JOKO, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §aJoko");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("team")) {
		        	
		        	cible.setRole(Roles.TEAM, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §9Team");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("gameblack")) {
		        	
		        	cible.setRole(Roles.GAMEBLACK, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §9GameBlack");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("maka")) {
		        	
		        	cible.setRole(Roles.MAKA, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §9Maka");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("trial")) {
		        	
		        	cible.setRole(Roles.TRIAL, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §9Trial");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("loup")) {
		        	
		        	cible.setRole(Roles.LOUP, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §9Loup");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("captain")) {
		        	
		        	cible.setRole(Roles.CAPTAIN, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §9Captain");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("hekow")) {
		        	
		        	cible.setRole(Roles.HEKOW, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §9Hekow");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("toinou")) {
		        	
		        	cible.setRole(Roles.TOINOU, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §2Toinou");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("obscur")) {
		        	
		        	cible.setRole(Roles.OBSCUR, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §2Obscur");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("nonoboy")) {
		        	
		        	cible.setRole(Roles.NONOBOY, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §2Nonoboy");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("theoochoux")) {
		        	
		        	cible.setRole(Roles.THEOOCHOUX, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §2Theoochoux");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("romprems")) {
		        	
		        	cible.setRole(Roles.ROMPREMS, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §2RomPrems");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("kzou")) {
		        	
		        	cible.setRole(Roles.KZOU, main);
		        	cible_.sendMessage("Vous êtes désormais le rôle §6Kzou");
		        	
		        }
		        
	        }
	        
		//}
		
		return false;
		
	}

}
