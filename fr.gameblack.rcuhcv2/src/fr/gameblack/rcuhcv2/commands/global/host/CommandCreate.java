package fr.gameblack.rcuhcv2.commands.global.host;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;

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
	            	
	            	Inventory inv_ = Bukkit.createInventory(null, 27, "§8Création de la partie - Version");
	            	inv_.setItem(12, Main.getItem(Material.NETHERRACK, "RC UHC V1", ""));
	                inv_.setItem(14, Main.getItem(Material.DIAMOND_SWORD, "RC UHC V2", ""));
	                
	                player.openInventory(inv_);
	
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
