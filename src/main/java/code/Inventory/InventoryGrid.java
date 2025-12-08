package code.Inventory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class InventoryGrid {
    private GridPane grid;
    private List<InventorySlot> slots;
    private int rows;
    private int cols;
    private int slotSize;
    
    public InventoryGrid(int rows, int cols, int slotSize) {
        this.rows = rows;
        this.cols = cols;
        this.slotSize = slotSize;
        this.slots = new ArrayList<>();
        
        createGrid();
    }
    
    private void createGrid() {
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15));
        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: #2c3e50; -fx-background-radius: 10;");
        
        // Create slots in a grid pattern
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                InventorySlot slot = new InventorySlot(slotSize, row * cols + col);
                slots.add(slot);
                grid.add(slot.getContainer(), col, row);
            }
        }
    }
    
    public GridPane getGrid() {
        return grid;
    }
    
    // Add an item to a specific slot
    public boolean addItemToSlot(int slotIndex, String imagePath, Object itemData) {
        if (slotIndex < 0 || slotIndex >= slots.size()) {
            return false;
        }
        return slots.get(slotIndex).setItem(imagePath, itemData);
    }
    
    // Add item to first available slot
    public int addItemToFirstAvailable(String imagePath, Object itemData) {
        for (InventorySlot slot : slots) {
            if (slot.isEmpty()) {
                slot.setItem(imagePath, itemData);
                return slot.getSlotIndex();
            }
        }
        return -1; // No available slots
    }
    
    // Remove item from slot
    public boolean removeItemFromSlot(int slotIndex) {
        if (slotIndex < 0 || slotIndex >= slots.size()) {
            return false;
        }
        return slots.get(slotIndex).clearItem();
    }
    
    // Get item data from slot
    public Object getItemData(int slotIndex) {
        if (slotIndex < 0 || slotIndex >= slots.size()) {
            return null;
        }
        return slots.get(slotIndex).getItemData();
    }
    
    // Check if slot is empty
    public boolean isSlotEmpty(int slotIndex) {
        if (slotIndex < 0 || slotIndex >= slots.size()) {
            return true;
        }
        return slots.get(slotIndex).isEmpty();
    }
    
    // Set click handler for all slots
    public void setOnSlotClicked(SlotClickListener listener) {
        for (InventorySlot slot : slots) {
            slot.setOnClicked(listener);
        }
    }
    
    // Clear all slots
    public void clearAll() {
        for (InventorySlot slot : slots) {
            slot.clearItem();
        }
    }
    
    // Interface for slot click events
    public interface SlotClickListener {
        void onSlotClicked(int slotIndex, Object itemData);
    }
}
