package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
//      String string = LocalDateTime.now().toString().substring(0,18).replace("-","/").replace("T"," ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date moment = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(string);

        Date moment = sdf.parse(LocalDateTime.now().toString().replace("-","/"));

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = sc.next();

        Order order = new Order(moment, OrderStatus.valueOf(status), new Client(name, email, birthDate));

        System.out.print("How many itens to this order? ");
        int itens = sc.nextInt();

        for(int i = 0; i<itens; i++){
            System.out.println("Enter #" + (i+1) + " item data:");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");

            int productQuantity = sc.nextInt();
            Product product = new Product(productName,productPrice);
            OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);

            order.addOrderItem(orderItem);
        }

        System.out.println("");
        System.out.println(order);

        sc.close();
    }
}
