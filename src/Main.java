import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static Function<String, Student> mapToItem = (line) -> {
        String[] array = line.split(";");
        return new Student(array[0], array[1], array[2], array[3]);
    };

    public static List<Student> getStudentsFromFile(String file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
        return bufferedReader.lines().skip(1).map(mapToItem).collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {

        System.out.println("\nExcercise 1, group by class and sort dem.");
        List<Student> students = getStudentsFromFile("Dat20Bstuderende.csv");
        // group by class in a map
        Map<String, List<Student>> studentsPerClass = students.stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .collect(Collectors.groupingBy(Student::getClassOrigin));
        System.out.println(studentsPerClass);


        System.out.println("\nExcercise 2, print total students after grouping by class:");
        // count the students
        Map<String, Integer> amountOfStudentsPerClass = new HashMap<>();
        for (String str : studentsPerClass.keySet()) {
            amountOfStudentsPerClass.put(str, studentsPerClass.get(str).size());
        }
        System.out.println(amountOfStudentsPerClass);
    }
}
