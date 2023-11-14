package gardeninghell;

import doctrina.Canvas;
import doctrina.CollidableRepository;
import doctrina.StaticEntity;

import java.awt.*;

public class Block extends StaticEntity {

    public Block(int width, int height, int x, int y) {
        setDimension(width, height);
        teleport(x, y);
        CollidableRepository.getInstance().registerEntity(this);
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
    }
}
