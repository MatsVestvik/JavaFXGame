package code.Util;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.util.HashMap;
import java.util.Map;

import code.Objects.Item;
import javafx.scene.text.Text;

public class CharacterScene {
    HBox sceneBox;
    public Group sceneGroup = new Group();
    
    // Keep track of ImageViews by their original image path
    private Map<String, ImageView> imageViewsByPath = new HashMap<>();
    private Map<Integer, Group> layers = new HashMap<>();
    
    public CharacterScene() {

        sceneBox = new HBox(20);
        sceneBox.setAlignment(Pos.CENTER);
        sceneBox.setPadding(new Insets(15));
        sceneBox.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc; -fx-border-width: 1 0 0 0;");

        for (int i = 0; i <= 7; i++) {
            Group layer = new Group();
            layers.put(i, layer);
            sceneGroup.getChildren().add(layer);
        }
    }

    public void removeItem(String imagePath) {
        ImageView imageView = imageViewsByPath.get(imagePath);
        if (imageView != null) {
            // Remove from all layers
            for (Group layer : layers.values()) {
                layer.getChildren().remove(imageView);
            }
            imageViewsByPath.remove(imagePath);
            System.out.println("Removed item: " + imagePath);
            return;
        } else {
            System.out.println("Item not found for removal: " + imagePath);
        }
    }

    public void addItem(Item item) {
        try {
            // Check if item already exists
            if (imageViewsByPath.containsKey(item.getImagePath())) {
                System.out.println("Item already exists: " + item.getImagePath());
                return;
            }
            
            Image img = new Image(getClass().getResourceAsStream(item.getImagePath()));
            if (img.isError()) {
                System.out.println("Failed to load image: " + item.getImagePath());
                return;
            }
            
            ImageView imgView = item.getTintedImageView();
            imgView.setFitWidth(700);
            imgView.setPreserveRatio(true);
            
            // Store reference with the exact imagePath used
            imageViewsByPath.put(item.getImagePath(), imgView);

            int layerNumber = getLayerByType(item.getType());
            
            // Add to the appropriate layer group
            if (layerNumber >= 0 && layerNumber <= 7) {
                layers.get(layerNumber).getChildren().add(imgView);
            } else {
                // Default to layer 0 if unknown type
                layers.get(0).getChildren().add(imgView);
            }
            
            System.out.println("Added item: " + item.getImagePath());
            
            // Debug: Print all current items
            System.out.println("Current items in map: " + imageViewsByPath.keySet());
        } catch (Exception e) {
            System.out.println("Error adding item: " + item.getImagePath() + " - " + e.getMessage());
        }
    }

    public Group getSceneGroup() {
        return sceneGroup;
    }

    private int getLayerByType(String type) {
        switch (type.toLowerCase()) {
            case "background": return 0;
            case "character": return 1;
            case "helmet": return 2;
            case "chestplate": return 3;
            case "pants": return 4;
            case "shoes": return 5;
            case "sword": return 6;
            case "shield": return 7;
            default: return -1;
        }
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