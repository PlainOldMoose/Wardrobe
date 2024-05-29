package me.plainoldmoose.wardrobe;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class ChestListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (player.hasMetadata("OpenedChest")) {
            event.setCancelled(true);

            if (event.getSlot() == 47) {
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_DIAMOND,29 , 29);
                player.sendMessage(ChatColor.RED + "Equipped loadout A");
            }
            else if (event.getSlot() == 49) {
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_DIAMOND,29 , 29);
                player.sendMessage(ChatColor.GREEN + "Equipped loadout B");
            }

            else if (event.getSlot() == 51) {
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_DIAMOND,29 , 29);
                player.sendMessage(ChatColor.BLUE + "Equipped loadout C");
            }
        }
    }
    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        if (player.hasMetadata("OpenedChest"))
            player.removeMetadata("OpenedChest", Wardrobe.getInstance());
    }
}
