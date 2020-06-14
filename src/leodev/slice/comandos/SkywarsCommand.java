package leodev.slice.comandos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import leodev.slice.Loader;
import leodev.slice.apis.Mensagens;
import leodev.slice.apis.SkywarsAPI;
import leodev.slice.enums.Estado;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.element.ElementDropdown;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementSlider;
import cn.nukkit.form.element.ElementStepSlider;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.response.FormResponseCustom;
import cn.nukkit.form.response.FormResponseSimple;
import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.Item;
import cn.nukkit.level.Level;
import cn.nukkit.utils.ConfigSection;

public class SkywarsCommand extends Command implements Listener{
	
	private Loader pl;

	public SkywarsCommand(Loader pl){
		super("sw");
		this.pl = pl;
		this.pl.getServer().getPluginManager().registerEvents(this, this.pl);
	}
	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(args.length == 0){
				p.sendMessage(Mensagens.COMANDO_INVALIDO);
				if(p.isOp()){
					FormWindowSimple simple = new FormWindowSimple(Mensagens.FORM_NAME_STAFF, Mensagens.FORM_STAFF_CONTENT);
					simple.addButton(new ElementButton(Mensagens.FORM_CREATE_BUTTON_NAME));
					simple.addButton(new ElementButton(Mensagens.FORM_SET_SPAWNS_BUTTON_NAME));
					simple.addButton(new ElementButton(Mensagens.FORM_STAFF_PLAY_BUTTON));
					simple.addButton(new ElementButton(Mensagens.FORM_WAIT_AREA_SET));
					p.showFormWindow(simple);
				}else {
				FormWindowSimple simple = new FormWindowSimple(Mensagens.FORM_NAME_PLAYER, Mensagens.FORM_PLAYER_CONTENT);
				for(SkywarsAPI sky : this.pl.salas){
					this.pl.getServer().getConsoleSender().sendMessage("" + sky.getConfigurada());
    					String msg = "§f" + sky.getName();
    					if(sky.getState().equals(Estado.ESPERANDO)){
    					if(sky.getC().exists("Configurada") && sky.getC().getInt("Configurada") != 0 || sky.getC().get("Configurada") != "0")
    					if(sky.getConfigurada() != 0)
    					 msg = "§a" + sky.getName();
    					}else if(sky.getState().equals(Estado.EM_JOGO)){
    							msg = "§4" + sky.getName();
                  	}else if(sky.getState().equals(Estado.RESETANDO)){
                  		msg = "§6" + sky.getName();
                  	}else if(sky.getConfigurada() == 0){
                  		msg = "§c" + sky.getName();
                  	}else{
                  		msg = null;
                  	}
    					if(msg != null){
	                    ElementButton button = new ElementButton(msg);
	                    Player player = (Player)sender;
	                    simple.addButton(button);
    					}
				}
				 ((Player) sender).showFormWindow(simple);
				}
			}/*else {
			if(args[0].equals("criar")){
				if(!args[1].isEmpty()){
					if(this.pl.getSkywars(args[1]) == null){
						SkywarsAPI sky = new SkywarsAPI(this.pl, args[1]);
						p.sendMessage(String.format(Mensagens.ARENA_CRIADA, args[1]));
						this.pl.salas.add(sky);
					}else {
						p.sendMessage(Mensagens.ARENA_JA_EXISTE);
					}
				}else {
					p.sendMessage(Mensagens.COMANDO_INVALIDO);
				}
				
				
			}else if(args[0].equals("setspawns")){
					if(!args[1].isEmpty()){
						if(p.isOp()){
							if(this.pl.getSkywars(args[1]) != null){
								p.sendMessage(args[1]);
								SkywarsAPI sky = this.pl.getSkywars(args[1]);
								if(sky.setSpawns(p.getLocation()) == true){
									p.sendMessage("Sucesso §c" + sky.getSpawns().size() + " / " + sky.getMaxPlayers());
									}else {
										p.sendMessage("maximo");
									}
							}else {
								p.sendMessage("False");
							}
						}
					}else {
						p.sendMessage(Mensagens.COMANDO_INVALIDO);
					}
				}else if(args[0].equals("entrar")){
					Integer joined = 0;
					if(!this.pl.salas.isEmpty()){
						for(SkywarsAPI sky : this.pl.salas){
							if(sky.getState().equals(Estado.ESPERANDO)){
								if(sky.getPlayers().containsKey(p)){
									p.sendMessage("A");
									joined = 1;
								}else {
									if(joined == 0){
								sky.join(p);
								joined = 1;
									}
								}
							}
						}
					}
				}else if(args[0].equals("setwaitarea")){
					if(p.isOp()){
						double x = p.getX();
						double y = p.getY();
						double z = p.getZ();
						String level = p.getLevel().getName();
						
						ConfigSection sec = new ConfigSection();
						sec.put("X", x);
						sec.put("Y", y);
						sec.put("Z", z);
						sec.put("Level", level);
						this.pl.configs.set("WaitArea", sec);
						this.pl.configs.save();
						p.sendMessage(Mensagens.WAIT_AREA_SUCESS_SET);
					}*/
		}
		return false;
	}
	 @EventHandler(priority = EventPriority.HIGH)
	    public void onModal(PlayerFormRespondedEvent event)
	    {
	        Player player = event.getPlayer();
	        FormWindow window = event.getWindow();
	        if (event.getResponse() == null) return;
	        if (window instanceof FormWindowSimple)
	        {
            	FormResponseSimple response = (FormResponseSimple) event.getResponse();
            	String text = response.getClickedButton().getText();
	            switch (((FormWindowSimple) window).getTitle())
	            {
	            
	            case Mensagens.FORM_NAME_STAFF:
	            	if(text.equals(Mensagens.FORM_CREATE_BUTTON_NAME)){
	            		FormWindowCustom custom = new FormWindowCustom(Mensagens.FORM_CREATE_NAME);
	            		List<String> steps = new ArrayList<>();
	            		for(Level lvl : this.pl.getServer().getLevels().values()){
	            			steps.add(lvl.getName() + "");
	            			pl.getServer().loadLevel(lvl.getName());
	            		}
	            		custom.addElement(new ElementToggle(Mensagens.FORM_ACTIVATE_WORLD_TP));
						custom.addElement(new ElementDropdown(Mensagens.FORM_WORLD_TP, steps));
	            		custom.addElement(new ElementInput(Mensagens.FORM_CREATE_ARENA, Mensagens.FORM_CREATE_PLACEHOLDER));
	            		custom.addElement(new ElementSlider(Mensagens.FORM_STAFF_CREATE_MAX_PLAYER, 1, 16, 1, 12));
	            		player.showFormWindow(custom);
	            		
	            	}else if(text.equals(Mensagens.FORM_STAFF_PLAY_BUTTON)){
	            		FormWindowSimple simple = new FormWindowSimple(Mensagens.FORM_NAME_PLAYER, Mensagens.FORM_PLAYER_CONTENT);
	    				for(SkywarsAPI sky : this.pl.salas){
	    					String msg = "§f" + sky.getName();
	    					if(sky.getState().equals(Estado.ESPERANDO)){
	        					if(sky.getC().exists("Configurada") && sky.getC().getInt("Configurada") != 0 || sky.getC().get("Configurada") != "0")
	        					if(sky.getConfigurada() != 0)
	        					 msg = "§a" + sky.getName();
	        					}else if(sky.getState().equals(Estado.EM_JOGO)){
	        							msg = "§4" + sky.getName();
	                      	}else if(sky.getState().equals(Estado.RESETANDO)){
	                      		msg = "§6" + sky.getName();
	                      	}else if(sky.getConfigurada() == 0){
	                      		msg = "§c" + sky.getName();
	                      	}else{
	                      		msg = null;
	                      	}
	        					if(msg != null){
	    	                    ElementButton button = new ElementButton(msg);
	    	                    simple.addButton(button);
	        					}
	    				}
	    				 player.showFormWindow(simple);
	    				 
	            	}else if(text.equals(Mensagens.FORM_SET_SPAWNS_BUTTON_NAME)){
	            		FormWindowSimple simple = new FormWindowSimple(Mensagens.FORM_STAFF_SETSPAWNS_OPEN_NAME, Mensagens.FORM_STAFF_SETSPAWNS_OPEN_CONTENT);
	            		for(SkywarsAPI sky : this.pl.salas){
	            			if(sky.getState().equals(Estado.ESPERANDO) || sky.getState() == null){
	            				if(sky.getConfigurada() == 0)
	            				simple.addButton(new ElementButton(sky.getName()));
	            			}
	            		}
	            		 player.showFormWindow(simple);
	            	}else if(text.equals(Mensagens.FORM_WAIT_AREA_SET)){
	            		FormWindowSimple simple = new FormWindowSimple(Mensagens.FORM_WAIT_AREA_SET, Mensagens.FORM_WAIT_AREA_SET);
	            		for(SkywarsAPI sky : this.pl.salas){
	            			if(sky.getState().equals(Estado.ESPERANDO) || sky.getState() == null){
	            				if(sky.getConfigurada() == 0 || sky.configurada == 0)
	            				simple.addButton(new ElementButton(sky.getName()));
	            			}
	            		}
	            		 player.showFormWindow(simple);
	            	}
                	break;
	            case Mensagens.FORM_STAFF_SETSPAWNS_OPEN_NAME:
	            	if(this.pl.getSkywars(text) != null){
	            		SkywarsAPI sky = this.pl.getSkywars(text);
	            		if(sky.getState().equals(Estado.ESPERANDO) || sky.getState() == null){
            				if(sky.getConfigurada() == 0){
            					if(this.pl.setingSpawns.containsKey(player)){
            						FormWindowSimple simple = new FormWindowSimple(Mensagens.FORM_STAFF_SETSPAWNS_OPEN_NAME, Mensagens.FORM_STAFF_SETSPAWNS_OPEN_CONTENT);
            	            		for(SkywarsAPI skys : this.pl.salas){
            	            			if(skys.getState().equals(Estado.ESPERANDO) || skys.getState() == null){
            	            				if(skys.getConfigurada() == 0)
            	            				simple.addButton(new ElementButton(skys.getName()));
            	            			}
            	            			 
            	            		}
            	            		player.showFormWindow(simple);
            					}else {
            						this.pl.setingSpawns.put(player, sky);
            						player.sendMessage(this.pl.setingSpawns.size() + "");
            						player.sendMessage(Mensagens.FORM_STAFF_SETSPAWNS_JOINED);
            						Item item = new Item(Item.STICK);
            						item.setCustomName("§a§lSETADOR DE SPAWNS");
            						player.getInventory().clearAll();
            						player.setGamemode(1);
            						player.getInventory().setItem(0, item);
            						
            					}
            				}
	            		}
	            	}
	            	break;
	            case Mensagens.FORM_NAME_PLAYER:
	            	if(text.startsWith("§a")){
                        if(this.pl.getSkywars(text.replaceAll("§a", "")) != null){
	            			SkywarsAPI api = this.pl.getSkywars(text.replaceAll("§a", ""));
	            			if(api.getState() != Estado.EM_JOGO && api.getState().equals(Estado.ESPERANDO)){
	            				api.join(player);
	            			}else {
	            				FormWindowSimple simple = new FormWindowSimple(Mensagens.FORM_NAME_PLAYER, Mensagens.FORM_PLAYER_CONTENT);
	    	    				for(SkywarsAPI sky : this.pl.salas){
	    	    					String msg = "§f" + sky.getName();
	    	    					if(sky.getState().equals(Estado.ESPERANDO)){
	    	        					if(sky.getC().exists("Configurada") && sky.getC().getInt("Configurada") != 0 || sky.getC().get("Configurada") != "0")
	    	        					if(sky.getConfigurada() != 0)
	    	        					 msg = "§a" + sky.getName();
	    	        					}else if(sky.getState().equals(Estado.EM_JOGO)){
	    	        							msg = "§4" + sky.getName();
	    	                      	}else if(sky.getState().equals(Estado.RESETANDO)){
	    	                      		msg = "§6" + sky.getName();
	    	                      	}else if(sky.getConfigurada() == 0){
	    	                      		msg = "§c" + sky.getName();
	    	                      	}else{
	    	                      		msg = null;
	    	                      	}
	    	        					if(msg != null){
	    	        					simple.setContent(Mensagens.FORM_CONTENT_ARENA_IS_IN_GAME);
	    	    	                    ElementButton button = new ElementButton(msg);
	    	    	                    simple.addButton(button);
	    	        					}
	    	    				}
	    	    				 player.showFormWindow(simple);
	            			}
	            		}else {
	            			FormWindowSimple simple = new FormWindowSimple(Mensagens.FORM_NAME_PLAYER, Mensagens.FORM_PLAYER_CONTENT);
    	    				for(SkywarsAPI sky : this.pl.salas){
    	    					String msg = "§f" + sky.getName();
    	    					if(sky.getState().equals(Estado.ESPERANDO)){
    	        					if(sky.getC().exists("Configurada") && sky.getC().getInt("Configurada") != 0 || sky.getC().get("Configurada") != "0")
    	        					if(sky.getConfigurada() != 0)
    	        					 msg = "§a" + sky.getName();
    	        					}else if(sky.getState().equals(Estado.EM_JOGO)){
    	        							msg = "§4" + sky.getName();
    	                      	}else if(sky.getState().equals(Estado.RESETANDO)){
    	                      		msg = "§6" + sky.getName();
    	                      	}else if(sky.getConfigurada() == 0){
    	                      		msg = "§c" + sky.getName();
    	                      	}else{
    	                      		msg = null;
    	                      	}
    	        					if(msg != null){
    	        					simple.setContent(Mensagens.FORM_CONTENT_ARENA_IS_IN_GAME);
    	    	                    ElementButton button = new ElementButton(msg);
    	    	                    simple.addButton(button);
    	        					}
    	    				}
    	    				 player.showFormWindow(simple);
	            		}
	            	}else if(text.startsWith("§4")){
	            		if(this.pl.getSkywars(text.replaceAll("§4", "")) != null){
	            			FormWindowSimple simple = new FormWindowSimple(Mensagens.FORM_NAME_PLAYER, Mensagens.FORM_PLAYER_CONTENT);
    	    				for(SkywarsAPI sky : this.pl.salas){
    	    					String msg = "§f" + sky.getName();
    	    					if(sky.getState().equals(Estado.ESPERANDO)){
    	        					if(sky.getC().exists("Configurada") && sky.getC().getInt("Configurada") != 0 || sky.getC().get("Configurada") != "0")
    	        					if(sky.getConfigurada() != 0)
    	        					 msg = "§a" + sky.getName();
    	        					}else if(sky.getState().equals(Estado.EM_JOGO)){
    	        							msg = "§4" + sky.getName();
    	                      	}else if(sky.getState().equals(Estado.RESETANDO)){
    	                      		msg = "§6" + sky.getName();
    	                      	}else if(sky.getConfigurada() == 0){
    	                      		msg = "§c" + sky.getName();
    	                      	}else{
    	                      		msg = null;
    	                      	}
    	        					if(msg != null){
    	        					simple.setContent(Mensagens.FORM_CONTENT_ARENA_IS_IN_GAME);
    	    	                    ElementButton button = new ElementButton(msg);
    	    	                    simple.addButton(button);
    	        					}
    	    				}
    	    				 player.showFormWindow(simple);
	            		}
	            	}else if(text.startsWith("§6")){
	            		FormWindowSimple simple = new FormWindowSimple(Mensagens.FORM_NAME_PLAYER, Mensagens.FORM_PLAYER_CONTENT);
	    				for(SkywarsAPI sky : this.pl.salas){
	    					String msg = "§f" + sky.getName();
	    					if(sky.getState().equals(Estado.ESPERANDO)){
	        					if(sky.getC().exists("Configurada") && sky.getC().getInt("Configurada") != 0 || sky.getC().get("Configurada") != "0")
	        					if(sky.getConfigurada() != 0)
	        					 msg = "§a" + sky.getName();
	        					}else if(sky.getState().equals(Estado.EM_JOGO)){
	        							msg = "§4" + sky.getName();
	                      	}else if(sky.getState().equals(Estado.RESETANDO)){
	                      		msg = "§6" + sky.getName();
	                      	}else if(sky.getConfigurada() == 0){
	                      		msg = "§c" + sky.getName();
	                      	}else{
	                      		msg = null;
	                      	}
	        					if(msg != null){
	        					simple.setContent(Mensagens.FORM_CONTENT_ARENA_IS_IN_GAME);
	    	                    ElementButton button = new ElementButton(msg);
	    	                    simple.addButton(button);
	        					}
	    				}
	    				 player.showFormWindow(simple);
	            	}else {
	            		FormWindowSimple simple = new FormWindowSimple(Mensagens.FORM_NAME_PLAYER, Mensagens.FORM_PLAYER_CONTENT);
	    				for(SkywarsAPI sky : this.pl.salas){
	    					player.sendMessage("§b" + sky.getName());
	    					String msg = "§f" + sky.getName();
	    					if(sky.getState().equals(Estado.ESPERANDO)){
	        					if(sky.getC().exists("Configurada") && sky.getC().getInt("Configurada") != 0 || sky.getC().get("Configurada") != "0")
	        					if(sky.getConfigurada() != 0)
	        					 msg = "§a" + sky.getName();
	        					}else if(sky.getState().equals(Estado.EM_JOGO) || sky.getState().equals(Estado.FINAL)){
	        							msg = "§4" + sky.getName();
	                      	}else if(sky.getState().equals(Estado.RESETANDO)){
	                      		msg = "§6" + sky.getName();
	                      	}else if(sky.getConfigurada() == 0){
	                      		msg = "§c" + sky.getName();
	                      	}else{
	                      		msg = null;
	                      	}
	        					if(msg != null){
	        					simple.setContent(Mensagens.FORM_CONTENT_ARENA_IS_IN_GAME);
	    	                    ElementButton button = new ElementButton(msg);
	    	                    simple.addButton(button);
	        					}
	    				}
	    				 player.showFormWindow(simple);
	            	}
                	break;
	            case Mensagens.FORM_WAIT_AREA_SET:
	            	if(this.pl.getSkywars(text) != null){
	            		SkywarsAPI sky = this.pl.getSkywars(text);
	            		if(sky.getState().equals(Estado.ESPERANDO) || sky.getState() == null){
            				if(sky.getConfigurada() == 0){
            					sky.waitArea = player.getLocation();
            					player.sendTip(Mensagens.WAIT_AREA_SUCESS_SET);
            					}
            				}
	            		}
	            	break;
	            
	            }
	        }else if(window instanceof FormWindowCustom){
	        	FormResponseCustom responses = (FormResponseCustom) event.getResponse();
	            switch (((FormWindowCustom) window).getTitle())
	            {
	            case Mensagens.FORM_CREATE_NAME:
	            	String texts = (String) responses.getResponse(2);
	            	float maxPlayers = (float)responses.getResponse(3);
	            	if(this.pl.getSkywars(texts) == null){
						SkywarsAPI sky = new SkywarsAPI(this.pl, texts,(int) maxPlayers);
						player.sendMessage(String.format(Mensagens.ARENA_CRIADA, texts));
						this.pl.salas.add(sky);
						if((boolean)responses.getResponse(0) ==  true){
							String l = responses.getResponse(1).toString();
							Level lvl = this.pl.getServer().getLevelByName(l);
							player.teleport(lvl.getSpawnLocation());
							this.pl.saveMap(lvl);
							}
					}else {
						player.sendMessage(Mensagens.ARENA_JA_EXISTE);
					}
	            	break;
	            }
	        }
	    }
}
