package viking;

import doctrina.Blockade;
import doctrina.Canvas;
import doctrina.GameConfig;
import doctrina.StaticEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tree extends StaticEntity {

    private static final String SPRITE_PATH = "images/tree.png";
    private Image image;

    public Tree(int x, int y) {
        teleport(x, y);
        load();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawImage(image, x, y);
    }

    private void load() {
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(SPRITE_PATH));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}