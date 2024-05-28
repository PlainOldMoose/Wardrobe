package me.plainoldmoose.wardrobe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;

public class ChestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players can use this command!");

            return true;
        }

        Player player = (Player) commandSender;

        Inventory inventory = Bukkit.createInventory(player, 9 * 6, ChatColor.DARK_PURPLE + "EnderChest");        ItemStack HeadSlot1 = new ItemStack(Material.DIAMOND_HELMET);

        for (int i = 0; i < 54; i++) {
            inventory.setItem(i, new ItemStack(Material.RED_STAINED_GLASS_PANE));
        }
        inventory.setItem(11, null);
        inventory.setItem(13, null);
        inventory.setItem(15, null);

        inventory.setItem(20, null);
        inventory.setItem(22, null);
        inventory.setItem(24, null);

        inventory.setItem(29, null);
        inventory.setItem(31, null);
        inventory.setItem(33, null);

        inventory.setItem(38, null);
        inventory.setItem(40, null);
        inventory.setItem(42, null);

        ItemStack selectorActive = new ItemStack(Material.ENDER_EYE);
        ItemStack selectorInactive = new ItemStack(Material.ENDER_PEARL);

        inventory.setItem(47, selectorActive);
        inventory.setItem(49, selectorInactive);
        inventory.setItem(51, selectorInactive);

        player.openInventory(inventory);
        //PersistentDataContainer container = inventory.getContents();
        player.setMetadata("OpenedChest", new FixedMetadataValue(Wardrobe.getInstance(), inventory));

        return true;
    }
}
