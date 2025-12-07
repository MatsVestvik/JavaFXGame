package code;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Group characterGroup = new Group();
    private int clickCount = 0;
    private Label clickLabel;

    /**
     * Add an image to the character group.
     * @param imagePath
     */
    private void addImage(String imagePath) {
        Image img = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(500);
        imgView.setPreserveRatio(true);
        characterGroup.getChildren().add(imgView);
    }
    
    /**
     * Start the JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) {
        // Add character images
        addImage("/resources/Basic_Background.png");
        addImage("/resources/Basic_Character.gif");
        
        
        
        // Create button with click handler
        Button actionButton = new Button("Click Me!");
        actionButton.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");
        
        // Button click event handler
        actionButton.setOnAction(event -> {
            clickCount++;
            
            if (clickCount == 1) {
                addImage("/resources/Basic_Helmet_2.gif");
            }
            else if (clickCount == 2) {
                addImage("/resources/Basic_Chestplate.gif");
            }
            else if (clickCount == 3) {
                addImage("/resources/Basic_Pants.gif");
            }
            else if (clickCount == 4) {
                addImage("/resources/Basic_Shoes.gif");
            }
            else if (clickCount > 4) {
                clickCount = 0;
                characterGroup.getChildren().clear();
                addImage("/resources/Basic_Background.png");
                addImage("/resources/Basic_Character.gif");
                
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
        root.setCenter(characterGroup);  // Character in center
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