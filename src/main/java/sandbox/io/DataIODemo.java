package sandbox.io;

import java.io.*;

public class DataIODemo {

    public static void main(String[] args) {
        try (var dout = new DataOutputStream(new FileOutputStream("test.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot Open Output File");
            return;
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }

        try (var din = new DataInputStream(new FileInputStream("test.dat"))) {
            var d = din.readDouble();
            var i = din.readInt();
            var b = din.readBoolean();
            System.out.printf("Here are the values %f %d %b", d, i, b);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot Open Input File");
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
