import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main9 {

    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    private static class MenuItem {
        private String name;
        private Exec exec;

        MenuItem(String name, Exec exec) {
            this.name = name;
            this.exec = exec;
        }

    }

    private static class Menu {

        private Scanner scanner;
        private List<MenuItem> items = new ArrayList<>();

        {
            items.add(new MenuItem("add", (personList) -> {
                String fio = "";
                while (!(fio = scanner.nextLine()).equals("end")) {
                    String[] strAfterSplit = fio.split(" ");
                    personList.add(new Person(strAfterSplit[0], strAfterSplit[1]));
                }
            }));

            items.add(new MenuItem("show", (personList) -> {
                if (personList.size() == 0) System.out.println("List is empty");
                else personList.forEach(System.out::println);
            }));

            items.add(new MenuItem("sort", (personList) -> {
                personList.stream()
                        .sorted((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()))
                        .collect(Collectors.toMap(Person::getLastName, Function.identity(), (existing, replacement) -> existing))
                        .values()
                        .stream()
                        .collect(Collectors.toList())
                        .forEach(System.out::println);
            }));



            items.add(new MenuItem("save", (personList) -> {
                if (personList.size() != 0) {
                    ObjectOutputStream oos = null;
                    FileOutputStream fos;
                    try {
                        fos = new FileOutputStream("src/main/resources/personList.ser", true);
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(personList);
                        System.out.println("List was serialized successfully!");
                    } catch(Exception e) {
                        e.printStackTrace();
                    } finally {
                        if(oos != null){
                            try {
                                oos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    System.out.println("List is empty");
                }
            }));

            items.add(new MenuItem("read", (personList) -> {
                FileInputStream fis= new FileInputStream("src/main/resources/personList.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                personList = (List<Person>)ois.readObject();
                for(Person person : personList) System.out.println(person);
            }));

            items.add(new MenuItem("clear", (personList) -> {
                personList.clear();
                System.out.println("List was clear successfully");
            }));
        }

        private Menu(Scanner scanner) {
            this.scanner = scanner;
        }

        public void getItem(List<Person> personList) throws Exception {
            boolean flag = true;
            while (flag) {
                System.out.println("\nMenu");
                System.out.println("1. Add");
                System.out.println("2. Show");
                System.out.println("3. Sort unique");
                System.out.println("4. Save to file");
                System.out.println("5. Read from file");
                System.out.println("6. Clear data in memory");
                System.out.println("7. Exit");
                switch (scanner.nextLine()) {
                    case "1":
                        items.get(0).exec.exec(personList);
                        break;
                    case "2":
                        items.get(1).exec.exec(personList);
                        break;
                    case "3":
                        items.get(2).exec.exec(personList);
                        break;
                    case "4":
                        items.get(3).exec.exec(personList);
                        break;
                    case "5":
                        items.get(4).exec.exec(personList);
                        break;
                    case "6":
                        items.get(5).exec.exec(personList);
                        break;
                    case "7":
                        flag = false;
                        break;
                    default:
                        System.out.println("Неверный пункт меню");
                        break;
                }
            }
        }

    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        try {
            menu.getItem(personList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
