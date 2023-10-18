package fr.gameblack.rcuhcv2.commands.admin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class CommandRandom implements CommandExecutor {
	
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
            
            Block bloc1 = ((Player) sender).getWorld().getBlockAt(((Player) sender).getLocation().add(2, 0, 0));

            BlockState bedFoot = bloc1.getState();
            BlockState bedHead = bedFoot.getBlock().getRelative(BlockFace.SOUTH).getState();
            bedFoot.setType(Material.BED_BLOCK);
            bedHead.setType(Material.BED_BLOCK);
            bedFoot.setRawData((byte) 0x0);
            bedHead.setRawData((byte) 0x8);
            bedFoot.update(true, false);
            bedHead.update(true, true);
            
            //((Bed)e.getBlockPlaced().getLocation().add(2,0,0).getBlock().getState().getData()).setHeadOfBed(true);
            
            sender.sendMessage("lit poser");

        }

        return false;
    }

}
