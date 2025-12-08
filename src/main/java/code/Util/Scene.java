package code.Util;

import java.security.PublicKey;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Scene {
    HBox sceneBox;
    public Group sceneGroup = new Group();
    
    public Scene() {
        sceneBox = new HBox(20); // 20px spacing
        sceneBox.setAlignment(Pos.CENTER);
        sceneBox.setPadding(new Insets(15));
        sceneBox.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc; -fx-border-width: 1 0 0 0;");
    }
}
    public HBox getSceneBox() {
        return sceneBox;
    }

    addItemToScene(javafx.scene.Node item) {
        sceneBox.getChildren().add(item);
    }

    public void removeImage(String imagePath) {
        // Normalize the path to just get filename
        String filename = imagePath.substring(imagePath.lastIndexOf('/') + 1);
        
        characterGroup.getChildren().removeIf(node -> {
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

    public void addImage(String imagePath) {
        Image img = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(500);
        imgView.setPreserveRatio(true);
        sceneGroup.getChildren().add(imgView);
        imgView.setEffect(rarityEffect);
    }
}