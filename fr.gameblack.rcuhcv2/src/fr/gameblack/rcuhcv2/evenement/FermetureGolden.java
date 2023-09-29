package fr.gameblack.rcuhcv2.evenement;

import java.util.Random;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.roles.staff.Trial;

public class FermetureGolden {
	
	public static void Active(Main main) {
		
		main.setFermetureGolden(false);
		main.setFermetureGoldenActif(true);
		
		if(main.getCompo().contains(Roles.TRIAL)) {
			
			Joueur trial = main.getJoueurByRole(Roles.TRIAL);
			
			trial.getPlayer().sendMessage("Golden ferme ses portes");
			
			if(main.getJoueurByRole(Roles.TRIAL).getCamp() == "uhc") {
				
				trial.setCamp("solo");
				trial.getPlayer().sendMessage("Vous devez désormais gagner seul");
				
				if(trial.getModeTrial().equalsIgnoreCase("fun")) {
				
					Trial.ItemsFunSolo(trial);
				
				}
				else {
					
					Trial.ItemsSerieuxSolo(trial);
					
				}
				
			}
			
		}
		if(main.getCompo().contains(Roles.GAMEBLACK) && main.getJoueurByRole(Roles.GAMEBLACK).getCamp() == "uhc") {
			
			Random r = new Random();
            int nb = r.nextInt(2);
            
            if(nb == 1) {
            	
            	main.getJoueurByRole(Roles.GAMEBLACK).setCamp("joueur");
            	main.getJoueurByRole(Roles.GAMEBLACK).getPlayer().sendMessage("Golden ferme ses portes. Vous passez dans le camp joueur");
            	
            }
			
		}
		
		if(main.getCompo().contains(Roles.KZOU)) {
			
			main.getJoueurByRole(Roles.KZOU).getPlayer().sendMessage("Golden ferme ses portes");
			
		}
		
	}

}
