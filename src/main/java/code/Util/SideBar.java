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
    HBox sideBar;

    public SideBar() {
        sideBar = new HBox(20); // 20px spacing
        sideBar.setAlignment(Pos.CENTER);
        sideBar.setPadding(new Insets(15));
        sideBar.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc; -fx-border-width: 1 0 0 0;");

        buttons = List.of(
            new Button("Helmet"),
            new Button("Chestplate"),
            new Button("Pants"),
            new Button("Shoes")
        );
        sideBar.getChildren().addAll(buttons);
    }

    public HBox getSideBarGroup() {
        return sideBar;
    }
}
