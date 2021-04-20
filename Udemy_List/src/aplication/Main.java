package aplication;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        System.out.println("How many employees will be registered? ");
        int numberOfEmployees = sc.nextInt();


        for(int i = 0; i<numberOfEmployees; i++){
            System.out.println("Employee: #" + (i+1) + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Salary: ");
            Double salary = sc.nextDouble();
            employeeList.add(new Employee(id,name,salary));
        }
        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        //Employee employee = employeeList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
       Integer pos = position(employeeList,id);
        if (pos == null){
            System.out.println("This id does not exist!");
        }else{
            System.out.println("Enter the percentage");
            double percentage = sc.nextDouble();
            employeeList.get(pos).increaseSalary(percentage);
        }

        System.out.println("List of employees: ");
        for (Employee value : employeeList) {
            System.out.println(value);
        }


        sc.close();

    }

    public static Integer position(List<Employee> employeeList, int id){
        for(int i=0;i<employeeList.size(); i++){
            if(employeeList.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }

}
