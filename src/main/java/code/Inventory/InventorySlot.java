package code.Inventory;

import code.Objects.Item;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class InventorySlot {
    private StackPane container;
    private Rectangle background;
    private ImageView imageView;
    private Text slotNumberText;
    private Object itemData;
    private Item item; 
    private int slotIndex;
    private boolean isEmpty;
    
    public InventorySlot(int size, int slotIndex) {
        this.slotIndex = slotIndex;
        this.isEmpty = true;
        
        createSlot(size);
    }
    
    private void createSlot(int size) {
        // Create background
        background = new Rectangle(size, size);
        background.setFill(Color.rgb(117, 117, 117));
        background.setStroke(Color.rgb(0, 0, 0));
        background.setStrokeWidth(2);
        background.setArcWidth(10);
        background.setArcHeight(10);
        
        // Create image view (initially empty)
        imageView = new ImageView();
        imageView.setFitWidth(size - 10);
        imageView.setFitHeight(size - 10);
        imageView.setPreserveRatio(true);
        imageView.setVisible(false);
        
        // Create slot number text (for debugging)
        slotNumberText = new Text(String.valueOf(slotIndex + 1));
        slotNumberText.setFont(Font.font(12));
        slotNumberText.setFill(Color.rgb(187, 187, 187));
        
        // Create container
        container = new StackPane();
        container.getChildren().addAll(background, imageView, slotNumberText);
        container.setCursor(Cursor.HAND);
        
        // Add hover effects
        container.setOnMouseEntered(e -> {
            background.setFill(Color.rgb(219, 219, 219));
        
            background.setStroke(Color.rgb(70, 70, 70));
            background.setStrokeWidth(2);
        });
        
        container.setOnMouseExited(e -> {
            background.setFill(isEmpty ? 
                Color.rgb(117, 117, 117) : 
                Color.rgb(117, 117, 117));
            background.setStroke(Color.rgb(0, 0, 0));
            background.setStrokeWidth(2);
        });
        
        // Click handler
        container.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                if (clickListenerInventory != null) {
                    clickListenerInventory.onSlotClicked(slotIndex, item);
                }
            } else if (e.getButton() == MouseButton.SECONDARY) {
                // Right-click to clear?
                clearItem();
            }
        });
    }
    
    public boolean setItem(Item item) {
        try {
            Image image = new Image(getClass().getResourceAsStream(item.getImagePath()));
            imageView.setImage(image);

            if (item instanceof Item) {
                Item armourItem = (Item) item;
                Item.applyRarityTint(imageView, armourItem.getRarity());
            } else if (item instanceof Item) {
                // If Item class has a tint method
                Item.applyRarityTint(imageView, item.getRarity());
            }

            imageView.setVisible(true);
            slotNumberText.setVisible(false);
            this.item = item;
            this.itemData = item.getType();
            this.isEmpty = false;
            
            return true;
        } catch (Exception e) {
            System.out.println("Failed to load image: " + item.getImagePath());
            return false;
        }
    }
    
    public StackPane getContainer() {
        return container;
    }
    
    public Object getItemData() {
        return itemData;
    }
    
    public boolean isEmpty() {
        return isEmpty;
    }
    
    public int getSlotIndex() {
        return slotIndex;
    }
    
    private InventoryGrid.SlotClickListener clickListenerInventory;
    
    public void setOnClickedInventory(InventoryGrid.SlotClickListener listener) {
        this.clickListenerInventory = listener;
    }

    public boolean setItem(String imagePath, Item armour) {
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            imageView.setImage(image);
            imageView.setVisible(true);
            slotNumberText.setVisible(false);
            this.item = armour;  // Store the Armour object
            this.isEmpty = false;
            
            background.setFill(Color.rgb(44, 62, 80));
            return true;
        } catch (Exception e) {
            System.out.println("Failed to load image: " + imagePath);
            return false;
        }
    }
    
    public Item getArmour() {
        return item;
    }
    
    public boolean clearItem() {
        imageView.setImage(null);
        imageView.setVisible(false);
        slotNumberText.setVisible(true);
        this.item = null;  // Clear the Armour object
        isEmpty = true;
        
        background.setFill(Color.rgb(52, 73, 94));
        return true;
    }
}
