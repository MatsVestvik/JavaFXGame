package code;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        

        Character character = new Character();
        CharacterScene characterScene = character.getCharacterScene();
        Inventory inventory = new Inventory(character);
        
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
        Image backGroundImage = new Image("/resources/Dungeon/Dungeon.png");
        
        ImageView backGroundImageView = new ImageView(backGroundImage);
        backGroundImageView.setFitWidth(Screen.getPrimary().getBounds().getWidth());
        backGroundImageView.setFitHeight(Screen.getPrimary().getBounds().getHeight()/2);
        Group backgroundGroup = new Group(backGroundImageView);
        backgroundGroup.getChildren().addAll();
        
        // Use BorderPane to organize layout
        BorderPane root = new BorderPane();
        root.setCenter(characterScene.getSceneGroup());  // Character in center
        root.setRight(inventoryGrid.getGrid()); // Inventory on the right
        root.setLeft(character.getEquippedGrid().getGrid());
        root.setTop(backgroundGroup);  // Equipped items on the left

        Scene scene = new Scene(root, Color.BLACK); 
        
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