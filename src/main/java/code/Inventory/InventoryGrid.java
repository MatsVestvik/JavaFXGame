package code.Inventory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.List;

import code.Objects.Armour;

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
        grid.setStyle("-fx-background-color: #2a2a2aff; -fx-background-radius: 10;");
        
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
    public boolean addItemToSlot(int slotIndex, Armour armour) {
        if (slotIndex < 0 || slotIndex >= slots.size()) {
            return false;
        }
        return slots.get(slotIndex).setItem(armour);
    }
    
    // Add item to first available slot
    public int addItemToFirstAvailable(Armour armour) {
        for (InventorySlot slot : slots) {
            if (slot.isEmpty()) {
                slot.setItem(armour);
                return slot.getSlotIndex();
            }
        }
        return -1; // No available slots
    }

    public Armour getItemFromSlot(int slotIndex) {
        Armour armour = slots.get(slotIndex).getArmour();
        return armour;
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
            slot.setOnClickedInventory(listener);
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
