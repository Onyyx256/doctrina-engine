package doctrina;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Loader {
    private BufferedImage spriteSheet;
    private String spritePlate;

    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

    public Loader (String spritePlate) {
        this.spritePlate = spritePlate;
        loadSpriteSheet();
    }

    private void loadSpriteSheet() {
        try {
            spriteSheet = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(spritePlate));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
