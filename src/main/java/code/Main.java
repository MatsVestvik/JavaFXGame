package code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import code.Objects.Character;
import code.Objects.Inventory;
import code.Util.CharacterScene;
import code.Util.SideBar;
import code.Util.InventoryView;

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
        character.equipArmor(inventory.getArmorByType("Helmet"));
        character.equipArmor(inventory.getArmorByType("Chestplate"));
        character.equipArmor(inventory.getArmorByType("Pants"));
        character.equipArmor(inventory.getArmorByType("Shoes"));


        

        SideBar sideBar = new SideBar();
        InventoryView inventoryView = new InventoryView();
        
        // Use BorderPane to organize layout
        BorderPane root = new BorderPane();
        root.setCenter(characterScene.getSceneGroup());  // Character in center
        root.setLeft(sideBar.getSideBarGroup()); // Sidebar on the left
        root.setRight(inventoryView.getInventoryGroup()); // Inventory on the right
        
        Scene scene = new Scene(root, 800, 500); // Increased height for button
        
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