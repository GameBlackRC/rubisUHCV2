package fr.gameblack.rcuhcv2.listener;

import java.util.Random;

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
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.roles.joueur.Raptor;
import fr.gameblack.rcuhcv2.roles.uhc.Toinou;

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
		
	}
	
	@EventHandler
	public void onPvp(EntityDamageByEntityEvent event) {
		
		Entity victim = event.getEntity();

        if (victim instanceof Player) {
            Player player = (Player) victim;
            Joueur joueur = main.getJoueur(player);

            Entity damager = event.getDamager();
            Player killer = player;

            double damage;

            if (damager instanceof Player) killer = (Player) damager;
            
            Joueur tueur = main.getJoueur(killer);

            if (main.getState() == Statut.PVP_ON || !joueur.isInvulnerable() || !tueur.isInvulnerable()) {

            	if(joueur != tueur) {
            		
            		joueur.addPourcentHack(2);
            		tueur.addPourcentHack(2);
            		
            		if(tueur != joueur.getLastHit()) {
            	
            			joueur.setLastHit(tueur);
            			joueur.setComboSubi(0);
            			
            		}
            		else if(joueur.getRole() == Roles.RAPTOR && joueur.getComboSubi() == 4) {
            			
            			Raptor.cheat(joueur, main);
            			
            			if(tueur.getRole() == Roles.TOINOU) {
            				
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
                
                double damage_strenght = (event.getDamage(DamageModifier.BASE)*(tueur.getForce()/100))*0.9;
                double armure = event.getDamage(DamageModifier.ARMOR)*0.9;
                event.setDamage(DamageModifier.BASE, damage_strenght);
                event.setDamage(DamageModifier.ARMOR,armure);
                double resi = event.getDamage(DamageModifier.BASE)*((joueur.getResi()/100)-1);
                event.setDamage(DamageModifier.RESISTANCE, -resi);
                
                damage = event.getFinalDamage();
                
                if(joueur.getRole() == Roles.RAPTOR && tueur.getRole() == Roles.TOINOU && tueur.isCheatToinou()) {
        			
        			damage *= 1.05;
        			
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
                
                if(joueur.isFireOn()) {
                	
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
