package CW2.ZAD5;

public class Main {
    public static void main(String[] args) {
        Person[] people = {
                new Person("John", 25),
                new Person("Mary", 30),
                new Person("Bob", 20),
                new Person("Alice", 35),
                new Person("Mark", 28)
        };

        Person.sort(people);

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
