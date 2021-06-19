import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Требуется передать 2 параметра");
            return;
        }
        Person person = new Person(args[0], args[1]);
        System.out.println(person);

    }
}
