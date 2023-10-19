package fr.gameblack.rcuhcv2.commands.admin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import fr.gameblack.rcuhcv2.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class CommandRandom implements CommandExecutor {
	
	private Main main;
	
	public CommandRandom(Main main) {
		this.main = main;
	}
	
	@SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {

        if (sender instanceof Player) {

        	TextComponent c = new TextComponent("accept!");
            c.setUnderlined(true);
            c.setColor(ChatColor.AQUA);
            c.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/tpaccept"));
            c.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Accept!").create()));
            TextComponent msg = new TextComponent("");
            msg.addExtra(c);
            ((Player) sender).spigot().sendMessage(msg);
            
            sender.sendMessage(ChatColor.MAGIC + "aaaa" + ChatColor.RESET + "aaaa");
            
            Block bloc1 = main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, 200));
    		
    		Block bloc2 = main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -200));

            BlockState bedFoot = bloc1.getState();
            BlockState bedHead = bedFoot.getBlock().getRelative(BlockFace.SOUTH).getState();
            bedFoot.setType(Material.BED_BLOCK);
            bedHead.setType(Material.BED_BLOCK);
            bedFoot.setRawData((byte) 0x0);
            bedHead.setRawData((byte) 0x8);
            bedFoot.update(true, false);
            bedHead.update(true, true);
            
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, 201)).setType(Material.OBSIDIAN);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, 200)).setType(Material.OBSIDIAN);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, 201)).setType(Material.OBSIDIAN);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, 200)).setType(Material.OBSIDIAN);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, 199)).setType(Material.OBSIDIAN);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, 202)).setType(Material.OBSIDIAN);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, 201)).setType(Material.OBSIDIAN);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, 200)).setType(Material.OBSIDIAN);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, 201)).setType(Material.OBSIDIAN);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, 200)).setType(Material.OBSIDIAN);
            
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -200)).setType(Material.WOOD);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -199)).setType(Material.WOOD);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -200)).setType(Material.WOOD);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -199)).setType(Material.WOOD);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -198)).setType(Material.WOOD);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -201)).setType(Material.WOOD);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -200)).setType(Material.WOOD);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -199)).setType(Material.WOOD);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -200)).setType(Material.WOOD);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -199)).setType(Material.WOOD);
            
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 98, -200)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 102, -200)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 98, -199)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 102, -199)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -198)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -198)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 101, -201)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 99, -201)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 101, -200)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 99, -200)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 101, -199)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 99, -199)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 101, -200)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 99, -200)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 101, -199)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 99, -199)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 202, 100, -199)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 202, 100, -200)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 198, 100, -199)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 198, 100, -200)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -198)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -198)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 201, 100, -201)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 199, 100, -201)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -202)).setType(Material.ENDER_STONE);
            main.getWorld().getBlockAt(new Location(main.getWorld(), 200, 100, -197)).setType(Material.ENDER_STONE);
            
            BlockState bedFoot2 = bloc2.getState();
            BlockState bedHead2 = bedFoot2.getBlock().getRelative(BlockFace.SOUTH).getState();
            bedFoot2.setType(Material.BED_BLOCK);
            bedHead2.setType(Material.BED_BLOCK);
            bedFoot2.setRawData((byte) 0x0);
            bedHead2.setRawData((byte) 0x8);
            bedFoot2.update(true, false);
            bedHead2.update(true, true);
            
            //((Bed)e.getBlockPlaced().getLocation().add(2,0,0).getBlock().getState().getData()).setHeadOfBed(true);
            
            sender.sendMessage("lit poser");

        }

        return false;
    }

}
