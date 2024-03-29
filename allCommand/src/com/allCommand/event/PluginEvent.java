package com.allCommand.event;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.craftbukkit.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.allCommand.AllCommand;


public class PluginEvent implements Listener{
	
	public static AllCommand plugin;
	public HashMap<UUID, Integer> map = new HashMap<UUID, Integer>();
	
	public static void setPlugin(AllCommand MainPlugin) {
		plugin = MainPlugin;
	}
	
	/**
	 * 플레이어가 입장할 때 실행되는 함수
	 * @param e
	 */
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		int count = 0;
		UUID uuid = e.getPlayer().getUniqueId();
		
		if(map.containsKey(uuid)) {
			map.put(uuid,  map.get(uuid)+1);
		}else {
			map.put(uuid, 1);
		}
		
		count = map.get(uuid);
		e.setJoinMessage(count+"번째 입장");
	}
}
