package sandbox.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("java.awt.Dimension");

            System.out.println("Constructors:");
            Constructor<?>[] constructors = c.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            System.out.println("Fields:");
            Field[] fields = c.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            System.out.println("Methods:");
            Method[] methods = c.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException | SecurityException e) {
            System.out.println(String.format("Exception: %s", e));
        }

    }
}
