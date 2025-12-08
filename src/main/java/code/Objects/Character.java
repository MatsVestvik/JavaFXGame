package code.Objects;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Character {

    
    ColorAdjust rarityEffect = new ColorAdjust();

    private int shield = 0;
    private List<Armor> equippedArmor = new ArrayList<>();
    private final int MAX_ARMOR_PIECES = 4;

    public Character() {
        for (int i = 0; i < 4; i++) {
            equippedArmor.add(null);
        }
    }

    public void equipArmor(Armor armor) {
        if (equippedArmor.size() < MAX_ARMOR_PIECES) {
            if (armor.type().equals("Helmet")) {
                equippedArmor.set(0, armor);
            }
            else if (armor.type().equals("Chestplate")) {
                equippedArmor.set(1, armor);
            }
            else if (armor.type().equals("Pants")) {
                equippedArmor.set(2, armor);
            }
            else if (armor.type().equals("Shoes")) {
                equippedArmor.set(3, armor);
            }
            addImage(armor.getImagePath());
            shield += armor.getShield();
        }
    }

    public void unequipArmor(Armor armor) {
        if (equippedArmor.contains(armor)) {
            int index = equippedArmor.indexOf(armor);
            equippedArmor.set(index, null);
            shield -= armor.getShield();
            removeImage(armor.getImagePath());
        }
    }


}