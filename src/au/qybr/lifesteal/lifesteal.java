package au.qybr.lifesteal;

import org.bukkit.plugin.java.JavaPlugin;

public class lifesteal extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Lifesteal enabled!");
        this.getCommand("withdraw").setExecutor(new iscommand());

    }
    @Override
    public void onDisable() {
        getLogger().info("Lifesteal disabled!");
    }
}
