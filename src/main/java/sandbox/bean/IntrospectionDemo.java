package sandbox.bean;

import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntrospectionDemo {

    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("Colors");
            var beanInfo = Introspector.getBeanInfo(c);

            System.out.println("Properties:");
            var pd = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : pd) {
                System.out.println(String.format("\t%s", propertyDescriptor.getName()));
            }
            System.out.println("Events:");
            var esd = beanInfo.getEventSetDescriptors();
            for (EventSetDescriptor eventSetDescriptor : esd) {
                System.out.println(String.format("\t%s", eventSetDescriptor.getName()));
            }
        } catch (ClassNotFoundException | IntrospectionException ex) {
            Logger.getLogger(IntrospectionDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
