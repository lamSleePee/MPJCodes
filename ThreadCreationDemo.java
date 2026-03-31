class MyWorkerThread extends Thread {
    public void run() {
        try {
            System.out.println(
                "Running thread: " + Thread.currentThread().getName()
                + " | ID: " + Thread.currentThread().getId()
            );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class ThreadCreationDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            MyWorkerThread t = new MyWorkerThread();
            t.start();
        }
    }
}
