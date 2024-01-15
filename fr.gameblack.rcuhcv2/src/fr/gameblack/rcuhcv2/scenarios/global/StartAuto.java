package fr.gameblack.rcuhcv2.scenarios.global;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.task.Autostart;

public class StartAuto {
	
	private static Scoreboard board_base = Bukkit.getScoreboardManager().getNewScoreboard();
    
    private static Scoreboard board_pourcent = Bukkit.getScoreboardManager().getNewScoreboard();
	
	public static void setStartAuto(Main main) {
		
		if(main.getMode() == Modes.RAPIDE) {
			
			if(main.getVersion() == 2) {
				
				main.getCompo().clear();
				
				main.getCompo().add(Roles.RAPTOR);
                main.getCompo().add(Roles.JEANNOT);
                main.getCompo().add(Roles.NICKOBOOP);
                main.getCompo().add(Roles.SLUP);
                main.getCompo().add(Roles.JOKO);
                
                main.getCompo().add(Roles.TEAM);
                main.getCompo().add(Roles.GAMEBLACK);
                main.getCompo().add(Roles.MAKA);
                main.getCompo().add(Roles.TRIAL);
                main.getCompo().add(Roles.LOUP);
                main.getCompo().add(Roles.CAPTAIN);
                main.getCompo().add(Roles.HEKOW);
                
                main.getCompo().add(Roles.MALIVOL);
                main.getCompo().add(Roles.TOINOU);
                main.getCompo().add(Roles.OBSCUR);
                main.getCompo().add(Roles.NONOBOY);
                main.getCompo().add(Roles.THEOOCHOUX);
                main.getCompo().add(Roles.ROMPREMS);
                
                main.getCompo().add(Roles.FARMEURIMMO);
                main.getCompo().add(Roles.KZOU);
                
            	main.updateScoreboard();
				
			}
			else {
				
				main.getCompo().clear();
				
				main.getCompo().add(Roles.GameBlack);
        		main.getCompo().add(Roles.Team);
        		main.getCompo().add(Roles.Joko);
        		main.getCompo().add(Roles.Maka);
        		main.getCompo().add(Roles.Loup);
        		main.getCompo().add(Roles.Raptor);
        		main.getCompo().add(Roles.Guerrier);
        		main.getCompo().add(Roles.Archer);
        		
        		main.getCompo().add(Roles.Malivol);
        		main.getCompo().add(Roles.Ange);
        		main.getCompo().add(Roles.Enfer);
        		main.getCompo().add(Roles.Electrique);
        		main.getCompo().add(Roles.Malediction);
        		main.getCompo().add(Roles.Sang);
        		main.getCompo().add(Roles.Tenebre);
        		
        		main.getCompo().add(Roles.Experimental);
        		main.getCompo().add(Roles.Farmeurimmo);
        		main.getCompo().add(Roles.Kzou);
        		
            	main.updateScoreboard();
				
			}
			
			Bukkit.getScheduler().runTaskAsynchronously(main, () -> {
				
                Autostart start = new Autostart(main, board_base, board_pourcent);
                start.runTaskTimer(main, 0, 20);

            });
			
		}
		
	}

}
