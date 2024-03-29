package com.allCommand.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;

import com.allCommand.AllCommand;

import net.md_5.bungee.api.ChatColor;

public class MakeFile {
	
	public static AllCommand plugin;
	
	//서버 > plugins의 플러그인안의 data.txt 파일을 선언하고 대입하는 과정 
	private final static File f = new File(plugin.getDataFolder(), "/data.txt");
		
	public static void setPlugin(AllCommand MainPlugin) {
		plugin = MainPlugin;
	}
	
	public static void setFile(HashMap<UUID, Integer> map) {
		plugin.console.sendMessage("Data Folder >>>> " + plugin.getDataFolder());
		makeFile(f);
		mapToFile(f, map);
		fileToMap(f, map);
	}
	
	/**
	 * 파일 생성
	 * @param f
	 */
	public static void makeFile(File f) {
		if(!f.exists() || !f.isFile()) {
			try {
				f.createNewFile();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * map에 저장했던 변수를 파일에 저장
	 * @param f
	 * @param map
	 */
	@SuppressWarnings("deprecation")
	public static void mapToFile(File f, HashMap<UUID, Integer> map) {
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable() {
			@Override
			public void run() {
				try {
					plugin.console.sendMessage(ChatColor.GREEN + "데이터를 저장했습니다.");
					FileWriter writer = new FileWriter(f, false);
					for(UUID uuid : map.keySet()) {
						writer.write(uuid + "|" + map.get(uuid) + "\n");
					}
					writer.close();
				} catch (IOException e){
					e.printStackTrace();
				}
			}
		}, 20*30, 20*30);
	}
	
	/**
	 * 파일에서 map으로 데이터 저장
	 * @param f
	 * @param map
	 */
	public static void fileToMap(File f, HashMap<UUID, Integer> map) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			
			String fileLine = null;
			while ((fileLine = reader.readLine()) != null) {
				UUID uuid = UUID.fromString(fileLine.split("\\|")[0]);
				String str = fileLine.split("\\|")[1];
				map.put(uuid, Integer.parseInt(str));
			}
		} catch(FileNotFoundException e3) {
			e3.printStackTrace();
		} catch(IOException e4) {
			e4.printStackTrace();
		}
	}
}
