package au.qybr.lifesteal;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class lsutiil {
    private lsutiil() {}

    public static ItemStack createHeart() {
        ItemStack nstar = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = nstar.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Heart");
        nstar.setItemMeta(meta);
        return nstar;
    }
    public static boolean isHeart(ItemStack stack) {
        if(stack==null || stack.getType()!=Material.NETHER_STAR || !stack.hasItemMeta() || !stack.getItemMeta().hasDisplayName()) {
            return false;
        } else if(stack.getItemMeta().getDisplayName().equals(ChatColor.RED + "Heart")) {
            return true;
        } else {
            return false;
        }

        }
    }

