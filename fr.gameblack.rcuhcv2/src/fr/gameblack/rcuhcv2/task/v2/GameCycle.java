package fr.gameblack.rcuhcv2.task.v2;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.evenement.v2.FermetureGolden;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.roles.v2.joueur.Nickoboop;
import fr.gameblack.rcuhcv2.roles.v2.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.v2.staff.Team;
import fr.gameblack.rcuhcv2.roles.v2.staff.Trial;
import fr.gameblack.rcuhcv2.scenarios.Scenarios;
import fr.gameblack.rcuhcv2.scenarios.v2.Skin;

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
    private static Scoreboard board_theoochoux;
    
    private static Scoreboard board_farmeurimmo;
    private static Scoreboard board_kzou;
    
    @SuppressWarnings("unused")
	private Scoreboard board_pourcent;
    
    private boolean score_board = true;

    @SuppressWarnings("static-access")
	public GameCycle(Main main, Scoreboard board_base, Scoreboard board_pourcent, Scoreboard board_raptor, Scoreboard board_jeannot, Scoreboard board_nickoboop, Scoreboard board_slup, Scoreboard board_joko, Scoreboard board_team, Scoreboard board_gameblack, Scoreboard board_maka, Scoreboard board_trial, Scoreboard board_loup, Scoreboard board_captain, Scoreboard board_hekow, Scoreboard board_malivol, Scoreboard board_toinou, Scoreboard board_obscur, Scoreboard board_nonoboy, Scoreboard board_theoochoux, Scoreboard board_farmeurimmo, Scoreboard board_kzou) {
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
        this.board_theoochoux = board_theoochoux;
        
        this.board_farmeurimmo = board_farmeurimmo;
        this.board_kzou = board_kzou;
    }

    public static void Nuit(Main main) {
    	
    	if(main.getJoueurByRole(Roles.KZOU) != null) {
    		
    		main.getJoueurByRole(Roles.KZOU).removeResi(0.02);
    		
    	}
    	
    	if(main.isFermetureGolden()) {

	        if(main.getEpisode() == 1 && (main.getMode().equalsIgnoreCase("rapide") || main.getMode().equalsIgnoreCase("meetup"))) {
	        	
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
	        	
	        	if(main.getMode().equalsIgnoreCase("rapide") || main.getMode().equalsIgnoreCase("meetup")) {
	        		
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
    	
    	if(main.getJoueurByRole(Roles.KZOU) != null) {
    		
    		main.getJoueurByRole(Roles.KZOU).addResi(0.02);
    		
    	}
    	
    	if(main.isFermetureGolden()) {

	    	if(main.getEpisode() == 1 && (main.getMode().equalsIgnoreCase("rapide") || main.getMode().equalsIgnoreCase("meetup"))) {
	        	
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
	        	
	        	if(main.getMode().equalsIgnoreCase("rapide") || main.getMode().equalsIgnoreCase("meetup")) {
	        		
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
    	else if(main.getCD().contains(Pouvoirs.HEKOW_JEU)) {
    		
    		main.getCD().remove(Pouvoirs.HEKOW_JEU);
    		
    	}
    	else if(main.getCD().contains(Pouvoirs.CAPTAIN_ENCHANT_OTHER)) {
    		
    		main.getCD().remove(Pouvoirs.CAPTAIN_ENCHANT_OTHER);
    		
    	}
    	else if(main.getCD().contains(Pouvoirs.CAPTAIN_ENCHANT_SELF)) {
    		
    		main.getCD().remove(Pouvoirs.CAPTAIN_ENCHANT_SELF);
    		
    	}
    	else if(main.getCD().contains(Pouvoirs.CAPTAIN_REPAIR)) {
    		
    		main.getCD().remove(Pouvoirs.CAPTAIN_REPAIR);
    		
    	}
    	else if(main.getCD().contains(Pouvoirs.OBSCUR_ADAPTION)) {
    		
    		main.getCD().remove(Pouvoirs.OBSCUR_ADAPTION);
    		
    	}
    	else if(main.getCD().contains(Pouvoirs.RAPTOR_RAGE)) {
    		
    		main.getCD().remove(Pouvoirs.RAPTOR_RAGE);
    		
    	}
    	else if(main.getCD().contains(Pouvoirs.TRIAL_JEU)) {
    		
    		main.getCD().remove(Pouvoirs.TRIAL_JEU);
    		
    	}
    	else if(main.getCD().contains(Pouvoirs.TRIAL_BENIHIME)) {
    		
    		main.getCD().remove(Pouvoirs.TRIAL_BENIHIME);
    		
    	}
    	else if(main.getCD().contains(Pouvoirs.TRIAL_SAKASHIMA)) {
    		
    		main.getCD().remove(Pouvoirs.TRIAL_SAKASHIMA);
    		
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
        	
        	if(!j.isSpec()) {
        	
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
		            j.setRole(role, main);
		            compo.remove(role);
		            nombre -= 1;
		            j.setInvulnerable(false);
		
		            pls.setHealth(pls.getMaxHealth());
		            
	        	}
	        	else {
	        		
	        		Player pls = j.getPlayer();
	        		
	        		Roles role = compo.get(0);
	        		compo_.add(role);
	        		j.setRole(role, main);
	        		compo.remove(role);
	        		j.setInvulnerable(false);
	        		pls.setHealth(pls.getMaxHealth());
	        		
	        	}
	        	
        	}

        }
        
        main.setCompo(compo_);
        
        if(main.getCompo().contains(Roles.JEANNOT) && main.getCompo().contains(Roles.NICKOBOOP)) {
        	
        	Joueur jeannot = main.getJoueurByRole(Roles.JEANNOT);
        	Joueur nickoboop = main.getJoueurByRole(Roles.NICKOBOOP);
        	jeannot.getPlayer().sendMessage("Nickoboop : " + nickoboop.getPlayer().getDisplayName());
        	nickoboop.getPlayer().sendMessage("Jeannot : " + jeannot.getPlayer().getDisplayName());
        	
        }
        else if(main.getCompo().contains(Roles.JEANNOT)) {
        	
        	main.getJoueurByRole(Roles.JEANNOT).addForce(0.02);
        	main.getJoueurByRole(Roles.JEANNOT).getPlayer().sendMessage("§aNickoboop§r n'étant pas dans la compo, vous recevez 2% de force permanent");
        	
        }
        else if(main.getCompo().contains(Roles.NICKOBOOP)) {
        	
        	main.getJoueurByRole(Roles.NICKOBOOP).addResi(0.02);
        	main.getJoueurByRole(Roles.NICKOBOOP).getPlayer().sendMessage("§aJeannot§r n'étant pas dans la compo, vous recevez 2% de résistance permanent");
        	
        }
        
        if(main.getCompo().contains(Roles.MALIVOL) && main.getCompo().contains(Roles.TOINOU)) {
        	
        	Joueur malivol = main.getJoueurByRole(Roles.MALIVOL);
        	Joueur toinou = main.getJoueurByRole(Roles.TOINOU);
        	
        	malivol.getPlayer().sendMessage("§2Toinou§r : " + toinou.getPlayer().getName());
        	
        }
        
        if(main.getCompo().contains(Roles.OBSCUR) && !main.getCompo().contains(Roles.TOINOU)) {
        	
        	Joueur obscur = main.getJoueurByRole(Roles.OBSCUR);
        	obscur.setTueurToinouKill(true);
        	obscur.addForce(0.02);
        	obscur.getPlayer().sendMessage("§2Toinou§r n'étant pas dans la compo, vous recevez 2% de force permanent");
        	
        }
        
        if(main.getCompo().contains(Roles.TRIAL) && main.getCompo().contains(Roles.LOUP)) {
        	
        	Joueur trial = main.getJoueurByRole(Roles.TRIAL);
        	Joueur loup = main.getJoueurByRole(Roles.LOUP);
        	trial.getPlayer().sendMessage("§9Loup§r : " + loup.getPlayer().getDisplayName());
        	
        }
        
        if(main.getCompo().contains(Roles.HEKOW) && main.getCompo().contains(Roles.CAPTAIN)) {
        	
        	Joueur hekow = main.getJoueurByRole(Roles.HEKOW);
        	Joueur captain = main.getJoueurByRole(Roles.CAPTAIN);
        	
        	hekow.getPlayer().sendMessage("§9Captain§r : " + captain.getPlayer().getName());
        	
        }
        
        if(main.getScenarios().contains(Scenarios.SKIN)) {
        	
        	Skin.setSkin(main);
        	
        }
    	
    }
    
    public static Scoreboard getScoreboardFarmeurimmo() {
    	return board_farmeurimmo;
    }
    
    public static Scoreboard getScoreboardJoko() {
    	return board_joko;
    }
    
    public static void ScoreboardBase(Main main, int timer, Roles role, Objective objective) {
    	
    	Joueur j = main.getJoueurByRole(role);
        
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("RC UHC V2");
        Score score1 = objective.getScore("Durée: " + main.getTimerInTexte(timer));
        score1.setScore(10);
        Score scoreep = objective.getScore("Episode : " + main.getEpisode());
        scoreep.setScore(9);
        Score score2 = objective.getScore("Joueurs : " + main.getListJoueurs().size() );
        score2.setScore(8);
        Score scorekill = objective.getScore("Kill : " + j.getKill() );
        scorekill.setScore(7);
        Score score3 = objective.getScore("Role: " + j.getCouleurCamp(main) + j.getRole().getTxt());
        score3.setScore(6);
        Score score4;
        if(j.getOrbe() == Orbe.EAU) {
        	
        	score4 = objective.getScore("Orbe: §1Eau");
        	
        }
        else if(j.getOrbe() == Orbe.FEU) {
        	
        	score4 = objective.getScore("Orbe: §cFeu");
        	
        }
        else if(j.getOrbe() == Orbe.GLACE) {
        	
        	score4 = objective.getScore("Orbe: §bGlace");
        	
        }
        else if(j.getOrbe() == Orbe.FOUDRE) {
        	
        	score4 = objective.getScore("Orbe: §eFoudre");
        	
        }
        else {
        	
        	score4 = objective.getScore("Orbe: Aucune");
        	
        }
        
        score4.setScore(5);
        Score score5;
        if(j.isOrbeActif()) {
        	
        	score5 = objective.getScore("Etat de l'orbe: §aActive");
        	
        }
        else {
        	
        	score5 = objective.getScore("Etat de l'orbe: §cInactive");
        	
        }
        score5.setScore(4);
        Score scoreip = objective.getScore("play.rubiscraft.fr");
        scoreip.setScore(1);
    	
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
        score1_base.setScore(4);
        Score scoreep_base = objective_base.getScore("Episode : " + main.getEpisode());
        scoreep_base.setScore(3);
        Score score2_base = objective_base.getScore("Joueurs : " + main.getListJoueurs().size() );
        score2_base.setScore(2);
        Score scoreip = objective_base.getScore("play.rubiscraft.fr");
        scoreip.setScore(1);
        if(objective_hp == null) {
        	objective_hp = board_base.registerNewObjective("hp", "health");
        }
        objective_hp.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective_hp.setDisplayName("HP");
        
        if((main.getEpisode() > 1 || (main.getEpisode() == 2 && main.getTemps() > 2)) || (main.getTemps() > 10 && main.getEpisode() >= 1 && (main.getMode().equalsIgnoreCase("rapide") || main.getMode().equalsIgnoreCase("meetup")))) {
        	
        	if(main.getCompo().contains(Roles.RAPTOR) && main.getJoueurByRole(Roles.RAPTOR) != null) {
            	
            	if(!board_raptor.getObjectives().isEmpty()) {
            		board_raptor.getObjective("test").unregister();
            	}
            		
            	Objective objective_raptor = board_raptor.registerNewObjective("test", "dummy");
                
		        ScoreboardBase(main, timer, Roles.RAPTOR, objective_raptor);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.JEANNOT)  && main.getJoueurByRole(Roles.JEANNOT) != null) {
            	
            	if(!board_jeannot.getObjectives().isEmpty()) {
            		board_jeannot.getObjective("test").unregister();
        		}
            		
            	Objective objective_jeannot = board_jeannot.registerNewObjective("test", "dummy");
            	
            	ScoreboardBase(main, timer, Roles.JEANNOT, objective_jeannot);
            	Score scorepartage_jeannot;
		        if(main.getJoueurByRole(Roles.JEANNOT).isJeannotPartageActif()) {
		        	
		        	scorepartage_jeannot = objective_jeannot.getScore("Partage: §aActif");
		        	
		        }
		        else {
		        	
		        	scorepartage_jeannot = objective_jeannot.getScore("Partage: §cInnactif");
		        	
		        }
		        scorepartage_jeannot.setScore(3);
		        
            	Score scoreabso_jeannot;
		        if(main.getJoueurByRole(Roles.JEANNOT).isJeannotAbso()) {
		        	
		        	scoreabso_jeannot = objective_jeannot.getScore("Absorption: §aActif");
		        	
		        }
		        else {
		        	
		        	scoreabso_jeannot = objective_jeannot.getScore("Absorption: §cInnactif");
		        	
		        }
		        scoreabso_jeannot.setScore(2);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.NICKOBOOP) && main.getJoueurByRole(Roles.NICKOBOOP) != null) {
	                   	
            	if(!board_nickoboop.getObjectives().isEmpty()) {
            		board_nickoboop.getObjective("test").unregister();
        		}
            		
            	Objective objective_nickoboop = board_nickoboop.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.NICKOBOOP, objective_nickoboop);
		    
        	}
        	
        	if(main.getCompo().contains(Roles.SLUP) && main.getJoueurByRole(Roles.SLUP) != null) {
	                    	
            	if(!board_slup.getObjectives().isEmpty()) {
            		board_slup.getObjective("test").unregister();
        		}
            		
            	Objective objective_slup = board_slup.registerNewObjective("test", "dummy");
            	
            	Joueur slup = main.getJoueurByRole(Roles.SLUP);
                
            	ScoreboardBase(main, timer, Roles.SLUP, objective_slup);
		        
		        Score scoreslime_slup = objective_slup.getScore("Slime: " + slup.getSlime());
		        scoreslime_slup.setScore(3);
		        Score scoreinvi_slup;
		        if(slup.isInvisible()) {
		        	
		        	scoreinvi_slup = objective_slup.getScore("Invisible: §aActif");
		        	
		        }
		        else {
		        	
		        	scoreinvi_slup = objective_slup.getScore("Invisible: §cInnactif");
		        	
		        }
		        scoreinvi_slup.setScore(2);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.JOKO) && main.getJoueurByRole(Roles.JOKO) != null) {
	                    	
            	if(!board_joko.getObjectives().isEmpty() && board_joko.getObjective("test") != null) {
            		board_joko.getObjective("test").unregister();
        		}
            		
            	Objective objective_joko = board_joko.registerNewObjective("test", "dummy");
            	
            	ScoreboardBase(main, timer, Roles.JOKO, objective_joko);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.TEAM) && main.getJoueurByRole(Roles.TEAM) != null) {
                   	
            	if(!board_team.getObjectives().isEmpty()) {
            		board_team.getObjective("test").unregister();
        		}
            		
            	Objective objective_team = board_team.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.TEAM, objective_team);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.GAMEBLACK) && main.getJoueurByRole(Roles.GAMEBLACK) != null) {
            	
            	if(!board_gameblack.getObjectives().isEmpty()) {
            		board_gameblack.getObjective("test").unregister();
        		}
            		
            	Objective objective_gb = board_gameblack.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.GAMEBLACK, objective_gb);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.MAKA)  && main.getJoueurByRole(Roles.MAKA) != null) {
            	
            	if(!board_maka.getObjectives().isEmpty()) {
            		board_maka.getObjective("test").unregister();
        		}
            		
            	Objective objective_maka = board_maka.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.MAKA, objective_maka);
            	
            	if(main.getJoueurByRole(Roles.MAKA).getForme().equalsIgnoreCase("simp") && main.getNeko() != null) {
            		
            		Score scoreneko_maka = objective_maka.getScore("Neko: " + main.getNeko().getPlayer().getName());
    		        scoreneko_maka.setScore(3);
            		
            	}
		        
        	}
        	
        	if(main.getCompo().contains(Roles.TRIAL) && main.getJoueurByRole(Roles.TRIAL) != null) {
	        
        		if(!board_trial.getObjectives().isEmpty()) {
            		board_trial.getObjective("test").unregister();
        		}
            		
            	Objective objective_trial = board_trial.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.TRIAL, objective_trial);
            	
            	Score scoremode_trial = objective_trial.getScore("Mode : " + main.getModeTrial());
		        scoremode_trial.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.LOUP) && main.getJoueurByRole(Roles.LOUP) != null) {
	        
        		if(!board_loup.getObjectives().isEmpty()) {
            		board_loup.getObjective("test").unregister();
        		}
            		
            	Objective objective_loup = board_loup.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.LOUP, objective_loup);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.CAPTAIN) && main.getJoueurByRole(Roles.CAPTAIN) != null) {
            	
            	if(!board_captain.getObjectives().isEmpty()) {
            		board_captain.getObjective("test").unregister();
        		}
            	
            	Objective objective_captain = board_captain.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.CAPTAIN, objective_captain);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.HEKOW) && main.getJoueurByRole(Roles.HEKOW) != null) {
            	
            	if(!board_hekow.getObjectives().isEmpty()) {
            		board_hekow.getObjective("test").unregister();
        		}
            		
            	Objective objective_hekow = board_hekow.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.HEKOW, objective_hekow);
            	
            	Score scorepourcent_hekow = objective_hekow.getScore("Pourcent: " + main.getJoueurByRole(Roles.HEKOW).getHekowPourcent());
            	scorepourcent_hekow.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.MALIVOL) && main.getJoueurByRole(Roles.MALIVOL) != null) {
            	
            	if(!board_malivol.getObjectives().isEmpty()) {
            		board_malivol.getObjective("test").unregister();
        		}
            		
            	Objective objective_malivol = board_malivol.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.MALIVOL, objective_malivol);
            	
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
		        	
		        	score5_malivol.setScore(3);
		        	
		        }
		        
        	}
        	
        	if(main.getCompo().contains(Roles.TOINOU) && main.getJoueurByRole(Roles.TOINOU) != null) {
            	
            	if(!board_toinou.getObjectives().isEmpty()) {
            		board_toinou.getObjective("test").unregister();
        		}
            		
            	Objective objective_toinou = board_toinou.registerNewObjective("test", "dummy");
            	ScoreboardBase(main, timer, Roles.TOINOU, objective_toinou);
            	
		        Joueur toinou = main.getJoueurByRole(Roles.TOINOU);
		        
		        Score scoreslime_slup = objective_toinou.getScore("Points: " + toinou.getPoints());
		        scoreslime_slup.setScore(3);
		        
		        Score scoreinvi_toinou;
		        if(toinou.isInvisible()) {
		        	
		        	scoreinvi_toinou = objective_toinou.getScore("Invisible: §aActif");
		        	
		        }
		        else {
		        	
		        	scoreinvi_toinou = objective_toinou.getScore("Invisible: §cInnactif");
		        	
		        }
		        scoreinvi_toinou.setScore(2);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.OBSCUR) && main.getJoueurByRole(Roles.OBSCUR) != null) {
            	
            	if(!board_obscur.getObjectives().isEmpty()) {
            		board_obscur.getObjective("test").unregister();
        		}
            		
            	Objective objective_obscur = board_obscur.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.OBSCUR, objective_obscur);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.NONOBOY) && main.getJoueurByRole(Roles.NONOBOY) != null) {
            	
            	if(!board_nonoboy.getObjectives().isEmpty()) {
            		board_nonoboy.getObjective("test").unregister();
        		}
            		
            	Objective objective_nonoboy = board_nonoboy.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.NONOBOY, objective_nonoboy);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.THEOOCHOUX) && main.getJoueurByRole(Roles.THEOOCHOUX) != null) {
            	
            	if(!board_theoochoux.getObjectives().isEmpty()) {
            		board_theoochoux.getObjective("test").unregister();
        		}
            		
            	Objective objective_theoochoux = board_theoochoux.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.THEOOCHOUX, objective_theoochoux);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.FARMEURIMMO) && main.getJoueurByRole(Roles.FARMEURIMMO) != null) {
            	
            	if(!board_farmeurimmo.getObjectives().isEmpty() && board_farmeurimmo.getObjective("test") != null) {
            		board_farmeurimmo.getObjective("test").unregister();
        		}
            		
            	Objective objective_farmeurimmo = board_farmeurimmo.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.FARMEURIMMO, objective_farmeurimmo);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.KZOU) && main.getJoueurByRole(Roles.KZOU) != null) {
            	
            	if(!board_kzou.getObjectives().isEmpty()) {
            		board_kzou.getObjective("test").unregister();
        		}
            		
            	Objective objective_kzou = board_kzou.registerNewObjective("test", "dummy");
                
            	ScoreboardBase(main, timer, Roles.KZOU, objective_kzou);
	        
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
        	else if(joueur.getRole() == Roles.THEOOCHOUX) {
                
	            player.setScoreboard(board_theoochoux);
	            
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
		
		if((timer > 2400 && timer < 3600 && timer%600 == 0 && main.getMode().equalsIgnoreCase("normal")) || (timer > 0 && timer < 12000 && timer%600 == 0 && (main.getMode().equalsIgnoreCase("rapide") || main.getMode().equalsIgnoreCase("meetup")))) {
			
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
			
			if(main.getMode().equalsIgnoreCase("rapide")) {
				
				Joueur cible1 = main.getMaudit().get(0);
				Joueur nono = main.getMaudit().get(1);
				
				if(!cible1.isProche(nono.getRole(), main)) {
					
					if(cible1.getPlayer().getHealth() > 3) {
						
						cible1.getPlayer().setHealth(cible1.getPlayer().getHealth()-1);
						
					}
					
				}
				
			}
			else {
			
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
			
		}
		
		if(timer % 150 == 0 && !main.getMaudit().isEmpty() && main.getNiv_maledition() == 3) {
			
			if(main.getMode().equalsIgnoreCase("rapide")) {
				
				Joueur cible1 = main.getMaudit().get(0);
				Joueur nono = main.getMaudit().get(1);
				
				if(!cible1.isProche(nono.getRole(), main)) {
					
					if(cible1.getPlayer().getHealth() > 4) {
						
						cible1.getPlayer().setHealth(cible1.getPlayer().getHealth()-1);
						
					}
					
				}
				
			}
			else {
			
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
			
		}
		
		if(timer % 140 == 0 && ((main.getEpisode() > 2 && main.getTemps() > 1 && main.getMode().equalsIgnoreCase("normal")) || (main.getEpisode() >= 1 && main.getTemps() > 11 && (main.getMode().equalsIgnoreCase("rapide") || main.getMode().equalsIgnoreCase("meetup"))))) {
			
			for(Joueur joueur : main.getListJoueurs()) {
				
				if(!joueur.isMort() && joueur.getRole() != Roles.FARMEURIMMO && joueur.getRole() != Roles.NONE && !joueur.isProche(Roles.FARMEURIMMO, main)) {
					
					joueur.addPourcentHack(1, main, board_farmeurimmo);
					
				}
				
			}
			
		}
		
    	if(main.getJoueurByRole(Roles.TOINOU) != null) {
    		
    		
    		
    		Joueur toinou = main.getJoueurByRole(Roles.TOINOU);
    		
    		ItemStack maudit = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta mauditM = maudit.getItemMeta();
            mauditM.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
            mauditM.setDisplayName("Épée maudite");
            maudit.setItemMeta(mauditM);
            
            ItemStack nuage = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemMeta nuageM = nuage.getItemMeta();
            nuageM.addEnchant(Enchantment.DAMAGE_ALL, 4, false);
            nuageM.setDisplayName("Nuage Flottant");
            nuage.setItemMeta(nuageM);
    		
    		if(toinou.getPlayer().getItemInHand().hasItemMeta() && toinou.getPlayer().getItemInHand().getItemMeta().getDisplayName() == "Nuage Flottant" && !toinou.isBonusToinouNuage()) {
    			
    			toinou.addSpeed(0.05);
    			toinou.setBonusToinouNuage(true);
    			
    		}
    		else if(!(toinou.getPlayer().getItemInHand().hasItemMeta() && toinou.getPlayer().getItemInHand().getItemMeta().getDisplayName() == "Nuage Flottant") && toinou.isBonusToinouNuage()){
    			
    			toinou.removeSpeed(0.05);
    			toinou.setBonusToinouNuage(false);
    			
    		}
    		
    		if(toinou.getPlayer().getItemInHand().hasItemMeta() && toinou.getPlayer().getItemInHand().getItemMeta().getDisplayName() == "Épée maudite" && !toinou.isBonusToinouMaudit()) {
    			
    			toinou.addForce(0.02);
    			toinou.setBonusToinouMaudit(true);
    			
    		}
    		else if(!(toinou.getPlayer().getItemInHand().hasItemMeta() && toinou.getPlayer().getItemInHand().getItemMeta().getDisplayName() == "Épée maudite") && toinou.isBonusToinouMaudit()){
    			
    			toinou.removeForce(0.02);
    			toinou.setBonusToinouMaudit(false);
    			
    		}
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.LOUP) != null && main.getJoueurByRole(Roles.LOUP).isSuperBateauLoup()) {
    		
    		for(Entity entity : Bukkit.getWorld("world").getEntities()) {
    			
    			if(entity instanceof Vehicle) {
    				
    				Vehicle boat = (Vehicle) entity;
    				
    				if(boat.isCustomNameVisible() && boat.getCustomName().equalsIgnoreCase("Super Bateau")) {
    					
    					System.out.println("c'est super bateau");
    					
    					if(boat.getPassenger() != null) {
    					
	    					Entity passager = boat.getPassenger();
	    					boat.eject();
	    					boat.teleport(main.getJoueurByRole(Roles.LOUP).getPlayer().getLocation());
	    					boat.setPassenger(passager);
    					
    					}
    					else {
    						
    						boat.teleport(main.getJoueurByRole(Roles.LOUP).getPlayer().getLocation());
    						
    					}
    					
    				}
    				
    			}
    			
    		}
    		
    		//Loup.getBoat().teleport(main.getJoueurByRole(Roles.LOUP).getPlayer().getLocation());
    		
    	}
        
        if(timer % 10 == 0) {
        	
        	Bukkit.getWorld("world").setStorm(false);
        	
        	if((main.getEpisode() == 2 && main.getMode().equalsIgnoreCase("normal")) || !main.getMode().equalsIgnoreCase("normal")) {
        		
        		if(timer % 3000 == 0 && main.getJoueurByRole(Roles.THEOOCHOUX) != null) {
        			
        			main.addStadeTheoochouxBonus(1);
        			
        		}
        		if(timer % 1800 == 0 && main.getJoueurByRole(Roles.THEOOCHOUX) != null) {
        			
        			main.addStadeTheochouxHack(1);
        			
        		}
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.THEOOCHOUX) != null) {
        		
        		Player theo = main.getJoueurByRole(Roles.THEOOCHOUX).getPlayer();
        		
        		RollBackCD cycle = new RollBackCD(main, theo.getLocation(), theo.getInventory(), theo.getHealth(), theo.getFoodLevel());
                cycle.runTaskTimer(main, 0, 20);
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.NICKOBOOP) != null && !main.getSpecNicko().isEmpty() && main.getMode().equalsIgnoreCase("rapide")) {
        		
        		Joueur nicko = main.getJoueurByRole(Roles.NICKOBOOP);
        		
        		for(Joueur j : main.getSpecNicko()) {
        			
        			if(!main.getGiveBoostNicko().contains(j) && j.isProche(Roles.NICKOBOOP, main)) {
        				
        				if(j.isBonPapiers()) {
        					
        					nicko.addForce(0.01);
        					main.getGiveBoostNicko().add(j);
        					
        					
        				}
        				else {
        					
        					main.getGiveBoostNicko().add(j);
        					nicko.addResi(0.01);
        					
        				}
        				
        			}
        			else if(main.getGiveBoostNicko().contains(j) && !j.isProche(Roles.NICKOBOOP, main)) {
        				
        				
        				if(j.isBonPapiers()) {
        					
        					main.getGiveBoostNicko().remove(j);
        					nicko.removeForce(0.01);
        					
        				}
        				else {
        					
        					main.getGiveBoostNicko().remove(j);
        					nicko.removeResi(0.01);
        					
        				}
        				
        			}
        			
        		}
        		
        	}
        	
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
        				slup.removeForce(0.01);
        				slup.removeSpeed(0.05);
        				
        			}
        			
        		} else if(slup.getTimerPalierSlup() > 420 && slup.getPalierSlup() == 2 && slup.isSlupBonusPalierActif()) {
        			
        			slup.removeSlime(1);
        			slup.setTimerPalierSlup(0);
        			
        			if(slup.getSlime() == 0) {
        				
        				slup.getPlayer().sendMessage("Vous n'avez plus de boules de slime, vous perdez donc de la speed");
        				slup.setSlupBonusPalierActif(false);
        				slup.setMalusSlupActif(true);
        				slup.removeForce(0.02);
        				slup.removeSpeed(0.07);
        				
        			}
        			
        		} else if(slup.getTimerPalierSlup() > 300 && slup.getPalierSlup() == 3 && slup.isSlupBonusPalierActif()) {
        			
        			slup.removeSlime(1);
        			slup.setTimerPalierSlup(0);
        			
        			if(slup.getSlime() == 0) {
        				
        				slup.getPlayer().sendMessage("Vous n'avez plus de boules de slime, vous perdez donc de la speed");
        				slup.setSlupBonusPalierActif(false);
        				slup.setMalusSlupActif(true);
        				slup.removeForce(0.03);
        				slup.removeSpeed(0.1);
        				
        			}
        			
        		} else if(slup.getTimerPalierSlup() > 420 && slup.getPalierSlup() == 4 && slup.isSlupBonusPalierActif()) {
        			
        			slup.removeSlime(2);
        			slup.setTimerPalierSlup(0);
        			
        			if(slup.getSlime() == 0) {
        				
        				slup.getPlayer().sendMessage("Vous n'avez plus de boules de slime, vous perdez donc de la speed");
        				slup.setSlupBonusPalierActif(false);
        				slup.setMalusSlupActif(true);
        				slup.removeForce(0.05);
        				slup.removeSpeed(0.015);
        				
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
        		
        		if(main.getMode().equalsIgnoreCase("rapide")) {
        			
            		Joueur cible1 = main.getMaudit().get(0);
        			Joueur nono = main.getMaudit().get(1);
        			
        			if(!cible1.isProche(nono.getRole(), main)) {
        				
        				cible1.setAbso(false);
        				
        			}
        			else {
        				
        				cible1.setAbso(true);
        				
        			}
        			
        		}
        		else {
        		
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
        		
        	}
        	
        	if(main.getNeko() != null && !main.getNeko().isMort() && main.getNeko().isProche(Roles.MAKA, main) && !main.getNeko().isSpeedProche() && !main.getJoueurByRole(Roles.MAKA).isMort()) {
        		
        		if(main.getNbJoueursStaff() == 6) {
        			main.getNeko().addSpeed(0.01);
        			main.getNeko().addForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.01);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.01);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 5) {
        			main.getNeko().addSpeed(0.02);
        			main.getNeko().addForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.02);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.01);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 4) {
        			main.getNeko().addSpeed(0.05);
        			main.getNeko().addForce(0.01);
        			main.getNeko().addResi(0.01);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.05);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).addResi(0.01);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 3) {
        			main.getNeko().addSpeed(0.05);
        			main.getNeko().addForce(0.02);
        			main.getNeko().addResi(0.01);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.05);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).addResi(0.01);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 2) {
        			main.getNeko().addSpeed(0.07);
        			main.getNeko().addForce(0.02);
        			main.getNeko().addResi(0.02);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.07);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).addResi(0.02);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		else if(main.getNbJoueursStaff() == 1) {
        			main.getNeko().addSpeed(0.10);
        			main.getNeko().addForce(0.02);
        			main.getNeko().addResi(0.02);
        			main.getJoueurByRole(Roles.MAKA).addSpeed(0.1);
        			main.getJoueurByRole(Roles.MAKA).addForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).addResi(0.02);
        			main.getNeko().setSpeedProche(true);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(true);
        		}
        		
        	}
        	else if(main.getNeko() != null && !main.getNeko().isProche(Roles.MAKA, main) && main.getNeko().isSpeedProche()) {
        		
        		if(main.getNbJoueursStaff() == 6) {
        			main.getNeko().removeSpeed(0.01);
        			main.getNeko().removeForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.01);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 5) {
        			main.getNeko().removeSpeed(0.02);
        			main.getNeko().removeForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.01);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 4) {
        			main.getNeko().removeSpeed(0.05);
        			main.getNeko().removeForce(0.01);
        			main.getNeko().removeResi(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.05);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeResi(0.01);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 3) {
        			main.getNeko().removeSpeed(0.05);
        			main.getNeko().removeForce(0.02);
        			main.getNeko().removeResi(0.01);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.05);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeResi(0.01);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 2) {
        			main.getNeko().removeSpeed(0.07);
        			main.getNeko().removeForce(0.02);
        			main.getNeko().removeResi(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.07);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeResi(0.02);
        			main.getNeko().setSpeedProche(false);
        			main.getJoueurByRole(Roles.MAKA).setSpeedProche(false);
        		}
        		else if(main.getNbJoueursStaff() == 1) {
        			main.getNeko().removeSpeed(0.1);
        			main.getNeko().removeForce(0.02);
        			main.getNeko().removeResi(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeSpeed(0.1);
        			main.getJoueurByRole(Roles.MAKA).removeForce(0.02);
        			main.getJoueurByRole(Roles.MAKA).removeResi(0.02);
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
        	
        	if(main.getTemps() == 10 && main.getEpisode() == 1 && (main.getMode().equalsIgnoreCase("rapide") || main.getMode().equalsIgnoreCase("meetup"))) {
        		
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
    	    	
    	    	Trial.checkZoneBenihimeAratame(main);
    	    	Team.checkZoneJustice(main);
    	    	
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
    	
    	        if (player.getWalkSpeed() != 0.2 * (joueur.getSpeed()/100)) {
    	
    	        	player.setWalkSpeed((float) (0.2 * (joueur.getSpeed())/100));
    	
    	        }
    	
    	    }
        	
        }

        timer++;

    }

}
