package fr.gameblack.rubisuhc.commands.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.roles.rc.GameBlack;

public class CommandGiveRole implements CommandExecutor {
	
	private Main main;

	public CommandGiveRole(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		Player player = (Player)sender;
		
		player.setMaxHealth(20);
		if(player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		if(player.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		if(player.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
		if(player.hasPotionEffect(PotionEffectType.SPEED)) player.removePotionEffect(PotionEffectType.SPEED);
		if(player.hasPotionEffect(PotionEffectType.WEAKNESS)) player.removePotionEffect(PotionEffectType.WEAKNESS);
		if(player.hasPotionEffect(PotionEffectType.SLOW)) player.removePotionEffect(PotionEffectType.SLOW);
		if(player.hasPotionEffect(PotionEffectType.FAST_DIGGING)) player.removePotionEffect(PotionEffectType.FAST_DIGGING);
		if(player.hasPotionEffect(PotionEffectType.JUMP)) player.removePotionEffect(PotionEffectType.JUMP);
		if(player.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) player.removePotionEffect(PotionEffectType.SLOW_DIGGING);

		if(args.length != 0 && args[0].equalsIgnoreCase("gameblack")) {
			
			//FINI
			
			main.setRole(player, Roles.GAMEBLACK);
			GameBlack.Items(player, main);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("trial")) {
			
			//KILL RC -> A FAIRE
			main.setRole(player, Roles.TRIAL);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("team")) {
			
			//CONNAIT GAMEBLACK OU MAKA -> A FAIRE
			main.setRole(player, Roles.TEAM);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("slup")) {
			
			//INFO UTILISATION POUVOIR -> A FAIRE
			main.setRole(player, Roles.SLUP);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("toinou")) {
			
			//KILL SLUP -> A FAIRE
			//KILL MALEDICTION -> A FAIRE
			//KILL SANG -> A FAIRE
			//KILL TENEBRE -> MANQUE CALCULE DEGAT
			//KILL TRONCONEUSE -> A FAIRE
			main.setRole(player, Roles.TOINOU);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("maka")) {
			
			//FINI
			main.setRole(player, Roles.MAKA);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("malivol")) {
			
			//ANTI KB -> A FAIRE
			main.setRole(player, Roles.MALIVOL);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("archer")) {
			
			//FINI
			main.setRole(player, Roles.ARCHER);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("guerrier")) {
			
			//FINI
			main.setRole(player, Roles.GUERRIER);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("eclaireur")) {
			
			main.setRole(player, Roles.ECLAIREUR);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("joko")) {
			
			//ARMURE INVINCIBLE -> ?
			main.setRole(player, Roles.JOKO);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("loup")) {
			
			//FINI
			main.setRole(player, Roles.LOUP);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("raptor")) {
			
			//FINI
			main.setRole(player, Roles.RAPTOR);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("ange")) {
			
			//CONNAIT SLUP -> A FAIRE
			main.setRole(player, Roles.ANGE);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("avenir")) {
			
			//GERER MORT -> A FAIRE
			//MORT DEF <3 coeurs -> A FAIRE
			//INF -> A FAIRE
			main.setRole(player, Roles.AVENIR);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("cosmos")) {
			
			//ZONE -> A FAIRE
			//KILL JOUEUR -> A FAIRE
			main.setRole(player, Roles.COSMOS);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("demon")) {
			
			//CONNAIT 1 DEMON -> A FAIRE
			main.setRole(player, Roles.DEMON);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("electrique")) {
			
			//CONNAIT SLUP -> A FAIRE
			main.setRole(player, Roles.ELECTRIQUE);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("enfer")) {
			
			//ZONE -> A FAIRE
			//CONNAIT SLUP -> A FAIRE
			main.setRole(player, Roles.ENFER);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("malediction")) {
			
			//LANCER MALEDICTION -> A FAIRE
			main.setRole(player, Roles.MALEDICTION);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("sang")) {
			
			//CONNAIT SLUP -> A FAIRE
			main.setRole(player, Roles.SANG);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("tenebre")) {
			
			main.setRole(player, Roles.TENEBRE);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("farmeurimmo")) {
			
			main.setRole(player, Roles.FARMEURIMMO);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("kzou")) {
			
			//CONNAIT SLUP -> A FAIRE
			//COMMANDE /RCDISPERSE -> A FAIRE
			//COMMANDE /RCBAN -> A FAIRE
			//PROBA FAIBLESSE -> A FAIRE
			//CHANGER ROLE MORT -> A FAIRE
			main.setRole(player, Roles.KZOU);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("experimental")) {
			
			//SACRIFIER UN COEUR -> A FAIRE
			//STUN -> A FAIRE
			main.setRole(player, Roles.EXPERIMENTAL);
			
		}
		else if(args.length != 0 && args[0].equalsIgnoreCase("tronconeuse")) {
			
			//EFFET SAIGNEMENT
			//MORT TRIAL
			//POUVOIR AFFUTER SES LAMES -> A FAIRE
			//ORBE ELEMENTAIRE -> A FAIRE
			main.setRole(player, Roles.TRONCONEUSE);
			
		}
		else {
			
			player.sendMessage("Non");
			
		}
		
		return false;
	}

}