package leodev.slice.eventos;

import java.util.HashMap;

import leodev.slice.Loader;
import leodev.slice.apis.SkywarsAPI;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;

public class SkywarsOpEvents implements Listener
{
	public Loader pl;
	public SkywarsOpEvents(Loader ps){
		this.pl = ps;
	}
	public HashMap<Player, Integer> antBugWin10 = new HashMap<Player, Integer>();
	@EventHandler
	public void deathEvent(PlayerDeathEvent e){
		Player p = e.getEntity();
		for(SkywarsAPI sky : this.pl.salas){
			if(sky.getPlayers().containsKey(p)){
				sky.killedPlayer(p);
			}
		}
	}
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		int yes = 0;
		if(!antBugWin10.containsKey(p)){
			antBugWin10.put(p, 0);
			yes = antBugWin10.get(p);
		}else {
			
		if(this.pl.setingSpawns.containsKey(p)){
			if(p.getInventory().getItemInHand().equals(Item.STICK) || p.getInventory().getItemInHand().getCustomName().equals("§a§lSETADOR DE SPAWNS")){
				SkywarsAPI api = this.pl.setingSpawns.get(p);
				if(antBugWin10.get(p) == 0){
					if(api.setSpawns(e.getBlock().getLocation()) == true){
						p.sendMessage("Sucesso §c" + api.getSpawns().size() + " / " + api.getMaxPlayers());
						antBugWin10.put(p, 1);
						}else {
							this.pl.setingSpawns.remove(p);
						}
				
				}else{
					antBugWin10.put(p, 0);
				   }
				}
			}
		}
	}
}
