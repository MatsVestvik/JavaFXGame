package code.Objects;

public class Armour {
    private String imagePath;
    private int shield;
    private int rarity;
    private final String type;

    public Armour(String imagePath, int rarity, int shield, String type) {
        this.shield = shield;
        this.imagePath = imagePath;
        this.rarity = rarity;
        this.type = type;
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
    public String getType() {
        return type;
    }
}