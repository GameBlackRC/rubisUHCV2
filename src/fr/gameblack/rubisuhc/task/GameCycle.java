package fr.gameblack.rubisuhc.task;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.gameblack.rubisuhc.Main;
import fr.gameblack.rubisuhc.Orbe;
import fr.gameblack.rubisuhc.Pouvoirs;
import fr.gameblack.rubisuhc.Roles;
import fr.gameblack.rubisuhc.State;
import fr.gameblack.rubisuhc.orbes.Foudre;
import fr.gameblack.rubisuhc.orbes.Glace;

public class GameCycle extends BukkitRunnable{
	
	private Main main;
	
	private int timer = 0;
	
	public GameCycle(Main main) {
		this.main = main;
	}
	
	
	@Override
	public void run() {
		
		//if(main.getTemps() == 1200) {
		if(main.getTemps() == main.getTempsEpisode()) {
			
			if(main.getCD().contains(Pouvoirs.GB_INSPECT)) {
				
				main.getCD().remove(Pouvoirs.GB_INSPECT);
				
			}
			else if(main.getCD().contains(Pouvoirs.GB_NERF)) {
				
				main.getCD().remove(Pouvoirs.GB_NERF);
				
			}
			else if(main.getCD().contains(Pouvoirs.GB_RECRUT)) {
				
				main.getCD().remove(Pouvoirs.GB_RECRUT);
				
			}
			else if(main.getCD().contains(Pouvoirs.KZOU_BAN)) {
				
				main.getCD().remove(Pouvoirs.KZOU_BAN);
				
			}
			else if(main.getCD().contains(Pouvoirs.KZOU_DISPERSE)) {
				
				main.getCD().remove(Pouvoirs.KZOU_DISPERSE);
				
			}
			else if(main.getCD().contains(Pouvoirs.LOUP_TRANSFO)) {
				
				main.getCD().remove(Pouvoirs.LOUP_TRANSFO);
				
			}
			else if(main.getCD().contains(Pouvoirs.MALIVOL_CHEAT)) {
				
				main.getCD().remove(Pouvoirs.MALIVOL_CHEAT);
				
			}
			else if(main.getCD().contains(Pouvoirs.RAPTOR_RAGE)) {
				
				main.getCD().remove(Pouvoirs.RAPTOR_RAGE);
				
			}
			else if(main.getCD().contains(Pouvoirs.SANG_SANG)) {
				
				main.getCD().remove(Pouvoirs.SANG_SANG);
				
			}
			else if(main.getCD().contains(Pouvoirs.TENEBRE_BLIND)) {
				
				main.getCD().remove(Pouvoirs.TENEBRE_BLIND);
				
			}
			else if(main.getCD().contains(Pouvoirs.JOKO_CUBE)) {
				
				main.getCD().remove(Pouvoirs.JOKO_CUBE);
				
			}
			else if(main.getCD().contains(Pouvoirs.ELECTRIQUE_FOUDRE)) {
				
				main.getCD().remove(Pouvoirs.ELECTRIQUE_FOUDRE);
				
			}
			else if(main.getCD().contains(Pouvoirs.ENFER_ZONE)) {
				
				main.getCD().remove(Pouvoirs.ENFER_ZONE);
				
			}
			else if(main.getCD().contains(Pouvoirs.TRONCONEUSE_LAME)) {
				
				main.getCD().remove(Pouvoirs.TRONCONEUSE_LAME);
				
			}
			
			int episode = main.getEpisode() + 1;
			
			Bukkit.broadcastMessage("_________________________\n \nEpisode " + episode + "\n_________________________");
			
			if(main.getEpisode() == 1) {
				
				main.setState(State.PVP_ON);
				
				for(Player pls : main.getPlayers()) {
					
					Random r = new Random();
					int nb = r.nextInt(main.getRoleGame().size());
					
					Roles role = main.getRoleGame().get(nb);
					main.setRole(pls, role);
					main.removeRoleGame(role);
					main.removeInvulnerable(pls);
					
					if(role == Roles.ARCHER || role == Roles.ECLAIREUR || role == Roles.FARMEURIMMO || role == Roles.GAMEBLACK || role == Roles.GUERRIER || role == Roles.JOKO || role == Roles.KZOU || role == Roles.LOUP || role == Roles.RAPTOR || role == Roles.SLUP || role == Roles.TEAM || role == Roles.TOINOU) {
						
						int nb_ = r.nextInt(4);
						
						if(nb_ == 1) {
							
							main.setOrbe(pls, Orbe.EAU);
							pls.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");
							
						}
						else if(nb_ == 2) {
							
							main.setOrbe(pls, Orbe.FEU);
							pls.sendMessage("Vous avez reçu l'orbe de feu. Vous pouvez l'activer avec la commande /rcorbe");
							
						}
						else if(nb_ == 3) {
							
							main.setOrbe(pls, Orbe.FOUDRE);
							pls.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");
							
						}
						else{
							
							main.setOrbe(pls, Orbe.GLACE);
							pls.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");
							
						}
						
					}
					else if(role == Roles.MAKA) {
						
						int nb_ = r.nextInt(3);
						
						if(nb_ == 1) {
							
							main.setOrbe(pls, Orbe.EAU);
							pls.sendMessage("Vous avez reçu l'orbe d'eau. Vous pouvez l'activer avec la commande /rcorbe");
							
						}
						else if(nb_ == 2) {
							
							main.setOrbe(pls, Orbe.FOUDRE);
							pls.sendMessage("Vous avez reçu l'orbe de foudre. Vous pouvez l'activer avec la commande /rcorbe");
							
						}
						else{
							
							main.setOrbe(pls, Orbe.GLACE);
							pls.sendMessage("Vous avez reçu l'orbe de glace. Vous pouvez l'activer avec la commande /rcorbe");
							
						}
						
					}
					
					pls.setHealth(pls.getMaxHealth());
					
					if(main.GetCampsDemon().contains(role)) {
						
						main.getCampsDemonVie().add(role);
						
					}
					else if(main.GetCampsRC().contains(role)) {
						
						main.getCampsRCVie().add(role);
						
					}
					else {
						
						main.getSoloVie().add(role);
						
					}
					
				}
				
				Random r = new Random();
				
				if(main.getCampsDemonVie().size() != 0) {
				
					int nb_ = r.nextInt(main.getCampsDemonVie().size());
					
					Roles tueur_neko_role = main.getCampsDemonVie().get(nb_);
					
					Player tueur_neko = main.getPlayerByRole(tueur_neko_role);
					
					tueur_neko.sendMessage("Vous êtes le tueur de neko ! Vous recevez 2% de force, de résistance et de speed");
					
					main.setTueurNeko(tueur_neko);
					main.addPourcentEffet(tueur_neko, "force", 0.02);
					main.addPourcentEffet(tueur_neko, "speed", 0.02);
					main.addPourcentEffet(tueur_neko, "resi", 0.02);
					
				}
				
				if(main.getCampsDemonVie().contains(Roles.SLUP)) {
					
					String pseudo_slup = main.getPlayerByRole(Roles.SLUP).getName();
					
					if(main.getCampsDemonVie().contains(Roles.ANGE)) {
						
						main.getPlayerByRole(Roles.ANGE).sendMessage("Slup : " + pseudo_slup);
						
					}
					if(main.getCampsDemonVie().contains(Roles.AVENIR)) {
						
						main.getPlayerByRole(Roles.AVENIR).sendMessage("Slup : " + pseudo_slup);
						
					}
					if(main.getCampsDemonVie().contains(Roles.COSMOS)) {
						
						main.getPlayerByRole(Roles.COSMOS).sendMessage("Slup : " + pseudo_slup);
						
					}
					if(main.getCampsDemonVie().contains(Roles.ELECTRIQUE)) {
						
						main.getPlayerByRole(Roles.ELECTRIQUE).sendMessage("Slup : " + pseudo_slup);
						
					}
					if(main.getCampsDemonVie().contains(Roles.ENFER)) {
						
						main.getPlayerByRole(Roles.ENFER).sendMessage("Slup : " + pseudo_slup);
						
					}
					if(main.getSoloVie().contains(Roles.KZOU)) {
						
						main.getPlayerByRole(Roles.KZOU).sendMessage("Slup : " + pseudo_slup);
						
					}
					if(main.getCampsDemonVie().contains(Roles.MALEDICTION)) {
						
						main.getPlayerByRole(Roles.MALEDICTION).sendMessage("Slup : " + pseudo_slup);
						
					}
					if(main.getCampsDemonVie().contains(Roles.SANG)) {
						
						main.getPlayerByRole(Roles.SANG).sendMessage("Slup : " + pseudo_slup);
						
					}
					if(main.getCampsDemonVie().contains(Roles.TENEBRE)) {
						
						main.getPlayerByRole(Roles.TENEBRE).sendMessage("Slup : " + pseudo_slup);
						
					}
					if(main.getCampsDemonVie().contains(Roles.TRONCONEUSE)) {
						
						main.getPlayerByRole(Roles.TRONCONEUSE).sendMessage("Slup : " + pseudo_slup);
						
					}
					
				}
				
				if(main.getCampsDemonVie().contains(Roles.DEMON)) {
					
					Roles role = Roles.TRIAL;
					
					while(role == Roles.TRIAL || role == Roles.SLUP || role == Roles.DEMON) {
						
						int nb = r.nextInt(main.getCampsDemonVie().size());
						
						role = main.getCampsDemonVie().get(nb);
						
					}
					
					main.getPlayerByRole(Roles.DEMON).sendMessage(role.toString().toLowerCase() + " : " + main.getPlayerByRole(role).getName());
					
				}
				
				if(main.getCampsDemonVie().contains(Roles.MALIVOL) && main.getCampsDemonVie().contains(Roles.TRIAL)) {
					
					main.getPlayerByRole(Roles.MALIVOL).sendMessage("Trial : " + main.getPlayerByRole(Roles.TRIAL).getName());
					
				}
				
				if(main.getCampsDemonVie().contains(Roles.OBSCUR) && main.getCampsDemonVie().contains(Roles.TRIAL)) {
					
					main.getPlayerByRole(Roles.OBSCUR).sendMessage("Trial : " + main.getPlayerByRole(Roles.TRIAL).getName());
					
				}
				
				if(main.getCampsRCVie().contains(Roles.TEAM)) {
					
					if(main.getConnaissanceTeam() == Roles.GAMEBLACK && main.getCampsRCVie().contains(Roles.GAMEBLACK)) {
						
						main.getPlayerByRole(Roles.TEAM).sendMessage("GameBlack : " + main.getPlayerByRole(Roles.GAMEBLACK).getName());
						
					}
					else if(main.getCampsRCVie().contains(Roles.MAKA) && main.getConnaissanceTeam() == Roles.MAKA){
						
						main.getPlayerByRole(Roles.TEAM).sendMessage("Maka : " + main.getPlayerByRole(Roles.MAKA).getName());
						
					}
					
				}
				
			}
			
			main.addEpisode();
			if(main.isDay()) {
				
				main.setJour(false);
				Bukkit.broadcastMessage("§1LA NUIT TOMBE");
				
			}
			else {
				
				main.setJour(true);
				Bukkit.broadcastMessage("§6LE JOUR SE LEVE");
				
			}
			
		}
		
		if(main.getTemps() == main.getTempsEpisode() / 2 && main.getEpisode() != 1) {
			
			if(main.isDay()) {
				
				main.setJour(false);
				Bukkit.broadcastMessage("§1LA NUIT TOMBE");
				Nuit(main);
				
			}
			else {
				
				main.setJour(true);
				Bukkit.broadcastMessage("§6LE JOUR SE LEVE");
				Jour(main);
				
			}
			
		}
		
		if(timer % 10 == 0) {
			
			if(main.getCampsDemonVie().contains(Roles.OBSCUR)) {
			
				Player obscur = main.getPlayerByRole(Roles.OBSCUR);
				
				for(Entity nearbyEntities : obscur.getNearbyEntities(20, 20, 20)) {
					
					if(nearbyEntities instanceof Player) {
						
						Player player = (Player) nearbyEntities;
						
						if(main.getNbCopie(player) < 300) {
						
							main.addCopie(player);
							
						}
						
					}
					
				}
				
			}
			
		}
		
		if(main.getRoles().contains(Roles.SLUP) && (main.getRoles().contains(Roles.ANGE) || main.getRoles().contains(Roles.AVENIR) || main.getRoles().contains(Roles.COSMOS) || main.getRoles().contains(Roles.DEMON) || main.getRoles().contains(Roles.ELECTRIQUE) || main.getRoles().contains(Roles.ENFER) || main.getRoles().contains(Roles.KZOU) || main.getRoles().contains(Roles.MALEDICTION) || main.getRoles().contains(Roles.MALIVOL) || main.getRoles().contains(Roles.SANG) || main.getRoles().contains(Roles.TENEBRE) || main.getRoles().contains(Roles.TRONCONEUSE))) {
			
			if(timer % 10 == 0) {
				
				Player slup = main.getPlayerByRole(Roles.SLUP);
			
				for (Entity nearbyEntities : slup.getNearbyEntities(30, 30, 30)) {
						
					if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.ANGE) && (Player) nearbyEntities == main.getPlayerByRole(Roles.ANGE)) {
						
						CheckProcheSlup(Roles.ANGE, slup, nearbyEntities, main);
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.COSMOS) && (Player) nearbyEntities == main.getPlayerByRole(Roles.COSMOS)) {
						
						CheckProcheSlup(Roles.COSMOS, slup, nearbyEntities, main);
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.AVENIR) && (Player) nearbyEntities == main.getPlayerByRole(Roles.AVENIR)) {
						
						CheckProcheSlup(Roles.AVENIR, slup, nearbyEntities, main);
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.DEMON) && (Player) nearbyEntities == main.getPlayerByRole(Roles.DEMON)) {
						
						CheckProcheSlup(Roles.DEMON, slup, nearbyEntities, main);
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.ELECTRIQUE) && (Player) nearbyEntities == main.getPlayerByRole(Roles.ELECTRIQUE)) {
						
						CheckProcheSlup(Roles.ELECTRIQUE, slup, nearbyEntities, main);
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.ENFER) && (Player) nearbyEntities == main.getPlayerByRole(Roles.ENFER)) {
						
						CheckProcheSlup(Roles.ENFER, slup, nearbyEntities, main);
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.KZOU) && (Player) nearbyEntities == main.getPlayerByRole(Roles.KZOU)) {
						
						if(main.getProcheSlup(main.getPlayerByRole(Roles.KZOU)) < 600) {
							
							main.addProcheSlup(main.getPlayerByRole(Roles.KZOU));
								
						}
						else if(main.getProcheSlup(main.getPlayerByRole(Roles.KZOU)) == 600) {
								
							main.addProcheSlup(main.getPlayerByRole(Roles.KZOU));
									
							slup.sendMessage("Vous avez un mauvais pressentiment");
								
						}
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.MALEDICTION) && (Player) nearbyEntities == main.getPlayerByRole(Roles.MALEDICTION)) {
						
						CheckProcheSlup(Roles.MALEDICTION, slup, nearbyEntities, main);
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.MALIVOL) && (Player) nearbyEntities == main.getPlayerByRole(Roles.MALIVOL)) {
						
						CheckProcheSlup(Roles.MALIVOL, slup, nearbyEntities, main);
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.OBSCUR) && (Player) nearbyEntities == main.getPlayerByRole(Roles.OBSCUR)) {
						
						CheckProcheSlup(Roles.OBSCUR, slup, nearbyEntities, main);
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.SANG) && (Player) nearbyEntities == main.getPlayerByRole(Roles.SANG)) {
						
						CheckProcheSlup(Roles.SANG, slup, nearbyEntities, main);
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.TENEBRE) && (Player) nearbyEntities == main.getPlayerByRole(Roles.TENEBRE)) {
						
						CheckProcheSlup(Roles.TENEBRE, slup, nearbyEntities, main);
							
					}
					else if(nearbyEntities instanceof Player && main.getRoles().contains(Roles.TRONCONEUSE) && (Player) nearbyEntities == main.getPlayerByRole(Roles.TRONCONEUSE)) {
						
						CheckProcheSlup(Roles.TRONCONEUSE, slup, nearbyEntities, main);
							
					}
					
				}
				
			}
			
		}
		
		if(timer % 10 == 0) {
			
			main.addTemps();
			
		}
		
		if(main.getTemps() % 300 == 0) {
			
			if(main.TrialCroiseKzou()) {
				
				main.setTrialKzou(false);
				Player trial = main.getPlayerByRole(Roles.TRIAL);
				trial.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 0, false, false));
				
			}
			
		}
		
		if(main.getCampsDemonVie().contains(Roles.ELECTRIQUE) && !main.getPlayerByRole(Roles.ELECTRIQUE).hasPotionEffect(PotionEffectType.SPEED)) {
			
			main.getPlayerByRole(Roles.ELECTRIQUE).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0, false, false));
			
		}
		
		if(main.TrialKillRaptor()) {
			
			Player player = main.getPlayerByRole(Roles.TRIAL);
			
			if(!player.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 0, false, false));
				
			}
			
		}
		
		if(main.getRoles().contains(Roles.MALIVOL)) {
			if(!main.getPlayerByRole(Roles.MALIVOL).hasPotionEffect(PotionEffectType.SPEED)) {
				
				main.getPlayerByRole(Roles.MALIVOL).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0, false, false));
				
			}
		}
		
		if(main.getRoles().contains(Roles.MAKA) && main.getRoles().contains(Roles.TEAM)) {
			
			if(main.getConnaissanceTeam() == Roles.MAKA) {
			
				Player maka = main.getPlayerByRole(Roles.MAKA);
				Player team = main.getPlayerByRole(Roles.TEAM);
				
				for (Entity nearbyEntities : maka.getNearbyEntities(20, 20, 20)) {
					
					if(nearbyEntities instanceof Player && (Player) nearbyEntities == team && !main.isMakaForce()) {
						
						main.setMakaForce(true);
						main.addPourcentEffet(maka, "force", 0.15);
						
					}
					else if(main.isMakaForce()){
						
						main.setMakaForce(false);
						main.removePourcentEffet(maka, "force", 0.15);
						
					}
					
				}
				
			}
			
		}
		
		if(main.getRoles().contains(Roles.TRIAL) && main.getRoles().contains(Roles.KZOU)) {
			
			Player trial = main.getPlayerByRole(Roles.TRIAL);
			Player kzou = main.getPlayerByRole(Roles.KZOU);
				
			for (Entity nearbyEntities : trial.getNearbyEntities(3, 3, 3)) {
					
				if(nearbyEntities instanceof Player && (Player) nearbyEntities == kzou) {
						
					main.setTrialKzou(true);
						
				}
					
			}
			
		}
		
		if(main.getCampsDemonVie().contains(Roles.OBSCUR)) {
			
			Player obscur = main.getPlayerByRole(Roles.OBSCUR);
			
			obscurEau(obscur, main);
			
			obscurFeu(obscur, main);
			
			obscurFoudre(obscur, main);
			
			obscurGlace(obscur, main);
			
			if(obscur.hasPotionEffect(PotionEffectType.SLOW) && main.getOrbeArme("jambiere") == Orbe.GLACE) {
				
				obscur.removePotionEffect(PotionEffectType.SLOW);
				
			}
			
		}
		
		if(main.getCampsRCVie().contains(Roles.ECLAIREUR) || (main.getCampsDemonVie().contains(Roles.TRIAL) && main.getVolTrial().contains("invisible_eclaireur"))) {
			
			Player eclaireur;
			
			if(main.getCampsRCVie().contains(Roles.ECLAIREUR)) {
			
				eclaireur = main.getPlayerByRole(Roles.ECLAIREUR);
				
			}
			else {
				
				eclaireur = main.getPlayerByRole(Roles.TRIAL);
				
			}
			
			if(eclaireur.getInventory().getBoots() == null && eclaireur.getInventory().getChestplate() == null && eclaireur.getInventory().getHelmet() == null && eclaireur.getInventory().getLeggings() == null) {
				
				if(!eclaireur.hasPotionEffect(PotionEffectType.INVISIBILITY)) eclaireur.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 0, false, false));
				if(!eclaireur.hasPotionEffect(PotionEffectType.WEAKNESS)) eclaireur.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 99999, 0, false, false));
				
			}
			else {
				
				if(eclaireur.hasPotionEffect(PotionEffectType.INVISIBILITY)) eclaireur.removePotionEffect(PotionEffectType.INVISIBILITY);
				if(eclaireur.hasPotionEffect(PotionEffectType.WEAKNESS)) eclaireur.removePotionEffect(PotionEffectType.WEAKNESS);
				
			}
			
		}
		
		for(int i = 0; i < main.getPlayers().size(); i++) {
			
			if(main.getPlayers().get(i).getFireTicks() > 0) {
				
				if(main.getOrbe(main.getPlayers().get(i)) == Orbe.GLACE && !main.isOrbeMalus(main.getPlayers().get(i))) {
					
					Glace.Malus(main.getPlayers().get(i), main);
					
				}
				
			}
			
			if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.SLOW)){
				
				if(main.getOrbe(main.getPlayers().get(i)) == Orbe.FOUDRE && !main.isOrbeMalus(main.getPlayers().get(i))) {
					
					Foudre.Malus(main.getPlayers().get(i), main);
					
				}
				
			}
			
			if(main.getPlayers().get(i).getWalkSpeed() != 0.2*main.getPourcentEffet(main.getPlayers().get(i), "speed")) {
				
				main.getPlayers().get(i).setWalkSpeed((float) (0.2*main.getPourcentEffet(main.getPlayers().get(i), "speed")));
				
			}
		
			if(!main.isDay()) {
					
				if(main.getRoles().contains(Roles.RAPTOR) && main.getRole(main.getPlayers().get(i)) == Roles.RAPTOR) {
						
					if(!main.getPlayers().get(i).hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) main.getPlayers().get(i).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 0, false, false));
						
				}
				else if(main.getRoles().contains(Roles.MAKA) && main.getRole(main.getPlayers().get(i)) == Roles.MAKA) {
					
					if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.SPEED)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.SPEED);
						
				}
				else if(main.getRoles().contains(Roles.FARMEURIMMO) && main.getRole(main.getPlayers().get(i)) == Roles.FARMEURIMMO) {
					
					if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.SPEED)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.SPEED);
					
				}
				else if(main.getRoles().contains(Roles.KZOU) && main.getRole(main.getPlayers().get(i)) == Roles.KZOU) {
					
					if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					
				}
				
			}
			else {
				
				if(main.isNuitTenebre()) {
					
					main.setJour(false);
					Bukkit.broadcastMessage("§1LA NUIT TOMBE");
					Bukkit.broadcastMessage("Le démon ténèbre à forcer la nuit");
					main.setNuitTenebre(false);
					
				}
					
				if(main.getRoles().contains(Roles.TRIAL) && main.getRole(main.getPlayers().get(i)) == Roles.TRIAL) {
						
					if(!main.TrialKillRaptor()) {
						
						if(!main.getPlayers().get(i).hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) main.getPlayers().get(i).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 0, false, false));
					
					}
					
					if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.SPEED)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.SPEED);
						
				}
				else if(main.getRoles().contains(Roles.MALEDICTION) && main.getRole(main.getPlayers().get(i)) == Roles.MALEDICTION) {
					
					if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						
				}
				else if(main.getRoles().contains(Roles.SANG) && main.getRole(main.getPlayers().get(i)) == Roles.SANG) {
					
					if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						
				}
				else if(main.getRoles().contains(Roles.MAKA) && main.getRole(main.getPlayers().get(i)) == Roles.MAKA) {
						
					if(!main.getPlayers().get(i).hasPotionEffect(PotionEffectType.SPEED)) main.getPlayers().get(i).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0, false, false));
						
				}
				else if(main.getRoles().contains(Roles.TENEBRE) && main.getRole(main.getPlayers().get(i)) == Roles.TENEBRE) {
					
					if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					if(!main.getPlayers().get(i).hasPotionEffect(PotionEffectType.WEAKNESS)) main.getPlayers().get(i).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 99999, 0, false, false));
					if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					
				}
				else if(main.getRoles().contains(Roles.LOUP) && main.getRole(main.getPlayers().get(i)) == Roles.LOUP) {
					
					if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						
				}
				else if(main.getRoles().contains(Roles.RAPTOR) && main.getRole(main.getPlayers().get(i)) == Roles.RAPTOR) {
					
					if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						
				}
				else if(main.getRoles().contains(Roles.TRONCONEUSE) && main.getRole(main.getPlayers().get(i)) == Roles.TRONCONEUSE) {
					
					if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						
				}
				else if(main.getRoles().contains(Roles.DEMON) && main.getRole(main.getPlayers().get(i)) == Roles.DEMON) {
					
					if(main.getEffetDemon() == "speed") {
						
						if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.SPEED)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.SPEED);
							
					}
					else {
							
						if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
							
					}
						
				}
				else if(main.getRoles().contains(Roles.FARMEURIMMO) && main.getRole(main.getPlayers().get(i)) == Roles.FARMEURIMMO) {
					
					if(main.isSpeedFarmeur()) {
					
						if(!main.getPlayers().get(i).hasPotionEffect(PotionEffectType.SPEED)) main.getPlayers().get(i).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 1, false, false));
						
					}
					else {
						
						if(main.getPlayers().get(i).hasPotionEffect(PotionEffectType.SPEED)) main.getPlayers().get(i).removePotionEffect(PotionEffectType.SPEED);
						
					}
					
				}
				else if(main.getRoles().contains(Roles.KZOU) && main.getRole(main.getPlayers().get(i)) == Roles.KZOU) {
					
					if(!main.getPlayers().get(i).hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) main.getPlayers().get(i).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 0, false, false));
					
				}
				
			}
		
		}
		
		timer ++;
		
	}
	
	public static void CheckProcheSlup(Roles role, Player slup, Entity nearbyEntities, Main main) {
			
		if(main.getProcheSlup(main.getPlayerByRole(role)) < 300) {
				
			main.addProcheSlup(main.getPlayerByRole(role));
				
		}
		else if(main.getProcheSlup(main.getPlayerByRole(role)) == 300) {
				
			main.addProcheSlup(main.getPlayerByRole(role));
			Random r = new Random();
			int nb = r.nextInt(100);
			if(nb < 21) {
					
				slup.sendMessage("Vous avez un mauvais pressentiment");
					
			}
			else {
					
				slup.sendMessage("Vous avez confiance en " + main.getPlayerByRole(role).getName());
					
			}
				
		}
		
	}
	
	public static void Nuit(Main main) {
		
		if(main.getCampsDemonVie().contains(Roles.SLUP)) {
			
			Player slup = main.getPlayerByRole(Roles.SLUP);
			main.addPourcentEffet(slup, "force", 0.15);
			
		}
		if(main.getCampsDemonVie().contains(Roles.DEMON)) {
			
			Player demon = main.getPlayerByRole(Roles.DEMON);
			
			if(main.getEffetDemon() == "speed") {
				
				demon.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0, false, false));
					
			}
			else {
					
				main.addPourcentEffet(demon, "force", 0.15);
					
			}
			
		}
		if(main.getCampsDemonVie().contains(Roles.TRIAL)) {
			
			Player trial = main.getPlayerByRole(Roles.TRIAL);
			
			trial.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0, false, false));
			if(!main.TrialKillRaptor()) {
				trial.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			}
				
		}
		if(main.getCampsDemonVie().contains(Roles.MALEDICTION)) {
			
			Player malediction = main.getPlayerByRole(Roles.MALEDICTION);
			
			main.addPourcentEffet(malediction, "force", 0.15);
				
		}
		if(main.getCampsDemonVie().contains(Roles.SANG)) {
			
			Player sang = main.getPlayerByRole(Roles.SANG);
			
			main.addPourcentEffet(sang, "force", 0.15);
				
		}
		if(main.getCampsDemonVie().contains(Roles.TENEBRE)) {
			
			Player tenebre = main.getPlayerByRole(Roles.TENEBRE);
			
			main.addPourcentEffet(tenebre, "force", 0.15);
			tenebre.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 0, false, false));
			tenebre.removePotionEffect(PotionEffectType.WEAKNESS);
			
		}
		if(main.getCampsDemonVie().contains(Roles.TRONCONEUSE)) {
			
			Player tronconeuse = main.getPlayerByRole(Roles.TRONCONEUSE);
			
			main.addPourcentEffet(tronconeuse, "force", 0.15);
				
		}
		if(main.getCampsDemonVie().contains(Roles.LOUP)) {
			
			Player loup = main.getPlayerByRole(Roles.LOUP);
			
			if(!main.isLoupPouvoir()) {
				main.addPourcentEffet(loup, "force", 0.15);
			}
				
		}
		
	}
	
	public static void Jour(Main main) {
		
		if(main.getCampsDemonVie().contains(Roles.SLUP)) {
			
			Player slup = main.getPlayerByRole(Roles.SLUP);
			main.removePourcentEffet(slup, "force", 0.15);
			
		}
		if(main.getCampsDemonVie().contains(Roles.DEMON)) {
			
			Player demon = main.getPlayerByRole(Roles.DEMON);
			
			if(main.getEffetDemon() == "speed") {
				
				demon.removePotionEffect(PotionEffectType.SPEED);
					
			}
			else {
					
				main.removePourcentEffet(demon, "force", 0.15);
					
			}
			
		}
		if(main.getCampsDemonVie().contains(Roles.TRIAL)) {
			
			Player trial = main.getPlayerByRole(Roles.TRIAL);
			
			trial.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 0, false, false));
			trial.removePotionEffect(PotionEffectType.SPEED);
				
		}
		if(main.getCampsDemonVie().contains(Roles.MALEDICTION)) {
			
			Player malediction = main.getPlayerByRole(Roles.MALEDICTION);
			
			main.removePourcentEffet(malediction, "force", 0.15);
				
		}
		if(main.getCampsDemonVie().contains(Roles.SANG)) {
			
			Player sang = main.getPlayerByRole(Roles.SANG);
			
			main.removePourcentEffet(sang, "force", 0.15);
				
		}
		if(main.getCampsDemonVie().contains(Roles.TENEBRE)) {
			
			Player tenebre = main.getPlayerByRole(Roles.TENEBRE);
			
			main.removePourcentEffet(tenebre, "force", 0.15);
			tenebre.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 99999, 0, false, false));
			tenebre.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			
		}
		if(main.getCampsDemonVie().contains(Roles.TRONCONEUSE)) {
			
			Player tronconeuse = main.getPlayerByRole(Roles.TRONCONEUSE);
			
			main.removePourcentEffet(tronconeuse, "force", 0.15);
				
		}
		if(main.getCampsDemonVie().contains(Roles.LOUP)) {
			
			Player loup = main.getPlayerByRole(Roles.LOUP);
			
			if(!main.isLoupPouvoir()) {
				main.removePourcentEffet(loup, "force", 0.15);
			}
				
		}
		
	}
	
	public static void obscurEau(Player obscur, Main main) {
		
		if(main.getInvOrbe().contains(Orbe.EAU)) {
			
			if(!main.getInvOrbeActif().contains(Orbe.EAU)) {
				
				main.addPourcentEffet(obscur, "speed", 0.05);
				
			}
			
			if(main.getOrbeArme("bottes") == Orbe.EAU && main.getOrbeArmeActif("bottes") != Orbe.EAU) {
				
				main.setOrbeArmeActif("bottes", Orbe.EAU);
				if(obscur.getInventory().getBoots().getType() != null) {
					
					ItemMeta epeeM = obscur.getInventory().getBoots().getItemMeta();
					epeeM.addEnchant(Enchantment.DEPTH_STRIDER, 2, false);
					ItemStack epee = obscur.getInventory().getBoots();
					epee.setItemMeta(epeeM);
					obscur.getInventory().setBoots(epee);
						
				}
				
			}
			if(main.getOrbeArme("plastron") == Orbe.EAU && main.getOrbeArmeActif("plastron") != Orbe.EAU) {
				
				main.setOrbeArmeActif("plastron", Orbe.EAU);
				
			}
			if(main.getOrbeArme("jambiere") == Orbe.EAU && main.getOrbeArmeActif("jambiere") != Orbe.EAU) {
				
				main.setOrbeArmeActif("jambiere", Orbe.EAU);
				
			}
			if(main.getOrbeArme("casque") == Orbe.EAU && main.getOrbeArmeActif("casque") != Orbe.EAU) {
				
				main.setOrbeArmeActif("casque", Orbe.EAU);
				
			}
			if(main.getOrbeArme("epee") == Orbe.EAU && main.getOrbeArmeActif("epee") != Orbe.EAU) {
				
				main.setOrbeArmeActif("epee", Orbe.EAU);
				
			}
			
		}
		else {
			
			if(main.getInvOrbeActif().contains(Orbe.EAU)) {
				
				main.removePourcentEffet(obscur, "speed", 0.05);
				
				if(main.getOrbeArme("bottes") != Orbe.EAU && main.getOrbeArmeActif("bottes") == Orbe.EAU) {
					
					main.setOrbeArmeActif("bottes", Orbe.NONE);
					if(obscur.getInventory().getBoots().getType() != null) {
						
						ItemMeta epeeM = obscur.getInventory().getBoots().getItemMeta();
						epeeM.removeEnchant(Enchantment.DEPTH_STRIDER);
						ItemStack epee = obscur.getInventory().getBoots();
						epee.setItemMeta(epeeM);
						obscur.getInventory().setBoots(epee);
							
					}
					
				}
				if(main.getOrbeArme("plastron") != Orbe.EAU && main.getOrbeArmeActif("plastron") == Orbe.EAU) {
					
					main.setOrbeArmeActif("plastron", Orbe.NONE);
					
				}
				if(main.getOrbeArme("jambiere") != Orbe.EAU && main.getOrbeArmeActif("jambiere") == Orbe.EAU) {
					
					main.setOrbeArmeActif("jambiere", Orbe.NONE);
					
				}
				if(main.getOrbeArme("casque") != Orbe.EAU && main.getOrbeArmeActif("casque") == Orbe.EAU) {
					
					main.setOrbeArmeActif("casque", Orbe.NONE);
					
				}
				if(main.getOrbeArme("epee") != Orbe.EAU && main.getOrbeArmeActif("epee") == Orbe.EAU) {
					
					main.setOrbeArmeActif("epee", Orbe.NONE);
					
				}
				
			}
			
		}
		
	}
	
	public static void obscurFeu(Player obscur, Main main) {
		
		if(!main.getInvOrbeActif().contains(Orbe.FEU)) {
			
			obscur.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 99999, 0, false, false));
			
		}
		
		if(main.getInvOrbe().contains(Orbe.FEU)) {
			
			if(main.getOrbeArme("bottes") == Orbe.FEU && main.getOrbeArmeActif("bottes") != Orbe.FEU) {
				
				main.setOrbeArmeActif("bottes", Orbe.FEU);
				
			}
			if(main.getOrbeArme("plastron") == Orbe.FEU && main.getOrbeArmeActif("plastron") != Orbe.FEU) {
				
				main.setOrbeArmeActif("plastron", Orbe.FEU);
				
			}
			if(main.getOrbeArme("jambiere") == Orbe.FEU && main.getOrbeArmeActif("jambiere") != Orbe.FEU) {
				
				main.setOrbeArmeActif("jambiere", Orbe.FEU);
				
			}
			if(main.getOrbeArme("casque") == Orbe.FEU && main.getOrbeArmeActif("casque") != Orbe.FEU) {
				
				main.setOrbeArmeActif("casque", Orbe.FEU);
				
			}
			if(main.getOrbeArme("epee") == Orbe.FEU && main.getOrbeArmeActif("epee") != Orbe.FEU) {
				
				main.setOrbeArmeActif("epee", Orbe.FEU);
				
			}
			
		}
		else {
			
			if(main.getInvOrbeActif().contains(Orbe.FEU)) {
				
				obscur.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				
				if(main.getOrbeArme("bottes") != Orbe.FEU && main.getOrbeArmeActif("bottes") == Orbe.FEU) {
					
					main.setOrbeArmeActif("bottes", Orbe.NONE);
					
				}
				if(main.getOrbeArme("plastron") != Orbe.FEU && main.getOrbeArmeActif("plastron") == Orbe.FEU) {
					
					main.setOrbeArmeActif("plastron", Orbe.NONE);
					
				}
				if(main.getOrbeArme("jambiere") != Orbe.FEU && main.getOrbeArmeActif("jambiere") == Orbe.FEU) {
					
					main.setOrbeArmeActif("jambiere", Orbe.NONE);
					
				}
				if(main.getOrbeArme("casque") != Orbe.FEU && main.getOrbeArmeActif("casque") == Orbe.FEU) {
					
					main.setOrbeArmeActif("casque", Orbe.NONE);
					
				}
				if(main.getOrbeArme("epee") != Orbe.FEU && main.getOrbeArmeActif("epee") == Orbe.FEU) {
					
					main.setOrbeArmeActif("epee", Orbe.NONE);
					
				}
				
			}
			
		}
		
	}
	
	public static void obscurFoudre(Player obscur, Main main) {
		
		if(main.getInvOrbe().contains(Orbe.FOUDRE)) {
			
			if(!main.getInvOrbeActif().contains(Orbe.EAU)) {
				
				main.addPourcentEffet(obscur, "force", 0.05);
				
			}
			
			if(main.getOrbeArme("bottes") == Orbe.FOUDRE && main.getOrbeArmeActif("bottes") != Orbe.FOUDRE) {
				
				main.setOrbeArmeActif("bottes", Orbe.FOUDRE);
				obscur.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0, false, false));
				
			}
			if(main.getOrbeArme("plastron") == Orbe.FOUDRE && main.getOrbeArmeActif("plastron") != Orbe.FOUDRE) {
				
				main.setOrbeArmeActif("plastron", Orbe.FOUDRE);
				if(obscur.getInventory().getChestplate().getType() != null) {
					
					ItemMeta epeeM = obscur.getInventory().getChestplate().getItemMeta();
					epeeM.addEnchant(Enchantment.THORNS, 3, false);
					ItemStack epee = obscur.getInventory().getChestplate();
					epee.setItemMeta(epeeM);
					obscur.getInventory().setChestplate(epee);
						
				}
				
			}
			if(main.getOrbeArme("jambiere") == Orbe.FOUDRE && main.getOrbeArmeActif("jambiere") != Orbe.FOUDRE) {
				
				main.setOrbeArmeActif("jambiere", Orbe.FOUDRE);
				
			}
			if(main.getOrbeArme("casque") == Orbe.FOUDRE && main.getOrbeArmeActif("casque") != Orbe.FOUDRE) {
				
				main.setOrbeArmeActif("casque", Orbe.FOUDRE);
				
			}
			if(main.getOrbeArme("epee") == Orbe.FOUDRE && main.getOrbeArmeActif("epee") != Orbe.FOUDRE) {
				
				main.setOrbeArmeActif("epee", Orbe.FOUDRE);
				
			}
			
		}
		else {
			
			main.addPourcentEffet(obscur, "force", 0.05);
			
			if(main.getInvOrbeActif().contains(Orbe.FOUDRE)) {
				
				if(main.getOrbeArme("bottes") != Orbe.FOUDRE && main.getOrbeArmeActif("bottes") == Orbe.FOUDRE) {
					
					main.setOrbeArmeActif("bottes", Orbe.NONE);
					obscur.removePotionEffect(PotionEffectType.SPEED);
					
				}
				if(main.getOrbeArme("plastron") != Orbe.FOUDRE && main.getOrbeArmeActif("plastron") == Orbe.FOUDRE) {
					
					main.setOrbeArmeActif("plastron", Orbe.NONE);
					if(obscur.getInventory().getChestplate().getType() != null) {
						
						ItemMeta epeeM = obscur.getInventory().getChestplate().getItemMeta();
						epeeM.removeEnchant(Enchantment.THORNS);
						ItemStack epee = obscur.getInventory().getChestplate();
						epee.setItemMeta(epeeM);
						obscur.getInventory().setChestplate(epee);
							
					}
					
				}
				if(main.getOrbeArme("jambiere") != Orbe.FOUDRE && main.getOrbeArmeActif("jambiere") == Orbe.FOUDRE) {
					
					main.setOrbeArmeActif("jambiere", Orbe.NONE);
					
				}
				if(main.getOrbeArme("casque") != Orbe.FOUDRE && main.getOrbeArmeActif("casque") == Orbe.FOUDRE) {
					
					main.setOrbeArmeActif("casque", Orbe.NONE);
					
				}
				if(main.getOrbeArme("epee") != Orbe.FOUDRE && main.getOrbeArmeActif("epee") == Orbe.FOUDRE) {
					
					main.setOrbeArmeActif("epee", Orbe.NONE);
					
				}
				
			}
			
		}
		
	}
	
	public static void obscurGlace(Player obscur, Main main) {
		
		if(main.getInvOrbe().contains(Orbe.GLACE)) {
			
			if(!main.getInvOrbeActif().contains(Orbe.EAU)) {
				
				main.addPourcentEffet(obscur, "resi", 0.05);
				
			}
			
			if(main.getOrbeArme("bottes") == Orbe.GLACE && main.getOrbeArmeActif("bottes") != Orbe.GLACE) {
				
				main.setOrbeArmeActif("bottes", Orbe.GLACE);
				main.addPourcentEffet(obscur, "speed", 0.05);
				
			}
			if(main.getOrbeArme("plastron") == Orbe.GLACE && main.getOrbeArmeActif("plastron") != Orbe.GLACE) {
				
				main.setOrbeArmeActif("plastron", Orbe.GLACE);
				
			}
			if(main.getOrbeArme("jambiere") == Orbe.GLACE && main.getOrbeArmeActif("jambiere") != Orbe.GLACE) {
				
				main.setOrbeArmeActif("jambiere", Orbe.GLACE);
				
			}
			if(main.getOrbeArme("casque") == Orbe.GLACE && main.getOrbeArmeActif("casque") != Orbe.GLACE) {
				
				main.setOrbeArmeActif("casque", Orbe.GLACE);
				
			}
			if(main.getOrbeArme("epee") == Orbe.GLACE && main.getOrbeArmeActif("epee") != Orbe.GLACE) {
				
				main.setOrbeArmeActif("epee", Orbe.GLACE);
				
			}
			
		}
		else {
			
			main.removePourcentEffet(obscur, "resi", 0.05);
			
			if(main.getInvOrbeActif().contains(Orbe.GLACE)) {
				
				if(main.getOrbeArme("bottes") != Orbe.GLACE && main.getOrbeArmeActif("bottes") == Orbe.GLACE) {
					
					main.setOrbeArmeActif("bottes", Orbe.NONE);
					main.removePourcentEffet(obscur, "speed", 0.05);
					
				}
				if(main.getOrbeArme("plastron") != Orbe.GLACE && main.getOrbeArmeActif("plastron") == Orbe.GLACE) {
					
					main.setOrbeArmeActif("plastron", Orbe.NONE);
					
				}
				if(main.getOrbeArme("jambiere") != Orbe.GLACE && main.getOrbeArmeActif("jambiere") == Orbe.GLACE) {
					
					main.setOrbeArmeActif("jambiere", Orbe.NONE);
					
				}
				if(main.getOrbeArme("casque") != Orbe.GLACE && main.getOrbeArmeActif("casque") == Orbe.GLACE) {
					
					main.setOrbeArmeActif("casque", Orbe.NONE);
					
				}
				if(main.getOrbeArme("epee") != Orbe.GLACE && main.getOrbeArmeActif("epee") == Orbe.GLACE) {
					
					main.setOrbeArmeActif("epee", Orbe.NONE);
					
				}
				
			}
			
		}
		
	}

}