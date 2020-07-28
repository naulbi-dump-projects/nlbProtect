package ru.naulbimix.rupozor.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.naulbimix.rupozor.Main;
import ru.naulbimix.rupozor.listeners.ListenerCommand;
import ru.naulbimix.rupozor.utils.ColorUtils;

public class ncpCommand implements ListenerCommand {

    private static Main plugin = Main.getInstance();

    @Override
    public String[] getCommand() {
        return new String[]{"ncp"};
    }

    @Override
    public boolean onCommand(Player p, String label, String[] args) {
        if(args.length == 3 && args[0].equals("delay") && args[1].equals("op") && args[2] != null) {
            p.sendMessage(ColorUtils.s(plugin.getConfig().getString("messages.ncp_op.msg").replace("$player", p.getName())));
            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ColorUtils.s(plugin.getConfig().getString("messages.ncp_op.cmd").replace("$player", p.getName())));
                }
            }, 25);
        }
        return true;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }
}
