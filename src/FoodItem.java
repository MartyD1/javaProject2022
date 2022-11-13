public class FoodItem {

    private final static char main = 'M';
    private final static char starter = 'S';
    private final static char dessert = 'D';
    private final static char beverage='B';

    private char type;
    private String name;
    private String description;
    private double price;


    public FoodItem(char type, String name, String description, double price){

        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    /*      Getters       */

    public char getType(){
        return type;
    }

    public String getDescription(){
        return description;
    }

    public String getName() {
        return name;
    }

    public double getPrice(){
        return price;
    }

    /*      Setters       */

    public void setType(char type){
        this.type = type;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    //override toString method
    @Override
    public String toString() {
        return String.format("\n%s: %s\n%s: %s\n%s: %s\n%s: %.2f\n\n", "Type", getType(),
                "Name", getName(), "Description", getDescription(), "Price", getPrice());
    }


}
