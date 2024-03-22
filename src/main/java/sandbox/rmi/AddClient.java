package sandbox.rmi;

import java.net.MalformedURLException;
import java.rmi.*;
import java.util.logging.*;

public class AddClient {

    public static void main(String[] args) {
        try {
            var host = "127.0.0.1";
            var addServerURL = String.format("rmi://%s/AddServer", host);
            var addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);
            var d1 = 2;
            var d2 = 3;
            System.out.println(String.format("d1 is %d and d2 is %s", d1, d2));

            var sum = addServerIntf.add(d1, d2);

            System.out.println(String.format("Sum is %f", sum));
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(AddClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
