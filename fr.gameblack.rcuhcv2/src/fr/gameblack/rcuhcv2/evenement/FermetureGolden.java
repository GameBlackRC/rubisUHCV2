package fr.gameblack.rcuhcv2.evenement;

import java.util.Random;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.staff.Trial;

public class FermetureGolden {
	
	public static void Active(Main main) {
		
		main.setFermetureGolden(false);
		main.setFermetureGoldenActif(true);
		
		if(main.getCompo().contains(Roles.TRIAL)) {
			
			Random r = new Random();
            int nb = r.nextInt(100);
			
			Joueur trial = main.getJoueurByRole(Roles.TRIAL);
			
			trial.getPlayer().sendMessage("Golden ferme ses portes");
			
			if(main.getJoueurByRole(Roles.TRIAL).getCamp() == "uhc" && nb <= 50) {
				
				trial.setCamp("solo");
				trial.getPlayer().sendMessage("Vous devez désormais gagner seul");
				
				if(main.getModeTrial().equalsIgnoreCase("fun")) {
				
					Trial.ItemsFunSolo(trial);
				
				}
				else {
					
					Trial.ItemsSerieuxSolo(trial);
					
				}
				
			}
			
		}
		if(main.getJoueurByRole(Roles.GAMEBLACK) != null && main.getJoueurByRole(Roles.GAMEBLACK).getCamp() == "uhc") {
			
			Random r = new Random();
            int nb = r.nextInt(100);
            
            if(nb <= 50) {
            	
            	main.getJoueurByRole(Roles.GAMEBLACK).setCamp("joueur");
            	GameBlack.itemJoueur(main.getJoueurByRole(Roles.GAMEBLACK), main);
            	main.getJoueurByRole(Roles.GAMEBLACK).getPlayer().sendMessage("Golden ferme ses portes. Vous passez dans le camp joueur");
            	
            }
			
		}
		
		if(main.getCompo().contains(Roles.KZOU)) {
			
			main.getJoueurByRole(Roles.KZOU).getPlayer().sendMessage("Golden ferme ses portes");
			
		}
		
	}

}
