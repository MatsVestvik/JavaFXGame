package code.Util;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Box;

public class SideBar {

    private List<Button> buttons;
    
    public HBox createSideBar(){
        Button[] buttons = {
            new Button("Helmet"),
            new Button("Chestplate"),
            new Button("Pants"),
            new Button("Shoes")
        };
        for (Button button : buttons) {
            button.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");
        }

        HBox sideBar = new HBox(20); // 20px spacing
        sideBar.setAlignment(Pos.CENTER);
        sideBar.setPadding(new Insets(15));
        sideBar.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc; -fx-border-width: 1 0 0 0;");
        sideBar.getChildren().addAll(buttons);
        return sideBar;
    }

    public Button getButton(int index) {
        return buttons.get(index);
    }
}
