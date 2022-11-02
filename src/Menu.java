import java.awt.*;

public class Menu {

    public static void main(String[] args) {

        // possible solution to food item?
        FoodItem pizza = new FoodItem('M', "Pizzas", "pizza, dish of Italian origin consisting of a flattened disk of bread dough topped with some combination", 20.0);
        FoodItem burger = new FoodItem('M', "MickDouble", "6oz meat patty between two brioche buns with cheese, lettuce and onions ", 13.0);
        FoodItem MickFlurry = new FoodItem('D', "MickFlurry", "soft serve Mick's vanilla-flavored ice cream in a cup.", 3.0);


        System.out.println("Cost of pizza = " + pizza.getPrice());
        System.out.println("Cost of a MickDouble = " + burger.getPrice());


    }




}
