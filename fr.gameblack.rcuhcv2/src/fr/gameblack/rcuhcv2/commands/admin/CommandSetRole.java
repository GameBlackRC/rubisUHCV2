package fr.gameblack.rcuhcv2.commands.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.joueur.Jeannot;
import fr.gameblack.rcuhcv2.roles.joueur.Joko;
import fr.gameblack.rcuhcv2.roles.joueur.Nickoboop;
import fr.gameblack.rcuhcv2.roles.joueur.Raptor;
import fr.gameblack.rcuhcv2.roles.joueur.Slup;
import fr.gameblack.rcuhcv2.roles.solo.Kzou;
import fr.gameblack.rcuhcv2.roles.staff.Captain;
import fr.gameblack.rcuhcv2.roles.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.staff.Hekow;
import fr.gameblack.rcuhcv2.roles.staff.Loup;
import fr.gameblack.rcuhcv2.roles.staff.Maka;
import fr.gameblack.rcuhcv2.roles.staff.Team;
import fr.gameblack.rcuhcv2.roles.staff.Trial;
import fr.gameblack.rcuhcv2.roles.uhc.Malivol;
import fr.gameblack.rcuhcv2.roles.uhc.Nonoboy;
import fr.gameblack.rcuhcv2.roles.uhc.Obscur;
import fr.gameblack.rcuhcv2.roles.uhc.Toinou;

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
	
	            joueur.setRole(Roles.FARMEURIMMO);
	            player.sendMessage("Vous êtes désormais le rôle Farmeurimmo");
	            
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("test")) {
	
	            joueur.setRole(Roles.TEST);
	            player.sendMessage("Vous êtes désormais le rôle Test");
	            
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("malivol")) {
	        	
	        	joueur.setRole(Roles.MALIVOL);
	        	Malivol.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Malivol");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("raptor")) {
	        	
	        	joueur.setRole(Roles.RAPTOR);
	        	Raptor.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Raptor");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("jeannot")) {
	        	
	        	joueur.setRole(Roles.JEANNOT);
	        	Jeannot.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Jeannot");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("nickoboop")) {
	        	
	        	joueur.setRole(Roles.NICKOBOOP);
	        	Nickoboop.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Nickoboop");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("slup")) {
	        	
	        	joueur.setRole(Roles.SLUP);
	        	Slup.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Slup");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("joko")) {
	        	
	        	joueur.setRole(Roles.JOKO);
	        	Joko.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Joko");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("team")) {
	        	
	        	joueur.setRole(Roles.TEAM);
	        	Team.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Team");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("gameblack")) {
	        	
	        	joueur.setRole(Roles.GAMEBLACK);
	        	GameBlack.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle GameBlack");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("maka")) {
	        	
	        	joueur.setRole(Roles.MAKA);
	        	Maka.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Maka");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("trial")) {
	        	
	        	joueur.setRole(Roles.TRIAL);
	        	Trial.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Trial");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("loup")) {
	        	
	        	joueur.setRole(Roles.LOUP);
	        	Loup.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Loup");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("captain")) {
	        	
	        	joueur.setRole(Roles.CAPTAIN);
	        	Captain.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Captain");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("hekow")) {
	        	
	        	joueur.setRole(Roles.HEKOW);
	        	Hekow.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Hekow");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("toinou")) {
	        	
	        	joueur.setRole(Roles.TOINOU);
	        	Toinou.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Toinou");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("obscur")) {
	        	
	        	joueur.setRole(Roles.OBSCUR);
	        	Obscur.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Obscur");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("nonoboy")) {
	        	
	        	joueur.setRole(Roles.NONOBOY);
	        	Nonoboy.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Nonoboy");
	        	
	        }
	        else if (args.length != 0 && args[0].equalsIgnoreCase("kzou")) {
	        	
	        	joueur.setRole(Roles.KZOU);
	        	Kzou.Items(joueur);
	        	player.sendMessage("Vous êtes désormais le rôle Kzou");
	        	
	        }
	        
		//}
		
		return false;
		
	}

}
