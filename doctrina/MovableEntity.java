package doctrina;

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
}
