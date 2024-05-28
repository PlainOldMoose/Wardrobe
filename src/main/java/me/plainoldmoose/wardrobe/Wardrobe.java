package me.plainoldmoose.wardrobe;

import org.bukkit.plugin.java.JavaPlugin;

public final class Wardrobe extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
        getCommand("gui").setExecutor(new GuiCommand());
        getCommand("chest").setExecutor(new ChestCommand());
    }

    @Override
    public void onDisable() {
    }

    public static Wardrobe getInstance() {
        return getPlugin(Wardrobe.class);
    }
}

