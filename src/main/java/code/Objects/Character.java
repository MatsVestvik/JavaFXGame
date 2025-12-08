package code.Objects;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import code.Util.CharacterScene;

public class Character {
    public CharacterScene scene = new CharacterScene();

    
    ColorAdjust rarityEffect = new ColorAdjust();

    private int shield = 0;
    private List<Armor> equippedArmor = new ArrayList<>();
    private final int MAX_ARMOR_PIECES = 4;

    public Character() {
        for (int i = 0; i < 4; i++) {
            equippedArmor.add(null);
        }
    }

    public CharacterScene getCharacterScene() {
        return scene;
    }

    public void equipArmor(Armor armor) {
        int slotIndex = getSlotIndexForArmorType(armor.type());
        
        if (slotIndex == -1) {
            System.out.println("Invalid armor type: " + armor.type());
            return;
        }
        
        // Check if slot is occupied
        if (equippedArmor.get(slotIndex) != null) {
            System.out.println(armor.type() + " slot is already occupied!");
            return;
        }
        
        // Equip the armor
        equippedArmor.set(slotIndex, armor);
        
        // Add to scene
        if (scene != null) {
            scene.addItem(armor.getImagePath());
        } else {
            System.out.println("Scene is not set!");
        }
        
        // Update shield
        shield += armor.getShield();
    }

    private int getSlotIndexForArmorType(String armorType) {
        switch (armorType.toLowerCase()) {
            case "helmet": return 0;
            case "chestplate": return 1;
            case "pants": return 2;
            case "shoes": return 3;
            default: return -1;
        }
    }

    public void unequipArmor(Armor armor) {
        if (equippedArmor.contains(armor)) {
            int index = equippedArmor.indexOf(armor);
            equippedArmor.set(index, null);
            shield -= armor.getShield();
            scene.removeItem(armor.getImagePath());
        }
    }


}