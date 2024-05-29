package me.plainoldmoose.wardrobe;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.StartPosition;
import org.mineacademy.fo.menu.button.annotation.Position;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class LoadoutMenu extends Menu {

    @Position(start = StartPosition.BOTTOM_CENTER, value = -2)
    private final Button selector1;
    @Position(start = StartPosition.BOTTOM_CENTER)
    private final Button selector2;
    @Position(start = StartPosition.BOTTOM_CENTER, value = 2)
    private final Button selector3;

    public LoadoutMenu() {
        setSlotNumbersVisible();
        setTitle(ChatColor.GRAY + "Wardrobe");
        setSize(9 * 6);

        this.selector1 = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                player.sendMessage(ChatColor.GREEN + "Selected Loadout A");
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.ENDER_PEARL, "&cSelect Loadout").make();
            }
        };

        this.selector2 = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                player.sendMessage(ChatColor.RED + "Selected Loadout B");
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.ENDER_PEARL, "&cSelect Loadout").make();
            }
        };

        this.selector3 = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                player.sendMessage(ChatColor.BLUE + "Selected Loadout C");
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.ENDER_PEARL, "&cSelect Loadout").make();
            }
        };
    }

    @Override
    protected void onPostDisplay(Player viewer) {

        for (int i = 0; i < 54; i++ ) {
            if (!(i == 51 || i == 49 || i == 47)) {
                setItem(i, ItemCreator.of(CompMaterial.RED_STAINED_GLASS_PANE).make());
            }
        }
    }
}
