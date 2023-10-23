package tank;

import doctrina.ControllableEntity;
import doctrina.MovementController;

import java.awt.*;

public class Tank extends ControllableEntity {
    private int cooldown;

    public Tank(MovementController controller) {
        super(controller);
        setDimension(30, 30);
        setSpeed(3);
        teleport(100, 100);
    }

    public Missile fire() {
        cooldown = 50;
        return new Missile(this);
    }

    public boolean canFire() {
        return cooldown == 0;
    }

    @Override
    public void update() {
        super.update();
        moveWithController();
        cooldown--;
        if (cooldown < 0) {
            cooldown = 0;
        }
    }

    @Override
    public void draw(doctrina.Canvas canvas) {
        canvas.drawRectangle(this, Color.GREEN);
        int cooldownWidth = cooldown * width / 50;
        canvas.drawRectangle(x, y - 5, cooldownWidth, 2, Color.GREEN);
        if (hasMoved()) {
            drawHitBox(canvas);
        }
    }
}