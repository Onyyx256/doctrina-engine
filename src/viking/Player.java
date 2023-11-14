package viking;

import doctrina.*;
import doctrina.Canvas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends ControllableEntity {

    private static final String SPRITE_PATH = "images/player.png";
    private static final int ANIMATION_SPEED = 8;

    private BufferedImage spriteSheet;
    private SpriteAnimation rightFrames;
    private SpriteAnimation leftFrames;
    private SpriteAnimation upFrames;
    private SpriteAnimation downFrames;
    private int currentAnimationFrame = 1; // idle frame (middle)
    private int nextFrame = ANIMATION_SPEED;

    public Player(MovementController controller) {
        super(controller);
        setDimension(32, 32);
        setSpeed(3);
        load();
    }

    @Override
    public void update() {
        super.update();
        moveWithController();
        if (hasMoved()) {
            --nextFrame;
            if (nextFrame == 0) {
                ++currentAnimationFrame;
                // if (currentAnimationFrame >= leftFrames.length) {
                //    currentAnimationFrame = 0;
                //}
                nextFrame = ANIMATION_SPEED;
            }
        } else {
            currentAnimationFrame = 1; // idle
        }
    }

    @Override
     public void draw(Canvas canvas) {
        /* if (getDirection() == Direction.RIGHT) {
            canvas.drawImage(rightFrames[currentAnimationFrame], x, y);
        } else if (getDirection() == Direction.LEFT) {
            canvas.drawImage(leftFrames[currentAnimationFrame], x, y);
        } else if (getDirection() == Direction.UP) {
            canvas.drawImage(upFrames[currentAnimationFrame], x, y);
        } else if (getDirection() == Direction.DOWN) {
            canvas.drawImage(downFrames[currentAnimationFrame], x, y);
        } */
        if (GameConfig.isDebugEnabled()) {
            drawHitBox(canvas);
        }
    }

    private void load() {
        loadSpriteSheet();
        loadAnimationFrames();
    }

    private void loadSpriteSheet() {
        try {
            spriteSheet = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(SPRITE_PATH));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadAnimationFrames() {
        downFrames = new SpriteAnimation(8, 48, 50);
        leftFrames = new SpriteAnimation(8, 60, 62);
        rightFrames = new SpriteAnimation(8, 72, 74);
        upFrames = new SpriteAnimation(8, 84, 86);
    }
}