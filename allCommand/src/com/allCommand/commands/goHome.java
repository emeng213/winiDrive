package com.allCommand.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class goHome implements CommandExecutor{
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
		
		Location homeLocation = (Location) setHome.map.get("homeLocation");
		
		player.teleport(homeLocation);
		
		player.sendMessage("집으로 이동하였습니다.");
		
		return false;
	}
}
