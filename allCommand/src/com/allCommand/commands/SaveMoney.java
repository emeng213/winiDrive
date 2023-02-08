package com.allCommand.commands;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.allCommand.file.MakeFile;

public class SaveMoney implements CommandExecutor{
	HashMap<UUID, Integer> cashMap = new HashMap<UUID, Integer>();
	/**
	 * 현금 기능
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player player = (Player) sender;
		UUID uuid = player.getUniqueId();
		
		if(args[0] == "입금") {
			cashMap.put(uuid, Integer.parseInt(args[1]));
		}else if(args[0] == "출금") {
			int money = cashMap.get(uuid) - Integer.parseInt(args[1]);
			cashMap.put(uuid, money);
		}else if(args[0] == "잔액") {
			player.sendMessage("현재 잔액은 " + cashMap.get(uuid) + "원입니다.");
		}
		
		MakeFile.makeFile(MakeFile.f);
		MakeFile.mapToFile(MakeFile.f, cashMap);
		MakeFile.fileToMap(MakeFile.f, cashMap);
		
		return false;
	}
}
