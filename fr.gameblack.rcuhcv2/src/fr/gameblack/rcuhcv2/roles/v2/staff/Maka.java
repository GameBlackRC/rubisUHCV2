package fr.gameblack.rcuhcv2.roles.v2.staff;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;

public class Maka {
	
	public static void Items(Joueur joueur) {
		
		Texte(joueur.getPlayer());
		joueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 0, false, false));
		if(joueur.isBot()) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tell " + joueur.getPlayer().getName() + " role Maka");
			
		}
		
	}
	
	public static void FormeSimp(Joueur joueur, Main main) {
		
		if(main.getNeko() == null) {
		
			List<Joueur> campStaff = main.getCampStaff();
			
			if(campStaff.size() > 1) {
			
				joueur.setForme("simp");
				
				Random r = new Random();
				
				campStaff.remove(joueur);
				
		        int nb = r.nextInt(campStaff.size());
				
				main.setNeko(campStaff.get(nb));
				
				main.setNbJoueursStaff(campStaff.size());
				
				joueur.getPlayer().sendMessage("Voici le pseudo de Neko : " + main.getNeko().getPlayer().getName());
				
				main.getNeko().getPlayer().sendMessage("Maka vient de passer dans sa forme simp, vous êtes Neko");
				
				if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
					
					Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
					
		            nb = r.nextInt(100);
		            
		            if(nb <= 80) {
		            	
		            	gb.getPlayer().sendMessage("[CONSOLE]" + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient d'effectuer une commande");
		            	
		            }
		            else {
		            	
		            	gb.getPlayer().sendMessage("[CONSOLE]" + joueur.getPlayer().getName() + " vient d'effectuer une commande");
		            	
		            }
					
				}
				
			}
			else {
				
				joueur.getPlayer().sendMessage("Vous ne pouvez pas passer en forme Simp car il n'y a plus aucun membre du staff");
				
			}
			
		}
		else {
			
			joueur.getPlayer().sendMessage("Vous êtes déjà en forme simp");
			
		}
			
	}
	
	public static void Texte(Player player) {

        player.sendMessage("____________________________________________________\n \n"
        		+ "Vous êtes §9Maka\n§r"
        		+ "Vous devez gagner avec le §9camp staff§r\n \n"
        		+ "Vous avez l'effet résistance au feu permanent\n \n"
        		+ "Avec la commande /rcforme, vous pouvez passer en forme simp\n"
        		+ "Moins il reste de joueur dans le camp staff lors du changement de forme, plus vous obtiendrez d'effets dans les différents cas\n \n"
        		+ "Tant que vous n'êtes pas en forme simp, vous avez 10% de chance de mettre un joueur en feu, vous recevez aussi 2% de résistance proche de Team et 2% de force (invisible avec le /rceffet) proche de GameBlack\n \n"
        		+ "Lorsque vous passez en mode simp, un joueur est désigné comme Neko\n"
        		+ "Lorsque vous êtes proche de Neko, vous et Neko recevez des effets supplémentaire\n"
        		+ "Lorsque Neko subi un coup et que vous êtes à plus de 20 blocs, vous recevez le pseudo du joueur lui mettant un coup\n"
        		+ "Lorsqu'un joueur frappe Neko, il subira 2% de dégâts supplémentaire de votre part pendant 10 secondes\n"
        		+ "Si Neko vient à mourrir, vous perdez un coeur permanent toutes les 5 minutes tant que le tueur de Neko n'est pas mort\n "
        		+ "Si vous parvenez à tuer le tueur de neko, vous retournez à 9 coeurs permanent si vous en avez moins, vous recevez de manière permanente des pourcentages d'effets\n"
        		+ "Si vous venez à mourrir avant Neko, Neko recevra des pourcents d'effets permanent\n \n"
        		+ "____________________________________________________");

    }

}
