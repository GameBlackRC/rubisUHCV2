package fr.gameblack.rcuhcv2.commands.v1.demons.obscur;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

public class CommandSetpiece implements CommandExecutor {

    private Main main;

    public CommandSetpiece(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;
        Joueur joueur = main.getJoueur(player);

        if (joueur.getRole() == Roles.Obscur) {
            	
            Inventory inv_pacte = Bukkit.createInventory(null, 36, "§8Choix de la pièce");

            inv_pacte.setItem(11, Main.getItem(Material.DIAMOND_HELMET, "Casque", ""));
            inv_pacte.setItem(13, Main.getItem(Material.DIAMOND_CHESTPLATE, "Plastron", ""));
            inv_pacte.setItem(15, Main.getItem(Material.DIAMOND_LEGGINGS, "Jambières", ""));
            inv_pacte.setItem(21, Main.getItem(Material.DIAMOND_BOOTS, "Bottes", ""));
            inv_pacte.setItem(23, Main.getItem(Material.DIAMOND_SWORD, "Epée", ""));

            player.openInventory(inv_pacte);

        } else {

            player.sendMessage("Vous n'avez pas le bon rôle");

        }

        return false;
    }

}