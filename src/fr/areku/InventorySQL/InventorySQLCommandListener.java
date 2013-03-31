package fr.areku.InventorySQL;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.areku.InventorySQL.command.Commandichk;
import fr.areku.InventorySQL.command.Commandinvsql;

public class InventorySQLCommandListener implements CommandExecutor {
	public InventorySQLCommandListener() {}

	public boolean onCommand(CommandSender cs, Command cmnd, String label,
			String[] args) {
		if (!InventorySQL.getInstance().ready) {
			cs.sendMessage("[InventorySQL] " + ChatColor.RED
					+ "配置加载失败请用/inv reload 重新加载");
			return true;
		}

		if ("ichk".equals(label)) {
			return new Commandichk(cs, cmnd, label, args, this).execute();
		}
		if ("inv".equals(label)) {
			return new Commandinvsql(cs, cmnd, label, args, this).execute();
			
		}
		return true;
	}

}
