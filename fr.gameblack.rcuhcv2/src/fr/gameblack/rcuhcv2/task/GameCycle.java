package fr.gameblack.rcuhcv2.task;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
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
    	else if(main.getCD().contains(Pouvoirs.TRIAL_JEU)) {
    		
    		main.getCD().remove(Pouvoirs.TRIAL_JEU);
    		
    	}
    	else if(main.getCD().contains(Pouvoirs.FARMEURIMMO_HACK)) {
    		
    		main.getCD().remove(Pouvoirs.FARMEURIMMO_HACK);
    		
    	} else if(main.getCD().contains(Pouvoirs.GAMEBLACK_CHECKORBE)) {
    		
    		main.getCD().remove(Pouvoirs.GAMEBLACK_CHECKORBE);
    		
    	} else if(main.getCD().contains(Pouvoirs.GAMEBLACK_CONSOLE)) {
    		
    		main.getCD().remove(Pouvoirs.GAMEBLACK_CONSOLE);
    		
    	} else if(main.getCD().contains(Pouvoirs.GAMEBLACK_FUITE)) {
    		
    		main.getCD().remove(Pouvoirs.GAMEBLACK_FUITE);
    		
    	} else if(main.getCD().contains(Pouvoirs.JOKO_CUBE)) {
    		
    		main.getCD().remove(Pouvoirs.JOKO_CUBE);
    		
    	} else if(main.getCD().contains(Pouvoirs.KZOU_BAN)) {
    		
    		main.getCD().remove(Pouvoirs.KZOU_BAN);
    		
    	} else if(main.getCD().contains(Pouvoirs.KZOU_DISPERSE)) {
    		
    		main.getCD().remove(Pouvoirs.KZOU_DISPERSE);
    		
    	} else if(main.getCD().contains(Pouvoirs.NICKOBOOP_PAPIER)) {
    		
    		main.getCD().remove(Pouvoirs.NICKOBOOP_PAPIER);
    		
    	} else if(main.getCD().contains(Pouvoirs.TOINOU_VACANCES)) {
    		
    		main.getCD().remove(Pouvoirs.TOINOU_VACANCES);
    		
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
        		
        		System.out.println("____________________________");
            	
            	System.out.println("taille : " + nombre);
            	
            	for(Roles role : compo) {
            		
            		System.out.println("Role : " + role.toString());
            		
            	}
            	
            	System.out.println("____________________________");
        	
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
        
        if(main.getCompo().contains(Roles.MALIVOL) && main.getCompo().contains(Roles.TOINOU)) {
        	
        	Joueur malivol = main.getJoueurByRole(Roles.MALIVOL);
        	Joueur toinou = main.getJoueurByRole(Roles.TOINOU);
        	
        	malivol.getPlayer().sendMessage("Toinou : " + toinou.getPlayer().getName());
        	
        }
        
        if(main.getCompo().contains(Roles.TRIAL) && main.getCompo().contains(Roles.LOUP)) {
        	
        	Joueur trial = main.getJoueurByRole(Roles.TRIAL);
        	Joueur loup = main.getJoueurByRole(Roles.LOUP);
        	trial.getPlayer().sendMessage("Loup : " + loup.getPlayer().getDisplayName());
        	
        }
    	
    }
    
    public static Scoreboard getScoreboardFarmeurimmo() {
    	return board_farmeurimmo;
    }
    
    public static Scoreboard getScoreboardJoko() {
    	return board_joko;
    }

    public static void setScoreboard(Main main, int timer) {
    	
    	Objective objective_hp = board_base.getObjective("hp");
    	
    	if(!board_base.getObjectives().isEmpty()) {
			board_base.getObjective("test").unregister();
		}
        
        Objective objective_base = board_base.registerNewObjective("test", "dummy");
        objective_base.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective_base.setDisplayName("RC UHC V2");
        Score score1_base = objective_base.getScore("Durée: " + main.getTimerInTexte(timer));
        score1_base.setScore(3);
        Score scoreep_base = objective_base.getScore("Episode : " + main.getEpisode());
        scoreep_base.setScore(2);
        Score score2_base = objective_base.getScore("Joueurs : " + main.getListJoueurs().size() );
        score2_base.setScore(1);
        if(objective_hp == null) {
        	objective_hp = board_base.registerNewObjective("hp", "health");
        }
        objective_hp.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective_hp.setDisplayName("HP");
        
        if((main.getEpisode() > 1 || (main.getEpisode() == 2 && main.getTemps() > 2)) || (main.getTemps() > 10 && main.getEpisode() >= 1 && main.getMode().equalsIgnoreCase("rapide"))) {
        	
        	if(main.getCompo().contains(Roles.RAPTOR) && main.getJoueurByRole(Roles.RAPTOR) != null) {
            	
            	if(!board_raptor.getObjectives().isEmpty()) {
            		board_raptor.getObjective("test").unregister();
            	}
            		
            	Objective objective_raptor = board_raptor.registerNewObjective("test", "dummy");
            	
            	Joueur raptor = main.getJoueurByRole(Roles.RAPTOR);
                
		        objective_raptor.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_raptor.setDisplayName("RC UHC V2");
		        Score score1_raptor = objective_raptor.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_raptor.setScore(7);
		        Score scoreep_raptor = objective_raptor.getScore("Episode : " + main.getEpisode());
		        scoreep_raptor.setScore(6);
		        Score score2_raptor = objective_raptor.getScore("Joueurs : " + main.getListJoueurs().size() );
		        score2_raptor.setScore(5);
		        Score scorekill_raptor = objective_raptor.getScore("Kill : " + raptor.getKill() );
		        scorekill_raptor.setScore(4);
		        Score score3_raptor = objective_raptor.getScore("Role: " + raptor.getCouleurCamp() + "Raptor");
		        score3_raptor.setScore(3);
		        Score score4_raptor;
		        if(raptor.getOrbe() == Orbe.EAU) {
		        	
		        	score4_raptor = objective_raptor.getScore("Orbe: §1Eau");
		        	
		        }
		        else if(raptor.getOrbe() == Orbe.FEU) {
		        	
		        	score4_raptor = objective_raptor.getScore("Orbe: §cFeu");
		        	
		        }
		        else if(raptor.getOrbe() == Orbe.GLACE) {
		        	
		        	score4_raptor = objective_raptor.getScore("Orbe: §bGlace");
		        	
		        }
		        else if(raptor.getOrbe() == Orbe.FOUDRE) {
		        	
		        	score4_raptor = objective_raptor.getScore("Orbe: §eFoudre");
		        	
		        }
		        else {
		        	
		        	score4_raptor = objective_raptor.getScore("Orbe: Aucune");
		        	
		        }
		        
		        score4_raptor.setScore(2);
		        Score score5_raptor;
		        if(main.getJoueurByRole(Roles.RAPTOR).isOrbeActif()) {
		        	
		        	score5_raptor = objective_raptor.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score5_raptor = objective_raptor.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score5_raptor.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.JEANNOT)  && main.getJoueurByRole(Roles.JEANNOT) != null) {
            	
            	if(!board_jeannot.getObjectives().isEmpty()) {
            		board_jeannot.getObjective("test").unregister();
        		}
            		
            	Objective objective_jeannot = board_jeannot.registerNewObjective("test", "dummy");
            	
            	Joueur jeannot = main.getJoueurByRole(Roles.JEANNOT);
                
		        objective_jeannot.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_jeannot.setDisplayName("RC UHC V2");
		        Score score1_jeannot = objective_jeannot.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_jeannot.setScore(7);
		        Score scoreep_jeannot = objective_jeannot.getScore("Episode : " + main.getEpisode());
		        scoreep_jeannot.setScore(6);
		        Score scorej_jeannot = objective_jeannot.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_jeannot.setScore(5);
		        Score scorekill_jeannot = objective_jeannot.getScore("Kill : " + jeannot.getKill() );
		        scorekill_jeannot.setScore(4);
		        Score score2_jeannot = objective_jeannot.getScore("Role: " + jeannot.getCouleurCamp() + "Jeannot");
		        score2_jeannot.setScore(3);
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
		        score3_jeannot.setScore(2);
		        Score score4_jeannot;
		        if(main.getJoueurByRole(Roles.JEANNOT).isOrbeActif()) {
		        	
		        	score4_jeannot = objective_jeannot.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_jeannot = objective_jeannot.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_jeannot.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.NICKOBOOP) && main.getJoueurByRole(Roles.NICKOBOOP) != null) {
	                   	
            	if(!board_nickoboop.getObjectives().isEmpty()) {
            		board_nickoboop.getObjective("test").unregister();
        		}
            		
            	Objective objective_nickoboop = board_nickoboop.registerNewObjective("test", "dummy");
            	
            	Joueur nickoboop = main.getJoueurByRole(Roles.NICKOBOOP);
                
		        objective_nickoboop.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_nickoboop.setDisplayName("RC UHC V2");
		        Score score1_nickoboop = objective_nickoboop.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_nickoboop.setScore(7);
		        Score scoreep_nickoboop = objective_nickoboop.getScore("Episode : " + main.getEpisode());
		        scoreep_nickoboop.setScore(6);
		        Score scorej_nickoboop = objective_nickoboop.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_nickoboop.setScore(5);
		        Score scorekill_nickoboop = objective_nickoboop.getScore("Kill : " + nickoboop.getKill() );
		        scorekill_nickoboop.setScore(4);
		        Score score2_nickoboop = objective_nickoboop.getScore("Role: " + nickoboop.getCouleurCamp() + "Nickoboop");
		        score2_nickoboop.setScore(3);
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
		        score3_nickoboop.setScore(2);
		        Score score4_nickoboop;
		        if(main.getJoueurByRole(Roles.NICKOBOOP).isOrbeActif()) {
		        	
		        	score4_nickoboop = objective_nickoboop.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_nickoboop = objective_nickoboop.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_nickoboop.setScore(1);
		    
        	}
        	
        	if(main.getCompo().contains(Roles.SLUP) && main.getJoueurByRole(Roles.SLUP) != null) {
	                    	
            	if(!board_slup.getObjectives().isEmpty()) {
            		board_slup.getObjective("test").unregister();
        		}
            		
            	Objective objective_slup = board_slup.registerNewObjective("test", "dummy");
            	
            	Joueur slup = main.getJoueurByRole(Roles.SLUP);
                
		        objective_slup.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_slup.setDisplayName("RC UHC V2");
		        Score score1_slup = objective_slup.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_slup.setScore(8);
		        Score scoreep_slup = objective_slup.getScore("Episode : " + main.getEpisode());
		        scoreep_slup.setScore(7);
		        Score scorej_slup = objective_slup.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_slup.setScore(6);
		        Score scorekill_slup = objective_slup.getScore("Kill : " + slup.getKill() );
		        scorekill_slup.setScore(5);
		        Score score2_slup = objective_slup.getScore("Role: " + slup.getCouleurCamp() + "Slup");
		        score2_slup.setScore(4);
		        Score scoreslime_slup = objective_slup.getScore("Slime: " + slup.getSlime());
		        scoreslime_slup.setScore(3);
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
		        score3_slup.setScore(2);
		        Score score4_slup;
		        if(main.getJoueurByRole(Roles.SLUP).isOrbeActif()) {
		        	
		        	score4_slup = objective_slup.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_slup = objective_slup.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_slup.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.JOKO) && main.getJoueurByRole(Roles.JOKO) != null) {
	                    	
            	if(!board_joko.getObjectives().isEmpty() && board_joko.getObjective("test") != null) {
            		board_joko.getObjective("test").unregister();
        		}
            		
            	Objective objective_joko = board_joko.registerNewObjective("test", "dummy");
            	
            	Joueur joko = main.getJoueurByRole(Roles.JOKO);
                
		        objective_joko.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_joko.setDisplayName("RC UHC V2");
		        Score score1_joko = objective_joko.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_joko.setScore(7);
		        Score scoreep_joko = objective_joko.getScore("Episode : " + main.getEpisode());
		        scoreep_joko.setScore(6);
		        Score scorej_joko = objective_joko.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_joko.setScore(5);
		        Score scorekill_joko = objective_joko.getScore("Kill : " + joko.getKill() );
		        scorekill_joko.setScore(4);
		        Score score2_joko = objective_joko.getScore("Role: " + joko.getCouleurCamp() + " Joko");
		        score2_joko.setScore(3);
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
		        score3_joko.setScore(2);
		        Score score4_joko;
		        if(main.getJoueurByRole(Roles.JOKO).isOrbeActif()) {
		        	
		        	score4_joko = objective_joko.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_joko = objective_joko.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_joko.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.TEAM) && main.getJoueurByRole(Roles.TEAM) != null) {
                   	
            	if(!board_team.getObjectives().isEmpty()) {
            		board_team.getObjective("test").unregister();
        		}
            		
            	Objective objective_team = board_team.registerNewObjective("test", "dummy");
                
		        objective_team.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_team.setDisplayName("RC UHC V2");
		        Score score1_team = objective_team.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_team.setScore(7);
		        Joueur team = main.getJoueurByRole(Roles.TEAM);
		        Score scoreep_team = objective_team.getScore("Episode : " + main.getEpisode());
		        scoreep_team.setScore(6);
		        Score scorej_team = objective_team.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_team.setScore(5);
		        Score scorekill_team = objective_team.getScore("Kill : " + team.getKill() );
		        scorekill_team.setScore(4);
		        Score score2_team = objective_team.getScore("Role: " + team.getCouleurCamp() + " Team");
		        score2_team.setScore(3);
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
		        score3_team.setScore(2);
		        Score score4_team;
		        if(main.getJoueurByRole(Roles.TEAM).isOrbeActif()) {
		        	
		        	score4_team = objective_team.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_team = objective_team.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_team.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.GAMEBLACK) && main.getJoueurByRole(Roles.GAMEBLACK) != null) {
            	
            	if(!board_gameblack.getObjectives().isEmpty()) {
            		board_gameblack.getObjective("test").unregister();
        		}
            		
            	Objective objective_gb = board_gameblack.registerNewObjective("test", "dummy");
                
		        objective_gb.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_gb.setDisplayName("RC UHC V2");
		        Score score1_gb = objective_gb.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_gb.setScore(7);
		        Joueur gameblack = main.getJoueurByRole(Roles.GAMEBLACK);
		        Score scoreep_gb = objective_gb.getScore("Episode : " + main.getEpisode());
		        scoreep_gb.setScore(6);
		        Score scorej_gb = objective_gb.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_gb.setScore(5);
		        Score scorekill_gb = objective_gb.getScore("Kill : " + gameblack.getKill() );
		        scorekill_gb.setScore(4);
		        Score score2_gb = objective_gb.getScore("Role: " + gameblack.getCouleurCamp() + "GameBlack");
		        score2_gb.setScore(3);
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
		        score3_gb.setScore(2);
		        Score score4_gb;
		        if(main.getJoueurByRole(Roles.GAMEBLACK).isOrbeActif()) {
		        	
		        	score4_gb = objective_gb.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_gb = objective_gb.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_gb.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.MAKA)  && main.getJoueurByRole(Roles.MAKA) != null) {
            	
            	if(!board_maka.getObjectives().isEmpty()) {
            		board_maka.getObjective("test").unregister();
        		}
            		
            	Objective objective_maka = board_maka.registerNewObjective("test", "dummy");
                
		        objective_maka.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_maka.setDisplayName("RC UHC V2");
		        Score score1_maka = objective_maka.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_maka.setScore(7);
		        Joueur maka = main.getJoueurByRole(Roles.MAKA);
		        Score scoreep_maka = objective_maka.getScore("Episode : " + main.getEpisode());
		        scoreep_maka.setScore(6);
		        Score scorej_maka = objective_maka.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_maka.setScore(5);
		        Score scorekill_maka = objective_maka.getScore("Kill : " + maka.getKill() );
		        scorekill_maka.setScore(4);
		        Score score2_maka = objective_maka.getScore("Role: " + maka.getCouleurCamp() + "Maka");
		        score2_maka.setScore(3);
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
		        score3_maka.setScore(2);
		        Score score4_maka;
		        if(main.getJoueurByRole(Roles.MAKA).isOrbeActif()) {
		        	
		        	score4_maka = objective_maka.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_maka = objective_maka.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_maka.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.TRIAL) && main.getJoueurByRole(Roles.TRIAL) != null) {
	        
        		if(!board_trial.getObjectives().isEmpty()) {
            		board_trial.getObjective("test").unregister();
        		}
            		
            	Objective objective_trial = board_trial.registerNewObjective("test", "dummy");
                
		        objective_trial.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_trial.setDisplayName("RC UHC V2");
		        Score score1_trial = objective_trial.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_trial.setScore(7);
		        Joueur trial = main.getJoueurByRole(Roles.TRIAL);
		        Score scoreep_trial = objective_trial.getScore("Episode : " + main.getEpisode());
		        scoreep_trial.setScore(6);
		        Score scorej_trial = objective_trial.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_trial.setScore(5);
		        Score scorekill_trial = objective_trial.getScore("Kill : " + trial.getKill() );
		        scorekill_trial.setScore(4);
		        Score score2_trial = objective_trial.getScore("Role: " + trial.getCouleurCamp() + "Trial");
		        score2_trial.setScore(3);
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
		        score3_trial.setScore(2);
		        Score score4_trial;
		        if(main.getJoueurByRole(Roles.TRIAL).isOrbeActif()) {
		        	
		        	score4_trial = objective_trial.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_trial = objective_trial.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_trial.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.LOUP) && main.getJoueurByRole(Roles.LOUP) != null) {
	        
        		if(!board_loup.getObjectives().isEmpty()) {
            		board_loup.getObjective("test").unregister();
        		}
            		
            	Objective objective_loup = board_loup.registerNewObjective("test", "dummy");
                
		        objective_loup.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_loup.setDisplayName("RC UHC V2");
		        Joueur loup = main.getJoueurByRole(Roles.LOUP);
		        Score score1_loup = objective_loup.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_loup.setScore(7);
		        Score scoreep_loup = objective_loup.getScore("Episode : " + main.getEpisode());
		        scoreep_loup.setScore(6);
		        Score scorej_loup = objective_loup.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_loup.setScore(5);
		        Score scorekill_loup = objective_loup.getScore("Kill : " + loup.getKill() );
		        scorekill_loup.setScore(4);
		        Score score2_loup = objective_loup.getScore("Role: " + loup.getCouleurCamp() + "Loup");
		        score2_loup.setScore(3);
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
		        score3_loup.setScore(2);
		        Score score4_loup;
		        if(main.getJoueurByRole(Roles.LOUP).isOrbeActif()) {
		        	
		        	score4_loup = objective_loup.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_loup = objective_loup.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_loup.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.CAPTAIN) && main.getJoueurByRole(Roles.CAPTAIN) != null) {
            	
            	if(!board_captain.getObjectives().isEmpty()) {
            		board_captain.getObjective("test").unregister();
        		}
            	
            	Objective objective_captain = board_captain.registerNewObjective("test", "dummy");
                
		        objective_captain.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_captain.setDisplayName("RC UHC V2");
		        Joueur captain = main.getJoueurByRole(Roles.CAPTAIN);
		        Score score1_captain = objective_captain.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_captain.setScore(7);
		        Score scoreep_captain = objective_captain.getScore("Episode : " + main.getEpisode());
		        scoreep_captain.setScore(6);
		        Score scorej_captain = objective_captain.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_captain.setScore(5);
		        Score scorekill_captain = objective_captain.getScore("Kill : " + captain.getKill() );
		        scorekill_captain.setScore(4);
		        Score score2_captain = objective_captain.getScore("Role: " + captain.getCouleurCamp() + "Captain");
		        score2_captain.setScore(3);
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
		        score3_captain.setScore(2);
		        Score score4_captain;
		        if(main.getJoueurByRole(Roles.CAPTAIN).isOrbeActif()) {
		        	
		        	score4_captain = objective_captain.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_captain = objective_captain.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_captain.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.HEKOW) && main.getJoueurByRole(Roles.HEKOW) != null) {
            	
            	if(!board_hekow.getObjectives().isEmpty()) {
            		board_hekow.getObjective("test").unregister();
        		}
            		
            	Objective objective_hekow = board_hekow.registerNewObjective("test", "dummy");
                
		        objective_hekow.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_hekow.setDisplayName("RC UHC V2");
		        Score score1_hekow = objective_hekow.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_hekow.setScore(7);
		        Joueur hekow = main.getJoueurByRole(Roles.HEKOW);
		        Score scoreep_hekow = objective_hekow.getScore("Episode : " + main.getEpisode());
		        scoreep_hekow.setScore(6);
		        Score scorej_hekow = objective_hekow.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_hekow.setScore(5);
		        Score scorekill_hekow = objective_hekow.getScore("Kill : " + hekow.getKill() );
		        scorekill_hekow.setScore(4);
		        Score score2_hekow = objective_hekow.getScore("Role: " + hekow.getCouleurCamp() + "Hekow");
		        score2_hekow.setScore(3);
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
		        score3_hekow.setScore(2);
		        Score score4_hekow;
		        if(main.getJoueurByRole(Roles.HEKOW).isOrbeActif()) {
		        	
		        	score4_hekow = objective_hekow.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_hekow = objective_hekow.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_hekow.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.MALIVOL) && main.getJoueurByRole(Roles.MALIVOL) != null) {
            	
            	if(!board_malivol.getObjectives().isEmpty()) {
            		board_malivol.getObjective("test").unregister();
        		}
            		
            	Objective objective_malivol = board_malivol.registerNewObjective("test", "dummy");
                
		        objective_malivol.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_malivol.setDisplayName("RC UHC V2");
		        Score score1_malivol = objective_malivol.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_malivol.setScore(8);
		        Joueur malivol = main.getJoueurByRole(Roles.MALIVOL);
		        Score scoreep_malivol = objective_malivol.getScore("Episode : " + main.getEpisode());
		        scoreep_malivol.setScore(7);
		        Score scorej_malivol = objective_malivol.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_malivol.setScore(6);
		        Score scorekill_malivol = objective_malivol.getScore("Kill : " + malivol.getKill() );
		        scorekill_malivol.setScore(5);
		        Score score2_malivol = objective_malivol.getScore("Role: " + malivol.getCouleurCamp() + "Malivol");
		        score2_malivol.setScore(4);
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
		        score3_malivol.setScore(3);
		        Score score4_malivol;
		        if(main.getJoueurByRole(Roles.MALIVOL).isOrbeActif()) {
		        	
		        	score4_malivol = objective_malivol.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_malivol = objective_malivol.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_malivol.setScore(2);
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
		        	
		        	score5_malivol.setScore(1);
		        	
		        }
		        
        	}
        	
        	if(main.getCompo().contains(Roles.TOINOU) && main.getJoueurByRole(Roles.TOINOU) != null) {
            	
            	if(!board_toinou.getObjectives().isEmpty()) {
            		board_toinou.getObjective("test").unregister();
        		}
            		
            		Objective objective_toinou = board_toinou.registerNewObjective("test", "dummy");
                
		        objective_toinou.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_toinou.setDisplayName("RC UHC V2");
		        Score score1_toinou = objective_toinou.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_toinou.setScore(7);
		        Joueur toinou = main.getJoueurByRole(Roles.TOINOU);
		        Score scoreep_toinou = objective_toinou.getScore("Episode : " + main.getEpisode());
		        scoreep_toinou.setScore(6);
		        Score scorej_toinou = objective_toinou.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_toinou.setScore(5);
		        Score scorekill_toinou = objective_toinou.getScore("Kill : " + toinou.getKill() );
		        scorekill_toinou.setScore(4);
		        Score score2_toinou = objective_toinou.getScore("Role: " + toinou.getCouleurCamp() + "Toinou");
		        score2_toinou.setScore(3);
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
		        score3_toinou.setScore(2);
		        Score score4_toinou;
		        if(main.getJoueurByRole(Roles.TOINOU).isOrbeActif()) {
		        	
		        	score4_toinou = objective_toinou.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_toinou = objective_toinou.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_toinou.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.OBSCUR) && main.getJoueurByRole(Roles.OBSCUR) != null) {
            	
            	if(!board_obscur.getObjectives().isEmpty()) {
            		board_obscur.getObjective("test").unregister();
        		}
            		
            	Objective objective_obscur = board_obscur.registerNewObjective("test", "dummy");
                
		        objective_obscur.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_obscur.setDisplayName("RC UHC V2");
		        Score score1_obscur = objective_obscur.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_obscur.setScore(7);
		        Joueur obscur = main.getJoueurByRole(Roles.OBSCUR);
		        Score scoreep_obscur = objective_obscur.getScore("Episode : " + main.getEpisode());
		        scoreep_obscur.setScore(6);
		        Score scorej_obscur = objective_obscur.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_obscur.setScore(5);
		        Score scorekill_obscur = objective_obscur.getScore("Kill : " + obscur.getKill() );
		        scorekill_obscur.setScore(4);
		        Score score2_obscur = objective_obscur.getScore("Role: " + obscur.getCouleurCamp() + "Obscur");
		        score2_obscur.setScore(3);
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
		        score3_obscur.setScore(2);
		        Score score4_obscur;
		        if(main.getJoueurByRole(Roles.OBSCUR).isOrbeActif()) {
		        	
		        	score4_obscur = objective_obscur.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_obscur = objective_obscur.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_obscur.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.NONOBOY) && main.getJoueurByRole(Roles.NONOBOY) != null) {
            	
            	if(!board_nonoboy.getObjectives().isEmpty()) {
            		board_nonoboy.getObjective("test").unregister();
        		}
            		
            	Objective objective_nonoboy = board_nonoboy.registerNewObjective("test", "dummy");
                
		        objective_nonoboy.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_nonoboy.setDisplayName("RC UHC V2");
		        Score score1_nonoboy = objective_nonoboy.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_nonoboy.setScore(7);
		        Joueur nonoboy = main.getJoueurByRole(Roles.NONOBOY);
		        Score scoreep_nonoboy = objective_nonoboy.getScore("Episode : " + main.getEpisode());
		        scoreep_nonoboy.setScore(6);
		        Score scorej_nonoboy = objective_nonoboy.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_nonoboy.setScore(5);
		        Score scorekill_nonoboy = objective_nonoboy.getScore("Kill : " + nonoboy.getKill() );
		        scorekill_nonoboy.setScore(4);
		        Score score2_nonoboy = objective_nonoboy.getScore("Role: " + nonoboy.getCouleurCamp() + "Nonoboy");
		        score2_nonoboy.setScore(3);
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
		        score3_nonoboy.setScore(2);
		        Score score4_nonoboy;
		        if(main.getJoueurByRole(Roles.NONOBOY).isOrbeActif()) {
		        	
		        	score4_nonoboy = objective_nonoboy.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_nonoboy = objective_nonoboy.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_nonoboy.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.FARMEURIMMO) && main.getJoueurByRole(Roles.FARMEURIMMO) != null) {
            	
            	if(!board_farmeurimmo.getObjectives().isEmpty() && board_farmeurimmo.getObjective("test") != null) {
            		board_farmeurimmo.getObjective("test").unregister();
        		}
            		
            	Objective objective_farmeurimmo = board_farmeurimmo.registerNewObjective("test", "dummy");
                
		        objective_farmeurimmo.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_farmeurimmo.setDisplayName("RC UHC V2");
		        Score score1_farmeurimmo = objective_farmeurimmo.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_farmeurimmo.setScore(7);
		        Joueur farmeurimmo = main.getJoueurByRole(Roles.FARMEURIMMO);
		        Score scoreep_farmeurimmo = objective_farmeurimmo.getScore("Episode : " + main.getEpisode());
		        scoreep_farmeurimmo.setScore(6);
		        Score scorej_farmeurimmo = objective_farmeurimmo.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_farmeurimmo.setScore(5);
		        Score scorekill_farmeurimmo = objective_farmeurimmo.getScore("Kill : " + farmeurimmo.getKill() );
		        scorekill_farmeurimmo.setScore(4);
		        Score score2_farmeurimmo = objective_farmeurimmo.getScore("Role: " + farmeurimmo.getCouleurCamp() + "Farmeurimmo");
		        score2_farmeurimmo.setScore(3);
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
		        score3_farmeurimmo.setScore(2);
		        Score score4_farmeurimmo;
		        if(main.getJoueurByRole(Roles.FARMEURIMMO).isOrbeActif()) {
		        	
		        	score4_farmeurimmo = objective_farmeurimmo.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_farmeurimmo = objective_farmeurimmo.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_farmeurimmo.setScore(1);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.KZOU) && main.getJoueurByRole(Roles.KZOU) != null) {
            	
            	if(!board_kzou.getObjectives().isEmpty()) {
            		board_kzou.getObjective("test").unregister();
        		}
            		
            	Objective objective_kzou = board_kzou.registerNewObjective("test", "dummy");
                
		        objective_kzou.setDisplaySlot(DisplaySlot.SIDEBAR);
		        objective_kzou.setDisplayName("RC UHC V2");
		        Score score1_kzou = objective_kzou.getScore("Durée: " + main.getTimerInTexte(timer));
		        score1_kzou.setScore(7);
		        Joueur kzou = main.getJoueurByRole(Roles.KZOU);
		        Score scoreep_kzou = objective_kzou.getScore("Episode : " + main.getEpisode());
		        scoreep_kzou.setScore(6);
		        Score scorej_kzou = objective_kzou.getScore("Joueurs : " + main.getListJoueurs().size() );
		        scorej_kzou.setScore(5);
		        Score scorekill_kzou = objective_kzou.getScore("Kill : " + kzou.getKill() );
		        scorekill_kzou.setScore(4);
		        Score score2_kzou = objective_kzou.getScore("Role: " + kzou.getCouleurCamp() + "Kzou");
		        score2_kzou.setScore(3);
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
		        score3_kzou.setScore(2);
		        Score score4_kzou;
		        if(main.getJoueurByRole(Roles.KZOU).isOrbeActif()) {
		        	
		        	score4_kzou = objective_kzou.getScore("Etat de l'orbe: §aActive");
		        	
		        }
		        else {
		        	
		        	score4_kzou = objective_kzou.getScore("Etat de l'orbe: §cInactive");
		        	
		        }
		        score4_kzou.setScore(1);
	        
        	}
	        
    	}
        
        for(Joueur joueur : main.getListJoueurs()) {
        	
        	Player player = joueur.getPlayer();
        	
        	//System.out.println("Joueur : " + player.getName());
        	//System.out.println("Role : " + joueur.getRole().toString());
        	
        	if(joueur.getRole() == Roles.NONE || joueur.isMort()) {
        		
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
        		
	            player.setScoreboard(board_farmeurimmo);
	            
            }
        	else if(joueur.getRole() == Roles.KZOU) {
                
	            player.setScoreboard(board_kzou);
	            
            }
            
        }
    	
    }
    
	@Override
    public void run() {
		
		if(main.getState() == Statut.FINISH) {
			
			main.reloadGame();
			
			cancel();
			
		}
		
		if((timer > 2400 && timer < 3600 && timer%600 == 0 && main.getMode().equalsIgnoreCase("normal")) || (timer > 0 && timer < 12000 && timer%600 == 0 && main.getMode().equalsIgnoreCase("rapide"))) {
			
			if(main.getJoueurByRole(Roles.TRIAL) != null && main.getJoueurByRole(Roles.SLUP) != null && main.getJoueurByRole(Roles.SLUP).getCamp() != "duo" && main.getJoueurByRole(Roles.SLUP).getPacteSlup() == 2) {
				
				Joueur slup = main.getJoueurByRole(Roles.SLUP);
				
				if(slup.isProche10(Roles.TRIAL, main)) {
					
					slup.getPlayer().sendMessage("Trial se trouve dans un rayon de 10 blocs");
					
				}
				else {
					
					slup.getPlayer().sendMessage("Trial n'est pas proche de vous");
					
				}
				
			}
			
		}
		
		if(timer % 200 == 0 && !main.getMaudit().isEmpty() && main.getNiv_maledition() != 3) {
			
			Joueur cible1 = main.getMaudit().get(0);
			Joueur cible2 = main.getMaudit().get(1);
			
			if(!cible1.isProche(cible2.getRole(), main)) {
				
				if(cible1.getPlayer().getHealth() > 3) {
					
					cible1.getPlayer().setHealth(cible1.getPlayer().getHealth()-2);
					
				}
				
				if(cible2.getPlayer().getHealth() > 3) {
					
					cible2.getPlayer().setHealth(cible2.getPlayer().getHealth()-2);
					
				}
				
			}
			
		}
		
		if(timer % 150 == 0 && !main.getMaudit().isEmpty() && main.getNiv_maledition() == 3) {
			
			Joueur cible1 = main.getMaudit().get(0);
			Joueur cible2 = main.getMaudit().get(1);
			
			if(!cible1.isProche(cible2.getRole(), main)) {
				
				if(cible1.getPlayer().getHealth() > 4) {
					
					cible1.getPlayer().setHealth(cible1.getPlayer().getHealth()-3);
					
				}
				
				if(cible2.getPlayer().getHealth() > 4) {
					
					cible2.getPlayer().setHealth(cible2.getPlayer().getHealth()-3);
					
				}
				
			}
			
		}
		
		if(timer % 140 == 0 && ((main.getEpisode() > 2 && main.getTemps() > 1 && main.getMode().equalsIgnoreCase("normal")) || (main.getEpisode() >= 1 && main.getTemps() > 11 && main.getMode().equalsIgnoreCase("rapide")))) {
			
			for(Joueur joueur : main.getListJoueurs()) {
				
				if(!joueur.isMort() && joueur.getRole() != Roles.FARMEURIMMO && joueur.getRole() != Roles.NONE && !joueur.isProche(Roles.FARMEURIMMO, main)) {
					
					joueur.addPourcentHack(1, main, board_farmeurimmo);
					
				}
				
			}
			
		}
        
        if(timer % 10 == 0) {
        	
        	if(main.getJoueurByRole(Roles.SLUP) != null) {
        		
        		Joueur slup = main.getJoueurByRole(Roles.SLUP);
        		
        		slup.addTimerPalierSlup();
        		
        		if(slup.getTimerPalierSlup() > 600 && slup.getPalierSlup() == 1 && slup.isSlupBonusPalierActif()) {
        			
        			slup.removeSlime(1);
        			slup.setTimerPalierSlup(0);
        			
        			if(slup.getSlime() == 0) {
        				
        				slup.getPlayer().sendMessage("Vous n'avez plus de boules de slime, vous perdez donc de la speed");
        				slup.setSlupBonusPalierActif(false);
        				slup.setMalusSlupActif(true);
        				slup.removeForce(0.02);
        				slup.removeSpeed(0.02);
        				
        			}
        			
        		} else if(slup.getTimerPalierSlup() > 420 && slup.getPalierSlup() == 2 && slup.isSlupBonusPalierActif()) {
        			
        			slup.removeSlime(1);
        			slup.setTimerPalierSlup(0);
        			
        			if(slup.getSlime() == 0) {
        				
        				slup.getPlayer().sendMessage("Vous n'avez plus de boules de slime, vous perdez donc de la speed");
        				slup.setSlupBonusPalierActif(false);
        				slup.setMalusSlupActif(true);
        				slup.removeForce(0.03);
        				slup.removeSpeed(0.03);
        				
        			}
        			
        		} else if(slup.getTimerPalierSlup() > 300 && slup.getPalierSlup() == 3 && slup.isSlupBonusPalierActif()) {
        			
        			slup.removeSlime(1);
        			slup.setTimerPalierSlup(0);
        			
        			if(slup.getSlime() == 0) {
        				
        				slup.getPlayer().sendMessage("Vous n'avez plus de boules de slime, vous perdez donc de la speed");
        				slup.setSlupBonusPalierActif(false);
        				slup.setMalusSlupActif(true);
        				slup.removeForce(0.05);
        				slup.removeSpeed(0.05);
        				
        			}
        			
        		} else if(slup.getTimerPalierSlup() > 420 && slup.getPalierSlup() == 4 && slup.isSlupBonusPalierActif()) {
        			
        			slup.removeSlime(2);
        			slup.setTimerPalierSlup(0);
        			
        			if(slup.getSlime() == 0) {
        				
        				slup.getPlayer().sendMessage("Vous n'avez plus de boules de slime, vous perdez donc de la speed");
        				slup.setSlupBonusPalierActif(false);
        				slup.setMalusSlupActif(true);
        				slup.removeSpeed(0.07);
        				
        			}
        			
        		}
        		
        		if(main.getLocZoneSlup() != null) {
            		
            		for(Joueur j : main.getJoueurInGame()) {
            			
            			if(j.isInSlupZone(main) && !j.isMalusZoneSlup() && j.getCamp() != slup.getCamp()) {
            				
            				j.setMalusZoneSlup(true);
            				j.removeSpeed(0.05);
            				
            			}
            			else if(!j.isInSlupZone(main) && j.isMalusZoneSlup() && j.getCamp() != slup.getCamp()) {
            				
            				j.setMalusZoneSlup(false);
            				j.addSpeed(0.05);
            				
            			}
            			
            		}
            		
            	}
        		
        	}
        	
        	if(!main.getMaudit().isEmpty() && main.getNiv_maledition() > 1) {
        		
        		Joueur cible1 = main.getMaudit().get(0);
    			Joueur cible2 = main.getMaudit().get(1);
    			
    			if(!cible1.isProche(cible2.getRole(), main)) {
    				
    				cible1.setAbso(false);
    				cible2.setAbso(false);
    				
    			}
    			else {
    				
    				cible1.setAbso(true);
    				cible2.setAbso(true);
    				
    			}
        		
        	}
        	
        	if(main.getNeko() != null && !main.getNeko().isMort() && main.getNeko().isProche(Roles.MAKA, main) && !main.getNeko().isSpeedProche() && !main.getJoueurByRole(Roles.MAKA).isMort()) {
        		
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
        	else if(main.getNeko() != null && !main.getNeko().isProche(Roles.MAKA, main) && main.getNeko().isSpeedProche()) {
        		
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
        	
        	if(main.getJoueurByRole(Roles.JEANNOT) != null) {
        		
        		if(main.getJoueurByRole(Roles.NICKOBOOP) != null) {
        		
        			Nickoboop.checkProcheJeannot(main.getJoueurByRole(Roles.NICKOBOOP), main);
        			
        		}
        		
        		if(main.getJoueurByRole(Roles.FARMEURIMMO) != null && main.getJoueurByRole(Roles.FARMEURIMMO).getVol().contains(Pouvoirs.NICKOBOOP_PROCHE_JEANNOT)) {
        			
        			Nickoboop.checkProcheJeannot(main.getJoueurByRole(Roles.FARMEURIMMO), main);
        			
        		}
        		
        	}
        	
        	if (main.getTemps() == main.getTempsEpisode() / 2 && main.getEpisode() != 1) {
        		
        		Joueur slup = main.getJoueurByRole(Roles.SLUP);
        		
        		if(slup != null) {
        			slup.addSlime(1);
        		}
        		
        		resetCD(main);

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
            
            for (Joueur joueur : main.getJoueurInGame()) {
    	    	
    	    	Player player = joueur.getPlayer();
    	    	
    	    	if(joueur.isCorrompu()) {
    	    		
    	    		List<Joueur> corruption = new ArrayList<>();
    	    		
    	    		for(Entity entity : player.getNearbyEntities(20, 20, 20)) {
    	    			
    	    			if(entity instanceof Player) {
    	    				
    	    				Player pls = (Player) entity;
    	    				Joueur j = main.getJoueur(pls);
    	    				if(!j.isCorrompuIndirect()) {
    	    					
    	    					j.setCorrompuIndirect(true);
    	    					j.removeForce(0.02);
    	    					
    	    				}
    	    				corruption.add(j);
    	    				
    	    			}
    	    			
    	    		}
    	    		
    	    		for(Joueur j : main.getJoueurInGame()) {
    	    			
    	    			if(!corruption.contains(j) && j.isCorrompuIndirect()) {
    	    				
    	    				j.addForce(0.02);
    	    				
    	    			}
    	    			
    	    		}
    	    		
    	    	}
    	
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
        	
        }

        timer++;

    }

}
