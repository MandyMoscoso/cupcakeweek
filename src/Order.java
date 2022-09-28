import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public Order (ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu){
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();
        ArrayList<Object> order = new ArrayList<>();

        if(placeOrder.equalsIgnoreCase("y")){
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu.");
            System.out.println("CUPCAKES:");

            int itemNumber = 0;
            for (int i = 0; i < cupcakeMenu.size() ; i++) {
                itemNumber++;
                System.out.println(itemNumber);
                cupcakeMenu.get(i).type();
                System.out.println("Price: " + cupcakeMenu.get(i).getPrice());
            }
            System.out.println("\nDRINKS:");
            for (Drink menu : drinkMenu) {
                itemNumber++;
                System.out.println(itemNumber);
                menu.type();
                System.out.println("Price: " + menu.getPrice());
            }
            System.out.println("\n");
        } else {
            System.out.println("Have a nice day then.");
        }

        boolean ordering = true;
        while (ordering){
            System.out.println("What would you like to order? Please use the number associated with each item to order.");
            int orderChoice = input.nextInt();
            input.nextLine();

            if(orderChoice == 1){
                order.add(cupcakeMenu.get(0));
            } else if(orderChoice == 2){
                order.add(cupcakeMenu.get(1));
            }else if(orderChoice == 3){
                order.add(cupcakeMenu.get(2));
            }else if(orderChoice == 4){
                order.add(drinkMenu.get(0));
            }else if(orderChoice == 5){
                order.add(drinkMenu.get(1));
            }else if(orderChoice == 6){
                order.add(drinkMenu.get(2));
            } else{
                System.out.println("Sorry, we don’t seem to have that on the menu.");
            }
            System.out.println("Would you like to continue ordering? (Y/N)");
            placeOrder = input.nextLine();
            if(!placeOrder.equalsIgnoreCase("y")) {
                ordering = false;
            }


        }
    }
}
