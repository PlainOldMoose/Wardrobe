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

        ItemStack ChestSlot1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack ChestSlot2 = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemStack ChestSlot3 = new ItemStack(Material.IRON_CHESTPLATE);

        ItemStack LegSlot1 = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack LegSlot2 = new ItemStack(Material.GOLDEN_LEGGINGS);
        ItemStack LegSlot3 = new ItemStack(Material.IRON_LEGGINGS);

        ItemStack BootSlot1 = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack BootSlot2 = new ItemStack(Material.GOLDEN_BOOTS);
        ItemStack BootSlot3 = new ItemStack(Material.IRON_BOOTS);

        ItemStack Selector1 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemStack Selector2 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemStack Selector3 = new ItemStack(Material.RED_STAINED_GLASS_PANE);


        inventory.setItem(11, HeadSlot1);
        inventory.setItem(13, HeadSlot2);
        inventory.setItem(15, HeadSlot3);

        inventory.setItem(20, ChestSlot1);
        inventory.setItem(22, ChestSlot2);
        inventory.setItem(24, ChestSlot3);

        inventory.setItem(29, LegSlot1);
        inventory.setItem(31, LegSlot2);
        inventory.setItem(33, LegSlot3);

        inventory.setItem(38, BootSlot1);
        inventory.setItem(40, BootSlot2);
        inventory.setItem(42, BootSlot3);

        inventory.setItem(47, Selector1);
        inventory.setItem(49, Selector2);
        inventory.setItem(51, Selector3);



        player.openInventory(inventory);
        player.setMetadata("OpenedMenu", new FixedMetadataValue(Wardrobe.getInstance(), inventory));

        return true;
    }
}
