package sandbox.rmi;

import java.rmi.RemoteException;

public class AddServerImpl implements AddServerIntf {

    @Override
    public double add(double d1, double d2) throws RemoteException {
        return d1 + d2;
    }

}
