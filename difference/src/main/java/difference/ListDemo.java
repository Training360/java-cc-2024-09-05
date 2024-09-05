package difference;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        var names = List.of("John");
        System.out.println(names);
        names = addElement(names);
        System.out.println(names);
    }

    public static List<String> addElement(List<String> names) {
        var copy = new ArrayList<>(names);
        copy.add("John Doe");
        return copy;
    }
}
