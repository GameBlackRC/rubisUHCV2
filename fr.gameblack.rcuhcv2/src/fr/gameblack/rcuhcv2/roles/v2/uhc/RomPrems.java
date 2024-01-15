package fr.gameblack.rcuhcv2.roles.v2.uhc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RomPrems {
	
	public static void Items(Joueur joueur, Main main) {
		
		Texte(joueur.getPlayer(), main);
		if(joueur.isBot()) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role RomPrems");
			
		}
		
		if(main.getMode() == Modes.RAPIDE) {
			
			joueur.addForce(0.02);
			
		}
		
	}
	
	public static void setEndermanBlazeBase(Joueur romprems,Main main) {
		
		List<Joueur> list = new ArrayList<>();
		
		for(Joueur j : main.getJoueurInGame()) {
			
			if(j.getCamp() != romprems.getCamp()) {
				
				list.add(j);
				
			}
			
		}
		
		Random r = new Random();
		
		if(list.size() > 0) {
		
			Joueur enderman1 = list.get(r.nextInt(list.size()));
			
	        romprems.getEnderman().add(enderman1);
	        list.remove(enderman1);
	        
	        if(list.size() > 0) {
	    		
				Joueur blaze1 = list.get(r.nextInt(list.size()));
				
				romprems.getEnderman().add(blaze1);
		        list.remove(blaze1);
		        
				if(list.size() > 0) {
					
					Joueur enderman2 = list.get(r.nextInt(list.size()));
					
					romprems.getEnderman().add(enderman2);
			        list.remove(enderman2);
			        
			        if(list.size() > 0) {
			    		
						Joueur blaze2 = list.get(r.nextInt(list.size()));
						
						romprems.getEnderman().add(blaze2);
				        list.remove(blaze2);
				        	
				        romprems.getPlayer().sendMessage("§5Enderman : " + enderman1.getPlayer().getName() + ", " + enderman2.getPlayer().getName() + "§r\n \n§6Blaze : " + blaze1.getPlayer().getName() + ", " + blaze2.getPlayer().getName());
				        
					}
			        else {
			        	
			        	romprems.getPlayer().sendMessage("§5Enderman : " + enderman1.getPlayer().getName() + ", " + enderman2.getPlayer().getName() + "§r\n \n§6Blaze : " + blaze1.getPlayer().getName());
			        	
			        }
			        
				}
				else {
		        	
		        	romprems.getPlayer().sendMessage("§5Enderman : " + enderman1.getPlayer().getName() + "§r\n \n§6Blaze : " + blaze1.getPlayer().getName());
		        	
		        }
		        
			}
	        else {
	        	
	        	romprems.getPlayer().sendMessage("§5Enderman : " + enderman1.getPlayer().getName());
	        	
	        }
	        
		}
		
	}
	
	public static void setEndermanBlazeRapide(Joueur romprems,Main main) {
		
		List<Joueur> list = new ArrayList<>();
		
		for(Joueur j : main.getJoueurInGame()) {
			
			if(j != romprems) {
				
				list.add(j);
				
			}
			
		}
		
		Random r = new Random();
		
		if(list.size() > 0) {
		
			Joueur enderman1 = list.get(r.nextInt(list.size()));
			
			romprems.getEnderman().add(enderman1);
	        list.remove(enderman1);
	        
	        if(list.size() > 0) {
	    		
				Joueur blaze1 = list.get(r.nextInt(list.size()));
				
				romprems.getEnderman().add(blaze1);
		        list.remove(blaze1);
		        
				if(list.size() > 0) {
					
					Joueur enderman2 = list.get(r.nextInt(list.size()));
					
					romprems.getEnderman().add(enderman2);
			        list.remove(enderman2);
			        
			        if(list.size() > 0) {
			    		
						Joueur blaze2 = list.get(r.nextInt(list.size()));
						
						romprems.getEnderman().add(blaze2);
				        list.remove(blaze2);
				        	
				        romprems.getPlayer().sendMessage("§5Enderman : " + enderman1.getPlayer().getName() + ", " + enderman2.getPlayer().getName() + "§r\n \n§6Blaze : " + blaze1.getPlayer().getName() + ", " + blaze2.getPlayer().getName());
				        
					}
			        else {
			        	
			        	romprems.getPlayer().sendMessage("§5Enderman : " + enderman1.getPlayer().getName() + ", " + enderman2.getPlayer().getName() + "§r\n \n§6Blaze : " + blaze1.getPlayer().getName());
			        	
			        }
			        
				}
				else {
		        	
		        	romprems.getPlayer().sendMessage("§5Enderman : " + enderman1.getPlayer().getName() + "§r\n \n§6Blaze : " + blaze1.getPlayer().getName());
		        	
		        }
		        
			}
	        else {
	        	
	        	romprems.getPlayer().sendMessage("§5Enderman : " + enderman1.getPlayer().getName());
	        	
	        }
	        
		}
		
	}
	
	public static void Texte(Player player, Main main) {
		
		if(main.getMode() == Modes.RAPIDE) {
			
			player.sendMessage("____________________________________________________\n \n"
					+ "Vous êtes §2RomPrems\n§r"
					+ "Vous devez gagner avec le §2camp UHC§r\n \n"
					+ "Lorsque vous tuer un blaze, vous gagnez aléatoirement 1% de force ou de résistance et avez 2% de chance supplémentaire de mettre un joueur en feu\n \n"
					+ "Lorsque vous tuer un enderman, vous recevez 5% de speed supplémentaire ainsi qu'un enderpearl (avec un cooldown de 3 minutes).\nSi vous tuer un enderman alors que vous avez déjà la pearl, le cooldown sera réduit d'une minute\n \n"
					+ "____________________________________________________");
			
		}
		else {

			player.sendMessage("____________________________________________________\n \n"
					+ "Vous êtes §2RomPrems\n§r"
					+ "Vous devez gagner avec le §2camp UHC§r\n \n"
					+ "Vous avez 20% de speed permanent\n \n"
					+ "Toutes les 5min, vous perdez 2% de speed permanent (vous garderez au minimum 2% de speed)\n \n"
					+ "Plus la partie avance plus vous avez de chance de recevoir un anti-kb ou de vous téléporter sur l'adversaire à chaque coup\n \n"
					+ "Lorsque vous faites un clique gauche sur votre item, vous revenez 3 secondes en arrière (seul la position est affecté) (cooldown : 2min)\n \n"
					+ "Lorsque vous faites un clique droit sur votre item, vous revenez 5 secondes en arrière (votre position, votre vie, vootre inventaire et votre barre de nourriture sont affecté)\n \n"
					+ "Avec la commande /rcinspect <pseudo>, vous recevrez aléatoirement le pourcentage des effets de la cible. Plus la partie avance plus le temps entre l'execution de la commande et la reception des informations seras longue\n \n"
					+ "____________________________________________________");

		}
        
    }

}
