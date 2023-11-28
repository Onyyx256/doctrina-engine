package viking;

import doctrina.Blockade;
import doctrina.Canvas;
import doctrina.GameConfig;
import doctrina.StaticEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Platform extends StaticEntity {
    private static final String SPRITE_PATH = "images/tree.png";
    private Blockade blockade;
    private Image image;
    public Platform(int x, int y) {
        teleport(x, y);
        setDimension(60, 12);
        blockade = new Blockade();
        blockade.teleport(x, y);
        load();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.CYAN);
        if (GameConfig.isDebugEnabled() && blockade != null) {
            blockade.draw(canvas);
        }
    }

    public void enableBlockade() {
        blockade.setDimension(60, 12);
    }

    public void disableBlockade() {
        blockade.setDimension(0, 0);
    }

    private void load() {
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(SPRITE_PATH));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
