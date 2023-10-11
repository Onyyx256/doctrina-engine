package movingrectangle;

import doctrina.Canvas;

import java.awt.*;

public class Player {

    private GamePad gamePad;
    private int x;
    private int y;
    private int speed;

    public Player(GamePad gamePad) {
        x = 200;
        y = 200;
        speed = 3;
        this.gamePad = gamePad;
    }

    public void update(int dashLength) {
        if (gamePad.isDownPressed()) {
            y += speed + dashLength;
        } else if (gamePad.isUpPressed()) {
            y -= speed + dashLength;
        } else if (gamePad.isLeftPressed()) {
            x -= speed + dashLength;
        } else if (gamePad.isRightPressed()) {
            x += speed + dashLength;
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRectangle(x, y, 20, 60, Color.WHITE);
    }
}
