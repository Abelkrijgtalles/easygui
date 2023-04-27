package nl.abelkrijgtalles.easygui.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUI {

    /**
     * Creates a GUI with the given size, title and optionally an item and an option to choose for a border and then the border item.
     * @param player The player who's going to use the GUI.
     * @param size The size of the GUI (Must be dividable with 9).
     * @param title The title for the GUI.
     * @return Returns the created GUI.
     */

    public static Inventory create(Player player, int size, String title) {
        if (size % 9 != 0) {
            Bukkit.getLogger().warning(size + " isn't dividable by 9.");
            throw new IllegalArgumentException();
        }

        return Bukkit.createInventory(player, size, title);
    }

    /**
     * Creates a GUI with the given size, title and optionally an item and an option to choose for a border and then the border item.
     * @param player The player who's going to use the GUI.
     * @param size The size of the GUI (Must be dividable with 9).
     * @param title The title for the GUI.
     * @param item (Optional) An item for the GUI.
     * @return Returns the created GUI.
     */

    public static Inventory create(Player player, int size, String title, ItemStack... item) {

        Inventory GUI = nl.abelkrijgtalles.easygui.gui.GUI.create(player, size, title);
        GUI.addItem(item);

        return GUI;
    }

    /**
     * Creates a GUI with the given size, title and optionally an item and an option to choose for a border and then the border item.
     * @param player The player who's going to use the GUI.
     * @param size The size of the GUI (Must be dividable with 9).
     * @param title The title for the GUI.
     * @param border An option for a border around in the GUI.
     * @return Returns the created GUI.
     */

    public static Inventory create(Player player, int size, String title, boolean border) {
        Inventory GUI = nl.abelkrijgtalles.easygui.gui.GUI.create(player, size, title);

        if (border) {
            GUI = nl.abelkrijgtalles.easygui.gui.GUI.addBorder(GUI);
        }

        return GUI;
    }

    /**
     * Creates a GUI with the given size, title and optionally an item and an option to choose for a border and then the border item.
     * @param player The player who's going to use the GUI.
     * @param size The size of the GUI (Must be dividable with 9).
     * @param title The title for the GUI.
     * @param border An option for a border around in the GUI.
     * @param borderItem An item for the border in the GUI.
     * @return Returns the created GUI.
     */

    public static Inventory create(Player player, int size, String title, boolean border, ItemStack borderItem) {

        Inventory GUI = nl.abelkrijgtalles.easygui.gui.GUI.create(player, size, title);

        if (border) {
            GUI = nl.abelkrijgtalles.easygui.gui.GUI.addBorder(GUI, borderItem);
        }

        return GUI;
    }

    /**
     * Creates a GUI with the given size, title and optionally an item and an option to choose for a border and then the border item.
     * @param player The player who's going to use the GUI.
     * @param size The size of the GUI (Must be dividable with 9).
     * @param title The title for the GUI.
     * @param item An item for the GUI.
     * @param border An option for a border around in the GUI.
     * @return Returns the created GUI.
     */


    public static Inventory create(Player player, int size, String title, ItemStack item, boolean border) {
        Inventory GUI = nl.abelkrijgtalles.easygui.gui.GUI.create(player, size, title);

        if (border) {
            GUI = nl.abelkrijgtalles.easygui.gui.GUI.addBorder(GUI);
        }
        GUI.addItem(item);

        return GUI;
    }

    /**
     * Creates a GUI with the given size, title and optionally an item and an option to choose for a border and then the border item.
     * @param player The player who's going to use the GUI.
     * @param size The size of the GUI (Must be dividable with 9).
     * @param title The title for the GUI.
     * @param item An item for the GUI.
     * @param border An option for a border around in the GUI.
     * @param borderItem An item for the border in the GUI.
     * @return Returns the created GUI.
     */


    public static Inventory create(Player player, int size, String title, ItemStack item, boolean border, ItemStack borderItem) {
        Inventory GUI = nl.abelkrijgtalles.easygui.gui.GUI.create(player, size, title);

        if (border) {
            GUI = nl.abelkrijgtalles.easygui.gui.GUI.addBorder(GUI, borderItem);
        }
        GUI.addItem(item);

        return GUI;
    }

    public static Inventory addBorder(Inventory GUI) {

        return nl.abelkrijgtalles.easygui.gui.GUI.addBorder(GUI, new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE));

    }

    public static Inventory addBorder(Inventory GUI, ItemStack borderItem) {

        if (GUI.getSize() % 9 != 0) {
            Bukkit.getLogger().warning(GUI.getSize() + " isn't dividable by 9.");
            throw new IllegalArgumentException();
        }

        if (GUI.getSize() >= 9 * 3) {
            for (int i = 0; i < 9; i++) {
                GUI.setItem(i, borderItem);
            }
        }

        return GUI;

    }

}
