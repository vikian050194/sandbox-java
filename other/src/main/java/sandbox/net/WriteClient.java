package sandbox.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.MalformedURLException;

public class WriteClient extends WriteDatagramBase {

    public static void main(String[] args) throws MalformedURLException, IOException {
        ds = new DatagramSocket(clientPort);
        while (true) {
            var p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
        }
    }
}
