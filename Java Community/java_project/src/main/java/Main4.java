import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList();
        int counter = 1;
        String userData = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите данные " + counter + " первого пользователя");
            userData = scanner.nextLine();
            if (userData.equals("end")) break;
            String [] strAfterParse = userData.split(" ");
            personList.add(new Person(strAfterParse[0], strAfterParse[1]));
            counter++;
        }
        Collections.sort(personList, (s1, s2) -> s1.getLastName().compareTo(s2.getLastName()));
        for(Person person : personList) System.out.println(person);
    }
}
