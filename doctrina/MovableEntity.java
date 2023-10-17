package doctrina;

import java.awt.*;

public abstract class MovableEntity extends StaticEntity {

    private int speed = 1;
    private Direction direction = Direction.UP;

    public abstract void update();

    public void move() {
        x += direction.calculateVelocityX(speed);
        y += direction.calculateVelocityY(speed);
    }

    public void move(Direction direction) {
        this.direction = direction;
        move();
    }

    public void moveUp() {
        move(direction.UP);
    }

    public void moveDown() {
        move(direction.DOWN);
    }

    public void moveLeft() {
        move(direction.LEFT);
    }

    public void moveRight() {
        move(direction.RIGHT);
    }

    public Rectangle getHitBox() {
        switch (direction) {
            case UP:return getUpperHitBox();
            case DOWN:return getLowerHitBox();
            case LEFT:return getLeftHitBox();
            case RIGHT:return getRightHitBox();
        }
        return getBounds();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean hitBoxIntersectWith(StaticEntity other) {
        if (other == null) {
            return false;
        }
        return getHitBox().intersects(other.getBounds());
    }

    public void drawHitBox(Canvas canvas) {
        Rectangle rectangle = getHitBox();
        Color color = new Color(255, 0, 0, 200);
        canvas.drawRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height, color);
    }

    private Rectangle getUpperHitBox() {
        return new Rectangle(x, y - speed, width, speed);
    }

    private Rectangle getLowerHitBox() {
        return new Rectangle(x, y + height, width, speed);
    }

    private Rectangle getLeftHitBox() {
        return new Rectangle(x - speed, y, speed, height);
    }

    private Rectangle getRightHitBox() {
        return new Rectangle(x + width, y, speed, height);
    }
}
