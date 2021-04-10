package core;

import java.util.*;

public class Race {

    static int time = 1;

    public static void main(String[] args) {
        ArrayList<Car> car = new ArrayList<>();
        ArrayList<ThreadCar> threadCar = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            car.add(new Car("car " + (i+1),0, 0, 0));
            threadCar.add(new ThreadCar(car.get(i)));
        }
        for (int i = 0; i < 10; i++) {
            threadCar.get(i).start();
        }


        while (time<=20) {

            for (int i = 0; i < 10; i++) {
                car.get(i).drive(getRandomSpeed());
            }

            System.out.println("Thread is " + Thread.currentThread().getName());
            System.out.println("-----------------  LEADERS after " + time + " sec ------------------------");
            getLeaders(car);

            time++;
        }
    }

    public static int getRandomSpeed() {
        Random ran = new Random();
        return ran.nextInt(6) + 4;
    }

    public static void getLeaders(ArrayList<Car> cars) {
        cars.sort((o1, o2) -> o2.distance - o1.distance);

        for (int i = 0; i < 3; i++) {
            cars.get(i).setPosition(i+1);
            String s = cars.get(i).toString();
            System.out.println(s);
        }
    }
}
