package code.Objects;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    public Inventory() {
        Item helmet = new Item("/resources/Basic_Helmet_2.gif", 4, 10, "Helmet");
        Item chestplate = new Item("/resources/Basic_Chestplate.gif", 2, 15, "Chestplate");
        Item pants = new Item("/resources/Basic_Pants.gif", 3, 12, "Pants");
        Item shoes = new Item("/resources/Basic_Shoes.gif", 4, 8, "Shoes");   
        Item shield = new Item("/resources/Basic_Shield.gif", 3, 20, "Shield");
        Item sword = new Item("/resources/Basic_Sword.gif", 2, 25, "Sword");
        Item character = new Item("/resources/Ninja/Ninja_Character.gif", 0, 0, "Character");
        Item background = new Item("/resources/Basic_Background.png", 0, 0, "Background");
        items.add(helmet);
        items.add(chestplate);
        items.add(pants);
        items.add(shoes);
        items.add(shield);
        items.add(sword);
        items.add(character);
        items.add(background);
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
}
