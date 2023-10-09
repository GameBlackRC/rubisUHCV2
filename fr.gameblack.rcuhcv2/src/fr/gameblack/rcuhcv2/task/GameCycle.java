package fr.gameblack.rcuhcv2.task;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import fr.gameblack.rcuhcv2.Joueur;
import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Orbe;
import fr.gameblack.rcuhcv2.Pouvoirs;
import fr.gameblack.rcuhcv2.Roles;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.evenement.FermetureGolden;
import fr.gameblack.rcuhcv2.orbes.Foudre;
import fr.gameblack.rcuhcv2.orbes.Glace;
import fr.gameblack.rcuhcv2.roles.joueur.Nickoboop;
import fr.gameblack.rcuhcv2.roles.staff.GameBlack;

public class GameCycle extends BukkitRunnable {

    private Main main;

    private int timer = 0;
    
    //private boolean objectif_pourcent_creer = false;
    
    private static Scoreboard board_base;
    
    private static Scoreboard board_raptor;
    private static Scoreboard board_jeannot;
    private static Scoreboard board_nickoboop;
    private static Scoreboard board_slup;
    private static Scoreboard board_joko;
    
    private static Scoreboard board_team;
    private static Scoreboard board_gameblack;
    private static Scoreboard board_maka;
    private static Scoreboard board_trial;
    private static Scoreboard board_loup;
    private static Scoreboard board_captain;
    private static Scoreboard board_hekow;
    
    private static Scoreboard board_malivol;
    private static Scoreboard board_toinou;
    private static Scoreboard board_obscur;
    private static Scoreboard board_nonoboy;
    
    private static Scoreboard board_farmeurimmo;
    private static Scoreboard board_kzou;
    
    @SuppressWarnings("unused")
	private Scoreboard board_pourcent;
    
    private boolean score_board = true;

    @SuppressWarnings("static-access")
	public GameCycle(Main main, Scoreboard board_base, Scoreboard board_pourcent, Scoreboard board_raptor, Scoreboard board_jeannot, Scoreboard board_nickoboop, Scoreboard board_slup, Scoreboard board_joko, Scoreboard board_team, Scoreboard board_gameblack, Scoreboard board_maka, Scoreboard board_trial, Scoreboard board_loup, Scoreboard board_captain, Scoreboard board_hekow, Scoreboard board_malivol, Scoreboard board_toinou, Scoreboard board_obscur, Scoreboard board_nonoboy, Scoreboard board_farmeurimmo, Scoreboard board_kzou) {
        this.main = main;
        this.board_base = board_base;
        this.board_pourcent = board_pourcent;
        
        this.board_raptor = board_raptor;
        this.board_jeannot = board_jeannot;
        this.board_nickoboop = board_nickoboop;
        this.board_slup = board_slup;
        this.board_joko = board_joko;
        
        this.board_team = board_team;
        this.board_gameblack = board_gameblack;
        this.board_maka = board_maka;
        this.board_trial = board_trial;
        this.board_loup = board_loup;
        this.board_captain = board_captain;
        this.board_hekow = board_hekow;
        
        this.board_malivol = board_malivol;
        this.board_toinou = board_toinou;
        this.board_obscur = board_obscur;
        this.board_nonoboy = board_nonoboy;
        
        this.board_farmeurimmo = board_farmeurimmo;
        this.board_kzou = board_kzou;
    }

    public static void Nuit(Main main) {
    	
    	if(main.isFermetureGolden()) {

	        if(main.getEpisode() == 1 && main.getMode().equalsIgnoreCase("rapide")) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 2) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 3) {
	        	
	        	if(main.getMode().equalsIgnoreCase("rapide")) {
	        		
	        		FermetureGolden.Active(main);
	        		
	        	}
	        	else {
	        		
	        		Random r = new Random();
	                int nb = r.nextInt(100);
	                
	                if(nb <= 25) {
	                	
	                	FermetureGolden.Active(main);
	                	
	                }
	        		
	        	}
	        	
	        }
	        else if(main.getEpisode() == 4 && main.getMode().equalsIgnoreCase("normal")) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 5 && main.getMode().equalsIgnoreCase("normal")) {
	            	
	            FermetureGolden.Active(main);
	        	
	        }
        
    	}

    }

    public static void Jour(Main main) {
    	
    	if(main.isFermetureGolden()) {

	    	if(main.getEpisode() == 1 && main.getMode().equalsIgnoreCase("rapide")) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 2) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 3) {
	        	
	        	if(main.getMode().equalsIgnoreCase("rapide")) {
	        		
	        		FermetureGolden.Active(main);
	        		
	        	}
	        	else {
	        		
	        		Random r = new Random();
	                int nb = r.nextInt(100);
	                
	                if(nb <= 25) {
	                	
	                	FermetureGolden.Active(main);
	                	
	                }
	        		
	        	}
	        	
	        }
	        else if(main.getEpisode() == 4 && main.getMode().equalsIgnoreCase("normal")) {
	        	
	        	Random r = new Random();
	            int nb = r.nextInt(100);
	            
	            if(nb <= 25) {
	            	
	            	FermetureGolden.Active(main);
	            	
	            }
	        	
	        }
	        else if(main.getEpisode() == 5 && main.getMode().equalsIgnoreCase("normal")) {
	            	
	            FermetureGolden.Active(main);
	        	
	        }
	    	
    	}

    }
    
    public static void resetCD(Main main) {
    	
    	if(main.getCD().contains(Pouvoirs.MALIVOL_CHEAT)) {
    		
    		main.getCD().remove(Pouvoirs.MALIVOL_CHEAT);
    		
    	}
    	else if(main.getCD().contains(Pouvoirs.RAPTOR_RAGE)) {
    		
    		main.getCD().remove(Pouvoirs.RAPTOR_RAGE);
    		
    	}
    	
    }
    
    public static void setRole(Main main) {
    	
    	main.setState(Statut.PVP_ON);
    	
    	List<Roles> compo = main.getCompo();
    	
    	int nombre = compo.size()-1;
    	
    	List<Roles> compo_ = new ArrayList<>();
    	
    	System.out.println("____________________________");
    	
    	System.out.println("taille : " + nombre);
    	
    	for(Roles role : compo) {
    		
    		System.out.println("Role : " + role.toString());
    		
    	}
    	
    	System.out.println("____________________________");

        for (Joueur j : main.getListJoueurs()) {
        	
        	if(nombre > 0) {
        	
	        	Player pls = j.getPlayer();
	
	            Random r = new Random();
	            int nb = r.nextInt(nombre);
	            System.out.println("Random (nb) : " + nb);
	            Roles role = compo.get(nb);
	            compo_.add(role);
	            j.setRole(role);
	            compo.remove(role);
	            nombre -= 1;
	            j.setInvulnerable(false);
	
	            pls.setHealth(pls.getMaxHealth());
	            
        	}
        	else {
        		
        		Player pls = j.getPlayer();
        		
        		Roles role = compo.get(0);
        		compo_.add(role);
        		j.setRole(role);
        		compo.remove(role);
        		j.setInvulnerable(false);
        		pls.setHealth(pls.getMaxHealth());
        		
        	}

        }
        
        main.setCompo(compo_);
        
        if(main.getCompo().contains(Roles.JEANNOT) && main.getCompo().contains(Roles.NICKOBOOP)) {
        	
        	Joueur jeannot = main.getJoueurByRole(Roles.JEANNOT);
        	Joueur nickoboop = main.getJoueurByRole(Roles.NICKOBOOP);
        	jeannot.getPlayer().sendMessage("Nickoboop : " + nickoboop.getPlayer().getDisplayName());
        	nickoboop.getPlayer().sendMessage("Jeannot : " + jeannot.getPlayer().getDisplayName());
        	
        }
        
        if(main.getCompo().contains(Roles.TRIAL) && main.getCompo().contains(Roles.LOUP)) {
        	
        	Joueur trial = main.getJoueurByRole(Roles.TRIAL);
        	Joueur loup = main.getJoueurByRole(Roles.LOUP);
        	trial.getPlayer().sendMessage("Loup : " + loup.getPlayer().getDisplayName());
        	
        }
    	
    }

    public static void setScoreboard(Main main, int timer) {
    	
    	if(!board_base.getObjectives().isEmpty()) {
			board_base.getObjective("test").unregister();
		}
        
        Objective objective_base = board_base.registerNewObjective("test", "dummy");
        objective_base.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective_base.setDisplayName("RC UHC V2");
        Score score1_base = objective_base.getScore("Durée: " + timer/10 + "s");
        score1_base.setScore(1);
        
        if((main.getEpisode() > 1 || (main.getEpisode() == 2 && main.getTemps() > 2)) || (main.getTemps() > 10 && main.getEpisode() >= 1 && main.getMode().equalsIgnoreCase("rapide"))) {
        	
        	if(main.getCompo().contains(Roles.RAPTOR)) {
            	
            	if(!board_raptor.getObjectives().isEmpty()) {
            		board_raptor.getObjective("test").unregister();
            	}
            		
            	Objective objective_raptor = board_raptor.registerNewObjective("test", "dummy");
                
		        objective_raptor.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_raptor.setDisplayName("RC UHC V2");
		        Score score1_raptor = objective_raptor.getScore("Durée: " + timer/10 + "s");
		        score1_raptor.setScore(6);
		        Joueur raptor = main.getJoueurByRole(Roles.RAPTOR);
		        Score score2_raptor = objective_raptor.getScore("Role: " + raptor.getCouleurCamp() + "Raptor");
		        score2_raptor.setScore(5);
		        Score score3_raptor;
		        if(raptor.getOrbe() == Orbe.EAU) {
		        	
		        	score3_raptor = objective_raptor.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(raptor.getOrbe() == Orbe.FEU) {
		        	
		        	score3_raptor = objective_raptor.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(raptor.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_raptor = objective_raptor.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(raptor.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_raptor = objective_raptor.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_raptor = objective_raptor.getScore("Orbe: Aucune");
		        	
		        }
		        
		        score3_raptor.setScore(4);
		        Score score4_raptor;
		        if(main.getJoueurByRole(Roles.RAPTOR).isOrbeActif()) {
		        	
		        	score4_raptor = objective_raptor.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_raptor = objective_raptor.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_raptor.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.JEANNOT)) {
            	
            	if(!board_jeannot.getObjectives().isEmpty()) {
            		board_jeannot.getObjective("test").unregister();
        		}
            		
            	Objective objective_jeannot = board_jeannot.registerNewObjective("test", "dummy");
                
		        objective_jeannot.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_jeannot.setDisplayName("RC UHC V2");
		        Score score1_jeannot = objective_jeannot.getScore("Durée: " + timer/10 + "s");
		        score1_jeannot.setScore(6);
		        Joueur jeannot = main.getJoueurByRole(Roles.JEANNOT);
		        Score score2_jeannot = objective_jeannot.getScore("Role: " + jeannot.getCouleurCamp() + "Jeannot");
		        score2_jeannot.setScore(5);
		        Score score3_jeannot;
		        if(jeannot.getOrbe() == Orbe.EAU) {
		        	
		        	score3_jeannot = objective_jeannot.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(jeannot.getOrbe() == Orbe.FEU) {
		        	
		        	score3_jeannot = objective_jeannot.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(jeannot.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_jeannot = objective_jeannot.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(jeannot.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_jeannot = objective_jeannot.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_jeannot = objective_jeannot.getScore("Orbe: Aucune");
		        	
		        }
		        score3_jeannot.setScore(4);
		        Score score4_jeannot;
		        if(main.getJoueurByRole(Roles.JEANNOT).isOrbeActif()) {
		        	
		        	score4_jeannot = objective_jeannot.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_jeannot = objective_jeannot.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_jeannot.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.NICKOBOOP)) {
	                   	
            	if(!board_nickoboop.getObjectives().isEmpty()) {
            		board_nickoboop.getObjective("test").unregister();
        		}
            		
            	Objective objective_nickoboop = board_nickoboop.registerNewObjective("test", "dummy");
                
		        objective_nickoboop.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_nickoboop.setDisplayName("RC UHC V2");
		        Score score1_nickoboop = objective_nickoboop.getScore("Durée: " + timer/10 + "s");
		        score1_nickoboop.setScore(6);
		        Joueur nickoboop = main.getJoueurByRole(Roles.NICKOBOOP);
		        Score score2_nickoboop = objective_nickoboop.getScore("Role: " + nickoboop.getCouleurCamp() + "Nickoboop");
		        score2_nickoboop.setScore(5);
		        Score score3_nickoboop;
		        if(nickoboop.getOrbe() == Orbe.EAU) {
		        	
		        	score3_nickoboop = objective_nickoboop.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(nickoboop.getOrbe() == Orbe.FEU) {
		        	
		        	score3_nickoboop = objective_nickoboop.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(nickoboop.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_nickoboop = objective_nickoboop.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(nickoboop.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_nickoboop = objective_nickoboop.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_nickoboop = objective_nickoboop.getScore("Orbe: Aucune");
		        	
		        }
		        score3_nickoboop.setScore(4);
		        Score score4_nickoboop;
		        if(main.getJoueurByRole(Roles.NICKOBOOP).isOrbeActif()) {
		        	
		        	score4_nickoboop = objective_nickoboop.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_nickoboop = objective_nickoboop.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_nickoboop.setScore(3);
		    
        	}
        	
        	if(main.getCompo().contains(Roles.SLUP)) {
	                    	
            	if(!board_slup.getObjectives().isEmpty()) {
            		board_slup.getObjective("test").unregister();
        		}
            		
            	Objective objective_slup = board_slup.registerNewObjective("test", "dummy");
                
		        objective_slup.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_slup.setDisplayName("RC UHC V2");
		        Score score1_slup = objective_slup.getScore("Durée: " + timer/10 + "s");
		        score1_slup.setScore(6);
		        Joueur slup = main.getJoueurByRole(Roles.SLUP);
		        Score score2_slup = objective_slup.getScore("Role: " + slup.getCouleurCamp() + "Slup");
		        score2_slup.setScore(5);
		        Score score3_slup;
		        if(slup.getOrbe() == Orbe.EAU) {
		        	
		        	score3_slup = objective_slup.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(slup.getOrbe() == Orbe.FEU) {
		        	
		        	score3_slup = objective_slup.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(slup.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_slup = objective_slup.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(slup.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_slup = objective_slup.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_slup = objective_slup.getScore("Orbe: Aucune");
		        	
		        }
		        score3_slup.setScore(4);
		        Score score4_slup;
		        if(main.getJoueurByRole(Roles.SLUP).isOrbeActif()) {
		        	
		        	score4_slup = objective_slup.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_slup = objective_slup.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_slup.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.JOKO)) {
	                    	
            	if(!board_joko.getObjectives().isEmpty()) {
            		board_joko.getObjective("test").unregister();
        		}
            		
            	Objective objective_joko = board_joko.registerNewObjective("test", "dummy");
                
		        objective_joko.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_joko.setDisplayName("RC UHC V2");
		        Score score1_joko = objective_joko.getScore("Durée: " + timer/10 + "s");
		        score1_joko.setScore(6);
		        Joueur joko = main.getJoueurByRole(Roles.JOKO);
		        Score score2_joko = objective_joko.getScore("Role: " + joko.getCouleurCamp() + " Joko");
		        score2_joko.setScore(5);
		        Score score3_joko;
		        if(joko.getOrbe() == Orbe.EAU) {
		        	
		        	score3_joko = objective_joko.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(joko.getOrbe() == Orbe.FEU) {
		        	
		        	score3_joko = objective_joko.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(joko.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_joko = objective_joko.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(joko.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_joko = objective_joko.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_joko = objective_joko.getScore("Orbe: Aucune");
		        	
		        }
		        score3_joko.setScore(4);
		        Score score4_joko;
		        if(main.getJoueurByRole(Roles.JOKO).isOrbeActif()) {
		        	
		        	score4_joko = objective_joko.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_joko = objective_joko.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_joko.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.TEAM)) {
                   	
            	if(!board_team.getObjectives().isEmpty()) {
            		board_team.getObjective("test").unregister();
        		}
            		
            	Objective objective_team = board_team.registerNewObjective("test", "dummy");
                
		        objective_team.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_team.setDisplayName("RC UHC V2");
		        Score score1_team = objective_team.getScore("Durée: " + timer/10 + "s");
		        score1_team.setScore(6);
		        Joueur team = main.getJoueurByRole(Roles.TEAM);
		        Score score2_team = objective_team.getScore("Role: " + team.getCouleurCamp() + " Team");
		        score2_team.setScore(5);
		        Score score3_team;
		        if(team.getOrbe() == Orbe.EAU) {
		        	
		        	score3_team = objective_team.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(team.getOrbe() == Orbe.FEU) {
		        	
		        	score3_team = objective_team.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(team.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_team = objective_team.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(team.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_team = objective_team.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_team = objective_team.getScore("Orbe: Aucune");
		        	
		        }
		        score3_team.setScore(4);
		        Score score4_team;
		        if(main.getJoueurByRole(Roles.TEAM).isOrbeActif()) {
		        	
		        	score4_team = objective_team.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_team = objective_team.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_team.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.GAMEBLACK)) {
            	
            	if(!board_gameblack.getObjectives().isEmpty()) {
            		board_gameblack.getObjective("test").unregister();
        		}
            		
            	Objective objective_gb = board_gameblack.registerNewObjective("test", "dummy");
                
		        objective_gb.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_gb.setDisplayName("RC UHC V2");
		        Score score1_gb = objective_gb.getScore("Durée: " + timer/10 + "s");
		        score1_gb.setScore(6);
		        Joueur gameblack = main.getJoueurByRole(Roles.GAMEBLACK);
		        Score score2_gb = objective_gb.getScore("Role: " + gameblack.getCouleurCamp() + "GameBlack");
		        score2_gb.setScore(5);
		        Score score3_gb;
		        if(gameblack.getOrbe() == Orbe.EAU) {
		        	
		        	score3_gb = objective_gb.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(gameblack.getOrbe() == Orbe.FEU) {
		        	
		        	score3_gb = objective_gb.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(gameblack.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_gb = objective_gb.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(gameblack.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_gb = objective_gb.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_gb = objective_gb.getScore("Orbe: Aucune");
		        	
		        }
		        score3_gb.setScore(4);
		        Score score4_gb;
		        if(main.getJoueurByRole(Roles.GAMEBLACK).isOrbeActif()) {
		        	
		        	score4_gb = objective_gb.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_gb = objective_gb.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_gb.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.MAKA)) {
            	
            	if(!board_maka.getObjectives().isEmpty()) {
            		board_maka.getObjective("test").unregister();
        		}
            		
            	Objective objective_maka = board_maka.registerNewObjective("test", "dummy");
                
		        objective_maka.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_maka.setDisplayName("RC UHC V2");
		        Score score1_maka = objective_maka.getScore("Durée: " + timer/10 + "s");
		        score1_maka.setScore(6);
		        Joueur maka = main.getJoueurByRole(Roles.MAKA);
		        Score score2_maka = objective_maka.getScore("Role: " + maka.getCouleurCamp() + "Maka");
		        score2_maka.setScore(5);
		        Score score3_maka;
		        if(maka.getOrbe() == Orbe.EAU) {
		        	
		        	score3_maka = objective_maka.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(maka.getOrbe() == Orbe.FEU) {
		        	
		        	score3_maka = objective_maka.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(maka.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_maka = objective_maka.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(maka.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_maka = objective_maka.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_maka = objective_maka.getScore("Orbe: Aucune");
		        	
		        }
		        score3_maka.setScore(4);
		        Score score4_maka;
		        if(main.getJoueurByRole(Roles.MAKA).isOrbeActif()) {
		        	
		        	score4_maka = objective_maka.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_maka = objective_maka.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_maka.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.TRIAL)) {
	        
        		if(!board_trial.getObjectives().isEmpty()) {
            		board_trial.getObjective("test").unregister();
        		}
            		
            	Objective objective_trial = board_trial.registerNewObjective("test", "dummy");
                
		        objective_trial.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_trial.setDisplayName("RC UHC V2");
		        Score score1_trial = objective_trial.getScore("Durée: " + timer/10 + "s");
		        score1_trial.setScore(6);
		        Joueur trial = main.getJoueurByRole(Roles.TRIAL);
		        Score score2_trial = objective_trial.getScore("Role: " + trial.getCouleurCamp() + "Trial");
		        score2_trial.setScore(5);
		        Score score3_trial;
		        if(trial.getOrbe() == Orbe.EAU) {
		        	
		        	score3_trial = objective_trial.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(trial.getOrbe() == Orbe.FEU) {
		        	
		        	score3_trial = objective_trial.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(trial.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_trial = objective_trial.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(trial.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_trial = objective_trial.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_trial = objective_trial.getScore("Orbe: Aucune");
		        	
		        }
		        score3_trial.setScore(4);
		        Score score4_trial;
		        if(main.getJoueurByRole(Roles.TRIAL).isOrbeActif()) {
		        	
		        	score4_trial = objective_trial.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_trial = objective_trial.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_trial.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.LOUP)) {
	        
        		if(!board_loup.getObjectives().isEmpty()) {
            		board_loup.getObjective("test").unregister();
        		}
            		
            	Objective objective_loup = board_loup.registerNewObjective("test", "dummy");
                
		        objective_loup.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_loup.setDisplayName("RC UHC V2");
		        Score score1_loup = objective_loup.getScore("Durée: " + timer/10 + "s");
		        score1_loup.setScore(6);
		        Joueur loup = main.getJoueurByRole(Roles.LOUP);
		        Score score2_loup = objective_loup.getScore("Role: " + loup.getCouleurCamp() + "Loup");
		        score2_loup.setScore(5);
		        Score score3_loup;
		        if(loup.getOrbe() == Orbe.EAU) {
		        	
		        	score3_loup = objective_loup.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(loup.getOrbe() == Orbe.FEU) {
		        	
		        	score3_loup = objective_loup.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(loup.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_loup = objective_loup.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(loup.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_loup = objective_loup.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_loup = objective_loup.getScore("Orbe: Aucune");
		        	
		        }
		        score3_loup.setScore(4);
		        Score score4_loup;
		        if(main.getJoueurByRole(Roles.LOUP).isOrbeActif()) {
		        	
		        	score4_loup = objective_loup.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_loup = objective_loup.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_loup.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.CAPTAIN)) {
            	
            	if(!board_captain.getObjectives().isEmpty()) {
            		board_captain.getObjective("test").unregister();
        		}
            	
            	Objective objective_captain = board_captain.registerNewObjective("test", "dummy");
                
		        objective_captain.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_captain.setDisplayName("RC UHC V2");
		        Score score1_captain = objective_captain.getScore("Durée: " + timer/10 + "s");
		        score1_captain.setScore(6);
		        Joueur captain = main.getJoueurByRole(Roles.CAPTAIN);
		        Score score2_captain = objective_captain.getScore("Role: " + captain.getCouleurCamp() + "Captain");
		        score2_captain.setScore(5);
		        Score score3_captain;
		        if(captain.getOrbe() == Orbe.EAU) {
		        	
		        	score3_captain = objective_captain.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(captain.getOrbe() == Orbe.FEU) {
		        	
		        	score3_captain = objective_captain.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(captain.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_captain = objective_captain.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(captain.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_captain = objective_captain.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_captain = objective_captain.getScore("Orbe: Aucune");
		        	
		        }
		        score3_captain.setScore(4);
		        Score score4_captain;
		        if(main.getJoueurByRole(Roles.CAPTAIN).isOrbeActif()) {
		        	
		        	score4_captain = objective_captain.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_captain = objective_captain.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_captain.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.HEKOW)) {
            	
            	if(!board_hekow.getObjectives().isEmpty()) {
            		board_hekow.getObjective("test").unregister();
        		}
            		
            	Objective objective_hekow = board_hekow.registerNewObjective("test", "dummy");
                
		        objective_hekow.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_hekow.setDisplayName("RC UHC V2");
		        Score score1_hekow = objective_hekow.getScore("Durée: " + timer/10 + "s");
		        score1_hekow.setScore(6);
		        Joueur hekow = main.getJoueurByRole(Roles.HEKOW);
		        Score score2_hekow = objective_hekow.getScore("Role: " + hekow.getCouleurCamp() + "Hekow");
		        score2_hekow.setScore(5);
		        Score score3_hekow;
		        if(hekow.getOrbe() == Orbe.EAU) {
		        	
		        	score3_hekow = objective_hekow.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(hekow.getOrbe() == Orbe.FEU) {
		        	
		        	score3_hekow = objective_hekow.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(hekow.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_hekow = objective_hekow.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(hekow.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_hekow = objective_hekow.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_hekow = objective_hekow.getScore("Orbe: Aucune");
		        	
		        }
		        score3_hekow.setScore(4);
		        Score score4_hekow;
		        if(main.getJoueurByRole(Roles.HEKOW).isOrbeActif()) {
		        	
		        	score4_hekow = objective_hekow.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_hekow = objective_hekow.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_hekow.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.MALIVOL)) {
            	
            	if(!board_malivol.getObjectives().isEmpty()) {
            		board_malivol.getObjective("test").unregister();
        		}
            		
            	Objective objective_malivol = board_malivol.registerNewObjective("test", "dummy");
                
		        objective_malivol.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_malivol.setDisplayName("RC UHC V2");
		        Score score1_malivol = objective_malivol.getScore("Durée: " + timer/10 + "s");
		        score1_malivol.setScore(6);
		        Joueur malivol = main.getJoueurByRole(Roles.MALIVOL);
		        Score score2_malivol = objective_malivol.getScore("Role: " + malivol.getCouleurCamp() + "Malivol");
		        score2_malivol.setScore(5);
		        Score score3_malivol;
		        if(malivol.getOrbe() == Orbe.EAU) {
		        	
		        	score3_malivol = objective_malivol.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(malivol.getOrbe() == Orbe.FEU) {
		        	
		        	score3_malivol = objective_malivol.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(malivol.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_malivol = objective_malivol.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(malivol.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_malivol = objective_malivol.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_malivol = objective_malivol.getScore("Orbe: Aucune");
		        	
		        }
		        score3_malivol.setScore(4);
		        Score score4_malivol;
		        if(main.getJoueurByRole(Roles.MALIVOL).isOrbeActif()) {
		        	
		        	score4_malivol = objective_malivol.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_malivol = objective_malivol.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_malivol.setScore(3);
		        if(main.getJoueurByRole(Roles.MALIVOL).getMalivolCheat() != 0) {
		        	
		        	Score score5_malivol;
		        	
		        	if(main.getJoueurByRole(Roles.MALIVOL).getMalivolCheat() == 1) {
		        		
		        		score5_malivol = objective_malivol.getScore("Cheat: §9SpeedHack");
		        		
		        	}
		        	else if(main.getJoueurByRole(Roles.MALIVOL).getMalivolCheat() == 2) {
		        		
		        		score5_malivol = objective_malivol.getScore("Cheat: §aNoFall");
		        		
		        	}
		        	else if(main.getJoueurByRole(Roles.MALIVOL).getMalivolCheat() == 3) {
		        		
		        		score5_malivol = objective_malivol.getScore("Cheat: §cFullcrit");
		        		
		        	}
		        	else {
		        		
		        		score5_malivol = objective_malivol.getScore("Cheat: §7Anti-KB");
		        		
		        	}
		        	
		        	score5_malivol.setScore(2);
		        	
		        }
		        
        	}
        	
        	if(main.getCompo().contains(Roles.TOINOU)) {
            	
            	if(!board_toinou.getObjectives().isEmpty()) {
            		board_toinou.getObjective("test").unregister();
        		}
            		
            		Objective objective_toinou = board_toinou.registerNewObjective("test", "dummy");
                
		        objective_toinou.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_toinou.setDisplayName("RC UHC V2");
		        Score score1_toinou = objective_toinou.getScore("Durée: " + timer/10 + "s");
		        score1_toinou.setScore(6);
		        Joueur toinou = main.getJoueurByRole(Roles.TOINOU);
		        Score score2_toinou = objective_toinou.getScore("Role: " + toinou.getCouleurCamp() + "Toinou");
		        score2_toinou.setScore(5);
		        Score score3_toinou;
		        if(toinou.getOrbe() == Orbe.EAU) {
		        	
		        	score3_toinou = objective_toinou.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(toinou.getOrbe() == Orbe.FEU) {
		        	
		        	score3_toinou = objective_toinou.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(toinou.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_toinou = objective_toinou.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(toinou.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_toinou = objective_toinou.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_toinou = objective_toinou.getScore("Orbe: Aucune");
		        	
		        }
		        score3_toinou.setScore(4);
		        Score score4_toinou;
		        if(main.getJoueurByRole(Roles.TOINOU).isOrbeActif()) {
		        	
		        	score4_toinou = objective_toinou.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_toinou = objective_toinou.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_toinou.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.OBSCUR)) {
            	
            	if(!board_obscur.getObjectives().isEmpty()) {
            		board_obscur.getObjective("test").unregister();
        		}
            		
            	Objective objective_obscur = board_obscur.registerNewObjective("test", "dummy");
                
		        objective_obscur.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_obscur.setDisplayName("RC UHC V2");
		        Score score1_obscur = objective_obscur.getScore("Durée: " + timer/10 + "s");
		        score1_obscur.setScore(6);
		        Joueur obscur = main.getJoueurByRole(Roles.OBSCUR);
		        Score score2_obscur = objective_obscur.getScore("Role: " + obscur.getCouleurCamp() + "Obscur");
		        score2_obscur.setScore(5);
		        Score score3_obscur;
		        if(obscur.getOrbe() == Orbe.EAU) {
		        	
		        	score3_obscur = objective_obscur.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(obscur.getOrbe() == Orbe.FEU) {
		        	
		        	score3_obscur = objective_obscur.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(obscur.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_obscur = objective_obscur.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(obscur.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_obscur = objective_obscur.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_obscur = objective_obscur.getScore("Orbe: Aucune");
		        	
		        }
		        score3_obscur.setScore(4);
		        Score score4_obscur;
		        if(main.getJoueurByRole(Roles.OBSCUR).isOrbeActif()) {
		        	
		        	score4_obscur = objective_obscur.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_obscur = objective_obscur.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_obscur.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.NONOBOY)) {
            	
            	if(!board_nonoboy.getObjectives().isEmpty()) {
            		board_nonoboy.getObjective("test").unregister();
        		}
            		
            	Objective objective_nonoboy = board_nonoboy.registerNewObjective("test", "dummy");
                
		        objective_nonoboy.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_nonoboy.setDisplayName("RC UHC V2");
		        Score score1_nonoboy = objective_nonoboy.getScore("Durée: " + timer/10 + "s");
		        score1_nonoboy.setScore(6);
		        Joueur nonoboy = main.getJoueurByRole(Roles.NONOBOY);
		        Score score2_nonoboy = objective_nonoboy.getScore("Role: " + nonoboy.getCouleurCamp() + "Nonoboy");
		        score2_nonoboy.setScore(5);
		        Score score3_nonoboy;
		        if(nonoboy.getOrbe() == Orbe.EAU) {
		        	
		        	score3_nonoboy = objective_nonoboy.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(nonoboy.getOrbe() == Orbe.FEU) {
		        	
		        	score3_nonoboy = objective_nonoboy.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(nonoboy.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_nonoboy = objective_nonoboy.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(nonoboy.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_nonoboy = objective_nonoboy.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_nonoboy = objective_nonoboy.getScore("Orbe: Aucune");
		        	
		        }
		        score3_nonoboy.setScore(4);
		        Score score4_nonoboy;
		        if(main.getJoueurByRole(Roles.NONOBOY).isOrbeActif()) {
		        	
		        	score4_nonoboy = objective_nonoboy.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_nonoboy = objective_nonoboy.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_nonoboy.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.FARMEURIMMO)) {
            	
            	if(!board_farmeurimmo.getObjectives().isEmpty()) {
            		board_farmeurimmo.getObjective("test").unregister();
        		}
            		
            	Objective objective_farmeurimmo = board_farmeurimmo.registerNewObjective("test", "dummy");
                
		        objective_farmeurimmo.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_farmeurimmo.setDisplayName("RC UHC V2");
		        Score score1_farmeurimmo = objective_farmeurimmo.getScore("Durée: " + timer/10 + "s");
		        score1_farmeurimmo.setScore(6);
		        Joueur farmeurimmo = main.getJoueurByRole(Roles.FARMEURIMMO);
		        Score score2_farmeurimmo = objective_farmeurimmo.getScore("Role: " + farmeurimmo.getCouleurCamp() + "Farmeurimmo");
		        score2_farmeurimmo.setScore(5);
		        Score score3_farmeurimmo;
		        if(farmeurimmo.getOrbe() == Orbe.EAU) {
		        	
		        	score3_farmeurimmo = objective_farmeurimmo.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(farmeurimmo.getOrbe() == Orbe.FEU) {
		        	
		        	score3_farmeurimmo = objective_farmeurimmo.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(farmeurimmo.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_farmeurimmo = objective_farmeurimmo.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(farmeurimmo.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_farmeurimmo = objective_farmeurimmo.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_farmeurimmo = objective_farmeurimmo.getScore("Orbe: Aucune");
		        	
		        }
		        score3_farmeurimmo.setScore(4);
		        Score score4_farmeurimmo;
		        if(main.getJoueurByRole(Roles.FARMEURIMMO).isOrbeActif()) {
		        	
		        	score4_farmeurimmo = objective_farmeurimmo.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_farmeurimmo = objective_farmeurimmo.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_farmeurimmo.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.KZOU)) {
            	
            	if(!board_kzou.getObjectives().isEmpty()) {
            		board_kzou.getObjective("test").unregister();
        		}
            		
            	Objective objective_kzou = board_kzou.registerNewObjective("test", "dummy");
                
		        objective_kzou.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_kzou.setDisplayName("RC UHC");
		        Score score1_kzou = objective_kzou.getScore("Durée: " + timer/10 + "s");
		        score1_kzou.setScore(2);
		        Joueur kzou = main.getJoueurByRole(Roles.KZOU);
		        Score score2_kzou = objective_kzou.getScore("Role: " + kzou.getCouleurCamp() + "Kzou");
		        score2_kzou.setScore(1);
		        Score score3_kzou;
		        if(kzou.getOrbe() == Orbe.EAU) {
		        	
		        	score3_kzou = objective_kzou.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(kzou.getOrbe() == Orbe.FEU) {
		        	
		        	score3_kzou = objective_kzou.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(kzou.getOrbe() == Orbe.GLACE) {
		        	
		        	score3_kzou = objective_kzou.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(kzou.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score3_kzou = objective_kzou.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score3_kzou = objective_kzou.getScore("Orbe: Aucune");
		        	
		        }
		        score3_kzou.setScore(4);
		        Score score4_kzou;
		        if(main.getJoueurByRole(Roles.KZOU).isOrbeActif()) {
		        	
		        	score4_kzou = objective_kzou.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_kzou = objective_kzou.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_kzou.setScore(3);
	        
        	}
	        
    	}
        
        for(Joueur joueur : main.getListJoueurs()) {
        	
        	Player player = joueur.getPlayer();
        	
        	//System.out.println("Joueur : " + player.getName());
        	//System.out.println("Role : " + joueur.getRole().toString());
        	
        	if(joueur.getRole() == Roles.NONE) {
        		
	            player.setScoreboard(board_base);
	            
            }
        	else if(joueur.getRole() == Roles.RAPTOR) {
                
	            player.setScoreboard(board_raptor);
	            
            }
            else if(joueur.getRole() == Roles.JEANNOT) {
                
	            player.setScoreboard(board_jeannot);
	            
            }
            else if(joueur.getRole() == Roles.NICKOBOOP) {
                
	            player.setScoreboard(board_nickoboop);
	            
            }
            else if(joueur.getRole() == Roles.SLUP) {
            	
	            player.setScoreboard(board_slup);
	            
            }
            else if(joueur.getRole() == Roles.JOKO) {
                
	            player.setScoreboard(board_joko);
	            
            }
            else if(joueur.getRole() == Roles.TEAM) {
                
	            player.setScoreboard(board_team);
	            
            }
            else if(joueur.getRole() == Roles.GAMEBLACK) {
                
	            player.setScoreboard(board_gameblack);
	            
            }
            else if(joueur.getRole() == Roles.MAKA) {
                
	            player.setScoreboard(board_maka);
	            
            }
        	else if(joueur.getRole() == Roles.TRIAL) {
                
	            player.setScoreboard(board_trial);
	            
            }
        	else if(joueur.getRole() == Roles.LOUP) {
                
	            player.setScoreboard(board_loup);
	            
            }
        	else if(joueur.getRole() == Roles.CAPTAIN) {
                
	            player.setScoreboard(board_captain);
	            
            }
        	else if(joueur.getRole() == Roles.HEKOW) {
                
	            player.setScoreboard(board_hekow);
	            
            }
        	else if(joueur.getRole() == Roles.MALIVOL) {
                
	            player.setScoreboard(board_malivol);
	            
            }
        	else if(joueur.getRole() == Roles.TOINOU) {
                
	            player.setScoreboard(board_toinou);
	            
            }
        	else if(joueur.getRole() == Roles.OBSCUR) {
                
	            player.setScoreboard(board_obscur);
	            
            }
        	else if(joueur.getRole() == Roles.NONOBOY) {
                
	            player.setScoreboard(board_nonoboy);
	            
            }
        	else if(joueur.getRole() == Roles.FARMEURIMMO) {
        		
        		System.out.println("c'est bien farmeurimmo");
        		
	            player.setScoreboard(board_farmeurimmo);
	            
            }
        	else if(joueur.getRole() == Roles.KZOU) {
                
	            player.setScoreboard(board_kzou);
	            
            }
            
        }
    	
    }
    
	@Override
    public void run() {
		
		if(timer % 70 == 0 && ((main.getEpisode() > 2 && main.getTemps() > 1 && main.getMode().equalsIgnoreCase("normal")) || (main.getEpisode() >= 1 && main.getTemps() > 11 && main.getMode().equalsIgnoreCase("rapide")))) {
			
			for(Joueur joueur : main.getListJoueurs()) {
				
				if(!joueur.isSpec() && joueur.getRole() != Roles.FARMEURIMMO && joueur.getRole() != Roles.NONE) {
					
					joueur.addPourcentHack(1, main);
					
				}
				
			}
			
		}
        
        if(timer % 10 == 0) {
        	
        	if(main.getNeko().isProche(Roles.MAKA, main) && !main.getNeko().isSpeedProche()) {
        		
        		if(main.getNbJoueursStaff() == 6) {
        			main.getNeko().addSpeed(0.01);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.01);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 5) {
        			main.getNeko().addSpeed(0.02);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.02);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 4) {
        			main.getNeko().addSpeed(0.05);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.05);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 3) {
        			main.getNeko().addSpeed(0.07);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.07);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 2) {
        			main.getNeko().addSpeed(0.1);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.1);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 1) {
        			main.getNeko().addSpeed(0.15);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.15);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		
        	}
        	else if(!main.getNeko().isProche(Roles.MAKA, main) && main.getNeko().isSpeedProche()) {
        		
        		if(main.getNbJoueursStaff() == 6) {
        			main.getNeko().removeSpeed(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.01);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 5) {
        			main.getNeko().removeSpeed(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.02);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 4) {
        			main.getNeko().removeSpeed(0.05);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.05);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 3) {
        			main.getNeko().removeSpeed(0.07);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.07);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 2) {
        			main.getNeko().removeSpeed(0.1);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.1);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 1) {
        			main.getNeko().removeSpeed(0.15);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.15);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.MAKA) != null && main.getJoueurByRole(Roles.MAKA).getForme().equalsIgnoreCase("normal") && main.getJoueurByRole(Roles.MAKA).isProche(Roles.TEAM, main) && !main.getJoueurByRole(Roles.MAKA).isResiProche()) {
        		
        		Joueur maka = main.getJoueurByRole(Roles.MAKA);
        		maka.addResi(0.02);
        		maka.setResiProche(true);
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.MAKA) != null && (!main.getJoueurByRole(Roles.MAKA).getForme().equalsIgnoreCase("normal") || !main.getJoueurByRole(Roles.MAKA).isProche(Roles.TEAM, main)) && main.getJoueurByRole(Roles.MAKA).isResiProche()) {
        		
        		Joueur maka = main.getJoueurByRole(Roles.MAKA);
        		maka.removeResi(0.02);
        		maka.setResiProche(false);
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.GAMEBLACK) != null && !main.getJoueurByRole(Roles.GAMEBLACK).isChoixGbCamp()) {
        		
        		Joueur gameblack = main.getJoueurByRole(Roles.GAMEBLACK);
        		
        		if(main.getJoueurByRole(Roles.MALIVOL) == null) {
        			
        			gameblack.setChoixGbCamp(true);
        			
        		}
        		else if(main.getJoueurByRole(Roles.TEAM) == null && main.getJoueurByRole(Roles.MAKA) == null) {
        			
        			gameblack.setChoixGbCamp(true);
        			gameblack.setCamp("uhc");
        			GameBlack.ItemsUHC(gameblack, main);
        			
        		}
        		else {
        			
        			if(gameblack.isProche(Roles.MALIVOL, main)) {
        				
        				gameblack.setChoixGbCamp(true);
        				gameblack.setCamp("uhc");
        				GameBlack.ItemsUHC(gameblack, main);
        				
        			}
        			else if(gameblack.isProche(Roles.MAKA, main) || gameblack.isProche(Roles.TEAM, main)) {
        				
        				gameblack.setChoixGbCamp(true);
        				
        			}
        			
        		}
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.NICKOBOOP) != null && main.getJoueurByRole(Roles.JEANNOT) != null) {
        		
        		Nickoboop.checkProcheJeannot(main.getJoueurByRole(Roles.NICKOBOOP), main);
        		
        	}
        	
        	if (main.getTemps() == main.getTempsEpisode() / 2 && main.getEpisode() != 1) {
        		
        		if(main.getCD().contains(Pouvoirs.FARMEURIMMO_HACK)) {
        			
        			main.getCD().remove(Pouvoirs.FARMEURIMMO_HACK);
        			
        		}

                if (main.isDay()) {

                    main.setJour(false);
                    Bukkit.broadcastMessage("§1LA NUIT TOMBE");
                    Nuit(main);

                } else {

                    main.setJour(true);
                    Bukkit.broadcastMessage("§6LE JOUR SE LEVE");
                    Jour(main);

                }

            }
        	
        	if(main.getTemps() == 10 && main.getEpisode() == 1 && main.getMode().equalsIgnoreCase("rapide")) {
        		
        		Bukkit.broadcastMessage("Attribution des rôles");
        		setRole(main);
        		
        	}
        	
        	if (main.getTemps() == main.getTempsEpisode()) {
            	
            	resetCD(main);

                int episode = main.getEpisode() + 1;

                Bukkit.broadcastMessage("_________________________\n \nEpisode " + episode + "\n_________________________");

                if (main.getEpisode() == 1 && main.getMode().equalsIgnoreCase("normal")) {

                	Bukkit.broadcastMessage("Attribution des rôles");
                	setRole(main);

                }

                main.addEpisode();
                if (main.isDay()) {

                    main.setJour(false);
                    Bukkit.broadcastMessage("§1LA NUIT TOMBE");

                } else {

                    main.setJour(true);
                    Bukkit.broadcastMessage("§6LE JOUR SE LEVE");

                }

            }
            
            main.addTemps();
            
            if(score_board) {
            
            	Bukkit.getScheduler().runTaskAsynchronously(main, () -> {
            	
            		setScoreboard(main, timer);
	            
            	});
	            
        	}
        	
        }

	    for (Joueur joueur : main.getJoueurInGame()) {
	    	
	    	Player player = joueur.getPlayer();
	
	    	if (player.getFireTicks() > 0) {
	
	    		if (joueur.getOrbe() == Orbe.GLACE && !joueur.isMalusOrbeActif()) {
	
	    			Glace.Malus(joueur, main);
	
	    		}
	
	    	}
	
	        if (player.hasPotionEffect(PotionEffectType.SLOW)) {
	
	        	if (joueur.getOrbe() == Orbe.FOUDRE && !joueur.isMalusOrbeActif()) {
	
	        		Foudre.Malus(joueur, main);
	
	            }
	
	        }
	
	        if (player.getWalkSpeed() != 0.2 * (joueur.getSpeed()/100)) {
	
	        	player.setWalkSpeed((float) (0.2 * (joueur.getSpeed())/100));
	
	        }
	
	    }

        timer++;

    }

}
