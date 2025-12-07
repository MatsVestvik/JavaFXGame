package code.Objects;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Character {
    private int helmet;
    private int chestplate;
    private int pants;
    private int shoes;
    public Group characterGroup = new Group();
    ColorAdjust rarityEffect = new ColorAdjust();
    private List<Armor> equippedArmor = new ArrayList<>();

    public Character() {
        this.helmet = 0;
        this.chestplate = 0;
        this.pants = 0;
        this.shoes = 0;
    }

    public void equipHelmet(String imagePath, int rarity, int shield) {
        Armor helmet = new Armor(imagePath, rarity, shield);
        equippedArmor.add(helmet);
        this.helmet = 1;
        addImage(imagePath);
    }
    public void equipChestplate(String imagePath, int rarity, int shield) {
        Armor chestplate = new Armor(imagePath, rarity, shield);
        equippedArmor.add(chestplate);
        this.chestplate = 1;    
        addImage(imagePath);
    }
    public void equipPants(String imagePath, int rarity, int shield) {
        Armor pants = new Armor(imagePath, rarity, shield);
        equippedArmor.add(pants);
        this.pants = 1;
        addImage(imagePath);
    }
    public void equipShoes(String imagePath, int rarity, int shield) {
        Armor shoes = new Armor(imagePath, rarity, shield);
        equippedArmor.add(shoes);
        this.shoes = 1;
        addImage(imagePath);
    }

    public void addImage(String imagePath) {
        Image img = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(500);
        imgView.setPreserveRatio(true);
        characterGroup.getChildren().add(imgView);
        imgView.setEffect(rarityEffect);
    }
}