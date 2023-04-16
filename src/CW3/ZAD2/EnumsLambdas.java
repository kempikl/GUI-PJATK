package CW3.ZAD2;

import java.util.Arrays;
import java.util.Comparator;

public class EnumsLambdas {

    public enum Sex {
        F("female"), M("male");

        private String description;

        Sex(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    public enum Size {
        XS, S, M, L, XL;
    }

    public enum Country {
        PL("Polska"), NL("Nederland"), DE("Deutschland");

        private String nativeName;

        Country(String nativeName) {
            this.nativeName = nativeName;
        }

        @Override
        public String toString() {
            return nativeName;
        }
    }

    public static class Person {
        private String name;
        private Sex sex;
        private Size size;
        private Country country;

        public Person(String name, Sex sex, Size size, Country country) {
            this.name = name;
            this.sex = sex;
            this.size = size;
            this.country = country;
        }

        @Override
        public String toString() {
            return name + " (" + sex + ", " + size + ", " + country + ")";
        }
    }

    public static <T> void printArray(String title, T[] array) {
        System.out.println("    *** " + title + " ***");
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Person[] persons = {
                new Person("Max",  Sex.M, Size.XL, Country.NL),
                new Person("Jan",  Sex.M, Size.S,  Country.PL),
                new Person("Eva",  Sex.F, Size.XS, Country.NL),
                new Person("Lina", Sex.F, Size.L,  Country.DE),
                new Person("Mila", Sex.F, Size.S,  Country.DE),
                new Person("Ola",  Sex.F, Size.M,  Country.PL),
        };

        Comparator<Person> sexThenSize = (a, b) -> {
            int result = a.sex.compareTo(b.sex);
            return result != 0 ? result : a.size.compareTo(b.size);
        };
        Arrays.sort(persons, sexThenSize);
        printArray("Persons by sex and then size", persons);

        Arrays.sort(persons, (a, b) -> {
            int result = a.size.compareTo(b.size);
            return result != 0 ? result : a.name.compareTo(b.name);
        });
        printArray("Persons by size and then name", persons);

        Country[] countries = Country.values();
        Arrays.sort(countries, Comparator.comparing(Country::toString));
        printArray("Countries by name", countries);
    }
}

