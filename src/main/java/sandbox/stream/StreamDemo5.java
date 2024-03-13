package sandbox.stream;

import java.util.ArrayList;

class NamePhoneEmail {

    String name;
    String phone;
    String email;

    public NamePhoneEmail(String n, String p, String e) {
        name = n;
        phone = p;
        email = e;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", name, phone, email);
    }
}

class NamePhone {

    String name;
    String phone;

    public NamePhone(String n, String p) {
        name = n;
        phone = p;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, phone);
    }
}

public class StreamDemo5 {

    public static void main(String[] args) {
        var fullDataList = new ArrayList<NamePhoneEmail>();
        fullDataList.add(new NamePhoneEmail("Alice", "555-555", "alice@example.com"));
        fullDataList.add(new NamePhoneEmail("Bob", "777-888", "bob@example.com"));
        fullDataList.add(new NamePhoneEmail("Eva", "123-456", "eva@example.com"));

        System.out.println("Original list:");
        fullDataList.stream().forEach((d) -> System.out.println(d));

        var subDataStream = fullDataList.stream().map((d) -> new NamePhone(d.name, d.phone));

        System.out.println("Sub list:");
        subDataStream.forEach((d) -> System.out.println(d));

        var aliceStream = fullDataList.stream().filter((d) -> d.name.startsWith("A")).map((d) -> new NamePhone(d.name, d.phone));

        System.out.println("Alice list:");
        aliceStream.forEach((d) -> System.out.println(d));
    }
}
