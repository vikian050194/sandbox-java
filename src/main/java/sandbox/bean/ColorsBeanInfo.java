package sandbox.bean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class ColorsBeanInfo extends SimpleBeanInfo {

    public PropertyDescriptor[] getPropertyDescriptiors() {
        try {
            var rectangular = new PropertyDescriptor("rectangular", Colors.class);
            PropertyDescriptor[] pd = {rectangular};
            return pd;
        } catch (IntrospectionException e) {
            System.out.println("Exception caught. " + e);
        }

        return null;
    }
}
