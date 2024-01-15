package fr.gameblack.rcuhcv2.task.v1;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.Statut;
import fr.gameblack.rcuhcv2.classes.Camps;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Modes;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.Pouvoirs_GB;
import fr.gameblack.rcuhcv2.evenement.v1.TueurNeko;
import fr.gameblack.rcuhcv2.orbes.Orbe;
import fr.gameblack.rcuhcv2.orbes.v1.Foudre;
import fr.gameblack.rcuhcv2.orbes.v1.Glace;

public class GameCycleV1 extends BukkitRunnable {

    private Main main;

    private int timer = 0;
    
    //private boolean objectif_pourcent_creer = false;
    
    private static Scoreboard board_base;
    
    private static Scoreboard board_gameblack; 
    private static Scoreboard board_team;
    private static Scoreboard board_joko;
    private static Scoreboard board_toinou;
    private static Scoreboard board_maka;
    private static Scoreboard board_loup;
    private static Scoreboard board_raptor;
    private static Scoreboard board_guerrier;
    private static Scoreboard board_archer;
    
    private static Scoreboard board_trial;
    private static Scoreboard board_slup;
    private static Scoreboard board_malivol;
    private static Scoreboard board_obscur;
    private static Scoreboard board_ange;
    private static Scoreboard board_avenir;
    private static Scoreboard board_cosmos;
    private static Scoreboard board_demon;
    private static Scoreboard board_electrique;
    private static Scoreboard board_enfer;
    private static Scoreboard board_malediction;
    private static Scoreboard board_sang;
    private static Scoreboard board_tronconneuse;
    private static Scoreboard board_tenebre;
    
    private static Scoreboard board_experimental;
    private static Scoreboard board_farmeurimmo;
    private static Scoreboard board_kzou;
    
    private boolean score_board = true;

    @SuppressWarnings("static-access")
	public GameCycleV1(Main main, Scoreboard board_base, Scoreboard board_gameblack, Scoreboard board_team, Scoreboard board_joko, Scoreboard board_toinou, Scoreboard board_maka, Scoreboard board_loup, Scoreboard board_raptor, Scoreboard board_guerrier, Scoreboard board_archer, Scoreboard board_trial, Scoreboard board_slup, Scoreboard board_malivol, Scoreboard board_obscur, Scoreboard board_ange, Scoreboard board_avenir, Scoreboard board_cosmos, Scoreboard board_demon, Scoreboard board_electrique, Scoreboard board_enfer, Scoreboard board_malediction, Scoreboard board_sang, Scoreboard board_tronconneuse, Scoreboard board_tenebre, Scoreboard board_experimental, Scoreboard board_farmeurimmo, Scoreboard board_kzou) {
        this.main = main;
        this.board_base = board_base;
        
        this.board_gameblack = board_gameblack;
        this.board_team = board_team;
        this.board_joko = board_joko;
        this.board_toinou = board_toinou;
        this.board_maka = board_maka;
        this.board_loup = board_loup;
        this.board_raptor = board_raptor;
        this.board_guerrier = board_guerrier;
        this.board_archer = board_archer;
        
        this.board_trial = board_trial;
        this.board_slup = board_slup;
        this.board_malivol = board_malivol;
        this.board_obscur = board_obscur;
        this.board_ange = board_ange;
        this.board_avenir = board_avenir;
        this.board_cosmos = board_cosmos;
        this.board_demon = board_demon;
        this.board_electrique = board_electrique;
        this.board_enfer = board_enfer;
        this.board_malediction = board_malediction;
        this.board_sang = board_sang;
        this.board_tronconneuse = board_tronconneuse;
        this.board_tenebre = board_tenebre;
        
        this.board_experimental = board_experimental;
        this.board_farmeurimmo = board_farmeurimmo;
        this.board_kzou = board_kzou;
    }

    public static void Nuit(Main main) {
    	
    	if(main.getJoueurByRole(Roles.Demon) != null) {
    		
    		if(main.getEffetDemon().equalsIgnoreCase("speed")) {
    			
    			main.getJoueurByRole(Roles.Demon).getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
    			
    		}
    		else {
    			
    			main.getJoueurByRole(Roles.Demon).addForce(main.getForceIBaseV1());
    			
    		}
    		
    		main.getJoueurByRole(Roles.Demon).addForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Kzou) != null) {
    		
    		main.getJoueurByRole(Roles.Kzou).removeResi(main.getResiIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Farmeurimmo) != null) {
    		
    		if(main.getJoueurByRole(Roles.Farmeurimmo).getPlayer().hasPotionEffect(PotionEffectType.SPEED)) main.getJoueurByRole(Roles.Farmeurimmo).getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Trial) != null) {
    		
    		main.getJoueurByRole(Roles.Trial).addForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Malediction) != null) {
    		
    		main.getJoueurByRole(Roles.Malediction).addForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Sang) != null) {
    		
    		main.getJoueurByRole(Roles.Sang).addForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Tronconeuse) != null) {
    		
    		main.getJoueurByRole(Roles.Tronconeuse).addForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Tenebre) != null) {
    		
    		main.getJoueurByRole(Roles.Tenebre).addForce(main.getForceIBaseV1()*2);
    		main.getJoueurByRole(Roles.Tenebre).addResi(main.getResiIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Slup) != null) {
    		
    		main.getJoueurByRole(Roles.Slup).addForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Maka) != null) {
    		
    		if(main.getJoueurByRole(Roles.Maka).getPlayer().hasPotionEffect(PotionEffectType.SPEED)) {
    			
    			main.getJoueurByRole(Roles.Maka).getPlayer().removePotionEffect(PotionEffectType.SPEED);
    			
    		}
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Loup) != null) {
    		
    		main.getJoueurByRole(Roles.Loup).addForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Raptor) != null) {
    		
    		main.getJoueurByRole(Roles.Raptor).addResi(main.getResiIBaseV1());
    		
    	}

    }

    public static void Jour(Main main) {
    	
    	if(main.getJoueurByRole(Roles.Demon) != null) {
    		
    		if(main.getEffetDemon().equalsIgnoreCase("force")) {
    			
    			main.getJoueurByRole(Roles.Demon).getPlayer().removePotionEffect(PotionEffectType.SPEED);
    			
    		}
    		else {
    			
    			main.getJoueurByRole(Roles.Demon).removeForce(main.getForceIBaseV1());
    			
    		}
    		
    		main.getJoueurByRole(Roles.Demon).removeForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Kzou) != null) {
    		
    		main.getJoueurByRole(Roles.Kzou).addResi(main.getResiIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Farmeurimmo) != null) {
    		
    		if(main.getJoueurByRole(Roles.Farmeurimmo).isSpeedIIActif()) {
    			
    			main.getJoueurByRole(Roles.Farmeurimmo).getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 1, false, false));
    			
    		}
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Trial) != null) {
    		
    		main.getJoueurByRole(Roles.Trial).removeForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Malediction) != null) {
    		
    		main.getJoueurByRole(Roles.Malediction).removeForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Sang) != null) {
    		
    		main.getJoueurByRole(Roles.Sang).removeForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Tronconeuse) != null) {
    		
    		main.getJoueurByRole(Roles.Tronconeuse).removeForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Tenebre) != null) {
    		
    		main.getJoueurByRole(Roles.Tenebre).removeForce(main.getForceIBaseV1()*2);
    		main.getJoueurByRole(Roles.Tenebre).removeResi(main.getResiIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Slup) != null) {
    		
    		main.getJoueurByRole(Roles.Slup).removeForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Maka) != null) {
    		
    		main.getJoueurByRole(Roles.Maka).getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Loup) != null) {
    		
    		main.getJoueurByRole(Roles.Loup).removeForce(main.getForceIBaseV1());
    		
    	}
    	
    	if(main.getJoueurByRole(Roles.Raptor) != null) {
    		
    		main.getJoueurByRole(Roles.Raptor).removeResi(main.getResiIBaseV1());
    		
    	}

    }
    
    public static void resetCD(Main main) {
    	
	    for(Joueur j : main.getJoueurInGame()) {
	    	
	    	if(j.getCD().contains(Pouvoirs.MALIVOL_CHEAT)) {
	    		
	    		j.getCD().remove(Pouvoirs.MALIVOL_CHEAT);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.SANG_SANG)) {
	    		
	    		j.getCD().remove(Pouvoirs.SANG_SANG);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.TENEBRE_BLIND)) {
	    		
	    		j.getCD().remove(Pouvoirs.TENEBRE_BLIND);
	    		
	    	}
	    	else if(j.getCD().contains(Pouvoirs.RAPTOR_RAGE)) {
	    		
	    		j.getCD().remove(Pouvoirs.RAPTOR_RAGE);
	    		
	    	} else if(j.getCD().contains(Pouvoirs.JOKO_CUBE)) {
	    		
	    		j.getCD().remove(Pouvoirs.JOKO_CUBE);
	    		
	    	} else if(j.getCD().contains(Pouvoirs.KZOU_BAN)) {
	    		
	    		j.getCD().remove(Pouvoirs.KZOU_BAN);
	    		
	    	} else if(j.getCD().contains(Pouvoirs.KZOU_DISPERSE)) {
	    		
	    		j.getCD().remove(Pouvoirs.KZOU_DISPERSE);
	    		
	    	}
    	
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
		            
		            if((main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP) && (j.getCamp() == Camps.RC || j.getRole() == Roles.Slup || j.getRole() == Roles.Farmeurimmo || j.getRole() == Roles.Kzou)) {
		            
		            	j.addOrbe(main);
		            	
		            }
		            
	        	}
	        	else {
	        		
	        		Player pls = j.getPlayer();
	        		
	        		Roles role = compo.get(0);
	        		compo_.add(role);
	        		j.setRole(role, main);
	        		compo.remove(role);
	        		j.setInvulnerable(false);
	        		pls.setHealth(pls.getMaxHealth());
	        		
		            if((main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP) && (j.getCamp() == Camps.RC || j.getRole() == Roles.Slup || j.getRole() == Roles.Farmeurimmo || j.getRole() == Roles.Kzou)) {
			            
		            	j.addOrbe(main);
		            	
		            }
	        		
	        	}
	        	
        	}

        }
        
        main.setCompo(compo_);
        
        TueurNeko.setTueur(main);
    	
    }
    
    public static Scoreboard getScoreboardFarmeurimmo() {
    	return board_farmeurimmo;
    }
    
    public static Scoreboard getScoreboardJoko() {
    	return board_joko;
    }

    public static Objective ScoreboardBase(Main main, int timer, Roles role, Scoreboard board) {
    	
    	if(!board.getObjectives().isEmpty()) {
    		board.getObjective("test").unregister();
		}
    		
    	Objective objective = board.registerNewObjective("test", "dummy");
    	
    	Joueur j = main.getJoueurByRole(role);
        
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("RC UHC V1");
        Score score1 = objective.getScore("Durée: " + main.getTimerInTexte(timer));
        score1.setScore(10);
        Score scoreep = objective.getScore("Episode : " + main.getEpisode());
        scoreep.setScore(9);
        Score score2 = objective.getScore("Joueurs : " + main.getListJoueurs().size() );
        score2.setScore(8);
        Score scorekill = objective.getScore("Kill : " + j.getKill() );
        scorekill.setScore(7);
        Score score3 = objective.getScore("Role: " + j.getCamp().getCouleur() + j.getRole().getTxt());
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
        
        return objective;
    	
    }

    @SuppressWarnings("unused")
	public static void setScoreboard(Main main, int timer) {
    	
    	Objective objective_hp = board_base.getObjective("hp");
    	
    	if(!board_base.getObjectives().isEmpty()) {
			board_base.getObjective("test").unregister();
		}
        
        Objective objective_base = board_base.registerNewObjective("test", "dummy");
        objective_base.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective_base.setDisplayName("RC UHC V1");
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
        
        if((main.getEpisode() > 1 || (main.getEpisode() == 2 && main.getTemps() > 2)) || (main.getTemps() > 10 && main.getEpisode() >= 1 && (main.getMode() == Modes.RAPIDE || main.getMode() == Modes.MEETUP))) {
        	
        	if(main.getCompo().contains(Roles.GameBlack) && main.getJoueurByRole(Roles.GameBlack) != null) {
            		
            	Objective objective_gb = ScoreboardBase(main, timer, Roles.GameBlack, board_gameblack);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Team)  && main.getJoueurByRole(Roles.Team) != null) {
            	
        		Objective objective_team = ScoreboardBase(main, timer, Roles.Team, board_team);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Joko) && main.getJoueurByRole(Roles.Joko) != null) {
	                   	
        		Objective objective_joko = ScoreboardBase(main, timer, Roles.Joko, board_joko);
		    
        	}
        	
        	if(main.getCompo().contains(Roles.Toinou) && main.getJoueurByRole(Roles.Toinou) != null) {
	                    	
        		Objective objective_toinou = ScoreboardBase(main, timer, Roles.Toinou, board_toinou);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Maka) && main.getJoueurByRole(Roles.Maka) != null) {
	                    	
        		Objective objective_maka = ScoreboardBase(main, timer, Roles.Maka, board_maka);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Loup) && main.getJoueurByRole(Roles.Loup) != null) {
                   	
        		Objective objective_loup = ScoreboardBase(main, timer, Roles.Loup, board_loup);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Raptor) && main.getJoueurByRole(Roles.Raptor) != null) {
            	
        		Objective objective_raptor = ScoreboardBase(main, timer, Roles.Raptor, board_raptor);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Guerrier) && main.getJoueurByRole(Roles.Guerrier) != null) {
            	
        		Objective objective_guerrier = ScoreboardBase(main, timer, Roles.Guerrier, board_guerrier);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Archer) && main.getJoueurByRole(Roles.Archer) != null) {
            	
        		Objective objective_archer = ScoreboardBase(main, timer, Roles.Archer, board_archer);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Trial) && main.getJoueurByRole(Roles.Trial) != null) {
            	
        		Objective objective_trial = ScoreboardBase(main, timer, Roles.Trial, board_trial);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Slup) && main.getJoueurByRole(Roles.Slup) != null) {
            	
        		Objective objective_slup = ScoreboardBase(main, timer, Roles.Slup, board_slup);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Malivol) && main.getJoueurByRole(Roles.Malivol) != null) {
            	
        		Objective objective_malivol = ScoreboardBase(main, timer, Roles.Malivol, board_malivol);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Obscur) && main.getJoueurByRole(Roles.Obscur) != null) {
            	
        		Objective objective_obscur = ScoreboardBase(main, timer, Roles.Obscur, board_obscur);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Ange) && main.getJoueurByRole(Roles.Ange) != null) {
            	
        		Objective objective_ange = ScoreboardBase(main, timer, Roles.Ange, board_ange);
        		Score scorepoint_ange = objective_ange.getScore("Points : " + main.getJoueurByRole(Roles.Ange).getPoints());
		        scorepoint_ange.setScore(3);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Avenir) && main.getJoueurByRole(Roles.Avenir) != null) {
            	
        		Objective objective_avenir = ScoreboardBase(main, timer, Roles.Avenir, board_avenir);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Cosmos) && main.getJoueurByRole(Roles.Cosmos) != null) {
            	
        		Objective objective_cosmos = ScoreboardBase(main, timer, Roles.Cosmos, board_cosmos);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Demon) && main.getJoueurByRole(Roles.Demon) != null) {
            	
        		Objective objective_demon = ScoreboardBase(main, timer, Roles.Demon, board_demon);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Electrique) && main.getJoueurByRole(Roles.Electrique) != null) {
            	
        		Objective objective_electrique = ScoreboardBase(main, timer, Roles.Electrique, board_electrique);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Enfer) && main.getJoueurByRole(Roles.Enfer) != null) {
            	
        		Objective objective_enfer = ScoreboardBase(main, timer, Roles.Enfer, board_enfer);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Malediction) && main.getJoueurByRole(Roles.Malediction) != null) {
            	
        		Objective objective_malediction = ScoreboardBase(main, timer, Roles.Malediction, board_malediction);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Sang) && main.getJoueurByRole(Roles.Sang) != null) {
            	
        		Objective objective_sang = ScoreboardBase(main, timer, Roles.Sang, board_sang);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Tronconeuse) && main.getJoueurByRole(Roles.Tronconeuse) != null) {
            	
        		Objective objective_tronconneuse = ScoreboardBase(main, timer, Roles.Tronconeuse, board_tronconneuse);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Tenebre) && main.getJoueurByRole(Roles.Tenebre) != null) {
            	
        		Objective objective_tenebre = ScoreboardBase(main, timer, Roles.Tenebre, board_tenebre);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Experimental) && main.getJoueurByRole(Roles.Experimental) != null) {
            	
        		Objective objective_experimental = ScoreboardBase(main, timer, Roles.Experimental, board_experimental);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Farmeurimmo) && main.getJoueurByRole(Roles.Farmeurimmo) != null) {
            	
        		Objective objective_farmeurimmo = ScoreboardBase(main, timer, Roles.Farmeurimmo, board_farmeurimmo);
        		Score scorespeed_farmeurimmo;
		        if(main.getJoueurByRole(Roles.Farmeurimmo).isSpeedIIActif()) {
		        	
		        	scorespeed_farmeurimmo = objective_farmeurimmo.getScore("Speed II : §aActif");
		        	
		        }
		        else {
		        	
		        	scorespeed_farmeurimmo = objective_farmeurimmo.getScore("Speed II : §cInnactif");
		        	
		        }
		        scorespeed_farmeurimmo.setScore(3);
		        
		        Score scoreabso_farmeurimmo;
		        if(main.getJoueurByRole(Roles.Farmeurimmo).isJeannotAbso()) {
		        	
		        	scoreabso_farmeurimmo = objective_farmeurimmo.getScore("Abso : §aActif");
		        	
		        }
		        else {
		        	
		        	scoreabso_farmeurimmo = objective_farmeurimmo.getScore("Abso : §cInnactif");
		        	
		        }
		        scoreabso_farmeurimmo.setScore(2);
		        
        	}
        	
        	if(main.getCompo().contains(Roles.Kzou) && main.getJoueurByRole(Roles.Kzou) != null) {
            	
        		Objective objective_kzou = ScoreboardBase(main, timer, Roles.Kzou, board_kzou);
		        
        	}
	        
    	}
        
        for(Joueur joueur : main.getListJoueurs()) {
        	
        	Player player = joueur.getPlayer();
        	
        	//System.out.println("Joueur : " + player.getName());
        	//System.out.println("Role : " + joueur.getRole().toString());
        	
        	if(joueur.getRole() == Roles.NONE || joueur.isMort()) {
        		
	            player.setScoreboard(board_base);
	            
            }
        	else if(joueur.getRole() == Roles.GameBlack) {
                
	            player.setScoreboard(board_gameblack);
	            
            }
        	else if(joueur.getRole() == Roles.Team) {
                
	            player.setScoreboard(board_team);
	            
            }
        	else if(joueur.getRole() == Roles.Joko) {
                
	            player.setScoreboard(board_joko);
	            
            }
        	else if(joueur.getRole() == Roles.Toinou) {
                
	            player.setScoreboard(board_toinou);
	            
            }
        	else if(joueur.getRole() == Roles.Maka) {
                
	            player.setScoreboard(board_maka);
	            
            }
        	else if(joueur.getRole() == Roles.Loup) {
                
	            player.setScoreboard(board_loup);
	            
            }
        	else if(joueur.getRole() == Roles.Raptor) {
                
	            player.setScoreboard(board_raptor);
	            
            }
        	else if(joueur.getRole() == Roles.Guerrier) {
                
	            player.setScoreboard(board_guerrier);
	            
            }
        	else if(joueur.getRole() == Roles.Archer) {
                
	            player.setScoreboard(board_archer);
	            
            }
        	else if(joueur.getRole() == Roles.Trial) {
                
	            player.setScoreboard(board_trial);
	            
            }
        	else if(joueur.getRole() == Roles.Slup) {
                
	            player.setScoreboard(board_slup);
	            
            }
        	else if(joueur.getRole() == Roles.Malivol) {
                
	            player.setScoreboard(board_malivol);
	            
            }
        	else if(joueur.getRole() == Roles.Obscur) {
                
	            player.setScoreboard(board_obscur);
	            
            }
        	else if(joueur.getRole() == Roles.Ange) {
                
	            player.setScoreboard(board_ange);
	            
            }
        	else if(joueur.getRole() == Roles.Avenir) {
                
	            player.setScoreboard(board_avenir);
	            
            }
        	else if(joueur.getRole() == Roles.Cosmos) {
                
	            player.setScoreboard(board_cosmos);
	            
            }
        	else if(joueur.getRole() == Roles.Demon) {
                
	            player.setScoreboard(board_demon);
	            
            }
        	else if(joueur.getRole() == Roles.Electrique) {
                
	            player.setScoreboard(board_electrique);
	            
            }
        	else if(joueur.getRole() == Roles.Enfer) {
                
	            player.setScoreboard(board_enfer);
	            
            }
        	else if(joueur.getRole() == Roles.Malediction) {
                
	            player.setScoreboard(board_malediction);
	            
            }
        	else if(joueur.getRole() == Roles.Sang) {
                
	            player.setScoreboard(board_sang);
	            
            }
        	else if(joueur.getRole() == Roles.Tronconeuse) {
                
	            player.setScoreboard(board_tronconneuse);
	            
            }
        	else if(joueur.getRole() == Roles.Tenebre) {
                
	            player.setScoreboard(board_tenebre);
	            
            }
        	else if(joueur.getRole() == Roles.Experimental) {
                
	            player.setScoreboard(board_experimental);
	            
            }
        	else if(joueur.getRole() == Roles.Farmeurimmo) {
                
	            player.setScoreboard(board_farmeurimmo);
	            
            }
        	else if(joueur.getRole() == Roles.Kzou) {
                
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
		
		if(timer % 200 == 0 && !main.getMaudit().isEmpty() && main.getNiv_maledition() != 3) {
			
			if(main.getMode() == Modes.RAPIDE) {
				
				Joueur cible1 = main.getMaudit().get(0);
				Joueur malediction = main.getMaudit().get(1);
				
				if(!cible1.isProche(malediction.getRole(), main)) {
					
					if(cible1.getPlayer().getHealth() > 3) {
						
						cible1.getPlayer().setHealth(cible1.getPlayer().getHealth()-2);
						
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
			
			if(main.getMode() == Modes.RAPIDE) {
				
				Joueur cible1 = main.getMaudit().get(0);
				Joueur malediction = main.getMaudit().get(1);
				
				if(!cible1.isProche(malediction.getRole(), main)) {
					
					if(cible1.getPlayer().getHealth() > 4) {
						
						cible1.getPlayer().setHealth(cible1.getPlayer().getHealth()-3);
						
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
        
        if(timer % 10 == 0) {
        	
        	if(main.getJoueurByRole(Roles.Team) != null) {
        		
        		Joueur team = main.getJoueurByRole(Roles.Team);
        		
        		if(team.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY) && (team.getPlayer().getInventory().getHelmet() != null || team.getPlayer().getInventory().getChestplate() != null || team.getPlayer().getInventory().getLeggings() != null || team.getPlayer().getInventory().getBoots() != null)) {
        			
        			team.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
        			team.getPlayer().removePotionEffect(PotionEffectType.SPEED);
        			team.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
        			team.setNofall(false);
        			team.removeResi(0.10);
        			
        		}
        		else if(!team.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY) && team.getPlayer().getInventory().getHelmet() == null && team.getPlayer().getInventory().getChestplate() == null && team.getPlayer().getInventory().getLeggings() == null && team.getPlayer().getInventory().getBoots() == null){
        			
        			team.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 0, false, false));
        			team.getPlayer().removePotionEffect(PotionEffectType.SPEED);
        			team.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 1, false, false));
        			team.setNofall(true);
        			team.addResi(0.10);
        			
        		}
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.GameBlack) != null && main.getJoueurByRole(Roles.GameBlack).getPouvoirGB() == Pouvoirs_GB.FLAIR) {
        		
        		Joueur gb = main.getJoueurByRole(Roles.GameBlack);
        		
        		if(main.getFlairGB() != gb && main.getFlairGB() != null){
        			
        			if(main.getFlairGB().isProche(Roles.GameBlack, main) && !gb.isForceProche()) {
        				
        				gb.removeForce(0.05);
        				gb.removeResi(0.05);
        				gb.setForceProche(true);
        				
        			}
        			else if(!main.getFlairGB().isProche(Roles.GameBlack, main) && gb.isForceProche()) {
        				
        				gb.addForce(0.05);
        				gb.addResi(0.05);
        				gb.setForceProche(false);
        				
        			}
        			
        		}
        		else if(gb.isForceProche()) {
        			
        			gb.addForce(0.05);
        			gb.addResi(0.05);
        			gb.setForceProche(false);
        			
        		}
        		
        	}
        	
        	if(main.getJoueurByRole(Roles.Maka) != null && main.getJoueurByRole(Roles.Team) != null && main.getConnaissanceTeam() == Roles.Maka) {
        		
        		if(main.getJoueurByRole(Roles.Maka).isProche(Roles.Team, main) && !main.getJoueurByRole(Roles.Maka).isForceProche()) {
        			
        			main.getJoueurByRole(Roles.Maka).addForce(main.getForceIBaseV1());
        			main.getJoueurByRole(Roles.Maka).setForceProche(true);
        			
        		}
        		else if(!main.getJoueurByRole(Roles.Maka).isProche(Roles.Team, main) && main.getJoueurByRole(Roles.Maka).isForceProche()) {
        			
        			main.getJoueurByRole(Roles.Maka).removeForce(main.getForceIBaseV1());
        			main.getJoueurByRole(Roles.Maka).setForceProche(false);
        			
        		}
        		
        	}
        	
        	if(!main.getMaudit().isEmpty() && main.getNiv_maledition() > 1) {
        		
        		if(main.getMode() == Modes.RAPIDE) {
        			
            		Joueur cible1 = main.getMaudit().get(0);
        			Joueur malediction = main.getMaudit().get(1);
        			
        			if(!cible1.isProche(malediction.getRole(), main)) {
        				
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
        	
        	if (main.getTemps() == main.getTempsEpisode() / 2 && main.getEpisode() != 1) {
        		
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
        	
        	if(main.getTemps() == 10 && main.getEpisode() == 1 && main.getMode() == Modes.RAPIDE) {
        		
        		Bukkit.broadcastMessage("Attribution des rôles");
        		setRole(main);
        		
        	}
        	
        	if (main.getTemps() == main.getTempsEpisode()) {
            	
            	resetCD(main);

                int episode = main.getEpisode() + 1;

                Bukkit.broadcastMessage("_________________________\n \nEpisode " + episode + "\n_________________________");
                
                if(main.getJoueurByRole(Roles.GameBlack) != null) {
                	
                	int nb_demons = 0;
                	
                	Joueur gb = main.getJoueurByRole(Roles.GameBlack);
                	
                	for(Entity entity : main.getFlairGB().getPlayer().getNearbyEntities(20, 20, 20)) {
                		
                		if(entity instanceof Player) {
                			
                			Player player = (Player) entity;
                			Joueur joueur = main.getJoueur(player);
                			
                			if((joueur.getCamp() == Camps.DEMON && joueur.getRole() != Roles.Slup) || joueur.getRole() == Roles.Experimental) {
                				
                				nb_demons ++;
                				
                			}
                			
                		}
                		
                	}
                	
                    Random r = new Random();
                    int nb = r.nextInt(100);
                    
                    if((nb <= 10 && main.getFlairGB() == gb) || (nb <= 50 && main.getFlairGB() != gb && main.getFlairGB().isProche(Roles.GameBlack, main))) {
                    	
                    	nb_demons ++;
                    	
                    }
                    
                    if(nb_demons <= 1) {
                    	
                    	gb.getPlayer().sendMessage("Votre flair a détecté " + nb_demons + " démon");
                    	
                    }
                    else {
                    
                    	gb.getPlayer().sendMessage("Votre flair a détecté " + nb_demons + " démons");
                    
                    }
                	
                }

                if (main.getEpisode() == 1 && main.getMode() == Modes.NORMAL) {

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
