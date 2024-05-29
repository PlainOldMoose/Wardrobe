package me.plainoldmoose.wardrobe;

import org.mineacademy.fo.menu.button.ButtonReturnBack;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.remain.CompMaterial;

public final class Wardrobe extends SimplePlugin {
    @Override
    public void onPluginStart() {
        ButtonReturnBack.setMaterial(CompMaterial.BARRIER);

        getCommand("gui").setExecutor(new GuiCommand());
        getCommand("chest").setExecutor(new ChestCommand());
    }

    @Override
    public void onPluginStop() {
    }

    public static Wardrobe getInstance() {
        return getPlugin(Wardrobe.class);
    }
}

