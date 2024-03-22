package sandbox.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class AddServer {

    public static void main(String[] args) {
        try {
            AddServerImpl addServerImpl = new AddServerImpl();
            Naming.rebind("AddServer", addServerImpl);
        } catch (MalformedURLException | RemoteException e) {
            System.out.println(String.format("Exception: %s", e));
        }
    }
}
