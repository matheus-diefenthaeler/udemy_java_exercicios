package program;

import entities.Rent;

import java.util.Scanner;

public class MainAluno {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Rent[] vect = new Rent[10];

        System.out.println("How many rooms will be rented? ");
        int n = sc.nextInt();

        for(int i=0; i<n; i ++){
            sc.nextLine();
            System.out.println("Rent #" + (i+1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Room: ");
            int room = sc.nextInt();
            vect[room] = new Rent(name,email);
        }

        System.out.println("\nBusy rooms: ");
        for(int i = 0; i< vect.length; i++){
            if(vect[i] != null){
                System.out.println( i + ": " + vect[i]);
            }
        }
        sc.close();

    }
}
