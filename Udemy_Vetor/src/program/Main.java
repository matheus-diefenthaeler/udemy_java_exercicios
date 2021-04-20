package program;

import entities.Produto;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Produto[] vect = new Produto[n];
        double sum = 0;
        double avg = 0;

        for(int i=0; i<n; i++){
            sc.nextLine();
            String name = sc.nextLine();
            double price = sc.nextDouble();
            vect[i] = new Produto(name,price);
            sum += vect[i].getPrice();
        }
        avg = sum/n;

        System.out.printf("Average price: %.2f%n", avg);

        sc.close();
    }


}
