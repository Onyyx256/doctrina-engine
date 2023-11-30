package gardeninghell;

import doctrina.Canvas;
import doctrina.ControllableEntity;
import doctrina.GameConfig;
import doctrina.MovementController;

import java.awt.*;

public class Player extends ControllableEntity {
    private boolean downBumping = true;
    public Player(MovementController controller) {
        super(controller);
        setDimension(32, 32);
        setYSpeed(4);
        setXSpeed(4);
    }

    public void update() {
        super.update();
        moveWithController();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
        if (GameConfig.isDebugEnabled()) {
            drawHitBox(canvas);
        }
    }

    public boolean isDownBumping() {
        return downBumping;
    }
}
