package RestaurantSystem;

import Person.Owner;
import Person.Staff;

import java.util.ArrayList;

public class Restaurant {

    // data fields
    private String location;
    private ArrayList<Staff> employees;
    private ArrayList<Table> tables;
    private Owner owner;
    private Menu menu;


    public Restaurant(String location,Owner owner,Menu menu){
      this.location=location;
       employees=new ArrayList<>();
       tables=new ArrayList<>();
       this.owner=owner;
     this.menu=menu;}


    //add employee
    public void addEmployee(Staff emp){
    employees.add(emp);}
    //remove employee
    public void removeEmployee(Staff emp){
    employees.remove(emp);}
    //add table
    public void addTable(Table table){
        tables.add(table);}
    //remove table
    public void removeTable(Table table){
        tables.remove(table);}






}
