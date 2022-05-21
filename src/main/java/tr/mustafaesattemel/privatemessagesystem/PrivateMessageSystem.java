package tr.mustafaesattemel.privatemessagesystem;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class PrivateMessageSystem extends JavaPlugin implements Listener {

    private HashMap<UUID, UUID> recentMessage;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("message").setExecutor(new MessageCommand(this));
        getCommand("reply").setExecutor(new MessageCommand(this));

        recentMessage=new HashMap<>();

        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public HashMap<UUID, UUID> getRecentMessage() {
        return recentMessage;
    }

    public void onQuit(PlayerQuitEvent e){
        recentMessage.remove(e.getPlayer().getUniqueId());
    }


}
