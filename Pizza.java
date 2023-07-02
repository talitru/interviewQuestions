package il.co.ilrd.InterviewQuestions;

class Main{
    public static void main(String[] args){
        Pizza myPizza = new PeppyPaneer();
        System.out.println("The price of " + myPizza.getDescription() + " is " + myPizza.getPrice());

        myPizza = new Jalapeno(myPizza);
        System.out.println("The price of " + myPizza.getDescription() + " is " + myPizza.getPrice());

        myPizza = new Jalapeno(myPizza);
        System.out.println("The price of " + myPizza.getDescription() + " is " + myPizza.getPrice());

        myPizza = new BBQ(myPizza);
        System.out.println("The price of " + myPizza.getDescription() + " is " + myPizza.getPrice());

    }
}
public abstract class Pizza {
    public abstract String getDescription();
    public abstract int getPrice();

}

abstract class PizzaDecorator extends Pizza{
    protected Pizza pizza;

    protected PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }
    @Override
    public abstract String getDescription();
    @Override
    public abstract int getPrice();
}

class FreshTomato extends PizzaDecorator{
    private int price = 1;

    private FreshTomato(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription() + " with FreshTomato";
    }
    @Override
    public int getPrice(){
        return pizza.getPrice() + price;
    }
}

class Paneer extends PizzaDecorator{
    private int price = 2;
    protected Paneer(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription() + " with Paneer";
    }
    @Override
    public int getPrice(){
        return pizza.getPrice() + price;
    }
}

class Jalapeno extends PizzaDecorator{
    private int price = 4;
    protected Jalapeno(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription(){
        return pizza.getDescription() + " with Jalapeno";
    }
    @Override
    public int getPrice(){
        return pizza.getPrice() +price;
    }
}

class Capsicum extends PizzaDecorator{
    private int price = 3;
    protected Capsicum(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription(){
        return pizza.getDescription() + " with Capsicum";
    }
    @Override
    public int getPrice(){
        return pizza.getPrice() + price;
    }
}
class BBQ extends PizzaDecorator{
    private int price = 5;
    protected BBQ(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription() + " with BBQ";
    }
    @Override
    public int getPrice(){
        return pizza.getPrice() + price;
    }
}

class PeppyPaneer extends Pizza{
    private int price = 10;

    @Override
    public String getDescription() {
        return "PeppyPaneer pizza";
    }

    @Override
    public int getPrice() {
        return price;
    }
}

class Farmhouse extends Pizza{
    private int price = 11;
    @Override
    public String getDescription() {
        return "Farmhouse pizza";
    }

    @Override
    public int getPrice() {
        return price;
    }
}

class Margherita extends Pizza{
    private int price = 12;
    @Override
    public String getDescription() {
        return "Margherita pizza";
    }

    @Override
    public int getPrice() {
        return price;
    }
}


class ChickenFiesta extends Pizza{
    private int price = 13;

    @Override
    public String getDescription() {
        return "ChickenFiesta pizza";
    }

    @Override
    public int getPrice() {
        return price;
    }
}