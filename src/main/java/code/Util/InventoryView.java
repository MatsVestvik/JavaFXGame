package code.Util;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class InventoryView {
    HBox InventoryBar;

    public InventoryView() {
        InventoryBar = new HBox(20); // 20px spacing
        InventoryBar.setAlignment(Pos.CENTER);
        InventoryBar.setPadding(new Insets(15));
        InventoryBar.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc; -fx-border-width: 1 0 0 0;");
    }

    public HBox getInventoryBar() {
        return InventoryBar;
    }

    public void addItemToInventory(javafx.scene.Node item) {
        InventoryBar.getChildren().add(item);
    }

    public void removeItemFromInventory(javafx.scene.Node item) {
        InventoryBar.getChildren().remove(item);
    }
}
