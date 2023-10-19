package sandbox.io;

import java.io.*;

class MyClass implements Serializable {

    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return String.format("s=%s; i=%d; d=%f;", s, i, d);
    }
}

public class SerializationDemo {

    public static void main(String[] args) {
        try (var objOStr = new ObjectOutputStream(new FileOutputStream("serial"))) {
            var object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println(object1);

            objOStr.writeObject(object1);
        } catch (IOException e) {
            System.err.println("Exception during serialization: " + e);
        }

        try (var objIStr = new ObjectInputStream(new FileInputStream("serial"))) {
            var object2 = (MyClass) objIStr.readObject();
            System.out.println(object2);
        } catch (Exception e) {
            System.err.println("Exception during serialization: " + e);
        }
    }
}
