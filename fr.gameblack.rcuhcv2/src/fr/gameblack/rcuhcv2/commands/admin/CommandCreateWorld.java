package fr.gameblack.rcuhcv2.commands.admin;

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

        	WorldCreator world_ = new WorldCreator("uhc").environment(Environment.NORMAL).type(WorldType.NORMAL).generateStructures(true).generator(new CustomChunkGenerator());
        	
        	World world = world_.createWorld();
            sender.sendMessage("Début de la génération du monde");

        }

        return false;
    }

}