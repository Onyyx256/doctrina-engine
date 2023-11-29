package gardeninghell;

import doctrina.Canvas;
import doctrina.Game;

import java.awt.*;

public class GardeningHellGame extends Game {
    private GamePad gamePad;
    private Player player;
    private World world;

    private Platform platform;
    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        player.teleport(200, 200);
        world = new World();
        platform = new Platform(250, 200);
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        player.update();
        if (player.getY() < platform.getY() - 31) {
            platform.enableBlockade();
        } else {
            platform.disableBlockade();
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        world.draw(canvas);
        player.draw(canvas);
        platform.draw(canvas);
    }
}
