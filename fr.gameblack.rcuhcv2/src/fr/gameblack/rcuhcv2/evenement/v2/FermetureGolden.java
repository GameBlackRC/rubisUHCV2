package fr.gameblack.rcuhcv2.evenement.v2;

import java.util.Random;

import org.bukkit.Sound;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.roles.v2.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.v2.staff.Trial;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;

public class FermetureGolden {
	
	public static void Active(Main main) {
		
		main.setFermetureGolden(false);
		main.setFermetureGoldenActif(true);
		String modeTrial = "fun";
		if(main.getJoueurByRole(Roles.TRIAL).getModeTrial() != null) {
			
			modeTrial = main.getJoueurByRole(Roles.TRIAL).getModeTrial();
			
		}
		
		if(main.getCompo().contains(Roles.TRIAL)) {
			
			Random r = new Random();
            int nb = r.nextInt(100);
			
			Joueur trial = main.getJoueurByRole(Roles.TRIAL);
			
			trial.getPlayer().sendMessage("Golden ferme ses portes");
			
			if(main.getScenarios().contains(Scenarios.SON_EN_FOLIE)) {
			
				trial.getPlayer().playSound(trial.getPlayer().getLocation(), Sound.ENDERDRAGON_DEATH, 10, 1);
				
			}
			
			if((main.getJoueurByRole(Roles.TRIAL).getCamp() == Camps.UHC && nb <= 50) || main.getJoueurByRole(Roles.TRIAL).getCamp() != Camps.DUO && nb <= 5) {
				
				trial.setCamp(Camps.SOLOS);
				trial.getPlayer().sendMessage("Vous devez désormais gagner seul");
				
				if(modeTrial.equalsIgnoreCase("fun")) {
				
					Trial.ItemsFunSolo(trial);
				
				}
				else {
					
					Trial.ItemsSerieuxSolo(trial);
					
				}
				
			}
			
		}
		if(main.getJoueurByRole(Roles.GAMEBLACK) != null) {
			
			Random r = new Random();
            int nb = r.nextInt(100);
            
            if((main.getJoueurByRole(Roles.GAMEBLACK).getCamp() == Camps.UHC && nb <= 50) || nb <= 5) {
            	
    			if(main.getScenarios().contains(Scenarios.SON_EN_FOLIE)) {
    				
    				main.getJoueurByRole(Roles.GAMEBLACK).getPlayer().playSound(main.getJoueurByRole(Roles.GAMEBLACK).getPlayer().getLocation(), Sound.ENDERDRAGON_DEATH, 10, 1);
    				
    			}
            	
            	main.getJoueurByRole(Roles.GAMEBLACK).setCamp(Camps.JOUEUR);
            	GameBlack.itemJoueur(main.getJoueurByRole(Roles.GAMEBLACK), main);
            	main.getJoueurByRole(Roles.GAMEBLACK).getPlayer().sendMessage("Golden ferme ses portes. Vous passez dans le camp joueur");
            	
            }
			
		}
		
		if(main.getCompo().contains(Roles.KZOU)) {
			
			if(main.getScenarios().contains(Scenarios.SON_EN_FOLIE)) {
				
				main.getJoueurByRole(Roles.KZOU).getPlayer().playSound(main.getJoueurByRole(Roles.KZOU).getPlayer().getLocation(), Sound.ENDERDRAGON_DEATH, 10, 1);
				
			}
			
			main.getJoueurByRole(Roles.KZOU).getPlayer().sendMessage("Golden ferme ses portes");
			
		}
		
	}

}
