package gardeninghell;

import doctrina.Canvas;
import doctrina.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class GardeningHellGame extends Game {
    private GamePad gamePad;
    private Player player;
    private World world;

    private Platform platform;
    private ArrayList<Platform> floor;
    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        player.teleport(200, 200);
        world = new World();
        platform = new Platform(250, 350);
        floor = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            floor.add(new Platform(i * 50, 500));
        }

    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        player.update();
        platform.updateBlockade(player.getY());
        for (Platform value : floor) {
            value.updateBlockade(player.getY());
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        world.draw(canvas);
        player.draw(canvas);
        platform.draw(canvas);
        for (Platform value : floor) {
            value.draw(canvas);
        }
    }
}
