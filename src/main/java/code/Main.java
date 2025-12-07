package code;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import code.Objects.Character;

public class Main extends Application {
    
    private int clickCount = 0;
    ColorAdjust rarityEffect = new ColorAdjust();

    Character character = new Character();
    
    /**
     * Start the JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) {
        // Add character images
        character.addImage("/resources/Basic_Background.png");
        character.addImage("/resources/Basic_Character.gif");
        
        
        
        // Create button with click handler
        Button actionButton = new Button("Click Me!");
        actionButton.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");
        
        // Button click event handler
        actionButton.setOnAction(event -> {
            clickCount++;
            
            if (clickCount == 1) {
                character.equipHelmet("/resources/Basic_Helmet_2.gif", 1, 10);
            }
            else if (clickCount == 2) {
                character.equipChestplate("/resources/Basic_Chestplate.gif", 2, 20);
                rarityEffect.setHue(1); // Apply blue hue effect to indicate rarity
            }
            else if (clickCount == 3) {
                character.equipPants("/resources/Basic_Pants.gif", 1, 15);
            }
            else if (clickCount == 4) {
                character.equipShoes("/resources/Basic_Shoes.gif", 1, 10);
            }
            else if (clickCount > 4) {
                clickCount = 0;
                character.characterGroup.getChildren().clear();
                character.addImage("/resources/Basic_Background.png");
                character.addImage("/resources/Basic_Character.gif");
                
            }
        });
        
        // Create a container for the button and label at the bottom
        HBox bottomContainer = new HBox(20); // 20px spacing
        bottomContainer.setAlignment(Pos.CENTER);
        bottomContainer.setPadding(new Insets(15));
        bottomContainer.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc; -fx-border-width: 1 0 0 0;");
        bottomContainer.getChildren().addAll(actionButton);
        
        // Use BorderPane to organize layout
        BorderPane root = new BorderPane();
        root.setCenter(character.characterGroup);  // Character in center
        root.setBottom(bottomContainer); // Button at bottom
        
        Scene scene = new Scene(root, 500, 600); // Increased height for button
        
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