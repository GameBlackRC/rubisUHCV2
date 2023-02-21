package fr.gameblack.rubisuhc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rubisuhc.commands.admin.CommandEpisode;
import fr.gameblack.rubisuhc.commands.admin.CommandGiveOrbe;
import fr.gameblack.rubisuhc.commands.admin.CommandGiveRole;
import fr.gameblack.rubisuhc.commands.admin.CommandReset;
import fr.gameblack.rubisuhc.commands.demon.ange.CommandPoints;
import fr.gameblack.rubisuhc.commands.demon.electrique.CommandSacrifice;
import fr.gameblack.rubisuhc.commands.demon.sang.CommandSang;
import fr.gameblack.rubisuhc.commands.demon.tenebre.CommandNuit;
import fr.gameblack.rubisuhc.commands.demon.trial.CommandMsg;
import fr.gameblack.rubisuhc.commands.game.CommandCompo;
import fr.gameblack.rubisuhc.commands.game.CommandEffet;
import fr.gameblack.rubisuhc.commands.game.CommandOrbe;
import fr.gameblack.rubisuhc.commands.host.CommandAddrole;
import fr.gameblack.rubisuhc.commands.host.CommandCreate;
import fr.gameblack.rubisuhc.commands.host.CommandRemoverole;
import fr.gameblack.rubisuhc.commands.host.CommandStart;
import fr.gameblack.rubisuhc.commands.rc.gameblack.CommandInspect;
import fr.gameblack.rubisuhc.commands.rc.gameblack.CommandNerf;
import fr.gameblack.rubisuhc.commands.rc.gameblack.CommandRecrut;
import fr.gameblack.rubisuhc.commands.rc.joko.CommandCube;
import fr.gameblack.rubisuhc.commands.rc.joko.CommandSteal;
import fr.gameblack.rubisuhc.commands.rc.maka.CommandDon;
import fr.gameblack.rubisuhc.commands.rc.toinou.CommandBonus;
import fr.gameblack.rubisuhc.commands.solo.farmeurimmo.CommandAbso;
import fr.gameblack.rubisuhc.commands.solo.farmeurimmo.CommandSpeed;
import fr.gameblack.rubisuhc.commands.solo.kzou.CommandBan;
import fr.gameblack.rubisuhc.commands.solo.kzou.CommandDisperse;
import fr.gameblack.rubisuhc.commands.solo.kzou.CommandOP;
import fr.gameblack.rubisuhc.listeners.GDamageListeners;
import fr.gameblack.rubisuhc.listeners.GPlayerListeners;
import fr.gameblack.rubisuhc.listeners.InteractListeners;
import fr.gameblack.rubisuhc.listeners.InventoryInteractListeners;
import fr.gameblack.rubisuhc.roles.demons.Ange;
import fr.gameblack.rubisuhc.roles.demons.Avenir;
import fr.gameblack.rubisuhc.roles.demons.Cosmos;
import fr.gameblack.rubisuhc.roles.demons.Demon;
import fr.gameblack.rubisuhc.roles.demons.Electrique;
import fr.gameblack.rubisuhc.roles.demons.Enfer;
import fr.gameblack.rubisuhc.roles.demons.Malediction;
import fr.gameblack.rubisuhc.roles.demons.Malivol;
import fr.gameblack.rubisuhc.roles.demons.Obscur;
import fr.gameblack.rubisuhc.roles.demons.Sang;
import fr.gameblack.rubisuhc.roles.demons.Slup;
import fr.gameblack.rubisuhc.roles.demons.Tenebre;
import fr.gameblack.rubisuhc.roles.demons.Trial;
import fr.gameblack.rubisuhc.roles.demons.Tronconeuse;
import fr.gameblack.rubisuhc.roles.rc.Archer;
import fr.gameblack.rubisuhc.roles.rc.Eclaireur;
import fr.gameblack.rubisuhc.roles.rc.GameBlack;
import fr.gameblack.rubisuhc.roles.rc.Guerrier;
import fr.gameblack.rubisuhc.roles.rc.Joko;
import fr.gameblack.rubisuhc.roles.rc.Loup;
import fr.gameblack.rubisuhc.roles.rc.Maka;
import fr.gameblack.rubisuhc.roles.rc.Raptor;
import fr.gameblack.rubisuhc.roles.rc.Team;
import fr.gameblack.rubisuhc.roles.rc.Toinou;
import fr.gameblack.rubisuhc.roles.solos.Experimental;
import fr.gameblack.rubisuhc.roles.solos.Farmeurimmo;
import fr.gameblack.rubisuhc.roles.solos.Kzou;

public class Main extends JavaPlugin{
	
	//GESTION DE LA PARTIE
	private Player host = null;
	private State state;
	private List<Player> invulnerable = new ArrayList<>();
	private List<Player> players = new ArrayList<>();
	private List<Roles> roles = new ArrayList<>();
	private List<Player> lastHit = new ArrayList<>();
			
	private List<Double> force = new ArrayList<>();
	private List<Double> speed = new ArrayList<>();
	private List<Double> resi = new ArrayList<>();
	
	private int temps = 0;
	private int episode = 1;
	private int temps_episode = 600;
	private boolean jour = false;
	
	private List<Pouvoirs> cd = new ArrayList<>();
	
	//CAMPS RC
	private List<Roles> camps_rc = new ArrayList<>();
	private List<Roles> camps_rc_vie = new ArrayList<>();
	
	  //JOKO
		private List<Integer> cube = new ArrayList<>();
		private boolean joko_item = false;
		private List<Player> joko_stun = new ArrayList<>();
	
	  //GAMEBLACK
		private int pacte_gb = 0;
	
	  //TOINOU
		private List<Roles> kill_toinou = new ArrayList<>();
		private boolean respawn_toinou = false;
		
	  //LOUP
		private boolean loup_pouvoir = false;
		
	  //MAKA
		private boolean maka_fire = false;
		private boolean maka_force = false;
		private Player tueur_neko;
		private boolean find_tueur_neko = false;
	
	  //TEAM
		private Roles connaissance_team = Roles.NONE;
	
	//CAMPS DEMON
	private List<Roles> camps_demon = new ArrayList<>();
	private List<Roles> camps_demon_vie = new ArrayList<>();
	
	  //TRIAL
		private boolean trial_kill_raptor = false;
		private boolean trial_kzou = false;
		private List<String> vol_trial = new ArrayList<>();
		private Roles role_kill_trial;
		private Orbe orbe_kill_trial;
	
	  //SLUP
		private List<Integer> proche_slup = new ArrayList<>();
	
	  //OBSCUR
		private List<Integer> copie_obscur = new ArrayList<>();
		private Orbe orbe_copier = Orbe.NONE;
		private List<Orbe> inv_orbe = new ArrayList<>();
		private List<Orbe> inv_orbe_actif = new ArrayList<>();
		
	  //MALIVOL
		private int malivol_cheat = 0;
	
	  //ANGE
		private int point_ange = 0;
	
	  //AVENIR
		private boolean infect = false;
		
	  //ELECTRIQUE
		private boolean nofall_elec = false;
	
	  //TENEBRE
		private boolean nuit_tenebre = false;
	
	  //MALEDICTION
		@SuppressWarnings("unused")
		private List<Player> maudit = new ArrayList<>();
		@SuppressWarnings("unused")
		private int timer_maudit = 0;
	
	  //TRONCONEUSE
		private Player saigne = null;
		private int nb_saigne = 0;
		private Orbe orbe_kill = Orbe.NONE;
	
	  //DEMON
		private String effet_demon = null;
	
	//SOLOS
	private List<Roles> solo_vie = new ArrayList<>();
	
	  //KZOU
		private boolean op = false;
		private int nb_op = 0;
		
	  //FARMEURIMMO
		private boolean speed_farmeur = false;
		private boolean abso_farmeur = false;
	
	//ORBES
	private List<Orbe> orbes = new ArrayList<>();
	private List<Boolean> orbes_actif = new ArrayList<>();
	private List<Boolean> orbe_malus = new ArrayList<>();
	
	//?
	private List<Roles> roles_select = new ArrayList<>();
	private List<Roles> compo = new ArrayList<>();
	
	@Override
	public void onEnable() {
		camps_rc.add(Roles.ARCHER);
		camps_rc.add(Roles.ECLAIREUR);
		camps_rc.add(Roles.GAMEBLACK);
		camps_rc.add(Roles.GUERRIER);
		camps_rc.add(Roles.JOKO);
		camps_rc.add(Roles.LOUP);
		camps_rc.add(Roles.MAKA);
		camps_rc.add(Roles.RAPTOR);
		camps_rc.add(Roles.TEAM);
		camps_rc.add(Roles.TOINOU);
		camps_demon.add(Roles.ANGE);
		camps_demon.add(Roles.AVENIR);
		camps_demon.add(Roles.COSMOS);
		camps_demon.add(Roles.DEMON);
		camps_demon.add(Roles.ELECTRIQUE);
		camps_demon.add(Roles.ENFER);
		camps_demon.add(Roles.MALEDICTION);
		camps_demon.add(Roles.MALIVOL);
		camps_demon.add(Roles.SANG);
		camps_demon.add(Roles.SLUP);
		camps_demon.add(Roles.TENEBRE);
		camps_demon.add(Roles.TRIAL);
		camps_demon.add(Roles.TRONCONEUSE);
		camps_demon.add(Roles.OBSCUR);
		inv_orbe.add(Orbe.NONE);
		inv_orbe.add(Orbe.NONE);
		inv_orbe.add(Orbe.NONE);
		inv_orbe.add(Orbe.NONE);
		inv_orbe.add(Orbe.NONE);
		//saveDefaultConfig();
		System.out.println("Le plugin viens de s'allumer");
		setState(State.WAITING);
		
		//CAMPS RC
		  //GAMEBLACK
			getCommand("rcnerf").setExecutor(new CommandNerf(this));
			getCommand("rcrecrut").setExecutor(new CommandRecrut(this));
			getCommand("rcinspect").setExecutor(new CommandInspect(this));
		
		  //TOINOU
			getCommand("rcbonus").setExecutor(new CommandBonus(this));
		
		  //JOKO
			getCommand("rccube").setExecutor(new CommandCube(this));
			getCommand("rcsteal").setExecutor(new CommandSteal(this));
			
		  //MAKA
			getCommand("rcdon").setExecutor(new CommandDon(this));
		
		//CAMPS DEMON
		  //TRIAL + SLUP
			getCommand("rcmsg").setExecutor(new CommandMsg(this));
		
		  //ELECTRIQUE + EXPERIMENTAL
			getCommand("rcsacrifice").setExecutor(new CommandSacrifice(this));
		
		  //SANG
			getCommand("rcsang").setExecutor(new CommandSang(this));
		
		  //TENEBRE
			getCommand("rcnuit").setExecutor(new CommandNuit(this));
			getCommand("rcblind").setExecutor(new CommandPoints(this));
		
		  //ANGE
			getCommand("rcpoints").setExecutor(new CommandPoints(this));
		
		//SOLOS
		  //KZOU
			getCommand("rcban").setExecutor(new CommandBan(this));
			getCommand("rcdisperse").setExecutor(new CommandDisperse(this));
			getCommand("rcop").setExecutor(new CommandOP(this));
			
		  //FARMEURIMMO
			getCommand("rcspeed").setExecutor(new CommandSpeed(this));
			getCommand("rcabso").setExecutor(new CommandAbso(this));
		
		//ORBES
		getCommand("giveorbe").setExecutor(new CommandGiveOrbe(this));
		getCommand("rcorbe").setExecutor(new CommandOrbe(this));
		
		//AUTRES
		getCommand("giverole").setExecutor(new CommandGiveRole(this));
		getCommand("start").setExecutor(new CommandStart(this));
		getCommand("addrole").setExecutor(new CommandAddrole(this));
		getCommand("removerole").setExecutor(new CommandRemoverole(this));
		getCommand("compo").setExecutor(new CommandCompo(this));
		getCommand("resetinv").setExecutor(new CommandReset(this));
		getCommand("rceffet").setExecutor(new CommandEffet(this));
		getCommand("skipepisode").setExecutor(new CommandEpisode(this));
		getCommand("create").setExecutor(new CommandCreate(this));
		
		getServer().getPluginManager().registerEvents(new GPlayerListeners(this), this);
		getServer().getPluginManager().registerEvents(new GDamageListeners(this), this);
		getServer().getPluginManager().registerEvents(new InteractListeners(this), this);
		getServer().getPluginManager().registerEvents(new InventoryInteractListeners(this), this);

	}
	
	public void onDisable() {
		
		
	}
	
	public void setCompo(int nb) {
		
		if(nb == 23) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ARCHER);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.GUERRIER);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.TOINOU);
			roles_select.add(Roles.MAKA);
			roles_select.add(Roles.LOUP);
			roles_select.add(Roles.RAPTOR);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ANGE);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.ENFER);
			roles_select.add(Roles.SANG);
			roles_select.add(Roles.TRONCONEUSE);
			roles_select.add(Roles.TENEBRE);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			roles_select.add(Roles.EXPERIMENTAL);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ARCHER);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.GUERRIER);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.TOINOU);
			compo.add(Roles.MAKA);
			compo.add(Roles.LOUP);
			compo.add(Roles.RAPTOR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ANGE);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.ENFER);
			compo.add(Roles.SANG);
			compo.add(Roles.TRONCONEUSE);
			compo.add(Roles.TENEBRE);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			compo.add(Roles.EXPERIMENTAL);
			
		}
		else if(nb == 22) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ARCHER);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.GUERRIER);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.TOINOU);
			roles_select.add(Roles.MAKA);
			roles_select.add(Roles.LOUP);
			roles_select.add(Roles.RAPTOR);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ANGE);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.ENFER);
			roles_select.add(Roles.SANG);
			roles_select.add(Roles.TRONCONEUSE);
			roles_select.add(Roles.TENEBRE);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ARCHER);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.GUERRIER);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.TOINOU);
			compo.add(Roles.MAKA);
			compo.add(Roles.LOUP);
			compo.add(Roles.RAPTOR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ANGE);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.ENFER);
			compo.add(Roles.SANG);
			compo.add(Roles.TRONCONEUSE);
			compo.add(Roles.TENEBRE);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			
		}
		else if(nb == 21) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ARCHER);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.GUERRIER);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.TOINOU);
			roles_select.add(Roles.MAKA);
			roles_select.add(Roles.LOUP);
			roles_select.add(Roles.RAPTOR);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.ENFER);
			roles_select.add(Roles.TRONCONEUSE);
			roles_select.add(Roles.TENEBRE);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			roles_select.add(Roles.EXPERIMENTAL);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ARCHER);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.GUERRIER);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.TOINOU);
			compo.add(Roles.MAKA);
			compo.add(Roles.LOUP);
			compo.add(Roles.RAPTOR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.ENFER);
			compo.add(Roles.TRONCONEUSE);
			compo.add(Roles.TENEBRE);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			compo.add(Roles.EXPERIMENTAL);
			
		}
		else if(nb == 20) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ARCHER);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.GUERRIER);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.TOINOU);
			roles_select.add(Roles.MAKA);
			roles_select.add(Roles.LOUP);
			roles_select.add(Roles.RAPTOR);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.ENFER);
			roles_select.add(Roles.TRONCONEUSE);
			roles_select.add(Roles.TENEBRE);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ARCHER);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.GUERRIER);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.TOINOU);
			compo.add(Roles.MAKA);
			compo.add(Roles.LOUP);
			compo.add(Roles.RAPTOR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.ENFER);
			compo.add(Roles.TRONCONEUSE);
			compo.add(Roles.TENEBRE);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			
		}
		
		else if(nb == 19) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.GUERRIER);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.TOINOU);
			roles_select.add(Roles.MAKA);
			roles_select.add(Roles.LOUP);
			roles_select.add(Roles.RAPTOR);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.ENFER);
			roles_select.add(Roles.TENEBRE);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			roles_select.add(Roles.EXPERIMENTAL);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.GUERRIER);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.TOINOU);
			compo.add(Roles.MAKA);
			compo.add(Roles.LOUP);
			compo.add(Roles.RAPTOR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.ENFER);
			compo.add(Roles.TENEBRE);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			compo.add(Roles.EXPERIMENTAL);
			
		}
		
		else if(nb == 18) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.GUERRIER);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.TOINOU);
			roles_select.add(Roles.MAKA);
			roles_select.add(Roles.LOUP);
			roles_select.add(Roles.RAPTOR);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.ENFER);
			roles_select.add(Roles.TENEBRE);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.GUERRIER);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.TOINOU);
			compo.add(Roles.MAKA);
			compo.add(Roles.LOUP);
			compo.add(Roles.RAPTOR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.ENFER);
			compo.add(Roles.TENEBRE);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			
		}
		
		else if(nb == 17) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.TOINOU);
			roles_select.add(Roles.MAKA);
			roles_select.add(Roles.LOUP);
			roles_select.add(Roles.RAPTOR);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.ENFER);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			roles_select.add(Roles.EXPERIMENTAL);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.TOINOU);
			compo.add(Roles.MAKA);
			compo.add(Roles.LOUP);
			compo.add(Roles.RAPTOR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.ENFER);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			compo.add(Roles.EXPERIMENTAL);
			
		}
		
		else if(nb == 16) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.TOINOU);
			roles_select.add(Roles.MAKA);
			roles_select.add(Roles.LOUP);
			roles_select.add(Roles.RAPTOR);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.ENFER);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.TOINOU);
			compo.add(Roles.MAKA);
			compo.add(Roles.LOUP);
			compo.add(Roles.RAPTOR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.ENFER);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			compo.add(Roles.EXPERIMENTAL);
			
		}
		else if(nb == 15) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.TOINOU);
			roles_select.add(Roles.MAKA);
			roles_select.add(Roles.RAPTOR);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			roles_select.add(Roles.EXPERIMENTAL);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.TOINOU);
			compo.add(Roles.MAKA);
			compo.add(Roles.RAPTOR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			compo.add(Roles.EXPERIMENTAL);
			
		}
		else if(nb == 14) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.TOINOU);
			roles_select.add(Roles.MAKA);
			roles_select.add(Roles.RAPTOR);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.TOINOU);
			compo.add(Roles.MAKA);
			compo.add(Roles.RAPTOR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			
		}
		else if(nb == 13) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.MAKA);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			roles_select.add(Roles.EXPERIMENTAL);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.MAKA);
			compo.add(Roles.ECLAIREUR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			compo.add(Roles.EXPERIMENTAL);
			
		}
		else if(nb == 12) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.MAKA);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.OBSCUR);
			
			roles_select.add(Roles.FARMEURIMMO);
			roles_select.add(Roles.KZOU);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.MAKA);
			compo.add(Roles.ECLAIREUR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.OBSCUR);
			
			compo.add(Roles.FARMEURIMMO);
			compo.add(Roles.KZOU);
			
		}
		else if(nb == 11) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.MAKA);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.ELECTRIQUE);
			roles_select.add(Roles.OBSCUR);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.MAKA);
			compo.add(Roles.ECLAIREUR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.ELECTRIQUE);
			compo.add(Roles.OBSCUR);
			
			Random r = new Random();
			int nb_ = r.nextInt(3);
			
			if(nb_ == 1) {
				roles_select.add(Roles.FARMEURIMMO);
				compo.add(Roles.FARMEURIMMO);
			}
			else if(nb_ == 2) {
				roles_select.add(Roles.KZOU);
				compo.add(Roles.KZOU);
			}
			else {
				roles_select.add(Roles.EXPERIMENTAL);
				compo.add(Roles.EXPERIMENTAL);
			}
			
		}
		else if(nb == 10) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.TEAM);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.MAKA);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.OBSCUR);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.TEAM);
			compo.add(Roles.JOKO);
			compo.add(Roles.MAKA);
			compo.add(Roles.ECLAIREUR);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.OBSCUR);
			
			Random r = new Random();
			int nb_ = r.nextInt(3);
			
			if(nb_ == 1) {
				roles_select.add(Roles.FARMEURIMMO);
				compo.add(Roles.FARMEURIMMO);
			}
			else if(nb_ == 2) {
				roles_select.add(Roles.KZOU);
				compo.add(Roles.KZOU);
			}
			else {
				roles_select.add(Roles.EXPERIMENTAL);
				compo.add(Roles.EXPERIMENTAL);
			}
			
		}
		else if(nb == 9) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.MAKA);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			roles_select.add(Roles.OBSCUR);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.JOKO);
			compo.add(Roles.MAKA);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			compo.add(Roles.OBSCUR);
			
			Random r = new Random();
			int nb_ = r.nextInt(3);
			
			if(nb_ == 1) {
				roles_select.add(Roles.FARMEURIMMO);
				compo.add(Roles.FARMEURIMMO);
			}
			else if(nb_ == 2) {
				roles_select.add(Roles.KZOU);
				compo.add(Roles.KZOU);
			}
			else {
				roles_select.add(Roles.EXPERIMENTAL);
				compo.add(Roles.EXPERIMENTAL);
			}
			
		}
		else if(nb == 8) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.ECLAIREUR);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.MAKA);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.ECLAIREUR);
			compo.add(Roles.JOKO);
			compo.add(Roles.MAKA);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			
			Random r = new Random();
			int nb_ = r.nextInt(3);
			
			if(nb_ == 1) {
				roles_select.add(Roles.FARMEURIMMO);
				compo.add(Roles.FARMEURIMMO);
			}
			else if(nb_ == 2) {
				roles_select.add(Roles.KZOU);
				compo.add(Roles.KZOU);
			}
			else {
				roles_select.add(Roles.EXPERIMENTAL);
				compo.add(Roles.EXPERIMENTAL);
			}
			
		}
		else if(nb == 7) {
			
			roles_select.add(Roles.GAMEBLACK);
			roles_select.add(Roles.JOKO);
			roles_select.add(Roles.MAKA);
			
			roles_select.add(Roles.TRIAL);
			roles_select.add(Roles.SLUP);
			roles_select.add(Roles.MALIVOL);
			
			compo.add(Roles.GAMEBLACK);
			compo.add(Roles.JOKO);
			compo.add(Roles.MAKA);
			
			compo.add(Roles.TRIAL);
			compo.add(Roles.SLUP);
			compo.add(Roles.MALIVOL);
			
			Random r = new Random();
			int nb_ = r.nextInt(3);
			
			if(nb_ == 1) {
				roles_select.add(Roles.FARMEURIMMO);
				compo.add(Roles.FARMEURIMMO);
			}
			else if(nb_ == 2) {
				roles_select.add(Roles.KZOU);
				compo.add(Roles.KZOU);
			}
			else {
				roles_select.add(Roles.EXPERIMENTAL);
				compo.add(Roles.EXPERIMENTAL);
			}
			
		}
		
	}
	
	//GESTION DE LA PARTIE
	public void setHost(Player player) {
		
		host = player;
		
	}
	public Player getHost() {
		
		return host;
		
	}
	
	public void addRoleGame(Roles role) {
		
		roles_select.add(role);
		
	}
	public void removeRoleGame(Roles role) {
		
		roles_select.remove(role);
		
	}
	public List<Roles> getRoleGame() {
		
		return roles_select;
		
	}
	
	public List<Roles> getCompo(){
		
		return compo;
		
	}
	
	public int getTempsEpisode() {
		
		return temps_episode;
		
	}
	public int getTemps() {
		
		return temps;
		
	}
	public void addTemps() {
		
		temps ++;
		
	}
	public void addEpisode() {
		
		temps = 0;
		episode += 1;
		
	}
	public int getEpisode() {
		
		return episode;
		
	}
	public void setTemps() {
		
		temps = temps_episode - 1;
		
	}
	public void setJour(boolean value) {
		
		jour = value;
		
	}
	
	public List<Pouvoirs> getCD(){
		
		return cd;
		
	}
	
	public void addInvulnerable(Player player) {
		
		invulnerable.add(player);
		
	}
	public void removeInvulnerable(Player player) {
		
		invulnerable.remove(player);
		
	}
	public List<Player> getInvulnerable(){
		
		return invulnerable;
		
	}
	
	public void setState(State state) {
		this.state = state;
	}
	public boolean isState(State state) {
		return this.state == state;
	}
	public State getState() {
		return this.state;
	}
	
	public boolean isDay() {
		
        return jour;
       
    }
	
	public void setRole(Player player, Roles role){
		int id = players.indexOf(player);
		roles.set(id, role);
		
		if(role == Roles.GAMEBLACK) {
			
			GameBlack.Items(player, this);
			
		}
		else if(role == Roles.ARCHER) {
			
			Archer.Items(player);
			
		}
		else if(role == Roles.ECLAIREUR) {
			
			Eclaireur.Items(player);
			
		}
		else if(role == Roles.GUERRIER) {
			
			Guerrier.Items(player, this);
			
		}
		else if(role == Roles.JOKO) {
			
			Joko.Items(player);
			
		}
		else if(role == Roles.LOUP) {
			
			Loup.Items(player);
			
		}
		else if(role == Roles.MAKA) {
			
			Maka.Items(player);
			
		}
		else if(role == Roles.RAPTOR) {
			
			Raptor.Items(player);
			
		}
		else if(role == Roles.TEAM) {
			
			Team.Items(player, this);
			
		}
		else if(role == Roles.TOINOU) {
			
			Toinou.Items(player);
			
		}
		else if(role == Roles.ANGE) {
			
			Ange.Items(player);
			
		}
		else if(role == Roles.AVENIR) {
			
			Avenir.Items(player, this);
			
		}
		else if(role == Roles.COSMOS) {
			
			Cosmos.Items(player, this);
			
		}
		else if(role == Roles.DEMON) {
			
			Demon.Items(player, this);
			
		}
		else if(role == Roles.ELECTRIQUE) {
			
			Electrique.Items(player);
			
		}
		else if(role == Roles.ENFER) {
			
			Enfer.Items(player, this);
			
		}
		else if(role == Roles.MALEDICTION) {
			
			Malediction.Items(player);
			
		}
		else if(role == Roles.MALIVOL) {
			
			Malivol.Items(player);
			
		}
		else if(role == Roles.SANG) {
			
			Sang.Items(player);
			
		}
		else if(role == Roles.SLUP) {
			
			Slup.Items(player);
			
		}
		else if(role == Roles.TENEBRE) {
			
			Tenebre.Items(player);
			
		}
		else if(role == Roles.TRIAL) {
			
			Trial.Items(player, this);
			
		}
		else if(role == Roles.TRONCONEUSE) {
			
			Tronconeuse.Items(player);
			
		}
		else if(role == Roles.EXPERIMENTAL) {
			
			Experimental.Items(player, this);
			
		}
		else if(role == Roles.OBSCUR) {
			
			Obscur.Items(player);
			
		}
		else if(role == Roles.FARMEURIMMO) {
			
			Farmeurimmo.Items(player, this);
			
		}
		else if(role == Roles.KZOU) {
			
			Kzou.Items(player);
			
		}
		
	}
	public Roles getRole(Player player) {
		
		int id = players.indexOf(player);
		return roles.get(id);
		
	}
	public List<Roles> getRoles() {
		
		return roles;
		
	}
	
	public Player getPlayerByRole(Roles role) {
		
		int id = roles.indexOf(role);
		return players.get(id);
		
	}
	public List<Player> getPlayers(){
		
		return players;
		
	}
	public void addPlayer(Player player) {
		
		players.add(player);
		roles.add(Roles.NONE);
		orbes.add(Orbe.NONE);
		orbes_actif.add(false);
		orbe_malus.add(false);
		force.add(1.0);
		speed.add(1.0);
		resi.add(1.0);
		cube.add(0);
		proche_slup.add(0);
		copie_obscur.add(0);
		lastHit.add(null);
		
	}

	public void setLastHit(Player player, Player damager) {
		
		int id = players.indexOf(player);
		
		lastHit.set(id, damager);
		
	}
	public Player getLastHit(Player player) {
		
		int id = players.indexOf(player);
		
		return lastHit.get(id);
		
	}
	
	public void addPourcentEffet(Player player, String effet, double nb) {
		
		int id = players.indexOf(player);
		if(effet == "force") {
			
			double new_force = force.get(id) + nb;
			force.set(id, new_force);
			
		}
		else if(effet == "speed") {
			
			double new_speed = speed.get(id) + nb;
			speed.set(id, new_speed);
			
		}
		else{
			
			double new_resi = resi.get(id) + nb;
			resi.set(id, new_resi);
			
		}
		
	}
	public void removePourcentEffet(Player player, String effet, double nb) {
		
		int id = players.indexOf(player);
		if(effet == "force") {
			
			double new_force = force.get(id) - nb;
			force.set(id, new_force);
			
		}
		else if(effet == "speed") {
			
			double new_speed = speed.get(id) - nb;
			speed.set(id, new_speed);
			
		}
		else{
			
			double new_resi = resi.get(id) - nb;
			resi.set(id, new_resi);
			
		}
		
	}
	public double getPourcentEffet(Player player, String effet) {
		
		int id = players.indexOf(player);
		if(effet == "force") {
			
			double nb = force.get(id);
			
			return nb;
			
		}
		else if(effet == "speed") {
			
			double nb = force.get(id);
			
			return nb;
			
		}
		else{
			
			double nb = resi.get(id);
			
			return nb;
			
		}
		
	}

	public void eliminate(Player player, boolean Kzou) {
		if(getCampsDemonVie().contains(getRole(player))) {
			
			camps_demon_vie.remove(getRole(player));
			
		}
		else if (getCampsDemonVie().contains(getRole(player))) {
			
			camps_rc_vie.remove(getRole(player));
			
		}
		else {
			
			solo_vie.remove(getRole(player));
			
		}
		
		Roles role;
		
		if(Kzou) {
			
			Random r = new Random();
			List<String> camps_list = new ArrayList<>();
			if(camps_demon_vie.size() != 0) {
				
				camps_list.add("demon");
				
			}
			if(camps_rc_vie.size() != 0) {
				
				camps_list.add("rc");
				
			}
			if(solo_vie.size() != 0)  {
				
				camps_list.add("solo");
				
			}
			
			int nb_ = r.nextInt(camps_list.size());
			String camps = camps_list.get(nb_);
			
			if(camps == "demon") {
				
				int nb = r.nextInt(camps_demon_vie.size());
				role = camps_demon_vie.get(nb);
				
			}
			else if(camps == "rc") {
				
				int nb = r.nextInt(camps_rc_vie.size());
				role = camps_rc_vie.get(nb);
				
			}
			else {
				
				int nb = r.nextInt(solo_vie.size());
				role = solo_vie.get(nb);
				
			}
			
			getPlayerByRole(Roles.KZOU).sendMessage("Tu as activé la commande /rcop, le vrai rôle du joueur était : " + getRole(player));;
			
		}
		else {
			
			role = getRole(player);
			
		}
		setRole(player, Roles.NONE);
		setOrbe(player, Orbe.NONE);
		Bukkit.broadcastMessage("_________________________\n" + player.getName() + " est mort. Il était : \n" + role + "\n_________________________");
		checkWin();
		player.setGameMode(GameMode.SPECTATOR);
		
		//MortCD cycle = new MortCD(this, player);
		//cycle.runTaskTimer(this, 0, 20);
	}

	public void checkWin() {
		
		if(camps_demon_vie.isEmpty() && solo_vie.isEmpty()) {
			
			Bukkit.broadcastMessage("Le camps RC remporte la partie !");
			
		}
		else if(camps_rc_vie.isEmpty() && solo_vie.isEmpty()) {
			
			Bukkit.broadcastMessage("Le camps Démon remporte la partie !");
			
		}
		else if(camps_demon_vie.isEmpty() && camps_rc_vie.isEmpty() && solo_vie.size() == 1) {
			
			if(solo_vie.get(0) == Roles.FARMEURIMMO) {
				
				Bukkit.broadcastMessage("Farmeurimmo remporte la partie !");
				
			}
			else if(solo_vie.get(0) == Roles.KZOU) {
				
				Bukkit.broadcastMessage("Kzou remporte la partie !");
				
			}
			else {
				
				Bukkit.broadcastMessage("Le démon Expérimental remporte la partie !");
				
			}
			
		}
		
	}
	
	public void Stun(Player player, int timer, Player cible) {
		
		cible.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, timer, 100, false, false));
		cible.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, timer, 100, false, false));
		cible.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, timer, 250, false, false));
		getInvulnerable().add(cible);
		
	}
	
	public static ItemStack getItem(Material material, String customName, String desc) {
		ItemStack it = new ItemStack(material,1);
		ItemMeta itM = it.getItemMeta();
		if(customName != null) itM.setDisplayName(customName);
		itM.setLore(Arrays.asList(desc.split(";")));
		itM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		it.setItemMeta(itM);
		return it;
	}
	
	//CAMPS RC
	public List<Roles> getCampsRCVie(){
		
		return camps_rc_vie;
		
	}
	public List<Roles> GetCampsRC(){
		
		return camps_rc;
		
	}
	
	public void setJokoItem(boolean value) {
		
		joko_item = value;
		
	}
	public boolean isJokoItem() {
		
		return joko_item;
		
	}
	public void addCube(Player player) {
		
		int id = players.indexOf(player);
		cube.set(id, cube.get(id)+1);
		
	}
	public void removeCube(Player player) {
		
		int id = players.indexOf(player);
		cube.set(id, cube.get(id)-1);
		
	}
	public int getCube(Player player) {
		
		int id = players.indexOf(player);
		return cube.get(id);
		
	}
	public List<Integer> getCubes() {
		
		return cube;
		
	}
	public void setStun(Player player) {
		
		joko_stun.add(player);
		
	}
	public boolean isStun() {
		
		return joko_stun.size() != 0;
		
	}
	public List<Player> getStun(){
		
		return joko_stun;
		
	}
	
	public void ToinouKillAvenir() {
		
		respawn_toinou = true;
		
	}
	public boolean ToinouCanRespawn() {
		
		return respawn_toinou;
		
	}
	public void ToinouRespawn() {
		
		respawn_toinou = false;
		
	}
	public void addKillToinou(Roles role) {
		
		kill_toinou.add(role);
		
	}
	public boolean ToinouKill(Roles role) {
		
		return kill_toinou.contains(role);
		
	}
	
	public Roles getConnaissanceTeam() {
		
		return connaissance_team;
		
	}
	public void setConnaissanceTeam(Roles role) {
		
		connaissance_team = role;
		
	}
	
	public boolean MakaRageActif() {
		
		return maka_fire;
		
	}
	public void ChangeMakaRage() {
		
		maka_fire = !maka_fire;
		
	}
	public void setMakaForce(boolean value) {
		
		maka_force = value;
		
	}
	public boolean isMakaForce() {
		
		return maka_force;
		
	}
	public void setTueurNeko(Player player) {
		
		tueur_neko = player;
		
	}
	public Player getTueurNeko() {
		
		return tueur_neko;
		
	}
	public void setFindTueurNeko(boolean value) {
		
		find_tueur_neko = value;
		
	}
	public boolean hasFindTueurNeko() {
		
		return find_tueur_neko;
		
	}
	
	public void setLoupPouvoir(boolean value) {
		
		loup_pouvoir = value;
		
	}
	public boolean isLoupPouvoir() {
		
		return loup_pouvoir;
		
	}
	
	public int getPacteGB() {
		
		return pacte_gb;
		
	}
	public void setPacteGB(int nb) {
		
		pacte_gb = nb;
		
	}
	
	//CAMPS DEMON
	public List<Roles> getCampsDemonVie(){
		
		return camps_demon_vie;
		
	}
	public List<Roles> GetCampsDemon(){
		
		return camps_demon;
		
	}
	
	public void setTrialKzou(boolean valeur) {
		
		trial_kzou = valeur;
		
	}
	public boolean TrialCroiseKzou() {
		
		return trial_kzou;
		
	}
	public boolean TrialKillRaptor() {
		
		return trial_kill_raptor;
		
	}
	public void setTrialKillRaptor() {
		
		trial_kill_raptor = true;
		
	}
	public void addVolTrial(String vol) {
		
		vol_trial.add(vol);
		
	}
	public List<String> getVolTrial(){
		
		return vol_trial;
		
	}
	public Roles getRoleKillTrial() {
		
		return role_kill_trial;
		
	}
	public Orbe getOrbeKillTrial() {
		
		return orbe_kill_trial;
		
	}
	public void setRoleKillTrial(Roles role) {
		
		role_kill_trial = role;
		
	}
	public void setOrbeKillTrial(Orbe orbe) {
		
		orbe_kill_trial = orbe;
		
	}
	
	public void setNofallElec(boolean valeur) {
		
		nofall_elec = valeur;
		
	}
	public boolean isNofallElec() {
		
		return nofall_elec;
		
	}
	
	public void setNuitTenebre(boolean valeur) {
		
		nuit_tenebre = valeur;
		
	}
	public boolean isNuitTenebre() {
		
		return nuit_tenebre;
		
	}
	
	public void addCopie(Player player) {
		
		int id = players.indexOf(player);
		int nb = copie_obscur.get(id) + 1;
		copie_obscur.set(id, nb);
		
	}
	public int getNbCopie(Player player) {
		
		int id = players.indexOf(player);
		return copie_obscur.get(id);
		
	}
	public List<Integer> getCopie(){
		
		return copie_obscur;
		
	}
	public void setOrbeCopier(Orbe orbe) {
		
		orbe_copier = orbe;
		
	}
	public Orbe getOrbeCopier() {
		
		return orbe_copier;
		
	}
	public void setOrbeArme(String arme, Orbe orbe) {
		
		if(arme.equalsIgnoreCase("casque")) {
			
			inv_orbe.set(0, orbe);
			
		}
		else if(arme.equalsIgnoreCase("plastron")) {
			
			inv_orbe.set(1, orbe);
			
		}
		else if(arme.equalsIgnoreCase("jambiere")) {
			
			inv_orbe.set(2, orbe);
			
		}
		else if(arme.equalsIgnoreCase("bottes")) {
			
			inv_orbe.set(3, orbe);
			
		}
		else {
			
			inv_orbe.set(4, orbe);
			
		}
		
	}
	public Orbe getOrbeArme(String arme) {
		
		if(arme.equalsIgnoreCase("casque")) {
			
			return inv_orbe.get(0);
			
		}
		else if(arme.equalsIgnoreCase("plastron")) {
			
			return inv_orbe.get(1);
			
		}
		else if(arme.equalsIgnoreCase("jambiere")) {
			
			return inv_orbe.get(2);
			
		}
		else if(arme.equalsIgnoreCase("bottes")) {
			
			return inv_orbe.get(3);
			
		}
		else {
			
			return inv_orbe.get(4);
			
		}
		
	}
	public List<Orbe> getInvOrbe(){
		
		return inv_orbe;
		
	}
	public List<Orbe> getInvOrbeActif(){
		
		return inv_orbe_actif;
		
	}
	public void setOrbeArmeActif(String arme, Orbe orbe) {
		
		if(arme.equalsIgnoreCase("casque")) {
			
			inv_orbe_actif.set(0, orbe);
			
		}
		else if(arme.equalsIgnoreCase("plastron")) {
			
			inv_orbe_actif.set(1, orbe);
			
		}
		else if(arme.equalsIgnoreCase("jambiere")) {
			
			inv_orbe_actif.set(2, orbe);
			
		}
		else if(arme.equalsIgnoreCase("bottes")) {
			
			inv_orbe_actif.set(3, orbe);
			
		}
		else {
			
			inv_orbe_actif.set(4, orbe);
			
		}
		
	}
	public Orbe getOrbeArmeActif(String arme) {
		
		if(arme.equalsIgnoreCase("casque")) {
			
			return inv_orbe_actif.get(0);
			
		}
		else if(arme.equalsIgnoreCase("plastron")) {
			
			return inv_orbe_actif.get(1);
			
		}
		else if(arme.equalsIgnoreCase("jambiere")) {
			
			return inv_orbe_actif.get(2);
			
		}
		else if(arme.equalsIgnoreCase("bottes")) {
			
			return inv_orbe_actif.get(3);
			
		}
		else {
			
			return inv_orbe_actif.get(4);
			
		}
		
	}
	
	public int getPointAnge() {
		
		return point_ange;
		
	}
	public void addPointAnge() {
		
		point_ange ++;
		
	}
	public void removePointAnge(int nb) {
		
		point_ange -= nb;
		
	}

	public void setEffetDemon(String effet) {
		
		effet_demon = effet;
		
	}
	public String getEffetDemon() {
		
		return effet_demon;
		
	}
	
	public int getMalivolCheat() {
		
		return malivol_cheat;
		
	}
	public void setMalivolCheat(int nb) {
		
		malivol_cheat = nb;
		
	}
	
	public void addProcheSlup(Player player) {
		
		int id = players.indexOf(player);
		int nb = proche_slup.get(id) + 1;
		proche_slup.set(id, nb);
		
	}
	public int getProcheSlup(Player player) {
		
		int id = players.indexOf(player);
		return proche_slup.get(id);
		
	}
	
	public void setInf(boolean value) {
		
		infect = value;
		
	}
	public boolean hasInf() {
		
		return infect;
		
	}
	
	public void addNbSaigne() {
		
		nb_saigne += 1;
		
	}
	public int getNbSaigne() {
		
		return nb_saigne;
		
	}
	public void addSaigne(Player player) {
		
		saigne = player;
		
	}
	public Player getSaigne() {
		
		return saigne;
		
	}
	public void setOrbeKill(Orbe orbe) {
		
		orbe_kill = orbe;
		
	}
	public Orbe getOrbeKill() {
		
		return orbe_kill;
		
	}
	
	//SOLOS
	public List<Roles> getSoloVie(){
		
		return solo_vie;
		
	}
	public void setOP(boolean value) {
		
		op = value;
		
	}
	public boolean hasOP() {
		
		return op;
		
	}
	public void addNbOP() {
		
		nb_op += 1;
		
	}
	public int getNbOP() {
		
		return nb_op;
		
	}
	
	public void setSpeedFarmeur(boolean value) {
		
		speed_farmeur = value;
		
	}
	public boolean isSpeedFarmeur() {
		
		return speed_farmeur;
		
	}
	public void setAbsoFarmeur(boolean value) {
		
		abso_farmeur = value;
		
	}
	public boolean isAbsoFarmeur() {
		
		return abso_farmeur;
		
	}
	
	//ORBES
	public void setOrbe(Player player, Orbe orbe) {
		
		int id = players.indexOf(player);
		orbes.set(id, orbe);
		
	}
	public void changeStatutOrbe(Player player, boolean bool) {
		
		int id = players.indexOf(player);	
		orbes_actif.set(id, bool);
		
	}
	public boolean isOrbeActif(Player player) {
		
		int id = players.indexOf(player);
		return orbes_actif.get(id);
		
	}
	public Orbe getOrbe(Player player) {
		
		int id = players.indexOf(player);
		return orbes.get(id);
		
	}
	public List<Orbe> getOrbes(){
		
		return orbes;
		
	}
	public boolean isOrbeMalus(Player player) {
		
		int id = players.indexOf(player);
		return orbe_malus.get(id);
		
	}
	public void setMalusOrbe(Player player, boolean value) {
		
		int id = players.indexOf(player);
		orbe_malus.set(id, value);
		
	}
	
}
