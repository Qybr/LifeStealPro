package au.qybr.lifesteal;

import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;

public class playerJoin {
    @EventHandler
    public void onJoin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if (p.hasPlayedBefore()) {
            playerDeath.playerlives.put(p, 20);
            Attributable playeratri = (Attributable) p;
            AttributeInstance pi = playeratri.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH);
            pi.setBaseValue(playerDeath.playerlives.get(p));
        }
        else {
            Attributable playeratri = (Attributable) p;
            AttributeInstance pi = playeratri.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH);
            pi.setBaseValue(playerDeath.playerlives.get(p));
        }
    }
}
