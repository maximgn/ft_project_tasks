import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main6 {
    public static void main(String[] args) {
        boolean flag = true;
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Menu");
            System.out.println("1. Add");
            System.out.println("2. Show");
            System.out.println("3. Sort unique");
            System.out.println("4. Exit");
            switch (scanner.nextLine()) {
                case "1":
                    String fio = "";
                    while (!(fio = scanner.nextLine()).equals("end")) {
                        String[] strAfterSplit = fio.split(" ");
                        personList.add(new Person(strAfterSplit[0], strAfterSplit[1]));
                    }
                    break;
                case "2":
                    if (personList.size() == 0) System.out.println("List is empty");
                    else for(Person person : personList) System.out.println(person);
                    break;
                case "3":
                    personList.stream()
                            .sorted((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()))
                            .collect(Collectors.toMap(Person::getLastName, Function.identity(), (existing, replacement) -> existing))
                            .values()
                            .stream()
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    break;
                case "4":
                    flag = false;
                    break;
                default:
                    System.out.println("Неверный пункт меню");
                    break;
            }
        }

    }
}
