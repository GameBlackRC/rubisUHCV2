package fr.gameblack.rcuhcv2.commands.global.host;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;

public class CommandFastcreate implements CommandExecutor {

    private Main main;

    public CommandFastcreate(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            
            Joueur joueur = main.getJoueur(player);
            
            if(joueur != null) {

	            if (main.getHostBase() == null) {
	            	
	            	main.setVersion(2);
        			main.getCompo().clear();
        			main.getScenarios().clear();
        			main.setMode(Modes.RAPIDE);
            		player.sendMessage("Vous avez selectionner le mode rapide");
            		System.out.println("Mode : " + main.getMode());
            		main.setHostBase(joueur);
            		player.getInventory().clear();
            		
            		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
                    ItemMeta coffreM = coffre.getItemMeta();
                    coffreM.setDisplayName("§8Paramètre de la partie");
                    coffre.setItemMeta(coffreM);
                    joueur.getPlayer().getInventory().addItem(coffre);
                    
                    joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
                    
                    main.updateScoreboard();
                    joueur.setBot(true);
	
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
