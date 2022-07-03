package au.qybr.lifesteal;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.net.http.WebSocket;

public class lsevent implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Action a = event.getAction();
        if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
            ItemStack hand = p.getInventory().getItemInMainHand();
            if (lsutiil.isHeart(hand)) {
                p.getInventory().removeItem(hand);
                playerDeath.playerlives.put(p, playerDeath.playerlives.get(p) + 2);
            }

            }
        }
    }

