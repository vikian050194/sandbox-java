package sandbox.net;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

public class InetAddressTest {

    public static void main(String[] args) throws MalformedURLException, UnknownHostException {
        var address = InetAddress.getLocalHost();
        System.out.println(address);

        address = InetAddress.getByName("www.herbschildt.com");
        System.out.println(address);

        var sw = InetAddress.getAllByName("www.nba.com");
        for (var s : sw) {
            System.out.println(s);
        }
    }
}
