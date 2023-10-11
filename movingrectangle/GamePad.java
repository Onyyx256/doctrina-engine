package movingrectangle;

import doctrina.MovementController;

import java.awt.event.KeyEvent;

public class GamePad extends MovementController {

    private int quitKey = KeyEvent.VK_Q;

    private int dashKey = KeyEvent.VK_SPACE;

    public GamePad() {
        bindKey(quitKey);
        bindKey(dashKey);
    }

    public boolean isQuitPressed() {
        return isKeyPressed(quitKey);
    }

    public int isSprintPressed() {
        return isKeyPressed(dashKey)? 50 : 1;
    }
}
