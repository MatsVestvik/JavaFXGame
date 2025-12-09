package code.Objects;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.effect.ColorAdjust;

import code.Util.CharacterScene;
import code.Inventory.EquippedGrid;
import code.Inventory.InventoryGrid;

public class Character {
    public CharacterScene scene = new CharacterScene();
    private EquippedGrid equippedGrid = new EquippedGrid(4, 2, 80);
    private InventoryGrid inventoryGrid = new InventoryGrid(4, 4, 80);

    
    ColorAdjust rarityEffect = new ColorAdjust();

    private int shield = 0;
    private List<Armour> equippedArmour = new ArrayList<>();

    public Character() {
        for (int i = 0; i < 8; i++) {
            equippedArmour.add(null);
        }
    }

    public CharacterScene getCharacterScene() {
        return scene;
    }

    public EquippedGrid getEquippedGrid() {
        return equippedGrid;
    }

    public InventoryGrid getInventoryGrid() {
        return inventoryGrid;
    }

    public void equipArmour(Armour armour) {
        int slotIndex = getSlotIndexForArmorType(armour.getType());
        System.out.println("Equipping...");
        
        if (slotIndex == -1) {
            System.out.println("Invalid armor type: " + armour.getType());
            return;
        }
        
        // Check if slot is occupied
        if (equippedArmour.get(getSlotIndexForArmorType(armour.getType())) != null) {
            System.out.println(armour.getType() + " slot is already occupied!");
            return;
        }
        System.out.println("Equipped " + armour.getType() + " in slot " + slotIndex);
        // Equip the armor
        equippedArmour.set(getSlotIndexForArmorType(armour.getType()), armour);
        equippedGrid.addItemToSlot(slotIndex, armour);
        
        // Add to scene
        if (scene != null) {
            scene.addItem(armour.getImagePath());
        } else {
            System.out.println("Scene is not set!");
        }
        
        // Update shield
        shield += armour.getShield();
    }

    private int getSlotIndexForArmorType(String armorType) {
        switch (armorType.toLowerCase()) {
            case "helmet": return 0;
            case "chestplate": return 2;
            case "pants": return 4;
            case "shield": return 5;
            case "shoes": return 6;
            default: return -1;
        }
    }

    public void unequipArmour(Armour armour) {
        if (equippedArmour.contains(armour)) {
            int index = getSlotIndexForArmorType(armour.getType());
            equippedArmour.set(index, null);
            shield -= armour.getShield();
            scene.removeItem(armour.getImagePath());
            equippedGrid.removeItemFromSlot(index);
            inventoryGrid.addItemToFirstAvailable(armour);
        }
    }

    public int getShield() {
        return shield;
    }

}