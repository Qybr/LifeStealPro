package au.qybr.lifesteal;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.net.http.WebSocket;

public class playerDeath implements Listener {
    public void onDeath(PlayerDeathEvent e) {
        Entity killer = e.getEntity().getKiller();
        Player player = e.getEntity();
        if (killer instanceof org.bukkit.entity.Player) {
            Player killerPlayer = (Player) killer;

        }
    }
}
