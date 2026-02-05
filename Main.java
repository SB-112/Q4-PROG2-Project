import java.io.*;
import java.util.*;

public class Main {

    // Class for managing employee names
    static class Employee{
        String id;
        String name;
        int salaryLevel;

        Employee(String id, String name, int salaryLevel){
            this.id = id;
            this.name = name;
            this.salaryLevel = salaryLevel;
        }
    }

    // Main Method
    public static void main(String[] args) {
        // Hashmap for storing all employee from txt
        Map<String, Employee> employeeList = new HashMap<>();

        // Read the contents of employee.txt then save it into the hashmap
        try{
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                String[] splittedParts = line.split(",");
                String id = splittedParts[0];
                String name = splittedParts[1];
                int salaryLevel = Integer.parseInt(splittedParts[2]);

                Employee employee = new Employee(id, name, salaryLevel);
                employeeList.put(id, employee);
            }
        }catch (IOException e){
            System.out.println("Error reading file " + e.getMessage());
        }

        // Search for employee from hashmap
        boolean isRunning = true;
        while (isRunning){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Employee ID(Enter 0 to exit): ");
            String inputId = input.nextLine().trim();
            if (inputId.equals("0")){
                System.out.println("Bye");
                isRunning = false;
                continue;
            }

            Employee searchEmp = employeeList.get(inputId);
            if (searchEmp != null) System.out.println("Employee: " + searchEmp.name + ", Salary level: " + searchEmp.salaryLevel);
            else System.out.println("Employee not found");
        }
    }
}