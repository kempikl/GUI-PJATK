package CW4.ZAD2;

import java.util.Collection;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private final String name;
    private final int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public static boolean isInColl(Collection<Person> coll, String name, int year) {
        return coll.contains(new Person(name, year));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthYear);
    }

    @Override
    public int compareTo(Person o) {
        int nameComparison = name.compareTo(o.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(birthYear, o.birthYear);
    }
}

