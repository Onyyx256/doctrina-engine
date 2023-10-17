package viking;

import doctrina.ControllableEntity;
import doctrina.MovementController;

import java.awt.*;

public class Player extends ControllableEntity {

    public Player(MovementController controller) {
        super(controller);
        setDimension(32, 32);
        setSpeed(3);
    }

    public void update() {
        super.update();
        moveWithController();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.RED);
    }
}
