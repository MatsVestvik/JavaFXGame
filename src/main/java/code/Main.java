package code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import code.Inventory.EquippedGrid;
import code.Inventory.InventoryGrid;
import code.Objects.Character;
import code.Objects.Inventory;
import code.Util.CharacterScene;
import code.Objects.Item;

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
        
        InventoryGrid inventoryGrid = character.getInventoryGrid();
        
        // Set click listener
        inventoryGrid.setOnSlotClicked((slotIndex, itemData) -> {
            System.out.println("selected slot: " + slotIndex);
            character.equipArmour(inventoryGrid.getItemFromSlot(slotIndex), slotIndex);
            System.out.println(character.getShield());
        });

        EquippedGrid equippedGrid = character.getEquippedGrid();

        equippedGrid.setOnSlotClicked((slotIndex, itemData) -> {
            System.out.println("unequipping slot: " + slotIndex);
            character.unequipArmour(equippedGrid.getItemFromSlot(slotIndex));
        });
        
        // Add some example items
        inventoryGrid.addItemToSlot(0, inventory.getItemByItemName("Helmet4"));
        inventoryGrid.addItemToSlot(1, inventory.getItemByItemName("Chestplate4"));
        inventoryGrid.addItemToSlot(2, inventory.getItemByItemName("Pants4"));
        inventoryGrid.addItemToSlot(3, inventory.getItemByItemName("Shoes4"));
        inventoryGrid.addItemToSlot(4, inventory.getItemByItemName("Shield4"));
        inventoryGrid.addItemToSlot(5, inventory.getItemByItemName("Sword4"));
        inventoryGrid.addItemToSlot(6, inventory.getItemByItemName("Character0"));
        inventoryGrid.addItemToSlot(7, inventory.getItemByItemName("Background0"));

        inventoryGrid.addItemToSlot(8, inventory.getItemByItemName("Helmet2"));
        inventoryGrid.addItemToSlot(9, inventory.getItemByItemName("Chestplate2"));
        inventoryGrid.addItemToSlot(10, inventory.getItemByItemName("Pants2"));
        inventoryGrid.addItemToSlot(11, inventory.getItemByItemName("Shoes2"));
        inventoryGrid.addItemToSlot(12, inventory.getItemByItemName("Shield2"));
        inventoryGrid.addItemToSlot(13, inventory.getItemByItemName("Sword2"));
    
        // Use BorderPane to organize layout
        BorderPane root = new BorderPane();
        root.setCenter(characterScene.getSceneGroup());  // Character in center
        root.setRight(inventoryGrid.getGrid()); // Inventory on the right
        root.setLeft(character.getEquippedGrid().getGrid()); // Equipped items on the left
        
        /*
        Screen screen = Screen.getPrimary();
        double maxheight = screen.getBounds().getHeight();
        double maxwidth = screen.getBounds().getWidth();
        */
        Text armourLabel = new Text();
        armourLabel.setText("jfidslkjfipojoxsja");
        armourLabel.setX(50);
        armourLabel.setY(10);
        characterScene.getSceneGroup().getChildren().add(armourLabel);

        Scene scene = new Scene(root, Color.BLACK); // Increased height for button
        
        Image icon = new Image("/resources/Basic_Character.gif");
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("Dungeons & Doors");
        primaryStage.setScene(scene);
        
        //primaryStage.setFullScreen(true);
        primaryStage.setMaximized(true);
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