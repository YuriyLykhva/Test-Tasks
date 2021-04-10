package core;

public class ThreadCar extends Thread {
    public ThreadCar(Car car) {

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

    }
}
