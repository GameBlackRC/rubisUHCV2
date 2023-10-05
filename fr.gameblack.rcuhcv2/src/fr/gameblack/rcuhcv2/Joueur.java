package fr.gameblack.rcuhcv2;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import fr.gameblack.rcuhcv2.roles.joueur.Jeannot;
import fr.gameblack.rcuhcv2.roles.joueur.Nickoboop;
import fr.gameblack.rcuhcv2.roles.joueur.Raptor;
import fr.gameblack.rcuhcv2.roles.joueur.Slup;
import fr.gameblack.rcuhcv2.roles.joueur.Joko;
import fr.gameblack.rcuhcv2.roles.staff.Team;
import fr.gameblack.rcuhcv2.roles.staff.GameBlack;
import fr.gameblack.rcuhcv2.roles.staff.Maka;
import fr.gameblack.rcuhcv2.roles.staff.Trial;
import fr.gameblack.rcuhcv2.roles.staff.Loup;
import fr.gameblack.rcuhcv2.roles.staff.Captain;
import fr.gameblack.rcuhcv2.roles.staff.Hekow;
import fr.gameblack.rcuhcv2.roles.uhc.Malivol;
import fr.gameblack.rcuhcv2.roles.uhc.Toinou;
import fr.gameblack.rcuhcv2.task.ItemCD;
import fr.gameblack.rcuhcv2.roles.uhc.Obscur;
import fr.gameblack.rcuhcv2.roles.uhc.Nonoboy;
import fr.gameblack.rcuhcv2.roles.solo.Farmeurimmo;
import fr.gameblack.rcuhcv2.roles.solo.Kzou;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	
	private static Scoreboard board_cube = Bukkit.getScoreboardManager().getNewScoreboard();
	private static Scoreboard board_hack = Bukkit.getScoreboardManager().getNewScoreboard();
	
	private Player player;
	private Roles role = Roles.NONE;
	private Orbe orbe = Orbe.NONE;
	private boolean orbe_actif = false;
	private boolean malus_orbe_actif = false;
	private int kill = 0;
	private boolean invulnerable = true;
	private Joueur lastHit = null;
	private boolean respawn = false;
	private double speed = 100;
	private double force = 100;
	private double resi = 110;
	private boolean abso = true;
	private boolean fire = false;
	private boolean can_active_orbe = true;
	private int malivol_cheat = 0;
	private boolean antiKB = false;
	private List<Pouvoirs> vol = new ArrayList<>();
	private boolean jeannotPartageActif = false;
	private boolean spec = false;
	private String camp = "rien";
	private int comboSubi = 0;
	private boolean nofall = false;
	private boolean cheatToinou = false;
	private boolean CanFight = true;
	private String modeTrial = null;
	private int pourcentHack = 0;
	private int pacteSlup = 0;
	private boolean bonPapiers = false;
	private boolean nickoProcheJeannot = false;
	private boolean cheatRaptorActif = false;
	private boolean cheatToinouActif = false;
	private boolean jokoItemActif = false;
	private int cube = 0;
	private boolean opKzou = false;
	private boolean mort = false;
	private boolean respawnTrial = false;
	private boolean choixGbCamp = false;
	private boolean checkMalusEau = true;
	private boolean consoleGBActif = false;

	public Joueur(Player player) {
		
		this.player = player;
		
	}

	public Player getPlayer() {
		return player;
	}
	
	public Roles getRole() {
		
		return role;
		
	}
	
	public void reset() {
		
		role = Roles.NONE;
		orbe = Orbe.NONE;
		orbe_actif = false;
		malus_orbe_actif = false;
		kill = 0;
		invulnerable = true;
		lastHit = null;
		respawn = false;
		speed = 100;
		force = 100;
		resi = 110;
		abso = true;
		fire = false;
		can_active_orbe = true;
		malivol_cheat = 0;
		antiKB = false;
		vol = new ArrayList<>();
		jeannotPartageActif = false;
		spec = false;
		camp = "rien";
		comboSubi = 0;
		nofall = false;
		cheatToinou = false;
		CanFight = true;
		modeTrial = null;
		pourcentHack = 0;
		pacteSlup = 0;
		bonPapiers = false;
		nickoProcheJeannot = false;
		cheatRaptorActif = false;
		cheatToinouActif = false;
		jokoItemActif = false;
		cube = 0;
		opKzou = false;
		mort = false;
		setRespawnTrial(false);
		
	}
	
	public String getCouleurCamp() {
		
		if(camp.equalsIgnoreCase("joueur")) {
			
			return "§a";
			
		}
		else if(camp.equalsIgnoreCase("uhc")) {
			
			return "§2";
			
		}
		else if(camp.equalsIgnoreCase("staff")) {
			
			return "§9";
			
		}
		else if(camp.equalsIgnoreCase("duo")) {
			
			return "§5";
			
		}
		else {
			
			return "§6";
			
		}
		
	}
	
	public boolean isProche(Roles role, Main main) {
		
		for(Joueur joueur : main.getListJoueurs()) {
			
			if(joueur.getRole() == role) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public void setRole(Roles role) {
		
		this.role = role;
		this.camp = role.getCamp();
		if(role == Roles.RAPTOR) {
			
			Raptor.Items(this);
			this.bonPapiers = true;
			
		}
		else if(role == Roles.JEANNOT) {
			
			Jeannot.Items(this);
			this.bonPapiers = true;
			
		}
		else if(role == Roles.NICKOBOOP) {
			
			Nickoboop.Items(this);
			this.bonPapiers = true;
			
		}
		else if(role == Roles.SLUP) {
			
			Slup.Items(this);
			this.bonPapiers = true;
			
		}
		else if(role == Roles.JOKO) {
			
			Joko.Items(this);
			this.bonPapiers = true;
			
		}
		else if(role == Roles.TEAM) {
			
			Team.Items(this);
			
		}
		else if(role == Roles.GAMEBLACK) {
			
			GameBlack.Items(this);
			
			this.bonPapiers = true;
			
		}
		else if(role == Roles.MAKA) {
			
			Maka.Items(this);
			
		}
		else if(role == Roles.TRIAL) {
			
			Trial.Items(this);
			
		}
		else if(role == Roles.LOUP) {
			
			Loup.Items(this);
			
		}
		else if(role == Roles.CAPTAIN) {
			
			Captain.Items(this);
			
		}
		else if(role == Roles.HEKOW) {
			
			Hekow.Items(this);
			
		}
		else if(role == Roles.MALIVOL) {
			
			Malivol.Items(this);
			
		}
		else if(role == Roles.TOINOU) {
			
			Toinou.Items(this);
			
		}
		else if(role == Roles.OBSCUR) {
			
			Obscur.Items(this);
			
		}
		else if(role == Roles.NONOBOY) {
			
			Nonoboy.Items(this);
			
		}
		else if(role == Roles.FARMEURIMMO) {
			
			Farmeurimmo.Items(this);
			
			this.bonPapiers = true;
			
		}
		else if(role == Roles.KZOU) {
			
			Kzou.Items(this);
			
		}
		
	}
	
	public Orbe getOrbe() {
		
		return orbe;
		
	}
	
	public void setOrbe(Orbe orbe) {
		
		this.orbe = orbe;
		
	}
	
	public boolean isOrbeActif() {
		
		return orbe_actif;
		
	}
	
	public void setStatutOrbe(boolean orbe_actif) {
		
		this.orbe_actif = orbe_actif;
		
	}
	
	public boolean isMalusOrbeActif() {
		
		return malus_orbe_actif;
		
	}
	
	public void setMalusOrbe(boolean malus_orbe_actif) {
		
		if(malus_orbe_actif) {
			
			this.can_active_orbe = false;
			
		}
		else {
			
			this.can_active_orbe = true;
			
		}
		
		this.malus_orbe_actif = malus_orbe_actif;
		
	}
	
	public int getKill() {
		
		return kill;
		
	}
	
	public void addKill() {
		
		kill += 1;
		
	}
	
	public void removeKill() {
		
		kill -= 1;
		
	}
	
	public void resetKill() {
		
		kill = 0;
		
	}
	
	public void setKill(int kill) {
		
		this.kill = kill;
		
	}
	
	public boolean isInvulnerable() {
		
		return invulnerable;
		
	}
	
	public void setInvulnerable(boolean invulnerable) {
		
		this.invulnerable = invulnerable;
		
	}
	
	public Joueur getLastHit() {
		
		return lastHit;
		
	}
	
	public void setLastHit(Joueur joueur) {
		
		lastHit = joueur;
		
	}
	
	public boolean canRespawn() {
		
		return respawn;
		
	}
	
	public void setRespawn(boolean respawn) {
		
		this.respawn =  respawn;
		
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed*100;
	}
	
	public void addSpeed(double speed) {
		this.speed += speed*100;
	}
	
	public void removeSpeed(double speed) {
		this.speed -= speed*100;
	}

	public double getForce() {
		return force;
	}

	public void setForce(double force) {
		this.force = force*100;
	}
	
	public void addForce(double force) {
		this.force += force*100;
	}
	
	public void removeForce(double force) {
		this.force -= force*100;
	}

	public double getResi() {
		return resi;
	}

	public void setResi(double resi) {
		this.resi = resi*100;
	}
	
	public void addResi(double resi) {
		this.resi += resi*100;
	}
	
	public void removeResi(double resi) {
		this.resi -= resi*100;
	}

	public boolean isAbsoOn() {
		return abso;
	}

	public void setAbso(boolean abso) {
		this.abso = abso;
	}

	public boolean isFireOn() {
		return fire;
	}

	public void setFire(boolean fire) {
		this.fire = fire;
	}

	public boolean canActiveOrbe() {
		return can_active_orbe;
	}

	public void setCanActiveOrbe(boolean can_active_orbe) {
		this.can_active_orbe = can_active_orbe;
	}

	public int getMalivolCheat() {
		return malivol_cheat;
	}

	public void setMalivolCheat(int malivol_cheat) {
		this.malivol_cheat = malivol_cheat;
	}

	public boolean isAntiKB() {
		return antiKB;
	}

	public void setAntiKB(boolean antiKB) {
		this.antiKB = antiKB;
	}

	public List<Pouvoirs> getVol() {
		return vol;
	}

	public boolean isJeannotPartageActif() {
		return jeannotPartageActif;
	}

	public void setJeannotPartageActif(boolean jeannotPartageActif) {
		this.jeannotPartageActif = jeannotPartageActif;
	}

	public boolean isSpec() {
		return spec;
	}

	public void setSpec(boolean spec) {
		this.spec = spec;
	}

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}

	public int getComboSubi() {
		return comboSubi;
	}

	public void setComboSubi(int comboSubi) {
		this.comboSubi = comboSubi;
	}

	public boolean isNofall() {
		return nofall;
	}

	public void setNofall(boolean nofall) {
		this.nofall = nofall;
	}

	public boolean isCheatToinou() {
		return cheatToinou;
	}

	public void setCheatToinou(boolean cheatToinou) {
		this.cheatToinou = cheatToinou;
	}

	public boolean canFight() {
		return CanFight;
	}

	public void setCanFight(boolean canFight) {
		CanFight = canFight;
	}

	public String getModeTrial() {
		return modeTrial;
	}

	public void setModeTrial(String modeTrial) {
		this.modeTrial = modeTrial;
	}
	
	public boolean isFarmeurimmoProche(Main main) {
		
		for(Entity entity : player.getNearbyEntities(25, 25, 25)) {
			
			if(entity instanceof Player && main.getJoueur((Player)entity).getRole() == Roles.FARMEURIMMO) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}

	public int getPourcentHack() {
		return pourcentHack;
	}

	public void setPourcentHack(int pourcentHack, Main main) {
		if(main.getJoueurByRole(Roles.FARMEURIMMO) != null) {
			this.pourcentHack = pourcentHack;
			Objective objective_hack = board_hack.registerNewObjective("hack", "dummy");
	        objective_hack.setDisplaySlot(DisplaySlot.BELOW_NAME);
	        objective_hack.setDisplayName("%");
	        @SuppressWarnings("deprecation")
			Score score = objective_hack.getScore(player);
	        score.setScore(cube);
	        main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer().setScoreboard(board_cube);
	        
		}
	}
	
	public void addPourcentHack(int nb, Main main) {
		
		if(main.getJoueurByRole(Roles.FARMEURIMMO) != null) {
		
			if(role != Roles.FARMEURIMMO) {
			
				if(role != Roles.MAKA) {
				
					if(pourcentHack + nb >= 100) {
						
						if(pourcentHack != 100) {
						
							pourcentHack = 100;
						
						}
						
					}
					else {
						
						pourcentHack += nb;
						
					}
					
				}
				else {
					
					if(pourcentHack + nb >= 40) {
						
						if(pourcentHack != 40) {
						
							pourcentHack = 40;
						
						}
						
					}
					else {
						
						pourcentHack += nb;
						
					}
					
				}
				
				Objective objective_hack = board_hack.registerNewObjective("hack", "dummy");
		        objective_hack.setDisplaySlot(DisplaySlot.BELOW_NAME);
		        objective_hack.setDisplayName("%");
		        @SuppressWarnings("deprecation")
				Score score = objective_hack.getScore(player);
		        score.setScore(cube);
		        main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer().setScoreboard(board_cube);
				
			}
			
		}
		
	}
	
	public void removePourcentHack(int nb, Main main) {
		
		if(main.getJoueurByRole(Roles.FARMEURIMMO) != null) {
		
			if(role != Roles.FARMEURIMMO) {
				
				if(pourcentHack - nb <= 100) {
						
					if(pourcentHack != 0) {
						
						pourcentHack = 0;
						
					}
						
				}
				else {
						
					pourcentHack -= nb;
						
				}
				
				Objective objective_hack = board_hack.registerNewObjective("hack", "dummy");
		        objective_hack.setDisplaySlot(DisplaySlot.BELOW_NAME);
		        objective_hack.setDisplayName("%");
		        @SuppressWarnings("deprecation")
				Score score = objective_hack.getScore(player);
		        score.setScore(cube);
		        main.getJoueurByRole(Roles.FARMEURIMMO).getPlayer().setScoreboard(board_cube);
				
			}
			
		}
		
	}

	public int getPacteSlup() {
		return pacteSlup;
	}

	public void setPacteSlup(int pacteSlup) {
		this.pacteSlup = pacteSlup;
	}

	public boolean isBonPapiers() {
		return bonPapiers;
	}

	public void setBonPapiers(boolean bonPapiers) {
		this.bonPapiers = bonPapiers;
	}

	public boolean isNickoProcheJeannot() {
		return nickoProcheJeannot;
	}

	public void setNickoProcheJeannot(boolean nickoProcheJeannot) {
		this.nickoProcheJeannot = nickoProcheJeannot;
	}

	public boolean isCheatRaptorActif() {
		return cheatRaptorActif;
	}

	public void setCheatRaptorActif(boolean cheatRaptorActif) {
		this.cheatRaptorActif = cheatRaptorActif;
	}

	public boolean isCheatToinouActif() {
		return cheatToinouActif;
	}

	public void setCheatToinouActif(boolean cheatToinouActif) {
		this.cheatToinouActif = cheatToinouActif;
	}

	public boolean isJokoItemActif() {
		return jokoItemActif;
	}

	public void setJokoItemActif(boolean jokoItemActif) {
		this.jokoItemActif = jokoItemActif;
	}

	public int getCube() {
		return cube;
	}

	public void setCube(int cube, Main main) {
		this.cube = cube;
		Objective objective_cube = board_cube.registerNewObjective("cube", "dummy");
        objective_cube.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        objective_cube.setDisplayName("cube");
        @SuppressWarnings("deprecation")
		Score score = objective_cube.getScore(player);
        score.setScore(cube);
        main.getJoueurByRole(Roles.JOKO).getPlayer().setScoreboard(board_cube);
	}
	
	public void addCube(Main main) {
		
		this.cube += 1;
		Objective objective_cube = board_cube.registerNewObjective("cube", "dummy");
        objective_cube.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        objective_cube.setDisplayName("cube");
        @SuppressWarnings("deprecation")
		Score score = objective_cube.getScore(player);
        score.setScore(cube);
        main.getJoueurByRole(Roles.JOKO).getPlayer().setScoreboard(board_cube);
		
	}
	
	public void addCubes(int cube, Main main) {
		
		this.cube += cube;
		Objective objective_cube = board_cube.registerNewObjective("cube", "dummy");
        objective_cube.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        objective_cube.setDisplayName("cube");
        @SuppressWarnings("deprecation")
		Score score = objective_cube.getScore(player);
        score.setScore(cube);
        main.getJoueurByRole(Roles.JOKO).getPlayer().setScoreboard(board_cube);
		
	}
	
	public void removeCube(Main main) {
		
		this.cube -= 1;
		Objective objective_cube = board_cube.registerNewObjective("cube", "dummy");
        objective_cube.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        objective_cube.setDisplayName("cube");
        @SuppressWarnings("deprecation")
		Score score = objective_cube.getScore(player);
        score.setScore(cube);
        main.getJoueurByRole(Roles.JOKO).getPlayer().setScoreboard(board_cube);
		
	}
	
	public void removeCubes(int cube, Main main) {
		
		this.cube -= cube;
		Objective objective_cube = board_cube.registerNewObjective("cube", "dummy");
        objective_cube.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        objective_cube.setDisplayName("cube");
        @SuppressWarnings("deprecation")
		Score score = objective_cube.getScore(player);
        score.setScore(cube);
        main.getJoueurByRole(Roles.JOKO).getPlayer().setScoreboard(board_cube);
		
	}
	
    public void Stun(int timer, Main main) {

        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, timer*20, 100, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, timer*20, 100, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, timer*20, 250, false, false));
        invulnerable = true;
        ItemCD cycle = new ItemCD(main, this, "stun", timer, this, null, null, null, null);
        cycle.runTaskTimer(main, 0, 20);

    }

	public boolean isOpKzou() {
		return opKzou;
	}

	public void setOpKzou(boolean opKzou) {
		this.opKzou = opKzou;
	}

	public boolean isMort() {
		return mort;
	}

	public void setMort(boolean mort) {
		this.mort = mort;
	}

	public boolean isRespawnTrial() {
		return respawnTrial;
	}

	public void setRespawnTrial(boolean respawnTrial) {
		this.respawnTrial = respawnTrial;
	}

	public boolean isChoixGbCamp() {
		return choixGbCamp;
	}

	public void setChoixGbCamp(boolean choixGbCamp) {
		this.choixGbCamp = choixGbCamp;
	}

	public boolean isCheckMalusEau() {
		return checkMalusEau;
	}

	public void setCheckMalusEau(boolean checkMalusEau) {
		this.checkMalusEau = checkMalusEau;
	}

	public boolean isConsoleGBActif() {
		return consoleGBActif;
	}

	public void setConsoleGBActif(boolean consoleGBActif) {
		this.consoleGBActif = consoleGBActif;
	}
	
}
