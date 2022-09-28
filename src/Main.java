import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class Cupcake {
        public double price;

        public double getPrice() {
            return price;
        }

        public  void setPrice(double value) {
            this.price = value;
        }

        public  void type(){
            System.out.println("A basic, generic cupcake, with vanilla frosting");
        }

        @Override
        public String toString() {
            return Double.toString(price);
        }
    }

    public static class RedVelvet extends Cupcake{
        public  void type(){

            System.out.println("A red velvet based cupcake, with cream cheese frosting.");
        }
    }

    public static class Chocolate extends Cupcake{
        public  void type(){

            System.out.println("A chocolate based cupcake, with chocolate frosting.");
        }
    }


    public static void main (String[] args) {

        ArrayList<Cupcake> cupcakeMenu = new ArrayList <>();
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu, but we need to decide on pricing.");
        Scanner input = new Scanner(System.in);
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);


        System.out.println("We are deciding on the price for our red velvet. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the red velvet? (Input a numerical number taken to 2 decimal places)");
         priceText = input.nextLine();
         price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);

        System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description:");
        chocolate.type();
        System.out.println("How much would you like to charge for the chocolate cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

        System.out.println(cupcakeMenu);

    }
}
