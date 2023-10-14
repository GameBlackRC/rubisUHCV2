package fr.gameblack.rcuhcv2.commands.game;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;

public class CommandList implements CommandExecutor {
	
	private Main main;

    public CommandList(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            
            Joueur joueur = main.getJoueur(player);
            
            if(joueur.isMort()) {

	            String golden;
	            
	            if(main.isFermetureGoldenActif()) {
	            	golden = "Actif";
	            }
	            else {
	            	golden = "Innactif";
	            }
	            
	            Inventory inv = Bukkit.createInventory(null, 36, "§8Compo");
	            inv.setItem(4, Main.getItem(Material.GOLDEN_APPLE, "Fermeture de golden : " + golden, ""));
	            
	            int nb = 9;
	            
	            for(Joueur j : main.getJoueurInGame()) {
	            	
	            	double speed = j.getSpeed() - 100;
	                double force = j.getForce() - 100;
	                double resi = j.getResi() - 110;
	            	
	            	ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
	    		    SkullMeta skull = (SkullMeta) item.getItemMeta();
	    		    skull.setDisplayName(j.getPlayer().getName());
	    		    ArrayList<String> lore = new ArrayList<String>();
	    		    lore.add("Role : " + j.getCouleurCamp() + j.getRole().toString());
	    		    lore.add("Orbe : " + j.getOrbe().toString());
	    		    lore.add("Kill : " + j.getKill());
	    		    lore.add("Poucent Hack : " + j.getPourcentHack());
	    		    lore.add("Cube : " + j.getCube());
	    		    lore.add("Force : " + force + "%; Résistance : " + resi + "%; Speed : " + speed + "%");
	    		    if(j.getRole() == Roles.JEANNOT) {
	    		    	
	    		    	if(j.isJeannotPartageActif()) {
	    		    		
	    		    		lore.add("Partage : Actif");
	    		    		
	    		    	} else {
	    		    		
	    		    		lore.add("Partage : Innactif");
	    		    		
	    		    	}
	    		    	
	    		    }
	    		    if(j.getRole() == Roles.SLUP) {
	    		    	
	    		    	lore.add("Slime : " + j.getSlime());
	    		    	
	    		    }
	    		    if(j.getRole() == Roles.MAKA) {
	    		    	
	    		    	if(j.getForme().equalsIgnoreCase("normal")) {
	    		    		
	    		    		lore.add("Forme : normal");
	    		    		
	    		    	}
	    		    	else {
	    		    		
	    		    		lore.add("Forme : simp");
	    		    		lore.add("Neko : " + main.getNeko());
	    		    		
	    		    	}
	    		    	
	    		    }
	    		    if(j.getRole() == Roles.TRIAL) {
	    		    	
	    		    	lore.add("Forme : " + j.getForme()); 
	    		    	
	    		    }
	    		    skull.setLore(lore);
	    		    skull.setOwner(j.getPlayer().getName());
	    		    item.setItemMeta(skull);
	    				
	    			inv.setItem(nb, item);
	    			nb += 1;
	            	
	            }
	            
	            player.openInventory(inv);
	            
            }
            else {
            	
            	player.sendMessage("Vous n'êtes pas encore mort");
            	
            }

        }

        return false;
    }

}
