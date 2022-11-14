public class TestTable{

        public static void main(String args[]){
                Table table1=new Table("A");
                Table table2=new Table("B");
                Table table3 = new Table("C");
                Table table4=new Table("D");

                table1.addMeal(new Meal(1, "Pizza") );
                table1.addMeal(new Meal(1, "Beef"));
                table1.setTips(10);

                table2.addMeal( new Meal(0, "Soup") );
                table2.addMeal( new Meal(0, "Briege") );
                table2.addMeal( new Meal(0, "Volivant", "nuts"));
                table2.setTips(20);
                table2.removeMeal( new Meal("Briege") );

                table3.addMeal( new Meal("Guiness" ));

                table4.addMeal( new Meal("Tea") );
                table4.addMeal( new Meal("Toast") );
                table4.cancelOrder();

                System.out.println( table1.toString() );
                System.out.println( table2.toString() );
                System.out.println( table3.toString() );
                System.out.println( table4.toString() );
        }
}