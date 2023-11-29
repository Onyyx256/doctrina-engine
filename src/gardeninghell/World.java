package gardeninghell;

import doctrina.Canvas;
import doctrina.RenderingEngine;
import doctrina.StaticEntity;

import java.awt.*;

public class World extends StaticEntity {

    public World () {
        setDimension(800, 600);
    }
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.BLACK);
    }
}
