package com.tsb.explore.streams;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeUtils {

    // Method to count employees grouped by age
    public static Map<Integer, Long> getCountByAge(List<Employee> employees) {
        return employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getAge,  // Group by age
                                Collectors.counting() // Count employees in each group
                        ));
    }
    
    // Method to filter names starting with 'A'
    public static List<String> filterNames(List<Employee> employees, String startsWith) {
        return employees.stream()
                        .map(Employee::getName) // Extract names
                        .filter(name -> name.startsWith(startsWith)) // Filter names starting with 'A'
                        .collect(Collectors.toList());
    }

    

    // Main method for testing
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 25));
        employees.add(new Employee("Bob", 30));
        employees.add(new Employee("Andrew", 25));
        employees.add(new Employee("John", 30));
        employees.add(new Employee("Anna", 35));
        employees.add(new Employee("Mark", 25));

        Map<Integer, Long> countByAge = getCountByAge(employees);
        System.out.println("Employee count by age: " + countByAge);
        
        String startsWith = "A";
        List<String> filteredNames = filterNames(employees,startsWith);
        System.out.println("Names starting with '" + startsWith + "': " + filteredNames);
        
    }
}
