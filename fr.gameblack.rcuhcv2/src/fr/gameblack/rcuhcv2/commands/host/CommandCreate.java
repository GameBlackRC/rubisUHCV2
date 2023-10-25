package fr.gameblack.rcuhcv2.commands.host;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;

public class CommandCreate implements CommandExecutor {

    private Main main;

    public CommandCreate(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            
            Joueur joueur = main.getJoueur(player);
            
            if(joueur != null) {

	            if (main.getHostBase() == null) {
	            	
	            	Inventory inv_pacte = Bukkit.createInventory(null, 27, "§8Création de la partie");
	            	inv_pacte.setItem(11, Main.getItem(Material.SUGAR, "Rapide", "Le stuff est directement give au début de la partie et tous les joueurs sont téléporter au même endroit"));
	                inv_pacte.setItem(13, Main.getItem(Material.REDSTONE, "Meetup", "Le stuff est directement give au début de la partie. \nCertains rôles changent pour s'adapter à ce mode"));
	                inv_pacte.setItem(15, Main.getItem(Material.DIAMOND_PICKAXE, "Normal", "C'est le mode de jeu de base avec du minage\net aucun changement de rôles"));
	
	                player.openInventory(inv_pacte);
	
	            }
	            else {
	            	
	            	player.sendMessage("Il y a déjà un host");
	            	
	            }
	            
            }
            else {
            	
            	player.sendMessage("Vous n'avez pas été enregistrer dans la partie, veuillez déco-reco");
            	
            }

        }

        return false;

    }

}
