package ru.naulbimix.rupozor.listeners;

import org.bukkit.event.*;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    private ListenerCommandStorage storage;

    public CommandListener(ListenerCommandStorage storage){
        this.storage = storage;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent ev){
        String args[] = ev.getMessage().split(" ");
        String command = args[0];
        if(command.contains(":")){
            command = command.split(":")[command.split(":").length - 1];
        }
        if(storage.containsCommand(command)){
            ListenerCommand cmd = storage.getCommand(command);
            String command_args[];
            if(args.length >= 2){
                command_args = parse(args, 1);
            }else{
                command_args = new String[0];
            }
            ev.setCancelled(cmd.isCancelled());
            boolean b = cmd.onCommand(ev.getPlayer(), command, command_args);
            if(!b){
                ev.getPlayer().sendMessage("false");
            }
        }
        System.out.println("Testing top plugin");
    }

    public String[] parse(String[] args, int index){
        if(args.length >= index){
            String[] toReturn = new String[args.length - index];
            for (int i = index; i < args.length; i++) {
                toReturn[i - index] = args[i];
            }
            return toReturn;
        }else{
            return args;
        }
    }
}
