package gardeninghell;

import doctrina.Canvas;
import doctrina.ControllableEntity;
import doctrina.MovementController;

import java.awt.*;

public class Player extends ControllableEntity {

    private int dashCooldown = 0;

    public Player(MovementController controller) {
        super(controller);
        setDimension(36, 36);
        setSpeed(3);
        teleport(100, 100);
    }

    public boolean canDash() {
        return dashCooldown == 50;
    }

    public void update() {
        super.update();
        moveWithController();
        dashCooldown++;
        if (dashCooldown > 50) {
            dashCooldown = 50;
        }
    }

    public void dash() {
        dashCooldown = 0;

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
        int cooldownWidth = dashCooldown * width / 50;
        canvas.drawRectangle(x, y - 5, cooldownWidth, 2, Color.CYAN);
        if (hasMoved()) {
            drawHitBox(canvas);
        }
    }
}
