package com.JavaIO;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    public static void main(String[] args) throws IOException {
        String fileName = "employee.txt";
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Populate test employee payroll object
        EmployeePayrollData employee1 = new EmployeePayrollData(101, "Garv", 50000);
        EmployeePayrollData employee2 = new EmployeePayrollData(102, "Vish", 60000);
        employeePayrollDataList.add(employee1);
        employeePayrollDataList.add(employee2);

        // Write employee payroll to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (EmployeePayrollData employee : employeePayrollDataList) {
                writer.write(employee.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Count number of entries in file
        int count = countEntries(fileName);
        System.out.println("Number of entries in file: " + count);

        scanner.close();
    }

    private static int countEntries(String fileName) throws IOException {
        int count = 0;
        try (Scanner scanner = new Scanner(fileName)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
        }
        return count;
    }

}

class EmployeePayrollData {
    private int id;
    private String name;
    private double salary;

    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + "," + name + "," + salary + "\n";
    }
}