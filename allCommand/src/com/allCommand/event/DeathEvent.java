package com.allCommand.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathEvent {
	public int playerLevel = 0;
	
	/**
	 * 플레이어가 죽을 때 발생
	 */
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		//사망한 좌표 출력
		player.sendMessage(player.getLocation() + " 좌표에서 사망하였습니다.");
		
		//레벨 저장
		playerLevel = player.getLevel();
	}
	
	/**
	 * 플레이어 리스폰시 레벨 복구
	 * @param event
	 */
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		player.setLevel(playerLevel);
	}
}
