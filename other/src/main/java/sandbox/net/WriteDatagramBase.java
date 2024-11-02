package sandbox.net;

import java.net.DatagramSocket;

public abstract class WriteDatagramBase {

    public static int serverPort = 8080;
    public static int clientPort = 8081;
    public static int bufferSize = 1024;
    public static DatagramSocket ds;
    public static byte[] buffer = new byte[bufferSize];
}
