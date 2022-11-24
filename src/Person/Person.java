package Person;
//public class person superclass for person classes
public class Person{
    //private data field name of type string
    private String name;

    //person constructor
    public Person(String name){
        this.name = name;
    }

    //set name method
    public void setName(String name){
        this.name=name;
    }

    //get name method
    public String getName(){
        return name;
    }

//toString method for person
    @Override
    public String toString() {
        return String.format("Name: %s", getName());
    }
}