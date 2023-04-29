package nl.abelkrijgtalles.easygui.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Defaults {

    /**
     * Returns the default exit item (Red Dye with a Red text: Exit)
     * @return The default exit item (Red Dye with a Red text: Exit)
     */

    public static ItemStack getExitItem() {
        ItemStack exitItem = new ItemStack(Material.RED_DYE);
        ItemMeta exitItemMeta = exitItem.getItemMeta();
        exitItemMeta.setDisplayName(ChatColor.RED + "Exit");
        exitItem.setItemMeta(exitItemMeta);

        return exitItem;
    }

    /**
     * Clears the name of an item.
     * @param item The item to get a clear name.
     * @return The given item with a clear name.
     */

    public static ItemStack setClearName(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RESET + "");
        item.setItemMeta(itemMeta);

        return item;
    }

    /**
     * Gets the default border item (Gray Stained Glass Pane with clear name).
     * @return The default border item (Gray Stained Glass Pane with clear name).
     */

    public static ItemStack getDefaultBorderItem() {
        ItemStack borderItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        Defaults.setClearName(borderItem);

        return borderItem;
    }

}
