import model.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        final int MAX_SIZE = 100;
        Employee[] employees = new Employee[MAX_SIZE];
        int currentIndex = 0;


        //try with resources умеет автоматически закрывать ресурсы классов реализующих интерфейс AutoCloseable
        try (Scanner scanner = new Scanner(new FileReader("src/in.txt"))){ //открывавем поток, удобно тем что поток закроется после завершения блока try



            while (scanner.hasNextLine() && currentIndex != MAX_SIZE) {
                String fileLine = scanner.nextLine();
                String[] fields = fileLine.split(" ");
                employees[currentIndex++] = new Employee(fields[0], Double.parseDouble(fields[1]));
            }


        } catch (FileNotFoundException e) {
            System.out.println("Отсутсвует файл");
        }

        employees = Arrays.copyOf(employees, currentIndex);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
