import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
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
        for(Person person : personList) System.out.println(person);
    }
}
