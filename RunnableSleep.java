class HalfSecondTask implements Runnable {
    public void run() {
        try {
            System.out.println("HalfSecondTask started: " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("HalfSecondTask ended: " + Thread.currentThread().getName());
        } catch (Exception e) {
            System.out.println("Error in HalfSecondTask: " + e.getMessage());
        }
    }
}

class OneSecondTask implements Runnable {
    public void run() {
        try {
            System.out.println("OneSecondTask started: " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("OneSecondTask ended: " + Thread.currentThread().getName());
        } catch (Exception e) {
            System.out.println("Error in OneSecondTask: " + e.getMessage());
        }
    }
}

public class RunnableSleep {
    public static void main(String[] args) {
        Thread t1 = new Thread(new HalfSecondTask(), "HalfSecondTask");
        Thread t2 = new Thread(new OneSecondTask(), "Thread-OneSecond");

        t1.start();
        t2.start();
    }
}
