package paper_plugin.paper_plugin;

import org.bukkit.plugin.java.JavaPlugin;
import paper_plugin.paper_plugin.Events.PlayerJoin;

public final class Paper_plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
