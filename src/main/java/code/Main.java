package code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import code.Inventory.EquippedGrid;
import code.Inventory.InventoryGrid;
import code.Objects.Character;
import code.Objects.Inventory;
import code.Util.CharacterScene;
import code.Objects.Armour;

public class Main extends Application {

    Character character = new Character();
    
    /**
     * Start the JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) {
        Inventory inventory = new Inventory();

        Character character = new Character();
        CharacterScene characterScene = character.getCharacterScene();
        characterScene.addItem("/resources/Basic_Background.png");
        characterScene.addItem("/resources/Basic_Character.gif");
        
        InventoryGrid inventoryGrid = character.getInventoryGrid();
        
        // Set click listener
        inventoryGrid.setOnSlotClicked((slotIndex, itemData) -> {
            System.out.println("selected slot: " + slotIndex);
            character.equipArmour(inventoryGrid.getItemFromSlot(slotIndex));
            inventoryGrid.removeItemFromSlot(slotIndex);
            System.out.println(character.getShield());
        });

        EquippedGrid equippedGrid = character.getEquippedGrid();

        equippedGrid.setOnSlotClicked((slotIndex, itemData) -> {
            System.out.println("unequipping slot: " + slotIndex);
            character.unequipArmour(equippedGrid.getItemFromSlot(slotIndex));
        });
        
        // Add some example items
        inventoryGrid.addItemToSlot(0, inventory.getArmourByType("Helmet"));
        inventoryGrid.addItemToSlot(1, inventory.getArmourByType("Chestplate"));
        inventoryGrid.addItemToSlot(2, inventory.getArmourByType("Pants"));
        inventoryGrid.addItemToSlot(3, inventory.getArmourByType("Shoes"));
        inventoryGrid.addItemToSlot(4, inventory.getArmourByType("Shield"));
        
        // Use BorderPane to organize layout
        BorderPane root = new BorderPane();
        root.setCenter(characterScene.getSceneGroup());  // Character in center
        root.setRight(inventoryGrid.getGrid()); // Inventory on the right
        root.setLeft(character.getEquippedGrid().getGrid()); // Equipped items on the left
        
        Scene scene = new Scene(root, 1100, 500); // Increased height for button
        
        primaryStage.setTitle("Character with Armour Overlay and Controls");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Main method - launch the JavaFX application.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Main.main() starting - calling Application.launch");
        System.out.flush();
        launch(args);
    }
}