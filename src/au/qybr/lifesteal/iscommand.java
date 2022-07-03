package au.qybr.lifesteal;

import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class iscommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        //if args if 0 then assume only 1 heart is wanted
        if (args.length == 0) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                if (playerDeath.playerlives.get(player) > 2) {
                    playerDeath.playerlives.put(player, playerDeath.playerlives.get(player) - 2);
                    Attributable playeratri = (Attributable) player;
                    AttributeInstance pi = playeratri.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH);
                    pi.setBaseValue(playerDeath.playerlives.get(player));
                    ItemStack heart = lsutiil.createHeart();
                    player.getInventory().addItem(heart);
                    player.sendMessage("You have withdrawn a heart!");
                    return true;
                }
                else {
                    player.sendMessage("You have run out of lives!");
                    return false;
                }

            }
            else {
                commandSender.sendMessage("You must be a player to use this command!");
                return false;
            }
        } else if (args.length == 1) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                int num = Integer.parseInt(args[0]);
                //repeat the command num times
                for (int i = 0; i < num; i++) {
                    if (playerDeath.playerlives.get(player) > 2) {
                        playerDeath.playerlives.put(player, playerDeath.playerlives.get(player) - 2);
                        Attributable playeratri = (Attributable) player;
                        AttributeInstance pi = playeratri.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH);
                        pi.setBaseValue(playerDeath.playerlives.get(player));
                        ItemStack heart = lsutiil.createHeart();
                        player.getInventory().addItem(heart);
                        player.sendMessage("You have withdrawn a heart!");
                    }
                    else {
                        player.sendMessage("You have run out of lives!");
                        return false;
                    }
                }
                return true;
            }

        }
        else {
            commandSender.sendMessage("Usage: /lifesteal <num>");
            return false;
        }
        return false;
    }
}
