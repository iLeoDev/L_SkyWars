package leodev.slice.eventos;

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
	@EventHandler
	public void deathEvent(PlayerDeathEvent e){
		Player p = e.getEntity();
		for(SkywarsAPI sky : this.pl.salas){
			if(sky.getPlayers().containsKey(p)){
				sky.killedPlayer(p);
			}
		}
	}
}
