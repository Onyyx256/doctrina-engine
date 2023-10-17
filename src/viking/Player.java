package viking;

import doctrina.ControllableEntity;
import doctrina.Direction;
import doctrina.MovementController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends ControllableEntity {

    private static final String SPRITE_PLATE = "images/player.png";
    private static final int ANIMATION_SPEED = 8;

    private BufferedImage spriteSheet;
    private Image[] rightFrame;
    private Image[] leftFrame;
    private Image[] upFrame;
    private Image[] downFrame;
    private int currentAnimationFrame = 1; // idle frame
    private int nextFrame = ANIMATION_SPEED;

    public Player(MovementController controller) {
        super(controller);
        setDimension(32, 32);
        setSpeed(3);
        load();
    }

    public void update() {
        super.update();
        moveWithController();
        if (hasMoved()) {
            --nextFrame;
            if (nextFrame == 0) {
                ++currentAnimationFrame;
                if (currentAnimationFrame >= leftFrame.length) {
                    currentAnimationFrame = 0;
                }
                nextFrame = ANIMATION_SPEED;
            }
        } else {
            currentAnimationFrame = 1; //idle
        }
    }

    @Override
    public void draw(doctrina.Canvas canvas) {
        if (getDirection() == Direction.RIGHT) {
            canvas.drawImage(rightFrame[currentAnimationFrame], x, y);
        } else if (getDirection() == Direction.LEFT) {
            canvas.drawImage(leftFrame[currentAnimationFrame], x, y);
        } else if (getDirection() == Direction.UP) {
            canvas.drawImage(upFrame[currentAnimationFrame], x, y);
        }  else if (getDirection() == Direction.DOWN) {
            canvas.drawImage(downFrame[currentAnimationFrame], x, y);
        }
    }

    private void load() {
        loadSpriteSheet();
        loadAnimationFrames();
    }

    private void loadSpriteSheet() {
        try {
            spriteSheet = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(SPRITE_PLATE));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadAnimationFrames() {
        downFrame = new Image[3];
        downFrame[0] = spriteSheet.getSubimage(0, 128, width, height);
        downFrame[1] = spriteSheet.getSubimage(32, 128, width, height);
        downFrame[2] = spriteSheet.getSubimage(64, 128, width, height);

        leftFrame = new Image[3];
        leftFrame[0] = spriteSheet.getSubimage(0, 160, width, height);
        leftFrame[1] = spriteSheet.getSubimage(32, 160, width, height);
        leftFrame[2] = spriteSheet.getSubimage(64, 160, width, height);

        rightFrame = new Image[3];
        rightFrame[0] = spriteSheet.getSubimage(0, 192, width, height);
        rightFrame[1] = spriteSheet.getSubimage(32, 192, width, height);
        rightFrame[2] = spriteSheet.getSubimage(64, 192, width, height);

        upFrame = new Image[3];
        upFrame[0] = spriteSheet.getSubimage(0, 224, width, height);
        upFrame[1] = spriteSheet.getSubimage(32, 224, width, height);
        upFrame[2] = spriteSheet.getSubimage(64, 224, width, height);
    }
}
