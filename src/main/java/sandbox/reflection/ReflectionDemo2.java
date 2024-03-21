package sandbox.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class A {

    public void a1() {

    }

    public void a2() {

    }

    protected void a3() {

    }

    private void a4() {

    }
}

public class ReflectionDemo2 {

    public static void main(String[] args) {
        try {
            var a = new A();
            Class<?> c = a.getClass();

            System.out.println("Methods:");
            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods) {
                var mods = method.getModifiers();
                if (Modifier.isPublic(mods)) {
                    System.out.println(method.getName());
                }
            }
        } catch (SecurityException e) {
            System.out.println(String.format("Exception: %s", e));
        }

    }
}
