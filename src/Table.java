public class Table{
    //private boolean tablePaid=false;
    //private boolean tableCancelled=false;
    private double tips;
    private String tableName;

    private Order order;

    public Table(String bookingName){
        this.tableName=bookingName;

        order=new Order();

    }//booking a table in advance is to do with schedule not table class

    public void setTips(double tips){
        this.tips=tips;
    }

    public void addMeal(Meal m){
        order.addDinner(m);
    }

    public void removeMeal(Meal m){
        order.removeDinner(m);
    }

    public void cancelOrder(){
        order.cancelDinners();
    }

    public double tableBill(){
        return order.orderPrice();
    }

    // public void changeTableMeal(int mealNum){ //Purpose?
    // order.changeStatus(mealNum);
    // }

    // public void nextMealNum(){
    // order.nextMealNum();


    public String toString(){
        String str="";
        str+="-  Table Name: "+tableName+", Final Bill: "+tableBill()+
                ", Tips: "+tips;
        str+="\nOrder:\n\n"+order.toString();
        return str;
    }

}
