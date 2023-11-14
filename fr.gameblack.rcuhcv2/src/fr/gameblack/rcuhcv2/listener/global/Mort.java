package fr.gameblack.rcuhcv2.listener.global;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.gameblack.rcuhcv2.Main;
import fr.gameblack.rcuhcv2.classes.Joueur;
import fr.gameblack.rcuhcv2.classes.Pouvoirs;
import fr.gameblack.rcuhcv2.classes.Roles;
import fr.gameblack.rcuhcv2.classes.v1.Pouvoirs_GB;
import fr.gameblack.rcuhcv2.roles.v2.staff.Trial;
import fr.gameblack.rcuhcv2.task.v2.ItemCD;

public class Mort {
	
	public static void setMort(Joueur joueur, Joueur tueur, EntityDamageByEntityEvent event, Main main) {
		
		tueur.addKill();
		
		if(main.getVersion() == 1) {
			
			setMortV1(joueur, tueur, event, main);
			
		}
		else if(main.getVersion() == 2) {
			
			setMortV2(joueur, tueur, event, main);
			
		}
		
	}
	
	public static void setMortV1(Joueur joueur, Joueur tueur, EntityDamageByEntityEvent event, Main main) {
		
		if(tueur.getRole() == Roles.GameBlack && tueur.getPouvoirGB() == Pouvoirs_GB.POURCENT && (joueur.getCamp().equalsIgnoreCase("demon") || joueur.getCamp().equalsIgnoreCase("solo")) && joueur.getGBPourcent() >= 100) {
			
			tueur.addSpeed(0.05);
			
		}
		
		if(tueur.getRole() == Roles.Tenebre) {
			
			tueur.addForce(0.03);
			
		}
		
		if(tueur.getRole() == Roles.Experimental) {
			
			tueur.addSpeed(0.05);
			
		}
		
		if(joueur.getRole() == Roles.Raptor && tueur.getRole() == Roles.Trial) {
			
			tueur.addResi(main.getResiIBaseV1());
			
		}
		
		if(joueur.getRole() == Roles.Kzou && tueur.getRole() == Roles.Trial) {
			
			tueur.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
			
		}
		
		if(tueur.getRole() == Roles.Trial) {
			
			tueur.getPlayer().setMaxHealth(tueur.getPlayer().getMaxHealth()+1);
			
		}
		
		if(main.getJoueurByRole(Roles.GameBlack) != null && main.getJoueurByRole(Roles.GameBlack).getPouvoirGB() == Pouvoirs_GB.INVISIBLE && main.getJoueurByRole(Roles.GameBlack).isInvisible()) {
			
			Joueur gb = main.getJoueurByRole(Roles.GameBlack);
			
			List<Joueur> joueurs = new ArrayList<>();
			
			for(Joueur j : main.getJoueurInGame()) {
				
				if(j.getRole() != Roles.GameBlack && j != tueur && j != joueur) {
					
					joueurs.add(j);
					
				}
				
			}
			
			if(joueurs.size() >= 5) {
				
		        Random r = new Random();
		        
		        int nb = r.nextInt(joueurs.size()-1);
		        Joueur j1 = joueurs.get(nb);
		        joueurs.remove(j1);
		        
		        nb = r.nextInt(joueurs.size()-1);
		        Joueur j2 = joueurs.get(nb);
		        joueurs.remove(j2);
		        
		        nb = r.nextInt(joueurs.size()-1);
		        Joueur j3 = joueurs.get(nb);
		        joueurs.remove(j3);
		        
		        nb = r.nextInt(joueurs.size()-1);
		        Joueur j4 = joueurs.get(nb);
		        joueurs.remove(j4);
		        
		        int nbtxt = r.nextInt(5);
		        if(nbtxt == 1) {
		        	
		        	gb.getPlayer().sendMessage("Le tueur de " + joueur.getPlayer().getName() + " est un joueur parmis les suivant : " + tueur.getPlayer().getName() + ", " + j1.getPlayer().getName() + ", " + j2.getPlayer().getName() + ", " + j3.getPlayer().getName() + ", " + j4.getPlayer().getName());
		        	
		        }
		        else if(nbtxt == 2) {
		        	
		        	gb.getPlayer().sendMessage("Le tueur de " + joueur.getPlayer().getName() + " est un joueur parmis les suivant : " + j1.getPlayer().getName() + ", " + tueur.getPlayer().getName() + ", " + j2.getPlayer().getName() + ", " + j3.getPlayer().getName() + ", " + j4.getPlayer().getName());
		        	
		        }
		        else if(nbtxt == 3) {
		        	
		        	gb.getPlayer().sendMessage("Le tueur de " + joueur.getPlayer().getName() + " est un joueur parmis les suivant : " + j1.getPlayer().getName() + ", " + j2.getPlayer().getName() + ", " + tueur.getPlayer().getName() + ", " + j3.getPlayer().getName() + ", " + j4.getPlayer().getName());
		        	
		        }
		        else if(nbtxt == 4) {
		        	
		        	gb.getPlayer().sendMessage("Le tueur de " + joueur.getPlayer().getName() + " est un joueur parmis les suivant : " + j1.getPlayer().getName() + ", " + j2.getPlayer().getName() + ", " + j3.getPlayer().getName() + ", " + tueur.getPlayer().getName() + ", " + j4.getPlayer().getName());
		        	
		        }
		        else {
		        	
		        	gb.getPlayer().sendMessage("Le tueur de " + joueur.getPlayer().getName() + " est un joueur parmis les suivant : " + j1.getPlayer().getName() + ", " + j2.getPlayer().getName() + ", " + j3.getPlayer().getName() + ", " + j4.getPlayer().getName() + ", " + tueur.getPlayer().getName());
		        	
		        }
				
			}
			
		}
		
		if(main.getJoueurByRole(Roles.GameBlack) != null && main.getJoueurByRole(Roles.GameBlack).getPouvoirGB() == Pouvoirs_GB.FLAIR && joueur == main.getFlairGB()) {
			
			main.getJoueurByRole(Roles.GameBlack).addSpeed(0.02);
			joueur.setFlairGB(false);
			main.getJoueurByRole(Roles.GameBlack).setFlairGB(true);
			main.getJoueurByRole(Roles.GameBlack).getPlayer().sendMessage("Le tueur de " + joueur.getPlayer().getName() + " possède le rôle " + tueur.getRole().getTxt());
			
		}
		
		if(tueur.getRole() == Roles.Malediction) {
			
			if(tueur.getPlayer().getMaxHealth() <= 21) {
				
				tueur.getPlayer().setMaxHealth(tueur.getPlayer().getMaxHealth()+3);
				
			}
			else {
				
				tueur.getPlayer().setMaxHealth(24);
				
			}
			
		}
		
		if(tueur.getRole() == Roles.GameBlack && tueur.getPouvoirGB() == Pouvoirs_GB.SPEED) {
			
			main.setGbKill(joueur);
			tueur.getPlayer().sendMessage("Vous venez de faire un kill, vous pouvez utiliser la commande /rcchoose <coeur|effet> afin de récupérer un bonus");
			
		}
		
		if(joueur.getCamp().equalsIgnoreCase("rc") && joueur.isProcheNb(Roles.GameBlack, main, 50)) {
			
			main.getJoueurByRole(Roles.GameBlack).addSpeed(0.05);
			
		}
		
		if(tueur.getRole() == Roles.Loup && tueur.getSpeed() + 5 <= 125) {
			
			tueur.getPlayer().sendMessage("Vous recevez 5% de speed supplémentaire grâce à votre kill");
			tueur.addSpeed(0.05);
			
		}
		else if(tueur.getRole() == Roles.Loup && tueur.getSpeed() + 5 < 130) {
			
			tueur.getPlayer().sendMessage("Vous avez atteint votre limite de speed, vous avez donc 25% de speed supplémentaire");
			tueur.setSpeedInt(125);
			
		}
		
		if(main.getJoueurByRole(Roles.Joko) != null) {
			
			if(joueur.getRole() == Roles.Team || joueur.getRole() == Roles.Maka || joueur.getRole() == Roles.Loup || joueur.getRole() == Roles.Trial || joueur.getRole() == Roles.Farmeurimmo) {
				
				main.getJoueurByRole(Roles.Joko).getPlayer().sendMessage("Un membre du staff vient de mourir, vous recevez donc 3% de force supplémentaire");
				main.getJoueurByRole(Roles.Joko).addForce(0.03);
				
			}
			else if(joueur.getRole() == Roles.GameBlack) {
				
				main.getJoueurByRole(Roles.Joko).getPlayer().sendMessage("GameBlack vient de mourrir, vous recevez donc 5% de force et de résistance supplémentaire");
				main.getJoueurByRole(Roles.Joko).addForce(0.05);
				main.getJoueurByRole(Roles.Joko).addResi(0.05);
				
			}
			
		}
		
	}

	public static void setMortV2(Joueur joueur, Joueur tueur, EntityDamageByEntityEvent event, Main main) {
		
		if(tueur.getRole() == Roles.TOINOU) {
			
			tueur.addPoint();
			
		}
		
		if(tueur.getRole() == Roles.HEKOW && tueur.isHekowJeuActif()) {
			
			tueur.addHekowPourcent(15);
			
		}
		
		if(joueur.isProche(Roles.TEAM, main) && (joueur.getCamp().equalsIgnoreCase("staff") || joueur.getRole() == Roles.GAMEBLACK || joueur.getRole() == Roles.TRIAL)) {
			
			Random r = new Random();
            int nb = r.nextInt(3);
            
            if(nb == 1) {
            	
            	main.getJoueurByRole(Roles.TEAM).addForce(0.01);
            	main.getJoueurByRole(Roles.TEAM).getPlayer().sendMessage("Un joueur du staff vient de mourir dans un rayon de 20 blocs, vous recevez donc 1% de force");
            	
            }
            else if(nb == 2) {
            	
            	main.getJoueurByRole(Roles.TEAM).addResi(0.01);
            	main.getJoueurByRole(Roles.TEAM).getPlayer().sendMessage("Un joueur du staff vient de mourir dans un rayon de 20 blocs, vous recevez donc 1% de résistance");
            	
            }
            else {
            	
            	main.getJoueurByRole(Roles.TEAM).addSpeed(0.02);
            	main.getJoueurByRole(Roles.TEAM).getPlayer().sendMessage("Un joueur du staff vient de mourir dans un rayon de 20 blocs, vous recevez donc 2% de speed");
            	
            }
			
		}
		
		if(main.getJoueurByRole(Roles.GAMEBLACK) != null) {
        	
        	Joueur gb = main.getJoueurByRole(Roles.GAMEBLACK);
        	
        	if(joueur == gb && tueur == main.getMaledictionGyomei()) {
        		
        		tueur.addForce(0.02);
        		
        	}
        	
        	Random r = new Random();
            int nb = r.nextInt(100);
        	
        	if(main.getJoueurByRole(Roles.GAMEBLACK).isConsoleGBActif()) {
	            
	            if(nb <= 10) {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE] " + ChatColor.MAGIC + "aaaaa" + ChatColor.RESET + " vient de tuer " + ChatColor.MAGIC + "aaaaa");
	            	
	            }
	            else {
	            	
	            	gb.getPlayer().sendMessage("[CONSOLE] " + tueur.getPlayer().getName() + " vient de tuer " + joueur.getPlayer().getName());
	            	
	            }
	            
        	}
        	
        }
		
		if(tueur.getRole() == Roles.SLUP) {
			
			tueur.addSlime(4);
			
		}
		
		if(tueur.getRole() == Roles.NONOBOY && !tueur.getCamp().equalsIgnoreCase("farmeurimmo")) {
			
			if(tueur.getPlayer().getMaxHealth() <= 21) {
				
				tueur.getPlayer().setMaxHealth(tueur.getPlayer().getMaxHealth()+3);
				
			}
			else {
				
				tueur.getPlayer().setMaxHealth(24);
				
			}
			
		}
		
		if(main.getNeko() != null && joueur.getRole() == Roles.MAKA && !main.getNeko().isMort()) {
			
			if(main.getNbJoueursStaff() == 6) {
    			main.getNeko().addSpeed(0.01);
    		}
    		else if(main.getNbJoueursStaff() == 5) {
    			main.getNeko().addForce(0.01);
    		}
    		else if(main.getNbJoueursStaff() == 4) {
    			main.getNeko().addSpeed(0.05);
    		}
    		else if(main.getNbJoueursStaff() == 3) {
    			main.getNeko().addSpeed(0.05);
    			main.getNeko().addForce(0.01);
    		}
    		else if(main.getNbJoueursStaff() == 2) {
    			main.getNeko().addSpeed(0.07);
    			main.getNeko().addForce(0.01);
    		}
    		else if(main.getNbJoueursStaff() == 1) {
    			main.getNeko().addSpeed(0.07);
    			main.getNeko().addForce(0.02);
    		}
			
		}
		
		if(main.getTueurNeko() == joueur && tueur.getRole() == Roles.MAKA) {
			
			if(tueur.getPlayer().getMaxHealth() <= 18) {
				
				tueur.getPlayer().setMaxHealth(18);
				
			}
				
			main.setTueurNeko(null);
			if(main.getNbJoueursStaff() == 6) {
	    		tueur.addSpeed(0.01);
	    		tueur.addForce(0.01);
	    		tueur.addResi(0.01);
	    	}
			else if(main.getNbJoueursStaff() == 5) {
				tueur.addSpeed(0.03);
	    		tueur.addForce(0.01);
	    		tueur.addResi(0.01);
	    	}
	    	else if(main.getNbJoueursStaff() == 4) {
	    		tueur.addSpeed(0.07);
	    		tueur.addForce(0.01);
	    		tueur.addResi(0.01);
	    	}
	    	else if(main.getNbJoueursStaff() == 3) {
	    		tueur.addSpeed(0.07);
	    		tueur.addForce(0.02);
	    		tueur.addResi(0.01);
	    	}
	    	else if(main.getNbJoueursStaff() == 2) {
	    		tueur.addSpeed(0.1);
	    		tueur.addForce(0.02);
	    		tueur.addResi(0.02);
	    	}
	    	else if(main.getNbJoueursStaff() == 1) {
	    		tueur.addSpeed(0.15);
	    		tueur.addForce(0.02);
	    		tueur.addResi(0.02);
	    	}
			
		}
		
		if(main.getJoueurByRole(Roles.MAKA) != null && main.getNeko() == joueur) {
			
			Joueur maka = main.getJoueurByRole(Roles.MAKA);
			
			main.setTueurNeko(tueur);
			
			maka.getPlayer().sendMessage("Neko vient de mourrir, vous perdrez donc 1 coeur permanent toutes les 5 minutes");
			
			ItemCD cycle = new ItemCD(main, maka, "mortNeko", 30, maka, null, null, 0, null);
	        cycle.runTaskTimer(main, 0, 20);
			
		}
		
		if(main.getJoueurByRole(Roles.OBSCUR) != null && joueur == main.getTueurToinou()) {
			
			Joueur obscur = main.getJoueurByRole(Roles.OBSCUR);
			
			if(main.isAdaptionObscurActif()) {
				
				obscur.addForce(0.01);
				
			} else {
				
				obscur.addForce(0.02);
				
			}
			obscur.setTueurToinouKill(true);
			
		}
		
		if(main.getJoueurByRole(Roles.OBSCUR) != null && joueur.getRole() == Roles.TOINOU) {
			
			Joueur obscur = main.getJoueurByRole(Roles.OBSCUR);
			obscur.getPlayer().sendMessage(tueur.getPlayer().getName() + " vient de tuer Toinou. Si vous parvenez à l'éliminer, vous obtiendrez 2% de force permanent");
			
		}
		
		if(joueur.getRole() == Roles.LOUP && main.getJoueurByRole(Roles.TRIAL) != null) {
			
			if(tueur.getCamp().equalsIgnoreCase("uhc")) {
				
				Joueur trial = main.getJoueurByRole(Roles.TRIAL);
				
				Joueur slup = main.getJoueurByRole(Roles.SLUP);
				
				if(trial.getCamp() == "duo" || (slup != null && slup.getPacteSlup() == 2 && ((main.getTemps() <= 600 && main.getEpisode() <= 3 && main.getMode() == "normal") || (main.getEpisode() < 2 && main.getMode() == "rapide")))) {
					
					if(trial.getCamp() == "duo") {
						
						trial.getPlayer().sendMessage("Un joueur du camp UHC vient de tuer Loup. Voici son pseudo : " + tueur.getPlayer().getName());
						tueur.getPlayer().sendMessage("Trial vient de rejoindre votre camp. Pseudo de Trial : " + trial.getPlayer().getName());
						
					}
					else {
						
						trial.getPlayer().sendMessage("Loup vient de mourir. Vous devez désormais gagner avec Slup. Le tueur de Loup appartient au camp uhc, voici son pseudo : " + tueur.getPlayer().getName());
						trial.setCamp("duo");
						
					}
					
				}
				else {
					
					trial.setCamp("uhc");
					trial.getPlayer().sendMessage("Un joueur du camp UHC vient de tuer Loup. Vous devez donc gagnez avec le camp UHC\nPseudo du tueur de Loup : " + tueur.getPlayer().getName());
					tueur.getPlayer().sendMessage("Trial vient de rejoindre votre camp. Pseudo de Trial : " + trial.getPlayer().getName());
					
				}
				
			}
			
			
		}
		
		if(tueur.getRole() == Roles.FARMEURIMMO && tueur.getVol().contains(Pouvoirs.TRIAL_FORCE_KILL)) {
			
			tueur.addForce(0.02);
			
		}
		
		if(tueur.getRole() == Roles.FARMEURIMMO && tueur.getVol().contains(Pouvoirs.NONOBOY_COEUR_KILL)) {
			
			tueur.getPlayer().setMaxHealth(tueur.getPlayer().getMaxHealth()+1);
			
		}
		
		if(tueur.getRole() == Roles.TRIAL) {
			
			if(tueur.getModeTrial(main) == "serieux") {
			
				tueur.addForce(0.02);
				
				if(tueur.getCamp() == "duo" && main.getJoueurByRole(Roles.SLUP) != null) {
					
					Joueur slup = main.getJoueurByRole(Roles.SLUP);
					
					slup.addForce(0.02);
					
				}
				
			}
			
		}
		if(joueur.isBonPapiers() && tueur.getRole() != Roles.TRIAL && tueur.getRole() != Roles.MAKA && tueur.getRole() != Roles.MALIVOL) {
			
			tueur.setBonPapiers(true);
			
		}
		else if(!joueur.isBonPapiers()) {
			
			tueur.setBonPapiers(false);
			
		}
		
	}
	
}