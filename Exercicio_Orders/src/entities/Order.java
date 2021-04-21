package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date moment;
    private OrderStatus status;

    private List<OrderItem> orderItemList = new ArrayList<>();
    private Client client;

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItemList.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem){
        orderItemList.remove(orderItem);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double total(){
        double sum = 0;
        for(OrderItem i : orderItemList){
           sum += i.getPrice() * i.getQuantity();
        }
        return sum;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        double sum = 0;
        sb.append("ORDER SUMMARY: ").append("\n");
        sb.append("Order moment: ").append(sdf.format(moment)).append("\n");
        sb.append("Order status: ").append(status).append("\n");
        sb.append("Cliente: ");
        sb.append(client.getName());
        sb.append(" (").append(sdf.format(client.getBirthDate())).append(")");
        sb.append(" - ");
        sb.append(client.getEmail()).append("\n");
        sb.append("Order itens: ").append("\n");

        for (OrderItem c : orderItemList) {
            sb.append(c.getProduct().getName()).append(", $");
            sb.append(c.getProduct().getPrice()).append(", Quantity: ");
            sb.append(c.getQuantity()).append(", Subtotal: $");
            sb.append(c.subTotal()).append("\n");
            sum += c.subTotal();
        }
        sb.append("\n").append("Total price: $");
        sb.append(sum);
        return sb.toString();
    }

}
