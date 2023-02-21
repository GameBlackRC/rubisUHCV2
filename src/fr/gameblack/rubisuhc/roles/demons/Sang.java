package fr.gameblack.rubisuhc.roles.demons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.task.ItemCD;

public class Sang {
	
	public static void Items(Player player) {
		
		Texte(player);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
		
	}
	
	public static void CommandSang(Player player, Player cible, Main main) {
		
		if(main.GetCampsDemon().contains(main.getRole(cible))) {
			
			List<String> effet = new ArrayList<>();
			
			if(!cible.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
				
				effet.add("resi");
				
			}
			
			if(main.getPourcentEffet(cible, "force") < 1.25) {
				
				effet.add("force");
				
			}
			
			if(!cible.hasPotionEffect(PotionEffectType.SPEED)) {
				
				effet.add("speed");
				
			}
			
			if(effet.size() == 0) {
				
				player.sendMessage("Ce joueur possède déjà tout les effets");
				
			}
			else {
				
				main.getCD().add(Pouvoirs.SANG_SANG);
				
				Random r = new Random();
				int nb = r.nextInt(effet.size());
				
				if(effet.get(nb) == "force") {
					
					main.addPourcentEffet(cible, "force", 0.15);
					ItemCD cycle = new ItemCD(main, player, "sangforce", 300, cible, null, null);
					cycle.runTaskTimer(main, 0, 20);
					
				}
				else if(effet.get(nb) == "speed") {
					
					cible.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 0, 6000, false, false));
					
				}
				else {
					
					cible.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 0, 6000, false, false));
					
				}
				
			}
			
		}
		else {
			
			List<String> effet = new ArrayList<>();
			
			if(!cible.hasPotionEffect(PotionEffectType.SLOW)) {
				
				effet.add("lenteur");
				
			}
			
			if(!cible.hasPotionEffect(PotionEffectType.WEAKNESS)) {
				
				effet.add("faiblesse");
				
			}
			
			if(effet.size() == 0) {
				
				player.sendMessage("Ce joueur possède déjà tout les effets");
				
			}
			else {
				
				Random r = new Random();
				int nb = r.nextInt(effet.size());
				
				main.getCD().add(Pouvoirs.SANG_SANG);
				
				if(effet.get(nb) == "lenteur") {
					
					cible.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 0, 3600, false, false));
					
				}
				else {
					
					cible.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 0, 3600, false, false));
					
				}
				
			}
			
		}
		
	}
	
	public static void Texte(Player player) {
		
		player.sendMessage("____________________________________________________\n \nVous êtes le §cDémon Sang\n§rVous devez gagner avec le §ccamps démon§r\n \nVous avez l'effet speed I permanent et l'effet force I la nuit\n \nAvec la commande /rcsang <pseudo>, vous pourrez donner aléatoirement speed I, force I ou résistance I pendant 5 minutes si le joueur ciblé est un démon ou faiblesse I ou lenteur I pendant 3 minutes si le joueur ciblé n'est pas un démon\n \nVous connaissez Slup\n \n____________________________________________________");
		
	}
	
}
