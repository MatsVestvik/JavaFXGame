package code;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Group root = new Group();

    private void addImage(String imagePath) {
        Image img = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(500);
        imgView.setPreserveRatio(true);
        root.getChildren().add(imgView);
    }
    
    @Override
    public void start(Stage primaryStage) {
        addImage("/resources/Basic_Character.gif");
        addImage("/resources/Basic_Helmet_2.gif");
        addImage("/resources/Basic_Chestplate.gif");
        addImage("/resources/Basic_Pants.gif");
        addImage("/resources/Basic_Shoes.gif");
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Character with Helmet Overlay");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        System.out.println("Main.main() starting - calling Application.launch");
        System.out.flush();
        launch(args);
    }
}