package code.Objects;

public class Armor {
    private String imagePath;
    private int shield;
    private int rarity;

    public Armor(String imagePath, int rarity, int shield) {
        this.shield = shield;
        this.imagePath = imagePath;
        this.rarity = rarity;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getRarity() {
        return rarity;
    }
    
    public int getShield() {
        return shield;
    }
}