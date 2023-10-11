package movingrectangle;

import doctrina.MovementController;

import java.awt.event.KeyEvent;

public class GamePad extends MovementController {

    private int quitKey = KeyEvent.VK_Q;

    private int sprintKey = KeyEvent.VK_SPACE;

    public GamePad() {
        bindKey(quitKey);
        bindKey(sprintKey);
    }

    public boolean isQuitPressed() {
        return isKeyPressed(quitKey);
    }

    public int isSprintPressed() {
        return isKeyPressed(sprintKey)? 3 : 1;
    }
}
