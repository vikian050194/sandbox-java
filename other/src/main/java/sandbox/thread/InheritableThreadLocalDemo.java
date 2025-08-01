package sandbox.thread;

public class InheritableThreadLocalDemo {

    private static volatile InheritableThreadLocal<Integer> intVal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Runnable rP = () -> {
            intVal.set(10);
            Runnable rC = () -> {
                var thread = Thread.currentThread();
                var name = thread.getName();
                System.out.println(String.format("%s %d%n", name, intVal.get()));
            };

            var threadChild = new Thread(rC);
            threadChild.setName("Child");
            threadChild.start();
        };

        var threadParent = new Thread(rP);
        threadParent.setName("Parent");
        threadParent.start();
    }
}
