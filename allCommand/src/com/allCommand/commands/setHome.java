package com.allCommand.commands;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setHome implements CommandExecutor{
	
	static HashMap<String, Object> map = new HashMap<String, Object>();
	
	/**
	 * 좌표 setHome
	 * sender : 입력한 플레이어
	 * command : 발동되는 커맨드
	 * s : 명령어
	 * args : param
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		
		map.put("homeLocation", player.getLocation());
		
		player.sendMessage(player.getLocation() + " 좌표가 집으로 설정되었습니다.");
		
		return false;
	}
}
