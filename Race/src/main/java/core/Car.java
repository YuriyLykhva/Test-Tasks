package core;

public class Car {

    String name;
    int speed;
    int distance;
    int position;

    public Car(String name, int speed, int distance, int position) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
        this.position = position;
    }

    public void drive(int speed){
        this.distance = distance + speed;
        setSpeed(speed);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("%9s %2d %10s %15s %2d %15s %4d",
                "position", position, name, "speed = ", speed, "distance = ", distance);
    }
}
