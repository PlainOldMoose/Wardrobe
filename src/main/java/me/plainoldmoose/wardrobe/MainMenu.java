package me.plainoldmoose.wardrobe;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.ButtonMenu;
import org.mineacademy.fo.menu.button.StartPosition;
import org.mineacademy.fo.menu.button.annotation.Position;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class MainMenu extends Menu {

    @Position(start = StartPosition.CENTER, value = -2)
    private final Button test1;

//    @Position(start = StartPosition.CENTER)
//    private final Button test2;
//
//    @Position(start = StartPosition.CENTER, value = 2)
//    private final Button test3;


    public MainMenu() {
        setSlotNumbersVisible();
        setTitle(ChatColor.GRAY + "Main Menu");
        setSize(9 * 3);

        this.test1 = new ButtonMenu(new TestMenu(), CompMaterial.LAVA_BUCKET,
                "&6&lOpen Test",
                "",
                "Click to open Test");
//        this.test2 = new ButtonMenu(new TestMenu2(), CompMaterial.LAVA_BUCKET,
//                "&6&lOpen Test2",
//                "",
//                "Click to open Test2");
//        this.test3 = new ButtonMenu(new TestMenu3(), CompMaterial.LAVA_BUCKET,
//                "&6&lOpen Test3",
//                "",
//                "Click to open Test3");

        /* this is a longer way of doing the above*/
//        this.test1 = new Button() {
//            @Override
//            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
//                new TestMenu().displayTo(player);
//            }
//
//            @Override
//            public ItemStack getItem() {
//                return ItemCreator.of(CompMaterial.LAVA_BUCKET,
//                        "&l Open Test",
//                        "",
//                        "Click to open Test").make();
//            }
//        };
    }

    private class TestMenu extends Menu {
        @Position(start = StartPosition.CENTER, value = -1)
        private final Button test4;

        @Position(start = StartPosition.CENTER, value = 1)
        private final Button test5;

        TestMenu() {
            super(MainMenu.this);
            setTitle("Test Menu");
            setSize(9 * 3);

            this.test4 = new Button() {
                @Override
                public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                    player.getInventory().clear();
                }

                @Override
                public ItemStack getItem() {
                    return ItemCreator.of(CompMaterial.LAVA_BUCKET, "&cClear Inventory").make();
                }
            };

            this.test5 = new Button() {
                @Override
                public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                    player.setHealth(player.getMaxHealth());

                    restartMenu("&aRefilled health!");
                }

                @Override
                public ItemStack getItem() {
                    return ItemCreator.of(CompMaterial.COOKED_BEEF,
                            "&6Replenish Health",
                            "",
                            "&fCurrent Health : &c" + Math.round(getViewer().getHealth()),
                            "",
                            "Click to refill").make();
                }
            };
        }

        @Override
        protected void onPostDisplay(Player viewer) {

            animate(20, new MenuRunnable() {

                boolean toggle = true;
                @Override
                public void run() {
                    setItem(getCenterSlot(), ItemCreator.of(toggle ? CompMaterial.RED_WOOL : CompMaterial.WHITE_WOOL).make());

                    toggle = !toggle;
                }
            });
        }
    }

//    @Override
//    public ItemStack getItemAt(int slot) {
//        if (slot == 11){
//            return test1.getItem();
//        }
//        ret
//    }
}
