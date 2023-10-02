package fr.gameblack.rcuhcv2.listener;

import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.orbes.Glace;
import fr.gameblack.rcuhcv2.roles.joueur.Raptor;
import fr.gameblack.rcuhcv2.roles.uhc.Toinou;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class DamageListener implements Listener {
	
	private Main main;
	
	public DamageListener(Main main) {
		
		this.main = main;
		
	}
	
	public static void Mort(Joueur joueur, Joueur tueur, EntityDamageByEntityEvent event, Main main) {
		
		if(tueur.getRole() == Roles.TRIAL && tueur.getModeTrial() == "serieux") {
			
			tueur.addForce(0.02);
			
			if(tueur.getCamp() == "duo" && main.getJoueurByRole(Roles.SLUP) != null) {
				
				Joueur slup = main.getJoueurByRole(Roles.SLUP);
				
				slup.addForce(0.02);
				
			}
			
		}
		if(joueur.isBonPapiers() && tueur.getRole() != Roles.TRIAL && tueur.getRole() != Roles.MAKA && tueur.getRole() != Roles.MALIVOL) {
			
			tueur.setBonPapiers(true);
			
		}
		else if(!joueur.isBonPapiers()) {
			
			tueur.setBonPapiers(false);
			
		}
		
	}
	
	@EventHandler
	public void onPvp(EntityDamageByEntityEvent event) {
		
		Entity victim = event.getEntity();

        if (victim instanceof Player) {
            Player player = (Player) victim;
            Joueur joueur = main.getJoueur(player);

            Entity damager = event.getDamager();
            Player killer = player;

            double damage = 0;

            if (damager instanceof Player) killer = (Player) damager;
            
            Joueur tueur = main.getJoueur(killer);

            if (main.getState() == Statut.PVP_ON || (!joueur.isInvulnerable() || !tueur.isInvulnerable())) {

            	if(joueur != tueur) {
            		
            		joueur.addPourcentHack(2, main);
            		tueur.addPourcentHack(2, main);
            		
            		if(tueur.getComboSubi() != 0) {
            			
            			tueur.setComboSubi(0);
            			
            		}
            		
            		if(tueur != joueur.getLastHit()) {
            	
            			joueur.setLastHit(tueur);
            			joueur.setComboSubi(0);
            			
            		}
            		else if(joueur.getRole() == Roles.RAPTOR && joueur.getComboSubi() == 4 && !joueur.isCheatRaptorActif()) {
            			
            			Raptor.cheat(joueur, main);
            			joueur.setCheatRaptorActif(true);
            			joueur.setComboSubi(0);
            			
            			if(tueur.getRole() == Roles.TOINOU && !joueur.isCheatToinouActif()) {
            				
            				joueur.setCheatToinou(true);
            				Toinou.Cheat(tueur, main);
            				
            			}
            			
            		}
            		else {
            			
            			joueur.setComboSubi(joueur.getComboSubi()+1);
            			
            		}
            	
            	}
            	
            	if(main.isDebug()) {
                	
                	System.out.println("_________________________________________");
                	System.out.println("Abso : " + event.getDamage(DamageModifier.ABSORPTION));
                	System.out.println("Armure : " + event.getDamage(DamageModifier.ARMOR));
                	System.out.println("Base : " + event.getDamage(DamageModifier.BASE));
                	System.out.println("Blocking : " + event.getDamage(DamageModifier.BLOCKING));
                	System.out.println("Hard hat : " + event.getDamage(DamageModifier.HARD_HAT));
                	System.out.println("Enchant : " + event.getDamage(DamageModifier.MAGIC));
                	System.out.println("Resistance : " + event.getDamage(DamageModifier.RESISTANCE));
                	System.out.println("Final : " + event.getFinalDamage());
                	System.out.println("__________________");
                	
                }
                
                if (tueur.getOrbe() == Orbe.GLACE && tueur.isOrbeActif()) {

                    Glace.Freeze(player);

                }
                
                if(main.isDebug()) {
                	
                	System.out.println("Abso : " + event.getDamage(DamageModifier.ABSORPTION));
                	System.out.println("Armure : " + event.getDamage(DamageModifier.ARMOR));
                	System.out.println("Base : " + event.getDamage(DamageModifier.BASE));
                	System.out.println("Blocking : " + event.getDamage(DamageModifier.BLOCKING));
                	System.out.println("Hard hat : " + event.getDamage(DamageModifier.HARD_HAT));
                	System.out.println("Enchant : " + event.getDamage(DamageModifier.MAGIC));
                	System.out.println("Resistance : " + event.getDamage(DamageModifier.RESISTANCE));
                	System.out.println("Final : " + event.getFinalDamage());
                	System.out.println("_________________________________________");
                	
                }
                
                if (damager instanceof Arrow) {

                    Arrow arrow = (Arrow) damager;
                    if (arrow.getShooter() instanceof Player) {
                        killer = (Player) arrow.getShooter();
                        tueur = main.getJoueur(killer);
                        joueur.setLastHit(tueur);
                    }

                }
                else if(tueur != joueur) {
                	
                	double damage_strenght = (event.getDamage(DamageModifier.BASE)*(tueur.getForce()/100))*0.9;
                    double armure = event.getDamage(DamageModifier.ARMOR);
                    event.setDamage(DamageModifier.BASE, damage_strenght);
                    event.setDamage(DamageModifier.ARMOR,armure);
                    double resi = event.getDamage(DamageModifier.BASE)*((joueur.getResi()/100)-1);
                    event.setDamage(DamageModifier.RESISTANCE, -resi);
                	
                }
                
                damage = event.getFinalDamage();
                
                if(joueur.getRole() == Roles.RAPTOR && tueur.getRole() == Roles.TOINOU && tueur.isCheatToinou()) {
        			
        			damage *= 1.03;
        			
        		}
                
                if(joueur.isFireOn() || (tueur.getOrbe() == Orbe.FEU && tueur.isOrbeActif())) {
                	
                	Random r = new Random();
                    int nb = r.nextInt(100);
                    
                    if(nb <= 10) {
                	
                    	joueur.getPlayer().setFireTicks(100);
                    	
                    }
                	
                }
                
                if (joueur.isAntiKB()) {

                    event.setCancelled(true);
                    player.damage(damage);

                }
                
                if (tueur.getRole() == Roles.JOKO && tueur.isJokoItemActif()) {

                    if (joueur.getCube() != 0 && !main.getJokoStun().contains(joueur)) {

                        Random r = new Random();
                        int nb = r.nextInt(100);
                        int pourcent = joueur.getCube() * 2;

                        if (nb < pourcent + 1) {

                        	joueur.Stun(10, main);
                        	joueur.removeCube(main);
                            main.getJokoStun().add(joueur);

                            killer.sendMessage("Vous venez de stun " + player.getName());

                            ItemCD cycle = new ItemCD(main, tueur, "stun", 10, joueur, null, null, null, null);
                            cycle.runTaskTimer(main, 0, 20);

                        }

                    }

                }
                
                if (player.getHealth() <= damage) {

                    ItemCD cycle = new ItemCD(main, tueur, "mort", 10, joueur, event, null, null, joueur.getPlayer().getLocation());
                    cycle.runTaskTimer(main, 0, 20);
                    event.setDamage(0);
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage("Vous êtes mort mais vous avez encore une chance de ressucité");

                }
                
            }
            else {
            	
            	event.setCancelled(true);
            	
            }
            
        }
		
	}
	
    @EventHandler
    public void onDamage(EntityDamageEvent event) {

        Entity victim = event.getEntity();
        
        if(victim instanceof Player) {
        	
        	Joueur joueur = main.getJoueur((Player) victim);
        	
        	if(joueur.isInvulnerable()) {
        		
        		event.setCancelled(true);
        		
        	}
        	
        }

    }

}
