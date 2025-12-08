package code.Util;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class CharacterScene {
    HBox sceneBox;
    public Group sceneGroup = new Group();
    
    public CharacterScene() {
        sceneBox = new HBox(20); // 20px spacing
        sceneBox.setAlignment(Pos.CENTER);
        sceneBox.setPadding(new Insets(15));
        sceneBox.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc; -fx-border-width: 1 0 0 0;");
    }

    public void removeItem(String imagePath) {
        // Normalize the path to just get filename
        String filename = imagePath.substring(imagePath.lastIndexOf('/') + 1);
        
        sceneGroup.getChildren().removeIf(node -> {
            if (node instanceof ImageView) {
                ImageView imgView = (ImageView) node;
                String url = imgView.getImage().getUrl();
                if (url == null) return false;
                
                // Get filename from URL
                String urlFilename = url.substring(url.lastIndexOf('/') + 1);
                // Compare ignoring case
                return urlFilename.equalsIgnoreCase(filename);
            }
            return false;
        });
    }

    public void addItem(String imagePath) {
        Image img = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(500);
        imgView.setPreserveRatio(true);
        sceneGroup.getChildren().add(imgView);
    }

    public Group getSceneGroup() {
        return sceneGroup;
    }
}