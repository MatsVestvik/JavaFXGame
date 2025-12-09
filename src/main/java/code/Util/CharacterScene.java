package code.Util;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.util.HashMap;
import java.util.Map;

public class CharacterScene {
    HBox sceneBox;
    public Group sceneGroup = new Group();
    
    // Keep track of ImageViews by their original image path
    private Map<String, ImageView> imageViewsByPath = new HashMap<>();
    
    public CharacterScene() {
        sceneBox = new HBox(20);
        sceneBox.setAlignment(Pos.CENTER);
        sceneBox.setPadding(new Insets(15));
        sceneBox.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc; -fx-border-width: 1 0 0 0;");
    }

    public void removeItem(String imagePath) {
        ImageView imageView = imageViewsByPath.get(imagePath);
        if (imageView != null) {
            sceneGroup.getChildren().remove(imageView);
            imageViewsByPath.remove(imagePath);
            System.out.println("Removed item: " + imagePath);
        } else {
            System.out.println("Item not found for removal: " + imagePath);
        }
    }

    public void addItem(String imagePath) {
        try {
            // Check if item already exists
            if (imageViewsByPath.containsKey(imagePath)) {
                System.out.println("Item already exists: " + imagePath);
                return;
            }
            
            Image img = new Image(getClass().getResourceAsStream(imagePath));
            if (img.isError()) {
                System.out.println("Failed to load image: " + imagePath);
                return;
            }
            
            ImageView imgView = new ImageView(img);
            imgView.setFitWidth(500);
            imgView.setPreserveRatio(true);
            
            // Store reference with the exact imagePath used
            imageViewsByPath.put(imagePath, imgView);
            sceneGroup.getChildren().add(imgView);
            
            System.out.println("Added item: " + imagePath);
            
            // Debug: Print all current items
            System.out.println("Current items in map: " + imageViewsByPath.keySet());
        } catch (Exception e) {
            System.out.println("Error adding item: " + imagePath + " - " + e.getMessage());
        }
    }

    public Group getSceneGroup() {
        return sceneGroup;
    }
    
    // Optional: Method to clear all items
    public void clearAllItems() {
        sceneGroup.getChildren().clear();
        imageViewsByPath.clear();
    }
    
    // Optional: Method to check if item exists
    public boolean hasItem(String imagePath) {
        return imageViewsByPath.containsKey(imagePath);
    }
}