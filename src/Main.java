import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.println("hello");
        ArrayList<Cupcake> cupcakeMenu = new ArrayList <>();
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        addPrice("cupcake", cupcake);
        addPrice("redvelvet", redVelvet);
        addPrice("chocolate", chocolate);

        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

        System.out.println(cupcakeMenu);
    }

    public static void addPrice(String cake, Cupcake obj){
        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu, but we need to decide on pricing.");
        Scanner input = new Scanner(System.in);
        System.out.println("We are deciding on the price for our standard " + cake + ". Here is the description:");
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();
        obj.type();

        System.out.println("How much would you like to charge for the " + cake +"? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();

        double price = Double.parseDouble(priceText);
        obj.setPrice(price);
    }
}


class Cupcake {
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

class RedVelvet extends Cupcake{
    public  void type(){

        System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}

class Chocolate extends Cupcake{
    public  void type(){

        System.out.println("A chocolate based cupcake, with chocolate frosting.");
    }
};
