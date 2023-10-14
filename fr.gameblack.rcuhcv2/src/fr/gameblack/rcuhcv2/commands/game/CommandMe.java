package fr.gameblack.rcuhcv2.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

public class CommandMe implements CommandExecutor {

    private Main main;

    public CommandMe(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Joueur joueur = main.getJoueur(player);
            
            if(joueur.getRole() == Roles.RAPTOR) {
            	
            	Raptor.Texte(player);
            	
            } else if(joueur.getRole() == Roles.NICKOBOOP) {
            	
            	Nickoboop.Texte(player);
            	
            } else if(joueur.getRole() == Roles.JEANNOT) {
            	
            	Jeannot.Texte(player);
            	
            } else if(joueur.getRole() == Roles.JOKO) {
            	
            	Joko.Texte(player);
            	
            } else if(joueur.getRole() == Roles.SLUP) {
            	
            	Slup.Texte(player);
            	
            } else if(joueur.getRole() == Roles.TEAM) {
            	
            	Team.Texte(player);
            	
            } else if(joueur.getRole() == Roles.GAMEBLACK) {
            	
            	if(joueur.getCamp().equalsIgnoreCase("joueur")) {
            		
            		GameBlack.TexteJoueur(player);
            		
            	}
            	else if(joueur.getCamp().equalsIgnoreCase("uhc")) {
            		
            		GameBlack.TexteUHC(player);
            		
            	}
            	else if(joueur.getCamp().equalsIgnoreCase("staff")) {
            		
            		GameBlack.Texte(player);
            		
            	}
            	
            } else if(joueur.getRole() == Roles.MAKA) {
            	
            	Maka.Texte(player);
            	
            } else if(joueur.getRole() == Roles.TRIAL) {
            	
            	Trial.Texte(player);
            	
            } else if(joueur.getRole() == Roles.LOUP) {
            	
            	Loup.Texte(player);
            	
            } else if(joueur.getRole() == Roles.CAPTAIN) {
            	
            	Captain.Texte(player);
            	
            } else if(joueur.getRole() == Roles.HEKOW) {
            	
            	Hekow.Texte(player);
            	
            } else if(joueur.getRole() == Roles.MALIVOL) {
            	
            	Malivol.Texte(player);
            	
            } else if(joueur.getRole() == Roles.TOINOU) {
            	
            	Toinou.Texte(player);
            	
            } else if(joueur.getRole() == Roles.OBSCUR) {
            	
            	Obscur.Texte(player);
            	
            } else if(joueur.getRole() == Roles.NONOBOY) {
            	
            	Nonoboy.Texte(player);
            	
            } else if(joueur.getRole() == Roles.FARMEURIMMO) {
            	
            	Farmeurimmo.Texte(player);
            	
            } else if(joueur.getRole() == Roles.KZOU) {
            	
            	Kzou.Texte(player);
            	
            }

        }

        return false;
    }

}
