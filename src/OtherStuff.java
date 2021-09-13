import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class OtherStuff {

    public void printFileLines() {
        // saving data in a bufferedReader and printing every line
        try {
            System.out.println("\nsaving data in a a bufferedReader and printing every line:");
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Dat20Bstuderende.csv", StandardCharsets.UTF_8));
            bufferedReader.lines().skip(1).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //printing lastnames of students from class B
    public void printLastNamesFromClassB() {
        try {
            System.out.println("\nprinting lastnames of students from class B: ");
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader("Dat20Bstuderende.csv", StandardCharsets.UTF_8));
            bufferedReader1.lines()
                    .map(Main.mapToStudent)
                    .filter(student -> student.getClassOrigin().equals("B"))
                    .forEach(s -> System.out.println(s.getLastName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void TestingMapToItemFunction(){
        System.out.println("Testing mapToItem function...");
        Stream<String> testLine = Stream.of("pete46m9@stud.kea.dk;Peter Ross;Larsen;B");
        testLine.map(Main.mapToStudent).forEach(student -> {System.out.println(student.getFirstName());});
    }

    public void printStudentsInFormattedString() throws IOException {
        System.out.println("\nprinting a list of the students in a formatted string: ");
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader("Dat20Bstuderende.csv", StandardCharsets.UTF_8));
        bufferedReader3.lines()
                .map(Main.mapToStudent)
                .map(student -> String.format("Student lastname: %s, Origin class:%s", student.getLastName(), student.getClassOrigin()))
                .forEach(System.out::println);
    }
}



