package fr.gameblack.rcuhcv2.roles.staff;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.task.ItemCD;

public class Team {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		ItemStack coffre = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta coffreM = coffre.getItemMeta();
        coffreM.setDisplayName("Justice");
        coffre.setItemMeta(coffreM);
        joueur.getPlayer().getInventory().addItem(coffre);
		
	}
	
	public static void InteractJusticeStaff(Joueur joueur, Main main) {
		
		if(!main.getCD().contains(Pouvoirs.TEAM_JUSTICE)) {
			
			main.getCD().add(Pouvoirs.TEAM_JUSTICE);
			joueur.getPlayer().sendMessage("Vous venez d'activer votre pouvoir 'Justice'");
			main.setZoneJusticeActif(true);
			
			joueur.addSpeed(0.05);
			ItemCD cycle = new ItemCD(main, joueur, "justice_team", 60, joueur, null, null, null, null);
		    cycle.runTaskTimer(main, 0, 20);
			
		}
		
	}
	
	public static void checkZoneJustice(Main main) {
		
		Joueur team = main.getJoueurByRole(Roles.TEAM);
		
		if(team != null) {
			
			List<Joueur> inZone = new ArrayList<>();
			
			for(Entity entity : team.getPlayer().getNearbyEntities(20, 20, 20)) {
				
				if(entity instanceof Player) {
					
					Player pls = (Player) entity;
					Joueur joueur = main.getJoueur(pls);
					
					if(!joueur.isInZoneJustice()) {
						
						joueur.setInZoneJustice(true);
						
						if(joueur.getCamp().equalsIgnoreCase("staff") || joueur.getRole() == Roles.TRIAL || joueur.getRole() == Roles.GAMEBLACK) {
							
							joueur.addSpeed(0.05);
							
						}
						else {
							
							joueur.removeResi(0.01);
							joueur.removeForce(0.01);
							
						}
						
					}
					
					inZone.add(joueur);
					
				}
				
			}
			
			for(Joueur j : main.getJoueurInGame()) {
				
				if(!inZone.contains(j) && j.isInZoneJustice()) {
					
					j.setInZoneJustice(false);

					if(j.getCamp().equalsIgnoreCase("staff") || j.getRole() == Roles.TRIAL || j.getRole() == Roles.GAMEBLACK) {
						
						j.removeSpeed(0.05);
						
					}
					else {
						
						j.addResi(0.01);
						j.addForce(0.01);
						
					}
					
				}
				
			}
			
		}
		
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \nVous êtes §9Team\n§rVous devez gagner avec le §9camp staff§r\n \nVous recevez 2% de résistance supplémentaire lorsque vous êtes proche de Farmeurimmo (invisible avec le /rceffet)\n \n____________________________________________________");

    }

}
