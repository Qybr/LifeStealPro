package au.qybr.lifesteal;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.net.http.WebSocket;
import java.util.HashMap;


public class playerDeath implements Listener {
    public static HashMap<Player, Integer> playerlives = new HashMap<Player, Integer>();
    public void onDeath(PlayerDeathEvent e) {
        Entity killer = e.getEntity().getKiller();
        Player player = e.getEntity();
        if (killer instanceof org.bukkit.entity.Player) {
            Player killerPlayer = (Player) killer;
            if (player == killerPlayer) {
                player.sendMessage("Nice Try silly!");
            }
            else {
                playerlives.put(player, playerlives.get(player) - 2);
                if (playerlives.get(player) <= 0) {
                    Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), "You have run out of life, an Administrator can revive you later!", null, "Lifesteal");
                    player.kickPlayer("You have run out of life, an Administrator can revive you later!");
                    playerlives.put(player, 20);
                    playerlives.put(killerPlayer, playerlives.get(killerPlayer) + 4);
                    killerPlayer.sendMessage(player.getName() + " has been eliminated! You have been given extra hearts!");
                }
                else {
                    Attributable playeratri = (Attributable) player;
                    AttributeInstance pi = playeratri.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH);
                    pi.setBaseValue(playerDeath.playerlives.get(player));
                }
                playerlives.put(killerPlayer, playerlives.get(killerPlayer) + 2);
                Attributable playeratri = (Attributable) killerPlayer;
                AttributeInstance pi = playeratri.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH);
                pi.setBaseValue(playerDeath.playerlives.get(killerPlayer));
            }


        }
    }
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        Attributable playeratri = (Attributable) p;
        AttributeInstance pi = playeratri.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH);
        pi.setBaseValue(playerDeath.playerlives.get(p));

    }
}
