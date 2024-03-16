package sandbox.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class StreamDemo7 {

    public static void main(String[] args) {
        var fullDataList = new ArrayList<NamePhoneEmail>();
        fullDataList.add(new NamePhoneEmail("Alice", "555-555", "alice@example.com"));
        fullDataList.add(new NamePhoneEmail("Bob", "777-888", "bob@example.com"));
        fullDataList.add(new NamePhoneEmail("Eva", "123-456", "eva@example.com"));

        System.out.println("Original list:");
        fullDataList.stream().forEach((d) -> System.out.println(d));

        var subDataStream = fullDataList.stream().map((d) -> new NamePhone(d.name, d.phone));

        var subList = subDataStream.collect(Collectors.toList());
        System.out.println("Sub data list:");
        for (NamePhone namePhone : subList) {
            System.out.println(namePhone);
        }

        subDataStream = fullDataList.stream().map((d) -> new NamePhone(d.name, d.phone));

        var subSet = subDataStream.collect(Collectors.toSet());
        System.out.println("Sub data set:");
        for (NamePhone namePhone : subSet) {
            System.out.println(namePhone);
        }

        subDataStream = fullDataList.stream().map((d) -> new NamePhone(d.name, d.phone));

        var subLinkedList = subDataStream.collect(() -> new LinkedList<NamePhone>(),
                (list, element) -> list.add(element),
                (listA, listB) -> listA.addAll(listB));
        System.out.println("Sub data linked list:");
        for (NamePhone namePhone : subLinkedList) {
            System.out.println(namePhone);
        }

        subDataStream = fullDataList.stream().map((d) -> new NamePhone(d.name, d.phone));

        HashSet<NamePhone> subHashSet = subDataStream.collect(HashSet::new, HashSet::add, HashSet::addAll);
        System.out.println("Sub data hash set:");
        for (NamePhone namePhone : subHashSet) {
            System.out.println(namePhone);
        }
    }
}
