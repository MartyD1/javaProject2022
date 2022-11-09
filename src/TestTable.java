public class TestTable{
        // I still need to implement Starter, Main Course, Dessert
        public static void main(String args[]){
                Table table1=new Table("A");
                Table table2=new Table("B");
                Table table3 = new Table("C");
                Table table4=new Table("D");

                table1.addMeal(new Meal(1, "Pizza", 10, "Cheese Pizza") );
                table1.addMeal(new Meal(1, "Beef", 15, "Potatoes, carrots, beef, gravy"));
                table1.setTips(10);

                table2.addMeal( new Meal(0, "Soup", 4, "Veg", "Chicken") );
                table2.addMeal( new Meal(0, "briege", 5, "breaded roast cheese") );
                table2.addMeal( new Meal(0, "Volivant", 5, "Chicken volivant and sauce", "nuts"));
                table2.setTips(20);
                table2.removeMeal( new Meal("briege", 5, "breaded roast cheese") );

                table3.addMeal( new Meal("Guiness", 5, "Point of guinness" ));

                table4.addMeal( new Meal("Tea", 1, "Tea") );
                table4.addMeal( new Meal("Toast", 1, "Toast") );
                table4.cancelOrder();

                System.out.println( table1.toString() );
                System.out.println( table2.toString() );
                System.out.println( table3.toString() );
                System.out.println( table4.toString() );
        }
}