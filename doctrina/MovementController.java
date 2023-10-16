package doctrina;

import java.awt.event.KeyEvent;

public class MovementController extends Controller {

    private int upKey = KeyEvent.VK_UP;
    private int downKey = KeyEvent.VK_DOWN;
    private int rightKey = KeyEvent.VK_RIGHT;
    private int leftKey = KeyEvent.VK_LEFT;
    private int dashKey = KeyEvent.VK_SPACE;

    public MovementController() {
        bindKey(upKey);
        bindKey(downKey);
        bindKey(leftKey);
        bindKey(rightKey);
    }

    public void useWASDKey() {
        setUpKey(KeyEvent.VK_W);
        setDownKey(KeyEvent.VK_S);
        setRightKey(KeyEvent.VK_A);
        setLeftKey(KeyEvent.VK_D);
    }

    public boolean isLeftPressed() {
        return isKeyPressed(leftKey);
    }

    public Direction getDirection() {
        if (isLeftPressed()) {
            return Direction.LEFT;
        }
        if (isRightPressed()) {
            return Direction.RIGHT;
        }
        if (isUpPressed()) {
            return Direction.UP;
        }
        if (isDownPressed()) {
            return Direction.DOWN;
        }
        return null;
    }

    public boolean isRightPressed() {
        return isKeyPressed(rightKey);
    }

    public boolean isDownPressed() {
        return isKeyPressed(downKey);
    }

    public boolean isUpPressed() {
        return isKeyPressed(upKey);
    }

    public boolean isMoving() {
        return isDownPressed() || isLeftPressed()
                || isRightPressed() || isUpPressed();
    }

    public void setDownKey(int keyCode) {
        removeKey(downKey);
        bindKey(keyCode);
        this.downKey = keyCode;
    }

    public void setUpKey(int keyCode) {
        removeKey(upKey);
        bindKey(keyCode);
        this.upKey = keyCode;
    }

    public void setRightKey(int keyCode) {
        removeKey(rightKey);
        bindKey(keyCode);
        this.rightKey = keyCode;
    }

    public void setLeftKey(int keyCode) {
        removeKey(leftKey);
        bindKey(keyCode);
        this.leftKey = keyCode;
    }

    public void setDashKey(int keyCode) {
        removeKey(dashKey);
        bindKey(keyCode);
        this.dashKey = keyCode;
    }
}
