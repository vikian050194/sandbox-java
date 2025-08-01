package sandbox.thread;

public class ThreadLocalDemo {

    private static volatile ThreadLocal<String> userID = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable r = () -> {
            var name = Thread.currentThread().getName();

            if (name.equals("A")) {
                userID.set("Alice");
            } else {
                userID.set("Bob");
            }

            System.out.println(name + " " + userID.get());
        };

        var threadA = new Thread(r);
        threadA.setName("A");
        var threadB = new Thread(r);
        threadB.setName("B");

        threadA.start();
        threadB.start();
    }
}
