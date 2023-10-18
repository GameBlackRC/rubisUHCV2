package fr.gameblack.rcuhcv2.commands.admin;

import org.bukkit.Bukkit;
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
import fr.gameblack.rcuhcv2.roles.solo.Farmeurimmo;
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

public class CommandSetRoleOther implements CommandExecutor {
	
	private Main main;
	
	public CommandSetRoleOther(Main main) {
		
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
	        
	        Player cible_ = Bukkit.getPlayer(args[0]);
	
	        if (cible_ != null) {
	        	
	        	Joueur cible = main.getJoueur(cible_);
	
		        if (args.length > 1 && args[1].equalsIgnoreCase("farmeurimmo")) {
		
		            cible.setRole(Roles.FARMEURIMMO);
		            Farmeurimmo.Items(joueur);
		            cible_.sendMessage("Vous êtes désormais le rôle Farmeurimmo");
		            
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("test")) {
		
		            cible.setRole(Roles.TEST);
		            cible_.sendMessage("Vous êtes désormais le rôle Test");
		            
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("malivol")) {
		        	
		        	cible.setRole(Roles.MALIVOL);
		        	Malivol.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Malivol");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("raptor")) {
		        	
		        	cible.setRole(Roles.RAPTOR);
		        	Raptor.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Raptor");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("jeannot")) {
		        	
		        	cible.setRole(Roles.JEANNOT);
		        	Jeannot.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Jeannot");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("nickoboop")) {
		        	
		        	cible.setRole(Roles.NICKOBOOP);
		        	Nickoboop.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Nickoboop");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("slup")) {
		        	
		        	cible.setRole(Roles.SLUP);
		        	Slup.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Slup");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("joko")) {
		        	
		        	cible.setRole(Roles.JOKO);
		        	Joko.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Joko");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("team")) {
		        	
		        	cible.setRole(Roles.TEAM);
		        	Team.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Team");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("gameblack")) {
		        	
		        	cible.setRole(Roles.GAMEBLACK);
		        	GameBlack.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle GameBlack");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("maka")) {
		        	
		        	cible.setRole(Roles.MAKA);
		        	Maka.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Maka");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("trial")) {
		        	
		        	cible.setRole(Roles.TRIAL);
		        	Trial.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Trial");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("loup")) {
		        	
		        	cible.setRole(Roles.LOUP);
		        	Loup.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Loup");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("captain")) {
		        	
		        	cible.setRole(Roles.CAPTAIN);
		        	Captain.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Captain");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("hekow")) {
		        	
		        	cible.setRole(Roles.HEKOW);
		        	Hekow.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Hekow");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("toinou")) {
		        	
		        	cible.setRole(Roles.TOINOU);
		        	Toinou.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Toinou");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("obscur")) {
		        	
		        	cible.setRole(Roles.OBSCUR);
		        	Obscur.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Obscur");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("nonoboy")) {
		        	
		        	cible.setRole(Roles.NONOBOY);
		        	Nonoboy.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Nonoboy");
		        	
		        }
		        else if (args.length > 1 && args[1].equalsIgnoreCase("kzou")) {
		        	
		        	cible.setRole(Roles.KZOU);
		        	Kzou.Items(joueur);
		        	cible_.sendMessage("Vous êtes désormais le rôle Kzou");
		        	
		        }
		        
	        }
	        
		//}
		
		return false;
		
	}

}
