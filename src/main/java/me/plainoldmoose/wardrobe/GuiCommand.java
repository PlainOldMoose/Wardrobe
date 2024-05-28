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

public class GuiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players can use this command!");

            return true;
        }

        Player player = (Player) commandSender;

        Inventory inventory = Bukkit.createInventory(player, 9 * 6, ChatColor.DARK_PURPLE + "Wardrobe");

        ItemStack HeadSlot1 = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack HeadSlot2 = new ItemStack(Material.GOLDEN_HELMET);
        ItemStack HeadSlot3 = new ItemStack(Material.IRON_HELMET);


        inventory.setItem(11, HeadSlot1);
        inventory.setItem(13, HeadSlot2);
        inventory.setItem(15, HeadSlot3);

        player.openInventory(inventory);
        player.setMetadata("OpenedMenu", new FixedMetadataValue(Wardrobe.getInstance(), inventory));

        return true;
    }
}
