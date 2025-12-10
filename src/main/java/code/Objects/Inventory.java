package code.Objects;

import java.util.ArrayList;
import java.util.List;

import code.Inventory.InventoryGrid;

public class Inventory {
    private List<Item> items = new ArrayList<>();
    private InventoryGrid inventoryGrid;

    public Inventory(Character character) {
        /*
        Item helmet4 = new Item("/resources/Basic_Helmet_2.gif", 4, "Helmet");
        Item chestplate4 = new Item("/resources/Basic_Chestplate.gif", 4, "Chestplate");
        Item pants4 = new Item("/resources/Basic_Pants.gif", 4, "Pants");
        Item shoes4 = new Item("/resources/Basic_Shoes.gif", 4, "Shoes");   
        Item shield4 = new Item("/resources/Basic_Shield.gif", 4, "Shield");
        Item sword4 = new Item("/resources/Basic_Sword.gif", 4, "Sword");
        Item character0 = new Item("/resources/Ninja/Ninja_Character.gif", 0, "Character");
        Item background0 = new Item("/resources/Basic_Background.png", 0, "Background");
        Item helmet2 = new Item("/resources/Basic_Helmet_2.gif", 2, "Helmet");
        Item chestplate2 = new Item("/resources/Basic_Chestplate.gif", 2, "Chestplate");
        Item pants2 = new Item("/resources/Basic_Pants.gif", 2, "Pants");
        Item shoes2 = new Item("/resources/Basic_Shoes.gif", 2, "Shoes");   
        Item shield2 = new Item("/resources/Basic_Shield.gif", 2, "Shield");
        Item sword2 = new Item("/resources/Basic_Sword.gif", 2, "Sword");
        items.add(helmet4);
        items.add(chestplate4);
        items.add(pants4);
        items.add(shoes4);
        items.add(shield4);
        items.add(sword4);
        items.add(character0);
        items.add(background0);
        items.add(helmet2);
        items.add(chestplate2);
        items.add(pants2);
        items.add(shoes2);
        items.add(shield2);
        items.add(sword2);
        */
        InventoryGrid inventoryGrid = character.getInventoryGrid();
        this.inventoryGrid = inventoryGrid;

        addItem("/resources/Basic_Helmet_2.gif", 4, "Helmet");
        addItem("/resources/Basic_Chestplate.gif", 1, "Chestplate");
        addItem("/resources/Basic_Pants.gif", 4, "Pants");
        addItem("/resources/Basic_Shoes.gif", 1, "Shoes"); 
        addItem("/resources/Basic_Shield.gif", 1, "Shield");
        addItem("/resources/Basic_Sword.gif", 4, "Sword");
        addItem("/resources/Basic_Character.gif", 0, "Character");
        addItem("/resources/Basic_Background.png", 0, "Background");
        addItem("/resources/Basic_Helmet_2.gif", 2, "Helmet");
        addItem("/resources/Basic_Chestplate.gif", 3, "Chestplate");
        addItem("/resources/Basic_Pants.gif", 3, "Pants");
        addItem("/resources/Basic_Shoes.gif", 2, "Shoes");
        addItem("/resources/Basic_Shield.gif", 2, "Shield");
        addItem("/resources/Basic_Sword.gif", 2, "Sword");
    }

    public void addItem(String imagePath, int rarity, String type) {
        Item item = new Item(imagePath, rarity, type);
        items.add(item);
        inventoryGrid.addItemToFirstAvailable(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getArmourByType(String type) {
        for (Item armour : items) {
            if (armour.getType().equals(type)) {
                return armour;
            }
        }
        return null;
    }

    public Item getItemByItemName (String name) {
        for (Item item : items) {
            if (item.getItemName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
