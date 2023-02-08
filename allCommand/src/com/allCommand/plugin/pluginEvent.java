package com.allCommand.plugin;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.craftbukkit.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.allCommand.allCommand;


public class pluginEvent implements Listener{
	
	public static allCommand plugin;
	public HashMap<UUID, Integer> map = new HashMap<UUID, Integer>();
	
	public static void setPlugin(allCommand MainPlugin) {
		plugin = MainPlugin;
	}
	
	/**
	 * 플레이어가 입장할 때 실행되는 함수
	 * @param e
	 */
	@EventHandler
	public void join(PlayerJoinEvent e) {
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
