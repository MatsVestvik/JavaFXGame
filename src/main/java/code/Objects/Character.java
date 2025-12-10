package code.Objects;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.text.Text;
import code.Util.CharacterScene;
import code.Inventory.EquippedGrid;
import code.Inventory.InventoryGrid;

public class Character {
    public CharacterScene scene = new CharacterScene();
    private EquippedGrid equippedGrid = new EquippedGrid(4, 2, 80);
    private InventoryGrid inventoryGrid = new InventoryGrid(4, 4, 80);
    private Text armourLabel = new Text();

    
    ColorAdjust rarityEffect = new ColorAdjust();

    private int shield = 0;
    private List<Item> equippedArmour = new ArrayList<>();

    public Character() {
        armourLabel.setX(50);
        armourLabel.setY(10);
        armourLabel.setText("Shield: " + shield);
        scene.getSceneGroup().getChildren().add(armourLabel);

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

    public Text getArmourLabel() {
        return armourLabel;
    }

    public void equipArmour(Item item, int pressedSquare) {
        
        
        int slotIndex = getSlotIndexForArmorType(item.getType());
        System.out.println("Equipping...");
        
        if (slotIndex == -1) {
            System.out.println("Invalid armor type: " + item.getType());
            return;
        }
        
        // Check if slot is occupied
        if (equippedArmour.get(getSlotIndexForArmorType(item.getType())) != null) {
            System.out.println(item.getType() + " slot is already occupied!");
            return;
        }
        System.out.println("Equipped " + item.getType() + " in slot " + slotIndex);
        // Equip the armor
        equippedArmour.set(getSlotIndexForArmorType(item.getType()), item);
        equippedGrid.addItemToSlot(slotIndex, item);
        inventoryGrid.removeItemFromSlot(pressedSquare);
        
        // Add to scene
        if (scene != null) {
            scene.addItem(item);
        } else {
            System.out.println("Scene is not set!");
        }
        
        // Update shield
        shield += item.getShield();
        armourLabel.setText("Shield: " + shield);
    }

    private int getSlotIndexForArmorType(String armorType) {
        switch (armorType.toLowerCase()) {
            case "helmet": return 0;
            case "character": return 1;
            case "chestplate": return 2;
            case "sword": return 3;
            case "pants": return 4;
            case "shield": return 5;
            case "shoes": return 6;
            case "background": return 7;
            default: return -1;
        }
    }

    private int getLayeringIndexForArmorType(String armorType) {
        switch (armorType.toLowerCase()) {
            case "shield": return 5;
            case "sword": return 4;
            case "helmet": return 3;
            case "chestplate": return 2;
            case "pants": return 1;
            case "shoes": return 0;
            default: return 0;
        }
    }

    public void unequipArmour(Item armour) {
        if (equippedArmour.contains(armour)) {
            int index = getSlotIndexForArmorType(armour.getType());
            equippedArmour.set(index, null);
            shield -= armour.getShield();
            scene.removeItem(armour.getImagePath());
            equippedGrid.removeItemFromSlot(index);
            inventoryGrid.addItemToFirstAvailable(armour);
            armourLabel.setText("Shield: " + shield);
        }
    }

    public int getShield() {
        return shield;
    }

}