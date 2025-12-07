package code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Load an image from file system
        //Image image = new Image("file:resources/Basic_Character.gif");  // From current directory
        
        // OR load from resources folder (inside your project)
        Image image = new Image(getClass().getResourceAsStream("/resources/Basic_Character.gif"));
        
        // Create ImageView to display the image
        ImageView imageView = new ImageView(image);
        
        // Optional: Set image size
        imageView.setFitWidth(300);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true); // Keep aspect ratio
        
        // Use VBox to stack label and image vertically
        VBox root = new VBox(10, imageView); // 10 is spacing
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");
        
        Scene scene = new Scene(root, 400, 350);
        
        primaryStage.setTitle("JavaFX Window with Image");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}