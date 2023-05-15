# GUI - CW 04 - Zad 2

Stwórz klasę Person z polami name typu String i birthYear typu int, jednym konstruktorem inicjującym pola oraz metodą statyczną:

    public static boolean isInColl(Collection<Person> coll, String name, int year) {
        return coll.contains(new Person(name, year));
    }

która ma sprawdzać, czy kolekcja coll zawiera osobę z podanym imieniem i rokiem urodzenia. Następujący program:

    import java.util.Arrays;
    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;
    import java.util.TreeSet;
    import static java.lang.System.out;
    
    public class PersonsColls {
        public static void main (String[] args) {
            List<Person> list = Arrays.asList(
                new Person("Alice", 2000),
                new Person("Brenda", 2001),
                new Person("Cecilia", 2002)
            );
            
            out.println(Person.isInColl(list, "Brenda", 2001));
            out.println(Person.isInColl(list, "Debby", 2001));
            
            Set<Person> tSet = new TreeSet<>(list);
            out.println(Person.isInColl(tSet, "Brenda", 2001));
            out.println(Person.isInColl(tSet, "Debby", 2001));
            
            Set<Person> hSet = new HashSet<>(list);
            out.println(Person.isInColl(hSet, "Brenda", 2001));
            out.println(Person.isInColl(hSet, "Debby", 2001));
            }
    }

powinien więc wydrukować


* Czy program się kompiluje? Jeśli nie, to uzupełnij klasę Person tak, aby się kompilował.
* Czy wyniki sa prawidłowe jeśli do funkcji isInColl przekazujemy listę? Jeśli nie, to popraw klasę Person tak aby były.
* Czy wyniki są prawidłowe jeśli do funkcji isInColl przekazujemy TreeSet?
* Czy wyniki są prawidłowe jeśli do funkcji isInColl przekazujemy HashSet? Jeśli nie, to popraw klasę Person tak aby były.