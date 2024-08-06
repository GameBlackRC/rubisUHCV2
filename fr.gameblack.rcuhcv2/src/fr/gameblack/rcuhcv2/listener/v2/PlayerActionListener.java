package fr.gameblack.rcuhcv2.listener.v2;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.Stats;
import fr.gameblack.rcuhcv2.evenement.v2.Minerais;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Jeannot;
import fr.gameblack.rcuhcv2.roles.v2.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.v2.staff.JeuxTrial;
import fr.gameblack.rcuhcv2.roles.v2.staff.Trial;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;
import fr.gameblack.rcuhcv2.scenarios.global.CutClean;
import fr.gameblack.rcuhcv2.scenarios.global.HasteyBoys;
import fr.gameblack.rcuhcv2.scenarios.global.Rodless;
import fr.gameblack.rcuhcv2.scenarios.global.Timber;
import fr.gameblack.rcuhcv2.task.v2.GameCycle;

public class PlayerActionListener implements Listener{
	
	private Main main;
	
	public PlayerActionListener(Main main) {
		
		this.main = main;
		
	}
	
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent event) {
		
		//if(main.isV2Actif()) {
		
			if(event.getItem().getType() == Material.GOLDEN_APPLE) {
				
				Joueur joueur = main.getJoueur(event.getPlayer());
				main.addStat(Stats.GAPS_MANGER, joueur);
				
				if(joueur.isBot()) {
					
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " pvp " + joueur.getLastHit().getPlayer().getName());
					joueur.setCibleBot(joueur.getLastHit());
					
				}
				
				if(joueur.getRole() == Roles.TRIAL && joueur.getModeTrial().equalsIgnoreCase("serieux")) {
					
					Random r = new Random();
					
		            int nb = r.nextInt(100);
		            
		            if(nb <= 20) {
					
		            	joueur.removeTrialHydratation(5);
					
		            }
					
				}
				
				if(joueur.getRole() == Roles.HEKOW) {
					
					if(joueur.isHekowJeuActif()) {
						
						joueur.addHekowPourcent(4);
						
					}
					
				}
				
				if(!joueur.isFarmeurimmoProche(main)) {
				
					joueur.addPourcentHack(10, main, GameCycle.getScoreboardFarmeurimmo());
				
				}
				
				if(joueur.getRole() == Roles.JEANNOT && joueur.isJeannotPartageActif()) {
					
					Jeannot.PartageAbso(joueur, main);
					joueur.getPlayer().getInventory().removeItem(new ItemStack(Material.GOLDEN_APPLE, 1));
					event.setCancelled(true);
					
				}
				
				if(joueur.getRole() == Roles.TEAM && joueur.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY)) {
					
					joueur.getPlayer().getInventory().removeItem(new ItemStack(Material.GOLDEN_APPLE, 1));
					
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0, false, false));
					
					event.setCancelled(true);
					
				}
				
				if(!joueur.isAbsoOn()) {
					
					joueur.getPlayer().getInventory().removeItem(new ItemStack(Material.GOLDEN_APPLE, 1));
					
					event.setCancelled(true);
					
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
					
				}
				
			}
			
		//}
		
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		
		Player player = event.getPlayer();
		Joueur joueur = main.getJoueur(player);
		if(!joueur.isMort() && (main.getState() == Statut.PVP_ON || main.getState() == Statut.PVP_OFF)) {
			joueur.setDeco(true);
		}
		else {
			
			main.getListJoueurs().remove(joueur);
			
		}
			
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		//if(main.isV2Actif()) {
		
			if(main.getJoueur(event.getPlayer()) == null && (main.getState() == Statut.WAITING || main.getState() == Statut.STARTING)) {
			
				main.addJoueur(event.getPlayer());
				if(main.getBoard_base() == null) {
					
					main.setBoard_spec(Bukkit.getScoreboardManager().getNewScoreboard());
	                main.setBoard_pourcent(Bukkit.getScoreboardManager().getNewScoreboard());
	                main.setBoard_base(Bukkit.getScoreboardManager().getNewScoreboard());
					
				}
				event.getPlayer().setScoreboard(main.getBoard_base());
				
			}
			else if(main.getJoueurByPseudo(event.getPlayer().getName()) == null) {
				
				event.getPlayer().setGameMode(GameMode.SPECTATOR);
				main.addJoueur(event.getPlayer());
				main.getJoueur(event.getPlayer()).setSpec(true);
				main.getJoueur(event.getPlayer()).setMort(true);
				
			}
			else {
				
				main.getJoueurByPseudo(event.getPlayer().getName()).setPlayer(event.getPlayer());
				System.out.println(main.getJoueur(event.getPlayer()).getPlayer().getName() + ", " + main.getJoueurByPseudo(event.getPlayer().getName()).getRole().getTxt());
				main.getJoueur(event.getPlayer()).setDeco(false);
				
			}
			
		//}
		
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		
		//if(main.isV2Actif()) {
		
	        Player player = e.getPlayer();
	        
	        Joueur joueur = main.getJoueur(player);
	        
	        if(joueur != null) {
	        	
	        	if(joueur.isBot() && joueur.getCibleBot() != null && !joueur.getCibleBot().isMort()) {
	        		
	        		double distance = 0;
	        		
	        		double x;
	        		
	        		if(joueur.getPlayer().getLocation().getX() < joueur.getCibleBot().getPlayer().getLocation().getX()) {
	        			x = joueur.getCibleBot().getPlayer().getLocation().getX() - joueur.getPlayer().getLocation().getX();
	        		}
	        		else {
	        			x = joueur.getPlayer().getLocation().getX() - joueur.getCibleBot().getPlayer().getLocation().getX();
	        		}
	        		
	        		double z;
	        		
	        		if(joueur.getPlayer().getLocation().getZ() < joueur.getCibleBot().getPlayer().getLocation().getZ()) {
	        			z = joueur.getCibleBot().getPlayer().getLocation().getZ() - joueur.getPlayer().getLocation().getZ();
	        		}
	        		else {
	        			z = joueur.getPlayer().getLocation().getZ() - joueur.getCibleBot().getPlayer().getLocation().getZ();
	        		}
	        		
	        		distance = (x+z)/2;
	        		
	        		if(distance > 7) {
	        			
	        			if(joueur.getModeBOT().equalsIgnoreCase("epee") && joueur.getPlayer().getInventory().contains(Material.ARROW)) {
	        				
	        				joueur.setModeBOT("arc");
	        				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " stoppvp ");
	        				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " bow " + joueur.getCibleBot().getPlayer().getName());
	        				
	        			}
	        			
	        		}
	        		else if(joueur.getModeBOT().equalsIgnoreCase("arc")) {
	        			
	        			joueur.setModeBOT("epee");
	        			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " stopbow ");
	        			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " pvp " + joueur.getCibleBot().getPlayer().getName());
	        			
	        		}
	        		
	        	}
	        	
	        	if(!joueur.isAbsoOn()) {
	        		
	        		player.removePotionEffect(PotionEffectType.ABSORPTION);
	        		
	        	}
	        	
	        	if(joueur.getRole() == Roles.TRIAL && joueur.getModeTrial().equalsIgnoreCase("serieux")) {
	        		
	        		joueur.setBouge(true);
	        		
	        	}
	        	
	        	if(main.getJeuTrial() == JeuxTrial.SOLEIL) {
	        		
	        		if(main.getJoueurJeuTrial().contains(joueur)) {
	        			
	        			main.setJeuTrial(null);
	        			List<Joueur> joueurs = main.getJoueurJeuTrial();
	        			joueurs.remove(joueur);
	        			Trial.FinJeuSoleil(joueurs.get(0), joueur, main);
	        			main.getJoueurJeuTrial().clear();
	        			
	        		}
	        		
	        	}
		        
			}
	        
		//}
	    
    }
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		
		if(event.getBlock().getType() == Material.BARRIER || event.getBlock().getType() == Material.REDSTONE_BLOCK) {
			
			event.setCancelled(true);
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		
		ItemStack item = event.getItemDrop().getItemStack();
		
		if(item.getType() == Material.BARRIER || item.getType() == Material.NETHER_STAR || item.getTypeId() == 351) {
			
			event.setCancelled(true);
			
		}
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		
		Player player = event.getPlayer();
		Joueur joueur = main.getJoueur(player);
		
		if(main.getScenarios().contains(Scenarios.TIMBERPVP) && main.getState() == Statut.PVP_OFF) {
			
			Timber.breakTree(event.getBlock());
			
		}
		
		if(main.getScenarios().contains(Scenarios.CUT_CLEAN)) {
			
			CutClean.setCutClean(event.getBlock());
			
		}
		
		if(event.getBlock().getType() == Material.GLOWSTONE || event.getBlock().getType() == Material.NETHER_BRICK || event.getBlock().getType() == Material.QUARTZ_ORE) {
			
			event.setCancelled(true);
			Minerais.InteractMinerais(joueur, event.getBlock().getType(), event.getBlock().getLocation());
			
		}
		
		if(event.getBlock().getType() == Material.BED_BLOCK && (main.getJoueurByRole(Roles.GAMEBLACK) != null && joueur.getModeTrial().equalsIgnoreCase("fun")) && ((event.getBlock().getLocation().getX() == 200 && event.getBlock().getLocation().getY() == 100 && event.getBlock().getLocation().getZ() == 200) || (event.getBlock().getLocation().getX() == 200 && event.getBlock().getLocation().getY() == 100 && event.getBlock().getLocation().getZ() == 201))) {
			
			Bukkit.broadcastMessage("Lit de GameBlack casser");
			GameBlack.litGBCasser(joueur, main);
			
		}
		else if(event.getBlock().getType() == Material.BED_BLOCK && (main.getJoueurByRole(Roles.GAMEBLACK) != null && joueur.getModeTrial().equalsIgnoreCase("fun")) && ((event.getBlock().getLocation().getX() == 200 && event.getBlock().getLocation().getY() == 100 && event.getBlock().getLocation().getZ() == -200) || (event.getBlock().getLocation().getX() == 200 && event.getBlock().getLocation().getY() == 100 && event.getBlock().getLocation().getZ() == -199))) {
			
			Bukkit.broadcastMessage("Lit de l'autre casser");
			GameBlack.litAutreCasser(joueur, main);
			
		}
		
	}
	
	@EventHandler
	public void onCraft(CraftItemEvent event) {
		
		if(main.getScenarios().contains(Scenarios.HASTEY_BOYS)) {
			
			HasteyBoys.setHasteyBoys(event);
			
		}
		if(main.getScenarios().contains(Scenarios.RODLESS)) {
			
			Rodless.setRodless(event);
			
		}
		
	}

    @EventHandler
    public void onPlayerWrite(AsyncPlayerChatEvent event) {

        if (main.getState() == Statut.PVP_ON && main.getMode() != Modes.RAPIDE) {

            event.setCancelled(true);

        }

    }

}
