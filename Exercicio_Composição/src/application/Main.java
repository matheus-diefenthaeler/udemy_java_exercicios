package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    /* **************** Exercicio de composição - 1 ****************

    Ler os dados (Nome, Nivel e Salario) de um trabalhador com N contratos (Data, valor/hora e Duração)
    (N fornecido pelo usuário).Depois, solicitar do usuário um mês e mostrar qual foi o salário
    do funcionário nesse mês */

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter departament's name: ");
        String departamentName = sc.nextLine();

        System.out.print("Enter worker data (Name, Level and Base Salary): ");
        String workerName = sc.nextLine();
        String workerLevel = sc.nextLine();
        Double workerBaseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary,
                new Departament(departamentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for(int i=1; i<=n;i++){
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour,hours);
            worker.addContract(contract);
        }
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Departament " + worker.getDepartament().getName());
        System.out.println("Income for: " + monthAndYear + ": " + String.format("%.2f", worker.income(year,month)));

        sc.close();

    }
}
