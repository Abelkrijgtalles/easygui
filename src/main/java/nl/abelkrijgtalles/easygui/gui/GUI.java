package nl.abelkrijgtalles.easygui.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class GUI {

    /**
     * Creates a GUI with the given size, title and optionally an item and an option to choose for a border and then the border item.
     * @param p The player who's going to use the GUI.
     * @param size The size of the GUI (Must be dividable with 9).
     * @param title The title for the GUI.
     * @param item (Optional) An item for the GUI.
     * @param border (Optional) An option for a border around in the GUI.
     * @param borderItem (Optional) An item for the border in the GUI.
     * @return Returns the created GUI.
     */

    public static Inventory create(Player p, int size, String title, Optional<ItemStack> item, Optional<Boolean> border, Optional<ItemStack> borderItem) {
        if (size % 9 != 0) {
            Bukkit.getLogger().warning(size + " isn't dividable by 9.");
            throw new IllegalArgumentException();
        }

        Inventory gui = Bukkit.createInventory(p, size, title);
        item.ifPresent(gui::addItem);

        return gui;
    }

}
