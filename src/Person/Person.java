package Person;

/**
 * superclass to construct a person
 */
public class Person{
    //private data field name of type string
    private String name;


    /**
     * person constructor
     * @param name- name of person
     */
    public Person(String name){
        this.name = name;
    }


    /**
     * @param name-name of person
     */
    public void setName(String name){
        this.name=name;
    }


    /**
     * @return name-name of person
     */
    public String getName(){
        return name;
    }


    /**
     * @return String format for person
     */
    @Override
    public String toString() {
        return String.format("Name: %s", getName());
    }
}