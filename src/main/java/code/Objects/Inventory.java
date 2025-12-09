package code.Objects;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Armour> items = new ArrayList<>();

    public Inventory() {
        Armour helmet = new Armour("/resources/Basic_Helmet_2.gif", 1, 10, "Helmet");
        Armour chestplate = new Armour("/resources/Basic_Chestplate.gif", 1, 15, "Chestplate");
        Armour pants = new Armour("/resources/Basic_Pants.gif", 1, 12, "Pants");
        Armour shoes = new Armour("/resources/Basic_Shoes.gif", 1, 8, "Shoes");   
        Armour shield = new Armour("/resources/Basic_Shield.gif", 1, 20, "Shield");
        Armour sword = new Armour("/resources/Basic_Sword.gif", 1, 25, "Sword");
        items.add(helmet);
        items.add(chestplate);
        items.add(pants);
        items.add(shoes);
        items.add(shield);
        items.add(sword);
    }

    public List<Armour> getItems() {
        return items;
    }

    public Armour getArmourByType(String type) {
        for (Armour armour : items) {
            if (armour.getType().equals(type)) {
                return armour;
            }
        }
        return null;
    }
}
