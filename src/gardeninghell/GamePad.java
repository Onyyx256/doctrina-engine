package gardeninghell;

import doctrina.MovementController;

import java.awt.event.KeyEvent;

public class GamePad extends MovementController {

    private int quitKey = KeyEvent.VK_ESCAPE;
    private int dashKey = KeyEvent.VK_SPACE;

    public GamePad() {
        bindKey(quitKey);
        bindKey(dashKey);
        useWasdKeys();
    }

    public boolean isQuitPressed() {
        return isKeyPressed(quitKey);
    }

    public boolean isDashPressed() {
        return isKeyPressed(dashKey);
    }
}
