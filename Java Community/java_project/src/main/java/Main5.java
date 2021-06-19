import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        boolean flag = true;
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Menu");
            System.out.println("1. Add");
            System.out.println("2. Show");
            System.out.println("3. Exit");
            switch (scanner.nextLine()) {
                case "1":
                    String fio = "";
                    while (!(fio = scanner.nextLine()).equals("end")) {
                        String[] strAfterSplit = fio.split(" ");
                        personList.add(new Person(strAfterSplit[0], strAfterSplit[1]));
                    }
                    break;
                case "2":
                    for(Person person : personList) System.out.println(person);
                    break;
                case "3":
                    flag = false;
                    break;
                default:
                    System.out.println("Неверный пункт меню");
                    break;
            }
        }

    }
}
