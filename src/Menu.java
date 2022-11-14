import java.util.ArrayList;

public class Menu {

    static ArrayList<FoodItem> Menuitems = new ArrayList<>();

    // add item to menu
    public static void add(FoodItem item) {
        Menuitems.add(item);
    }

    // remove item from menu
    public static void remove(FoodItem item) {
        Menuitems.remove(item);
    }


    public static void main(String[] args) {
        //Starters
        // (0)garlic bread
        FoodItem garlicBread = new FoodItem('S', "Garlic Bread", "3 slices Garlic Bread", 4.00);
        add(garlicBread);
        //(1)mozzarella sticks
        FoodItem mozzarellaSticks = new FoodItem('S', "Mozzarella Sticks", "Six mozzarella sticks", 3.00);
        add( mozzarellaSticks);
        //(2)spicy chicken wings
        FoodItem spicyChickenWings = new FoodItem('S', "Spicy Chicken Wings", "Four chicken wings covered in Yum's spicy sauce", 5.50);
        add(spicyChickenWings);
        //(3)BBQ chicken wings
        FoodItem bbqChickenWings = new FoodItem('S', "BBQ Chicken Wings", "Four chicken wings covered in Yum's BBQ sauce", 6.00);
        add(bbqChickenWings);
        //(4) onion rings
        FoodItem onionRings= new FoodItem('S',"Onion Rings","Eight onion rings",6.00);
        add(onionRings);

        //Mains
        //(5) burger and chips
        FoodItem burgerAndChips=new FoodItem('M',"Burger and Chips","Burger with cheese,lettuce and onions with a side of chips ",13.00);
        add(burgerAndChips);
        //(6)pasta carbonara
        FoodItem pastaCarbonara=new FoodItem('M',"Pasta Carbonara","Pasta with bacon bits and a carbonara sauce",12.00);
        add(pastaCarbonara);
        //(7) roast beef
        FoodItem roastBeef= new FoodItem('M',"Roast Beef Dinner","Roast beef with mashed potatoes,broccoli,carrots and gravy",16.00);
        add(roastBeef);
        //(8) fish and chips
        FoodItem fishAndChips= new FoodItem('M',"Fish And Chips","One piece of cod with a side of chips",10.00);
        add(fishAndChips);
        //(9)pizza
        FoodItem pizza=new FoodItem('M',"Pizza","Ham And Cheese Pizza",9.00);
        add(pizza);

        //Desserts
        //(10) ice cream and jelly
        FoodItem jellyAndIcecream= new FoodItem('D',"Jelly And Ice-cream","Two scoops of ice-cream with jelly",2.50);
        add(jellyAndIcecream);
        //(11) chocolate brownie
        FoodItem chocBrownie= new FoodItem('D',"Chocolate Brownie","Warm chocolate brownie with a scoop of icecream",5.50);
        add(chocBrownie);
        //(12)apple tart
        FoodItem appleTart= new FoodItem('D',"Apple Tart","Slice of apple tart with fresh cream",4.00);
        add(appleTart);
        //(13)lemon cheesecake
        FoodItem lemonCheesecake= new FoodItem('D',"Lemon Cheesecake","Slice of lemon cheesecake",5.00);
        add(lemonCheesecake);
        //(14)banoffee pie
        FoodItem banoffeePie= new FoodItem('D',"Banoffee Pie","Slice of Banoffe pie",3.50);
        add(banoffeePie);

        //beverages
        //(15) coca cola
        FoodItem cocaCola= new FoodItem('B',"Coca-Cola","Glass of coca-cola",1.50);
        add(cocaCola);
        //(16) Hot Chocolate
        FoodItem hotChocolate=new FoodItem('B',"Hot Chocolate","Hot chocolate with marshmallows and cream",3.00);
        add(hotChocolate);
        //(17) Milkshake
        FoodItem milkShake=new FoodItem('B',"Milkshake","Vanilla milkshake",3.50);
        add(milkShake);
        //(18) Guinness
        FoodItem guinness= new FoodItem('B',"Guinness","Pint of Guinness",5.00);
        add(guinness);
        //(19) Heineken
        FoodItem heineken= new FoodItem('B',"Heineken","Pint of Heineken",5.00);
        add(heineken);
    }
}


