package com.JavaIO;
import java.io.*;
import java.util.Arrays;

public class EmployeePayrollService {
    public static void main(String[] args) {
        class Employee{
            private String name;
            private double salary;
            private int age;

            public Employee(String name, double salary, int age) {
                this.name = name;
                this.salary = salary;
                this.age = age;
            }
            public String getName() {
                return name;
            }
            public double getSalary() {
                return salary;
            }
            public int getAge() {
                return age;
            }

            @Override
            public String toString() {
                return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + ", age=" + age + '}';
            }
        }
        File file = new File("employeeData.txt"); // Check if file exists
        if (file.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }
        Employee employee1 = new Employee("Vishruti", 50000.0, 25 );
        Employee employee2 = new Employee("Ashu", 60000.0, 26 );
        try{
            FileWriter fileWriter = new FileWriter("employeeData.txt");
            fileWriter.write(employee1.getName() + "," +employee1.getSalary() + "," +employee1.getAge()+ "\n");
            fileWriter.write(employee2.getName() + "," +employee2.getSalary() + "," +employee2.getAge());
            fileWriter.close();
            System.out.println("Employee Data written to file successfully");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        // Check if file exists
        if (file.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }

        try{
            FileReader fileReader = new FileReader("employeeData.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            System.out.println("Employee Data read from file :");
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                String name = data[0];
                double salary = Double.parseDouble(data[1]);
                int age = Integer.parseInt(data[2]);
                Employee employee = new Employee(name,salary,age);
                System.out.println(employee.toString());
            }
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        // Delete file and check if it exists
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete file.");
        }
        if (file.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }
        // Create directory
        File directory = new File("employeeDirectory");
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory created successfully.");
            } else {
                System.out.println("Failed to create directory.");
            }
        } else {
            System.out.println("Directory already exists.");
        }
        // Create empty file in directory
        File emptyFile = new File(directory, "emptyFile.txt");
        try {
            if (emptyFile.createNewFile()) {
                System.out.println("Empty file created successfully.");
            } else {
                System.out.println("Failed to create empty file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // List files and directories
        System.out.println("Files and directories in current directory:");
        String[] filesAndDirectories = new File(".").list();
        for (String fileName : filesAndDirectories) {
            System.out.println(fileName);
        }

        // List files with a specific extension
        System.out.println("Files with extension .txt:");
        File directoryFile = new File(".");
        File[] fileList = directoryFile.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        Arrays.stream(fileList).forEach(fileItem -> System.out.println(fileItem.getName()));
    }
}

