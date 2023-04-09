package com.JavaIO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    }
}

