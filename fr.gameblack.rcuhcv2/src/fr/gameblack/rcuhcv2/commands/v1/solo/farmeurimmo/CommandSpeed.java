package fr.gameblack.rcuhcv2.commands.v1.solo.farmeurimmo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

public class CommandSpeed implements CommandExecutor {

    private Main main;

    public CommandSpeed(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);

        if (joueur.getRole() == Roles.Farmeurimmo) {

        	if (joueur.isSpeedIIActif()) {

        		if(joueur.getPlayer().hasPotionEffect(PotionEffectType.SPEED)) joueur.getPlayer().removePotionEffect(PotionEffectType.SPEED);
        		joueur.setSpeedIIActif(false);

        	} else {
        		
        		if(main.isDay()) {

        			joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 1, false, false));
        		
        		}
        		
        		joueur.setSpeedIIActif(true);

        	}

        } else {

        	player.sendMessage("Vous n'avez pas le bon rôle");

        }

        return false;
    }

}