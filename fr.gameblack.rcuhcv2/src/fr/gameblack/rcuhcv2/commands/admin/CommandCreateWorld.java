package fr.gameblack.rcuhcv2.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.World.Environment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.task.CustomChunkGenerator;

public class CommandCreateWorld implements CommandExecutor {

    private Main main;

    public CommandCreateWorld(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {

        if (sender instanceof Player) {
        	
        	sender.sendMessage("Début de la génération du monde");

        	WorldCreator world_ = new WorldCreator("uhc");
        	
        	world_.environment(Environment.NORMAL);
        	world_.type(WorldType.NORMAL);
        	world_.generateStructures(true);
        	world_.generator(new CustomChunkGenerator());
        	
        	Bukkit.createWorld(world_);
        	
        	World world = Bukkit.getWorld("uhc");
        	
        	main.setWorld(world);
        	
        	Bukkit.broadcastMessage("Génération du monde '" + world.getName() + "' fini");
        	
        	world.save();
        	
        	Bukkit.unloadWorld(world, true);
        	
        	Bukkit.getServer().spigot().restart();

        }

        return false;
    }

}