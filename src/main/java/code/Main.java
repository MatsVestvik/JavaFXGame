package code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import code.Objects.Character;
import code.Util.SideBar;

public class Main extends Application {
    
    private int clickCount = 0;
    ColorAdjust rarityEffect = new ColorAdjust();

    Character character = new Character();

    private int hatCounter = 0;
    private int chestCounter = 0;
    private int pantsCounter = 0;
    private int shoesCounter = 0;
    
    /**
     * Start the JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) {
        // Add character images
        character.addImage("/resources/Basic_Background.png");
        character.addImage("/resources/Basic_Character.gif");
        
        
        // Create a container for the button and label at the bottom
        SideBar sideBar = new SideBar();
        HBox bottomContainer = sideBar.createSideBar();

        sideBar.getButton(0).setOnAction(event -> {
            hatCounter++;

            if (hatCounter%2!=0) {
                character.equipHelmet("/resources/Basic_Helmet_2.gif", 1, 10);
            }
            else if (hatCounter%2==0) {
                character.characterGroup.getChildren().clear();
            }
        });
        
        // Use BorderPane to organize layout
        BorderPane root = new BorderPane();
        root.setCenter(character.characterGroup);  // Character in center
        root.setLeft(bottomContainer); // Button at bottom
        
        Scene scene = new Scene(root, 700, 500); // Increased height for button
        
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