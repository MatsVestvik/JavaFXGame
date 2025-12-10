    package code.Objects;

    import javafx.scene.effect.ColorAdjust;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.paint.Color;

    public class Item {
        private String itemName;
        private String imagePath;
        private int shield;
        private int rarity;
        private final String type;
        private final javafx.scene.image.Image img;

        public Item(String imagePath, int rarity, String type) {
            this.shield = getShieldByType(type)*rarity;
            this.imagePath = imagePath;
            this.rarity = Math.min(Math.max(rarity, 0), RARITY_COLORS.length - 1);
            this.type = type;
            Image img = new Image(getClass().getResourceAsStream(imagePath));
            this.img = img;
            this.itemName =  type+rarity;
        }

        public String getImagePath() {
            return imagePath;
        }

        public javafx.scene.image.Image getImage() {
            return img;
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
        public String getItemName() {
            return itemName;
        }

        private int getShieldByType(String type) {
            switch (type.toLowerCase()) {
                case "helmet": return 3;
                case "chestplate": return 5;
                case "pants": return 4;
                case "shoes": return 2;
                case "shield": return 6;
                default: return 0;
            }
        }
        private static final Color[] RARITY_COLORS = {
            Color.WHITE,  // Placeholder for index 
            Color.GRAY,      // Common
            Color.WHITE,     // Uncommon
            Color.BLUE,      // Rare
            Color.PURPLE,    // Epic
            Color.GOLD       // Legendary
        };

        public ImageView getTintedImageView() {
            ImageView imageView = new ImageView(img);
            return applyRarityTint(imageView, rarity);
        }

        public static ImageView applyRarityTint(ImageView imageView, int rarity) {
            ColorAdjust colorAdjust = new ColorAdjust();
            
            // Set brightness and saturation based on rarity
            switch (rarity) {
                case 0: // Common - Gray
                    break;
                case 1: // Uncommon - White
                    colorAdjust.setHue(0.33);
                    colorAdjust.setBrightness(0.1);
                    colorAdjust.setSaturation(-0.2);
                    break;
                case 2: // Rare - brown 
                    colorAdjust.setHue(0.15); // Purple hue
                    colorAdjust.setSaturation(1);
                    break;
                case 3: // red
                    colorAdjust.setHue(0.05); // Yellow/Gold hue
                    colorAdjust.setSaturation(1);
                    colorAdjust.setBrightness(0.2);
                    break;
                case 4: // blue
                    colorAdjust.setHue(1.); // Blue hue
                    colorAdjust.setSaturation(1.0);
                    break;
                default:
                    // No tint for unknown rarities
            }
            
            imageView.setEffect(colorAdjust);
            return imageView;
        }

        public void setRarityColor(int rarity) {
            this.rarity = Math.min(Math.max(rarity, 0), RARITY_COLORS.length - 1);
        }
    
        // Get the rarity color
        public Color getRarityColor() {
            return RARITY_COLORS[Math.min(rarity, RARITY_COLORS.length - 1)];
        }


        public int getTypeAsInt() {
            switch (type.toLowerCase()) {
                case "helmet": return 0;
                case "chestplate": return 2;
                case "pants": return 4;
                case "shoes": return 6;
                default: return -1;
            }
        }
    }