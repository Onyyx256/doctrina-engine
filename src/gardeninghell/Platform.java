package gardeninghell;

import doctrina.Blockade;
import doctrina.Canvas;
import doctrina.GameConfig;
import doctrina.StaticEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Platform extends StaticEntity {
    private Blockade blockade;
    private final int WIDTH = 60;
    private final int HEIGHT = 12;
    public Platform(int x, int y) {
        teleport(x, y);
        setDimension(WIDTH, HEIGHT);
        blockade = new Blockade();
        blockade.teleport(x, y);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.CYAN);
        if (GameConfig.isDebugEnabled() && blockade != null) {
            blockade.draw(canvas);
        }
    }

    public void enableBlockade() {
        blockade.setDimension(WIDTH, HEIGHT);
    }

    public void disableBlockade() {
        blockade.setDimension(0, 0);
    }
}
