package code.Objects;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Armor> items = new ArrayList<>();
    private final int maxCapacity = 20;

    public Inventory() {
        Armor helmet = new Armor("/resources/Basic_Helmet_2.gif", 1, 10, "Helmet");
        Armor chestplate = new Armor("/resources/Basic_Chestplate_2.gif", 1, 15, "Chestplate");
        Armor pants = new Armor("/resources/Basic_Pants_2.gif", 1, 12, "Pants");
        Armor shoes = new Armor("/resources/Basic_Shoes_2.gif", 1, 8, "Shoes");   
        items.add(helmet);
        items.add(chestplate);
        items.add(pants);
        items.add(shoes);
    }

    public List<Armor> getItems() {
        return items;
    }

    public Armor getArmorByType(String type) {
        for (Armor armor : items) {
            if (armor.type().equals(type)) {
                return armor;
            }
        }
        return null;
    }
}
