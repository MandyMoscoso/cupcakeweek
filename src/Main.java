import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        ArrayList<Cupcake> cupcakeMenu = new ArrayList <Cupcake>();
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        addPrice("cupcake","cupcake", cupcake);
        addPrice("cupcake","redvelvet", redVelvet);
        addPrice("cupcake","chocolate", chocolate);
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);
//        System.out.println(cupcakeMenu);

        ArrayList<Drink> drinkMenu = new ArrayList <Drink>();
        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();
        addPrice("drink", "water", water);
        addPrice("drink", "soda", soda);
        addPrice("drink", "milk", milk);
        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);
//        System.out.println(drinkMenu);




    }
    public static void addPrice(String type,String cake, Consumables obj){
        System.out.println("We are in the middle of creating the "+type +" menu. We currently have three " + type + " on the menu, but we need to decide on pricing.");
        Scanner input = new Scanner(System.in);
        System.out.println("We are deciding on the price for our " + cake + ". Here is the description:");
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



class Consumables {
    public double price;
    public double getPrice() {
        return price;
    }
    public  void setPrice(double value) {
        this.price = value;
    }
    public  void type(){
        System.out.println("A consumables");
    }
    @Override
    public String toString() {
        return Double.toString(price);
    }
}

class Cupcake extends Consumables{
    @Override
    public void type() {
        System.out.println("A basic, generic cupcake, with vanilla frosting");
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
}

class Drink extends Consumables{
    @Override
    public void type() {
        System.out.println("A bottle of water");
    }
}

class Soda extends Drink {
    public void type()
    {
        System.out.println("A bottle of soda.");
    }
}

class Milk extends Drink {
    public void type()
    {
        System.out.println("A bottle of milk.");
    }
}