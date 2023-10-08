package sandbox.resource;

import java.util.*;

public class LRBDemo {

    public static void main(String[] args) {
        // Load the deafult bundle
        var rb = ResourceBundle.getBundle("SampleRB");

        System.out.println("English version:");
        System.out.println("Title: " + rb.getString("title"));
        System.out.println("StopText: " + rb.getString("StopText"));
        System.out.println("StartText: " + rb.getString("StartText"));

        rb = ResourceBundle.getBundle("SampleRB", Locale.GERMAN);

        System.out.println("English version:");
        System.out.println("Title: " + rb.getString("title"));
        System.out.println("StopText: " + rb.getString("StopText"));
        System.out.println("StartText: " + rb.getString("StartText"));
    }
}
