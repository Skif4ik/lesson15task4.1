import model.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int MAX_SIZE = 100;
        Employee[] employees = new Employee[MAX_SIZE];
        int currentIndex = 0;

        Scanner scanner = null;//открываем поток

        try {

            scanner = new Scanner(new FileReader("src/in.txt"));//инициализируем поток

            while (scanner.hasNextLine() && currentIndex != MAX_SIZE) {
                String fileLine = scanner.nextLine();
                String[] fields = fileLine.split(" ");
                employees[currentIndex++] = new Employee(fields[0], Double.parseDouble(fields[1]));
            }


        } catch (FileNotFoundException e) {
            System.out.println("Отсутсвует файл");
        } finally {

            if(scanner != null){
                scanner.close();//закрываем поток если он не ссылается на null
            }
        }

        employees = Arrays.copyOf(employees, currentIndex);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
