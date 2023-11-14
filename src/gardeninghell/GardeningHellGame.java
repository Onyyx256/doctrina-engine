package gardeninghell;

import doctrina.Canvas;
import doctrina.Game;

import java.util.ArrayList;

public class GardeningHellGame extends Game {
    private Player player;
    private GamePad gamePad = new GamePad();
    private ArrayList<Block> blocks;


    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        blocks = new ArrayList<>();
        blocks.add(new Block(9000, 32, 0, 600));
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        if (gamePad.isDashPressed() && player.canDash()) {
            player.dash();
        }
        player.update();
    }

    @Override
    protected void draw(Canvas canvas) {
        player.draw(canvas);
        for (Block block : blocks) {
            block.draw(canvas);
        }
    }
}
