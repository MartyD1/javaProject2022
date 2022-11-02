public class FoodItem {

    private final static char main = 'M';
    private final static char starter = 'S';
    private final static char dessert = 'D';

    private char type;
    private String name;
    private double price;
    private byte state;


    public FoodItem(char type, String name, double price, byte state){

        this.type = type;
        this.name = name;
        this.price = price;
        this.state = 0;

    }


    /*      Getters       */

    public char getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice(){
        return price;
    }

    public byte getState(){
        return state;
    }


    /*      Setters       */

    public void setType(char type){
        this.type = type;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setState(byte state) {
        this.state = state;
    }


}
