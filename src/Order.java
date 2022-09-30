import java.io.*;
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

        System.out.println(order.get(0));
        System.out.println(order.get(1));

        double subTotal = 0.0;

        for (int i = 2; i < order.size() ; i++) {
            if(cupcakeMenu.contains(order.get(i))){
                int index = cupcakeMenu.indexOf(order.get(i));
                cupcakeMenu.get(index).type();
                subTotal += cupcakeMenu.get(index).getPrice();
            } else if(drinkMenu.contains(order.get(i))){
                int index = drinkMenu.indexOf(order.get(i));
                drinkMenu.get(index).type();
                subTotal += drinkMenu.get(index).getPrice();
            }
        }
        System.out.println("$" + subTotal + "\n");
        new CreateFile();
        new WriteToFile(order);
    }
}

class CreateFile {
    public CreateFile() {
        try {
            File salesData = new File("salesData.txt");
            if(salesData.createNewFile()){
                System.out.println("File created: " + salesData.getName());
            } else{
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
}

class WriteToFile {
    public WriteToFile(ArrayList<Object> order) {
        try {
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);
            for (int i = 0; i <order.size() ; i++) {
                salesWriter.println(order.get(i));
            }
            salesWriter.close();
            System.out.println("Successfully wrote to the file");

        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
}