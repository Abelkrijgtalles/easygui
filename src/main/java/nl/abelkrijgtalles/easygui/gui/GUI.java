package nl.abelkrijgtalles.easygui.gui;

import nl.abelkrijgtalles.easygui.util.Defaults;
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
        Inventory GUI = Bukkit.createInventory(player, size, title);
        nl.abelkrijgtalles.easygui.gui.GUI.checkGUI(GUI);

        return GUI;
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

    /**
     * Adds a border around the given GUI.
     * @param GUI The GUI to put a border around.
     * @return The GUI with a border
     */

    public static Inventory addBorder(Inventory GUI) {

        return nl.abelkrijgtalles.easygui.gui.GUI.addBorder(GUI, Defaults.getDefaultBorderItem());

    }

    /**
     * Adds a border around the given GUI.
     * @param GUI The GUI to put a border around.
     * @param borderItem The item for the border.
     * @return The GUI with a border
     */

    public static Inventory addBorder(Inventory GUI, ItemStack borderItem) {

        nl.abelkrijgtalles.easygui.gui.GUI.checkGUI(GUI);

        int size = GUI.getSize();
        int rows = size / 9;
        int lastRow = (rows - 1) * 9;

        if (size >= 9 * 3) {
            for (int i = 0; i < 9; i++) {
                GUI.setItem(i, borderItem);
            }
            for (int i = 0; i < rows - 2; i++) {
                int firstRow = (i + 1) * 9;

                GUI.setItem(firstRow, borderItem);
                GUI.setItem(firstRow + 8, borderItem);
            }
            for (int i = lastRow - 1; i < size; i++) {

                if (i == lastRow + 4) {
                    GUI.setItem(i, Defaults.getExitItem());
                } else {
                    GUI.setItem(i, borderItem);
                }
            }
        }

        return GUI;

    }

    /**
     * Checks for certain things in the given GUI. If they are not present, then it wil throw an exception. Current list of checks: If the GUI-size dividable is by 9.
     * @param GUI The GUI to check.
     */

    public static void checkGUI(Inventory GUI) {
        if (GUI.getSize() % 9 != 0) {
            Bukkit.getLogger().warning(GUI.getSize() + " isn't dividable by 9.");
            throw new IllegalArgumentException();
        }
    }

}
