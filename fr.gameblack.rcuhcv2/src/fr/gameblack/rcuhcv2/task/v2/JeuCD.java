package fr.gameblack.rcuhcv2.task.v2;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.roles.v2.staff.JeuxTrial;
import fr.gameblack.rcuhcv2.roles.v2.staff.Trial;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent.Action;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class JeuCD extends BukkitRunnable {

    @SuppressWarnings("unused")
	private Main main;
    private Player player1;
    private Player player2;
    private String jeu;
    private int timer;
    @SuppressWarnings("unused")
	private EntityDamageByEntityEvent event;
    @SuppressWarnings("unused")
	private List<Player> players = new ArrayList<>();
    private Joueur joueur1;
    private Joueur joueur2;

    public JeuCD(Main main, Joueur joueur1, Joueur joueur2, String jeu, int timer_max) {
        this.main = main;
        this.player1 = joueur1.getPlayer();
        this.player1 = joueur2.getPlayer();
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.jeu = jeu;
        this.timer = timer_max;
    }

    @Override
    public void run() {
    	
    	Random r = new Random();
        int nb = r.nextInt(15);
        nb += 6;
        
        if(timer == nb && jeu == "reflex") {
        	
        	main.setTrialReflexActif(true);
        	TextComponent c = new TextComponent("Clique ici !");
            c.setUnderlined(true);
            c.setColor(ChatColor.AQUA);
            c.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/firstreflexgame"));
            c.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Clique ici !").create()));
            TextComponent msg = new TextComponent("");
            msg.addExtra(c);
            player1.spigot().sendMessage(msg);
            player2.spigot().sendMessage(msg);
        	
        }
        
        if(timer == 30 && jeu == "soleil") {
        	
        	main.setJeuTrial(JeuxTrial.SOLEIL);
        	
        }

        if (timer == 0) {
            cancel();
            if (jeu == "soleil") {

                if(main.getJeuTrial() != null) {
                	
                	main.setJeuTrial(null);
                	joueur1.setInvulnerable(false);
                	joueur2.setInvulnerable(false);
                	joueur1.getPlayer().sendMessage("Le jeu est désormais fini, vous pouvez bouger");
                	joueur2.getPlayer().sendMessage("Le jeu est désormais fini, vous pouvez bouger");
                	
                }

            } else if (jeu == "takaoni") {

            	Trial.FinJeuTakaoni(joueur1, joueur2, main);

            } else if (jeu == "reflex") {

            	

            }

        }

        timer--;

    }

    public ItemStack getItem(Material material, String customName, String desc) {
        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        if (customName != null) itM.setDisplayName(customName);
        itM.setLore(Arrays.asList(desc.split(",")));
        itM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        it.setItemMeta(itM);
        return it;
    }

}