package CW4.ZAD4;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Student>> studentsByGroup = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            studentsByGroup = reader.lines()
                    .map(line -> line.split(" "))
                    .map(data -> new Student(data[0], data[1], Integer.parseInt(data[2])))
                    .collect(Collectors.groupingBy(Student::getGroup));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = studentsByGroup.entrySet().stream()
                .map(entry -> "Group " + entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }
}
