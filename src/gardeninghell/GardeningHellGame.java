package gardeninghell;

import doctrina.Canvas;
import doctrina.Game;
import gardeninghell.GamePad;
import gardeninghell.Player;

import java.awt.*;

public class GardeningHellGame extends Game {
    private GamePad gamePad;
    private Player player;
    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);

    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        //canvas.drawRectangle(canvas, Color.BLACK);
    }
}
